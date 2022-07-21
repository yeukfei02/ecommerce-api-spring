package com.donaldwu.ecommerceapispring.controller

import com.donaldwu.ecommerceapispring.entity.OrderEntity
import com.donaldwu.ecommerceapispring.requestBody.CreateOrderRequestBody
import com.donaldwu.ecommerceapispring.responseBody.CreateOrderResponseBody
import com.donaldwu.ecommerceapispring.responseBody.GetOrderByIdResponseBody
import com.donaldwu.ecommerceapispring.responseBody.GetOrdersResponseBody
import com.donaldwu.ecommerceapispring.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping(value= ["/api"])
class OrderController(private val orderService: OrderService) {
    @RequestMapping(value = ["/orders"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createOrder(@RequestBody createOrderRequestBody: CreateOrderRequestBody, orderEntity: OrderEntity): CreateOrderResponseBody {
        if (createOrderRequestBody.order_detail.isNotEmpty() &&
            createOrderRequestBody.shop_id > 0 &&
            createOrderRequestBody.user_id > 0) {
            orderService.createOrder(
                orderEntity,
                createOrderRequestBody.order_detail,
                createOrderRequestBody.shop_id,
                createOrderRequestBody.user_id
            )
        }

        val createOrderResponseBody = CreateOrderResponseBody()
        createOrderResponseBody.message = "createOrder"

        return createOrderResponseBody
    }

    @RequestMapping(value = ["/orders"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getOrders(): GetOrdersResponseBody {
        val orders = orderService.getOrders()

        val getOrdersResponseBody = GetOrdersResponseBody()
        getOrdersResponseBody.message = "getOrders"
        getOrdersResponseBody.orders = orders

        return getOrdersResponseBody
    }

    @RequestMapping(value = ["/orders/{id}"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getOrderById(@PathVariable("id") id: Long): GetOrderByIdResponseBody {
        val order = orderService.getOrderById(id)

        var orderResult: OrderEntity? = null
        if (order.isPresent) {
            orderResult = order.get()
        }

        val getOrderByIdResponseBody = GetOrderByIdResponseBody()
        getOrderByIdResponseBody.message = "getOrderById"
        getOrderByIdResponseBody.order = orderResult

        return getOrderByIdResponseBody
    }
}