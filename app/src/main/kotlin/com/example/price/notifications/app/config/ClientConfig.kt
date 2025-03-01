package com.example.price.notifications.app.config

import com.example.price.notifications.client.apis.AlphaVantageApi
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ClientConfig.AlphaVantageClientProperties::class)
class ClientConfig {

    @Bean
    fun alphaVantageApi(properties: AlphaVantageClientProperties): AlphaVantageApi {
        return AlphaVantageApi(properties.url)
    }

    @ConfigurationProperties(prefix = "client.alpha-vantage")
    data class AlphaVantageClientProperties(
        val url: String,
        val key: String
    )
}