package com.example.hltv.ui.screens.singleTeam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hltv.R
import com.example.hltv.ui.common.CommonCard
import androidx.compose.ui.text.font.FontWeight


@Composable
fun SingleTeam(){
    LazyColumn{
        item{
            overviewPlayers(
                player1 = "Device",
                player2 = "b0RUP",
                player3 = "blameF",
                player4 = "Staehr",
                player5 = "Buzz",
                player1Image = painterResource(id = R.drawable.person_24px),
                player2Image = painterResource(id = R.drawable.person_24px),
                player3Image = painterResource(id = R.drawable.person_24px),
                player4Image = painterResource(id = R.drawable.person_24px),
                player5Image = painterResource(id = R.drawable.person_24px)
            )
            overviewInfo(
                country = "Denmark",
                countryImage = painterResource(id = R.drawable.dk_flag),
                worldRank = "5"
            )
            recentMatches(
                team1 = "Astralis",
                team2 = "Astralis",
                imageTeam1 = painterResource(id = R.drawable.astralis_logo),
                imageTeam2 = painterResource(id = R.drawable.astralis_logo),
                score = "16-10",
                date = "10 October"
            )
        }
    }
}

@Composable
fun overviewPlayers(
    player1: String,
    player2: String,
    player3: String,
    player4: String,
    player5: String,
    player1Image: Painter,
    player2Image: Painter,
    player3Image: Painter,
    player4Image: Painter,
    player5Image: Painter,
){

}

@Composable
fun overviewInfo(
    country: String,
    countryImage: Painter,
    worldRank: String
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = country,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = countryImage,
                contentDescription = null,
                alignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(40.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "World Ranking",
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "#" + worldRank,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun recentMatches(
    team1: String,
    team2: String,
    imageTeam1: Painter,
    imageTeam2: Painter,
    score: String,
    date: String,

){
    CommonCard(
        modifier = Modifier,
        R = MaterialTheme,
        cardWidth = Modifier.fillMaxWidth(),
        topBox = {
            Box {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = imageTeam1,
                            contentDescription = null,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier
                                .size(40.dp)
                        )
                        Text(
                            text = team1,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = score,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = date,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = team2,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Image(
                            painter = imageTeam2,
                            contentDescription = null,
                            alignment = Alignment.CenterEnd,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                }
            }
        }
    )
}

@Composable
@Preview
fun SingleTeamPreview(){
    SingleTeam()
}