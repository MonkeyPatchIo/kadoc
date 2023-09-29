package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString
import com.example.kadoc.Dice
import com.example.kadoc.RollStore
import io.monkeypatch.mobk.api.computed
import io.monkeypatch.mobk.ui.Observer
import io.monkeypatch.mobk.ui.Render
import org.koin.androidx.compose.koinViewModel

@Composable
fun RollView() {
    val store = koinViewModel<RollStore>()
    Observer {
        val dice = store.dice
        Render {
            Column {
                Text(buildAnnotatedString { append( dice.representation )})

                val value by computed {
                    when (dice) {
                        Dice.One -> 1
                        Dice.Two -> 2
                        Dice.Three -> 3
                        Dice.Four -> 4
                        Dice.Five -> 5
                        Dice.Six -> 6
                    }.toString()
                }
                Text(value)
                Button(onClick = { store.roll() }) {
                    Text("Reroll")
                }
            }
        }
    }

}