package com.example.price_notifications.app.config

import com.example.price_notifications.client.apis.PostsApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfig {

    @Bean
    fun postApi(@Value("\${client.posts.url}") postsUrl: String): PostsApi{
        return PostsApi(postsUrl)
    }
}