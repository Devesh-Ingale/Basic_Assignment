package dev.devlopment.basic_assignment.PostGreSql



import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val id:Int,
    val channelName: String? = null,
    val title: String,
    val thumbnailUrl: String? = null,
    val description: String,
    val likes: Int,
    val comments: Int
)



