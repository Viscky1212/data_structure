package patternBase.tree;

import java.util.*;

/*

Yes 👍 **this page is the next problem after normal Level Order Traversal: Zigzag Level Order Traversal.**

Your second image shows the same **Dadaji → Papa/Chacha → children** tree, but now the direction changes at every level.

# 🌳 Zigzag Level Order Traversal

Normal level order:

```text
             Dadaji
             /    \
          Papa    Chacha
          / \      / \
       Child1 Child2 Child3 Child4
```

Normal BFS:

```text
Level 1 → Dadaji
Level 2 → Papa, Chacha
Level 3 → Child1, Child2, Child3, Child4
```

### Zigzag means alternate direction

```text
Level 1 → left  → right
Level 2 → right → left
Level 3 → left  → right
Level 4 → right → left
```

Therefore:

```text
[
   [Dadaji],
   [Chacha, Papa],
   [Child1, Child2, Child3, Child4]
]
```

---

# 🔥 Why is this different from normal Level Order?

Normal BFS always gives:

```text
left → right
```

But Zigzag requires:

```text
L → R
R → L
L → R
R → L
```

The **queue still performs BFS**. We only change the way we store/read the current level.

---

# 1. Your notebook's main idea

You already learned:

```java
int levelSize = queue.size();
```

For zigzag, add one more variable:

```java
boolean leftToRight = true;
```

Then:

```text
if leftToRight
    store normally

else
    store in reverse
```

After every level:

```java
leftToRight = !leftToRight;
```

---

# 2. Easiest Java solution

```java
public List<List<Integer>> zigzagLevelOrder(Node root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
        return result;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);

    boolean leftToRight = true;

    while (!queue.isEmpty()) {

        int levelSize = queue.size();

        List<Integer> currentLevel = new ArrayList<>();

        for (int i = 0; i < levelSize; i++) {

            Node node = queue.poll();

            currentLevel.add(node.data);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        // Reverse alternate levels
        if (!leftToRight) {
            Collections.reverse(currentLevel);
        }

        result.add(currentLevel);

        // Change direction
        leftToRight = !leftToRight;
    }

    return result;
}
```

---

# 3. Dry run — very important 🧠

Tree:

```text
             1
           /   \
          2     3
         / \   / \
        4   5 6   7
```

### Initially

```text
queue = [1]
leftToRight = true
```

### Level 1

```text
levelSize = 1

1
```

Direction:

```text
L → R
```

Result:

```text
[[1]]
```

Toggle:

```text
leftToRight = false
```

---

### Level 2

Queue:

```text
[2, 3]
```

Process:

```text
2, 3
```

But direction is now:

```text
R → L
```

So reverse:

```text
[3, 2]
```

Result:

```text
[
   [1],
   [3, 2]
]
```

Toggle:

```text
leftToRight = true
```

---

### Level 3

Queue:

```text
[4, 5, 6, 7]
```

Process:

```text
4 5 6 7
```

Direction:

```text
L → R
```

So don't reverse.

Result:

```text
[
   [1],
   [3, 2],
   [4, 5, 6, 7]
]
```

---

# ⭐ The pattern you should memorize

For **Level Order**:

```text
Queue
  ↓
levelSize
  ↓
process level
  ↓
add children
```

For **Zigzag Level Order**:

```text
Queue
  ↓
levelSize
  ↓
process level
  ↓
if direction == RIGHT
    reverse
  ↓
toggle direction
```

### One-line interview memory trick:

> **Zigzag = BFS + alternate reversal.**

---

## ⚠️ One important optimization

`Collections.reverse()` makes the solution simple and is **O(levelSize)** for each level, so overall it remains:

```text
Time  = O(N)
Space = O(N)
```

For a more optimized interview implementation, we can avoid the reversal entirely by using a **Deque** and inserting elements from the appropriate end. That's the next level of this problem and is likely what your handwritten **`push/pop` notes are moving toward.**

 */

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                Node node = queue.poll();

                currentLevel.add(node.data);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Reverse alternate levels
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);

            // Change direction
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        ZigzagLevelOrderTraversal tree = new ZigzagLevelOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> result = tree.zigzagLevelOrder(root);

        System.out.println("Zigzag Level Order Traversal of binary tree is:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
