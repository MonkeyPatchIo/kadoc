package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kadoc.CounterStore
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import org.koin.androidx.compose.koinViewModel


@Composable
fun CounterView() {
    val counterStore = koinViewModel<CounterStore>()
    Observer {
        val counter = counterStore.counter
        val message = counterStore.message
        val tip = counterStore.tipOfDay
        val decrementAvailable = counterStore.decrementAvailable
        Render {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = counter.toString())

                Button(onClick = { counterStore.increment() }) {
                    Text(text = "Increment")
                }
                Button(onClick = { counterStore.decrement() }, enabled = decrementAvailable) {
                    Text(text = "Decrement")
                }
                message?.let {
                    Text(it)
                }
                tip?.let {
                    Text(it)
                }
            }
        }
    }
}

@Preview
@Composable
fun CounterViewPreview() {
    MyApplicationTheme {
        CounterView()
    }
}
