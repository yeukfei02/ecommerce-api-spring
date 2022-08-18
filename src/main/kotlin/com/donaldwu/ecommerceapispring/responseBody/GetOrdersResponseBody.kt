package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Order
import lombok.Data

@Data
class GetOrdersResponseBody {
    var message: String = ""
    var orders: MutableIterable<Order> = mutableListOf()
}
