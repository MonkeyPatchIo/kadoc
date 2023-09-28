package com.example.kadoc

actual class BillingManager {
    actual suspend fun listProducts(identifiers: List<String>): List<String> {
        return emptyList()
    }
}