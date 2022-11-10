package com.example.testtasks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasks.ui.theme.TestTasksTheme

sealed class Categories(@DrawableRes val icon: Int, val label: String){
    object Books: Categories(R.drawable.books, "Books")
    object Phones: Categories(R.drawable.phones, "Phones")
    object Health: Categories(R.drawable.health, "Health")
    object Computer: Categories(R.drawable.computers, "Computer")

}

@Composable
fun ItemCategory(
    isSelected: Boolean,
    onSelected: () -> Unit,
    item: Categories
) {
    Column(
        modifier = Modifier.width(71.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.White,
            shape = CircleShape,
            modifier = Modifier.size(71.dp),
            onClick = onSelected
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.padding(17.dp)
            )
        }
        Spacer(modifier = Modifier.size(7.dp))
        
        Text(
            text = item.label,
            color = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight(500),
            fontSize = 12.sp
        )
    }
    
    
}

@Preview
@Composable
fun PreviewItemCategory() {
    TestTasksTheme{
        ItemCategory(
            isSelected = true,
            onSelected = {

            },
            item = Categories.Books
        )
    }
}