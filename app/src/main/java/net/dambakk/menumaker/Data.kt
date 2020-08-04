package net.dambakk.menumaker

import net.dambakk.menumaker.model.RecipeModel

val pannekaker = RecipeModel(
    name = "Pannekaker med bacon",
    imageUrl = null,
    duration = "30 min",
    notes = "Husk bacon",
    recipeUrl = null
)

val lasagne = RecipeModel(
    name = "Lasagne",
    imageUrl = null,
    duration = "70 min",
    notes = null,
    recipeUrl = null
)

val burger = RecipeModel(
    name = "Burger m/Bacon",
    imageUrl = null,
    duration = "10 min",
    notes = "Husk ekstra bacon",
    recipeUrl = null
)

val allRecipes = listOf(
    pannekaker,
    lasagne,
    burger
)