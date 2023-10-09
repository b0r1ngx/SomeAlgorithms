package yandex.school

fun solve(n: Short, a: List<Short>, b: List<Short>): Short {
    var answer = -1
    outer@ for (i in 0 until n) {
        for (j in n - 1 downTo 0) {
            if (i > j) break@outer
            if (a[i] == b[j]) {
                answer = j - i
                break@outer
            }
        }
    }
    outer@ for (j in n - 1 downTo 0) {
        for (i in 0 until n) {
            if (i > j) break@outer
            if (a[i] == b[j]) {
                if (j - i > answer)
                    answer = j - i
                break@outer
            }
        }
    }

    return answer.toShort()
}

fun main() {
    val n = readln().toShort()
    val a = readln().split(' ').map { it.toShort() }
    val b = readln().split(' ').map { it.toShort() }
    println(solve(n, a, b))
}


