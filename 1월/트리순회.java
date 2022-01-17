import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// BOJ 1991 SILVER1
// 트리, 재귀
// 1시간 이상 소요
public class 트리순회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, Node> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String p = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            Node node,left,right;
            if (map.containsKey(p)) node = map.get(p);
            else {
                node = new Node(p);
                map.put(p,node);
            }
            if (map.containsKey(l)) {
                left = map.get(l);
                node.setLeft(left);
            }
            else if (!l.equals(".")){
                left = new Node(l);
                map.put(l,left);
                node.setLeft(left);
            }
            if (map.containsKey(r)) {
                right = map.get(r);
                node.setRight(right);
            }
            else if (!r.equals(".")){
                right = new Node(r);
                map.put(r,right);
                node.setRight(right);
            }

        }
        Node tree = map.get("A");
        System.out.println(preorder(tree));
        System.out.println(inorder(tree));
        System.out.println(postorder(tree));
    }

    public static class Node {
        private String c;
        private Node left;
        private Node right;

        public Node(String c) {
            this.c = c;
        }

        public String getC() {
            return c;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static String preorder(Node n) {
        if (n == null) return "";
        return n.getC() + preorder(n.getLeft()) + preorder(n.getRight());
    }

    public static String inorder(Node n) {
        if (n == null) return "";
        return inorder(n.getLeft()) + n.getC() + inorder(n.getRight());
    }

    public static String postorder(Node n) {
        if (n == null) return "";
        return postorder(n.getLeft()) + postorder(n.getRight()) + n.getC();
    }
}
