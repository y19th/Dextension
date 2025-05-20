package com.y19th.dextension.sample_default.start.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.dextension.sample_default.start.logic.StartEvents

@Composable
internal fun StartContent(
    component: StartComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "start content"
            )


            Text(
                text = "count state: ${state.value.counter}"
            )

            Button(
                onClick = { handleEvents(StartEvents.OnCounterIncrement) }
            ) {
                Text(
                    text = "update"
                )
            }

            Button(
                onClick = { handleEvents(StartEvents.OnNavigateToSecond) }
            ) {
                Text(
                    text = "navigate to end"
                )
            }
        }

    }
}