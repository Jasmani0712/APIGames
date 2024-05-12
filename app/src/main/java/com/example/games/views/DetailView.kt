package com.example.games.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.games.components.MainImage
import com.example.games.components.MainTopBar
import com.example.games.components.MetaWebsite
import com.example.games.components.ReviewCard
import com.example.games.util.Constants.Companion.CUSTOM_BLACK
import com.example.games.viewModel.GamesViewModel

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(viewModel: GamesViewModel, navController: NavController, id: Int) {
    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }

    DisposableEffect(Unit){
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            MainTopBar(title = viewModel.state.name, showBackButton = true, onClickBackButton = {
                navController.popBackStack() }){}
        }
    ) {
        ContentDetailView(it, viewModel)
    }
}

@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: GamesViewModel) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .padding(pad)
            .background(Color(CUSTOM_BLACK))
    ) {
        MainImage(image = state.background_image)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ) {
            MetaWebsite(state.website)
            ReviewCard(state.metacritic)
        }

        val scroll = rememberScrollState(0)
        Text(text = state.description_raw,
            color = Color.White,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
                .verticalScroll(scroll)
        )

    }
}