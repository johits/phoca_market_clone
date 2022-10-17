package com.pm.presentation.base

interface DiffModel {
    val diffId: Any
    override fun equals(other: Any?): Boolean
}
