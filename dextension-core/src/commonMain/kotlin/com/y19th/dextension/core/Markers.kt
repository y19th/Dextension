package com.y19th.dextension.core

/**
* Marker interface for state in [ScreenComponent]
* */
interface BaseState

/**
 * Marker interface for events in [ScreenComponent]
 * */
interface BaseEvents

/**
 * Marker interface for side effects in [ScreenWithEffectComponent]
 * */
interface BaseEffects

/**
 * Empty state instance. Used in [EventComponent] as state that never updates.
 * */
internal class EmptyState private constructor(): BaseState {
    companion object {
        val Empty = EmptyState()
    }
}