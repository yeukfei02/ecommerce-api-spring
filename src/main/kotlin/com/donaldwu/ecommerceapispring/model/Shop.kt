package com.donaldwu.ecommerceapispring.model

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shops")
@Data
class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "name", nullable = true)
    var name: String? = ""

    @Column(name = "address", nullable = true)
    var address: String? = ""

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var books: List<Book> = mutableListOf()

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var orders: List<Order> = mutableListOf()

    @Column(name = "created_at")
    @CreationTimestamp
    var created_at: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updated_at: LocalDateTime = LocalDateTime.now()
}
