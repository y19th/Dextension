package com.y19th.dextension.extensions.sample

import com.y19th.dextension.extensions.property.propertyValidate

data class State(
    val text: String = "",
    val number: Int = 0
)

fun State.validate(): Boolean = propertyValidate {
    if(text.isNotEmpty()) {
        valid = false
        // update state
    }
    if(number != 124) {
        valid = false
        // update state
    }
}