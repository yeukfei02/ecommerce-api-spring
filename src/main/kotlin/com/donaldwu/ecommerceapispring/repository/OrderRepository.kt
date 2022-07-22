package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.entity.OrderEntity
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderEntity, Long>
