package ru.logosph.chgk_server.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Users, Long> {
    fun findByUsername(username: String): Users?
}