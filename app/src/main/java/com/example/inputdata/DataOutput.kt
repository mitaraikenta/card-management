package com.example.inputdata

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter


@Composable
fun DataOutput(
    navController: NavController,
    items: List<TodoItem>,
    onRemoveItem: (TodoItem) -> Unit
){
    
    TopAppBar(navController = navController)

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = items) {
                TodoRow(
                    navController = navController,
                    todo = it,
                    onItemClicked = { onRemoveItem(it) },
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
    }
}

@Composable
fun SimpleImage() {
    val imageUrl = "https://developer.android.com/images/brand/Android_Robot.png"

    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null
    )
}

@Composable
fun TodoRow(
    navController: NavController,
    todo: TodoItem,
    onItemClicked: (TodoItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column{
        Row(
            modifier = modifier
                .clickable { onItemClicked(todo) }
                .clickable { navController.navigate(route = Screen.DataList.route + "/${todo.place}/${todo.numsheet}") }
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween


        ) {
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    //アイコンの形、サイズ
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            SimpleImage()

            Text(todo.task)
        }

        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
    }
}

@Preview
@Composable
fun previewSample(){
    SimpleImage()
}