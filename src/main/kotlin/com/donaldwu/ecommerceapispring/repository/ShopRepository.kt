package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.model.Shop
import org.springframework.data.repository.CrudRepository

interface ShopRepository : CrudRepository<Shop, Long>
