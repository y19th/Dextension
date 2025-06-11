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

/**
* Navigation class that used single child navigation like Bottom sheets or dialogs.
 *
 * By [create] function you provides child factory for slot navigation.
 * [activate] and [dismiss] functions used for manipulating navigation stack.
 *
 * @param context component context for registering slots.
 * @param serializer serializer of [C] configuration.
 *
 * @sample com.y19th.dextension.sample_slot.holder.ui.SampleSlotHolderComponent
* */
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