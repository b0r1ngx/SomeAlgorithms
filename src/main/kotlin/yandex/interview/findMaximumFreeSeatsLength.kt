package yandex.interview

/* Места в кинотеатре расположены в один ряд. Только что пришедший зритель выбирает место,
 * чтобы сидеть максимально далеко от остальных зрителей в ряду. То есть расстояние от того места,
 * куда сядет зритель до ближайшего к нему зрителя должно быть максимально.
 *
 * Гарантируется, что в ряду всегда есть свободные места и уже сидит хотя бы один зритель.
 *
 * Напишите функцию, которая по заданному ряду мест (массиву из нулей и единиц)
 * вернёт расстояние от выбранного места до ближайшего зрителя.
 */
fun findMaximumFreeSeatsLength(seats: List<Int>): Int {
    var maximumLength = 1
    var localLength = 0
    var startIndexCountLength = 0

    for (i in seats.indices) {
        val isSeatBusy: Int = seats[i]
        if (isSeatBusy == 0) {
            localLength += 1
        } else {
            if (startIndexCountLength == 0) {
                if (maximumLength < localLength) {
                    maximumLength = localLength
                }
            } else {
                val realLength: Int = (localLength + 1) / 2
                if (maximumLength < realLength) {
                    maximumLength = realLength
                }
            }

            localLength = 0
            startIndexCountLength = i + 1
        }
    }

    if (maximumLength < localLength) {
        maximumLength = localLength
    }

    return maximumLength
}

// just second implementation after some time passed
fun findMaximumFreeSeatsLength2(seats: List<Int>): Int {
    var result = 0
    var localMaxDistanceToOne = 0
    var isThereWasOneBefore = false

    for (i in seats.indices) {
        val value = seats[i]
        if (value == 0) {
            localMaxDistanceToOne += 1
        } else {
            if (isThereWasOneBefore) {
                localMaxDistanceToOne = Math.round(localMaxDistanceToOne.toFloat() / 2)
            }
            if (localMaxDistanceToOne > result) {
                result = localMaxDistanceToOne
            }
            localMaxDistanceToOne = 0
            isThereWasOneBefore = true
        }
    }

    if (seats[seats.size - 1] == 0) {
        if (localMaxDistanceToOne > result) {
            result = localMaxDistanceToOne
        }
    }

    return result
}

fun main() {
    val testCases = listOf(
        listOf(1, 0) to 1,
        listOf(1, 0, 0, 0, 0, 1) to 2,
        listOf(1, 0, 0, 0, 1) to 2,
        listOf(1, 0, 0, 0, 0) to 4,
        listOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1) to 3,
        listOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0) to 7,
    )

    testCases.forEach { (testCase, expected) ->
        println(findMaximumFreeSeatsLength(testCase) == expected)
        println(findMaximumFreeSeatsLength2(testCase) == expected)
        println()
    }
}
