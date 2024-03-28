package codewars

import kotlin.math.*

/**
 * amort(6, 100000, 360, 1) ->
 * "num_payment 1 c 600 princ 100 int 500 balance 99900"
 *
 * amort(6, 100000, 360, 12) ->
 * "num_payment 12 c 600 princ 105 int 494 balance 98772"
 */
object Finance {
    fun amort(rate: Double, bal: Int, term: Int, numPayment: Int): String {
        val r = rate / 1200
        val c = (r * bal) / (1 - (1 + r).pow(-term)) // monthlyPayment
        val balance = (1 + r).pow(numPayment) * bal - (((1 + r).pow(numPayment) - 1) / r) * c
        val prevBalance = (1 + r).pow(numPayment - 1) * bal - (((1 + r).pow(numPayment - 1) - 1) / r) * c
        val princ = prevBalance - balance
        val int = c - princ
        return "num_payment $numPayment c ${c.roundToInt()} princ ${princ.roundToInt()} int ${int.roundToInt()} balance ${balance.roundToInt()}"
    }
}

fun main() {
    println(Finance.amort(3.8, 48603, 24, 10))
}