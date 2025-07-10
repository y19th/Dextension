package com.y19th.dextension.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlin.jvm.JvmName

/**
 * Interface for storage component events. Used for communication between [ScreenComponent].
 *
 * For example used for popping out component that located in out of module.
 * */
interface ComponentEventsStorage {

    val events: StateFlow<ComponentEvent?>

    fun handle(event: ComponentEvent?)
    fun clear()
}

/**
 * Contains instance of [ComponentEventsStorage] and providing it in [ScreenComponent]. By default using [DefaultComponentEventsStorageImpl].
 *
 * You can provide your own storage with [provide] function.
 * */
internal object ComponentEventsStorageProvider {

    private var _instance: ComponentEventsStorage = DefaultComponentEventsStorageImpl()

    fun get(): ComponentEventsStorage = _instance

    fun provide(instance: ComponentEventsStorage) {
        _instance = instance
    }
}

/**
 * Default implementation of [ComponentEventsStorage]. Used by default in [ComponentEventsStorageProvider].
 * */
internal class DefaultComponentEventsStorageImpl : ComponentEventsStorage {

    private val _events = MutableStateFlow<ComponentEvent?>(null)
    override val events = _events.asStateFlow()

    override fun handle(event: ComponentEvent?) {
        _events.value = event
    }

    override fun clear() {
        _events.value = null
    }
}

/**
 * collecting all type not null events from [ComponentEventsStorage]
 *
 * @param block callback on collected event.
 * */
@JvmName("onEvent")
suspend fun ComponentEventsStorage.onEvent(block: suspend (ComponentEvent) -> Unit) {
    events.filterNotNull().collect {
        block(it)
        clear()
    }
}

/**
 * collecting [T] type not null events from [ComponentEventsStorage]
 *
 * @param block callback on collected event.
 * */
@JvmName("filteringOnEvent")
suspend inline fun <reified T : ComponentEvent> ComponentEventsStorage.onEvent(
    noinline block: suspend (T) -> Unit
) {
    events.filterIsInstance<T>().collect {
        block(it)
        clear()
    }
}

/**
 * Marker interface for events in [ComponentEventsStorage].
 * */
interface ComponentEvent