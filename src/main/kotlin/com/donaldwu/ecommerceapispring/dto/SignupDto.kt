package com.donaldwu.ecommerceapispring.dto

import lombok.Data

@Data
class SignupDto {
    var email: String = ""
    var password: String = ""
}
