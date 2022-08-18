package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): User
}
