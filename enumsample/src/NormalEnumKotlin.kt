import java.lang.RuntimeException

enum class GarbageType2(
    val koName: String
) {
    PLASTIC("플라스틱"),
    GLASS("유리"),
    IRON("고철")
}

fun main() {
    // 플라스틱 20키로를 표현했습니다.
    val pair = 20 to GarbageType2.PLASTIC

    // 총 가격을 구해옵니다.
    val totalPrice = sell(pair)

    // 총 가격은 3000입니다 출력
    println("총 가격은 $totalPrice 입니다.")
}

// 판매 가격 알아내기
private fun sell(pair: Pair<Int, GarbageType2>): Int {
    // 분해할당으로 weight는 20, type GarbageType2.PLASTIC이 할당됩니다.
    val (weight, type) = pair

    // 현재 가져온 고물의 종류와 무게로 kg당 얼마인지 가져옵니다.
    // Enum을 아이템을 분류하는 Flag로 삼아 조건 분기합니다.
    val price = when (type) {
        GarbageType2.PLASTIC -> {
            when (weight) {
                in 0..10 -> 100
                in 10..29 -> 150
                in 30..Int.MAX_VALUE -> 200
                else -> throw EnumValueMisMathedException()
            }
        }
        GarbageType2.GLASS -> {
            when(weight){
                in 0..10 -> 150
                in 10..29 -> 250
                in 30..Int.MAX_VALUE -> 300
                else -> throw EnumValueMisMathedException()
            }
        }
        GarbageType2.IRON -> {
            when(weight){
                in 0..10 -> 100
                in 10..29 -> 150
                in 30..Int.MAX_VALUE -> 200
                else -> throw EnumValueMisMathedException()
            }
        }
    }
    return weight * price
}

