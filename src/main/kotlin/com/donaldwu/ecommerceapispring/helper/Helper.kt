package com.donaldwu.ecommerceapispring.helper

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException

class Helper {
    companion object {
        fun getJwtToken(id: Int, email: String): String {
            var token = ""

            try {
                val payload = mutableMapOf<String, Any>()
                payload["id"] = id
                payload["email"] = email

                val jwtSecret = System.getenv("JWT_SECRET") ?: "secret"

                val algorithm: Algorithm = Algorithm.HMAC256(jwtSecret)
                token = JWT.create()
                    .withIssuer("auth0")
                    .withPayload(payload)
                    .sign(algorithm)
            } catch (e: JWTCreationException) {
                println("getJwtToken error = ${e.message}")
            }

            return token
        }
    }
}