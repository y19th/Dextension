package com.y19th.dextension.core

/**
 * There is default implementation in extension module. Used for simplicity validating state classes in components.
 *
 * @sample com.y19th.dextension.extensions.property.PropertyValidator
 * @sample com.y19th.dextension.extensions.property.propertyValidate
 * @sample com.y19th.dextension.extensions.sample.validate
* */
interface Validator {
    var valid: Boolean
}

