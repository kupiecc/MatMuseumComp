package net.jackapp.matmuseumcomp.leetcode

class LongestPalindromic {

    private var longestPalindromic = ""

    fun longestPalindrome(s: String): String {
        var decreasingString = s.replace(" ", "").toLowerCase()
        val lettersChecked = arrayListOf<Char>()
        val words = arrayListOf<String>()

        if (decreasingString.all { it == decreasingString.first() })
            return decreasingString

        s.forEach { char ->
            if (lettersChecked.contains(char))
                return@forEach

            lettersChecked.add(char)
            findAllTextToTest(decreasingString, char, true)
            findAllTextToTest(decreasingString, char, false)

            println(">>> longestPalindromic = ${longestPalindromic}")
        }

/*        while (decreasingString.isNotEmpty()) {
            val firstChar = decreasingString.first { it !in lettersChecked }
            val firstCharIndex = decreasingString.indexOfFirst { it !in lettersChecked }
            val lastSameCharIndex = decreasingString.indexOfLast { it == firstChar }
            var stringToTest = ""
            if (lastSameCharIndex != -1) {
                stringToTest = decreasingString.substring(firstCharIndex, lastSameCharIndex + 1)

                if (isPalindromic(stringToTest)) {
                    if (stringToTest.length == decreasingString.length &&
                        stringToTest.length > longestPalindromic.length
                    )
                        return stringToTest

                    if (longestPalindromic.length < stringToTest.length)
                        longestPalindromic = stringToTest

                    lettersChecked.add(stringToTest.first())
                    decreasingString = decreasingString.drop(1)
                } else {
                    val innerText = decreasingString.substring(0, lastSameCharIndex)
                    while (innerTextToTest(stringToTest).isNotEmpty()) {

                    }
                }
            }

        }*/

        return longestPalindromic
    }

    //    "aacabdkacaa"
    private fun findAllTextToTest(s: String, char: Char, lr: Boolean) {
        var stringToTest = if (lr) s else s.reversed()

        while (stringToTest.count { it == char } > 2) {
            val first = stringToTest.indexOfFirst { it == char }
            val last = stringToTest.indexOfLast { it == char }
            stringToTest = stringToTest.substring(first, last + 1)

            if (isPalindromic(stringToTest) && stringToTest.length > longestPalindromic.length)
                longestPalindromic = stringToTest

//            stringToTest = if (i) stringToTest.drop(1) else stringToTest.dropLast(1)
        }
    }

    private fun findText(string: String, c: Char): String {
        return if (string.count { it == c } >= 2) {
            val firstSameCharIndex = string.indexOfFirst { it == c }
            val lastSameCharIndex = string.indexOfLast { it == c }
            string.substring(firstSameCharIndex, lastSameCharIndex + 1)
        } else ""
    }

/*    private fun innerTextToTest(s: String): String {
        val firstLetter = s.first()
        val lastSameCharIndex = decreasingString.indexOfLast { it == firstChar }
        var decreasingText = s
        return if (s.count { it == firstLetter } >= 2) {

        } else {
            ""
        }
    }*/

    private fun isPalindromic(s: String): Boolean {
        var decreasingString = s

        while (decreasingString.isNotEmpty() && decreasingString.first() == decreasingString.last()) {
            decreasingString = decreasingString.drop(1).dropLast(1)
            val isEven = decreasingString.length % 2 == 0
            if (isEven && decreasingString.isEmpty() || !isEven && decreasingString.length == 1)
                return true
        }

        return false
    }

    private fun findInnerWordToTest(s: String): String {
        var anotherWordToTest = s
        while (anotherWordToTest.isNotEmpty() && anotherWordToTest.first() != anotherWordToTest.last()) {
            anotherWordToTest = anotherWordToTest.dropLast(1)
        }

        return anotherWordToTest
    }
}