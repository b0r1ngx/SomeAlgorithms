package yandex.interview

/* Места в кинотеатре расположены в один ряд. Только что пришедший зритель выбирает место,
 * чтобы сидеть максимально далеко от остальных зрителей в ряду. То есть расстояние от того места,
 * куда сядет зритель до ближайшего к нему зрителя должно быть максимально.
 * Гарантируется, что в ряду всегда есть свободные места и уже сидит хотя бы один зритель.
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

fun main() {
    val a = listOf(1, 0)
    val b = listOf(1, 0, 0, 0, 0, 1)
    val c = listOf(1, 0, 0, 0, 1)
    val d = listOf(1, 0, 0, 0, 0)
    val e = listOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1)
    val f = listOf(0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0)
    println(findMaximumFreeSeatsLength(e))
}