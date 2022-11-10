

package com.example.testtasks

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testtasks.ui.theme.TestTasksTheme




@ExperimentalMaterialApi
@Composable
fun HomeScreen() {

    val categories = listOf(Categories.Phones, Categories.Computer, Categories.Health, Categories.Books)
    val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    val (isSelected, onSelected) = remember {
        mutableStateOf(categories[0])
    }

    val text = remember{
        mutableStateOf("")
    }
    BottomDrawer(
        drawerContent = {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                onClick = { },
                content = { Text("Close Drawer") }
            )

        },
        drawerState = drawerState,

    ) {

        Scaffold(

        ) {
            paddingValue ->

            Column(
                modifier = Modifier
                    .padding(paddingValue)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            ) {
                Label(
                    text = "Select Category",
                    subtext = "view all",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp)
                        .padding(top = 30.dp)
                ) {

                }
                LazyRow(
                    contentPadding = PaddingValues(
                        horizontal = 27.dp,
                        vertical = 24.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(23.dp)
                ){
                    items(categories){
                        ItemCategory(
                            isSelected = isSelected == it,
                            onSelected = {
                                onSelected(it)
                            },
                            item = it
                        )
                    }
                }


                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .padding(horizontal = 27.dp),
                    shape = RoundedCornerShape(50),
                    elevation = 20.dp,
                    color = Color.White,
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colors.secondary,

                        )
                        TextField(
                            value = text.value,
                            onValueChange = {text.value = it},
                            placeholder = {
                                Text("Search")
                            },
                            colors = TextFieldDefaults
                                .textFieldColors(
                                    backgroundColor = Color.White,
                                    focusedIndicatorColor = Color.White,
                                    unfocusedIndicatorColor = Color.White
                                )
                        )
                    }
                        



                }




            }


        }
    }




}


@Preview
@Composable
@ExperimentalMaterialApi

fun PreviewHomeScreen() {
    TestTasksTheme{
        HomeScreen()
    }
}