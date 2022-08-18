package com.donaldwu.ecommerceapispring.dto

import lombok.Data

@Data
class UpdateBookByIdDto {
    var name: String = ""
    var author: String = ""
    var price: Double = 0.0
    var quantity: Int = 0
    var shop_id: Long = 0
    var user_id: Long = 0
}
