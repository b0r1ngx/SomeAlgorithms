object Server {
    fun singleThread(tasks: List<Pair<Int, Int>>): List<Int> {
        val answer = mutableListOf<Int>()
        var d = 0
        for (task in tasks) {
            val a = task.first + task.second
            val formula =
                if (task.first < d) d + task.second
                else a

            answer.add(formula)
            d = formula
        }
        return answer
    }

    fun multiThread(threads: Int, tasks: List<Pair<Int, Int>>): List<Int> {
        if (threads == 1) return singleThread(tasks)

        val answer = mutableListOf<Int>()
        val threadInfo = mutableListOf(0)
        var threadsInWork = 1

        for (task in tasks) {
            val (minIndex, minThread) = threadInfo.withIndex().minByOrNull { (i, v) -> v }!!

            if (task.first < minThread) {
                val formula = minThread + task.second
                answer.add(formula)

                if (threadsInWork < threads) {
                    threadInfo.add(formula)
                    threadsInWork++
                } else {
                    threadInfo[minIndex] = formula
                }
            } else {
                val taskEndTime = task.first + task.second
                answer.add(taskEndTime)

                if (threadsInWork < threads) {
                    threadInfo.add(taskEndTime)
                    threadsInWork++
                } else {
                    threadInfo[minIndex] = taskEndTime
                }
            }
        }

        return answer
    }
}

fun main() {
    val tests = readLine()!!.toInt()

//    for (i in 0 until tests) {
//        readLine()
//        val n = readLine()!!.toInt()
//        val tasks = listOf<Pair<Int, Int>>()
//        for (j in 0 until n) {
//            val (t, d) = readLine()!!.split(' ')
//            tasks.add(t.toInt() to d.toInt())
//        }
//        println(Server.singleThread(tasks).joinToString(separator = " "))
//    }

    for (i in 0 until tests) {
        readLine()
        val (k, n) = readLine()!!.split(' ')
        val tasks = mutableListOf<Pair<Int, Int>>()
        for (j in 0 until n.toInt()) {
            val (t, d) = readLine()!!.split(' ')
            tasks.add(t.toInt() to d.toInt())
        }
        println(Server.multiThread(k.toInt(), tasks).joinToString(separator = " "))
    }
}