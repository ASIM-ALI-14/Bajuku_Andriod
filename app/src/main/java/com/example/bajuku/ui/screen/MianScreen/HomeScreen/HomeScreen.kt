package com.example.bajuku.ui.screen.MianScreen.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.BannerCarousel
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.bannerList
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.getHomeTabs
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = getHomeTabs(navHostController)

    Column(modifier = Modifier.fillMaxWidth()) {
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .padding(horizontal = 10.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(90)
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
            tabs.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier
                        .height(58.dp)
                        .width(34.dp)
                        .zIndex(2f),

                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.tertiary,
                    text = {
                        Text(
                            text = tab.title,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                )
            }
        }

        verticalSpacingM()
        BannerCarousel(bannerList)

        // Render selected tab content dynamically
        tabs[selectedTabIndex].content()
    }
}












