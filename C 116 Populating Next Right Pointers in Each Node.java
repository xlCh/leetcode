//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//         1
//       /  \
//      2    3
//     / \  / \
//    4  5  6  7

//      to

//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \  / \
//    4->5->6->7 -> NULL
//这种效率太低，一种最快的方法，链了下一层再遍历：https://leetcode.com/discuss/87477/share-my-loop-java-1ms-solution-easy-understand
public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
        queue1.add(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            while(!queue1.isEmpty()) {
                TreeLinkNode temp = queue1.remove();
                if(queue1.isEmpty()) {
                    temp.next = null;
                }
                else {
                    temp.next = queue1.element();
                }
                if(temp.left != null)
                    queue2.add(temp.left);
                if(temp.right != null)
                    queue2.add(temp.right);
            }
            while(!queue2.isEmpty()) {
                TreeLinkNode temp = queue2.remove();
                if(queue2.isEmpty()) {
                    temp.next = null;
                }
                else {
                    temp.next = queue2.element();
                }
                if(temp.left != null)
                    queue1.add(temp.left);
                if(temp.right != null)
                    queue1.add(temp.right);
            }
        }
    }
