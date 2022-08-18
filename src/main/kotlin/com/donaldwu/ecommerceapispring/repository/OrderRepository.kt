package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>
