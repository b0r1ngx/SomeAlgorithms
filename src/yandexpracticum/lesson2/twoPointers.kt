package yandexpracticum.lesson2

/**
 * Task:
 *  Given an array with real numbers `arr` and real `x`.
 *  Say, exists or not, a continuous `sub_array` in `arr`,
 *  that sum of `sub_array` is equal to `x`.
 *
 *  Maybe you ask why this task goes to twoPointers problems?
 *
 *  Yes, this task can be solved only
 *  if we have few more restrictions on input data:
 *  elements of `arr`
 *  1) are non-negative real numbers
 *  - and/or -
 *  2) arranged in ascending order
 */

// P.S. Want to use kotlin.Number for elements (now Int), but can't add plus method when implement Number class
fun findSubArrayEqualsX(arr: List<Int>, x: Int): List<Int> {
    var (left, right) = 0 to 0
    var sum = arr[left]

    while (left < arr.size) {
        if (left > 0)
            sum -= arr[left - 1]

        if (sum == x)
            return arr.subList(left, right)
        else while (sum < x && right < arr.size) {
            sum += arr[right]
            right++
        }

        left++
    }

    return listOf()
}

/**
 * Little add to yandex example realisation:
 * 1) instead of output boolean existence, output first `sub_array` in `array`
 * 2) try to solve it on negative array, but arranged in non-decreasing order
 */
fun yandexSubArraySum(nonNegativeArray: List<Int>, x: Int): List<Int> {
    var (sum, right) = 0 to 0

    for (left in nonNegativeArray.indices) {
        if (left > 0) {
            val outerLeftPointerElement = nonNegativeArray[left - 1]
            if (outerLeftPointerElement < 0) {
                sum += outerLeftPointerElement
                right--
            } else
                sum -= outerLeftPointerElement
        }

        while (right < nonNegativeArray.size && sum < x) {
            sum += nonNegativeArray[right]
            right++
        }

        if (sum == x)
            return nonNegativeArray.subList(left, right)
    }

    return listOf()
}

fun main() {
    // array doesn't have properties, that must be,
    // to solve task with two pointers algorithm
    var arr = listOf(5, 4, 3, 5, 5, 2, 1, 1, 1)
    var x: Int = 14
    println(findSubArrayEqualsX(arr, x))

    // not so obvious what must be returned,
    // but if we know algorithm realisation, we can say it
    arr = listOf(-5, -5, -1, 0, 5, 5, 6, 10, 12)
    x = 10
    println(findSubArrayEqualsX(arr, x))
}