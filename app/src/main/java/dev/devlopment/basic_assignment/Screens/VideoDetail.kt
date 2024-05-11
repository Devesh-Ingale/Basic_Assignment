package dev.devlopment.basic_assignment.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.devlopment.basic_assignment.PostGreSql.Video
import dev.devlopment.basic_assignment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoDetail(video: Video, onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Video Details",style = MaterialTheme.typography.headlineLarge,
                color = Color.Black) },colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor =  Color(0xFFF86B3F),
                titleContentColor =  Color(0xFFF86B3F)),
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Card(
                modifier = Modifier
                    .fillMaxSize().padding(4.dp).wrapContentSize()
                    .padding(it),
                elevation = CardDefaults.cardElevation(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = video.title,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = video.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = video.channel_name ?: "",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Likes: ${video.likes}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Comments: ${video.comments}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }
    )
}

