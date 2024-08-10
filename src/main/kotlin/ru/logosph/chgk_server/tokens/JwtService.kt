package ru.logosph.chgk_server.tokens

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService {
    private val key = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    fun generateToken(username: String): String {
        val now = Date()
        val expiryDate = Date(now.time + 1000L * 60 * 60 * 24 * 90)

        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUsernameFromToken(token: String): String {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).body.subject
    }

}