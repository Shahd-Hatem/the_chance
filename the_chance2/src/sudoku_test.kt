fun validandinvalid() {
    // Valid cases
    check(name = "valid 9x9 Sudoku",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        expected = true
    )

    check(name = "valid empty 9x9 Sudoku ",
        checkBoard = isValidSudoku(Array(9) { Array(9) { '-' } }),
        expected = true
    )

    check(name = "valid 4x4 Sudoku",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('1', '-', '-', '4'),
            arrayOf('-', '4', '1', '-'),
            arrayOf('-', '1', '-', '2'),
            arrayOf('2', '-', '3', '-')
        )),
        expected = true
    )

    check(name = "valid 16x16 Sudoku ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
            arrayOf('4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3'),
            arrayOf('7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6'),
            arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
            arrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1'),
            arrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
            arrayOf('8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7'),
            arrayOf('B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A'),
            arrayOf('3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2'),
            arrayOf('6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5'),
            arrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
            arrayOf('C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'),
            arrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
            arrayOf('E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'),
            arrayOf('F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'),
            arrayOf('G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
        )),
        expected = true
    )

    // Invalid cases

    check(name = "invalid 9x9 Sudoku with duplicate in column ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '5') // duplicate 5 in last column
        )),
        expected = false
    )

    check(name = "invalid 9x9 Sudoku with duplicate in subgrid ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            arrayOf('-', '-', '-', '-', '-', '-', '2', '8', '-'),
            arrayOf('6', '6', '-', '4', '1', '9', '6', '-', '5'), // duplicate 6 in bottom-left subgrid row
            arrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        expected = false
    )

    check(name = "invalid 4x4 Sudoku",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('1', '-', '-', '4'),
            arrayOf('-', '4', '1', '3'),
            arrayOf('-', '1', '-', '3'),
            arrayOf('2', '-', '3', '1') // duplicate 3 in last column
        )),
        expected = false
    )

    check(name = "invalid 16x16 Sudoku",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
            arrayOf('4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3'),
            arrayOf('7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6'),
            arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
            arrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1'),
            arrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
            arrayOf('8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7'),
            arrayOf('B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A'),
            arrayOf('3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2'),
            arrayOf('6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5'),
            arrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
            arrayOf('C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'),
            arrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
            arrayOf('E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'),
            arrayOf('F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'),
            arrayOf('G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', '1') // duplicate 1 in row and colum
        )),
        expected = false
    )

    check(name = "Sudoku with invalid characters ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            arrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            arrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            arrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            arrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            arrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            arrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            arrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            arrayOf('-', '-', 'X', '-', '8', '-', '-', '7', '9') // invalid character 'X'
        )),
        expected = false
    )

    check(name = "non-square Sudoku ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('5', '3', '-'),
            arrayOf('6', '-', '-'),
            arrayOf('-', '9', '8'),
            arrayOf('8', '-', '-')
        )),
        expected = false
    )
    check(name = "empty board ",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf<Char>(),
            arrayOf<Char>(),
            arrayOf<Char>()
        )),
        expected = false
    )
    check(name = "invalid 4x4 Sudoku",
        checkBoard = isValidSudoku(arrayOf(
            arrayOf('1', '-', '-', '4'),
            arrayOf('-', '4', '1', '-'),
            arrayOf('-', '1', '-', '3'),
            arrayOf('2', '-', '3', '-')
        )),
        expected = false
    )//duplicate in bottom left subgrid

}


fun check(name: String, checkBoard: Boolean, expected: Boolean) {

}