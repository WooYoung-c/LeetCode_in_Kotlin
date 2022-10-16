import kotlin.math.max

class P554 {
    // https://leetcode.com/problems/brick-wall/discuss/888577/IntuitionC%2B%2BWith-PicturesHashMapDetailed-ExplanationCommentsSolutionCode
    fun leastBricks(wall: List<List<Int>>): Int {
        // 각 row에 있는 brick들의 edge가 등장하는 빈도수를 측정할 HashMap을 선언한다.
        // Key : edge의 위치
        // Value : 그 edge가 등장하는 빈도수
        val edgeFrequency = HashMap<Int, Int>()
        // 가장 많이 등장하는 edge의 빈도수를 따로 저장할 변수를 선언한다.
        var maxFrequency = 0

        // edgeFrequency의 내용을 채울 반복문을 실행한다.
        // 우선, wall의 각 row에 접근한다.
        for (row in wall.indices) {
            // edge가 등장하는 위치, 즉 edgeFrequency의 key 값으로 쓰일 변수를 선언한다.
            var edgePosition = 0

            // 각 row에 있는 brick들에 접근하여 edge를 계산한다.
            // 이 때, 시작점과 가장 끝점의 edge는 제외한다 => wall[row].size에 1을 뺀 위치까지만 탐색하는 이유
            for (brick in 0 until wall[row].size - 1) {
                // edge의 위치는 "한 row에 있는 brick들의 사이 = 0에서 각각 brick들의 길이를 더한 값"만큼으로 표현될 수 있다.
                // 따라서 edgePosition은 한 row에 있는 brick들의 길이를 순차적으로 더해 계산할 수 있다.
                // ex. 한 row가 1 2 2 1인 brick들로 이루어져 있다면 각 edge의 위치는 1, 3, 5.
                val currentBrickLength = wall[row][brick]
                edgePosition += currentBrickLength
                // 그렇게 계산한 edge의 위치가 얼만큼 등장하는지 edgeFrequency에 저장한다.
                if (edgeFrequency.contains(edgePosition)) {
                    edgeFrequency[edgePosition] = edgeFrequency[edgePosition]!! + 1
                } else {
                    edgeFrequency[edgePosition] = 1
                }
                // 가장 많이 등장한 edge의 빈도수를 max를 통해 유지한다.
                maxFrequency = max(edgeFrequency[edgePosition]!!, maxFrequency)
            }
        }

        // 통과해야 하는 최소의 brick 수 = 전체 row 수 - 가장 많이 공유되는 edge 수 = 그 edge를 공유하지 못한 row 수
        return wall.size - maxFrequency
    }
}