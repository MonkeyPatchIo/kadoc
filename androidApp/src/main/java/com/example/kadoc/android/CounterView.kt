package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kadoc.CounterStore
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState


@Composable
fun CounterView() {
    val counterStore = koinViewModel<CounterStore>()
    val state by counterStore.collectAsState()
    val counter = state.counter

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = counter.toString())

        Button(onClick = { counterStore.increment() }) {
            Text(text = "Increment")
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
