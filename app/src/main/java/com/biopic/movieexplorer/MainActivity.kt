package com.biopic.movieexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.MovieExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieExplorerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black)
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {
        composable(route = "HomeScreen") {
            HomeScreen(navController)
        }
        composable(route = "ComingSoon") {
            Settings(navController)
        }
    }
}