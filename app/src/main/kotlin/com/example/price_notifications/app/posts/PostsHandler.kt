package com.example.price_notifications.app.posts

import com.example.price_notifications.client.apis.PostsApi
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class PostsHandler(val postsApi: PostsApi) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun posts(request: ServerRequest): Mono<ServerResponse> {
        logger.debug("Request to get all posts")
        return postsApi.getPosts()
            .flatMap{posts -> ServerResponse.ok().bodyValue(posts)}
    }

    fun postById(request: ServerRequest): Mono<ServerResponse> {
        val postId = request.pathVariable("id").toLong()
        logger.debug("Request to get post by id $postId")
        return postsApi.getPost(postId)
            .flatMap { post -> ServerResponse.ok().bodyValue(post) }
    }
}