package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.OrderEntity
import lombok.Data

@Data
class GetOrdersResponseBody {
    var message: String = ""
    var orders: MutableIterable<OrderEntity> = mutableListOf()
}