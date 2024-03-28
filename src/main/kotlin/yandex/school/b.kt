package yandex.school

const val start = "APPLICATION_FINISHED_LAUNCHING"
const val finish = "APPLICATION_TERMINATED"

fun crashFreeRate(map: MutableMap<Short, MutableList<String>>): Float {
    var totalCrashes = 0f
    var totalSessions = 0
    for ((user, session) in map) {
        var localCrashes = 0
        var localSessions = 0
        var isFinished = false
        for (i in session.size - 1 downTo 0) {
            if (session[i] == start && !isFinished) {
                localCrashes++
                totalSessions++
                continue
            }

            if (session[i] == finish && !isFinished) {
                isFinished = true
                continue
            }

            if (session[i] == start) {
                isFinished = false
                localSessions++
                continue
            }
        }
        totalCrashes += localCrashes
        totalSessions += localSessions
    }
    return if (totalCrashes == 0f) totalCrashes
    else totalCrashes / totalSessions
}

fun main() {
    val n = readln().toInt()
    val sessions = mutableMapOf<Short, MutableList<String>>()
    for (i in 0 until n) {
        val name = readln()
        val uid = readln().toShort()
        if (sessions.get(uid) == null) sessions[uid] = mutableListOf(name)
        else sessions[uid]!!.add(name)
    }
    println(crashFreeRate(sessions) * 100)
}