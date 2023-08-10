package com.silvacomp.spacetrack.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBarUi(
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    matchesFound: Boolean,
    onNavigateBack: () -> Unit = {},
    results: @Composable () -> Unit = {}
) {
    Box {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                searchText = searchText,
                placeHolder = placeholderText,
                onSearchTextChanged = onSearchTextChanged,
                onClearClick= onClearClick,
                onNavigateBack = onNavigateBack
            )

            if (matchesFound){
                results()
            }else {
                if (searchText.isNotEmpty()){
                    NoSearchResults()
                }
            }

        }
    }
}