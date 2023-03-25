package com.example.kotlinspring

import com.example.kotlinspring.config_props.Droid
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinspringApplication{
	@Bean
	@ConfigurationProperties(prefix = "droid")
	fun createDroid() = Droid()
}

fun main(args: Array<String>) {
	runApplication<KotlinspringApplication>(*args)
}


