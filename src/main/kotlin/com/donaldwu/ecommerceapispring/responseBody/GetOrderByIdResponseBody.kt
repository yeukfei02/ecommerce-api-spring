package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Order
import lombok.Data

@Data
class GetOrderByIdResponseBody {
    var message: String = ""
    var order: Order? = null
}
