package org.stype.vekmath

/**
 * An immutable 2D point
 */
class Point(x: Double, y: Double): Tuple(x, y) {

    /**
     * Constructs a point from a tuple
     */
    constructor(p: Tuple): this(p.x, p.y)

    /**
     * Calculates the distance from this point to another point
     */
    fun distance(that: Point): Double {
        val dx = this.x - that.x
        val dy = this.y - that.y
        return Math.sqrt(dx * dx + dy * dy)
    }

    /**
     * Adds a tuple to this point
     */
    operator fun plus(that: Tuple): Point {
        return Point(x + that.x, y + that.y)
    }

    /**
     * Subtracts a tuple from this point
     */
    operator fun minus(that: Tuple): Point {
        return Point(x - that.x, y - that.y)
    }

    /**
     * Scales this point by a scale factor
     */
    operator fun times(scale: Double): Point {
        return Point(x * scale, y * scale)
    }



}