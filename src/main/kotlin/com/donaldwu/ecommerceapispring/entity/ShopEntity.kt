package com.donaldwu.ecommerceapispring.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shops")
@Data
class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "name", nullable = true)
    var name: String? = ""

    @Column(name = "address", nullable = true)
    var address: String? = ""

    @Column(name = "created_at")
    @CreationTimestamp
    var created_at: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updated_at: LocalDateTime = LocalDateTime.now()
}