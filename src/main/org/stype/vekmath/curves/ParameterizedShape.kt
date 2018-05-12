package org.stype.vekmath.curves

import org.stype.vekmath.Point
import org.stype.vekmath.Vector

/**
 * Represents a 2d shape parameterized from 0-1.
 */
abstract class ParameterizedShape {

    /**
     * Returns the point with the given u-value.  U is typically between 0 and 1
     */
    abstract fun getPoint(u: Double): Point

    /**
     * Returns the total length of the curve.  This method is not always accurate.
     */
    open fun getLength(): Double {
        return getPoint(0.0).distance(getPoint(1.0))
    }

    /**
     * Returns true if this is a closed shape, i.e. the start and end points are the same or should be connected
     */
    open fun isClosed() = true

    /**
     * Returns a normal vector at the given point
     */
    open fun getNormal(u: Double): Vector {
        var u1 = u
        var u2 = u + 0.001
        if(u2 > 1) {
            u1 = 0.99
            u2 = 1.0
        }
        val dir = Vector(getPoint(u1) - getPoint(u2)).normalize()

        return Vector(dir.y, -dir.x)
    }






}