package com.example.coilproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coilproject.data.ImageItem
import com.example.coilproject.ui.components.AppImageLoader


@Composable
fun ImageFeedScreen(items:List<ImageItem>)
{
    LazyColumn (
        modifier=Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        )

    {
        items(items){
            item->ImageListItem(item=item)
        }

    }

}

@Composable
fun ImageListItem(item: ImageItem)
{
    Column(modifier=Modifier.fillMaxSize()) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        AppImageLoader(
            imageUrl = item.url,
            contentDescription=item.title,

            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)

        )
    }
}



