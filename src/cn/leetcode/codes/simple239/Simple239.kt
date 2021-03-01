package cn.leetcode.codes.simple239

import cn.leetcode.codes.out
import java.util.*

fun main() {

    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    out(maxSlidingWindow(nums, 3).contentToString())

}

/*

239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。



示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.size < 2) return nums

    val list = LinkedList<Int>()

    val ans = IntArray(nums.size - k + 1)

    nums.forEachIndexed { i, _ ->
        //保证从大到小排列
        while (list.isNotEmpty() && nums[list.peekLast()] <= nums[i]) {
            list.pollLast()
        }
        //添加到队列尾部
        list.addLast(i)

        if (list.peek() <= i - k) {
            list.poll()
        }
        if (i + 1 >= k) {
            ans[i + 1 - k] = nums[list.peek()]
        }
    }
    return ans
}