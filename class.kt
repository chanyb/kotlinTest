/* 
 * 클래스
 * 1) 생성자
 * 2) 멤버 프로퍼티 선언
 * 
 * 인터페이스
 * 3) 인터페이스
 * 
 * 4) 상속
 * 5) 위임(Delegation)
 */

// 1) 생성자
public class People {
    var age: Int;
    var name: String;

    constructor(name: String="", age: Int=0) {
        // 생성자의 default값을 이용하면 생성자를 오버로딩 하지 않아도 된다.
        // 멤버프로퍼티에 대해 자동으로 getter, setter가 생긴다.
        // ex) people.name = "bcyu" 가능.
        this.name = name;
        this.age = age;
    }

    fun koreanAge(): Int {
        return this.age-2;
    }
}

// 2) 멤버 프로퍼티 선언
public class People2(
    // val 또는 var 키워드를 사용하면, 멤버 프로퍼티를 따로 선언하지 않아도 된다.
    // 자동으로 getter, setter 생김.
    val name: String="", var age: Int
)

// 3) 인터페이스
interface BaseInterfase {
    fun koreanAge(): Int;
}

// 4) 상속
public class People3: BaseInterfase {
    var age: Int;
    var name: String;

    constructor(name: String="", age: Int=0) {
        // 생성자의 default값을 이용하면 생성자를 오버로딩 하지 않아도 된다.
        // 멤버프로퍼티에 대해 자동으로 getter, setter가 생긴다.
        // ex) people.name = "bcyu" 가능.
        this.name = name;
        this.age = age;
    }

    override fun koreanAge(): Int {
        return this.age-2;
    }
}

// 5) 위임
public class Student(p: BaseInterfase): BaseInterfase by p {}
// 위임을 BaseInterface로 한다고 했기때문에, BaseInterface를 상속받아 구현한 class를 위임받을 수 있다. 따라서 People3을 위임받았다.
/* 관련코드
    val someOne = People3("bcyu", 29);
    var student = Student(someOne);
    println(student.koreanAge());
*/