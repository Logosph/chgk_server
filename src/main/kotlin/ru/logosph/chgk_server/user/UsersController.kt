package ru.logosph.chgk_server.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.logosph.chgk_server.tokens.JwtService

@RestController
@RequestMapping("/api/users")
class UsersController(
    private val usersService: UsersService,
    private val jwtService: JwtService
) {

    @PostMapping("/register")
    fun registerUsers(@RequestParam username: String, @RequestParam password: String): ResponseEntity<String> {
        usersService.registerUsers(username, password)
        return ResponseEntity.ok("User registered successfully")
    }

    @PostMapping("/login")
    fun loginUsers(@RequestParam username: String, @RequestParam password: String): ResponseEntity<String> {
        return if (usersService.authenticateUsers(username, password)) {
            val token = jwtService.generateToken(username)
            ResponseEntity.ok(token)
        } else {
            ResponseEntity.status(401).body("Invalid credentials")
        }
    }
}