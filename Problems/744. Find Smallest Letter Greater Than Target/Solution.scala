object Solution {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char =
    nextGreatestLetter(letters, target, 0, letters.length - 1)

  def nextGreatestLetter(letters: Array[Char], target: Char, l: Int, r: Int): Char = {
    if (l > r) {
      return letters(
        if (l < letters.length) l
        else 0
      )
    }

    val m = l + (r - l) / 2
    if (letters(m) <= target) {
      nextGreatestLetter(letters, target, m + 1, r)
    } else {
      nextGreatestLetter(letters, target, l, m - 1)
    }
  }
}
