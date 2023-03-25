package com.example.kotlinspring.controller

import com.example.kotlinspring.config_props.Greeting
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(
    private val greeting:Greeting
) {

    @GetMapping
    fun getGreeting()="Hello, ${greeting.name}"

    @GetMapping("/coffee")
    fun getNameAndCoffee() = greeting.coffee

}