package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class CreateShopRequestBody {
    var name: String = ""
    var address: String = ""
}