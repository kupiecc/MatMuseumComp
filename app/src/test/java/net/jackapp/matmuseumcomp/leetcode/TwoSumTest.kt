package net.jackapp.matmuseumcomp.leetcode

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

internal class TwoSumTest {

    private lateinit var subject: TwoSum

    @Before
    fun setUp() {
        subject = TwoSum()
    }

    @Test
    fun `Given TwoSum, When Input nums array 2,7,11,15 and target = 9, Then output should be array 0, 1`() {
        val inputNums = listOf(2, 7, 11, 15).toIntArray()

        val result = subject.twoSum(inputNums, 9)

        assertThat(result).isEqualTo(listOf(0, 1).toIntArray())
    }

    @Test
    fun `Given TwoSum, When Input nums array 3, 2, 4 and target = 6, Then output should be array 1, 2`() {
        val inputNums = listOf(3, 2, 4).toIntArray()

        val result = subject.twoSum(inputNums, 6)

        assertThat(result).isEqualTo(listOf(1, 2).toIntArray())
    }

    @Test
    fun `Given TwoSum, When Input nums array 3, 3 and target = 6, Then output should be array 0, 1`() {
        val inputNums = listOf(3, 3).toIntArray()

        val result = subject.twoSum(inputNums, 6)

        assertThat(result).isEqualTo(listOf(0, 1).toIntArray())
    }

    @Test
    fun `Given TwoSum, When Input nums array 0,4,3,0 and target = 0, Then output should be array 0, 3`() {
        val inputNums = listOf(0,4,3,0).toIntArray()

        val result = subject.twoSum(inputNums, 0)

        assertThat(result).isEqualTo(listOf(0, 3).toIntArray())
    }

    @Test
    fun `Given TwoSum, When Input nums array -3,4,3,90 and target = 0, Then output should be array 0, 2`() {
        val inputNums = listOf(-3,4,3,90).toIntArray()

        val result = subject.twoSum(inputNums, 0)

        assertThat(result).isEqualTo(listOf(0, 2).toIntArray())
    }

    @Test
    fun `Given TwoSum, When Input nums array 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 20 and target = 20, Then output should be array 10, 61`() {
        val inputNums = listOf(1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 20).toIntArray()

        val result = subject.twoSum(inputNums, 20)

        assertThat(result).isEqualTo(listOf(10, 61).toIntArray())
    }

}