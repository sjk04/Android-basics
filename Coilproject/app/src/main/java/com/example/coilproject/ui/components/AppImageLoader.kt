package com.example.coilproject.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.ImageLoader
import coil.decode.SvgDecoder
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import com.example.coilproject.R

@Composable
fun AppImageLoader(
    imageUrl: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val imageLoader = remember {
        ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build(),
        imageLoader = imageLoader,
        placeholder = painterResource(R.drawable.img),
        error = painterResource(R.drawable.errorimage),
        contentDescription = contentDescription,
        modifier = modifier
    )
}


























