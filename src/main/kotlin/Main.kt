const val DISCOUNT_1001 = 100
const val DISCOUNT_10001 = 0.05
const val DISCOUNT_REGULAR_CLIENT = 0.01

fun main() {
    val amount = 1000
    val previousAmount = 50000
    val regularClient = true

    val discountAmount = if (previousAmount >= 1001 && previousAmount <= 10000) amount - DISCOUNT_1001
    else if (previousAmount >= 10001) amount - (amount * DISCOUNT_10001)
    else amount

    val discountRegularClient = if (regularClient == true)
        discountAmount.toDouble() - (discountAmount.toDouble() * DISCOUNT_REGULAR_CLIENT)
    else discountAmount

    val totalString = "%.2f".format(discountRegularClient)
    val rub = totalString.substringBefore(",")
    val kop = totalString.substringAfter(",")

    val rubString = if (rub.endsWith("11")) "рублей"
    else if (rub.endsWith("1")) "рубль"
    else "рублей"

    val kopString = if (kop.endsWith("11")) "копеек"
    else if (kop.endsWith("1")) "копейка"
    else "копеек"

    print("Итоговая сумма покупки $rub $rubString и $kop $kopString")
}