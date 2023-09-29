package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.kadoc.TransactionStore
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun TransactionView() {
    val store = koinViewModel<TransactionStore>()
    val coroutineScope = rememberCoroutineScope()

    Observer {
        val running = store.running
        Render {
            Column {
                Button(onClick = {coroutineScope.launch { store.start() }  }) {
                    Text("Start")
                }
                Button(onClick = { coroutineScope.cancel() }) {
                    Text("Cancel")
                }
                if (running) {
                    CircularProgressIndicator()
                }
            }
        }
    }

}