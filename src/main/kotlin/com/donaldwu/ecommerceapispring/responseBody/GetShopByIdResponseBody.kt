package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.Shop
import lombok.Data

@Data
class GetShopByIdResponseBody {
    var message: String = ""
    var shop: Shop? = null
}
