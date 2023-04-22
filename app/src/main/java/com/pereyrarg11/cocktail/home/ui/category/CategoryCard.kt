package com.pereyrarg11.cocktail.home.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryCard(
    model: CategoryDisplayable,
    modifier: Modifier = Modifier,
    isPreview: Boolean = LocalInspectionMode.current,
    onClickListener: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.width_category_filter_card))
            .clickable {
                onClickListener()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize(),
        ) {
            val label = stringResource(id = model.labelResource)

            if (isPreview) {
                Image(
                    painter = painterResource(id = R.drawable.img_drink_demo),
                    contentDescription = label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.height_category_filter_card)),
                )

            } else {
                GlideImage(
                    model = model.imageUrl,
                    contentDescription = label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.height_category_filter_card)),
                )
            }

            CategoryText(label = label)
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    CategoryCard(
        model = CategoryDisplayable(
            labelResource = R.string.title_category_filter_coffee_and_tea,
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg",
            type = CategoryFilterType.COFFEE_AND_TEA,
        )
    )
}