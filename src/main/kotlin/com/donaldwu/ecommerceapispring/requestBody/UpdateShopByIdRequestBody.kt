package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class UpdateShopByIdRequestBody {
    var name: String = ""
    var address: String = ""
}