package com.aldyaz.wadirect.ui.main.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldyaz.wadirect.presentation.model.HistoryListState
import com.aldyaz.wadirect.presentation.model.HistoryPresentationModel
import com.aldyaz.wadirect.presentation.viewmodel.HistoryListViewModel

@Composable
fun HistoryListPage(
    viewModel: HistoryListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HistoryListScaffold(state = state)
}

@Composable
fun HistoryListScaffold(
    state: HistoryListState
) {
    Scaffold(
        content = { contentPadding ->
            HistoryListContent(
                items = state.histories,
                modifier = Modifier.padding(contentPadding)
            )
        }
    )
}

@Composable
fun HistoryListContent(
    items: List<HistoryPresentationModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        content = {
            itemsIndexed(items) { index, item ->
                HistoryListItem(
                    item = item,
                    modifier = Modifier
                        .clickable {
                        }
                        .padding(16.dp)
                )
                if (index < items.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun HistoryListItem(
    item: HistoryPresentationModel,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.phone,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.date,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Image(
            imageVector = Icons.AutoMirrored.Filled.Send,
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}
