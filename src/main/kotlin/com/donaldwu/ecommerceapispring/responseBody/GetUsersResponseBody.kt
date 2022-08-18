package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.model.User
import lombok.Data

@Data
class GetUsersResponseBody {
    var message: String = ""
    var users: MutableIterable<User> = mutableListOf()
}
