package com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens

import com.example.bajuku.R

data class Product(
    val id: Int,
    val imageRes: Int,
    val isOnSale: Boolean = false,
    val isBestSeller: Boolean = false
)

data class CategorySection(
    val title: String,
    val showSeeAll: Boolean = true,
    val products: List<Product>
)

val accessoriesSections = listOf(
    CategorySection(
        title = "New Arrival",
        products = listOf(
            Product(
                id = 1,
                imageRes = R.drawable.acess_1,
                isOnSale = true,
                isBestSeller = true
            ),
            Product(
                id = 2,
                imageRes = R.drawable.acess_2,
                isOnSale = true
            )
        )
    ),
    CategorySection(
        title = "Recommendation",
        products = listOf(
            Product(
                id = 3,
                imageRes = R.drawable.acess_2,
                isBestSeller = true
            ),
            Product(
                id = 4,
                imageRes = R.drawable.acess_1
            )
        )
    ),
    CategorySection(
        title = "Popular Jacket",
        products = listOf(
            Product(
                id = 5,
                imageRes = R.drawable.acess_2
            ),
            Product(
                id = 6,
                imageRes = R.drawable.acess_1
            )
        )
    )
)
