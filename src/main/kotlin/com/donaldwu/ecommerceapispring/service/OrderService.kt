package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.model.Order
import com.donaldwu.ecommerceapispring.repository.OrderRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(private val orderRepository: OrderRepository) {
    fun createOrder(order: Order, orderDetail: String, shop_id: Long, user_id: Long) {
        order.order_detail = orderDetail
        order.shop_id = shop_id
        order.user_id = user_id
        orderRepository.save(order)
    }

    fun getOrders(): MutableIterable<Order> {
        return orderRepository.findAll()
    }

    fun getOrderById(id: Long): Optional<Order> {
        return orderRepository.findById(id)
    }
}
