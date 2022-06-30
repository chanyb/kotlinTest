/* 
 * 클래스
 * 1) 생성자
 * 2) 멤버 프로퍼티 선언
 * 3) 인터페이스
 * 4) 인터페이스 구현
 * 5) 위임(Delegation)
 * 6) 상속
 * 7) object 클래스
 * 7-1) companion object
 * 8) innerclass & outerclass
 */

// 1) 생성자
open public class People {
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

// 4) 인터페이스 구현
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

// 6) 상속
class Teacher(name: String, age: Int): People(name, age) {}
// 상속 받고자하는 People이 open으로 설정이 되어있어야 한다.(kotlin은 default로 final class이므로 open 키워드를 통해 final이 아님을 선언해준다.)

// 7) Object 클래스: singleton패턴을 언어자체에서 지원한다.
object counterManager {
    // 그 자체로 객체이기 때문에, 생성자를 사용하지 않는다.
    var count=0;
    
    fun countUp() {
        count++;
    }

    fun clear() {
        count = 0;
    }
}

// 7-1) companion object: 기존 클래스 안에도 object를 만들 수 있다. (기존 언어들의 static과 비슷함.)
public class People4 {
    companion object {
        var peopleCount = 0;
    }
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

// 8) innerClass & outerClass
class OuterClass {
    var text = "OuterClass";

    class NestedClass {
        fun hello() {
            println("NestedClass");
        }
    }

    inner class InnerClass {
        var text= "InnerClass";

        fun hello() {
            println(text)
        }

        fun helloOuter() {
            println(this@OuterClass.text);
        }
    }
}