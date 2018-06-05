package org.stype.vekmath.curves

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.Test
import org.stype.vekmath.Point
import org.stype.vekmath.Vector

class SegmentTest {
    private fun assertIntersects(s1: Segment, s2: Segment, u1: Double, u2: Double) {
        assertThat(s1.intersects(s2)).isTrue()
        assertThat(s1.findIntersection(s2)).isEqualTo(u1, Offset.offset(1E-4))

        assertThat(s2.intersects(s1)).isTrue()
        assertThat(s2.findIntersection(s1)).isEqualTo(u2, Offset.offset(1E-4))

        val r1 = s1.reverse()
        val r2 = s2.reverse()

        assertThat(r1.intersects(r2)).isTrue()
        assertThat(r1.findIntersection(r2)).isEqualTo(1.0 - u1, Offset.offset(1E-4))

        assertThat(r2.intersects(r1)).isTrue()
        assertThat(r2.findIntersection(r1)).isEqualTo(1.0 - u2, Offset.offset(1E-4))

    }

    @Test
    fun testIntersect1() {
        val s1 = Segment(Point(0, 5), Point(10, 5))
        val s2 = Segment(Point(5, 0), Point(5, 10))

        assertIntersects(s1, s2, 0.5, 0.5)
    }

    @Test
    fun testIntersect2() {
        val s1 = Segment(Point(0, 0), Point(10,10))
        val s2 = Segment(Point(2, 2), Point(10,5))

        assertIntersects(s1, s2, 0.0, 0.2)
    }

    @Test
    fun testIntersect3() {
        val s1 = Segment(Point(-2, -2), Point(-2,2))
        val s2 = Segment(Point(-2, 0), Point(2,0))

        assertIntersects(s1, s2, 0.0, 0.5)
    }

    @Test
    fun testIntersect4() {
        val s1 = Segment(Point(0, 4), Point(4,4))
        val s2 = Segment(Point(4, 0), Point(4,8))

        assertIntersects(s1, s2, 0.5, 1.0)
    }

    @Test
    fun testIntersect5() {
        val s1 = Segment(Point(0, 0), Point(10,10))
        val s2 = Segment(Point(2, 2), Point(8,8))

        assertThat(s1.intersects(s2)).isTrue()
        assertThat(s1.findIntersection(s2)).isBetween(0.0, 1.0)

        assertThat(s2.intersects(s1)).isTrue()
        assertThat(s2.findIntersection(s1)).isBetween(0.2, 0.8)
    }

    @Test
    fun testIntersect6() {
        val s1 = Segment(Point(2, 10), Point(10,2))
        val s2 = Segment(Point(2, 10), Point(10,2))
        assertThat(s1.intersects(s2)).isTrue()
        assertThat(s1.findIntersection(s2)).isBetween(0.0, 1.0)

        assertThat(s2.intersects(s1)).isTrue()
        assertThat(s2.findIntersection(s1)).isBetween(0.0, 1.0)
    }

    @Test
    fun testDoesntIntersect1() {
        val s1 = Segment(Point(4, 5), Point(6,7))
        val s2 = Segment(Point(2, 2), Point(10,10))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect2() {
        val s1 = Segment(Point(-8, 10), Point(-4,2))
        val s2 = Segment(Point(-4, 8), Point(0,0))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect3() {
        val s1 = Segment(Point(0, 0), Point(0,2))
        val s2 = Segment(Point(4, 4), Point(4,6))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect4() {
        val s1 = Segment(Point(0, 0), Point(0,2))
        val s2 = Segment(Point(4, 4), Point(6,4))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect5() {
        val s1 = Segment(Point(-2, -2), Point(5,5))
        val s2 = Segment(Point(7, 7), Point(10,10))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect6() {
        val s1 = Segment(Point(0, 0), Point(2,2))
        val s2 = Segment(Point(1, 4), Point(0,4))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testDoesntIntersect7() {
        val s1 = Segment(Point(2, 2), Point(8,2))
        val s2 = Segment(Point(4, 4), Point(6,4))
        assertThat(s1.intersects(s2)).isFalse()
    }

    @Test
    fun testGetNormal() {
        val s1 = Segment(Point(0,0), Point(2, 0))
        assertThat(s1.getNormal(0.0)).isEqualTo(Vector(0.0, 1.0))
    }

    @Test
    fun testGetLength() {
        val s1 = Segment(Point(0,0), Point(2, 0))
        assertThat(s1.getLength()).isEqualTo(2.0)
    }

    @Test
    fun testIsClosed() {
        val s1 = Segment(Point(0,0), Point(2, 0))
        assertThat(s1.isClosed()).isFalse()
    }
}