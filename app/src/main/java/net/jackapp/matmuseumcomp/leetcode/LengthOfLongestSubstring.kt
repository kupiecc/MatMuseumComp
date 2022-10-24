package net.jackapp.matmuseumcomp.leetcode

/*

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

class LengthOfLongestSubstring {

    fun lengthOfLongestSubstring(s: String): Int {
        var longest = ""
        var listOfLetters = s.toCharArray().toList()
        val word = StringBuilder()
        while (listOfLetters.isNotEmpty()) {
            word.clear()
            run breaking@{
                listOfLetters.forEach { char ->
                    if (!word.contains(char)) {
                        word.append(char)
                    } else {
                        return@breaking
                    }
                }
            }

            if (longest.length < word.length)
                longest = word.toString()

            listOfLetters =
                if (listOfLetters.size == word.length) emptyList()
                else listOfLetters.drop(1)
        }

        return longest.length
    }

}