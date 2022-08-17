object F {
    fun solving(n: Int, q: Int, modules: MutableList<String>, queries: MutableList<String>): List<List<String>> {
        val answer = mutableListOf<MutableList<String>>()
        val alreadyCompiled = mutableListOf<String>()


        for (i in 0 until q) {
            var compiled = false
            val module = queries[i]

            if (module in alreadyCompiled) {
                answer.add(mutableListOf("0"))
                continue
            }

            while (!compiled) {

                val (b, list) = lookAtModules(n, q, module, modules)

                if (!b)
                    compiled = true
            }
        }

        return answer
    }

    private fun lookAtModules(n: Int, q: Int, module: String, modules: MutableList<String>): Pair<Boolean, List<String>> {
        val f = modules.find { it.startsWith(module) }!!
        val dependencies = f.split(" ").toMutableList()

        return if (dependencies.size == 1) {
            false to dependencies
        } else {
            true to dependencies
        }
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        readLine()
        val n = readLine()!!.toInt()
        val modules = mutableListOf<String>()

        for (j in 0 until n)
            modules.add(readLine()!!)

        val q = readLine()!!.toInt()
        val queries = mutableListOf<String>()

        for (k in 0 until q)
            queries.add(readLine()!!)

        val answer = F.solving(n, q, modules, queries)
        for (l in answer)
            println(l.joinToString(separator = " "))
        println()
    }
}