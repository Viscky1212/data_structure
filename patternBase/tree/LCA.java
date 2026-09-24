package patternBase.tree;


/*

Yes 👍 These pages are your **LCA — Lowest Common Ancestor** notes. The recursion you wrote is the standard **Binary Tree LCA** approach.

Your notes are using an example roughly like:

```text
             1
           /   \
          2     3
         / \
        4   5
           /
          6
```

And you are considering:

```text
p = 4
q = 6
```

The **LCA of 4 and 6 is 2**.

---

# 1. What is LCA?

**Lowest Common Ancestor** means:

> The deepest/lowest node in the tree that is an ancestor of both `p` and `q`.

For:

```text
             1
           /   \
          2     3
         / \
        4   5
           /
          6
```

Paths are:

```text
4 → 2 → 1
6 → 5 → 2 → 1
```

Common ancestors:

```text
1
2
```

The lowest one is:

```text
2
```

Therefore:

```text
LCA(4, 6) = 2
```

---

# 2. The most important LCA recursion

Your notebook has this idea:

```java
left  = fun(node.left, p, q);
right = fun(node.right, p, q);

if (left != null && right != null) {
    return node;
}
```

This is the **heart of LCA**. 🔥

Why?

If:

```text
left != null
```

means:

> One target was found in the left subtree.

And:

```text
right != null
```

means:

> The other target was found in the right subtree.

Therefore:

```text
       node
      /    \
     p      q
```

The current `node` must be their common ancestor.

---

# 3. Your complete algorithm

Clean Java version:

```java
public Node lowestCommonAncestor(Node root, Node p, Node q) {

    // Base case
    if (root == null) {
        return null;
    }

    // If current node itself is p or q
    if (root == p || root == q) {
        return root;
    }

    // Search in left subtree
    Node left = lowestCommonAncestor(root.left, p, q);

    // Search in right subtree
    Node right = lowestCommonAncestor(root.right, p, q);

    // One target found on each side
    if (left != null && right != null) {
        return root;
    }

    // Return whichever side found something
    if (left != null) {
        return left;
    }

    return right;
}
```

This is exactly the logic your handwritten pages are developing.

---

# 4. Now let's do YOUR dry run

Tree:

```text
             1
           /   \
          2     3
         / \
        4   5
           /
          6
```

Target:

```text
p = 4
q = 6
```

We start:

```java
LCA(1, 4, 6)
```

Node `1` isn't `4` or `6`.

So:

```text
left  = LCA(2, 4, 6)
right = LCA(3, 4, 6)
```

---

# 5. Go into node 2

```text
LCA(2, 4, 6)
```

Node `2` isn't `4` or `6`.

So:

```text
left  = LCA(4, 4, 6)
right = LCA(5, 4, 6)
```

---

# 6. Node 4 🔥

Now:

```java
LCA(4, 4, 6)
```

We immediately hit:

```java
if (root == p || root == q) {
    return root;
}
```

Because:

```text
root = 4
p    = 4
```

Therefore:

```text
return 4
```

So back at node `2`:

```text
left = 4
```

---

# 7. Now go to node 5

We need:

```java
LCA(5, 4, 6)
```

Node `5` isn't `4` or `6`.

So:

```text
left  = LCA(null, 4, 6)
right = LCA(6, 4, 6)
```

Left:

```text
LCA(null) → null
```

Right:

```text
LCA(6, 4, 6)
```

---

# 8. Node 6

Node `6` is `q`.

Therefore:

```java
return 6;
```

So at node `5`:

```text
left  = null
right = 6
```

This condition:

```java
if (left != null && right != null)
```

is false.

Therefore:

```java
return right;
```

So:

```text
LCA(5, 4, 6) → 6
```

---

# 9. Now return to node 2

We have:

```text
left  = 4
right = 6
```

🔥 This is the critical moment.

Both are non-null:

```text
left  != null
right != null
```

Therefore:

```java
if (left != null && right != null) {
    return root;
}
```

Current root is:

```text
2
```

Therefore:

```text
return 2;
```

So:

```text
LCA(2, 4, 6) = 2
```

---

# 10. What happens to node 1?

We return back to:

```text
LCA(1, 4, 6)
```

The left side gives:

```text
left = 2
```

Now we search the right subtree:

```text
LCA(3, 4, 6)
```

There is no `4` or `6` there.

Therefore:

```text
right = null
```

At node `1`:

```text
left  = 2
right = null
```

Since both aren't non-null:

```java
if (left != null && right != null)
```

is false.

Then:

```java
return left;
```

Therefore:

```text
return 2
```

Final answer:

```text
LCA = 2
```

---

# 🧠 The entire recursion in one picture

```text
                     LCA(1)
                    /      \
               LCA(2)     LCA(3)
               /    \          \
          LCA(4)   LCA(5)      null
             ↓       |
             4      LCA(6)
                     ↓
                     6
```

At node `2`:

```text
          2
         / \
        4   6
        ↑   ↑
      left right
```

Both sides returned something.

Therefore:

```text
             2
            / \
         found found
            ↓   ↓
            4   6

          LCA = 2
```

That's the central LCA concept. 🔥

---

# 11. Why do we return `left` or `right`?

Your notes show:

```text
if left != null
    return left

else
    return right
```

This is important.

Suppose only `p` exists in the left subtree:

```text
        1
       / \
      2   3
     /
    p
```

At node `1`:

```text
left = p
right = null
```

We don't know yet whether `q` will be found higher up.

So we propagate:

```text
p
```

upward.

That's why we return whichever side is non-null.

---

# 12. Why check `root == p || root == q` first?

This is another important interview point.

Suppose:

```text
       1
      /
     2
    /
   4
```

and:

```text
p = 2
q = 4
```

When recursion reaches `2`:

```java
root == p
```

So immediately:

```java
return root;
```

This correctly allows `2` to become the LCA.

In other words:

> **A target node can itself be the LCA of the other target and itself.**

---

# 13. Your handwritten logic in compact form

You can memorize your notebook as these **4 steps**:

### Step 1 — Null

```java
if (root == null) {
    return null;
}
```

### Step 2 — Found target

```java
if (root == p || root == q) {
    return root;
}
```

### Step 3 — Search both sides

```java
Node left = lca(root.left, p, q);
Node right = lca(root.right, p, q);
```

### Step 4 — Decide

```java
if (left != null && right != null) {
    return root;
}

return left != null ? left : right;
```

---

# 14. Same Tree vs Symmetric vs Invert vs LCA

You are now building a very useful recursion pattern set:

| Problem            | Core recursion                                        |
| ------------------ | ----------------------------------------------------- |
| **Same Tree**      | `L ↔ L`, `R ↔ R`                                      |
| **Symmetric Tree** | `L ↔ R`, `R ↔ L`                                      |
| **Invert Tree**    | Swap `L` and `R`                                      |
| **LCA**            | Search `L` + Search `R`; if both found → current node |

The LCA pattern is:

```text
                root
               /    \
              ↓      ↓
          search    search
           left      right
              \      /
               \    /
              both found
                  ↓
                ROOT
```

---

## Complexity

For a normal binary tree:

```text
Time  = O(N)
Space = O(H)
```

`N` = number of nodes, `H` = tree height.

For a skewed tree:

```text
H = N
```

so recursion space becomes:

```text
O(N)
```

For a balanced tree:

```text
H = log N
```

so recursion space is:

```text
O(log N)
```

### 🔑 Interview sentence

> **"I recursively search both subtrees. If both sides return a non-null node, the current node is the Lowest Common Ancestor; otherwise, I propagate the non-null result upward."**

That's the exact reasoning behind the LCA code in your notebook. 🌳

 */
public class LCA {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        // Base case
        if (root == null) {
            return null;
        }

        // If current node itself is p or q
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        Node left = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        Node right = lowestCommonAncestor(root.right, p, q);

        // One target found on each side
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found something
        if (left != null) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {
        LCA tree = new LCA();
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        Node p = root.left; // Node with value 5
        Node q = root.left.right.right; // Node with value 4

        Node lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is: " + lca.data);
    }
}
