package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.responseBody.GetMainResponseBody
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping("/")
class MainController {
    @RequestMapping(value = [""], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getMain(): GetMainResponseBody {
        val getMainResponseBody = GetMainResponseBody()
        getMainResponseBody.message = "ecommerce-api-spring"

        return getMainResponseBody
    }
}
