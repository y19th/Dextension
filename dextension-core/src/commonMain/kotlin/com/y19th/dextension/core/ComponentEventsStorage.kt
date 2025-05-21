package com.y19th.dextension.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlin.jvm.JvmName

interface ComponentEventsStorage {

    val events: StateFlow<ComponentEvent?>

    fun handle(event: ComponentEvent?)
    fun clear()
}

internal object ComponentEventsStorageProvider {

    private var _instance: ComponentEventsStorage = DefaultComponentEventsStorageImpl()

    fun get(): ComponentEventsStorage = _instance

    fun provide(instance: ComponentEventsStorage) {
        _instance = instance
    }
}

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

@JvmName("onEvent")
suspend fun ComponentEventsStorage.onEvent(block: (ComponentEvent) -> Unit) {
    events.filterNotNull().collect {
        block(it)
        clear()
    }
}

@JvmName("reflectionOnEvent")
suspend inline fun <reified T : ComponentEvent> ComponentEventsStorage.onEvent(
    noinline block: (T) -> Unit
) {
    events.filterIsInstance<T>().collect {
        block(it)
        clear()
    }
}

interface ComponentEvent