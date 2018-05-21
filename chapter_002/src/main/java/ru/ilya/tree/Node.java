package ru.ilya.tree;

/**
 * Created by Lenovo2 on 14.05.2018.
 */
import java.util.ArrayList;
import java.util.List;

public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();

    public E getValue() {
        return value;
    }

    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public void addAllToList(List<Node<E>> nodes) {
        nodes.add(this);
        for (Node<E> e : this.leaves()) {
            e.addAllToList(nodes);
        }
    }

    public boolean isBinary() {
        boolean result = true;
        if (leaves().size() >= 2) {
            result = false;
        } else {
            for (Node node : leaves()) {
                node.isBinary();
            }
        }
        return result;
    }

}
