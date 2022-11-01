package net.jackapp.matmuseumcomp.leetcode

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

internal class LongestPalindromicTest {

    private lateinit var subject: LongestPalindromic

    @Before
    fun setUp() {
        subject = LongestPalindromic()
    }

    @Test
    fun `Given LongestPalindromic, When Input s is babad, Then output should be bab`() {
        val result = subject.longestPalindrome("babad")

        Truth.assertThat(result).isEqualTo("bab")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is abadd, Then output should be aba`() {
        val result = subject.longestPalindrome("abadd")

        Truth.assertThat(result).isEqualTo("aba")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is abb, Then output should be bb`() {
        val result = subject.longestPalindrome("abb")

        Truth.assertThat(result).isEqualTo("bb")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is SQQSYYSQQS, Then output should be SQQSYYSQQS`() {
        val result = subject.longestPalindrome("SQQSYYSQQS")

        Truth.assertThat(result).isEqualTo("SQQSYYSQQS")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is a, Then output should be a`() {
        val result = subject.longestPalindrome("a")

        Truth.assertThat(result).isEqualTo("a")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is ac, Then output should be a`() {
        val result = subject.longestPalindrome("ac")

        Truth.assertThat(result).isEqualTo("a")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is cbbd, Then output should be bb`() {
        val result = subject.longestPalindrome("cbbd")

        Truth.assertThat(result).isEqualTo("bb")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is aacabdkacaa, Then output should be aca`() {
        val result = subject.longestPalindrome("aacabdkacaa")

        Truth.assertThat(result).isEqualTo("aca")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is babadada, Then output should be adada`() {
        val result = subject.longestPalindrome("babadada")

        Truth.assertThat(result).isEqualTo("adada")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is babAdAdA, Then output should be AdAdA`() {
        val result = subject.longestPalindrome("babAdAdA")

        Truth.assertThat(result).isEqualTo("AdAdA")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is abacab, Then output should be bacab`() {
        val result = subject.longestPalindrome("abacab")

        Truth.assertThat(result).isEqualTo("bacab")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir, Then output should be gykrkyg`() {
        val result = subject.longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir")

        Truth.assertThat(result).isEqualTo("gykrkyg")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa, Then output should be abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa`() {
        val result = subject.longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa")

        Truth.assertThat(result).isEqualTo("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa")
    }

    @Test
    fun `Given LongestPalindromic, When Input s is aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaa, Then output should be aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa`() {
        val result = subject.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaa")

        Truth.assertThat(result).isEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

}