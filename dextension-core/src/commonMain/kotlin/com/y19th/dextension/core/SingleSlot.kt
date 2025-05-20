package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import kotlinx.serialization.KSerializer

fun <C : Any> ComponentContext.singleSlot(
    serializer: KSerializer<C>
): SingleSlot<C> =
    SingleSlot(context = this, serializer = serializer)

class SingleSlot<C : Any>(
    private val context: ComponentContext,
    private val serializer: KSerializer<C>
) {
    private val source = SlotNavigation<C>()

    fun <T : Any> create(childFactory: (C, ComponentContext) -> T) =
        context.childSlot(
            source = source,
            serializer = serializer,
            handleBackButton = true,
            childFactory = childFactory
        )

    fun activate(configuration: C) {
        source.activate(configuration)
    }

    fun dismiss() {
        source.dismiss()
    }
}