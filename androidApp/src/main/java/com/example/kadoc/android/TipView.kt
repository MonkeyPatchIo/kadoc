package com.example.kadoc.android

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kadoc.TipStore
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import org.koin.androidx.compose.koinViewModel

@Composable
fun TipView() {
    val tipStore = koinViewModel<TipStore>()
    Observer {
        val tip = tipStore.tipOfDay
        Render {
            tip?.let {
                Text(tip)
            }
        }
    }
}