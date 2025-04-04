


fun main(){
    val ip:String = "192.16.0.-1"
    isValidIPv4(ip)
    if(isValidIPv4(ip)== false){
        println("pass")
    }
}

fun isValidIPv4(ip: String): Boolean {
  if (ip.contains("..")) return false
    val parts = ip.split(".")
    if (parts.size != 4) return false

    for (part in parts) {
        if (part.any { !it.isDigit() }) return false
        if (part.toInt() !in 0..255) return false
        if (part.length > 1 && part.startsWith("0")) return false
    }

    return true
}

