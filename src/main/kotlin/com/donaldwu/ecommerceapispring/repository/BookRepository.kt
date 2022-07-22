package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.entity.BookEntity
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookEntity, Long>
