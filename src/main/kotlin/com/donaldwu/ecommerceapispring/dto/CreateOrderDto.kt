package com.donaldwu.ecommerceapispring.dto

import lombok.Data

@Data
class CreateOrderDto {
    var order_detail: String = ""
    var shop_id: Long = 0
    var user_id: Long = 0
}
