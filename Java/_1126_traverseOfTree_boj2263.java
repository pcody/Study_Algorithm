import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Node1126 {
    public int value;
    public Node1126 left;
    public Node1126 right;

    public Node1126(int value, Node1126 left, Node1126 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void makeLeftNode(Node1126 left) {
        this.left = left;
    }

    public void makeRightNode(Node1126 right) {
        this.right = right;
    }
}

class Tree1126 {
    public Node1126 root;

    public Tree1126(Node1126 root) {
        this.root = root;
    }

    public void inOrderTraverse(Node1126 curNode) {
        if (curNode == null) {
            return;
        }

        inOrderTraverse(curNode.left);
        System.out.print(curNode.value + " ");
        inOrderTraverse(curNode.right);
    }

    public void postOrderTraverse(Node1126 curNode) {
        if (curNode == null) {
            return;
        }

        postOrderTraverse(curNode.left);
        postOrderTraverse(curNode.right);
        System.out.print(curNode.value + " ");
    }

    public void preOrderTraverse(Node1126 curNode) {
        if (curNode == null) {
            return;
        }

        System.out.print(curNode.value + " ");
        preOrderTraverse(curNode.left);
        preOrderTraverse(curNode.right);
    }
}

public class _1126_traverseOfTree_boj2263 {
    static Tree1126 tree;
    static List<Integer> inOrder;
    static List<Integer> postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(rd.readLine());

        st = new StringTokenizer(rd.readLine());
        inOrder = new ArrayList<>();
        while (st.hasMoreTokens()) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(rd.readLine());
        postOrder = new ArrayList<>();
        while (st.hasMoreTokens()) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        Node1126 root = makeTree(n, 0, n, 0, n);
        tree = new Tree1126(root);
        tree.preOrderTraverse(root);

        rd.close();
    }

    public static Node1126 makeTree(int n, int inIdx1, int inIdx2, int postIdx1, int postIdx2) {
        int rootValue = postOrder.get(postIdx2 - 1);
        Node1126 curNode = new Node1126(rootValue, null, null);

        // left, right으로 나누고
        int ln;
        int rn;
        int idx = inIdx1;
        while (inOrder.get(idx) != rootValue) {
            idx++;
        }
        ln = idx - inIdx1;
        rn = n - ln - 1;

        // left의 root를 왼쪽으로, right의 root를 오른쪽으로
        if (ln > 0) {
            curNode.makeLeftNode(makeTree(ln, inIdx1, inIdx1 + ln, postIdx1, postIdx1 + ln));
        }
        if (rn > 0) {
            curNode.makeRightNode(
                    makeTree(rn, inIdx1 + ln + 1, inIdx1 + ln + 1 + rn, postIdx1 + ln, postIdx1 + ln + rn));
        }

        return curNode;
    }
}
