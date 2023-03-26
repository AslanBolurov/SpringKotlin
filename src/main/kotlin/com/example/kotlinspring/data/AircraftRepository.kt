package com.example.kotlinspring.data

import com.example.kotlinspring.model.Aircraft
import org.springframework.data.repository.CrudRepository

interface AircraftRepository : CrudRepository<Aircraft, Long> {
}