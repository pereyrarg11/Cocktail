package com.pereyrarg11.cocktail.data

interface Converter<Input, Output> {

    fun convert(input: Input): Output
}