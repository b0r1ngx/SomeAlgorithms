object E {
//    enum class TYPE_OF_QUERY {
//        "BUY", "BACK", "FULLBUY"
//    }

    fun solving(n: Int, q: Int, queries: MutableList<List<Int>>): MutableList<String> {
        val answer = mutableListOf<String>()

        // mutableMap
        val occupied = sortedMapOf<Int, MutableList<Int>>()
        val realesed = mutableListOf<Int>()

        first@ for (query in queries) {
            val queryType = query[0]
            if (queryType == 1) {
                // 1) покупка (1 - p) - "SUCCESS" or "FAIL", if место свободно, то "SUCCESS" и пометить место занятым, иначе "FAIL"
                val seatNumber = query[1]
                val coupe =
                    if (seatNumber % 2 == 1)
                        seatNumber / 2 + 1
                    else
                        seatNumber / 2

                val a = occupied[coupe]
                if (a != null) {
                    val find = a.find { it == seatNumber }
                    if (find == null) {
                        answer.add("SUCCESS")
                        occupied[coupe]!!.add(seatNumber)
                    } else
                        answer.add("FAIL")
                } else {
                    answer.add("SUCCESS")
                    occupied[coupe] = mutableListOf(seatNumber)
                }
            } else if (queryType == 2) {
                // 2) возврат (2 - p) - "SUCCESS" or "FAIL", если было занято, то "SUCCESS" и место освободить, иначе "FAIL"
                val seatNumber = query[1]
                val coupe =
                    if (seatNumber % 2 == 1)
                        seatNumber / 2 + 1
                    else
                        seatNumber / 2

                val a = occupied[coupe]
                if (a != null) {
                    val find = a.find { it == seatNumber }
                    if (find == null)  {
                        answer.add("FAIL")
                    } else {
                        answer.add("SUCCESS")
                        if (a.size == 2) {
                            occupied[coupe]!!.remove(seatNumber)
                        } else {
                            occupied.remove(coupe)
                            realesed.add(coupe)
                        }
                    }
                } else
                    answer.add("FAIL")
            } else {
                // 3) покупка купе целиком (3) - "SUCCESS X-Y" or "FAIL",
                if (occupied.size < n) {
                    var checked = false
                    for (i in 1 until occupied.size + 2) {
                        if (occupied[i] == null) {
                            occupied[i] = mutableListOf(i * 2 - 1, i * 2)
                            answer.add("SUCCESS ${i * 2 - 1}-${i * 2}")
                            continue@first
                        }
                        if (!checked) {
                            for (j in realesed) {
                                if (occupied[j] == null) {
                                    for (k in i until j) {
                                        if (occupied[k] == null) {
                                            occupied[k] = mutableListOf(k * 2 - 1, k * 2)
                                            answer.add("SUCCESS ${k * 2 - 1}-${k * 2}")
                                            continue@first
                                        }
                                    }

                                    occupied[j] = mutableListOf(j * 2 - 1, j * 2)
                                    answer.add("SUCCESS ${j * 2 - 1}-${j * 2}")
                                    continue@first
                                }
                            }
                            checked = true
                        }
                    }
                } else
                    answer.add("FAIL")
            }
        }
        return answer
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        readLine()
        val (n, q) = readLine()!!.split(' ').map { it.toInt() }

        val queries = mutableListOf<List<Int>>()
        for (j in 0 until q) {
            val list = readLine()!!.split(' ').map { it.toInt() }
            queries.add(list)
        }
        val answer = E.solving(n, q, queries)
        for (k in answer)
            println(k)
        println()
    }
}