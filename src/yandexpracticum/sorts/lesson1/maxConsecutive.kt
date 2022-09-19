package yandexpracticum.sorts.lesson1

fun <T> findNextOtherIndexElement(currIndex: Int, collection: Array<T>): Int {
    var nextOtherValueIndex = currIndex

    while (nextOtherValueIndex < collection.size &&
        collection[nextOtherValueIndex] == collection[currIndex]
    )
        nextOtherValueIndex++

    return nextOtherValueIndex
}

fun <T> maxConsecutiveElements(collection: Array<T>): Int {
    var (result, currIndex) = 0 to 0

    while (currIndex < collection.size) {
        val nextOtherValueIndex = findNextOtherIndexElement(currIndex, collection)
        result = result.coerceAtLeast(nextOtherValueIndex - currIndex)
        currIndex = nextOtherValueIndex
    }

    return result
}

fun findNextOtherValueIndex(currIndex: Int, sequence: CharSequence): Int {
    var nextOtherValueIndex = currIndex

    while (nextOtherValueIndex < sequence.length &&
        sequence[currIndex] == sequence[nextOtherValueIndex]
    )
        nextOtherValueIndex++

    return nextOtherValueIndex
}

fun maxConsecutiveChars(sequence: CharSequence): Int {
    var (result, currIndex) = 0 to 0

    while (currIndex < sequence.length) {
        val nextOtherValueIndex = findNextOtherValueIndex(currIndex, sequence)
        result = result.coerceAtLeast(nextOtherValueIndex - currIndex)
        currIndex = nextOtherValueIndex
    }

    return result
}

fun main() {
    val test = arrayOf(5, 5, 5, 4, 3, 2, 1, 1, 1, 1)
    println(maxConsecutiveElements(test))

    val testSequence = "privetbooms"
    println(maxConsecutiveChars(testSequence))
}