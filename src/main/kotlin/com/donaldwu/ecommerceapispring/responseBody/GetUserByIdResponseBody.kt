package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.User
import lombok.Data

@Data
class GetUserByIdResponseBody {
    var message: String = ""
    var user: User? = null
}
