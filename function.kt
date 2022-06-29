/*
 * 함수
 * 1) 오버로딩, 오버라이딩 가능
 * 2) 디폴트 인자
 * 3) 확장함수
 * 4) 고차함수
 */


// 1) 오버로딩
fun functionOverloading(arg1: Int): Unit {
    println(arg1);
}

fun functionOverloading(arg1: Int, arg2: String): Unit {
    println(arg1);
    println(arg2);
}

fun functionOverloading(arg1: String): Unit {
    println(arg1);
}

// 2) 디폴트 인자
fun defaultParameter(arg1: Int=532): Unit {
    println(arg1);
} 

fun defaultParameter_start(arg1: Int=532, arg2: Int): Unit {
    // 에러, default 인자는 뒤부터 가능
    println(arg1);
    println(arg2);
}

fun defaultParameter_end(arg1: Int, arg2: Int=142): Unit {
    println(arg1);
    println(arg2);
}

// 3) 확장함수
fun People.nextYear(): Int {
    // People class에 없던 nextYear 멤버 함수를 추가했음.
    return this.age+1;
}

// 4) 고차함수: 다른 함수를 인자로 받거나 함수를 반환하는 함수
// 고차함수에 넘기려면 ::funcName 형식으로 넘겨줘야함.. -> higherOrderFunction(::calledFunction);
fun higherOrderFunction(func: (String) -> Unit): Unit {
    func("Call in higherOrder Function");
}

fun calledFunction(value: String): Unit {
    println("calledFunction: " + value);
}

