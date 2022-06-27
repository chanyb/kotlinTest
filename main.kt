fun main(args: Array<String>) {
    /* 
     * 코틀린 컴파일 및 jvm을 이용한 실행 방법 
     * 컴파일: kotlinc [파일 또는 폴더] -include-runtime -d [파일명].jar
     * 실행: java -jar [파일명].jar
     * 
     * 메인함수 인자 전달
     * java -jar [??].jar 4 3 ...
     * 
     * *주의* 메인의 인자는, Array<String>형식이 아닌 경우 Manifest 관련 에러가 발생 할 수 있음..
     */

    println(calc(args[0].toInt(), args[1].toInt()));
}

