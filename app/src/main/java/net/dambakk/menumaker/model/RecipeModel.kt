package net.dambakk.menumaker.model

data class RecipeModel(
    val name: String,
    val imageUrl: String?,
    val duration: String,
    val notes: String?,
    val recipeUrl: String?
)