package com.example.inputdata

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument



@Composable
fun NavMain(
    navController: NavHostController,
    DataViewModel: DataViewModel,
    todo:TodoItem
){

    val items: List<TodoItem> by DataViewModel.inputData.observeAsState(listOf())

    NavHost(
        navController = navController,
        startDestination = Screen.DataOutput.route
    ){
        composable(route = Screen.InputScreen.route){
            //入力画面をここで呼び出す
            InputScreen(navController = navController, items = items, onAddItem = {DataViewModel.addItem(it)}, onRemoveItem = {DataViewModel.removeItem(it)})
        }

        composable(route = Screen.DataOutput.route){
            DataOutput(navController = navController, items = items,onRemoveItem = {})
        }

        composable(
            route = Screen.DataList.route + "/{place}/{numsheet}",
            arguments = listOf(
                navArgument("place") { type = NavType.StringType },
                navArgument("numsheet") { type = NavType.StringType }
            )
        ){ backStackEntry ->
            val place = backStackEntry.arguments?.getString("place") ?: ""
            val numsheet = backStackEntry.arguments?.getString("numsheet") ?: ""

            DataList(todo = TodoItem(todo.task,place,numsheet),navController = navController)
    }
    }
}