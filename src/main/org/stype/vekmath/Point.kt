package org.stype.vekmath

/**
 * An immutable 2D point
 */
class Point(x: Double, y: Double): Tuple(x, y) {

    constructor(p: Tuple): this(p.x, p.y)

    fun distance(that: Point): Double {
        val dx = this.x - that.x
        val dy = this.y - that.y
        return Math.sqrt(dx * dx + dy * dy)
    }

    operator fun plus(that: Tuple): Point {
        return Point(x + that.x, y + that.y)
    }

    operator fun minus(that: Tuple): Point {
        return Point(x - that.x, y - that.y)
    }

    operator fun times(scale: Double): Point {
        return Point(x * scale, y * scale)
    }



}