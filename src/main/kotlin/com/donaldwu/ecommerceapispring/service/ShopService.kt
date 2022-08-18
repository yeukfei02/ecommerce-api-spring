package com.donaldwu.ecommerceapispring.service

import com.donaldwu.ecommerceapispring.model.Shop
import com.donaldwu.ecommerceapispring.repository.ShopRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShopService(private val shopRepository: ShopRepository) {
    fun createShop(shop: Shop, name: String, address: String) {
        shop.name = name
        shop.address = address
        shopRepository.save(shop)
    }

    fun getShops(): MutableIterable<Shop> {
        return shopRepository.findAll()
    }

    fun getShopById(id: Long): Optional<Shop> {
        return shopRepository.findById(id)
    }

    fun updateShopById(shop: Shop, name: String, address: String) {
        shop.name = name
        shop.address = address
        shopRepository.save(shop)
    }

    fun deleteShopById(id: Long) {
        shopRepository.deleteById(id)
    }
}
