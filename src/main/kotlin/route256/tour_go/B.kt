package route256.tour_go

import kotlin.math.*

object B {
    fun solution(n: Int, A: MutableList<Int>): List<Pair<Int, Int>> {
        val preparation = sortedMapOf<Int, MutableList<Int>>()

        for (i in 0 until n) {
            val it = A[i]
            preparation[it]?.add(i) ?: preparation.set(it, mutableListOf(i))
        }

        val answer = mutableListOf<Pair<Int, Int>>()
        val stopCondition = n / 2

        var indexShift = 0
        while (answer.size != stopCondition) {
            val valueOf = A.removeFirst()
            indexShift++
            val firstIndex = preparation[valueOf]!!.removeFirst() // OrNull() ?: break

            var secondIndex = preparation[valueOf]!!.removeFirstOrNull()
            var step = 1

            while (secondIndex == null) {
                val secondIndexFirstTry = preparation[valueOf - step]?.firstOrNull()
                val secondIndexSecondTry = preparation[valueOf + step]?.firstOrNull()

                if (secondIndexFirstTry != null && secondIndexSecondTry != null) {
                    secondIndex = min(secondIndexFirstTry, secondIndexSecondTry)
                    if (secondIndex == secondIndexFirstTry)
                        preparation[valueOf - step]?.removeFirstOrNull()
                    else
                        preparation[valueOf + step]?.removeFirstOrNull()
                } else if (secondIndexFirstTry != null) {
                    secondIndex = secondIndexFirstTry
                    preparation[valueOf - step]?.removeFirstOrNull()
                } else if (secondIndexSecondTry != null) {
                    secondIndex = secondIndexSecondTry
                    preparation[valueOf + step]?.removeFirstOrNull()
                }

                step++
            }

            answer.add(firstIndex + 1 to secondIndex + 1)
            A.removeAt(abs(secondIndex - indexShift))
            indexShift++

            if (A.size == 2)
                answer.add(
                    preparation[A[0]]!!.removeFirst()
                            to preparation[A[1]]!!.removeFirst()
                )
        }

        return answer
    }
}

fun main() {
    val tests = readln().toInt()
    for (i in 0 until tests) {
        val n = readln().toInt()
        val A = readln().split(' ').map { it.toInt() }.toList()

        val solution = B.solution(n, A.toMutableList())

        for (s in solution)
            println("${s.first} ${s.second}")

        if (i != tests - 1)
            println()
    }
}