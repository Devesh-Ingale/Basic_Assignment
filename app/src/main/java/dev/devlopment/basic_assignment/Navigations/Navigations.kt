package dev.devlopment.basic_assignment.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.devlopment.basic_assignment.Screens.VideoDetail
import dev.devlopment.basic_assignment.Screens.YouTubeHome
import dev.devlopment.basic_assignment.Screens.videoList

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            YouTubeHome(navController = navController)
        }
        composable("${Screen.VideoScreen.route}/{videoTitle}") { backStackEntry ->
            val videoTitle = backStackEntry.arguments?.getString("videoTitle")
            videoTitle?.let { title ->
                val video = videoList.find { it.title == title }
                video?.let {
                    VideoDetail(video = it) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}
