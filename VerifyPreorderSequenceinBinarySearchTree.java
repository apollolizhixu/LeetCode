public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //Recursive:
        //Time: O(nlogn), Space: O(logn);
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }
        int root = preorder[start];
        if (root > max || root < min) {
            return false;
        }
        int index = start;
        while (index <= end && preorder[index] <= root) {
            index++;
        }
        return helper(preorder, start + 1, index - 1, min, root) &&
            helper(preorder, index, end, root, max);
    }

    public boolean verifyPreorder1(int[] preorder) {
        //Stack:
        //Time: O(n), Space: O(logn);
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        stack.push(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            if (stack.isEmpty() || preorder[i] < stack.peek()) {
                if(preorder[i] < min) {
                    return false;
                }
                stack.push(preorder[i]);
            } else {
                while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                    min = stack.pop();
                }
                stack.push(preorder[i]);
            }
        }
        return true;
    }
}