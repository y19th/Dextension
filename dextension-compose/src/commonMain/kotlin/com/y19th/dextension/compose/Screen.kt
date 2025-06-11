package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

/**
* Main component ui unit. [Content] function used for displaying ui content via [ProvideContent].
 *
 * @property componentContext handles [ComponentContext] for creating screen component.
* */
interface Screen {

    val componentContext: ComponentContext

    @Composable
    fun Content()
}
