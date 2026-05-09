package akhil_dsa.basic_pattern;
/*
Take this input:

```java
arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0}
```

Initial indexes:

```java
index =  0  1  2  3  4  5  6  7  8  9
arr   = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0}
```

Code logic:

```java
int left = 0;
int right = arr.length - 1;
```

So:

- `left = 0`
- `right = 9`

Now let’s trace every step.

**Iteration 1**

Check:

```java
while (left < right && arr[left] == 0)
```

- `arr[0] = 0`, so `left++`
- `left = 1`

Now stop because:

- `arr[1] = 1`

Next:

```java
while (left < right && arr[right] == 1)
```

- `arr[9] = 0`, so this loop does not move

Now:

- `left = 1`
- `right = 9`
- `arr[left] = 1`
- `arr[right] = 0`

So swap `arr[1]` and `arr[9]`

Array becomes:

```java
{0, 0, 0, 1, 0, 0, 1, 1, 1, 1}
```

Then:

- `left++` -> `2`
- `right--` -> `8`

**Iteration 2**

Now:

- `left = 2`
- `right = 8`

Check left side:

- `arr[2] = 0`, so `left++`
- `left = 3`

Now:

- `arr[3] = 1`, stop

Check right side:

- `arr[8] = 1`, so `right--`
- `right = 7`

Again:

- `arr[7] = 1`, so `right--`
- `right = 6`

Again:

- `arr[6] = 1`, so `right--`
- `right = 5`

Again:

- `arr[5] = 0`, stop

Now:

- `left = 3`
- `right = 5`
- `arr[left] = 1`
- `arr[right] = 0`

Swap `arr[3]` and `arr[5]`

Array becomes:

```java
{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
```

Then:

- `left++` -> `4`
- `right--` -> `4`

**Iteration 3**

Now:

- `left = 4`
- `right = 4`

Condition:

```java
while (left < right)
```

This is now false because `4 < 4` is false.

So loop stops.

**Final array**

```java
{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
```

**Short table**

| Step | left | right | Action | Array |
|------|------|-------|--------|-------|
| Start | 0 | 9 | Initial | `{0,1,0,1,0,0,1,1,1,0}` |
| 1 | 1 | 9 | swap `1` and `0` | `{0,0,0,1,0,0,1,1,1,1}` |
| 2 | 3 | 5 | swap `1` and `0` | `{0,0,0,0,0,1,1,1,1,1}` |
| End | 4 | 4 | stop | final |

**Why it stops**

Because once `left` and `right` meet, all `0`s are already on the left and all `1`s are on the right.

If you want, I can also write this iteration in a very simple interview-style format line by line exactly as the pointer moves.


 */


import java.util.Arrays;

public class ArrasyReArrange {
    void segregate0and1(int[] arr) {
        // code here
        int i = 0;
        int j = arr.length - 1;

        while (i < j){
            while (i < j && arr[i] == 0){
                i++;
               // System.out.println(i);
            }
            while (i < j && arr[j] == 1){
                j--;
            }

            if (i < j){
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
                 i++;
                 j--;
            }
        }


    }


    public static void main(String[] args) {
       int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};

       ArrasyReArrange sol = new ArrasyReArrange();
        sol.segregate0and1(arr);
        System.out.println(Arrays.toString(arr));

    }
}
