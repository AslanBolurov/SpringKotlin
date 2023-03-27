package com.example.kotlinspring.client

import com.example.kotlinspring.data.AircraftRepository
import com.example.kotlinspring.model.Aircraft
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@EnableScheduling
@Component
class PlaneFinderPoller(private val repo: AircraftRepository) {
    private val client = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedDelay = 1000)
    private fun pollPlanes() {
        repo.deleteAll()
        client.get()
            .retrieve()
            .bodyToFlux<Aircraft>()
            .filter { !it.reg.isNullOrEmpty() }
            .toStream()
            .forEach { repo.save(it) }

        repo.findAll().forEach { println(it) }
    }
}