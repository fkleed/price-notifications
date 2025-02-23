package com.example.price_notifications.app.config

import com.example.price_notifications.app.posts.PostsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class WebConfig {

    @Bean
    fun postsRouterFunction(postsHandler: PostsHandler): RouterFunction<ServerResponse> = router {
        ("/posts" and accept(APPLICATION_JSON)).nest {
            GET("/{id}", postsHandler::postById)
            GET("", postsHandler::posts)
        }
    }
}