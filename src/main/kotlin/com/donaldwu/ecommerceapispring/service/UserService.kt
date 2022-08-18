package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.model.User
import com.donaldwu.ecommerceapispring.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun signup(user: User, email: String, password: String) {
        user.email = email
        user.password = password
        userRepository.save(user)
    }

    fun getUsers(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
    }

    fun changePassword(user: User, newPassword: String) {
        user.password = newPassword
        userRepository.save(user)
    }
}
