package ru.ilya.list;

/**
 * Created by Lenovo2 on 26.04.2018.
 */
public class Cycle {
    public boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }
      Node slower, faster;
        slower = first;
        faster = first.next;
        while (true) {
            if (faster == null || faster.next == null) {
                return false;
            } else if (slower == faster || slower == faster.next) {
                return true;
            } else {
                slower = slower.next;
                faster = faster.next.next;
            }
        }
    }
}


    class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }