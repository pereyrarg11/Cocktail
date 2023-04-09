package com.pereyrarg11.cocktail.categories.alcoholic.ui

import androidx.lifecycle.ViewModel
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import javax.inject.Inject

class AlcoholicViewModel @Inject constructor() : ViewModel() {

    val cocktailList: List<CocktailModel>
        get() = listOf(
            CocktailModel(
                name = "Applejack",
                thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/sutyqp1479209062.jpg",
                id = "16311"
            ),
            CocktailModel(
                name = "Margarita",
                thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                id = "11007"
            ),
            CocktailModel(
                name = "Mojito",
                thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg",
                id = "11000"
            ),
        )
}