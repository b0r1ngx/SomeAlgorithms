object C {
    fun solving(n: Int, logins: List<String>): List<String> {
        val answers = mutableListOf<String>()
        val alreadyCorrect = mutableListOf<String>()

        val pattern = Regex("[\\da-zA-Z_-]{2,24}")

        first@ for (login in logins) {
            if (login[0] != '-') {
                for (i in alreadyCorrect) {
                    if (login.equals(i, ignoreCase = true)) {
                        answers.add("NO")
                        continue@first
                    }
                }
                if (pattern.matches(login)) {
                    answers.add("YES")
                    alreadyCorrect.add(login)
                } else {
                    answers.add("NO")
                }
            } else {
                answers.add("NO")
            }
        }
        return answers
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        val n = readLine()!!.toInt()

        val logins = mutableListOf<String>()
        for (j in 0 until n) {
            logins.add(readLine()!!)
        }
        val answer = C.solving(n, logins)
        for (j in answer)
            println(j)
        println()
    }
}