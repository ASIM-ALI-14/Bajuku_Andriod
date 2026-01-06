package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data


import com.example.bajuku.R
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.ItemDetails
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product


// Accessories
val DressProducts = listOf(
    Product(
        id = "dress_1",
        name = "Winter Hooded Jacket",
        originalPrice = "IDR 280.000",
        discountedPrice = "IDR 210.000",
        image = R.drawable.dress_1,
        category = "Dress",
        description = "A warm hooded jacket suitable for winter dresses.",
        itemDetails = ItemDetails(
            category = "Winter Dress",
            color = "Black",
            madeIn = "Japan",
            material = "Polyester"
        ),
        rating = 4.7,
        reviewsCount = 98
    ),
    Product(
        id = "dress_2",
        name = "Elegant Winter Dress",
        originalPrice = "IDR 500.000",
        discountedPrice = "IDR 400.000",
        image = R.drawable.dress_2,
        category = "Dress",
        description = "Elegant winter dress with premium fabric.",
        itemDetails = ItemDetails(
            category = "Formal Dress",
            color = "Red",
            madeIn = "Italy",
            material = "Wool Blend"
        ),
        rating = 4.6,
        reviewsCount = 76
    ),
    Product(
        id = "dress_3",
        name = "Classic Long Dress",
        originalPrice = "IDR 450.000",
        discountedPrice = "IDR 380.000",
        image = R.drawable.dress_2,
        category = "Dress",
        description = "Classic long dress for special occasions.",
        itemDetails = ItemDetails(
            category = "Classic Dress",
            color = "Blue",
            madeIn = "France",
            material = "Cotton Blend"
        ),
        rating = 4.5,
        reviewsCount = 64
    ),
    Product(
        id = "dress_4",
        name = "Stylish Party Dress",
        originalPrice = "IDR 700.000",
        discountedPrice = "IDR 650.000",
        image = R.drawable.dress_1,
        category = "Dress",
        description = "Stylish dress perfect for evening parties.",
        itemDetails = ItemDetails(
            category = "Party Dress",
            color = "Green",
            madeIn = "UK",
            material = "Silk Blend"
        ),
        rating = 4.8,
        reviewsCount = 112
    ),
    Product(
        id = "dress_5",
        name = "Modern Casual Dress",
        originalPrice = "IDR 600.000",
        discountedPrice = "IDR 550.000",
        image = R.drawable.dress_1,
        category = "Dress",
        description = "Modern casual dress for daily wear.",
        itemDetails = ItemDetails(
            category = "Casual Dress",
            color = "Beige",
            madeIn = "Korea",
            material = "Cotton"
        ),
        rating = 4.4,
        reviewsCount = 53
    ),
    Product(
        id = "dress_6",
        name = "Luxury Evening Dress",
        originalPrice = "IDR 900.000",
        discountedPrice = "IDR 800.000",
        image = R.drawable.dress_1,
        category = "Dress",
        description = "Luxury evening dress with premium finishing.",
        itemDetails = ItemDetails(
            category = "Evening Dress",
            color = "Black",
            madeIn = "USA",
            material = "Velvet"
        ),
        rating = 4.9,
        reviewsCount = 145
    )
)

val JacketProducts = listOf(
    Product(
        id = "jacket_1",
        name = "Seamless Down Parka",
        originalPrice = "IDR 300.000",
        discountedPrice = "IDR 240.000",
        image = R.drawable.jacket_1,
        category = "Jacket",
        description = "A seamless down parka designed for cold weather.",
        itemDetails = ItemDetails(
            category = "Jacket & Hoodies",
            color = "Cream",
            madeIn = "Australia",
            material = "Fleece"
        ),
        rating = 4.9,
        reviewsCount = 154
    ),
    Product(
        id = "jacket_2",
        name = "Winter Jacket",
        originalPrice = "IDR 500.000",
        discountedPrice = "IDR 400.000",
        image = R.drawable.jacket_2,
        category = "Jacket",
        description = "Warm winter jacket with premium insulation.",
        itemDetails = ItemDetails(
            category = "Jacket & Hoodies",
            color = "Black",
            madeIn = "Japan",
            material = "Polyester"
        ),
        rating = 4.8,
        reviewsCount = 121
    ),
    Product(
        id = "jacket_3",
        name = "Classic Coat",
        originalPrice = "IDR 450.000",
        discountedPrice = "IDR 380.000",
        image = R.drawable.jacket_3,
        category = "Jacket",
        description = "Classic long coat for formal and casual wear.",
        itemDetails = ItemDetails(
            category = "Coat",
            color = "Brown",
            madeIn = "Italy",
            material = "Wool"
        ),
        rating = 4.7,
        reviewsCount = 98
    ),
    Product(
        id = "jacket_4",
        name = "Stylish Coat",
        originalPrice = "IDR 700.000",
        discountedPrice = "IDR 650.000",
        image = R.drawable.jacket_4,
        category = "Jacket",
        description = "Modern stylish coat with premium finish.",
        itemDetails = ItemDetails(
            category = "Coat",
            color = "Grey",
            madeIn = "France",
            material = "Cashmere Blend"
        ),
        rating = 4.9,
        reviewsCount = 143
    ),
    Product(
        id = "jacket_5",
        name = "Modern Jacket",
        originalPrice = "IDR 600.000",
        discountedPrice = "IDR 550.000",
        image = R.drawable.jacket_2,
        category = "Jacket",
        description = "Lightweight modern jacket for daily wear.",
        itemDetails = ItemDetails(
            category = "Jacket",
            color = "Navy",
            madeIn = "Korea",
            material = "Nylon"
        ),
        rating = 4.6,
        reviewsCount = 88
    ),
    Product(
        id = "jacket_6",
        name = "Leather Jacket",
        originalPrice = "IDR 900.000",
        discountedPrice = "IDR 800.000",
        image = R.drawable.jacket_4,
        category = "Jacket",
        description = "Premium leather jacket with durable finish.",
        itemDetails = ItemDetails(
            category = "Leather Jacket",
            color = "Black",
            madeIn = "USA",
            material = "Genuine Leather"
        ),
        rating = 4.9,
        reviewsCount = 167
    )
)

val PantsProducts = listOf(
    Product(
        id = "pant_1",
        name = "Slim Fit Winter Pants",
        originalPrice = "IDR 300.000",
        discountedPrice = "IDR 240.000",
        image = R.drawable.pant_1,
        category = "Pants",
        description = "Slim fit winter pants designed for comfort and warmth.",
        itemDetails = ItemDetails(
            category = "Winter Pants",
            color = "Black",
            madeIn = "Korea",
            material = "Cotton Blend"
        ),
        rating = 4.6,
        reviewsCount = 82
    ),
    Product(
        id = "pant_2",
        name = "Classic Formal Pants",
        originalPrice = "IDR 500.000",
        discountedPrice = "IDR 400.000",
        image = R.drawable.pant_2,
        category = "Pants",
        description = "Classic formal pants suitable for office and events.",
        itemDetails = ItemDetails(
            category = "Formal Pants",
            color = "Grey",
            madeIn = "Italy",
            material = "Wool Blend"
        ),
        rating = 4.7,
        reviewsCount = 91
    ),
    Product(
        id = "pant_3",
        name = "Casual Cotton Pants",
        originalPrice = "IDR 450.000",
        discountedPrice = "IDR 380.000",
        image = R.drawable.pant_3,
        category = "Pants",
        description = "Casual cotton pants for daily wear.",
        itemDetails = ItemDetails(
            category = "Casual Pants",
            color = "Navy",
            madeIn = "India",
            material = "Cotton"
        ),
        rating = 4.5,
        reviewsCount = 67
    ),
    Product(
        id = "pant_4",
        name = "Stylish Cargo Pants",
        originalPrice = "IDR 700.000",
        discountedPrice = "IDR 650.000",
        image = R.drawable.pant_4,
        category = "Pants",
        description = "Stylish cargo pants with multiple pockets.",
        itemDetails = ItemDetails(
            category = "Cargo Pants",
            color = "Olive",
            madeIn = "China",
            material = "Twill"
        ),
        rating = 4.8,
        reviewsCount = 119
    ),
    Product(
        id = "pant_5",
        name = "Modern Jogger Pants",
        originalPrice = "IDR 600.000",
        discountedPrice = "IDR 550.000",
        image = R.drawable.pant_3,
        category = "Pants",
        description = "Modern jogger pants for active lifestyle.",
        itemDetails = ItemDetails(
            category = "Joggers",
            color = "Dark Grey",
            madeIn = "Vietnam",
            material = "Poly Cotton"
        ),
        rating = 4.4,
        reviewsCount = 58
    ),
    Product(
        id = "pant_6",
        name = "Premium Leather Pants",
        originalPrice = "IDR 900.000",
        discountedPrice = "IDR 800.000",
        image = R.drawable.pant_4,
        category = "Pants",
        description = "Premium leather pants with luxury finish.",
        itemDetails = ItemDetails(
            category = "Leather Pants",
            color = "Black",
            madeIn = "USA",
            material = "Genuine Leather"
        ),
        rating = 4.9,
        reviewsCount = 134
    )
)

val ShoesProducts = listOf(
    Product(
        id = "shoes_1",
        name = "Winter Sneakers",
        originalPrice = "IDR 300.000",
        discountedPrice = "IDR 240.000",
        image = R.drawable.shoes_1,
        category = "Shoes",
        description = "Comfortable winter sneakers for daily use.",
        itemDetails = ItemDetails(
            category = "Sneakers",
            color = "White",
            madeIn = "Vietnam",
            material = "Synthetic Leather"
        ),
        rating = 4.6,
        reviewsCount = 88
    ),
    Product(
        id = "shoes_2",
        name = "Classic Leather Shoes",
        originalPrice = "IDR 500.000",
        discountedPrice = "IDR 400.000",
        image = R.drawable.shoes_2,
        category = "Shoes",
        description = "Classic leather shoes for formal occasions.",
        itemDetails = ItemDetails(
            category = "Formal Shoes",
            color = "Brown",
            madeIn = "Italy",
            material = "Leather"
        ),
        rating = 4.8,
        reviewsCount = 102
    ),
    Product(
        id = "shoes_3",
        name = "Casual Walking Shoes",
        originalPrice = "IDR 450.000",
        discountedPrice = "IDR 380.000",
        image = R.drawable.shoes_3,
        category = "Shoes",
        description = "Lightweight shoes designed for walking.",
        itemDetails = ItemDetails(
            category = "Casual Shoes",
            color = "Blue",
            madeIn = "China",
            material = "Mesh Fabric"
        ),
        rating = 4.5,
        reviewsCount = 71
    ),
    Product(
        id = "shoes_4",
        name = "Stylish Boots",
        originalPrice = "IDR 700.000",
        discountedPrice = "IDR 650.000",
        image = R.drawable.shoes_4,
        category = "Shoes",
        description = "Stylish boots suitable for winter outfits.",
        itemDetails = ItemDetails(
            category = "Boots",
            color = "Black",
            madeIn = "Germany",
            material = "Leather"
        ),
        rating = 4.9,
        reviewsCount = 143
    ),
    Product(
        id = "shoes_5",
        name = "Modern Sport Shoes",
        originalPrice = "IDR 600.000",
        discountedPrice = "IDR 550.000",
        image = R.drawable.shoes_4,
        category = "Shoes",
        description = "Sport shoes designed for comfort and flexibility.",
        itemDetails = ItemDetails(
            category = "Sports Shoes",
            color = "Grey",
            madeIn = "Indonesia",
            material = "Rubber & Mesh"
        ),
        rating = 4.4,
        reviewsCount = 65
    ),
    Product(
        id = "shoes_6",
        name = "Premium Leather Boots",
        originalPrice = "IDR 900.000",
        discountedPrice = "IDR 800.000",
        image = R.drawable.shoes_1,
        category = "Shoes",
        description = "Premium leather boots with durable sole.",
        itemDetails = ItemDetails(
            category = "Leather Boots",
            color = "Dark Brown",
            madeIn = "USA",
            material = "Genuine Leather"
        ),
        rating = 4.9,
        reviewsCount = 156
    )
)

val accessoriesProducts = listOf(
    Product(
        id = "access_1",
        name = "Winter Wool Scarf",
        originalPrice = "IDR 300.000",
        discountedPrice = "IDR 240.000",
        image = R.drawable.acess_1,
        category = "Accessories",
        description = "Warm wool scarf for winter season.",
        itemDetails = ItemDetails(
            category = "Scarf",
            color = "Grey",
            madeIn = "UK",
            material = "Wool"
        ),
        rating = 4.5,
        reviewsCount = 60
    ),
    Product(
        id = "access_2",
        name = "Leather Hand Gloves",
        originalPrice = "IDR 500.000",
        discountedPrice = "IDR 400.000",
        image = R.drawable.acess_2,
        category = "Accessories",
        description = "Premium leather gloves for cold weather.",
        itemDetails = ItemDetails(
            category = "Gloves",
            color = "Black",
            madeIn = "Italy",
            material = "Leather"
        ),
        rating = 4.7,
        reviewsCount = 83
    ),
    Product(
        id = "access_3",
        name = "Classic Winter Cap",
        originalPrice = "IDR 450.000",
        discountedPrice = "IDR 380.000",
        image = R.drawable.acess_1,
        category = "Accessories",
        description = "Classic cap designed to keep you warm.",
        itemDetails = ItemDetails(
            category = "Cap",
            color = "Navy",
            madeIn = "Canada",
            material = "Knitted Wool"
        ),
        rating = 4.4,
        reviewsCount = 49
    ),
    Product(
        id = "access_4",
        name = "Stylish Sunglasses",
        originalPrice = "IDR 700.000",
        discountedPrice = "IDR 650.000",
        image = R.drawable.acess_2,
        category = "Accessories",
        description = "Stylish sunglasses with UV protection.",
        itemDetails = ItemDetails(
            category = "Sunglasses",
            color = "Black",
            madeIn = "France",
            material = "Polycarbonate"
        ),
        rating = 4.8,
        reviewsCount = 132
    ),
    Product(
        id = "access_5",
        name = "Modern Wrist Watch",
        originalPrice = "IDR 600.000",
        discountedPrice = "IDR 550.000",
        image = R.drawable.acess_2,
        category = "Accessories",
        description = "Modern wrist watch with minimalist design.",
        itemDetails = ItemDetails(
            category = "Watch",
            color = "Silver",
            madeIn = "Japan",
            material = "Stainless Steel"
        ),
        rating = 4.6,
        reviewsCount = 97
    ),
    Product(
        id = "access_6",
        name = "Luxury Leather Belt",
        originalPrice = "IDR 900.000",
        discountedPrice = "IDR 800.000",
        image = R.drawable.acess_2,
        category = "Accessories",
        description = "Luxury leather belt with premium buckle.",
        itemDetails = ItemDetails(
            category = "Belt",
            color = "Brown",
            madeIn = "USA",
            material = "Genuine Leather"
        ),
        rating = 4.9,
        reviewsCount = 141
    )
)
