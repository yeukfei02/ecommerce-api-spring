package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity
}