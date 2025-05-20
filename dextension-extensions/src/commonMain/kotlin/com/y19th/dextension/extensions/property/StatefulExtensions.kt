package com.y19th.dextension.extensions.property

fun <T: Any> Stateful<T>.error(isError: Boolean): Stateful<T> = update(isError = isError)