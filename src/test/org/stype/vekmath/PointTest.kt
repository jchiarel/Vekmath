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

}