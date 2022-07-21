package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.entity.UserEntity
import com.donaldwu.ecommerceapispring.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun signup(email: String, password: String) {
        val userEntity = UserEntity()
        userEntity.email = email
        userEntity.password = password
        userRepository.save(userEntity)
    }

    fun getUsers(): MutableList<UserEntity> {
        return userRepository.findAll()
    }

    fun getUserById(id: Int): Optional<UserEntity> {
        return userRepository.findById(id)
    }

    fun getUserByEmail(email: String): UserEntity {
        return userRepository.findByEmail(email)
    }
}