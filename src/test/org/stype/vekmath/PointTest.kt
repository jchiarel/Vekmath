package org.stype.vekmath

import org.assertj.core.api.Assertions.*
import org.junit.Test

class PointTest {

    @Test
    fun testDistance() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 0.0)

        assertThat(p1.distance(p2)).isEqualTo(1.0)
    }

    @Test
    fun testDistance0() {
        val p1 = Point(0.0, 0.0)
        assertThat(p1.distance(p1)).isEqualTo(0.0)
    }

    @Test
    fun testAddition() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(2.0, 3.0)
        assertThat(p1 + p2).isEqualTo(Point(2.0, 3.0))
    }

    @Test
    fun testSubtraction() {
        val p1 = Point(5.0, 7.0)
        val p2 = Point(2.0, 3.0)
        assertThat(p1 - p2).isEqualTo(Point(3.0, 4.0))
    }

    @Test
    fun testMultiplication() {
        val p1 = Point(2.0, 3.0)
        assertThat(p1 * 4.0).isEqualTo(Point(8.0, 12.0))
    }

}