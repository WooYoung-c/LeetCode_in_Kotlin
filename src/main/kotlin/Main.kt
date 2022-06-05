fun main() {
    val check = "aab"
    val list = P131().partition(check)
    for (palindromes in list) {
        for (palindrome in palindromes) print("$palindrome, ")
    }
}