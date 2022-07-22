package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.ShopEntity
import lombok.Data

@Data
class GetShopsResponseBody {
    var message: String = ""
    var shops: MutableIterable<ShopEntity> = mutableListOf()
}
