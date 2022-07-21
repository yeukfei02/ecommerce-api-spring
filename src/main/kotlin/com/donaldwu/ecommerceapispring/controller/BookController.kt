package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.entity.BookEntity
import com.donaldwu.ecommerceapispring.requestBody.CreateBookRequestBody
import com.donaldwu.ecommerceapispring.requestBody.UpdateBookByIdRequestBody
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class BookController(private val bookService: BookService) {
    @RequestMapping(value = ["/books"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createBook(@RequestBody createBookRequestBody: CreateBookRequestBody, bookEntity: BookEntity): CreateBookResponseBody {
        if (createBookRequestBody.name.isNotEmpty() &&
            createBookRequestBody.author.isNotEmpty() &&
            createBookRequestBody.price > 0 &&
            createBookRequestBody.quantity > 0 &&
            createBookRequestBody.shop_id > 0 &&
            createBookRequestBody.user_id > 0) {
            bookService.createBook(
                bookEntity,
                createBookRequestBody.name,
                createBookRequestBody.author,
                createBookRequestBody.price,
                createBookRequestBody.quantity,
                createBookRequestBody.shop_id,
                createBookRequestBody.user_id
            )
        }

        val createBookResponseBody = CreateBookResponseBody()
        createBookResponseBody.message = "createBook"

        return createBookResponseBody
    }

    @RequestMapping(value = ["/books"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getBooks(): GetBooksResponseBody {
        val books = bookService.getBooks()

        val getBooksResponseBody = GetBooksResponseBody()
        getBooksResponseBody.message = "getBooks"
        getBooksResponseBody.books = books

        return getBooksResponseBody
    }

    @RequestMapping(value = ["/books/{id}"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getBookById(@PathVariable("id") id: Long): GetBookByIdResponseBody {
        val book = bookService.getBookById(id)

        var bookResult: BookEntity? = null
        if (book.isPresent) {
            bookResult = book.get()
        }

        val getBookByIdResponseBody = GetBookByIdResponseBody()
        getBookByIdResponseBody.message = "getBookById"
        getBookByIdResponseBody.book = bookResult

        return getBookByIdResponseBody
    }

    @RequestMapping(value = ["/books/{id}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun updateBookById(@PathVariable("id") id: Long, @RequestBody updateBookByIdRequestBody: UpdateBookByIdRequestBody): UpdateBookByIdResponseBody {
        val updateBookByIdResponseBody = UpdateBookByIdResponseBody()

        val bookEntity = bookService.getBookById(id)
        if (bookEntity.isPresent) {
            val book = bookEntity.get()
            bookService.updateBookById(
                book,
                updateBookByIdRequestBody.name,
                updateBookByIdRequestBody.author,
                updateBookByIdRequestBody.price,
                updateBookByIdRequestBody.quantity,
                updateBookByIdRequestBody.shop_id,
                updateBookByIdRequestBody.user_id
            )
            updateBookByIdResponseBody.message = "updateBookById success"
        }

        return updateBookByIdResponseBody
    }

    @RequestMapping(value = ["/books/{id}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun deleteBookById(@PathVariable("id") id: Long): DeleteBookByIdResponseBody {
        if (id > 0) {
            bookService.deleteBookById(id)
        }

        val deleteBookByIdResponseBody = DeleteBookByIdResponseBody()
        deleteBookByIdResponseBody.message = "deleteBookById"

        return deleteBookByIdResponseBody
    }
}