package ru.logosph.chgk_server.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import ru.logosph.chgk_server.tokens.JwtInterceptor
import ru.logosph.chgk_server.tokens.JwtService

@Configuration
class WebConfig(
    private val jwtService: JwtService
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(JwtInterceptor(jwtService))
            .addPathPatterns("/api/login")
    }
}