@file:Suppress("FunctionName")

package com.y19th.dextension.extensions.property

import com.y19th.dextension.core.Validator

/**
* Implementation of [Validator]. Used in [propertyValidate].
* */
fun PropertyValidator(): Validator = object : Validator {
    override var valid: Boolean = true
}

inline fun propertyValidate(block: Validator.() -> Unit): Boolean {
    val validator = PropertyValidator()
    block(validator)
    return validator.valid
}
