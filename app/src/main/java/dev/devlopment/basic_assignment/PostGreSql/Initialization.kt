package dev.devlopment.basic_assignment.PostGreSql

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.supabaseJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Initialization {

    val supabase = createSupabaseClient(
        supabaseUrl = "https://eogedcwxsoquyanzidtk.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVvZ2VkY3d4c29xdXlhbnppZHRrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTUzMzQxODAsImV4cCI6MjAzMDkxMDE4MH0.vSp_qunJ5qti3PFst_gpRHvTqkucpjS1wgtdi7rS_og"
    ) {
        install(Postgrest)
    }


    @Composable
    fun Videolist(): List<Video> {
        val Videos = remember {
            mutableStateListOf<Video>()
        }
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                val results = supabase.from("videos").select().decodeList<Video>()
                Videos.clear()
                Videos.addAll(results)
            }
        }
        return Videos
    }

    @Composable
    fun getVideoByTitle(title: String): Video? {
        return Videolist().find { it.title == title }
    }

}