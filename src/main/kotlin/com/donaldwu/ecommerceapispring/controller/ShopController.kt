package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.entity.ShopEntity
import com.donaldwu.ecommerceapispring.requestBody.CreateShopRequestBody
import com.donaldwu.ecommerceapispring.requestBody.UpdateShopByIdRequestBody
import com.donaldwu.ecommerceapispring.responseBody.*
import com.donaldwu.ecommerceapispring.service.ShopService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class ShopController(private val shopService: ShopService) {
    @RequestMapping(value = ["/shops"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createShop(@RequestBody createShopRequestBody: CreateShopRequestBody, shopEntity: ShopEntity): CreateShopResponseBody {
        if (createShopRequestBody.name.isNotEmpty() && createShopRequestBody.address.isNotEmpty()) {
            shopService.createShop(shopEntity, createShopRequestBody.name, createShopRequestBody.address)
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

        var shopResult: ShopEntity? = null
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
    fun updateShopById(@PathVariable("id") id: Long, @RequestBody updateShopByIdRequestBody: UpdateShopByIdRequestBody): UpdateShopByIdResponseBody {
        val updateShopByIdResponseBody = UpdateShopByIdResponseBody()

        val shopEntity = shopService.getShopById(id)
        if (shopEntity.isPresent) {
            val shop = shopEntity.get()
            if (updateShopByIdRequestBody.name.isNotEmpty() && updateShopByIdRequestBody.address.isNotEmpty()) {
                shopService.updateShopById(shop, updateShopByIdRequestBody.name, updateShopByIdRequestBody.address)
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