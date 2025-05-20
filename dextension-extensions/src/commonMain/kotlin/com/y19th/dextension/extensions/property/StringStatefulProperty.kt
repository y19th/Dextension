package com.y19th.dextension.extensions.property

data class StringStatefulProperty(
    override val value: String,
    override val isError: Boolean
): Stateful<String> {
    override fun update(value: String, isError: Boolean): Stateful<String> {
        return copy(value = value, isError = isError)
    }
}

fun statefulProperty(default: String): StringStatefulProperty {
    return StringStatefulProperty(default, false)
}