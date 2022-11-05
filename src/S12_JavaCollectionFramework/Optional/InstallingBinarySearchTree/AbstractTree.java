package S12_JavaCollectionFramework.Optional.InstallingBinarySearchTree;

public abstract class AbstractTree<E extends Comparable<E>> implements Tree {
    public abstract boolean insert(E e);

    @Override
    public void inorder() {
    }
}