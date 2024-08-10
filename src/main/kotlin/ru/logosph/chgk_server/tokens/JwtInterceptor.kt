package ru.logosph.chgk_server.tokens

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class JwtInterceptor(
    private val jwtService: JwtService
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        val authHeader = request.getHeader("Authorization") ?: return false

        if (authHeader.startsWith("Bearer ")) {
            val token = authHeader.substring(7)
            if (jwtService.validateToken(token)) {
                response.status = HttpServletResponse.SC_OK
                val newToken = jwtService.generateToken(jwtService.getUsernameFromToken(token))
                response.writer.write(newToken)
                return false
            }
        }

        response.status = HttpServletResponse.SC_UNAUTHORIZED
        return false
    }
}