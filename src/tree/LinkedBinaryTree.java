package tree;

import java.util.Iterator;

/**
 * Concrete implementation of a Binary Tree using a Node based linked structure
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //Nested node class
    protected static class Node<E> implements Position<E>{

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }


        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    /**
     * Factory method to create a new node for storing element e
     * @param e
     * @param parent
     * @param left
     * @param right
     * @return
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree(){

    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");

        Node<E> node = (Node<E>) p;

        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in tree");

        return node;
    }

    public int size(){
        return size;
    }

    public Node<E> root(){
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException{
        if(!isEmpty())
            throw new IllegalStateException("Tree is not empty");

        root = createNode(e, null, null, null);
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);

        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child. Use set if you want to update");

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E>p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);

        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child. Use set if you want to update");

        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
        Node<E> node = validate(p);

        if(isInternal(p)) throw new IllegalArgumentException("p must be a leaf");

        size += t1.size() + t2.size();

        if(!t1.isEmpty()){
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root=null;
            t1.size=0;
        }

        if(!t2.isEmpty()){
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size=0;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
