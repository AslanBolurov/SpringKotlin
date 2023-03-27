package com.example.kotlinspring.data

import com.example.kotlinspring.model.Aircraft
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AircraftRepository : ReactiveCrudRepository<Aircraft, Long> {
}