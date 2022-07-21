package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.BookEntity
import lombok.Data

@Data
class GetBooksResponseBody {
    var message: String = ""
    var books: MutableIterable<BookEntity> = mutableListOf()
}