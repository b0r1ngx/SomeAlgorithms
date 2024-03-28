package codewars

fun encryptThis(text:String): String{
    val textList = text.split(" ")
    var result = ""
    for (word in textList) {
        result += when (word.length) {
            1 -> "${word[0].code} "
            2 -> "${word[0].code}${word[1]} "
            else -> "${word[0].code}${word.last()}${word.drop(2).dropLast(1)}${word[1]} "
        }
    }
    return result.dropLast(1)
}

fun main() {
    print(encryptThis("A wise old owl lived in an oak"))
}