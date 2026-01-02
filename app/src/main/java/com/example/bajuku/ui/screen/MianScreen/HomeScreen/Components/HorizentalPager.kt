package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.BannerUiModel
import com.example.bajuku.ui.theme.verticalSpacingXS
import kotlin.math.absoluteValue


//@Preview
//@Composable
//fun BannerCard() {
//    Card() {
//        Box(modifier = Modifier.fillMaxWidth()) {
//            Image(
//                painter = painterResource(R.drawable.banner_1),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {
//                Spacer(modifier = Modifier.height(68.dp))
//                Text(
//                    text = "New Season Essential",
//                    style = MaterialTheme.typography.labelLarge,
//                    fontWeight = FontWeight.SemiBold,
//                    color = MaterialTheme.colorScheme.background,
//                    lineHeight = 12.sp
//                )
//                Text(
//                    text = "Discount Up to 50% off",
//                    style = MaterialTheme.typography.headlineSmall,
//                    fontWeight = FontWeight.SemiBold,
//                    color = MaterialTheme.colorScheme.background
//                )
//                verticalSpacingS()
//                SelectedButton(
//                    "Get it Now",
//                    {},
//                    modifier = Modifier,
//                    selected = true,
//                    bg = MaterialTheme.colorScheme.background,
//                    contantcolor = MaterialTheme.colorScheme.primary,
//                    35.dp
//                )
//
//            }
//        }
//    }
//}

@Composable
fun BannerCarousel(
    banners: List<BannerUiModel>,
    onCtaClick: (BannerUiModel) -> Unit = {}
) {

    val realCount = banners.size
    val startIndex = Int.MAX_VALUE / 2
    val initialPage = startIndex - (startIndex % realCount)

    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { Int.MAX_VALUE }
    )


    Column {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 17.dp)
        ) { page ->

            val realPage = page % realCount

            Card(
                modifier = Modifier
                    .padding(horizontal = 6.dp)   // 👈 space between cards
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) +
                                    pagerState.currentPageOffsetFraction)
                                .absoluteValue
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Image(
                        painter = painterResource(banners[realPage].imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.BottomStart)
                    ) {
                        Text(
                            text = banners[realPage].title,
                            color = Color.White,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = banners[realPage].subtitle,
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        verticalSpacingXS()
                        PrimaryButton(
                            banners[realPage].ctaText,
                            {},
                            modifier = Modifier,
                            isSelected = true,
                            height = 35.dp,
                            width = 100.dp
                        )

                    }
                }
            }
        }

        // Indicator (uses real index)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(realCount) { index ->
                val currentRealPage = pagerState.currentPage % realCount
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (currentRealPage == index) 10.dp else 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (currentRealPage == index)
                                Color.DarkGray
                            else
                                Color.LightGray
                        )
                )
            }
        }
    }
}

