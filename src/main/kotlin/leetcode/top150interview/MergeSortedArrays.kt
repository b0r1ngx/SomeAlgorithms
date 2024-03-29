package leetcode.top150interview

fun mergeSortedArrays(numbers1: List<Int>, numbers2: List<Int>): List<Int> {
    var (firstArrayPointer, secondArrayPointer) = 0 to 0
    val result = mutableListOf<Int>()

    val totalIndexes = numbers1.size + numbers2.size
    for (i in 0 until totalIndexes) {
        val elementFromFirstArray = numbers1
            .getOrNull(firstArrayPointer) ?: Int.MAX_VALUE
        val elementFromSecondArray = numbers2
            .getOrNull(secondArrayPointer) ?: Int.MAX_VALUE
        
        if (elementFromFirstArray > elementFromSecondArray) {
            result.add(elementFromSecondArray)
            secondArrayPointer += 1
        } else {
           result.add(elementFromFirstArray)
           firstArrayPointer += 1
        }
    }
    
    return result
}

fun main() {
    val nums1 = listOf(1, 2, 3)
    val nums2 = listOf(2, 5, 6)
    val expected = listOf(1, 2, 2, 3, 5, 6)
    val actual = mergeSortedArrays(nums1, nums2)

    if (expected == actual) print("Arrays are the same")
    else print("Arrays are different")
}
