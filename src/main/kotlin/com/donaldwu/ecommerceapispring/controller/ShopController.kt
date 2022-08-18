package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.dto.CreateShopDto
import com.donaldwu.ecommerceapispring.dto.UpdateShopByIdDto
import com.donaldwu.ecommerceapispring.model.Shop
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.ShopService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value = ["/api"])
class ShopController(private val shopService: ShopService) {
    @RequestMapping(value = ["/shops"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createShop(@RequestBody createShopDto: CreateShopDto, shop: Shop): CreateShopResponseBody {
        if (createShopDto.name.isNotEmpty() && createShopDto.address.isNotEmpty()) {
            shopService.createShop(shop, createShopDto.name, createShopDto.address)
        }

        val createShopResponseBody = CreateShopResponseBody()
        createShopResponseBody.message = "createShop"

        return createShopResponseBody
    }

    @RequestMapping(value = ["/shops"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getShops(): GetShopsResponseBody {
        val shops = shopService.getShops()

        val getShopsResponseBody = GetShopsResponseBody()
        getShopsResponseBody.message = "getShops"
        getShopsResponseBody.shops = shops

        return getShopsResponseBody
    }

    @RequestMapping(value = ["/shops/{id}"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getShopById(@PathVariable("id") id: Long): GetShopByIdResponseBody {
        val shop = shopService.getShopById(id)

        var shopResult: Shop? = null
        if (shop.isPresent) {
            shopResult = shop.get()
        }

        val getShopByIdResponseBody = GetShopByIdResponseBody()
        getShopByIdResponseBody.message = "getShopById"
        getShopByIdResponseBody.shop = shopResult

        return getShopByIdResponseBody
    }

    @RequestMapping(value = ["/shops/{id}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun updateShopById(@PathVariable("id") id: Long, @RequestBody updateShopByIdDto: UpdateShopByIdDto): UpdateShopByIdResponseBody {
        val updateShopByIdResponseBody = UpdateShopByIdResponseBody()

        val shopEntity = shopService.getShopById(id)
        if (shopEntity.isPresent) {
            val shop = shopEntity.get()
            if (updateShopByIdDto.name.isNotEmpty() && updateShopByIdDto.address.isNotEmpty()) {
                shopService.updateShopById(shop, updateShopByIdDto.name, updateShopByIdDto.address)
                updateShopByIdResponseBody.message = "updateShopById success"
            }
        }

        return updateShopByIdResponseBody
    }

    @RequestMapping(value = ["/shops/{id}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun deleteShopById(@PathVariable("id") id: Long): DeleteShopByIdResponseBody {
        if (id > 0) {
            shopService.deleteShopById(id)
        }

        val deleteShopByIdResponseBody = DeleteShopByIdResponseBody()
        deleteShopByIdResponseBody.message = "deleteShopById"

        return deleteShopByIdResponseBody
    }
}
