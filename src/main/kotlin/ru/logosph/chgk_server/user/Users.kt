package ru.logosph.chgk_server.user

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String = "",
    val password: String = ""
)
