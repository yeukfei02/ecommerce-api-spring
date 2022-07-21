package com.donaldwu.ecommerceapispring.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
@Data
class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "order_detail", nullable = true)
    var order_detail: String? = ""

    @Column(name = "shop_id", nullable = true)
    var shop_id: Long? = 0

    @Column(name = "user_id", nullable = true)
    var user_id: Long? = 0

    @Column(name = "created_at")
    @CreationTimestamp
    var created_at: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updated_at: LocalDateTime = LocalDateTime.now()
}