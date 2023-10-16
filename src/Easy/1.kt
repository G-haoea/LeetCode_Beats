package Easy

fun main() {
    val nums = listOf(3, 3)
    val target = 6
    print(twoNum(nums, target))
}

private fun twoNum(nums: List<Int>, target: Int) : IntArray {
    var result = IntArray(2)
    var map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        if (map.containsKey(target - i)) {
            result.set(0, index)
            result.set(1, map.get(target - i)!!)
            return result
        }
        map.put(i, index)
    }
    return result
}