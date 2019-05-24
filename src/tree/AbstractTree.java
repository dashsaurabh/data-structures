package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    public Iterable<Position<E>> positionsPreorder(){
        return preorder();
    }

    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c: children(p))
            preorderSubtree(c, snapshot);

    }

    public Iterable<Position<E>> positionsPostorder(){
        return postorder();
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    public void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c: children(p))
            postorderSubtree(c, snapshot);

        snapshot.add(p);
    }

    public Iterable<Position<E>> breadthFirst(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()) {
            Queue<Position<E>> queue = new ConcurrentLinkedQueue<>();
            queue.offer(root());
            while (!queue.isEmpty()) {
                Position<E> p = queue.remove();
                snapshot.add(p);
                for (Position<E> c : children(p))
                    queue.offer(c);
            }
        }

        return snapshot;
    }

}
