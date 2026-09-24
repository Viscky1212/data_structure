package patternBase.tree;


/*

These pages are about **Binary Tree – Mirror / Symmetric Tree**. 🌳

The main concept in your notes is:

> **Two trees are symmetric if one tree is the mirror image of the other.**

Your handwritten code is checking exactly that.

---

# 1. Understand the tree first

Your example is essentially:

```text
        1                    1
       / \                  / \
      2   3                3   2
```

The second tree is the **mirror image** of the first.

So:

```text
Tree 1                  Tree 2

    1                       1
   / \                     / \
  2   3                   3   2
```

The trees are symmetric.

---

# 2. What does "symmetric" actually mean?

For two trees:

```java
isMirror(root1, root2)
```

we need to check **three things**.

### Condition 1 — Both nodes are null

```java
if (root1 == null && root2 == null) {
    return true;
}
```

If both sides have no node:

```text
null       null
```

They match.

---

### Condition 2 — Only one is null

```java
if (root1 == null || root2 == null) {
    return false;
}
```

For example:

```text
Tree 1          Tree 2

   1               1
  /                 \
 2                   2
```

One side has a node and the other doesn't.

Therefore:

```text
false
```

---

### Condition 3 — Values must match

```java
if (root1.data != root2.data) {
    return false;
}
```

Example:

```text
Tree 1          Tree 2

   1               1
  /                 \
 2                   3
```

Here:

```text
2 != 3
```

So:

```text
false
```

---

# 3. The MOST important part of your code

Your notebook has:

```java
boolean r1 = fun(root1.left, root2.right);

boolean r2 = fun(root1.right, root2.left);
```

This is the heart of the problem. 🔥

Notice carefully:

```text
root1.left  ↔ root2.right
root1.right ↔ root2.left
```

We **cross the sides**.

Why?

Because we are checking a **mirror**, not two trees in the same direction.

---

# 4. Example from your page

Consider:

```text
Tree 1                 Tree 2

       1                   1
      / \                 / \
     2   3               3   2
```

We start:

```java
fun(1, 1)
```

Values:

```text
1 == 1
```

Now compare:

```text
Tree 1 left  = 2
Tree 2 right = 2
```

So:

```java
fun(2, 2)
```

Then compare:

```text
Tree 1 right = 3
Tree 2 left  = 3
```

So:

```java
fun(3, 3)
```

Everything matches.

Therefore:

```text
true
```

---

# 5. Why don't we compare left-left?

This is a very common interview confusion.

❌ Wrong for mirror checking:

```java
fun(root1.left, root2.left);
fun(root1.right, root2.right);
```

That checks the trees in the **same direction**.

For symmetry we need:

```java
fun(root1.left, root2.right);
fun(root1.right, root2.left);
```

Think:

```text
          1
        /   \
       2     3
```

Mirror means:

```text
LEFT  ↔ RIGHT
RIGHT ↔ LEFT
```

That's the entire trick.

---

# 6. Your recursive code cleaned up

Your notebook's logic can be written as:

```java
boolean isMirror(Node root1, Node root2) {

    // Both are empty
    if (root1 == null && root2 == null) {
        return true;
    }

    // Only one is empty
    if (root1 == null || root2 == null) {
        return false;
    }

    // Values are different
    if (root1.data != root2.data) {
        return false;
    }

    // Cross comparison
    boolean leftRight = isMirror(root1.left, root2.right);

    boolean rightLeft = isMirror(root1.right, root2.left);

    return leftRight && rightLeft;
}
```

---

# 7. If you are checking ONE tree for symmetry

LeetCode's **101. Symmetric Tree** usually gives you only one tree.

For example:

```text
        1
       / \
      2   2
     / \ / \
    3  4 4  3
```

We can treat the left and right subtrees as the two trees:

```java
public boolean isSymmetric(Node root) {

    if (root == null) {
        return true;
    }

    return isMirror(root.left, root.right);
}
```

And:

```java
private boolean isMirror(Node left, Node right) {

    if (left == null && right == null) {
        return true;
    }

    if (left == null || right == null) {
        return false;
    }

    if (left.data != right.data) {
        return false;
    }

    return isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
}
```

---

# 8. Dry run of your `1,2,3,4` example

Your second image shows this type of structure:

```text
        1
       / \
      2   3
     /     \
    4       4
```

Suppose the comparison is:

```text
Tree 1             Tree 2

   1                  1
  / \                / \
 2   3              3   2
/     \            /     \
4       4          4       4
```

Start:

```text
fun(1, 1)
```

### Step 1

```text
1 == 1
```

Continue.

### Step 2

Cross comparison:

```text
fun(Tree1.left, Tree2.right)

fun(2, 2)
```

and:

```text
fun(Tree1.right, Tree2.left)

fun(3, 3)
```

### Step 3

For `2`:

```text
left ↔ right
4    ↔ 4
```

Matches.

For `3`:

```text
right ↔ left
4     ↔ 4
```

Matches.

Eventually:

```text
null ↔ null
```

returns `true`.

So the whole tree is symmetric.

---

# 9. The recursion pattern to memorize 🧠

For **Mirror/Symmetric Tree**, remember:

```text
        root1          root2
          |              |
        compare values
              ↓
       LEFT  ↔ RIGHT
       RIGHT ↔ LEFT
```

In code:

```java
return isMirror(left.left, right.right)
    && isMirror(left.right, right.left);
```

### Your interview one-liner

> **"For a symmetric tree, I recursively compare the left subtree of one side with the right subtree of the other side, and vice versa."**

---

# 10. Complexity

For `N` nodes:

### Time

```text
O(N)
```

Every node is visited at most once.

### Space

```text
O(H)
```

where `H` is the height of the tree because of the recursion stack.

For a balanced tree:

```text
O(log N)
```

For a completely skewed tree:

```text
O(N)
```

---

## 🔥 The key difference from your previous problems

You have now covered three very important tree patterns:

```text
1. Normal Level Order
       ↓
   Queue / BFS

2. Zigzag Level Order
       ↓
   Queue + direction

3. Symmetric / Mirror Tree
       ↓
   Recursion
       ↓
   LEFT ↔ RIGHT
   RIGHT ↔ LEFT
```

The **`left ↔ right` cross-recursion** is the one thing I would make absolutely automatic in your mind for this problem.

 */
public class MirrorTree {

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);

        boolean result = tree.isMirror(root1, root2);
        System.out.println("The two trees are mirror images: " + result);
    }

    boolean isMirror(Node root1, Node root2) {

        // Both are empty
        if (root1 == null && root2 == null) {
            return true;
        }

        // Only one is empty
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different
        if (root1.data != root2.data) {
            return false;
        }

        // Cross comparison
        boolean leftRight = isMirror(root1.left, root2.right);

        boolean rightLeft = isMirror(root1.right, root2.left);

        return leftRight && rightLeft;
    }
}
