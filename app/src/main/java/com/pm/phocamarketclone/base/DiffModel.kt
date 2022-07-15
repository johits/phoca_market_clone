package com.pm.phocamarketclone.base

interface DiffModel {
    val diffId: Any
    override fun equals(other: Any?): Boolean
}
