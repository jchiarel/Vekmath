package org.stype.vekmath.curves

import org.stype.vekmath.Point

/**
 * A 2D axis-aligned bounding box.
 */
class Box(private val min: Point, private val max: Point) {
    fun intersects(that: Box): Boolean {
        return min.x <= that.max.x
                && max.x >= that.min.x
                && min.y <= that.max.y
                && max.y >= that.min.y
    }
}