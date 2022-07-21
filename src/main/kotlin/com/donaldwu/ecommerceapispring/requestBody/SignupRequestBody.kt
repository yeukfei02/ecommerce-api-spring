package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class SignupRequestBody {
    var email: String = ""
    var password: String = ""
}