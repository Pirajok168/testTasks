package com.example.testtasks

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.example.testtasks.ui.theme.TestTasksTheme
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun ItemBestSeller(
    imgUrl: String,
    price: String,
    oldPrice: String? = null,
    nameModel: String,
    onClick: () -> Unit,
    onFavorite: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.size(width = 173.dp, height = 227.dp),
        elevation = 40.dp,
        shape = RoundedCornerShape(10)
    ) {
        val isFavorite = remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp)
                .padding(bottom = 15.dp)
            ,
            contentAlignment = Alignment.Center){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                GlideImage(
                    modifier = Modifier
                        .size(width = 181.dp, height = 168.dp),
                    imageModel = imgUrl,
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator()
                    },
                    failure = {
                        CircularProgressIndicator()
                    }
                )

                Row(
                   horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Text(
                        text = price,
                        fontWeight = FontWeight(700),
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.alignByBaseline()
                    )
                    if (oldPrice != null){
                        Text(
                            text = oldPrice,
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            color = Color.LightGray,
                            modifier = Modifier.alignByBaseline()
                        )
                    }
                }
            
                Spacer(modifier = Modifier.size(5.dp))
                
                Text(
                    text = nameModel,
                    fontWeight = FontWeight(400),
                    fontSize = 10.sp,
                    color = MaterialTheme.colors.primary,

                )

            }
            Box(
                modifier = Modifier.fillMaxSize().padding(end = 4.dp, top = 8.dp),
                contentAlignment = Alignment.TopEnd){
                Surface(
                    modifier = Modifier.size(25.dp),
                    elevation = 20.dp,
                    shape = CircleShape
                ) {
                    IconToggleButton(
                        checked = isFavorite.value,
                        onCheckedChange = {
                            isFavorite.value = !isFavorite.value
                        },

                    ) {
                        val tint by animateColorAsState(if (isFavorite.value) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            modifier = Modifier.padding(7.dp),
                            tint = tint
                        )
                    }
                }
            }

        }

    }
}


