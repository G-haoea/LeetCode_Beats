package Easy

import java.lang.StringBuilder

fun main() {
    val s = "aacc"
    val t = "ccac"
    print(isAnagram(s, t))
}

private fun isAnagram(s: String, t: String): Boolean {
    if (t.length != s.length) {
        return false
    }
    val sKV = makeKV(s)
    val tKV = makeKV(t)
    return isEqualKV(sKV, tKV)
}

private fun makeKV(str: String) : Map<Char, Int> {
    var sb = StringBuilder(str)
    var map = mutableMapOf<Char, Int>()
    sb.forEach {
        map[it] = ((map.get(it) ?: 0) + 1)
    }
    return map
}

private fun isEqualKV(s: Map<Char, Int>, t: Map<Char, Int>) : Boolean {
    var result = true
    t.forEach { char, num ->
        if (s.get(char) ?: 0 < num) {
            result = false
            return@forEach
        }
    }
    return result
}