package com.pereyrarg11.cocktail.detail.data.repository.model.content

enum class AlcoholDrinkCategory(val description: String) {
    ALCOHOLIC("Alcoholic"),
    NON_ALCOHOLIC("Non alcoholic"),
    OPTIONAL_ALCOHOL("Optional alcohol"),
    UNKNOWN("");

    companion object {
        fun from(description: String): AlcoholDrinkCategory =
            values().firstOrNull { it.description.equals(description, true) } ?: UNKNOWN
    }
}