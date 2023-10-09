data class Tenant(
    val minQ: Int,
    val baseQ: Int,
    val maxQ: Int
)

fun <T> Iterable<T>.zipWithNexts(): List<Triple<T, T, T>> {
    return zipWithNext { a, b, c -> Triple(a, b, c) }
}

inline fun <T, R> Iterable<T>.zipWithNext(transform: (a: T, b: T, c: T) -> R): List<R> {
    val iterator = iterator()
    if (!iterator.hasNext()) return emptyList()
    val result = mutableListOf<R>()
    var current = iterator.next()
    while (iterator.hasNext()) {
        val next = iterator.next()
        val nexts = iterator.next()
        result.add(transform(current, next, nexts))
        current = nexts
    }
    return result
}

fun main(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")
    val (numberOfTenants, totalBufferSize, lengthOfOperationSequence) =
        readlnOrNull()!!.split(" ").map { it.toInt() }
    val priorityLevelOfTenant = readlnOrNull()!!.split(" ").map { it.toInt() }
    val databaseSizeOfTenant = readlnOrNull()!!.split(" ").map { it.toInt() }
    val bufferSize = readlnOrNull()!!.split(" ")
        .map { it.toInt() }
        .zipWithNexts()
         // 3 * numberOfTenants
    for (judge in 0 until lengthOfOperationSequence) {
        val (u, p) = readlnOrNull()!!.split(" ").map { it.toInt() }
        answerToJudge(u, p)

    }
}

fun answerToJudge(u: Int, p: Int) {
    var answer = 0

    println(answer)
    System.out.flush()
}
