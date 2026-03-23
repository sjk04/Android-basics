package com.example.coilproject.util

import androidx.compose.ui.res.painterResource
import com.example.coilproject.R
import com.example.coilproject.data.ImageItem

object SampleDataProvider {
    fun getSampleImages(): List<ImageItem> {
        return listOf(
            ImageItem(
                id = 1,
                title = "1st image",
                url = "https://static.vecteezy.com/system/resources/thumbnails/057/068/323/small/single-fresh-red-strawberry-on-table-green-background-food-fruit-sweet-macro-juicy-plant-image-photo.jpg"
            ),
            ImageItem(
                id = 2,
                title = "2nd image",
                url = null
            ),
            ImageItem(
                id = 3,
                title = "3rd image",
                url = "https://static.vecteezy.com/vite/assets/photo-masthead-375-BoK_p8LG.webp"

            ),
            ImageItem(
                id = 4,
                title = "4th image",
                url = "https://images.panda.org/assets/images/pages/welcome/orangutan_1600x1000_279157.jpg"

            ),
            ImageItem(
                id = 5,
                title = "5th image",
                url = "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/android.svg"

            ),
            ImageItem(
                id = 6,
                title = "6th image",
                url = "android.resource://com.example.coilproject/${R.drawable.alien_svgrepo_com}"
            )





        )
    }
}