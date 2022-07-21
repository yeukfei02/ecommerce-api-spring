package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.entity.UserEntity
import com.donaldwu.ecommerceapispring.requestBody.LoginRequestBody
import com.donaldwu.ecommerceapispring.requestBody.SignupRequestBody
import com.donaldwu.ecommerceapispring.responseBody.GetUserByIdResponseBody
import com.donaldwu.ecommerceapispring.responseBody.GetUsersResponseBody
import com.donaldwu.ecommerceapispring.responseBody.LoginResponseBody
import com.donaldwu.ecommerceapispring.responseBody.SignupResponseBody
import com.donaldwu.ecommerceapispring.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class UserController(private val userService: UserService) {
    @RequestMapping(value = ["/users/signup"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun signup(@RequestBody signupRequestBody: SignupRequestBody): SignupResponseBody {
        if (signupRequestBody.email.isNotEmpty() && signupRequestBody.password.isNotEmpty()) {
            userService.signup(signupRequestBody.email, signupRequestBody.password)
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
            if (user.password == loginRequestBody.password) {
                loginResponseBody.message = "login success"
                loginResponseBody.token = ""
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
}