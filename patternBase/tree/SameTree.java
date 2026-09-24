package patternBase.tree;
/*
Exactly. 👍 These pages now cover **three separate Binary Tree interview problems**:

1. **Same Tree**
2. **Symmetric Tree**
3. **Invert Binary Tree**

The first two are closely related, but **Invert Tree is a transformation**, not a comparison.

---

# 1. Same Tree

### Problem

Given two binary trees, determine whether they are **exactly identical**.

Example:

```text
Tree 1              Tree 2

    1                   1
   / \                 / \
  2   3               2   3
```

Result:

```text
true
```

Because:

* Same structure
* Same values

---

## Your recursive logic

```java
boolean sameTree(Node root1, Node root2) {

    // Both are null
    if (root1 == null && root2 == null) {
        return true;
    }

    // Only one is null
    if (root1 == null || root2 == null) {
        return false;
    }

    // Values are different
    if (root1.data != root2.data) {
        return false;
    }

    boolean left = sameTree(root1.left, root2.left);

    boolean right = sameTree(root1.right, root2.right);

    return left && right;
}
```

### Key point 🧠

For **Same Tree**:

```text
LEFT  ↔ LEFT
RIGHT ↔ RIGHT
```

Remember:

```text
Same Tree
    ↓
same direction
    ↓
L ↔ L
R ↔ R
```

---

# 2. Symmetric Tree

This is what you were studying on the previous page.

Example:

```text
        1
       / \
      2   2
     / \ / \
    3  4 4  3
```

This is symmetric because the right side is the mirror of the left side.

The important comparison is:

```text
LEFT  ↔ RIGHT
RIGHT ↔ LEFT
```

Code:

```java
boolean isMirror(Node root1, Node root2) {

    if (root1 == null && root2 == null) {
        return true;
    }

    if (root1 == null || root2 == null) {
        return false;
    }

    if (root1.data != root2.data) {
        return false;
    }

    boolean leftRight =
            isMirror(root1.left, root2.right);

    boolean rightLeft =
            isMirror(root1.right, root2.left);

    return leftRight && rightLeft;
}
```

Then:

```java
boolean isSymmetric(Node root) {
    return isMirror(root.left, root.right);
}
```

---

# 3. The BIG difference between Same and Symmetric

This is probably the most important thing from your notes.

### Same Tree

```text
Tree 1              Tree 2

    1                   1
   / \                 / \
  2   3               2   3
```

Compare:

```text
root1.left  ↔ root2.left
root1.right ↔ root2.right
```

### Symmetric Tree

```text
Tree 1              Tree 2

    1                   1
   / \                 / \
  2   3               3   2
```

Compare:

```text
root1.left  ↔ root2.right
root1.right ↔ root2.left
```

### Memorize this table 🧠

| Problem              | Left comparison | Right comparison |
| -------------------- | --------------- | ---------------- |
| **Same Tree**        | L ↔ L           | R ↔ R            |
| **Symmetric/Mirror** | L ↔ R           | R ↔ L            |

This single distinction solves a lot of confusion.

---

# 4. Invert Binary Tree

Your third question is:

> **Invert Tree**

This is different.

We don't compare two trees.

We **modify one tree**.

Suppose:

```text
        1
       / \
      2   3
     / \   \
    4   5   6
```

After inversion:

```text
        1
       / \
      3   2
     /   / \
    6   5   4
```

Every node's:

```text
left ↔ right
```

is swapped.

---

# 5. Recursive Invert Tree

The clean Java implementation:

```java
public Node invertTree(Node root) {

    // Empty tree
    if (root == null) {
        return null;
    }

    // Swap left and right
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively invert left subtree
    invertTree(root.left);

    // Recursively invert right subtree
    invertTree(root.right);

    return root;
}
```

---

# 6. Dry run

Suppose:

```text
        1
       / \
      2   3
```

Start:

```java
invertTree(1)
```

At node `1`:

```text
left  = 2
right = 3
```

Swap:

```text
left  = 3
right = 2
```

Tree becomes:

```text
        1
       / \
      3   2
```

Then recursively process:

```text
invertTree(3)
invertTree(2)
```

Since both are leaves:

```text
return
```

Final:

```text
        1
       / \
      3   2
```

---

# 7. One subtle point about your notes

You wrote something like:

```text
fun(root.left)
fun(root.right)
```

after swapping.

That works.

But you could also recursively process the children **before** swapping:

```java
public Node invertTree(Node root) {

    if (root == null) {
        return null;
    }

    invertTree(root.left);
    invertTree(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
}
```

Both approaches produce the same final inverted tree.

---

# 8. Complexity

For all three problems:

### Same Tree

```text
Time  = O(N)
Space = O(H)
```

### Symmetric Tree

```text
Time  = O(N)
Space = O(H)
```

### Invert Tree

```text
Time  = O(N)
Space = O(H)
```

Where:

* `N` = number of nodes
* `H` = tree height

For a skewed tree:

```text
H = N
```

so recursion space can become:

```text
O(N)
```

---

# 🧠 Your Tree Pattern Sheet

Based on the progression in your notebook, I would memorize these three like this:

```text
                 BINARY TREE
                      |
        ┌─────────────┼──────────────┐
        ↓             ↓              ↓
    SAME TREE      SYMMETRIC      INVERT
        |             |              |
   Compare         Compare         Modify
        |             |              |
   L ↔ L           L ↔ R          swap L/R
   R ↔ R           R ↔ L
```

### 🔥 Three one-line rules

**Same Tree**

```java
same(left1, left2) && same(right1, right2)
```

**Symmetric Tree**

```java
mirror(left1, right2) && mirror(right1, left2)
```

**Invert Tree**

```java
swap(root.left, root.right)
```

If you make these three patterns automatic, a large class of basic recursive binary-tree questions becomes much easier. 🌳

 */
public class SameTree {

    boolean sameTree(Node root1, Node root2) {

        // Both are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // Only one is null
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different
        if (root1.data != root2.data) {
            return false;
        }

        boolean left = sameTree(root1.left, root2.left);

        boolean right = sameTree(root1.right, root2.right);

        return left && right;
    }

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        boolean result = tree.sameTree(root1, root2);
        System.out.println("The two trees are the same: " + result);
    }
}
