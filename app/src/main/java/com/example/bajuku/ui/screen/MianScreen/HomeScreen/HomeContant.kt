package com.example.bajuku.ui.screen.MianScreen.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.BannerCarousel
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.ItemCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Accessories
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Dress
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Jacket
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Pants
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Shoes
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun HomeContant(
    onclciksearch: Boolean, searchQuery: String, navHostController: NavHostController
) {
    val tabs = listOf("Jacket", "Pants", "Shoes", "Dress", "Accessories")
    var selectedTabIndex by remember { mutableStateOf(0) }
    if (onclciksearch) {
//        SearchContant(
//            isTyping = searchQuery.isNotEmpty()
//        )
    } else {
        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .fillMaxWidth()
                            .height(1.5.dp)
                            .padding(horizontal = 8.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(70)
                            )
                    )
                },
                divider = {
                    Divider(
                        thickness = 1.2.dp,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    val isSelected = selectedTabIndex == index

                    Tab(
                        selected = isSelected,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.tertiary,
                        text = {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 1,
                                softWrap = false
                            )

                        }
                    )
                }
            }
            verticalSpacingM()
            BannerCarousel()

            when (selectedTabIndex) {
                0 -> Jacket({ navHostController.navigate("ItemDetail") })
                1 -> Pants({ navHostController.navigate("ItemDetail") })
                2 -> Shoes({ navHostController.navigate("ItemDetail") })
                3 -> Dress({ navHostController.navigate("ItemDetail") })
                4 -> Accessories({ navHostController.navigate("ItemDetail") })
            }
        }

    }
}











