package com.y19th.dextension.extensions.property

interface Stateful<T : Any> {
    val value: T
    val isError: Boolean

    fun update(value: T = this.value, isError: Boolean = this.isError): Stateful<T>
}