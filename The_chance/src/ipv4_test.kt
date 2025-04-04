

class IPv4CheckerTest {

    fun `Valid IPv4 addresses`() {
        check(
            name = "Standard private IP",
            checkip = isValidIPv4("192.168.1.1"),
            expected = true
        )
        check(
            name = "All zeros",
            checkip = isValidIPv4("0.0.0.0"),
            expected = true
        )
        check(
            name = "Maximum values",
            checkip = isValidIPv4("255.255.255.255"),
            expected = true
        )
    }
    fun `Invalid IPv4 addresses`() {
        check(
            name = "Out of range",
            checkip = isValidIPv4("256.256.256.256"),
            expected = false
        )
        check(
            name = "Negative numbers",
            checkip = isValidIPv4("192.168.-1.1"),
            expected = false
        )
        check(
            name = "Leading zeros",
            checkip = isValidIPv4("192.168.01.1"),
            expected = false
        )

        check(
            name = "Non-numeric characters",
            checkip = isValidIPv4("192.a.1.1"),
            expected = false
        )
        check(
            name = "Empty segment",
            checkip = isValidIPv4("192.168.1."),
            expected = false
        )
        check(
            name = "Too many segments",
            checkip = isValidIPv4("192.168.1.1.1"),
            expected = false
        )
        check(
            name = "Trailing space",
            checkip = isValidIPv4("192.168.1.1 "),
            expected = false
        )
        check(
            name = "Leading space",
            checkip = isValidIPv4(" 192.168.1.1"),
            expected = false
        )
        check(
            name = "Trailing dot",
            checkip = isValidIPv4("192.168.1.1."),
            expected = false
        )
        check(
            name = "Wrong separator",
            checkip = isValidIPv4("192,168,1,1"),
            expected = false
        )
        check(
            name = "Empty string",
            checkip = isValidIPv4(""),
            expected = false
        )

    }

    private fun check(name: String, checkip: Boolean, expected: Boolean) {
    }
}