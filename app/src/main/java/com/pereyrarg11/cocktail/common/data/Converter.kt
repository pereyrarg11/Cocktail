package com.pereyrarg11.cocktail.common.data

interface Converter<Input, Output> {

    fun convert(input: Input): Output
}