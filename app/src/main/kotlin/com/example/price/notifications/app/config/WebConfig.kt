package com.example.price.notifications.app.config

import com.example.price.notifications.app.alphaVantage.AlphaVantageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class WebConfig {

    @Bean
    fun alphaVantageRouterFunction(alphaVantageHandler: AlphaVantageHandler): RouterFunction<ServerResponse> = router {
        ("/exchange" and accept(APPLICATION_JSON)).nest {
            GET("", alphaVantageHandler::currencyExchange)
        }
    }
}