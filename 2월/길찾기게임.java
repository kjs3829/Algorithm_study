import java.util.*;

// Programmers Level3
// 이진탐색트리, 트리 순회
// 1시간 54분 소요
public class 길찾기게임 {
    public int[][] solution(int[][] nodeinfo) {
        int nodeCnt = nodeinfo.length;
        int[][] ni = new int[nodeCnt][3];
        for (int i=0; i<nodeCnt; i++) {
            ni[i][0] = nodeinfo[i][0];
            ni[i][1] = nodeinfo[i][1];
            ni[i][2] = i+1;
        }
        Arrays.sort(ni, (i1,i2)->i2[1]-i1[1]);

        BST bst = new BST(new Node(ni[0][0],ni[0][1],ni[0][2]));
        for (int i=1; i<nodeCnt; i++)
            bst.add(new Node(ni[i][0],ni[i][1],ni[i][2]));

        return new int[][]{bst.getPreOrder(),bst.getPostOrder()};
    }

    private class Node {
        int x, y, n;
        Node left, right;

        public Node(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    private class BST {
        Node root;

        public BST(Node root) {
            this.root = root;
        }

        public void add(Node node) {
            Node curNode = root;
            while(true) {
                if (curNode.x < node.x) {
                    if (curNode.right != null) curNode = curNode.right;
                    else {
                        curNode.right = node;
                        break;
                    }
                } else if (curNode.x >= node.x) {
                    if (curNode.left != null) curNode = curNode.left;
                    else {
                        curNode.left = node;
                        break;
                    }
                }
            }
        }

        public int[] getPreOrder() {
            List<Integer> preList = new ArrayList<>();
            preOrder(preList, root);
            int[] result = new int[preList.size()];
            int idx = 0;
            for (Integer n : preList) result[idx++] = n;
            return result;
        }

        private void preOrder(List<Integer> result, Node node) {
            if (node == null) return;
            result.add(node.n);
            preOrder(result, node.left);
            preOrder(result, node.right);
        }

        public int[] getPostOrder() {
            List<Integer> postList = new ArrayList<>();
            postOrder(postList, root);
            int[] result = new int[postList.size()];
            int idx = 0;
            for (Integer n : postList) result[idx++] = n;
            return result;
        }

        private void postOrder(List<Integer> result, Node node) {
            if (node == null) return;
            postOrder(result, node.left);
            postOrder(result, node.right);
            result.add(node.n);
        }
    }
}
