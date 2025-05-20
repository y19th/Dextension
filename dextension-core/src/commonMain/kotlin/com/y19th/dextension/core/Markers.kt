package com.y19th.dextension.core

interface BaseState

interface BaseEvents

interface BaseEffects

internal class EmptyState private constructor(): BaseState {
    companion object {
        val Empty = EmptyState()
    }
}