package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class LoginRequestBody {
    var email: String = ""
    var password: String = ""
}