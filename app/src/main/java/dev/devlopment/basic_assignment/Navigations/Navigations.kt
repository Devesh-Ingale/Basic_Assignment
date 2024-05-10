package dev.devlopment.basic_assignment.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.devlopment.basic_assignment.PostGreSql.Initialization
import dev.devlopment.basic_assignment.Screens.VideoDetail
import dev.devlopment.basic_assignment.Screens.YouTubeHome

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
                val initialization = Initialization()
                val video = initialization.getVideoByTitle(title)
                video?.let {
                    VideoDetail(video = it) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}

