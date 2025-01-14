package com.aldyaz.wadirect.ui.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel

@Composable
fun CountryCodeBottomSheet(
    countryCodes: List<CountryCodePresentationModel>,
    onClickItem: (CountryCodePresentationModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        content = {
            itemsIndexed(countryCodes) { index, item ->
                if (index > 0) {
                    HorizontalDivider()
                }
                CountryCodeListItem(
                    item = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onClickItem(item)
                        }
                        .padding(16.dp)
                )
            }
        }
    )
}
