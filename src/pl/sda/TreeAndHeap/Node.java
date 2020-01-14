package pl.sda.TreeAndHeap;

public class Node<E>{
        private Node<E> left;
        private Node<E> right;
        private E value;
        private Node<E> parent;

        public Node(Node<E> left, Node<E> right, Node<E> parent, E value) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.parent=parent;
    }
        public E getValue() {
            return this.value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public void setValue(E value) {
            this.value = value;
        }
        public Node<E> getParent() {
            return parent;
        }

    @Override
    public String toString() {
        return value.toString();
    }
    }


