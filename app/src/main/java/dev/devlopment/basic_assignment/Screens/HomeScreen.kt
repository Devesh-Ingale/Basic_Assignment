package dev.devlopment.basic_assignment.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.devlopment.basic_assignment.Navigations.Screen
import dev.devlopment.basic_assignment.R
import dev.devlopment.basic_assignment.Utils.SearchBar
import dev.devlopment.basic_assignment.Utils.VideoItem
import dev.devlopment.basic_assignment.Utils.getFilteredVideos

// Sample data class representing a video
data class Video(val title: String, val description: String, val likes: Int, val comments: Int, val thumbnail: Int)

// Sample list of videos
val videoList = listOf(
    Video("Video 1", "Description for Video 1", 100, 20, R.drawable.logo),
    Video("Video 2", "Description for Video 2", 150, 30, R.drawable.logo),
    Video("Video 3", "Description for Video 3", 200, 40, R.drawable.logo)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YouTubeHome(navController: NavHostController) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = "Home") })
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            searchText = searchText,
            onSearchTextChanged = { searchText = it }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(getFilteredVideos(searchText.text)) { video ->
                VideoItem(video = video) {
                    navController.navigate("${Screen.VideoScreen.route}/${video.title}")
                }
            }
        }
    }
}



