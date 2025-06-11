package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

/**
 * Cover on [Children] function.
* */
@Composable
fun <C : Any, T : Any> DefaultChildren(
    stack: Value<ChildStack<C, T>>,
    animator: StackAnimator = slide(),
    modifier: Modifier = Modifier,
    onChildrenInstance: @Composable (T) -> Unit
) {
    Children(
        modifier = modifier,
        stack = stack,
        animation = stackAnimation(animator),
        content = { onChildrenInstance(it.instance) }
    )
}

/**
* Used for displaying and handling state of single slot navigation component.
 *
 * @param slot single slot from component.
 * @param reaction ui content if slot activated.
* */
@Composable
fun <C : Any, T : Any> ReactOnSingleChildChange(
    slot: Value<ChildSlot<C, T>>,
    reaction: @Composable (T) -> Unit
) {
    val instance = slot.subscribeAsState()

    instance.value.child?.instance?.also { reaction(it) }
}

/**
 * Used for displaying and handling state of single slot navigation component.
 * As reaction used [ProvideContent] function.
 *
 * @param slot single slot from component.
 * */
@Composable
fun <C : Any, T : Screen> ReactOnSingleChildChange(
    slot: Value<ChildSlot<C, T>>
) {
    val instance = slot.subscribeAsState()

    instance.value.child?.instance?.also { ProvideContent(it) }
}