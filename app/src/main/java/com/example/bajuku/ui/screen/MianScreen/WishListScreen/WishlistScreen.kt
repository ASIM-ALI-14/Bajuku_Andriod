import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.screen.MianScreen.Components.ProductCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun WishlistScreen(
    wishlist: List<Product>,
    onRemove: (Product) -> Unit
) {
    val gridState = rememberLazyGridState()

    Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {
        verticalSpacingM()
        Text(
            text = "Wish_List",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        verticalSpacingM()

        if (wishlist.isEmpty()) {
            Text("No items in wishlist")
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,

                horizontalArrangement = Arrangement.spacedBy(12.dp), // space between columns
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier,
                content = {
                    items(wishlist) { product ->
                        ProductCard(
                            product = product,
                            isFavorite = true, // always filled
                            onFavoriteClick = { onRemove(product) },
                            onClick = { /* Navigate if needed */ }
                        )
                    }
                }
            )
        }
    }
}
