package com.example.bajuku.ui.screen.MianScreen.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Restore
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bajuku.R
import com.example.bajuku.ui.components.SearchField
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS
import com.example.bajuku.ui.theme.verticalSpacingXS


data class SearchSuggestion(val title: String, val reviewCount: Int)
data class TopProduct(val title: String, val subtitle: String, val imageRes: Int)
data class RecentSearch(val title: String)
data class RelatedSearch(val line1: String, val line2: String, val imageRes: Int)
@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }

    // Sample data
    val suggestions = listOf(
        SearchSuggestion("Seamless", 12),
        SearchSuggestion("Superstar Shoes", 12),
        SearchSuggestion("Seamless", 12),
        SearchSuggestion("Superstar Shoes", 12)
    )

    val topProducts = List(4) {
        TopProduct("Seamless Down Parka", "Jacket (334 stock)", R.drawable.jacket_2)
    }

    val recentSearchesInitial = listOf(
        RecentSearch("Superstar Shoes"),
        RecentSearch("Reusable Tote Bag (Medium)"),
        RecentSearch("Adi break Pants")
    )
    var recentSearches by remember { mutableStateOf(recentSearchesInitial) }

    val relatedSearches = List(4) {
        RelatedSearch("Seamless Down", "Parka", R.drawable.jacket_2)
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = screenHorizontal, vertical = 5.dp)
                    .systemBarsPadding()
            ) {
                SearchField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    keyboardType = KeyboardType.Text,
                    placeholder = "Search or tab",
                    leadingIcon = Icons.Filled.Search,
                    Background = Color.Transparent,
                    border = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFFAFAFA))
                .verticalScroll(rememberScrollState())
        ) {

            HorizontalDivider(
                thickness = 1.4.dp,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            verticalSpacingM()

            if (!searchQuery.isEmpty()) {
                // Empty search state
                SearchEmptyState(suggestions, topProducts, relatedSearches)
            } else {
                // Show recent search state
                SearchResultState(recentSearches) { item ->
                    recentSearches = recentSearches - item
                }
            }
            verticalSpacingEXL()
        }
    }
}

@Composable
private fun SearchEmptyState(
    suggestions: List<SearchSuggestion>,
    topProducts: List<TopProduct>,
    relatedSearches: List<RelatedSearch>
) {
    Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {

        // Suggestions
        suggestions.forEach {
            SearchContantRow(it.title, it.reviewCount)
            verticalSpacingXS()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            verticalSpacingS()
        }

        // Top Products
        SectionHeader("Top Product")
        topProducts.forEach {
            TopSearchRow(it)
            verticalSpacingS()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            verticalSpacingS()
        }

        // Related Searches
        SectionHeader("Related Search")
        relatedSearches.chunked(2).forEach { row ->
            Row {
                row.forEach { _ ->
                    RelatedRow()
                    HorizontalSpacingS()
                }
            }
            verticalSpacingS()
        }
    }
}

@Composable
private fun SearchResultState(
    recentSearches: List<RecentSearch>,
    onClear: (RecentSearch) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {

        SectionHeader("Recent Search", "Remove All")

        recentSearches.forEach { item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {}
                ) {
                    Icon(
                        Icons.Outlined.Restore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    HorizontalSpacingS()
                    Text(
                        item.title,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { onClear(item) }) {
                    Icon(
                        Icons.Outlined.Clear,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        verticalSpacingM()

        Text(
            text = "View all search history (${recentSearches.size})",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium,
            color = AppColors.Blur20
        )
    }
}

@Composable
fun SectionHeader(title: String, actionText: String? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
        actionText?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
    verticalSpacingM()
}
@Composable
fun SearchContantRow(text: String, num: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            Text(text, style = MaterialTheme.typography.labelLarge)
            Text("${num} review", fontSize = 10.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Outlined.ArrowOutward, contentDescription = null)
        }
    }
}

@Composable
fun TopSearchRow(item: TopProduct) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        HorizontalSpacingM()
        Column {
            Text(item.title, style = MaterialTheme.typography.labelLarge)
            verticalSpacingXS()
            Text(item.subtitle, style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun RelatedRow() {
    Row(
        modifier = Modifier
            .background(Color(0xFFF5F5F5), RoundedCornerShape(10.dp))
            .padding(end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.jacket_2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 5.dp,
                        0.dp,
                        bottomStart = 5.dp,
                        bottomEnd = 0.dp
                    )
                )
        )
        HorizontalSpacingS()
        Column() {
            Text(
                text = "Seamless Down",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Parka", style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
