package com.donaldwu.ecommerceapispring.responseBody

import lombok.Data

@Data
class LoginResponseBody {
    var message: String = ""
    var token = ""
}