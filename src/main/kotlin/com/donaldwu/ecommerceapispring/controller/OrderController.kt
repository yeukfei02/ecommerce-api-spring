package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.service.OrderService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class OrderController(private val orderService: OrderService) {
}