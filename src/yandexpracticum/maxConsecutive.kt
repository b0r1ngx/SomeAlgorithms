val a = String()
val b = mutableListOf<Int>()

fun <T> findMaxConsecutive(): Int = TODO()

fun <T> maxConsecutiveElements(collection: Array<T>): Int {
    var result = 0
    var currIndexElement = 0

    while (currIndexElement < collection.size) {
        var nextIndexOtherElement = currIndexElement

        while (nextIndexOtherElement < collection.size &&
            collection[nextIndexOtherElement] == collection[currIndexElement]) {
            nextIndexOtherElement++
        }

        result = result.coerceAtLeast(nextIndexOtherElement - currIndexElement)
        currIndexElement = nextIndexOtherElement
    }

    return result
}

fun maxConsecutiveChars(array: CharSequence): Int {
    var result = 0
    var currIndexElement = 0



    return result
}

fun main() {
    val test = arrayOf(5, 5, 5, 4, 3, 2, 1, 1, 1, 1)
    print(maxConsecutiveElements(test))
}