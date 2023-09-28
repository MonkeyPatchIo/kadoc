package com.example.kadoc

import io.monkeypatch.mobk.api.computed
import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel


class CryptoStore(private val cryptoManager: CryptoManager) : MobkViewModel() {
    var data by observable("")

    val hashed by computed {
        cryptoManager.encrypt(data)
    }
}