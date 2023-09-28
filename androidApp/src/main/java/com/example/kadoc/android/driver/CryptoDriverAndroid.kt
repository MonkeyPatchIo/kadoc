package com.example.kadoc.android.driver

import com.example.kadoc.CryptoDriver
import java.security.MessageDigest


class CryptoDriverAndroid : CryptoDriver {
    override fun hash(data: String): String {
        val messageDigest = MessageDigest.getInstance("SHA-512")
        val hashBytes = messageDigest.digest(data.toByteArray())

        val hexString = StringBuilder()
        for (hashByte in hashBytes) {
            val hex = Integer.toHexString(0xff and hashByte.toInt())
            if (hex.length == 1) {
                hexString.append('0')
            }
            hexString.append(hex)
        }
        return hexString.toString()
    }
}