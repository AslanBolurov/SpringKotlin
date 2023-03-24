package com.example.kotlinspring.data

import com.example.kotlinspring.model.Coffee
import org.springframework.data.repository.CrudRepository

interface CoffeeRepository : CrudRepository<Coffee, String>