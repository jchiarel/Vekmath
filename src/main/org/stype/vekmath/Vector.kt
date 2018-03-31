package org.stype.vekmath

/**
 * An immutable 2D Vector
 */
class Vector(x: Double, y: Double): Tuple(x, y) {
    /**
     * Constructs a Vector from a Tuple
     */
    constructor(p: Tuple): this(p.x, p.y)

    /**
     * Scales this Vector by a scale factor
     */
    operator fun times(scale: Double): Vector {
        return Vector(x * scale, y * scale)
    }

    /**
     * Subtracts the Tuple from this Vector
     */
    operator fun minus(that: Tuple): Vector {
        return Vector(x - that.x, y - that.y)
    }

    /**
     * Adds the Tuple to this Vector
     */
    operator fun plus(that: Tuple): Vector {
        return Vector(x + that.x, y + that.y)
    }

    /**
     * Returns a Vector in the same direction as this one, but with length 1
     */
    fun normalize(): Vector {
        val norm = 1.0 / Math.sqrt(x * x + y * y)
        val newX = x * norm
        val newY = y * norm

        return Vector(newX, newY)
    }

    /**
     * Calculates the dot product of this and another vector
     */
    fun dot(dir: Vector): Double {
        return (this.x*dir.x + this.y*dir.y)
    }

    /**
     * Calculates the cross product of this and another vector.
     * There is no standard definition of 2D cross-product but I've found this one useful
     */
    fun cross(that: Vector): Double {
        return x * that.y - that.x * y
    }
}