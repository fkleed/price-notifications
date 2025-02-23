package com.example.price_notifications.app

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class FluxController(val fluxService: FluxService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/numbers")
    fun numbers(@RequestParam limit: Int): Flux<Int> {
        logger.debug("received request")
        return fluxService.numberFlux(limit).map { it.times(MULTIPLIER) }
    }

    companion object {
        const val MULTIPLIER = 10
    }
}