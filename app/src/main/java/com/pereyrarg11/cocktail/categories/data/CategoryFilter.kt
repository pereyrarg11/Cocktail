package com.pereyrarg11.cocktail.categories.data

// TODO: can be renamed to CategoryType
/**
 * List of all filters that can be used to list drinks.
 * Alcohol subcategories are flattened in the list.
 */
enum class CategoryFilter(val query: String) {
    ALCOHOLIC("Alcoholic"),
    NON_ALCOHOLIC("Non_Alcoholic"),
    ALCOHOL_OPTIONAL("Optional_alcohol"),
    OTHER("Other_/_Unknown");
}