import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

class Node1128 {
    public int value;
    public Node1128 left;
    public Node1128 right;

    public Node1128(int value, Node1128 left, Node1128 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void makeLeftChild(Node1128 left) {
        this.left = left;
    }

    public void makeRightChild(Node1128 right) {
        this.right = right;
    }
}

class Tree1128 {
    public Node1128 topNode;
    public StringBuilder sb;

    public Tree1128(Node1128 topNode) {
        this.topNode = topNode;
        sb = new StringBuilder();
    }

    public void postOrderTraverse(Node1128 curNode) {
        if (curNode == null) {
            return;
        }

        postOrderTraverse(curNode.left);
        postOrderTraverse(curNode.right);
        sb.append(curNode.value + "\n");
    }
}

public class _1128_binarySearchingTree_boj5639 {
    static Tree1128 tree;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(rd.readLine());
        Tree1128 tree = new Tree1128(new Node1128(a, null, null));

        while (true) {
            try {
                a = Integer.parseInt(rd.readLine());
                makeChild(tree.topNode, a);
            } catch (Exception e) {
                break;
            }
        }
        tree.postOrderTraverse(tree.topNode);
        System.out.println(tree.sb);
        rd.close();
    }

    public static void makeChild(Node1128 curNode, int value) {
        if (curNode.value > value) {
            if (curNode.left == null) {
                curNode.makeLeftChild(new Node1128(value, null, null));
                return;
            } else {
                makeChild(curNode.left, value);
            }
        } else {
            if (curNode.right == null) {
                curNode.makeRightChild(new Node1128(value, null, null));
                return;
            } else {
                makeChild(curNode.right, value);
            }
        }
    }
}
