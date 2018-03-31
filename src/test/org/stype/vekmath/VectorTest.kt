package org.stype.vekmath

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VectorTest {

    @Test
    fun testMultiplication() {
        val v1 = Vector(1.0, 2.0)
        val v2 = v1 * 3.0
        assertThat(v2).isEqualTo(Vector(3.0, 6.0))
    }

    @Test
    fun testAddition() {
        val v1 = Vector(1.0, 2.0)
        val v2 = Vector(3.0, 4.0)
        assertThat(v1 + v2).isEqualTo(Vector(4.0, 6.0))
    }

    @Test
    fun testSubtraction() {
        val v1 = Vector(2.0, 1.0)
        val v2 = Vector(3.0, 4.0)
        assertThat(v1 - v2).isEqualTo(Vector(-1.0, -3.0))
    }
}