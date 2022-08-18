package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.model.Book
import com.donaldwu.ecommerceapispring.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookRepository: BookRepository) {
    fun createBook(book: Book, name: String, author: String, price: Double, quantity: Int, shop_id: Long, user_id: Long) {
        book.name = name
        book.author = author
        book.price = price
        book.quantity = quantity
        book.shop_id = shop_id
        book.user_id = user_id
        bookRepository.save(book)
    }

    fun getBooks(): MutableIterable<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Optional<Book> {
        return bookRepository.findById(id)
    }

    fun updateBookById(book: Book, name: String, author: String, price: Double, quantity: Int, shop_id: Long, user_id: Long) {
        book.name = name
        book.author = author
        book.price = price
        book.quantity = quantity
        if (shop_id > 0) {
            book.shop_id = shop_id
        }
        if (user_id > 0) {
            book.user_id = user_id
        }
        bookRepository.save(book)
    }

    fun deleteBookById(id: Long) {
        bookRepository.deleteById(id)
    }
}
