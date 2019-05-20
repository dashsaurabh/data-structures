package tree;

public interface BinaryTree<E> extends Tree<E> {

    /**
     * Returns the Position of p's left child (or null if no child exists)
     *
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's right child (or null if no child exists)
     *
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's sibling (or null if no sibling exists)
     *
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of positions using In-Order Traversal
     * @return
     */
    Iterable<Position<E>> positionsInorder();
}
