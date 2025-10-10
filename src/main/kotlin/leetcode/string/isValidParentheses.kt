package leetcode.string

import java.util.Stack

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 */
fun isValidParentheses(string: String): Boolean {
    val closeToOpenBracketsMap: Map<Char, Char> = mapOf(']' to '[', '}' to '{', ')' to '(')
    val stack = Stack<Char>()

    for (char in string) {
        if (char in closeToOpenBracketsMap.keys) {
            if (stack.isEmpty() || closeToOpenBracketsMap[char] != stack.pop()) {
                return false
            }
        } else {
            stack.push(char)
        }
    }

    return stack.isEmpty()
}

fun main() {
    println(isValidParentheses("()"))
    println(isValidParentheses("(){}[]"))
    println(isValidParentheses("([{}])"))
    println(!isValidParentheses("("))
    println(!isValidParentheses("(("))
    println(!isValidParentheses("([)]"))
    println(!isValidParentheses("({[}])"))
}
