
fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Double {
    val fee = when (total) {
        in 0..1_000 -> 0.3 * amount
        in 1_001..10_000 -> 0.25 * amount
        in 10_001..50_000 -> 0.2 * amount
        else -> 0.15 * amount
    }
    val feeExclusive = if (exclusive) 0.05 * amount else 0.0
    return fee - feeExclusive
}

fun main() {
    val amount = 200 // стоимость текущей продажи
    val total = 11_000 // сумма предыдущих продаж
    val fee = calculateFee(amount, total)  // exclusive по умолчанию = false
    println("exclusive is false, fee = $fee") // 40
    val exclusive = true
    val feeExclusive = calculateFee(amount,total, exclusive)
    println("exclusive is true, fee = $feeExclusive")
}
