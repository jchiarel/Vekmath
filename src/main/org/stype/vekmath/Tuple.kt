package org.stype.vekmath

/**
 * An immutable pair of Double values.
 */
abstract class Tuple(val x: Double, val y: Double) {
    override fun toString() = "($x, $y)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Tuple) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }
}