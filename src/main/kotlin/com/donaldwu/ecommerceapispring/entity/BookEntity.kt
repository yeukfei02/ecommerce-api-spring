package com.donaldwu.ecommerceapispring.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "books")
@Data
class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "name", nullable = true)
    var name: String? = ""

    @Column(name = "author", nullable = true)
    var author: String? = ""

    @Column(name = "price", nullable = true)
    var price: Double? = 0.0

    @Column(name = "quantity", nullable = true)
    var quantity: Int? = 0

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