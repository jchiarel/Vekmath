package org.stype.vekmath.curves

import org.stype.vekmath.Point
import org.stype.vekmath.Vector

/**
 * A line segment.
 */
class Segment(private val p1: Point, private val p2: Point): ParameterizedShape() {
    companion object {
        private const val EPSILON = 0.0001
    }

    override fun isClosed() = false

    override fun getPoint(u: Double): Point {
        return (p1 * (1 - u)) + (p2 * u)
    }

    private fun isPointOnLine(b: Point): Boolean {
        val aTmp = Vector(p2 - p1)
        val bTmp = Vector(b - p1)
        val r = aTmp.cross(bTmp)
        return Math.abs(r) < EPSILON
    }

    private fun isPointRightOfLine(b: Point): Boolean {
        val aTmp = Vector(p2 - p1)
        val bTmp = Vector(b - p1)
        val r = aTmp.cross(bTmp)
        return r < 0
    }

    private fun touchesOrCrossesLine(that: Segment): Boolean {
        return isPointOnLine(that.p1)
                || isPointOnLine(that.p2)
                || (isPointRightOfLine(that.p1) xor isPointRightOfLine(that.p2))
    }

    fun intersects(that: Segment): Boolean {
        val box1 = boundingBox
        val box2 = that.boundingBox
        return box1.intersects(box2)
                && touchesOrCrossesLine(that)
                && that.touchesOrCrossesLine(this)
    }

    private val boundingBox = Box(Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y)),
                Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y)))

    /**
     * Returns the u-value on the given segment that intersects this segment.
     * This method has undefined behavior if the two segments do not intersect.
     */
    fun findIntersection(that: Segment):Double {
        var uMin = 0.0
        var uMax = 1.0

        var pMin = that.getPoint(uMin)
        repeat(20) {
            val uMid = (uMin + uMax) / 2

            val pTest = that.getPoint(uMid)

            if(isPointOnLine(pTest)) {
                return uMid
            }

            if(isPointRightOfLine(pTest) == isPointRightOfLine(pMin)) {
                uMin = uMid
                pMin = pTest
            } else {
                uMax = uMid
            }
        }

        return (uMin + uMax) / 2
    }

    fun reverse() = Segment(p2, p1)

}

