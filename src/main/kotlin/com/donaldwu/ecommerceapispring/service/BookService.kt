package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.entity.BookEntity
import com.donaldwu.ecommerceapispring.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookRepository: BookRepository) {
    fun createBook(bookEntity: BookEntity, name: String, author: String, price: Double, quantity: Int, shop_id: Long, user_id: Long) {
        bookEntity.name = name
        bookEntity.author = author
        bookEntity.price = price
        bookEntity.quantity = quantity
        bookEntity.shop_id = shop_id
        bookEntity.user_id = user_id
        bookRepository.save(bookEntity)
    }

    fun getBooks(): MutableIterable<BookEntity> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Optional<BookEntity> {
        return bookRepository.findById(id)
    }

    fun updateBookById(bookEntity: BookEntity, name: String, author: String, price: Double, quantity: Int, shop_id: Long, user_id: Long) {
        bookEntity.name = name
        bookEntity.author = author
        bookEntity.price = price
        bookEntity.quantity = quantity
        if (shop_id > 0) {
            bookEntity.shop_id = shop_id
        }
        if (user_id > 0) {
            bookEntity.user_id = user_id
        }
        bookRepository.save(bookEntity)
    }

    fun deleteBookById(id: Long) {
        bookRepository.deleteById(id)
    }
}