package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kadoc.PlayerStore
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlayerView() {
    val store = koinViewModel<PlayerStore>()

    Observer {
        val running = store.running
        Render {
            Column {
                Button(onClick = { store.start() }) {
                    Text("Play")
                }
                Button(onClick = { store.cancel() }) {
                    Text("Cancel")
                }
                if (running) {
                    CircularProgressIndicator()
                }
            }
        }
    }

}