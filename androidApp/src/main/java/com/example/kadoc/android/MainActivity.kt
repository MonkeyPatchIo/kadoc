package com.example.kadoc.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KoinAndroidContext {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController, startDestination = NavigationItem.Home.path
                        ) {
                            composable(NavigationItem.Home.path) {
                                HomeView {
                                    navController.navigate(it.path)
                                }
                            }
                            composable(NavigationItem.Counter.path) {
                                CounterView()
                            }
                            composable(NavigationItem.Tip.path) {
                                TipView()
                            }
                            composable(NavigationItem.Crypto.path) {
                                CryptoView()
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class NavigationItem(val path: String) {
  Home("home"),  Counter("counter"), Tip("tip"), Crypto("crypto")
}