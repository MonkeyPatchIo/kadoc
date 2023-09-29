package com.example.kadoc.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeView(onNavigate: (item: NavigationItem) -> Unit) {
    Column {
        Button(onClick = {
            onNavigate(NavigationItem.Counter)
        }) {
            Text("Mobk Counter")
        }
        Button(onClick = {
            onNavigate(NavigationItem.Tip)
        }) {
            Text("Tip")
        }
        Button(onClick = {
            onNavigate(NavigationItem.Crypto)
        }) {
            Text("Crypto")
        }
        Button(onClick = {
            onNavigate(NavigationItem.Roll)
        }) {
            Text("Roll")
        }
    }
}