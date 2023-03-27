package com.example.kotlinspring.data

import com.example.kotlinspring.model.Aircraft
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class DataLoader(
    private val repo:AircraftRepository
) {
    @PostConstruct
    private fun loadData(){
        repo.deleteAll()
        repo.save(
            Aircraft(
                81L,
                "AAL608", "1451", "N754UW", "AA608", "IND-PHX", "A319", "A3",
                36000, 255, 423, 0, 36000,
                39.150284, -90.684795, 1012.8, 26.575562, 295.501994,
                true, false,
                Instant.parse("2020-11-27T21:29:35Z"),
                Instant.parse("2020-11-27T21:29:34Z"),
                Instant.parse("2020-11-27T21:29:27Z")
            )
        )
    }
}