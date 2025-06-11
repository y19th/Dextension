package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.y19th.dextension.core.BaseEffects
import com.y19th.dextension.core.ScreenWithEffectComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull

/**
 * Function for collecting not null side effects. Used in [SubscribedEffect].
 * */
suspend fun <Effect : BaseEffects> ScreenWithEffectComponent<*, *, Effect>.handleEffects(
    action: suspend (value: Effect) -> Unit
) {
    sideEffects.filterNotNull().collectLatest(action)
}

/**
 * Compose wrapper on [ScreenWithEffectComponent] for collecting side effects.
* */
@Composable
fun <Effect : BaseEffects> SubscribedEffect(
    component: ScreenWithEffectComponent<*, *, Effect>,
    action: suspend (value: Effect) -> Unit
) {
    LaunchedEffect(Unit) {
        component.handleEffects(action = action)
    }
}