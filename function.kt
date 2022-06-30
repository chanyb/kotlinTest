/*
 * 함수
 * 1) 오버로딩, 오버라이딩 가능
 * 2) 디폴트 인자
 * 3) 확장함수
 * 4) 고차함수
 * 5) 람다함수
 * 6) 스코프함수
 * 6-1) apply
 * 6-2) run
 * 6-3) with
 * 6-4) also
 * 6-5) let
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

// 5) 람다함수
val lambda1: (String) -> Unit = { _str ->
    println(_str);
    println("끝");
}

val lambda2: (String) -> String = { _str ->
    println(_str);
    println("끝");
    "this";
    //람다함수가 여러줄 인 경우, 마지막 줄의 결과값이 반환된다.
}

// 6) 스코프함수
class Book(var name: String, var price: Int) {}

// 6-1) apply: 변수에 담기 전에 초기화 과정을 수행할 때
fun disCountBookWithApply(book: Book) {

    book.apply {
        name = "[초특가]"+name;
    }
    println(book.name);

}

// 6-2 run: apply와 같지만, 맨 마지막줄을 return한다.
fun disCountBookWithRun(book: Book) {

    var returnValue = book.run {
        name = "[초특가]"+name;
        "this";
    }
    println(returnValue);
}

// 6-3 with: run과 같고, 인스턴스를 참조연산자 대신 파라미터로받는다.
fun disCountBookWithWith(book: Book) {
    var returnValue = with (book) {
        name = "[초특가]" + name;
        "this2";
    }

    println(returnValue);
}

// 6-4 also: 처리가 끝나면 인스턴스를반환(as apply) but 참조연산자 it을 사용 해야함. (apply가 같은 이름의 변수가 스코프 밖에 있는경우에, 스코프 밖을 먼저 참조하기 떄문에..)
// 6-5 let: 처리가 끝나면 최종 라인을 반환(as run) but 참조연산자 it을 사용 해야함. (run이 같은 이름의 변수가 스코프 밖에 있는경우에, 스코프 밖을 먼저 참조하기 떄문에..)