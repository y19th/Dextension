package com.y19th.dextension.sample_default.start.logic

import com.y19th.dextension.core.BaseEvents

internal sealed interface StartEvents: BaseEvents {

    data object OnCounterIncrement: StartEvents

    data object OnNavigateToSecond: StartEvents
}