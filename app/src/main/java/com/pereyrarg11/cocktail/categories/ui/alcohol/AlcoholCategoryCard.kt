package com.pereyrarg11.cocktail.categories.ui.alcohol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.CategoryType
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AlcoholCategoryCard(
    category: CategoryItemDisplayable,
    modifier: Modifier = Modifier,
    onClickListener: (CategoryType) -> Unit = {},
    isPreview: Boolean = LocalInspectionMode.current
) {
    Card(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.width_alcohol_category))
            .height(dimensionResource(id = R.dimen.height_alcohol_category))
            .clickable {
                onClickListener(category.categoryType)
            }
    ) {
        Box {
            val label = stringResource(id = category.labelResource)

            if (isPreview) {
                Image(
                    painter = painterResource(id = R.drawable.img_drink_demo),
                    contentDescription = label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize(),
                )
            } else {
                GlideImage(
                    model = category.imageUrl,
                    contentDescription = label,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize(),
                )
            }

            Text(
                text = label,
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            0f to Color.Transparent,
                            .5f to Color.Black.copy(alpha = 0.5f),
                            1f to Color.Black.copy(alpha = 0.8f)
                        )
                    )
                    .padding(
                        start = dimensionResource(id = R.dimen.size_sm),
                        end = dimensionResource(id = R.dimen.size_sm),
                        top = dimensionResource(id = R.dimen.size_lg),
                        bottom = dimensionResource(id = R.dimen.size_md)
                    ),
            )
        }
    }
}

@Preview
@Composable
fun AlcoholCardPreview() {
    CocktailPreview {
        AlcoholCategoryCard(
            category = CategoryItemDisplayable(R.string.title_category_non_alcoholic)
        )
    }
}