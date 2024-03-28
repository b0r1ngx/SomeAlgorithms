package tinkoff

//enum class banknotes() {
//    FIVE(500)
//}

class ATM {
    private val banknotesToCount = mutableMapOf(
        20 to 0,
        50 to 0,
        100 to 0,
        200 to 0,
        500 to 0
    )
    private var banknotesTotal = 0

    fun deposit(banknotesCount: IntArray) {
        banknotesToCount[20] = banknotesCount[0]
        banknotesToCount[50] = banknotesCount[1]
        banknotesToCount[100] = banknotesCount[2]
        banknotesToCount[200] = banknotesCount[3]
        banknotesToCount[500] = banknotesCount[4]
        banknotesTotal = banknotesCount.sum()
    }

    fun withdraw(amount: Int): IntArray {
        val banknotesCount = IntArray(5) { 0 }
        var leftToOut = amount
        for (i in 0 until banknotesTotal) {
            if (leftToOut >= 500 && banknotesToCount[500]!! > 0) {
                banknotesCount[4] += 1
                banknotesToCount[500] = banknotesToCount[500]!! - 1
                leftToOut -= 500
            } else if (leftToOut >= 200 && banknotesToCount[200]!! > 0) {
                banknotesCount[3] += 1
                banknotesToCount[200] = banknotesToCount[200]!! - 1
                leftToOut -= 200
            } else if (leftToOut >= 100 && banknotesToCount[100]!! > 0) {
                banknotesCount[2] += 1
                banknotesToCount[100] = banknotesToCount[100]!! - 1
                leftToOut -= 100
            } else if (leftToOut >= 50 && banknotesToCount[50]!! > 0) {
                banknotesCount[1] += 1
                banknotesToCount[50] = banknotesToCount[50]!! - 1
                leftToOut -= 50
            } else if (leftToOut >= 20 && banknotesToCount[20]!! > 0) {
                banknotesCount[0] += 1
                banknotesToCount[20] = banknotesToCount[20]!! - 1
                leftToOut -= 20
            }
        }
        if (leftToOut != 0) return intArrayOf(-1)
        return banknotesCount
    }
}

fun main() {
    val atm = ATM()
    atm.deposit(intArrayOf(2, 2, 3, 4, 5))
    atm.withdraw(1500).forEach {
        println(it)
    }
}

//fun main() {
//    val commands = readln().split(",")
//    val arguments = readln().split(";").map { it.split(",").map(String::toInt) }
//
//    if (commands.count() != arguments.count()) return
//
//    val atm = ATM()
//
//    for (pair in (commands zip arguments)) {
//        when (pair.first) {
//            "withdraw" -> {
//                println(atm.withdraw(pair.second[0]).joinToString(","))
//            }
//
//            "deposit" -> {
//                atm.deposit(pair.second.toIntArray())
//                println("OK")
//            }
//
//            else -> continue
//        }
//    }
//}