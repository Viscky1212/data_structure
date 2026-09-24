package patternBase.tree;


/*
Yes 👍 This page is specifically showing the **dry run of Invert Binary Tree**. Your recursion is correct. Let’s trace exactly what happens.

## 🌳 Original tree

From your page:

```text
          1
        /   \
       2     3
            / \
           4   5
```

The goal of **invert tree** is to swap `left` and `right` at **every node**.

Expected final tree:

```text
          1
        /   \
       3     2
      / \
     5   4
```

---

# 1. Your code

You wrote essentially:

```java
void fun(Node root) {

    if (root == null) {
        return;
    }

    // Swap
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively process children
    fun(root.left);
    fun(root.right);
}
```

This is correct. ✅

---

# 2. Step 1 — Start at node `1`

Initially:

```text
        1
       / \
      2   3
         / \
        4   5
```

Call:

```java
fun(1);
```

At node `1`:

```text
root.left  = 2
root.right = 3
```

Swap:

```text
root.left  = 3
root.right = 2
```

Tree becomes:

```text
        1
       / \
      3   2
     / \
    4   5
```

⚠️ Notice something important:

After swapping, `root.left` is now **3**, not 2.

Therefore the next call is:

```java
fun(root.left);
```

which means:

```java
fun(3);
```

This is exactly the point your right page is trying to demonstrate.

---

# 3. Step 2 — Go to node `3`

We now have:

```text
        1
       / \
      3   2
     / \
    4   5
```

Call:

```java
fun(3);
```

Before swap:

```text
3.left  = 4
3.right = 5
```

Swap:

```text
3.left  = 5
3.right = 4
```

Tree:

```text
        1
       / \
      3   2
     / \
    5   4
```

Then:

```java
fun(3.left);
```

means:

```java
fun(5);
```

---

# 4. Step 3 — Node `5`

Node `5` is a leaf:

```text
5.left  = null
5.right = null
```

Call:

```java
fun(5);
```

It doesn't have children.

Eventually:

```java
fun(null);
```

hits:

```java
if (root == null) {
    return;
}
```

Then recursion comes back.

---

# 5. Step 4 — Node `4`

After finishing node `5`, recursion returns to node `3`.

Then:

```java
fun(root.right);
```

At this point:

```text
3.right = 4
```

So:

```java
fun(4);
```

Again `4` is a leaf.

Return.

---

# 6. Step 5 — Return to node `1`

Now the entire left side of node `1` has been inverted:

```text
        1
       / \
      3   2
     / \
    5   4
```

Now execute:

```java
fun(root.right);
```

At node `1`:

```text
root.right = 2
```

So:

```java
fun(2);
```

Node `2` is a leaf.

Return.

Final tree:

```text
        1
       / \
      3   2
     / \
    5   4
```

---

# 🔥 The most important thing to understand

Your code does:

```java
swap(root.left, root.right);

fun(root.left);
fun(root.right);
```

The recursive calls happen **after the swap**.

Therefore:

```text
Before swap:

        1
       / \
      2   3

root.left  = 2
root.right = 3
```

After swap:

```text
        1
       / \
      3   2

root.left  = 3
root.right = 2
```

So:

```java
fun(root.left);
```

now means:

```java
fun(3);
```

**not** `fun(2)`.

That's the key observation in your handwritten dry run.

---

# 🧠 Call stack view

Your recursion can be visualized as:

```text
fun(1)
  |
  |-- swap 1
  |
  |-- fun(3)
  |     |
  |     |-- swap 3
  |     |
  |     |-- fun(5)
  |     |     |
  |     |     └── return
  |     |
  |     |-- fun(4)
  |           |
  |           └── return
  |
  |-- fun(2)
        |
        └── return
```

So the important sequence is:

```text
1
↓
3
↓
5
↓
4
↓
2
```

while the **final tree** is:

```text
          1
        /   \
       3     2
      / \
     5   4
```

---

# ⚠️ One thing to be careful about

If you wrote:

```java
Node temp = root.left;
root.left = root.right;
root.right = temp;
```

that's good.

Don't do this:

```java
root.left = root.right;
root.right = root.left; // ❌
```

Because after the first assignment, both references point to the same node.

Correct:

```java
Node temp = root.left;

root.left = root.right;

root.right = temp;
```

---

## Interview pattern 🧠

For **Invert Binary Tree**, remember only this:

```text
                 INVERT
                   ↓
             swap L and R
                   ↓
           recurse on children
```

```java
public Node invertTree(Node root) {

    if (root == null) {
        return null;
    }

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
}
```

### Complexity

```text
Time  : O(N)
Space : O(H)
```

Where `N` is the number of nodes and `H` is the tree height.


 */
public class InvertTree {
    public Node invertTree(Node root) {

        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    void fun(Node root) {

        if (root == null) {
            return;
        }

        // Swap
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively process children
        fun(root.left);
        fun(root.right);
    }
    public static void main(String[] args) {
        InvertTree tree = new InvertTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder traversal of original binary tree is:");
        tree.inorderTraversal(root);

        tree.invertTree(root);

        System.out.println("Inorder traversal of inverted binary tree is:");
        tree.inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}
