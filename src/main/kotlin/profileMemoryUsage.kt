import kotlin.math.abs

fun <T> profileMemoryUsage(block: () -> T): Pair<T, Long> {
    val beforeUsedMemory = prepareGcAndGetUsedMemory()
    val result = block()
    val afterUsedMemory = prepareGcAndGetUsedMemory()

    val memoryUsedInBytes = abs(afterUsedMemory - beforeUsedMemory)
    println("memory usage: ${memoryUsedInBytes / 1024} KB")
    return result to memoryUsedInBytes
}

private fun prepareGcAndGetUsedMemory(): Long {
    with(Runtime.getRuntime()) {
        runAndSettleGc()
        return totalMemory() - freeMemory()
    }
}

private fun Runtime.runAndSettleGc() {
    runGc()
    Thread.sleep(100)
}

private fun Runtime.runGc() = gc()
