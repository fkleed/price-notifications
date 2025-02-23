package com.example.price_notifications.app

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class FluxService {

    fun numberFlux(limit: Int): Flux<Int> {
        return Flux.range(1, limit)
    }
}