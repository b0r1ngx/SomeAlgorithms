package yandex

import java.util.Stack

// исходная задача: Реалиовать findPath, возвращающий путь from -> to
// функция поиска вариантов перелетов из точки
fun fetchFlights(fromCity: String): List<String> {
    return listOf()
}

// Например, для
// graph = {A: [B, D], B: [C, N, Z], D: [E, F], F: [S]}

// функция поиска составного авиабилета
fun findPath(from: String, to: String, fetchFlights: (fromCity: String) -> List<String>): List<String> {
    return listOf()
}

// задача с измененными входными данными
// передаем graph, вместо функции fetchFlights
fun findPath(from: String, to: String, graph: Map<String, List<String>>): List<String> {
    val paths = mutableMapOf<String, List<String>>()

    val stack = Stack<String>()
    stack.push(from)
    paths[from] = listOf(from)

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        val possibleEnds = graph[node] ?: continue
        val currentRoute = paths[node] ?: listOf()
        for (end in possibleEnds) {
            if (end !in paths) stack.push(end)
            paths[end] = currentRoute.plus(end)
            if (to == end) return paths[end]!!.also { println(it) }
        }
    }
    return listOf()
}

fun main() {
    val graph = mutableMapOf(
        "A" to listOf("B", "D"), "B" to listOf("C", "N", "Z"),
        "D" to listOf("E", "F"), "F" to listOf("S"),
    )
    println(listOf("A", "B", "N") == findPath("A", "N", graph)) // Promise.resolve(['A', 'B', 'N']) -> not empty list
    println(listOf("A", "D", "F", "S") == findPath("A", "S", graph)) // Promise.resolve(['A', 'D', 'F', 'S']) -> not empty list
    println(listOf<String>() == findPath("B", "S", graph)) // Promise.reject(new Error( 'No way')) -> empty list
}
