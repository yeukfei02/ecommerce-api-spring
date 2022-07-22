package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.OrderEntity
import lombok.Data

@Data
class GetOrderByIdResponseBody {
    var message: String = ""
    var order: OrderEntity? = null
}
