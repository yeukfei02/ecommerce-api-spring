package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Book
import lombok.Data

@Data
class GetBookByIdResponseBody {
    var message: String = ""
    var book: Book? = null
}
