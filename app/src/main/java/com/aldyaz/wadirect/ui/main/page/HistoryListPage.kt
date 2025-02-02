@file:OptIn(ExperimentalMaterial3Api::class)

package com.aldyaz.wadirect.ui.main.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldyaz.wadirect.R
import com.aldyaz.wadirect.presentation.model.HistoryListState
import com.aldyaz.wadirect.presentation.model.HistoryPresentationModel
import com.aldyaz.wadirect.presentation.viewmodel.HistoryListViewModel

@Composable
fun HistoryListPage(
    onNavigateUp: () -> Unit,
    viewModel: HistoryListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HistoryListScaffold(
        onClickNavigateBack = onNavigateUp,
        state = state
    )
}

@Composable
fun HistoryListScaffold(
    onClickNavigateBack: () -> Unit,
    state: HistoryListState
) {
    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 2.dp,
                content = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = stringResource(R.string.label_sent_histories),
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = onClickNavigateBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }
            )
        },
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
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {
            itemsIndexed(items) { _, item ->
                HistoryListItem(
                    item = item,
                    onClick = {},
                    modifier = Modifier
                )
            }
        }
    )
}

@Composable
fun HistoryListItem(
    item: HistoryPresentationModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
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
}
