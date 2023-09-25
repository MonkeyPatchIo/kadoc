package com.example.kadoc

import kotlinx.serialization.Serializable

@Serializable
data class Fact(val fact: String, val length: Int)