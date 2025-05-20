package com.y19th.dextension.extensions.property

data class IntStatefulProperty(
    override val value: Int,
    override val isError: Boolean
): Stateful<Int> {
    override fun update(value: Int, isError: Boolean): Stateful<Int> {
        return copy(value = value, isError = isError)
    }
}

fun statefulProperty(default: Int): IntStatefulProperty {
    return IntStatefulProperty(default, false)
}