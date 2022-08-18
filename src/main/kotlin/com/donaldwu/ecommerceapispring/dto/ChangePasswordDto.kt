package com.donaldwu.ecommerceapispring.dto

import lombok.Data

@Data
class ChangePasswordDto {
    var old_password: String = ""
    var new_password: String = ""
}
