import java.util.*

class P946 {
    companion object {
        fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
            // pushed, popped 배열 요소로 push, pop할 stack을 정의한다.
            val stack = Stack<Int>()
            // popped 배열에 접근할 index 변수를 정의한다.
            var poppedIndex = 0

            // pushed 배열 요소를 순차적으로 하나씩 접근해,
            for (currentPushed in pushed) {
                // 정의해놓은 stack에 push한다.
                stack.push(currentPushed)

                // push한 후, stack의 가장 위의 요소가 접근한 popped 요소와 같다면 pop 시켜 주고
                // index 값을 하나 뒤로 옮겨 다음 popped 배열의 요소와 stack의 요소를 비교할 수 있게 한다.
                // stack이 비게 된다면 오류가 발생하니, 이를 검사하는 문장도 조건문에 추가한다.
                while (stack.isNotEmpty() && popped[poppedIndex] == stack.peek()) {
                    stack.pop()
                    poppedIndex++
                }
            }

            // 모든 push 연산이 끝나고, stack이 비었는지 반환한다.
            return stack.isEmpty()
        }
    }
}