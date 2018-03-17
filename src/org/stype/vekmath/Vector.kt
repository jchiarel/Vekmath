package org.stype.vekmath

/**
 * Created by Joe on 5/23/2017.
 */
class Vector(x: Double, y: Double): Tuple(x, y) {
    constructor(p: Tuple): this(p.x, p.y)

    operator fun times(scale: Double): Vector {
        return Vector(x * scale, y * scale)
    }

    operator fun minus(that: Tuple): Vector {
        return Vector(x - that.x, y - that.y)
    }

    operator fun plus(that: Tuple): Vector {
        return Vector(x + that.x, y + that.y)
    }

    fun normalize(): Vector {
        val norm = 1.0 / Math.sqrt(x * x + y * y)
        val newX = x * norm
        val newY = y * norm

        return Vector(newX, newY)
    }

    fun dot(dir: Vector): Double {
        return (this.x*dir.x + this.y*dir.y);
    }

    fun cross(that: Vector): Double {
        return x * that.y - that.x * y
    }
}