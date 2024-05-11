package dev.devlopment.basic_assignment.PostGreSql



import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val id:Int,
    val channel_name: String,
    val title: String,
    val thumbnail_url: String,
    val description: String,
    val likes: Int,
    val comments: Int
)



