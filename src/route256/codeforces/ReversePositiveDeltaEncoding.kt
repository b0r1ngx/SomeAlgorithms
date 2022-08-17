package route256.codeforces

import java.util.*

object ReverseDeltaEncoding {
    fun d(n: Int, encoded: MutableList<Int>): MutableList<Int> {
        var l = 0
        for (i in 0 until n) {
            val delta = encoded[i]
            encoded[i] = delta + l
            l = encoded[i]
        }
        return encoded
    }

    private fun <T> linkedListOf(vararg elements: T): LinkedList<T> {
        return LinkedList<T>(elements.toList())
    }

    fun decode(n: Int, encoded: List<Int>): List<Int> {
        if (n == 1) {
            return if (encoded[0] < 0) {
                listOf(-encoded[0], 0)
            } else {
                listOf(0, encoded[0])
            }
        }
        return if (encoded[n - 1] > 0) {
            hardDecode(n, encoded)
        } else {
            decodeFromEnd(n, encoded)
        }
    }

    private fun decodeFromEnd(n: Int, encoded: List<Int>): List<Int> {
        val answer = linkedListOf<Int>()
        answer.push(0)
        for (i in n - 1 downTo 0) {
            val e = answer[0] - encoded[i]
            if (i == n - 1) {
                if (e < 0) {
                    answer.pop()
                    answer.push(-e)
                    answer.push(0)
                } else {
                    answer.push(e)
                }
            } else {
                answer.push(e)
            }
        }
        return answer
    }

    private fun decodeFromStart(n: Int, encoded: List<Int>): List<Int> {
        val answer = linkedListOf<Int>()
        answer.push(encoded[0])
        for (el in encoded) {

        }
        return answer
    }

    private fun hardDecode(n: Int, encoded: List<Int>): List<Int> {
        val answer = linkedListOf<Int>()
        answer.push(encoded[n - 1])
        var answerSize = 1
        var memoryIndex = 1
        var isZeroPushed = false

        for (i in n - 2 downTo 0) {
            val el = encoded[i]
            if (el > 0) {
                for (j in 0 until memoryIndex) {
                    answer[j] += el
                }
                answer.push(el)
                memoryIndex++
            } else if (el < 0) {
                if (!isZeroPushed) {
                    answer.push(0)
                    memoryIndex = 1
                }
                answer.push(answer[0] - el)
                memoryIndex++
                isZeroPushed = true
            }
        }

        if (!isZeroPushed) {
            answer.push(0)
        }
        return answer
    }

    fun lastTryToEncode(n: Int, encoded: List<Int>): List<Int> {
        val answer = mutableListOf<Int>()

        var sum = 0
        var minMinus = 0
        var maxPlus = 0
        for (i in encoded) {
            sum += i
        }
//        if (sum)

        return answer
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val encoded = readLine()!!.split(' ').map { it.toInt() }
//    println(ReverseDeltaEncoding.decode(n, encoded).joinToString(separator = " "))
    println(ReverseDeltaEncoding.d(n, encoded.toMutableList()).joinToString(separator = " "))
}