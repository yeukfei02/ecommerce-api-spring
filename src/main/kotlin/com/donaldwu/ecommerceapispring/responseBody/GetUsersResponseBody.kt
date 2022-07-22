package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.UserEntity
import lombok.Data

@Data
class GetUsersResponseBody {
    var message: String = ""
    var users: MutableIterable<UserEntity> = mutableListOf()
}
