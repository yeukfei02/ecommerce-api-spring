package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class CreateOrderRequestBody {
    var order_detail: String = ""
    var shop_id: Long = 0
    var user_id: Long = 0
}
