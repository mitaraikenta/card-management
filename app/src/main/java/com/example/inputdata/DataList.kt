package com.example.inputdata

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DataList(todo: TodoItem,navController: NavController) {

    ListAll(navController = navController)

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "管理場所",
            fontSize = 50.sp
        )

        Text(
            text = todo.place,
            fontSize = 30.sp,
            modifier = Modifier.paddingFromBaseline(top = 50.dp)
        )

        Text(
            text = "枚数",
            fontSize = 50.sp,
            modifier = Modifier.paddingFromBaseline(top = 100.dp)
        )

        Text(
            text = todo.numsheet,
            fontSize = 30.sp,
            modifier = Modifier.paddingFromBaseline(top = 50.dp)
        )
    }

}

