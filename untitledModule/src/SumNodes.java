import java.util.List;
    public class TreeSum {
        public static void main(String[] args) {
            int value;
            List<TreeSum> children;
            TreeSum(int value, List<TreeSum>chlid){
                this.value = value;
                this.children = child;
            }
            // Create the tree
            Node leaf1 = new Node(1, new ArrayList<>());
            Node leaf2 = new Node(2, new ArrayList<>());
            Node leaf3 = new Node(3, new ArrayList<>());
            Node leaf4 = new Node(4, new ArrayList<>());

            List<Node> children1 = new ArrayList<>();
            children1.add(leaf2);
            children1.add(leaf3);

            List<Node> children2 = new ArrayList<>();
            children2.add(leaf4);

            Node root = new Node(0, new ArrayList<>());
            root.children.add(leaf1);
            root.children.add(new Node(5, children1));
            root.children.add(new Node(6, children2));

            // Compute the sum
            int sum = sum(root);
            System.out.println(sum);  // Output: 21
        }

        public static int sum(Node node) {
            int sum = node.value;

            for (Node child : node.children) {
                sum += sum(child);
            }

            return sum;
        }
    }

/*
class Node {
    int value;
    List<Node> children;

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }
}

public class TreeSum {
    public static void main(String[] args) {
        // Create the tree
        Node leaf1 = new Node(1, new ArrayList<>());
        Node leaf2 = new Node(2, new ArrayList<>());
        Node leaf3 = new Node(3, new ArrayList<>());
        Node leaf4 = new Node(4, new ArrayList<>());

        List<Node> children1 = new ArrayList<>();
        children1.add(leaf2);
        children1.add(leaf3);

        List<Node> children2 = new ArrayList<>();
        children2.add(leaf4);

        Node root = new Node(0, new ArrayList<>());
        root.children.add(leaf1);
        root.children.add(new Node(5, children1));
        root.children.add(new Node(6, children2));

        // Compute the sum
        int sum = sum(root);
        System.out.println(sum);  // Output: 21
    }

    public static int sum(Node node) {
        int sum = node.value;

        for (Node child : node.children) {
            sum += sum(child);
        }

        return sum;
    }
}
 */