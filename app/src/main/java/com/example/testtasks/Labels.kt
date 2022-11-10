package com.example.testtasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testtasks.ui.theme.TestTasksTheme

@Composable
fun Label(
    text: String,
    subtext: String,
    modifier: Modifier,
    onSeeMore: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight(700),
            color = MaterialTheme.colors.primary
        )

        ClickableText(text = AnnotatedString(subtext, spanStyle = SpanStyle(
            color = MaterialTheme.colors.secondary,
            fontSize = 19.sp,
            fontWeight = FontWeight(400)
        )
        ), onClick = {
            onSeeMore()
        })
    }

}

@Preview
@Composable
fun PreviewLabel() {
    TestTasksTheme{
        Label(text = "Select Category", subtext = "view all", Modifier) {

        }
    }
}