package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.entity.ShopEntity
import com.donaldwu.ecommerceapispring.repository.ShopRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShopService(private val shopRepository: ShopRepository) {
    fun createShop(shopEntity: ShopEntity, name: String, address: String) {
        shopEntity.name = name
        shopEntity.address = address
        shopRepository.save(shopEntity)
    }

    fun getShops(): MutableIterable<ShopEntity> {
        return shopRepository.findAll()
    }

    fun getShopById(id: Long): Optional<ShopEntity> {
        return shopRepository.findById(id)
    }

    fun updateShopById(shopEntity: ShopEntity, name: String, address: String) {
        shopEntity.name = name
        shopEntity.address = address
        shopRepository.save(shopEntity)
    }

    fun deleteShopById(id: Long) {
        shopRepository.deleteById(id)
    }
}