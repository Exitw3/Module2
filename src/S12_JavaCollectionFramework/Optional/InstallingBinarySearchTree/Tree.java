package S12_JavaCollectionFramework.Optional.InstallingBinarySearchTree;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
}