package tinkoff

class View(
    val id: Int,
    var parent: View? = null,
    var children: List<View> = listOf()
)

fun findCommonParent(a: View, b: View): View? {
    if (a.id == b.id) return a

    var parent: View? = null
    var parentA: View? = null
    var parentB: View? = null
    while (parentA?.id != 0 && parentB?.id != 0) {
        parentA = a.parent
        if (parentA?.id == b.id)
            parent = parentA

        parentB = b.parent
        if (parentB?.id == a.id)
            parent = parentB

        if (parentA?.id == parentB?.id)
            parent = parentA
    }
    return parent
}

fun main() {
    val numberOfNodes = readln().toInt()

    val relations: MutableMap<Int, List<Int>> = mutableMapOf()
    val views: MutableMap<Int, View> = mutableMapOf()

    for (i in 1 .. numberOfNodes) {
        val nodes = readln().split(" ").map { it.toIntOrNull() }.filterNotNull()

        if (nodes.isEmpty()) continue

        for (node in nodes) {
            if (!views.containsKey(node)) {
                views[node] = View(node)
            }

            relations[nodes[0]] = nodes.drop(1)
        }
    }

    for (parent in relations.keys) {
        val parentView = views[parent]
        val children = relations[parent]?.map { views[it] }?.filterNotNull()

        children?.let {
            parentView?.children = it

            it.forEach {
                it.parent = parentView
            }
        }
    }

    val targets = readln().split(" ").map { it.toIntOrNull() }.filterNotNull()

    if (targets.count() != 2) return

    val a = views[targets[0]]
    val b = views[targets[1]]

    if (a != null && b != null) {
        val result = findCommonParent(a!!, b!!)
        result?.let { print(it.id) }
    }
}