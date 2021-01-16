public class BinaryTree<T> {
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    private T value;
    public BinaryTree(T value) {
        leftChild = null;
        rightChild = null;
        this.value = value;
    }
    public boolean hasLeftChild(){
        return this.getLeftChild() != null;
    }
    public boolean hasRightChild(){
        return this.getRightChild() != null;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getDepth(){
        int leftChildDepth = hasLeftChild() ? this.getLeftChild().getDepth() :0;
        int rightChildDepth = hasRightChild() ? this.getRightChild().getDepth() :0;
        return Math.max(leftChildDepth, rightChildDepth) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.hasRightChild()) {
            String[] linesRight = this.getRightChild().toString().split("\n");
            for (String s : linesRight) {
                sb.append("    ").append(s).append("\n");
            }
        }
        sb.append(this.getValue().toString());
        sb.append("\n");
        if (this.hasLeftChild()){
            String[] linesLeft = this.getLeftChild().toString().split("\n");
            for (String s : linesLeft) {
                sb.append("    ").append(s).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
