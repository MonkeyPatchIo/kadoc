package com.example.kadoc

import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel


enum class Dice(val representation: String) {
    One(
        """
        -----
        |   |
        | o |
        |   |
        -----
    """.trimIndent()
    ),
    Two(
        """
        -----
        |o  |
        |   |
        |  o|
        -----
    """.trimIndent()
    ),
    Three(
        """
        -----
        |o  |
        | o |
        |  o|
        -----
    """.trimIndent()
    ),
    Four(
        """
        -----
        |o o|
        |   |
        |o o|
        -----
    """.trimIndent()
    ),
    Five(
        """
        -----
        |o o|
        | o |
        |o o|
        -----
    """.trimIndent()
    ),
    Six(
        """
        -----
        |o o|
        |o o|
        |o o|
        -----
    """.trimIndent()
    )
}

class RollStore : MobkViewModel() {
    var dice by observable(Dice.One)

    fun roll() {
        dice = Dice.values().random()
    }
}