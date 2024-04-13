package com.example.notestring.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notestring.screens.add.AddModel
import com.example.notestring.screens.add.AddView
import com.example.notestring.screens.add.AddViewModel
import com.example.notestring.screens.edit.EditModel
import com.example.notestring.screens.edit.EditView
import com.example.notestring.screens.edit.EditViewModel
import com.example.notestring.screens.home.HomeModel
import com.example.notestring.screens.home.HomeView
import com.example.notestring.screens.home.HomeViewModel
import com.example.notestring2.database.AppDataBase
import com.example.notestring2.screens.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    context: Context
) {
    val appDataBase = AppDataBase.getInstance(context)
    val appDao = appDataBase.getDao()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {

        val hm = HomeModel(appDao)
        val hvm = HomeViewModel(navController, hm)
        composable(Screens.HomeView.route) {
            HomeView(hvm, navController)
        }


        val edit = EditModel(appDao)
        composable(Screens.EditView.route, arguments = listOf(navArgument("id") {
            type = NavType.IntType
        })) {
            val id = it.arguments?.getInt("id")!!
            val avm = EditViewModel(navController, id, edit)
            EditView(avm, navController)
        }


        val edit1 = AddModel(appDao)
        composable(Screens.AddView.route, arguments = listOf(navArgument("id") {
            type = NavType.IntType
        })) {
            val id = it.arguments?.getInt("id")!!
            val avm1 = AddViewModel(navController, id, edit1)
            AddView(avm1, navController)
        }


        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
    }
}