package com.donaldwu.ecommerceapispring.dto

import lombok.Data

@Data
class LoginDto {
    var email: String = ""
    var password: String = ""
}
