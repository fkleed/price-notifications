package com.example.price.notifications.app.alphaVantage

import com.example.price.notifications.app.config.ClientConfig
import com.example.price.notifications.client.apis.AlphaVantageApi
import com.example.price.notifications.client.models.Currency
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class AlphaVantageHandler(private val alphaVantageApi: AlphaVantageApi, private val alphaVantageProperties: ClientConfig.AlphaVantageClientProperties) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun currencyExchange(request: ServerRequest): Mono<ServerResponse> {
        logger.debug("Request to get currency exchange")
        return alphaVantageApi.getCurrencyExchangeRate(
            AlphaVantageApi.FunctionGetCurrencyExchangeRate.CURRENCY_EXCHANGE_RATE,
            Currency.XRP,
            Currency.EUR,
            alphaVantageProperties.key
        ).flatMap { ServerResponse.ok().bodyValue(it) }
    }
}