package com.example.inputdata

import android.text.Layout
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInputText(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInputPlace(
    place: String,
    onPlaceChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = place,
        onValueChange = onPlaceChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInputNum(
    num: String,
    onNumChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = num,
        onValueChange = onNumChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun TodoItemInputBackground(
    elevate: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    val animatedElevation by animateDpAsState(if (elevate) 1.dp else 0.dp, TweenSpec(500))
    Surface(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        elevation = animatedElevation,
        shape = RectangleShape,
    ) {
        Row(
            modifier = modifier.animateContentSize(animationSpec = TweenSpec(300)),
            content = content
        )
    }
}

//送信フォームの画面
@Composable
fun TodoItemInput(navController: NavController,onItemComplete: (TodoItem) -> Unit) {
    val (text, setText) = remember { mutableStateOf("") }

    val (place, setPlace) = remember { mutableStateOf("") }

    val (num,setNum) = remember{ mutableStateOf("") }

    Column {
        Row(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 150.dp)
        ) {
            Text("カード名:")

            TodoInputText(
                text = text,
                onTextChange = setText,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
        }

        Column {
            Row(
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 60.dp)
            ) {
                Text("保存場所:")

                TodoInputPlace(
                    place = place,
                    onPlaceChange = setPlace,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
            }
        }

        Column {
            Row(
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 60.dp)
            ) {

                Text("枚数:")

                TodoInputNum(
                    num = num,
                    onNumChange = setNum,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                TodoEditButton(
                    onClick = {
                        onItemComplete(TodoItem(text, place, num))
                        navController.navigate(route = Screen.DataOutput.route)
                        setText("")
                    },
                    text = "Add",
                    enabled = text.isNotBlank()
                )
            }
        }
    }




}

@Composable
fun TodoEditButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text)
    }
}



@Composable

fun InputScreen(
    navController: NavController,
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
){
    TopAppBar(navController)

    Column {
        TodoItemInputBackground(elevate = true, modifier = Modifier.fillMaxWidth()) {
            TodoItemInput(navController = navController, onItemComplete = onAddItem)
        }
    }
}



