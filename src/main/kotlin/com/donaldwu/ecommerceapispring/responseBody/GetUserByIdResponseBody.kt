package com.donaldwu.ecommerceapispring.responseBody

import com.donaldwu.ecommerceapispring.entity.UserEntity
import lombok.Data

@Data
class GetUserByIdResponseBody {
    var message: String = ""
    var user: UserEntity? = null
}