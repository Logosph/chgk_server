package ru.logosph.chgk_server

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @GetMapping("/api/hello")
    fun hello(): String {
        return "Hello, World!!!!!!!"
    }


}