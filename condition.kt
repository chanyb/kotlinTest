/*
 * 조건문
 * 1) if-else
 * 2) when
 */

// 1) if-else
fun basicCondition(x: Int) {
    if (x < 5) {
        println("5보다 작음");
    } else if (x < 10) {
        println("10보다 작음");
    } else {
        println("10이상임");
    }
}

// 2) when
fun whenCondition(x: Int) {
    when(x) {
        3 -> println("3");
        5 -> println("5");
        else -> println("3,5를 제외한수임;;");
    }
}

fun whenReturnValue(x: Int): Any {
    var res = when(x) {
        3 -> 2;
        4 -> 3;
        5 -> 4;
        else -> "3|4|5 중에 넣어봐.. -1 해서 줌";
    }
    return res;
}