package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

interface Screen {

    val componentContext: ComponentContext

    @Composable
    fun Content()
}
