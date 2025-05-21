package com.y19th.dextension.sample_slot.holder.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.y19th.dextension.compose.ReactOnSingleChildChange
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.dextension.sample_slot.holder.logic.SampleSlotHolderEvents

@Composable
internal fun SampleSlotHolderContent(
    component: SampleSlotHolderComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    ReactOnSingleChildChange(
        slot = component.slot
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "current shared state: ${state.value.sharedState}"
        )

        Button(
            onClick = { handleEvents(SampleSlotHolderEvents.OnActivateSlot) }
        ) {
            Text(
                text = "open dialog"
            )
        }
    }
}