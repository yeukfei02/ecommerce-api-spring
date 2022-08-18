package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.dto.ChangePasswordDto
import com.donaldwu.ecommerceapispring.dto.LoginDto
import com.donaldwu.ecommerceapispring.dto.SignupDto
import com.donaldwu.ecommerceapispring.helper.Helper
import com.donaldwu.ecommerceapispring.model.User
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.UserService
import com.toxicbakery.bcrypt.Bcrypt
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value = ["/api"])
class UserController(private val userService: UserService) {
    @RequestMapping(value = ["/users/signup"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun signup(@RequestBody signupDto: SignupDto, user: User): SignupResponseBody {
        if (signupDto.email.isNotEmpty() && signupDto.password.isNotEmpty()) {
            val hashPassword = Bcrypt.hash(signupDto.password, 10)
            val hashPasswordStr = String(hashPassword)
            userService.signup(user, signupDto.email, hashPasswordStr)
        }

        val signupResponseBody = SignupResponseBody()
        signupResponseBody.message = "signup"

        return signupResponseBody
    }

    @RequestMapping(value = ["/users/login"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun login(@RequestBody loginDto: LoginDto): LoginResponseBody {
        val loginResponseBody = LoginResponseBody()

        if (loginDto.email.isNotEmpty() && loginDto.password.isNotEmpty()) {
            val user = userService.getUserByEmail(loginDto.email)
            val isPasswordValid = Bcrypt.verify(loginDto.password, user.password.toByteArray())
            if (isPasswordValid) {
                loginResponseBody.message = "login success"

                val token = Helper.getJwtToken(user.id, user.email)
                loginResponseBody.token = token
            } else {
                loginResponseBody.message = "login fail, wrong password"
            }
        }

        return loginResponseBody
    }

    @RequestMapping(value = ["/users"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getUsers(): GetUsersResponseBody {
        val users = userService.getUsers()

        val getUsersResponseBody = GetUsersResponseBody()
        getUsersResponseBody.message = "getUsers"
        getUsersResponseBody.users = users

        return getUsersResponseBody
    }

    @RequestMapping(value = ["/users/{id}"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getUserById(@PathVariable("id") id: Long): GetUserByIdResponseBody {
        val user = userService.getUserById(id)

        var userResult: User? = null
        if (user.isPresent) {
            userResult = user.get()
        }

        val getUserByIdResponseBody = GetUserByIdResponseBody()
        getUserByIdResponseBody.message = "getUserById"
        getUserByIdResponseBody.user = userResult

        return getUserByIdResponseBody
    }

    @RequestMapping(value = ["/users/change-password/{id}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun changePassword(@PathVariable("id") id: Long, @RequestBody changePasswordDto: ChangePasswordDto): ChangePasswordResponseBody {
        val changePasswordResponseBody = ChangePasswordResponseBody()

        val userEntity = userService.getUserById(id)
        if (userEntity.isPresent) {
            val user = userEntity.get()
            if (changePasswordDto.old_password.isNotEmpty() && changePasswordDto.new_password.isNotEmpty()) {
                val isPasswordValid = Bcrypt.verify(changePasswordDto.old_password, user.password.toByteArray())
                if (isPasswordValid) {
                    val hashPassword = Bcrypt.hash(changePasswordDto.new_password, 10)
                    val hashPasswordStr = String(hashPassword)

                    userService.changePassword(user, hashPasswordStr)
                    changePasswordResponseBody.message = "changePassword success"
                } else {
                    changePasswordResponseBody.message = "changePassword error, wrong old password"
                }
            }
        }

        return changePasswordResponseBody
    }
}
