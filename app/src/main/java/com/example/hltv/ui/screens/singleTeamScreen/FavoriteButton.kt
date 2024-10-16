package com.example.hltv.ui.screens.singleTeamScreen

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.example.hltv.data.local.PrefDataKeyValueStore
import com.example.hltv.ui.common.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun FavoriteButton(
    datastore: PrefDataKeyValueStore,
    teamID: Int,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFFF0000)
) {

    var isFavorite by remember { mutableStateOf(false) }
    var localClickVar by remember { mutableStateOf(false)}

    LaunchedEffect(isFavorite){
        CoroutineScope(Dispatchers.IO).launch {
            datastore.getFavouriteTeam().collect { int ->
                isFavorite = int == teamID
            }
        }

    }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = it
            localClickVar = it
            CoroutineScope(Dispatchers.IO).launch {
                if (isFavorite) {
                    datastore.updateFavouriteTeam(teamID)
                    datastore.getFavouriteTeam().collect { int ->
                        Log.d("FavoriteButton", "Favourite team is now: $int vs  $teamID")
                    }
                } else {
                    datastore.updateFavouriteTeam(0)
                    Log.d("FavoriteButton", "Favourite team is now: 0")
                }
            }
        }
    ) {
        if (localClickVar)
            showToast(message = "This team is now your favorite")

        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}