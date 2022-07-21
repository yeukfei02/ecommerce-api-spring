package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.entity.UserEntity
import com.donaldwu.ecommerceapispring.helper.Helper
import com.donaldwu.ecommerceapispring.requestBody.ChangePasswordRequestBody
import com.donaldwu.ecommerceapispring.requestBody.LoginRequestBody
import com.donaldwu.ecommerceapispring.requestBody.SignupRequestBody
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.UserService
import com.toxicbakery.bcrypt.Bcrypt
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class UserController(private val userService: UserService) {
    @RequestMapping(value = ["/users/signup"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun signup(@RequestBody signupRequestBody: SignupRequestBody, userEntity: UserEntity): SignupResponseBody {
        if (signupRequestBody.email.isNotEmpty() && signupRequestBody.password.isNotEmpty()) {
            val hashPassword = Bcrypt.hash(signupRequestBody.password, 10)
            val hashPasswordStr = String(hashPassword)
            userService.signup(userEntity, signupRequestBody.email, hashPasswordStr)
        }

        val signupResponseBody = SignupResponseBody()
        signupResponseBody.message = "signup"

        return signupResponseBody
    }

    @RequestMapping(value = ["/users/login"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun login(@RequestBody loginRequestBody: LoginRequestBody): LoginResponseBody {
        val loginResponseBody = LoginResponseBody()

        if (loginRequestBody.email.isNotEmpty() && loginRequestBody.password.isNotEmpty()) {
            val user = userService.getUserByEmail(loginRequestBody.email)
            val isPasswordValid = Bcrypt.verify(loginRequestBody.password, user.password.toByteArray())
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
    fun getUserById(@PathVariable("id") id: Int): GetUserByIdResponseBody {
        val user = userService.getUserById(id)

        var userResult: UserEntity? = null
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
    fun changePassword(@PathVariable("id") id: Int, @RequestBody changePasswordRequestBody: ChangePasswordRequestBody): ChangePasswordResponseBody {
        val changePasswordResponseBody = ChangePasswordResponseBody()

        val userEntity = userService.getUserById(id)
        if (userEntity.isPresent) {
            val user = userEntity.get()
            if (changePasswordRequestBody.old_password.isNotEmpty() && changePasswordRequestBody.new_password.isNotEmpty()) {
                val isPasswordValid = Bcrypt.verify(changePasswordRequestBody.old_password, user.password.toByteArray())
                if (isPasswordValid) {
                    val hashPassword = Bcrypt.hash(changePasswordRequestBody.new_password, 10)
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