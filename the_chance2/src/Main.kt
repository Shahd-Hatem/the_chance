fun isValidSudoku(board: Array<Array<Char>>): Boolean {
    val size = board.size
    if (size == 0 || board.any { it.size != size }) return false

    // Determine allowed characters based on board size
    val allowedChars = when (size) {
        4 -> ('1'..'4').toSet() + '-'
        9 -> ('1'..'9').toSet() + '-'
        16 -> ('1'..'9').toSet() + ('A'..'G').toSet() + '-'
        else -> return false
    }

    // Check all cells contain allowed characters
    for (row in board) {
        for (cell in row) {
            if (cell !in allowedChars) return false
        }
    }

    // Check rows and columns
    for (i in 0 until size) {
        // Check row
        if (!isValidUnit(board[i].toList())) return false

        // Check column
        val column = board.map { it[i] }
        if (!isValidUnit(column)) return false
    }

    // Check subgrids
    val subgridSize = when (size) {
        4 -> 2
        9 -> 3
        16 -> 4
        else -> return false
    }

    for (boxRow in 0 until subgridSize) {
        for (boxCol in 0 until subgridSize) {
            val subgrid = mutableListOf<Char>()
            for (i in 0 until subgridSize) {
                for (j in 0 until subgridSize) {
                    subgrid.add(board[boxRow * subgridSize + i][boxCol * subgridSize + j])
                }
            }
            if (!isValidUnit(subgrid)) return false
        }
    }

    return true
}

private fun isValidUnit(unit: List<Char>): Boolean {
    val seen = mutableSetOf<Char>()
    for (c in unit) {
        if (c == '-') continue
        if (c in seen) return false
        seen.add(c)
    }
    return true
}

fun main() {
    val valid16x16 = arrayOf(
        arrayOf('5', '3', '-'),
        arrayOf('6', '-', '-'),
        arrayOf('-', '9', '8'),
        arrayOf('8', '-', '-')
    )
    println(isValidSudoku(valid16x16)) // Will now correctly print "true"
}