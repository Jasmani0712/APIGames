package com.example.games.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.games.model.GameList
import com.example.games.util.Constants.Companion.CUSTOM_BLACK
import com.example.games.util.Constants.Companion.CUSTOM_GREEN

@OptIn (ExperimentalMaterialApi::class)
@Composable
fun MainTopBar(title: String, showBackButton: Boolean = false,onClickBackButton:() -> Unit,onClickAction: () -> Unit){
    /*TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold)},
        //colors = TopAppBarDefaults.mediumTopAppBarColors
        colors = AppBarDefaults.

    )*/

    TopAppBar(
        title = { Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
        ) },
        backgroundColor = Color(CUSTOM_BLACK),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            if (!showBackButton) {
                IconButton(onClick = { onClickAction() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun CardGame(game: GameList, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage(image = game.background_image)
        }
    }
}

@Composable
fun MainImage(image: String) {
    val image = rememberImagePainter(data = image)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )

}

@Composable
fun MetaWebsite(url: String) {

    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    Column {
        Text(
            text = "METASCORE",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )

        Button(
            onClick = { context.startActivity(intent) }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                //containerColor = Color.Gray

            )
        ) {
            Text(text = "Sitio Web")
        }
    }
}

@Composable
fun ReviewCard(metascore: Int) {
    Card(
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(CUSTOM_GREEN)
        //colors = CardDefaults.cardColors(
          //  containerColor = Color(CUSTOM_GREEN)
        //)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = metascore.toString(),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp
            )
        }
    }
}


