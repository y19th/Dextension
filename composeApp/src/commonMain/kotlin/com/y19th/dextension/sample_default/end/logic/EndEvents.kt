package com.y19th.dextension.sample_default.end.logic

import com.y19th.dextension.core.BaseEvents

internal sealed interface EndEvents: BaseEvents {

    data object OnCounterIncrement: EndEvents

    data object OnNavigateToFirst: EndEvents
}