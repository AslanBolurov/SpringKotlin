package com.example.kotlinspring.controller

import com.example.kotlinspring.data.AircraftRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/aircraft")
class PositionController(
    private val repository: AircraftRepository
) {

    @GetMapping
    fun getCurrentAircraftPositions(model: Model):String{
        model.addAttribute("currentPositions",repository.findAll())
        return "positions"
    }


}