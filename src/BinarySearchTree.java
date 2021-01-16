public class BinarySearchTree <T extends Comparable<T>> extends BinaryTree<T>{
    public BinarySearchTree(T value) {
        super(value);
    }

    @Override
    public BinarySearchTree<T> getLeftChild() {
        return (BinarySearchTree<T>) super.getLeftChild();
    }


    public void setLeftChild(BinarySearchTree<T> leftChild) {
        super.setLeftChild(leftChild);
    }


    @Override
    public BinarySearchTree<T> getRightChild() {
        return (BinarySearchTree<T>) super.getRightChild();
    }

    public void setRightChild(BinarySearchTree<T> rightChild) {
        super.setRightChild(rightChild);
    }
    public void insert(T value){
        this.insert(new BinarySearchTree<>(value));
    }

    private void insert(BinarySearchTree<T> newTree){
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
}
