package com.pereyrarg11.cocktail.categories.data

/**
 * List of all filters that can be used to list drinks.
 * Alcohol subcategories are flattened in the list.
 */
enum class CategoryType {
    ALCOHOLIC,
    NON_ALCOHOLIC,
    ALCOHOL_OPTIONAL,
    OTHER,
}