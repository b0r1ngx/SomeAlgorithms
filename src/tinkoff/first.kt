package tinkoff

fun main(args: Array<String>) {
    println(validate("4 5 6 7 8 9 10 9 8 7 6 5 4 5 6 7 8 9 10 9 8 7 6 5 4"))
}

fun validate(cardNumber: String): Boolean {
    val numbers = cardNumber
        .map { it.digitToIntOrNull() }
        .filterNotNull()

    val sequence = numbers.slice(numbers.indices)
    val parity = sequence.size % 2
    val controlNumber = sequence.last()

    val sum = sequence.reversed().foldIndexed(0) { index, acc, i ->
        acc + when((index + 1) % 2) {
            parity -> if (i * 2 > 9) (i * 2 - 9) else i * 2
            else -> i
        }
    }
    println(sum)
    return sum % 10 == 0
}
