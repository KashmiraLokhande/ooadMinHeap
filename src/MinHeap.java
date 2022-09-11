
public class MinHeap {
    class Node {
        Node left;
        Node right;
        Node parent;
        int data;
        int left_height = 0;
        int right_height = 0;
        Node(int data){
            this.data = data;
        }

    }
    Node root;
    Node newNode;
    int[] postOrderData = new int[50];
    int i =0;
    int[] preOrderData = new int[50];
    int j = 0;
    String insertNode(int data){
        int initialLeftHeight = 0;
        int initialRightHeight = 0;
        if(root == null){
            root = new Node(data);
            root.left_height = 0;
            root.right_height = 0;
//            System.out.println("root "+root.data);
        }
        else {
            initialLeftHeight = root.left_height;
            initialRightHeight = root.right_height;
            int checkData = data;
            Node checkNode = root;
            while(checkNode.left != null && checkNode.right != null ){
                    if(checkNode.data > checkData){
//                        System.out.println("Swapping check Node = "+checkNode.data+" and check Data = "+checkData);
                        checkData = swapNodeData(checkNode, checkData);
                    }
                    if(checkNode.left_height < checkNode.right_height){
                        checkNode.left_height += 1;
                        checkNode = checkNode.left;
                    }
                    else  if(checkNode.right_height < checkNode.left_height) {
                        checkNode.right_height += 1;
                        checkNode = checkNode.right;
                    }
                    else if(checkNode.left_height == checkNode.right_height){
                        checkNode.left_height += 1;
                        checkNode = checkNode.left;
                    }

                }
                if(checkNode.left == null && checkNode.right == null ){
                    if(checkNode.data > checkData){
//                        System.out.println("Swapping check Node = "+checkNode.data+" and check Data = "+checkData);
                        checkData = swapNodeData(checkNode, checkData);

                    }
                    newNode = new Node(checkData);
                    newNode.parent = checkNode;
                    checkNode.left = newNode;
                    checkNode.left_height += 1;
//                    System.out.println(newNode.data+" left child of "+newNode.parent.data);
                }
                else if(checkNode.left != null){
                    if(checkNode.data > checkData){
//                        System.out.println("Swapping check Node = "+checkNode.data+" and check Data = "+checkData);
                        checkData = swapNodeData(checkNode, checkData);

                    }
                    newNode = new Node(checkData);
                    newNode.parent = checkNode;
                    checkNode.right = newNode;
                    checkNode.right_height += 1;
//                    System.out.println(newNode.data+" right child of "+newNode.parent.data);
                }
            }
        if (root.left_height > initialLeftHeight || root.right_height > initialRightHeight) {
            return (data + " Inserted");
        }
        else if(root.data == data){
            return (data + " Inserted");
        }
        else{
            return (data + " Not Inserted");
        }
        }
        int swapNodeData(Node a, int currentData){
            int temp = a.data;
            a.data = currentData;
            currentData = temp;
            return currentData;
        }

        int[] postorder(Node currentNode)
        {
            if(currentNode == null){
                return null;
            }
            postorder(currentNode.left);
            postorder(currentNode.right);
            postOrderData[i] = currentNode.data;
            i += 1;
            return postOrderData;
        }

        int[] oddPreorder(Node currentNode)
        {
            if (currentNode == null){
                return null;
            }
            if (currentNode.data % 2 != 0) {
                preOrderData[j] = currentNode.data;
                j += 1;
            }
            oddPreorder(currentNode.left);
            oddPreorder(currentNode.right);
            return preOrderData;
        }

    public static void main(String[] args) {

    }
}
