package yandex.coderun.mobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val nums = numbers.sorted()

    print(nums[1])

    reader.close()
    writer.close()
}