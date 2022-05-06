import kotlin.math.abs
import kotlin.math.floor

fun bsplineNoise(grads: Gradients<Vector1>, perm: PermutationTable, x: Float): Float {
    val xp = x * 2.09375f
    val xf = floor(xp).toInt()
    val xs = xp - xf

    var n = 0f

    for(i in -1 until 3) {
        val g = grads[perm[xf + i]]
        val xsi = xs - i
        val t = 2f - xsi * xsi
        n +=
            if(t < 0) 0f
            else {
                val tp = t * t
                tp * g.dot(xsi)
            }
    }

    return n * 0.3323288141f
}

fun bsplineNoise(grads: Gradients<Vector2>, perm: PermutationTable, x: Float, y: Float): Float {
    val xp = x * 2.09375f
    val yp = y * 2.09375f

    val xf = floor(xp).toInt()
    val yf = floor(yp).toInt()
    val xs = xp - xf
    val ys = yp - yf

    var n = 0f

    for(i in -1 until 3) {
        for(j in -1 until 3) {
            val g = grads[perm[xf + i, yf + j]]
            val xsi = xs - i
            val ysj = ys - j
            val t = 2f - xsi * xsi - ysj * ysj
            n +=
                if(t < 0) 0f
                else {
                    val tp = t * t
                    tp * g.dot(xsi, ysj)
                }
        }
    }

    return n * 0.15713484842f
}

fun bsplineNoise(grads: Gradients<Vector3>, perm: PermutationTable, x: Float, y: Float, z: Float): Float {
    val xp = x * 2.09375f
    val yp = y * 2.09375f
    val zp = z * 2.09375f

    val xf = floor(xp).toInt()
    val yf = floor(yp).toInt()
    val zf = floor(zp).toInt()
    val xs = xp - xf
    val ys = yp - yf
    val zs = zp - zf

    var n = 0f

    for(i in -1 until 3) {
        for(j in -1 until 3) {
            for(k in -1 until 3) {
                val g = grads[perm[xf + i, yf + j, zf + k]]
                val xsi = xs - i
                val ysj = ys - j
                val zsk = zs - k
                val t = 2f - xsi * xsi - ysj * ysj - zsk * zsk
                n +=
                    if(t < 0) 0f
                    else {
                        val tp = t * t
                        tp * g.dot(xsi, ysj, zsk)
                    }
            }

        }
    }

    return n * 0.07775896f
}