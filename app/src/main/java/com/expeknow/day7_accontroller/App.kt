package com.expeknow.day7_accontroller

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.expeknow.day7_accontroller.ui.windows.MainScreen
import com.expeknow.day7_accontroller.ui.windows.StartScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    val navController = rememberNavController()
    
    Scaffold() {
        NavHost(navController = navController, startDestination = "splash") {
            composable(route = "home") {
                MainScreen(navController)
            }

            composable(route = "splash") {
                StartScreen(navController)
            }
        }
    }
}

