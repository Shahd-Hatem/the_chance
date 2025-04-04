


fun main(){
    val ip:String = " "
    isValidIPv4(ip)
    if(!isValidIPv4(ip)){
        println("pass")
    }
}

fun isValidIPv4(ip: String): Boolean {
    if (ip.isEmpty()) return false
  if (ip.contains("..")) return false
    val parts = ip.split(".")
    if (parts.size != 4) return false

    for (part in parts) {
        if (part.isEmpty()) return false
        if (part.any { !it.isDigit() }) return false
        if (part.toInt() !in 0..255) return false
        if (part.length > 1 && part.startsWith("0")) return false
    }
    return true
}

