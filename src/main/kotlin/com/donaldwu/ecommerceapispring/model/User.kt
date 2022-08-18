package com.donaldwu.ecommerceapispring.model

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
@Data
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "email", nullable = false)
    var email: String = ""

    @Column(name = "password", nullable = false)
    var password: String = ""

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var books: List<Book> = mutableListOf()

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var orders: List<Order> = mutableListOf()

    @Column(name = "created_at")
    @CreationTimestamp
    var created_at: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updated_at: LocalDateTime = LocalDateTime.now()
}
