package com.example.kadoc


interface CryptoDriver {
      fun hash(data: String): String
}