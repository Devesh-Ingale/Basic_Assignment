package dev.devlopment.basic_assignment.Utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dev.devlopment.basic_assignment.PostGreSql.Video
import dev.devlopment.basic_assignment.R

@Composable
fun VideoItem(video: Video, onItemClick: (Video) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(video) }
            .padding(bottom = 8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = video.thumbnail_url,
                    builder = {
                        // when the real url will be there it will display it

                        placeholder(R.drawable.logo) // Placeholder while loading
                        error(R.drawable.logo) // Error image to show if loading fails
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = video.title,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = video.channel_name,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Likes: ${video.likes}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Comments: ${video.comments}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}
