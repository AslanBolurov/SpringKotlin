package com.example.kotlinspring.controller

import com.example.kotlinspring.data.AircraftRepository
import com.example.kotlinspring.model.Aircraft
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@EnableScheduling
@Component
class PlaneFinderPoller(
    private val connectionFactory: RedisConnectionFactory,
    private val repo: AircraftRepository
    //    private val redisOperations: RedisOperations<String, Aircraft>

) {
    private val client = WebClient.create("http://localhost:8080/aircraft")

    @Scheduled(fixedDelay = 1000)
    private fun pollPlanes() {

        repo.deleteAll()
//        connectionFactory.connection.serverCommands().flushDb()

        client.get()
            .retrieve()
            .bodyToFlux<Aircraft>()
            .filter { !it.reg.isNullOrEmpty() }
            .toStream()
            .forEach { repo.save(it) }
//            .forEach { redisOperations.opsForValue()[it.reg!!]=it }

//        redisOperations.opsForValue()
//            .operations
//            .keys("*")
//            ?.forEach { println(redisOperations.opsForValue()[it])}
        repo.findAll().forEach { println(it) }

    }


}