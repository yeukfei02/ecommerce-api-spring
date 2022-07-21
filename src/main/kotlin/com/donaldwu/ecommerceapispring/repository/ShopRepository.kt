package com.donaldwu.ecommerceapispring.repository

import com.donaldwu.ecommerceapispring.entity.ShopEntity
import org.springframework.data.repository.CrudRepository

interface ShopRepository: CrudRepository<ShopEntity, Long>