enum class GarbageType3(
    val koName : String,
    val calculate : (Int) -> Int // 멤버변수로 추가해줍니다.
){
    PLASTIC("플라스틱",{
        // this.koName 에 접근할 수 없음.
        when (it) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    }),
    GLASS("유리",{
        when (it) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    }),
    IRON("고철",{
        when (it) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    });
}

fun main() {
    val pair = 20 to GarbageType3.PLASTIC

    val totalPrice = sell(pair)

    println("총 가격은 $totalPrice 입니다.")
}

// 판매 가격 알아내기
private fun sell(pair: Pair<Int, GarbageType3>): Int {
    val (weight, type) = pair

    // 분류의 책임이 사라져 굉장히 클-린해졌습니다 !
    val price= type.calculate(weight)

    return weight * price
}

