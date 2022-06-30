/*
 * observer pattern
 * - 개발자는 이벤트 A(클릭)기 일어났을 때, 특정 로직을 수행하고 싶다.
 * - 안드로이드(구글) 입장에서는 이벤트는 유저(client)가 어떤 이벤트를 언제 발생시킬지, 개발자가 어떤 이벤트를 처리하고자 하는지 모른다..
 * - ex) 클릭이벤트
 * - 발생한 클릭을 넘겨줄 수 있는 클래스 A(clickEventListenerByAndroid)가 필요하고
 * - 클릭을 수신할 수있는 class B(ClassMadeByDeveloper)가 필요하다. 
 * - 기기(핸드폰)는 자동으로 이벤트(클릭)을 발생시킨다.
 */


interface ClickEventListener {
    fun onEvent();
}

class clickEventListenerByDeveloper (var listener: ClickEventListener) {
    fun click() {
        println("안드로이드에 클릭 요청");
        listener.onEvent(); // 난 무조건 얘 호출할테니까, 넌 무조건 click 호출 해.
    }

    fun tuning(){
        println("클릭 이벤트발생 시 튜닝한 것 실행...");
        click(); // 안드로이드에게도 클릭 전달
    }
}

class Click: ClickEventListener {
    override fun onEvent() {
        println("개발자가 일으킨 클릭 처리...");
    }

    fun occur() {
        clickEventListenerByDeveloper(this).tuning();
    }
}


// 1. 개발자가 클릭이벤트를튜닝 -> ClassMadeByDeveloper에 clickEventListener를 구현
// 2. 사람이 클릭이벤트를 발생시킴 -> 안드로이드가 clickEventListener를 구현한 class를 찾아 약속된 method(start()) 실행 (ClassMadeByDeveloper().start());
// 3. 사용자가 약속대로 정의한 method(onEvent)가 실행됨.

/* or */

// 1. 개발자가 약속대로 clickEventListener를 만듬 -> 무조건 같은이름, 같은 함수, 같은 method(onEvent) 호출
// 2. 사람이 클릭이벤트를 발생 시킴 -> 안드로이드는 clickEvent를 발생시킴 (click.occur()) -> 정해진 대로, tuning 한 것이 실행됨.
// 3. 개발자가 호출하고 싶을 때는, click을 호출하면 됨.