class Solution {
    data class Node(val idx: Int, val v: Int) {
        var parent: Node? = null
        var childLeft: Node? = null
        var childRight: Node? = null
    }

    private lateinit var nodes: MutableList<Node>
    private lateinit var nums: IntArray
    private var cntGroup = 0

    // 루트 노드를 찾는 함수
    private fun findRoot(): Int {
        for (node in nodes) {
            if (node.parent == null) {
                return node.idx
            }
        }
        return -1  // 루트가 없을 경우를 대비한 처리
    }

    fun solution(k: Int, num: IntArray, links: Array<IntArray>): Int {
        nums = num
        nodes = MutableList(nums.size) { idx -> Node(idx, nums[idx]) }

        for (idx in links.indices) {
            val (left, right) = links[idx]
            if (left != -1) {
                nodes[idx].childLeft = nodes[left]
                nodes[left].parent = nodes[idx]
            }
            if (right != -1) {
                nodes[idx].childRight = nodes[right]
                nodes[right].parent = nodes[idx]
            }
        }

        val rootNode = nodes[findRoot()]

        if (k == 1) {
            return nums.sum()
        }

        var limitLow = nums.maxOrNull()!!
        var limitHigh = nums.sum() + 1

        while (limitLow <= limitHigh) {
            val limitMid = (limitLow + limitHigh) / 2

            if (getGroupCount(limitMid, rootNode) <= k) {
                limitHigh = limitMid - 1
            } else {
                limitLow = limitMid + 1
            }
        }

        return limitLow
    }

    // 그룹의 개수를 구하는 함수
    private fun getGroupCount(limit: Int, rootNode: Node): Int {
        cntGroup = 0
        dfs(limit, rootNode)
        return cntGroup + 1
    }

    // DFS 함수
    private fun dfs(limit: Int, node: Node): Int {
        var leftV = 0
        var rightV = 0

        node.childLeft?.let {
            leftV = dfs(limit, it)
        }

        node.childRight?.let {
            rightV = dfs(limit, it)
        }

        // 그룹 크기가 limit 이하일 경우
        if (node.v + leftV + rightV <= limit) {
            return node.v + leftV + rightV
        }

        // 자식 중 하나를 포함시킬 수 있을 때
        if (node.v + minOf(leftV, rightV) <= limit) {
            cntGroup += 1
            return node.v + minOf(leftV, rightV)
        }

        // 현재 노드를 독립적으로 그룹으로 처리해야 할 때
        cntGroup += 2
        return node.v
    }
}
