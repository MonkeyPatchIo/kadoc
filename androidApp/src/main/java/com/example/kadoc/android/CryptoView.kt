package com.example.kadoc.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kadoc.CounterStore
import com.example.kadoc.CryptoStore
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import org.koin.androidx.compose.koinViewModel

@Composable
fun CryptoView() {
    val cryptoStore = koinViewModel<CryptoStore>()
    Observer {
        val data = cryptoStore.data
        val hashed = cryptoStore.hashed
        Render {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(value = data, onValueChange = { cryptoStore.data = it })
                Divider()
                Text(text = data)
                Divider()
                Text(text = hashed)
            }
        }
    }
}

@Preview
@Composable
fun CounterViewPreview() {
    MyApplicationTheme {
        CryptoView()
    }
}
