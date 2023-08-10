package com.silvacomp.spacetrack.home.presentation

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.crew.presentation.CrewActivity
import com.silvacomp.spacetrack.dragons.presentation.DragonActivity
import com.silvacomp.spacetrack.home.presentation.components.InfoLaunch
import com.silvacomp.spacetrack.home.presentation.components.OptionsRowScroll
import com.silvacomp.spacetrack.launchpads.presentation.LaunchpadActivity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val latestLaunch = viewModel.stateLatestLaunch.collectAsState()
    val nextLaunch = viewModel.stateNextLaunch.collectAsState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.hellow),
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(id = R.string.launches),
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 14.sp,

            )
        Text(
            text = stringResource(id = R.string.lastlaunches),
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 14.sp,

            )

        InfoLaunch(
            title = latestLaunch.value.latestLaunch?.name ?: "error",
            flightNumber = latestLaunch.value.latestLaunch?.flightNumber ?: 0,
            image = latestLaunch.value.latestLaunch?.imageLaunch ?: "null",
            crewMembers = latestLaunch.value.latestLaunch?.numberCrewMembers ?: 0,
            date = latestLaunch.value.latestLaunch?.dateUnix ?: 0
        )

        Text(
            text = stringResource(id = R.string.nextlaunch),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            fontSize = 14.sp,

            )

        InfoLaunch(
            title = nextLaunch.value.nextLaunch?.name ?: "error",
            flightNumber = nextLaunch.value.nextLaunch?.flightNumber ?: 0,
            image = nextLaunch.value.nextLaunch?.imageLaunch ?: "null",
            crewMembers = nextLaunch.value.nextLaunch?.numberCrewMembers ?: 0,
            date = nextLaunch.value.nextLaunch?.dateUnix ?: 0
        )

        val dataList = listOf("Crew", "Dragons", "Launchpads")
        val images = listOf(R.drawable.crew,R.drawable.dragon,R.drawable.launchpad)
        val activities = listOf(Intent(context, CrewActivity::class.java),
            Intent(context, DragonActivity::class.java),
            Intent(context, LaunchpadActivity::class.java)
        )

        val pagerState = rememberPagerState()

        HorizontalPager(state = pagerState, pageCount = dataList.size) { page ->
            // Aquí defines cómo se muestra cada página.
            // Por ejemplo, un Card con un texto:
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable {
                        context.startActivity(activities[page])
                    }

            ) {
                Box(modifier = Modifier.background(Color.Black)){
                    Image(
                        painter = painterResource(id = images[page]),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Crew"
                    )
                    Text(
                        text = dataList[page],
                        style = MaterialTheme.typography.h5,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .align(Alignment.BottomCenter)
                    )
                }

            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            repeat(dataList.size) {
                val color = if (pagerState.currentPage == it) Color.Black else Color.Black.copy(
                    alpha = 0.5f
                )

                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(CircleShape)
                        .size(12.dp)
                        .background(color)
                )
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}