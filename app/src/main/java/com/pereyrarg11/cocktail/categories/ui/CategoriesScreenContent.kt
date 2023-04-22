package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.CategoryType
import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType
import com.pereyrarg11.cocktail.categories.ui.alcohol.AlcoholCategoryRow
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@Composable
fun CategoriesScreenContent(
    categoryWrapperList: List<CategoryWrapperDisplayable>,
    modifier: Modifier = Modifier,
    onItemClickListener: (CategoryType) -> Unit = {},
) {
    Column(modifier = modifier) {
        categoryWrapperList.forEach { wrapper ->
            CategoryRow(label = stringResource(id = wrapper.labelResource)) {
                when (wrapper.type) {
                    CategoryWrapperType.ALCOHOL -> {
                        AlcoholCategoryRow(
                            categories = wrapper.items,
                            onItemClickListener = onItemClickListener,
                        )
                    }
                    else -> {}
                }
            }
        }

        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.size_md)))
    }
}

@Preview
@Composable
fun CategoriesScreenContentPreview() {
    CocktailPreview {
        CategoriesScreenContent(
            categoryWrapperList = listOf(
                CategoryWrapperDisplayable(
                    labelResource = R.string.title_category_wrapper_alcohol,
                    type = CategoryWrapperType.ALCOHOL,
                    items = listOf(
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                        ),
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_non_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
                        ),
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_alcohol_optional,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
                        )
                    )
                )
            )
        )
    }
}
