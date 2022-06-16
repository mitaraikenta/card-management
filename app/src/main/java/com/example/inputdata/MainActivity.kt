package com.example.inputdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inputdata.ui.theme.MitarashiTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    private val dataViewModel by viewModels<DataViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MitarashiTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                NavMain(todo = TodoItem("","",""), navController = navController, DataViewModel = dataViewModel)
            }
        }
    }
}







