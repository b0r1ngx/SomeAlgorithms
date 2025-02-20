package codewars

import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.pow

fun doubles(maxk:Int, maxn:Int):Double {
    var value = 0.0
    for (k in 1 .. maxk) {
        for (n in 1 .. maxn) {
            val under = n.toDouble() + 1
            value += 1.0 / (k * under.pow(2*k))
        }
    }
    return value
}

fun main() {
    fun assertFuzzyEquals(act:Double, exp:Double) {
        val inrange = abs(act - exp) <= 1e-6
        if (!inrange) {
            val df = DecimalFormat("#0.000000")
            println("At 1e-6: Expected must be " + df.format(exp) + ", but got " + df.format(act))
        }
        println(inrange)
    }

    assertFuzzyEquals(doubles(1, 10), 0.5580321939764581)
    assertFuzzyEquals(doubles(10, 1000), 0.6921486500921933)
}
