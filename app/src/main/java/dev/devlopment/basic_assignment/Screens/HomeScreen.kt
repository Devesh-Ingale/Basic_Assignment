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


// Sample list of videos


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YouTubeHome(navController: NavHostController) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    val filteredVideos = getFilteredVideos(searchText.text)

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
            items(filteredVideos) { video ->
                VideoItem(video = video) {
                    navController.navigate("${Screen.VideoScreen.route}/${video.title}")
                }
            }
        }
    }
}




