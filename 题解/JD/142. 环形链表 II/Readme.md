### **142. 环形链表 II**
🔗 [leetcode 142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/)

#### 题意：
给出一个链表，链表包含本身数值和下一个数据的地址。需要判断出此链表存不存在环形结构，返回入环的节点。
#### 思路：
若链表有环，那么循环链表的话会永远找不到出口，可以利用这个特性，就像人在操场跑步，只要第一名足够快，第一名和最后一名一定会相遇，在链表中循环也是一样利用套圈会相遇的特点，使用两个循环若相遇（相同值）就是有环，否则无环。

但是有个问题，虽然能相遇，但是不一定是在开始循环的节点相遇，还需要计算出入环节点。

这个时候就需要公式推导了（为什么公式可以推导？因为这个是有规律的）
我们称快的为fast，慢的为slow。为了好计算，fast的速度是2，slow为1，即fast一次循环两个节点，slow为一个。

- 以路程为视角，S(fast) = 2S(slow)
- 以fast追slow为视角，追了n圈才相遇，S(fast)=S(slow) + n * S(环长度)
- 得出S(slow) = n * S(环长度)
- 以slow为视角，S(slow) = res + m * S(环长度)

res为从起点到入环的距离，即slow再走res步就是答案。换个说法，从head走res步也是入环节点，那么从head和slow位置同时走，走res步则会相遇，只要判断相遇，相遇的点就是入环点，就是答案。

有了思路，剩下的是转换为代码

#### 参考
- [参考博文](https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/)