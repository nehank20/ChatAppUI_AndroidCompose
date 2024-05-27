package com.example.nehank.chatapp_ui_androidcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nehank.chatapp_ui_androidcompose.screens.ChatScreen
import com.example.nehank.chatapp_ui_androidcompose.screens.HomeScreen
import com.example.nehank.chatapp_ui_androidcompose.screens.SplashScreen

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController =  navController, startDestination = Screen.SplashScreen.route) {

        composable(Screen.SplashScreen.route){
            SplashScreen {
                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(Screen.HomeScreen.route){
            HomeScreen {id ->
                navController.navigate(Screen.ChatScreen.createRoute(id))
            }
        }

        composable(Screen.ChatScreen.route){
            val id = it.arguments?.getString("id")?.toIntOrNull()
            ChatScreen(personId = id ?: 1)
        }

    }
}

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splashscreen")
    data object HomeScreen : Screen("homescreen")
    data object ChatScreen : Screen("chatscreen/{id}"){
        fun createRoute(id: Int) = "chatscreen/$id"
    }
}