package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {
}