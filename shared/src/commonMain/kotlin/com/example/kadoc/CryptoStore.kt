package com.example.kadoc

import io.monkeypatch.mobk.api.computed
import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel


class CryptoStore(private val cryptoDriver: CryptoDriver) : MobkViewModel() {
    var data by observable("")

    val hashed by computed {
        cryptoDriver.hash(data)
    }
}