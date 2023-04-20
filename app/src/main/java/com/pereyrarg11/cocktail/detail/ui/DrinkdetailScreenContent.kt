package com.pereyrarg11.cocktail.detail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R

@Composable
fun DrinkDetailScreenContent(
    drinkDetail: DrinkDetailDisplayable,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(bottom = dimensionResource(id = R.dimen.size_md))
            .verticalScroll(rememberScrollState())
    ) {
        DrinkDetailImage(
            imageUrl = drinkDetail.imageUrl,
            imageCopyright = drinkDetail.imageCopyright
        )
        DrinkDetailName(title = drinkDetail.name)
        DrinkDetailSubtitle(label = stringResource(R.string.title_glass_type))
        DrinkDetailContent(label = drinkDetail.glass)
        DrinkDetailSubtitle(label = stringResource(R.string.title_ingredients))
        DrinkDetailContent(label = drinkDetail.ingredients.joinToString(separator = "\n"))
        DrinkDetailSubtitle(label = stringResource(R.string.title_preparation))
        DrinkDetailContent(label = drinkDetail.instructions)
    }
}

// TODO: center the image, some times is cut-off
// TODO: add a placeholder in order to avoid the re-sizing of screen
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DrinkDetailImage(
    imageUrl: String,
    imageCopyright: String,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (image, copyright) = createRefs()

        GlideImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
        )

        if (imageCopyright.isNotEmpty()) {
            // TODO: add a backdrop
            Text(
                text = imageCopyright,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.size_sm))
                    .constrainAs(copyright) {
                        bottom.linkTo(image.bottom)
                        end.linkTo(image.end)
                    },
            )
        }
    }
}

@Composable
fun DrinkDetailName(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier
            .padding(horizontal = dimensionResource(id = R.dimen.size_md)),
    )
}

@Composable
fun DrinkDetailSubtitle(
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.size_md))
    ) {
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.size_md)))
        Text(
            text = label,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun DrinkDetailContent(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.size_md)),
    )
}

@Preview
@Composable
fun DrinkDetailTitlePreview() {
    DrinkDetailName("Gluehwein")
}