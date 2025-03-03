package selfwar

// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html
fun hashSetIsSameAsLinkedHashSet() {
    val a = hashSetOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    a.add(11)
    a.add(12)
    val b = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    var aIterator = a.iterator()
    var bIterator = b.iterator()
    while (aIterator.hasNext()) {
        print("${aIterator.next() }")
    }
    println()
    aIterator = a.iterator()
    while (aIterator.hasNext()) {
        print("${aIterator.next() }")
    }
    println()
    aIterator = a.iterator()
    while (aIterator.hasNext()) {
        print("${aIterator.next() }")
    }
    println()
    while (bIterator.hasNext()) {
        print("${bIterator.next() }")
    }
    println()
    bIterator = b.iterator()
    while (bIterator.hasNext()) {
        print("${bIterator.next() }")
    }
    println()

    val hashSet = HashSet<Int>()
    hashSet.add(1)
    hashSet.add(2)
    hashSet.add(3)
    hashSet.add(4)
    hashSet.add(5)
    var setIterator = hashSet.iterator()
    while (setIterator.hasNext()) {
        print("${setIterator.next() }")
    }
    println()
    setIterator = hashSet.iterator()
    while (setIterator.hasNext()) {
        print("${setIterator.next() }")
    }
}

fun main() {
    hashSetIsSameAsLinkedHashSet()
}
