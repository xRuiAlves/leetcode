object Day24 {
    def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
        val sorted_tokens = tokens.sortWith(_<_);
        var i0 = 0
        var i1 = sorted_tokens.length - 1
        var points = P
        var curr_score = 0
        var best_score = curr_score

        while (i0 <= i1 && (points >= sorted_tokens(i0) || curr_score > 0)) {
            if (points >= sorted_tokens(i0)) {
                points -= sorted_tokens(i0)
                i0 += 1
                curr_score += 1
                best_score = math.max(best_score, curr_score)
            } else {
                if (curr_score > 0) {
                    points += sorted_tokens(i1)
                    i1 -= 1
                    curr_score -= 1
                }
            }
        }
        best_score
    }
}
