package com.example.sstelematicaandroidtest.util

import io.mockk.MockKAnnotations

fun Any.initMockKAnnotations() {
    MockKAnnotations.init(this, relaxUnitFun = true)
}