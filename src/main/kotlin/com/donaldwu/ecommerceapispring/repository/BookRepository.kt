package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long>
