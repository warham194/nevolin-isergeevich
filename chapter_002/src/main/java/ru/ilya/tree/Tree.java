package ru.ilya.tree;

import java.util.*;


/**
 * Created by Lenovo2 on 14.05.2018.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (root == null) {
            return false;
        }
        Optional<Node<E>> parentOptional = findBy(parent);
        boolean result = parentOptional.isPresent() && !findBy(child).isPresent() && duplicate(parent, child);
        if (result) {
            parentOptional.get().add(new Node<>(child));
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    private boolean duplicate(E parent, E child) {
        boolean result = true;
        for (Node<E> e : this.findBy(parent).get().leaves()) {
            if (e.eqValue(child)) {
                result = false;
            }
        }
        return result;
    }

        @Override
    public Iterator<E> iterator() {
        List<Node<E>> nodes = new ArrayList<>();
        root.addAllToList(nodes);
        List<E> values = new ArrayList<>(nodes.size());
        for (Node<E> node : nodes) {
            values.add(node.getValue());
        }
        return values.iterator();
    }
}
