package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.entity.OrderEntity
import com.donaldwu.ecommerceapispring.repository.OrderRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(private val orderRepository: OrderRepository) {
    fun createOrder(orderEntity: OrderEntity, orderDetail: String, shop_id: Long, user_id: Long) {
        orderEntity.order_detail = orderDetail
        orderEntity.shop_id = shop_id
        orderEntity.user_id = user_id
        orderRepository.save(orderEntity)
    }

    fun getOrders(): MutableIterable<OrderEntity> {
        return orderRepository.findAll()
    }

    fun getOrderById(id: Long): Optional<OrderEntity> {
        return orderRepository.findById(id)
    }
}
