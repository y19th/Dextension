package com.y19th.dextension.extensions.property

data class StatefulProperty<T : Any>(
    override val value: T,
    override val isError: Boolean
) : Stateful<T> {
    override fun update(value: T, isError: Boolean): Stateful<T> {
        return copy(value = value, isError = isError)
    }
}

fun <T: Any> statefulProperty(default: T): StatefulProperty<T> {
    return StatefulProperty(default, false)
}

