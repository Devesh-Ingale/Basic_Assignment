package dev.devlopment.basic_assignment.Utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import dev.devlopment.basic_assignment.PostGreSql.Initialization
import dev.devlopment.basic_assignment.PostGreSql.Video


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchText: TextFieldValue,
    onSearchTextChanged: (TextFieldValue) -> Unit
) {
    TextField(
        value = searchText,
        onValueChange = onSearchTextChanged,
        modifier = Modifier.padding(all = 20.dp).fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Search", color = Color(0xFFF86B3F)) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription ="create",
                // tint = myColor5
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFF86B3F),
            unfocusedLabelColor = Color(0xFFF86B3F),
            focusedLabelColor = Color(0xFFF86B3F),
            cursorColor = Color(0xFFF86B3F),
            focusedLeadingIconColor = Color(0xFFF86B3F),
            unfocusedLeadingIconColor = Color(0xFFF86B3F),
            focusedTrailingIconColor = Color(0xFFF86B3F),
            unfocusedTrailingIconColor = Color(0xFFF86B3F),
            containerColor = Color(0xFFF86B3F).copy(
                .2f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent),
        shape = RoundedCornerShape(25.dp)
    )
}

@Composable
fun getFilteredVideos(searchText: String): List<Video> {
    val initialization = Initialization()
    val videoList = initialization.Videolist()
    return if (searchText.isNotBlank()) {
        videoList.filter { it.title.contains(searchText, ignoreCase = true) }
    } else {
        videoList.take(10) // Show top 10 videos when search text is empty
    }
}