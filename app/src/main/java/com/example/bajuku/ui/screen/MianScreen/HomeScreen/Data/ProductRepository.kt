package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data

import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product

object ProductRepository {

    val allProducts =
        JacketProducts +
                PantsProducts +
                DressProducts +
                ShoesProducts +
                accessoriesProducts
    // + shoes + pants

    fun getProductById(productId: String): Product {
        return allProducts.first { it.id == productId }
    }

    fun getRelatedProducts(category: String, excludeId: String): List<Product> {
        return allProducts
            .filter { it.category == category && it.id != excludeId }
            .take(2)
    }
}
