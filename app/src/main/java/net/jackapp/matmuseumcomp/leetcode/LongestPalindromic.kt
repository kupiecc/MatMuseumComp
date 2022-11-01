package net.jackapp.matmuseumcomp.leetcode

import kotlin.system.measureTimeMillis

/*
* Given a string s, return the longest palindromic substring in s.
A string is called a palindrome string if the reverse of that string is the same as the original string.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

* Example 2:
Input: s = "cbbd"
Output: "bb"
* */

class LongestPalindromic {

    private var longestPalindromic = ""

    fun longestPalindrome(s: String): String {
        val string =
//          "SQQSYYSQQS"
//          "aabbaacddddaaa"
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//          "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"
//          "jkexvzsqshsxyytjmmhauoyrbxlgvdovlhzivkeixnoboqlfemfzytbolixqzwkfvnpacemgpotjtqokrqtnwjpjdiidduxdprngvitnzgyjgreyjmijmfbwsowbxtqkfeasjnujnrzlxmlcmmbdbgryknraasfgusapjcootlklirtilujjbatpazeihmhaprdxoucjkynqxbggruleopvdrukicpuleumbrgofpsmwopvhdbkkfncnvqamttwyvezqzswmwyhsontvioaakowannmgwjwpehcbtlzmntbmbkkxsrtzvfeggkzisxqkzmwjtbfjjxndmsjpdgimpznzojwfivgjdymtffmwtvzzkmeclquqnzngazmcfvbqfyudpyxlbvbcgyyweaakchxggflbgjplcftssmkssfinffnifsskmsstfclpjgblfggxhckaaewyygcbvblxypduyfqbvfcmzagnznquqlcemkzzvtwmfftmydjgvifwjoznzpmigdpjsmdnxjjfbtjwmzkqxsizkggefvztrsxkkbmbtnmzltbchepwjwgmnnawokaaoivtnoshywmwszqzevywttmaqvncnfkkbdhvpowmspfogrbmuelupcikurdvpoelurggbxqnykjcuoxdrpahmhiezaptabjjulitrilkltoocjpasugfsaarnkyrgbdbmmclmxlzrnjunjsaefkqtxbwoswbfmjimjyergjygzntivgnrpdxuddiidjpjwntqrkoqtjtopgmecapnvfkwzqxilobtyzfmeflqobonxiekvizhlvodvglxbryouahmmjtyyxshsqszvxekj"
//          "xeeevvgrqunieginnvgvttbloinzpmoiaczszxswpmsxkhtnyrzimeckwndjnrvczcokshsachapcsbhijbbedfjnccqifibbumjchrarmvfoacdxwwkwrsnnebsdqksjmxzuwlpztltsgtllviztsqzzzzsrxkhmrugklfxinlkbdtgzaqgrrnplsbbtoqfrjwzqhwozesjqanifdswbtrkbtzkwtcodejwdorsdcairdodaluaafbviigevezrkovmcbswauhkvhrhzojdmlevuvfycjqntgpxtjtqqtjtxpgtnqjcyfvuvelmdjozhrhvkhuawsbcmvokrzevegiivbfaauladodriacdsrodwjedoctwkztbkrtbwsdfinaqjsezowhqzwjrfqotbbslpnrrgqazgtdbklnixflkgurmhkxrszzzzqstzivlltgstltzplwuzxmjskqdsbennsrwkwwxdcaofvmrarhcjmubbifiqccnjfdebbjihbscpahcashskoczcvrnjdnwkcemizrynthkxsmpwsxzszcaiompzniolbttvgvnnigeinuqrgvveeex"
//          "aba"
//           s.replace(" ", "")
        val lettersChecked = arrayListOf<Char>()

        if (string.all { it == string.first() })
            return string

        findSingleLetterString(string)
        val time = measureTimeMillis {
            firstSolution(string, lettersChecked)
//            secondSolution(string)
        }
        println(">>> time = ${time}")

        return longestPalindromic
    }

    private fun firstSolution(string: String, lettersChecked: ArrayList<Char>) {
        val lettersArray = string.toCharArray().distinct()
        lettersArray.forEach { char ->
            if (lettersChecked.contains(char))
                return@forEach

            lettersChecked.add(char)
            findAllTextToTest(string, char)

        }
    }

    private fun secondSolution(string: String) {
        val letterIterator = string.toList().listIterator()
        while (letterIterator.hasNext()) {
            val letter = letterIterator.next()
            val letterPosition = letterIterator.previousIndex()

            if (letterPosition > longestPalindromic.length) {
                for (position in 0..letterPosition) {
                    val from = letterPosition - position
                    val toEven = letterPosition + position + 1
                    val toOdd = letterPosition + position + 2
                    if (toEven <= string.length) {
                        val evenWord = string.substring(from, toEven)
                        if (isPalindromic(evenWord) && evenWord.length > longestPalindromic.length)
                            longestPalindromic = evenWord
                    }
                    if (toOdd <= string.length) {
                        val oddWord = string.substring(from, toOdd)
                        if (isPalindromic(oddWord) && oddWord.length > longestPalindromic.length)
                            longestPalindromic = oddWord

                    }
                }
            }
        }
    }

    private fun findAllTextToTest(stringToTest: String, letter: Char) {
        val letterPositions: List<Int> = stringToTest.mapIndexedNotNull { index, c ->
            index.takeIf { c.toLowerCase() == letter.toLowerCase() }
        }

        if (letterPositions.size == 1) {
            if (longestPalindromic.isEmpty())
                longestPalindromic = stringToTest[letterPositions.first()].toString()
            else return
        }

        for (frameSize in letterPositions.size downTo 2) {
            val letterFrames = letterPositions.windowed(size = frameSize)
            if (isAnyLongertWord(letterFrames))
                return
            letterFrames.forEach { frame ->
                val word = stringToTest.substring(frame.first(), frame.last() + 1)
                if (isPalindromic(word) && word.length > longestPalindromic.length) {
                    longestPalindromic = word
                    return@forEach
                }
            }
        }
    }

    private fun isAnyLongertWord(letterFrames: List<List<Int>>): Boolean {
        var longestDistance = 0
        letterFrames.forEach {
            val distance = it.last() - it.first()
            if (distance > longestDistance)
                longestDistance = distance
        }
        return longestDistance < longestPalindromic.length
    }

    private fun findSingleLetterString(stringToTest: String) {
        val stringIterator = stringToTest.iterator()
        val sb = StringBuilder()
        while (stringIterator.hasNext()) {
            val char = stringIterator.next()
            if (sb.isEmpty() || sb.contains(char))
                sb.append(char)
            else {
                setIfLongestWord(sb.toString())
                sb.clear()
                sb.append(char)
            }
        }
        setIfLongestWord(sb.toString())
    }

    private fun setIfLongestWord(sb: String) {
        if (sb.length > longestPalindromic.length)
            longestPalindromic = sb
    }

    private fun isPalindromic(string: String): Boolean {
        val part1: String
        val part2: String

        if (string.all { it == string.first() })
            return true

        val isEven = string.length % 2 == 0
        if (isEven) {
            part1 = string.substring(0, string.length / 2)
            part2 = string.substring(string.length / 2, string.length)
        } else {
            part1 = string.substring(0, (string.length - 1) / 2)
            part2 = string.substring((string.length + 1) / 2, string.length)
        }

        return part1 == part2.reversed()
    }

}