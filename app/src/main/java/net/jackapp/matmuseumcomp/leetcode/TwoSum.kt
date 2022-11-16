package net.jackapp.matmuseumcomp.leetcode

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

*/

class TwoSum {

    var time = 0L

    val sample = intArrayOf(1, 2, 3, 0, -1, -2, -3, 50, 51, 52, 53, 62, 63, 20)
    val sample2 = intArrayOf(3, 3)
    val sample3 = intArrayOf(2, 7, 11, 15)
    val sample4 = intArrayOf(3, 2, 4)

    fun oneToHundredThousand(): IntArray {
        val range = 1..20000000
        return range.toList().toIntArray()
    }

    fun twoSum(
        nums: IntArray = oneToHundredThousand(),
        target: Int = 19999999
    ): IntArray {
        var result: IntArray

        time = measureTimeMillis {
            result = indicesWithAny(nums, target)
        }

        println(">>> time = ${time}")
        return result
    }

    fun indicesWithAny(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            val secondValue = target - nums[i]
            val copy = nums.copyOfRange(i + 1, nums.size)
            if (copy.any { it == secondValue }) {
                val secondIndex = copy.indexOfFirst { it == secondValue }
                return intArrayOf(i, secondIndex + i + 1)
            }
        }
        return intArrayOf()
    }

    fun twoSumThird(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i < j) {
                    val n1 = nums[i]
                    val n2 = nums[j]
                    if (n1 + n2 == target)
                        return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }

    fun solution(nums: IntArray, target: Int): IntArray {
        var i = 0
        nums.forEach { num ->
            i++
            val secondValue = target - num
            val tmpNum = nums.takeLast(nums.size - i)
            val contains = tmpNum.any { it == secondValue }
            if (contains) {
                val list = nums.takeWhile { it == secondValue }
                return intArrayOf(i - 1, list.size)
            }
        }
        return intArrayOf()
    }

    fun mapIndex(nums: IntArray, target: Int): IntArray {
        var i = 0
        nums.forEach { num ->
            val secondValue = target - num
            val contains = nums.any { it == secondValue }
            if (contains) {
                val map = nums.mapIndexed { index, i -> index to i }
                val searchingIndex = map.indexOfFirst { i != it.first && it.second == secondValue }
                if (searchingIndex != -1)
                    return intArrayOf(i, searchingIndex)
            }
            i++
        }
        return intArrayOf()
    }

    fun sortedMap(nums: IntArray, target: Int): IntArray {
        val sortedMap = nums
            .mapIndexed { index, i -> i to index }
            .sortedBy { (k, v) -> k }

        val iterator1 = sortedMap.iterator()
        var index = 0
        val numChecked: List<Int?> = emptyList()
        while (iterator1.hasNext()) {
            var map = sortedMap.filter { it.first !in numChecked }
            val firstItem = iterator1.next()
            val firstValue = firstItem.first
            val firstIndex = firstItem.second
            numChecked.plus(firstValue)
            map = map.drop(index + 1)
            index++

            while (map.isNotEmpty()) {
                val centerPosition = Math.ceil(map.size / 2.0).toInt()
                val secondValue = map[centerPosition - 1].first
                val secondIndex = map[centerPosition - 1].second
                if (firstValue + secondValue == target) {
                    return intArrayOf(firstIndex, secondIndex)
                } else if (firstValue + secondValue > target) {
                    map = map.dropLast(centerPosition)
                } else if (firstValue + secondValue < target) {
                    map = map.drop(centerPosition)
                }
            }
        }

        return intArrayOf()
    }

    fun twoSumSequence(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j: Int
        val iterator1 = nums.asSequence().iterator()
        var iterator2: Iterator<Int>

        while (iterator1.hasNext()) {
            val firstValue = iterator1.next()
            iterator2 = nums.drop(i + 1).asSequence().iterator()
            j = i + 1
            while (iterator2.hasNext()) {
                val secondValue = iterator2.next()
                if (firstValue + secondValue == target) {
                    return intArrayOf(i, j)
                }
                j++
            }
            i++
        }

        return intArrayOf()
    }

    fun twoSumFourth(nums: IntArray, target: Int): IntArray {
        val iterator1 = nums.asSequence().iterator()
        for ((i, v1) in iterator1.withIndex()) {
            for (num in nums.size - 1 downTo i + 1) {
                val numInList = nums[num]
                val result = v1 + numInList
                if (result == target) {
                    return intArrayOf(i, num)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSumSecondSolution(nums: IntArray, target: Int): IntArray {
        val iterator1 = nums.toList().listIterator()
        while (iterator1.hasNext()) {
            val numberToCheck = iterator1.next()
            val numberPosition = iterator1.previousIndex()
            for (num in (numberPosition + 1) until nums.size) {
                val numInList = nums[num]
                val result = numberToCheck + numInList
                if (result == target) {
                    return intArrayOf(numberPosition, num)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSumFirstSolution(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index1, val1 ->
            nums.forEachIndexed { index2, val2 ->
                val sum = val1 + val2
                if (sum == target && index1 != index2) {
                    return intArrayOf(index1, index2)
                }
            }
        }
        return intArrayOf()
    }


}