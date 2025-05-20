package com.y19th.dextension.koin

import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.Qualifier


fun KoinComponent.deleteProperty(
    qualifier: Qualifier? = null
) = getKoin().deleteProperty(key = qualifier?.value ?: "key_default")


inline fun <reified T : Any> KoinComponent.declareProperty(
    instance: T,
    qualifier: Qualifier?
) {
    getKoin().setProperty(
        key = qualifier?.value ?: "default",
        value = instance
    )
}

inline fun <reified T : Any> KoinComponent.getOrDeclareProperty(
    qualifier: Qualifier?,
    onDefault: () -> T
): T =
    getKoin().getProperty(qualifier?.value ?: "default") ?: onDefault().apply {
        declareProperty(
            this@apply,
            qualifier
        )
    }
