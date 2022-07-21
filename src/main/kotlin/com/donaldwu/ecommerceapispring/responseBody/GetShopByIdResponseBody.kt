package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.ShopEntity
import lombok.Data
import java.util.*

@Data
class GetShopByIdResponseBody {
    var message: String = ""
    var shop: ShopEntity? = null
}