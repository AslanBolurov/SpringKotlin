package com.example.kotlinspring.controller

import com.example.kotlinspring.config_props.Droid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/droid")
class DroidController(@get:GetMapping val droid: Droid)


