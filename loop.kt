/*
 * 반복문
 * 1) 반복문 (upsizing)
 * 2) step
 * 3) downsizing
 */

// 1) 반복문 (upsizing)
fun loop1() {
    for(idx in 0..9) {
        //인덱싱에사용할 idx를 따로 선언하지 않아도 된다.
        // idx in 0..9 를통해 0~9까지 찍을 수 있음.
        println(idx);
    }
}

// 2) step
fun loop2() {
    for(idx in 0..9 step 3) {
        // 스텝 설정 가능
        println(idx);
    }
}

// 3) Down Sizing
fun loop3() {
    for(idx in 9 downTo 0) {
        // 9~0으로 내려오기 가능
        println(idx);
    }
}