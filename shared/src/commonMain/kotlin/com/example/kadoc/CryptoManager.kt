package com.example.kadoc

 class CryptoManager(private val cryptoDriver: CryptoDriver) {
     fun encrypt(data: String): String {
            return cryptoDriver.hash(data)
     }
}