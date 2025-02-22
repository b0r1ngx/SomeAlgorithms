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

// what if graph is: {A: [B], B: [C], C: [D], D: [E], E: [F], F: [G]}
// find from A -> G
// bad: memory O(n*n/2) -> O(n^2)
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
            if (to == end) return paths[end]!!.also {
                println(paths)
                println(it)
            }
        }
    }
    return listOf()
}

fun findPathOptimal(from: String, to: String, graph: Map<String, List<String>>): List<String> {
    val paths = mutableMapOf<String, String>()

    val stack = Stack<String>()
    stack.push(from)

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        val possibleEnds = graph[node] ?: continue
        for (end in possibleEnds) {
            if (end !in paths) stack.push(end)
            paths[end] = node
            if (to == end) return createPath(from, to, paths)
        }
    }
    return listOf()
}

private fun createPath(from: String, to: String, paths: Map<String, String>): List<String> {
    println(paths)
    var prevFlight = paths[to] ?: return listOf(to)
    val result = mutableListOf(to, prevFlight)

    while (prevFlight !== from) {
        prevFlight = paths[prevFlight]!!
        result.add(prevFlight)
    }

    return result.reversed()
}

fun main() {
    var graph = mutableMapOf(
        "A" to listOf("B", "D"), "B" to listOf("C", "N", "Z"),
        "D" to listOf("E", "F"), "F" to listOf("S"),
    )
    println("graph: $graph")
    println(listOf("A", "B", "N") == findPathOptimal("A", "N", graph))
    println(listOf("A", "D", "F", "S") == findPathOptimal("A", "S", graph))
    println(listOf<String>() == findPathOptimal("B", "S", graph))

    graph = mutableMapOf(
        "A" to listOf("B"), "B" to listOf("C"), "C" to listOf("D"),
        "D" to listOf("E"), "E" to listOf("F"), "F" to listOf("G")
    )
    println("graph: $graph")
    // memory with findPath(...):
    // keys (keys+values) -> values (keys+values)
    // 6 (12) -> 28 (35)
    println(listOf("A", "B", "C", "D", "E", "F", "G") == findPathOptimal("A", "G", graph))
}
