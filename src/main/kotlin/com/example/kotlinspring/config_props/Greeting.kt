package com.example.kotlinspring.config_props

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "greeting")
class Greeting(
    val name: String,
    val coffee: String
)