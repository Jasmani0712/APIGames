package com.example.games

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.games.navigation.NavManager
import com.example.games.ui.theme.GamesTheme
import com.example.games.viewModel.GamesViewModel
import com.example.games.views.HomeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //Para inyeccion de dependencias
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : GamesViewModel by viewModels()
        setContent {
            GamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //HomeView(viewModel)
                    NavManager(viewModel)

                }
            }
        }
    }
}
