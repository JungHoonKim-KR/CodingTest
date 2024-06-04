import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
class Node {
    int data;
    String color;
    Node left, right, parent;
    Node(int data, String color) {
        this.data = data;
        this.color = color;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
class RedBlackTree {
    Node root = null;
    void insert(int data) {
        Node node = new Node(data, "RED");
        root = insertNode(root, node);
        root.color = "BLACK";
        insertfix(node);
    }
    void delete(int data) {
        Node target = findNode(root, data);
        deleteNode(target);
    }
    private Node deleteNode(Node target) {
        Node targetNode = null;
        Node successor = new Node(-1, "BLACK");
        if (target.left.data == -1 || target.right.data == -1) {
            targetNode = target;
        } else targetNode = findSuccessor(target.right);
        if (targetNode.left.data != -1) {
            successor = targetNode.left;
        } else if (targetNode.right.data != -1)
            successor = targetNode.right;
        if (successor != null)
            successor.parent = targetNode.parent;
        if (targetNode.parent == null)
            root = successor;
        else if (targetNode == targetNode.parent.left)
            targetNode.parent.left = successor;
        else targetNode.parent.right = successor;

        if (targetNode != target)
            target.data = targetNode.data;
        if (targetNode.color.equals("BLACK")) {
            deleteFix(successor);
        }
        return target;
    }
    private void deleteFix(Node node) {
        Node brother = null;
        while (node != root && node.color.equals("BLACK")) {
            if (node == node.parent.left) {
                brother = node.parent.right;
                if (brother.color.equals("RED")) {
                    brother.color = "BLACK";
                    node.parent.color = "RED";
                    leftRotate(node.parent);
                    brother = node.parent.right;
                }
                if (brother.left.color.equals("BLACK") && brother.right.color.equals("BLACK")) {
                    brother.color = "RED";
                    node = node.parent;
                } else {
                    if (brother.right.color.equals("BLACK")) {
                        brother.color = "RED";
                        brother.left.color = "BLACK";
                        rightRotate(brother);
                        brother = node.parent.right;
                    }
                    brother.color = node.parent.color;
                    node.parent.color = "BLACK";
                    brother.right.color = "BLACK";
                    leftRotate(node.parent);
                    node = root;
                }
            }
            else if (node == node.parent.right) {
                brother = node.parent.left;
                if (brother.color.equals("RED")) {
                    brother.color = "BLACK";
                    node.parent.color = "RED";
                    rightRotate(node.parent);
                    brother = node.parent.left;
                }
                if (brother.right.color.equals("BLACK") && brother.left.color.equals("BLACK")) {
                    brother.color = "RED";
                    node = node.parent;
                }
                else {
                    if (brother.left.color.equals("BLACK")) {
                        brother.color = "RED";
                        brother.right.color = "BLACK";
                        leftRotate(brother);
                        brother = node.parent.left;
                    }

                    brother.color = node.parent.color;
                    node.parent.color = "BLACK";
                    brother.left.color = "BLACK";
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }
        node.color="BLACK";
    }
    String findColor ( int data){
        Node node = findNode(root, data);
        return node.color;
    }
    private Node findNode (Node treeNode,int data){
        if (treeNode.data == data) {
            return treeNode;
        } else if (treeNode.data < data) {
            return findNode(treeNode.right, data);
        } else {
            return findNode(treeNode.left, data);
        }
    }
    private Node findSuccessor (Node node){
        while (node.left.data != -1) {
            node = node.left;
        }
        return node;
    }
    private void changeColor (Node node){
        if (node.color.equals("RED"))
            node.color = "BLACK";
        else node.color = "RED";
    }
    private void addDummyChildren (Node node){
        if (node.left == null) {
            node.left = new Node(-1, "BLACK");
            node.left.parent = node;
        }
        if (node.right == null) {
            node.right = new Node(-1, "BLACK");
            node.right.color = "BLACK";
            node.right.parent = node;
        }
    }
    private Node insertNode (Node root, Node node){
        if (root == null) {
            addDummyChildren(node);
            return node;
        }
        else if (node.data < root.data) {
            if (root.left.data == -1) {
                root.left = node;
                node.parent = root;
                addDummyChildren(node);
            } else
                insertNode(root.left, node);
        } else {
            if (root.right.data == -1) {
                root.right = node;
                node.parent = root;
                addDummyChildren(node);
            } else
                insertNode(root.right, node);
        }
        return root;
    }
    private void leftRotate (Node x){
        Node y = x.right;
        x.right = y.left;
        if(y.left.data != -1)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }
    private void rightRotate (Node x){
        Node y = x.left;
        x.left = y.right;
        if(y.right.data != -1)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else x.parent.right = y;
        y.right = x;
        x.parent = y;
    }
    private void insertfix (Node node){
        Node parent = null;
        Node grandParent = null;
        while (node != root && node.color.equals("RED") && node.parent.color.equals("RED") && node.parent.parent != null) {
            parent = node.parent;
            grandParent = parent.parent;
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.color.equals("RED")) {
                    changeColor(parent);
                    changeColor(grandParent);
                    changeColor(uncle);
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        leftRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rightRotate(grandParent);
                    grandParent.color = "RED";
                    parent.color = "BLACK";
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.color.equals("RED")) {
                    changeColor(parent);
                    changeColor(grandParent);
                    changeColor(uncle);
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rightRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftRotate(grandParent);
                    grandParent.color = "RED";
                    parent.color = "BLACK";
                }
            }
        }
        root.color = "BLACK";
    }
}
public class rbt {
    public static void main(String[] args) throws IOException {
        File file1 = new File("rbt.inp");
        File file2 = new File("rbt.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer st;
        String command, line;
        int data;
        RedBlackTree rbt = new RedBlackTree();
        while ((line = bufferedReader.readLine()) != null) {
            st = new StringTokenizer(line);
            command = st.nextToken();
            data = Integer.parseInt(st.nextToken());
            if (data != -1) {
                if (command.equals("i")) {
                    rbt.insert(data);
                } else if (command.equals("d")) {
                    rbt.delete(data);
                } else if (command.equals("c")) {
                    fileWriter.write("color(" + data + "): " + rbt.findColor(data) + "\n");
                }
            } else {
                fileWriter.flush();
                fileWriter.close();
            }
        }

    }
}
