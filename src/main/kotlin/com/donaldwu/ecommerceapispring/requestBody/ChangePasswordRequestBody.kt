package com.donaldwu.ecommerceapispring.requestBody

import lombok.Data

@Data
class ChangePasswordRequestBody {
    var old_password: String = ""
    var new_password: String = ""
}
