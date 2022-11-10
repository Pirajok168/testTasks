package com.example.testtasks

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasks.ui.theme.TestTasksTheme

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {

        Box(modifier = Modifier.size(400.dp), contentAlignment = Alignment.Center){
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .size(132.dp)

            ) {
            }

            Text(
                text = "Ecommerce\nConcept",
                fontWeight = FontWeight(800),
                fontSize = 30.sp,
                color = Color.White,
                lineHeight = 33.sp,
                modifier = Modifier.padding(start = 95.dp)
            )

        }




    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    TestTasksTheme {
        SplashScreen()
    }
}