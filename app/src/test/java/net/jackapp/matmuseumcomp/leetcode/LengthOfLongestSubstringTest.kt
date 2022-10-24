package net.jackapp.matmuseumcomp.leetcode

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

internal class LengthOfLongestSubstringTest {

    private lateinit var subject: LengthOfLongestSubstring

    @Before
    fun setUp() {
        subject = LengthOfLongestSubstring()
    }

    @Test
    fun `Given LengthOfLongestSubstring, When Input s is abcabcbb, Then output should be 3`() {
        val result = subject.lengthOfLongestSubstring("abcabcbb")

        Truth.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `Given LengthOfLongestSubstring, When Input s is bbbbb, Then output should be 1`() {
        val result = subject.lengthOfLongestSubstring("bbbbb")

        Truth.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `Given LengthOfLongestSubstring, When Input s is pwwkew, Then output should be 3`() {
        val result = subject.lengthOfLongestSubstring("pwwkew")

        Truth.assertThat(result).isEqualTo(3)
    }


}