fun main(args: Array<String>) {

    println("Hello, Ex1: Только что.")
    println()
    val userGoneTime: Int = 79100 //ВВЕДИТЕ время в секундах
    println(agoToText(userGoneTime))
    println()


    println("Ex2: Разная комиссия для разных платежных систем.")
    print("Ваша комиссия составит: ")
    //println(calcComission("Master", 20_000, transfer = 70_000))
    println(calcComission(transfer = 100_000))
}

fun calcComission(typeCard: String = "VK pay", earlyTransfer: Int = 0, transfer: Int) =
    when (typeCard) {
        "Master", "Maestro" ->
            if ((earlyTransfer + transfer) < 75_000) 0 else transfer * 0.006 + 20

        "Visa", "Мир" ->
            if (transfer * 0.075 < 35) 35 else transfer * 0.075

        else -> 0.0
    }

fun agoToText(time: Int): String {
    val minute = (time / 60).toInt()
    val hour = (time / 3600).toInt()

    return when (time) {
        in 1..59 -> "был(а) только что"
        in 61 .. 60 * 60 -> "был(а) в сети " + minute + " " + minutaS(minute) + " назад"
        in 60 * 60 + 1 until 24 * 60 * 60 -> "был(а) в сети " +hour+ " "+hourS(hour) +" назад"

        in 24 * 60 * 60 until 2 * 24 * 60 * 60 -> "был(а) в сети вчера"
        in 2 * 24 * 60 * 60..3 * 24 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }

}
fun minutaS(minute: Int): String {
    if ((minute - 1) % 10 === 0) {
        return "минуту"
    } else if ((minute - 2) % 10 === 0 || (minute - 3) % 10 === 0 || (minute - 4) % 10 === 0) {
        return "минуты"
    } else return "минут"
}
fun hourS(hour: Int): String {
    if ((hour - 1) % 20 === 0) {
        return "час"
    } else if ((hour - 2) % 20 === 0 || (hour - 3) % 20 === 0 || (hour - 4) % 20 === 0) {
        return "часа"
    } else return "часов"
}
