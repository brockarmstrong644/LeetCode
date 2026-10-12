// Accepted and Run with a runtime of 1ms
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(); //Creates empty queue to hold nodes waiting to be visited, LinkedList allows for 'null' values
        q.add(root); // L1 is the root, so it goes in the queue first

        while (!q.isEmpty()) { // Continues as long as something is waiting in the queue
            int size =q.size(); // at execution, this is exactly the number of spots on the level, null cells included
            List<Integer> level = new ArrayList<>(); // Create a fresh list for each level's values. Uses 'Integer' so it has the ability to hold null values

                for (int i = 0; i < size; i++){  // Runs 'size' times, once per cell per level
                    TreeNode node = q.poll(); // takes next item off front of queue

                    if (node == null){ //If a spot it null it records it in the level list
                        level.add(null);
                        continue;
                    }

                    level.add(node.val); // record real nodes value
                    q.add(node.left); // put children in the back of the queue
                    q.add(node.right);
                }
            if (!isPalindrome(level)) return false; // if a level doesnt read the same both ways the tree cant be symmetric, returns false immediatley without checking the remaining levels
        }
            return true; // only runs if every level passed after loop finishes
    }

    private boolean isPalindrome(List<Integer> level) {
        int left = 0;
        int right = level.size() - 1;
        while(left < right) {
        // Objects.equals safely handles 'null' values
        if (!Objects.equals(level.get(left),level.get(right))) return false;
        left++;
        right--;
    }
    return true;
    }
}
