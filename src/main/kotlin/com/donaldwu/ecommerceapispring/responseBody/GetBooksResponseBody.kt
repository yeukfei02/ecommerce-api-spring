package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Book
import lombok.Data

@Data
class GetBooksResponseBody {
    var message: String = ""
    var books: MutableIterable<Book> = mutableListOf()
}
