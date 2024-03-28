package yandex.school

fun totalToLaugh(momLaughOnNewInSeconds: Short, momLaughsAtJoke: List<Short>): Pair<Short, Int> {
    var initialTimeOnJoke: Short = 0
    var indexWhereToPut = 0
    for (i in momLaughsAtJoke.indices) {
        val localLaughInSeconds = momLaughsAtJoke[i]
        initialTimeOnJoke = (initialTimeOnJoke + ((i + 1) * localLaughInSeconds)).toShort()
        if (indexWhereToPut == 0 && localLaughInSeconds > momLaughOnNewInSeconds)
            indexWhereToPut = i
    }
    return initialTimeOnJoke to indexWhereToPut
}

fun insertIdeally(momLaughOnNewInSeconds: Short, momLaughsAtJoke: MutableList<Short>): Short {
    val (initialTimeOnJoke, indexWhereToPut) = totalToLaugh(momLaughOnNewInSeconds, momLaughsAtJoke)

    val addedTimeToJoke: Short = if (indexWhereToPut == 0) {
        (momLaughOnNewInSeconds * (momLaughsAtJoke.size + 1)).toShort()
    } else {
        momLaughsAtJoke.add(indexWhereToPut, momLaughOnNewInSeconds)
        (totalToLaugh(momLaughOnNewInSeconds, momLaughsAtJoke).first - initialTimeOnJoke).toShort()
    }
    return addedTimeToJoke
}

fun main() {
    val momLaughOnNewInSeconds = readln().toShort()
    readln()
    val momLaughsAtJoke = readln().split(' ').map { it.toShort() }.toMutableList()
    println(insertIdeally(momLaughOnNewInSeconds, momLaughsAtJoke))
}