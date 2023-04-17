package com.pereyrarg11.cocktail.detail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R

@Composable
fun DrinkDetailScreen(
    cocktailId: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val drinkDetail = getDrinkDetailDisplayable()

    Scaffold(
        topBar = { DrinkDetailAppBar(navController) },
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkDetailAppBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.title_drink))
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.action_back)
                )
            }
        },
    )
}

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
    DrinkDetailName(getDrinkDetailDisplayable().name)
}

fun getDrinkDetailDisplayable(): DrinkDetailDisplayable {
    // https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=12944
    return DrinkDetailDisplayable(
        name = "Gluehwein",
        alcohol = "Optional alcohol",
        category = "Punch / Party Drink",
        glass = "Irish coffee cup",
        imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
        imageCopyright = "Getty",
        ingredients = listOf(
            "Red wine (1 L)",
            "Water (125 ml)",
            "Sugar (60 gr)",
            "Cinnamon (1)",
            "Cloves (3)",
            "Lemon peel (1 tblsp)",
        ),
        instructions = "Boil sugar and spices in water, leave in the water for 30 minutes. Strain the spiced water and mix with the wine. Heat slowly until short of boiling temperature. (To remove alcohol, let it boil for a while.) You may add lemon or orange juice to taste. Serve in irish coffee cup.",
    )
}