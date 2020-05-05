
// 인터페이스를 정의합니다.
interface Calculable {
    fun calculate(weight: Int): Int
}

enum class GarbageType4(
    val koName: String
) : Calculable {
    PLASTIC("플라스틱") {
        // 각 멤버가 인터페이스에 정의된 메소드를 구현해줍니다.
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    },
    GLASS("유리") {
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    },
    IRON("고철") {
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    }
}


fun main() {
    val pair = 20 to GarbageType4.PLASTIC

    val totalPrice = sell(pair)

    println("총 가격은 $totalPrice 입니다.")
}

// 이제 sell 함수에서 Calculable 인터페이스를 인자로 받습니다.
private fun sell(pair: Pair<Int, Calculable>): Int {
    val (weight, type) = pair

    // 분류의 책임이 사라져 굉장히 클-린해졌습니다 !
    val price = type.calculate(weight)

    return weight * price
}

