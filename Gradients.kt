sealed class Vector(val size: Int)
data class Vector1(val x: Float): Vector(1) {
    fun dot(x1: Float): Float {
        return x * x1
    }
}
data class Vector2(val x: Float, val y: Float): Vector(2) {
    fun dot(x1: Float, y1: Float): Float {
        return x * x1 + y * y1
    }
}

data class Vector3(val x: Float, val y: Float, val z: Float): Vector(3) {
    fun dot(x1: Float, y1: Float, z1: Float): Float {
        return x * x1 + y * y1 + z * z1
    }
}

data class Gradients<V: Vector>(val grads: Array<V>) {
    override fun toString(): String {
        return "<$grads[0], $grads[1]>"
    }

    operator fun get(index: Int): V {
        return grads[index.rem(grads.size)]
    }
}