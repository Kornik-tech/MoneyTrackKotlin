package com.example.moneytrack.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.moneytrack.R
import com.example.moneytrack.ui.theme.MoneyTrackTheme
import com.example.moneytrack.widgets.CustomGlassSurface

@Composable
fun HomeScreen(navController: NavController) {
    val isFemale = remember { mutableStateOf(false) }
    val name = remember { mutableStateOf("Kornel") }

    Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Header(isFemale, name)

        UpcomingBill()

        TotalBalance()

        IncomeAndSpend()
    }
}

@Composable
fun IncomeAndSpend() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomGlassSurface(modifier = Modifier.width(170.dp)) {
            Column(modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 25.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color(0xFF34D399).copy(alpha = 0.3f))
                            .padding(8.dp),
                        imageVector = Icons.Default.ArrowDownward,
                        contentDescription = "Income",
                        tint = Color(0xFF34D399)
                    )

                    Row(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xFF34D399).copy(alpha = 0.3f))
                            .padding(end = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropUp,
                            contentDescription = "Income",
                            tint = Color(0xFF34D399)
                        )
                        Text(
                            text = "12%",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 14.sp,
                                color = Color(0xFF34D399)
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Income", style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "$4,200", style = MaterialTheme.typography.titleMedium)
            }
        }
        CustomGlassSurface(modifier = Modifier.width(170.dp)) {
            Column(modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 25.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color(0xFFEF4444).copy(alpha = 0.3f))
                            .padding(8.dp),
                        imageVector = Icons.Default.ArrowUpward,
                        contentDescription = "Spend",
                        tint = Color(0xFFEF4444)
                    )

                    Row(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xFFEF4444).copy(alpha = 0.3f))
                            .padding(end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropUp,
                            contentDescription = "Spend",
                            tint = Color(0xFFEF4444)
                        )
                        Text(
                            text = "5%",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 14.sp,
                                color = Color(0xFFEF4444)
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Spend", style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "$1,850", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Composable
fun TotalBalance() {
    Surface(modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(brush = Brush.linearGradient(colors = listOf(Color(0xFF2665EC), Color(0xFF3A81F6))))
            .padding(horizontal = 25.dp, vertical = 20.dp),
        shape = RoundedCornerShape(15.dp),
        color = Color.Transparent,
        tonalElevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(text = "TOTAL BALANCE", style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp))
            Text(text = "$12,450.00", style = MaterialTheme.typography.titleLarge)
            Row(modifier =  Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White.copy(alpha = 0.3f))
                    .padding(vertical = 5.dp, horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.AutoMirrored.Filled.ShowChart,
                        contentDescription = "Info",
                        tint = Color.White
                    )
                    Text(text = "+2.5%", style = MaterialTheme.typography.titleMedium.copy(fontSize = 15.sp))

                }
                Text(text = "vs last month", style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp))
            }
        }
    }
}

@Composable
private fun UpcomingBill() {
    CustomGlassSurface(
        modifier = Modifier
            .fillMaxWidth()
            .dropShadow(
                shape = RoundedCornerShape(15.dp),
                shadow = Shadow(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                    offset = DpOffset.Zero,
                    radius = 8.dp,
                    spread = 1.dp
                )
            ),
        borderColor = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.Top
        ) {

            Icon(
                Icons.Default.Info,
                contentDescription = "Info",
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(
                    text = "Upcoming Bill",
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Netflix subscription ($15.99) is due tomorrow",
                    style = MaterialTheme.typography.labelSmall
                )
            }

        }
    }
}

@Composable private fun Header(
    isFemale: MutableState<Boolean>,
    name: MutableState<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(shape = CircleShape) {
                AsyncImage(
                    modifier = Modifier
                        .size(50.dp),
                    placeholder = painterResource(id = R.drawable.badge_man),
                    contentDescription = "Badge",
                    model = if (isFemale.value) {
                        R.drawable.badge_woman
                    } else {
                        R.drawable.badge_man
                    },
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(text = "Hello ${name.value}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Welcome Back!", style = MaterialTheme.typography.labelSmall)
            }
        }

        CustomGlassSurface(modifier = Modifier.size(45.dp), shape = CircleShape) {
            Icon(modifier = Modifier.padding(10.dp),
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification",
                tint = Color(0xFF989FAB))
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0F172A, device = "spec:width=1440px,height=3120px,dpi=550")
fun HomeScreenPreview() {
    val navController = rememberNavController()
    MoneyTrackTheme {
        HomeScreen(navController)
    }
}