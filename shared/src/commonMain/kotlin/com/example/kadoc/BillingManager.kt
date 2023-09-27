package com.example.kadoc

expect class BillingManager {
   suspend fun listProducts(identifiers: List<String>): List<String>
}