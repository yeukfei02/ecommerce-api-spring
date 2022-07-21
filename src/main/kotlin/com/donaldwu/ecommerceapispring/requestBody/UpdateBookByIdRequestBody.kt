package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class UpdateBookByIdRequestBody {
    var name: String = ""
    var author: String = ""
    var price: Double = 0.0
    var quantity: Int = 0
    var shop_id: Long = 0
    var user_id: Long = 0
}