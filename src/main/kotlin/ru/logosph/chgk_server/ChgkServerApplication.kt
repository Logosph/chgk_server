package ru.logosph.chgk_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChgkServerApplication

fun main(args: Array<String>) {
    runApplication<ChgkServerApplication>(*args)
}
