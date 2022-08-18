package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Shop
import lombok.Data

@Data
class GetShopsResponseBody {
    var message: String = ""
    var shops: MutableIterable<Shop> = mutableListOf()
}
