package com.example.inputdata

sealed class Screen(val route: String) {
    object InputScreen: Screen(route = "InputData")
    object MainActivity: Screen(route = "MainScreen")
    object DataOutput: Screen(route = "DataOutput")
    object DataList:Screen(route = "Datalist")
}