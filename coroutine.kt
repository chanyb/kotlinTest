/*
 * 코루틴
 * - 메인이 되는 루틴과, 서브 루틴으로 이루어지며 개발자가 마음대로 루틴을 실행, 중단 할 수 있다.
 * - 제어범위, 실행범위를 지정할 수 있다.
 *   1) GlobalScope - 프로그램의 어디서나 제어, 동작이 가능한 기본 범위
 *   2) CoroutineScope - 특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 새로운 코루틴의 범위를 생성
 * - Dispatcher 종류
 *   1) Dispatcher.Default - 백그라운드에서 동작
 *   2) Dispatcher.IO - 네트웤, 디스크 등 I/O에서 사용
 *   3) Dispatcher.Main - 메인스레드에서 함께 동작
 * 
 * - launch vs async : 반환값이 있느냐 없느냐의 차이 (반환필요: async)
 * 
 * - 코루틴은 제어되는 스코프 또는, 프로그램이 종료되면 함께 종료된다.
 *   코루틴의 실행을 보장하려면??
 *   1) runBlocking 블럭을 만든다.
 * 
 * - cancel
 *   조건1) 코루틴 내부의 delay() 또는, yield() 함수가 사용된 위치까지 수행된 뒤 종료
 *   조건2) 코루틴 내부에서 isActive가 false가 되므로 이를 확인하여 수동으로 종료
 * 
 * - withTimeoutOrNull(*millisecond)
 *   시간 내에 출력되지 않으면 null 반환
 */

// import kotlinx.coroutine.*;