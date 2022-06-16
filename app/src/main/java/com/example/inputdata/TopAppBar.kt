package com.example.inputdata

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun TopAppBar(navController: NavController) {
    TopAppBar(
        title = { Text("カード管理アプリ") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate(route = Screen.DataOutput.route)}) {
                Icon(Icons.Filled.Menu, contentDescription = "Open drawer")
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(route = Screen.InputScreen.route) }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit text")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Share, contentDescription = "Share text")
            }
        }
    )
}

@Composable
fun DataAll() {
    TopAppBar(
        title = { Text("情報詳細") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = "Open drawer")
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit text")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Share, contentDescription = "Share text")
            }
        }
    )
}

@Composable
fun ListAll(navController: NavController) {
    TopAppBar(
        title = { Text("情報詳細") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate(Screen.DataOutput.route)}) {
                Icon(Icons.Filled.Menu, contentDescription = "Open drawer")
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit text")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Share, contentDescription = "Share text")
            }
        }
    )
}

