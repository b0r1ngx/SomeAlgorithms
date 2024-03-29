fun mergeTwoArrays(
    numbers1: List<Int>,
    m: Int,
    numbers2: List<Int>,
    n: Int
): List<Int> {
    var currentIndex = 0
    val maxIndex = if (m > n) m else n
    
    val result = mutableListOf<Int>()
    var firstArrayPointer = 0
    var secondArrayPointer = 0
    for (i in 0 until m + n) {
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
    val nums1 = listOf(1,2,3)
    val m = 3
    val nums2 = listOf(2,5,6)
    val n = 3
    val expected = listOf(1,2,2,3,5,6)
    val actual = mergeTwoArrays(nums1,m,nums2,n)
    if (expected == actual)
        print("Arrays are the same")
    else
        print("Arrays are different")
}
