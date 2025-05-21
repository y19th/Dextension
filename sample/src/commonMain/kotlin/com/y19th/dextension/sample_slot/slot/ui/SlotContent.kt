package com.y19th.dextension.sample_slot.slot.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.dextension.sample_slot.slot.logic.SlotEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SlotContent(
    component: SlotComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    ModalBottomSheet(
        onDismissRequest = { handleEvents(SlotEvents.OnDismiss) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "current inner state: ${state.value.innerState}"
            )

            Button(
                onClick = { handleEvents(SlotEvents.OnIncrement) }
            ) {
                Text(
                    text = "increment"
                )
            }
        }
    }
}