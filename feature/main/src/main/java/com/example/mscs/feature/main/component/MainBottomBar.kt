package com.example.mscs.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mscs.feature.main.MainTab
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
internal fun MainBottomBar(
    modifier: Modifier = Modifier,
    tabs: PersistentList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        tabs.forEach { tab ->
            MainBottomBarItem(
                tab = tab,
                selected = tab == currentTab,
                onClick = { onTabSelected(tab) }
            )
        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    modifier: Modifier = Modifier,
    tab: MainTab,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
            )
            .background(
                if (selected) {
                    Color.LightGray
                } else {
                    Color.White
                }
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(tab.iconResId),
            contentDescription = stringResource(tab.labelResId),
            modifier = Modifier.size(34.dp)
        )
        Text(
            text = stringResource(tab.labelResId),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    MainBottomBar(
        tabs = MainTab.entries.toPersistentList(),
        currentTab = MainTab.Recruitment,
        onTabSelected = { },
    )
}
