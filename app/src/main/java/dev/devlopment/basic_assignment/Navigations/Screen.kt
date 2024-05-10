package dev.devlopment.basic_assignment.Navigations

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object VideoScreen : Screen("video")
}
