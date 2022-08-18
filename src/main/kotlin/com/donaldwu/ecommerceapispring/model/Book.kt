package com.donaldwu.ecommerceapispring.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "books")
@Data
class Book {
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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "shop_id", insertable = false, updatable = false)
    @JsonIgnore
    var shop: Shop? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    var user: User? = null

    @Column(name = "created_at")
    @CreationTimestamp
    var created_at: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updated_at: LocalDateTime = LocalDateTime.now()
}
