package com.example.testtasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testtasks.ui.theme.TestTasksTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTasksTheme {
                ItemBestSeller(
                    price = "\$1,047",
                    oldPrice = "\$1,500",
                    nameModel = "Samsung Galaxy s20 Ultra",
                    onFavorite = {},
                    onClick = {},
                    imgUrl="https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTasksTheme {
        SplashScreen()
    }
}