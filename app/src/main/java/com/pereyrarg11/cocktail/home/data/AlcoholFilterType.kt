package com.pereyrarg11.cocktail.home.data

enum class AlcoholFilterType(val query: String) {
    ALCOHOLIC("Alcoholic"),
    NON_ALCOHOLIC("Non_Alcoholic"),
    OPTIONAL_ALCOHOL("Optional_alcohol"),
    UNKNOWN("");
}