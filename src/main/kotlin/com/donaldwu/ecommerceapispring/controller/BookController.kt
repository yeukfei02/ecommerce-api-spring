package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.dto.CreateBookDto
import com.donaldwu.ecommerceapispring.dto.UpdateBookByIdDto
import com.donaldwu.ecommerceapispring.model.Book
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value = ["/api"])
class BookController(private val bookService: BookService) {
    @RequestMapping(value = ["/books"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createBook(@RequestBody createBookDto: CreateBookDto, book: Book): CreateBookResponseBody {
        if (createBookDto.name.isNotEmpty() &&
            createBookDto.author.isNotEmpty() &&
            createBookDto.price > 0 &&
            createBookDto.quantity > 0 &&
            createBookDto.shop_id > 0 &&
            createBookDto.user_id > 0
        ) {
            bookService.createBook(
                book,
                createBookDto.name,
                createBookDto.author,
                createBookDto.price,
                createBookDto.quantity,
                createBookDto.shop_id,
                createBookDto.user_id
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

        var bookResult: Book? = null
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
    fun updateBookById(@PathVariable("id") id: Long, @RequestBody updateBookByIdDto: UpdateBookByIdDto): UpdateBookByIdResponseBody {
        val updateBookByIdResponseBody = UpdateBookByIdResponseBody()

        val bookEntity = bookService.getBookById(id)
        if (bookEntity.isPresent) {
            val book = bookEntity.get()
            bookService.updateBookById(
                book,
                updateBookByIdDto.name,
                updateBookByIdDto.author,
                updateBookByIdDto.price,
                updateBookByIdDto.quantity,
                updateBookByIdDto.shop_id,
                updateBookByIdDto.user_id
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
