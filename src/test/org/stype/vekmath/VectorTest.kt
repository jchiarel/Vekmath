package org.stype.vekmath

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
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

    @Test
    fun testConstructor() {
        val v1 = Vector(1.0, 2.0)
        val v2 = Vector(v1)
        assertThat(v1).isEqualTo(v2)
    }

    @Test
    fun testNormalize() {
        val v1 = Vector(2.0, 2.0)
        val sqrtTwo = Math.sqrt(2.0) / 2
        val n = v1.normalize()
        assertThat(n.x).isCloseTo(sqrtTwo, Offset.offset(0.00001))
        assertThat(n.y).isCloseTo(sqrtTwo, Offset.offset(0.00001))
    }

    @Test
    fun testDot0() {
        val v1 = Vector(1.0, 0.0)
        val v2 = Vector(0.0, 1.0)
        assertThat(v1.dot(v2)).isEqualTo(0.0)
    }

    @Test
    fun testDot1() {
        val v1 = Vector(1.0, 0.0)
        assertThat(v1.dot(v1)).isEqualTo(1.0)
    }

    @Test
    fun testCross1() {
        val v1 = Vector(1.0, 0.0)
        val v2 = Vector(0.0, 1.0)
        val cross = v1.cross(v2)
        assertThat(cross).isEqualTo(1.0)
    }

    @Test
    fun testCross0() {
        val v1 = Vector(1.0, 0.0)
        val cross = v1.cross(v1)
        assertThat(cross).isEqualTo(0.0)
    }
}