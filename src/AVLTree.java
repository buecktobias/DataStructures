public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    public AVLTree(T value) {
        super(value);
    }
    public void insert(T value){
        this.insert(new AVLTree<>(value));
    }

    public int getBalanceFactor(){
        int leftChildDepth = hasLeftChild() ?getLeftChild().getDepth() : 0;
        int rightChildDepth = hasRightChild() ? getRightChild().getDepth() : 0;
        return rightChildDepth -leftChildDepth;
    }

    public void reBalance(){
        if(this.getBalanceFactor() == 2){
            this.leftRotate();
        }
    }

    public void leftRotate(){
        AVLTree<T> X = this;
        AVLTree<T> Z = (AVLTree<T>) X.getRightChild();
        AVLTree<T> t23 = (AVLTree<T>) Z.getLeftChild();
        X.setRightChild(t23);
        Z.setLeftChild(X);

    }
    public void insert(BinarySearchTree<T> newTree){
        T value = newTree.getValue();
        if(value.compareTo(this.getValue()) > 0){
            if (this.hasLeftChild()) {
                this.getLeftChild().insert(newTree);
            }else{
                this.setLeftChild(newTree);
            }
        }else{
            if(this.hasRightChild()) {
                this.getRightChild().insert(newTree);
            }else{
                this.setRightChild(newTree);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.hasRightChild()) {
            String[] linesRight = this.getRightChild().toString().split("\n");
            for (String s : linesRight) {
                sb.append("     ").append(s).append("\n");
            }
        }
        sb.append(this.getValue().toString()).append("(").append(this.getBalanceFactor()).append(")");
        sb.append("\n");
        if (this.hasLeftChild()){
            String[] linesLeft = this.getLeftChild().toString().split("\n");
            for (String s : linesLeft) {
                sb.append("     ").append(s).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
