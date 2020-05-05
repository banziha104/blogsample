
enum class GarbageType5(
    val koName: String
) {
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
            in 30..Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    },
    IRON("고철") {
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    }; // !!!!*중요* 요소들을 선언한 후에는 반드시 세미콜론을 찍어야 기능을 정의할 수 있습니다!!!!!!
    abstract fun calculate(weight: Int) : Int
}


fun main() {
    val pair = 20 to GarbageType5.PLASTIC

    val totalPrice = sell(pair)

    println("총 가격은 $totalPrice 입니다.")
}

private fun sell(pair: Pair<Int, GarbageType5>): Int {
    val (weight, type) = pair

    // 분류의 책임이 사라져 굉장히 클-린해졌습니다 !
    val price = type.calculate(weight)

    return weight * price
}

