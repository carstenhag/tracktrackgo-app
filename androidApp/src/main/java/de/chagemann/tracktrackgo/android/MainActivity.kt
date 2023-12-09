package de.chagemann.tracktrackgo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.chagemann.tracktrackgo.StartViewModel
import de.chagemann.tracktrackgo.android.Screens.*
import dev.icerock.moko.mvvm.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = Start.route
                ) {
                    composable(Start.route) {
                        StartScreen(viewModel = getViewModel { StartViewModel() })
                    }
                }
            }
        }
    }
}

enum class Screens(val route: String) {
    Start("start")
}

@Composable
fun StartScreen(viewModel: StartViewModel) {
    val state by viewModel.viewState.collectAsState()
    Button(onClick = { viewModel.fetchData("1") }) {
        Text(text = state.counter.toString())
    }
}
