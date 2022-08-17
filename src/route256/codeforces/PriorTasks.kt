object PriorTasks {
    fun prior(size: Int, A: MutableList<Int>): List<Int> {
        val prioritize = mutableListOf<Int>()
        for (i in 0 until size) {
            prioritize.add(0)
        }

        val listWithIndexes = A.mapIndexed { index, i -> index to i }
        val sortedWithIndexes = listWithIndexes.sortedWith(compareBy { it.second }).asReversed()

        var prior = 1
        var nextMax = sortedWithIndexes[0].second - 1
        for ((index, element) in sortedWithIndexes) {
            if (element < nextMax) {
                nextMax = element - 1
                prior++
            }
            prioritize[index] = prior
        }

        return prioritize
    }
}

fun main() {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val size = readLine()!!.toInt()
        val A = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
        println(PriorTasks.prior(size, A).joinToString(separator = " "))
    }
}