package com.pereyrarg11.cocktail.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun IngredientImage(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    isPreview: Boolean = LocalInspectionMode.current,
    onClickListener: () -> Unit = {},
) {
    val strokeWidth = dimensionResource(id = R.dimen.width_ingredient_filter_stroke)
    val innerModifier = modifier
        .clip(CircleShape)
        .border(
            BorderStroke(strokeWidth, MaterialTheme.colorScheme.primary),
            CircleShape
        )
        .padding(strokeWidth)
        .clickable { onClickListener() }

    if (isPreview) {
        Image(
            painter = painterResource(id = R.drawable.img_drink_demo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = innerModifier,
        )

    } else {
        GlideImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = innerModifier,
        )
    }
}