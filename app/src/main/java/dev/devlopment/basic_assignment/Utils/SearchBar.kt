package dev.devlopment.basic_assignment.Utils

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import dev.devlopment.basic_assignment.Screens.Video
import dev.devlopment.basic_assignment.Screens.videoList

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = searchText,
        onValueChange = onSearchTextChanged,
        label = { Text("Search") },
        singleLine = true
    )
}

fun getFilteredVideos(searchText: String): List<Video> {
    return if (searchText.isNotBlank()) {
        videoList.filter { it.title.contains(searchText, ignoreCase = true) }
    } else {
        videoList.take(10) // Show top 10 videos when search text is empty
    }
}