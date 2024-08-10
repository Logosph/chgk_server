package ru.logosph.chgk_server.user

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsersService(private val usersRepository: UsersRepository) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun registerUsers(username: String, password: String): Users {
        val encodedPassword = passwordEncoder.encode(password)
        val users = Users(username = username, password = encodedPassword)
        return usersRepository.save(users)
    }

    fun authenticateUsers(username: String, password: String): Boolean {
        val user = usersRepository.findByUsername(username) ?: return false
        return passwordEncoder.matches(password, user.password)
    }
}