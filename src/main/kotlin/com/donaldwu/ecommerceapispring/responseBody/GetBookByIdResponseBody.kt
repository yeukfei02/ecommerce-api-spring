package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.BookEntity
import lombok.Data

@Data
class GetBookByIdResponseBody {
    var message: String = ""
    var book: BookEntity? = null
}