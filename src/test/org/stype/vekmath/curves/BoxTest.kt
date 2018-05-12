package org.stype.vekmath.curves

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.stype.vekmath.Point

class BoxTest {
    @Test
    fun testNoIntersect() {
        val b1 = Box(Point(1, 1), Point(2,2))
        val b2 = Box(Point(3,3), Point(4,4))
        assertThat(b1.intersects(b2)).isFalse()
    }

    @Test
    fun testCorner() {
        val b1 = Box(Point(1, 1), Point(2,2))
        val b2 = Box(Point(2,2), Point(4,4))
        assertThat(b1.intersects(b2)).isTrue()
    }

    @Test
    fun testSide() {
        val b1 = Box(Point(1, 1), Point(2,2))
        val b2 = Box(Point(1,2), Point(2,3))
        assertThat(b1.intersects(b2)).isTrue()
    }

    @Test
    fun testIntersect() {
        val b1 = Box(Point(1, 1), Point(3,3))
        val b2 = Box(Point(2,2), Point(4,4))
        assertThat(b1.intersects(b2)).isTrue()
    }

    @Test
    fun testInside() {
        val b1 = Box(Point(1, 1), Point(4,4))
        val b2 = Box(Point(2,2), Point(3,3))
        assertThat(b1.intersects(b2)).isTrue()
    }
}