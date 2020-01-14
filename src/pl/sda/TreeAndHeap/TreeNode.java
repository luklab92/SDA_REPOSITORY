package pl.sda.TreeAndHeap;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class TreeNode<E> implements Comparable<Node<E>> {

    private Node<E> root;
    private final Comparator<E> comparator;

    private List<E> tempList = new LinkedList<>();
    private List<Integer> nodeList = new LinkedList<>();
    private List<E> inOrderList = new LinkedList<>();
    private List<E> leafList = new LinkedList<>();
    private List<E> justOneChildList = new LinkedList<>();
    private List<Integer> treeLength = new LinkedList<>();

    //Konstruktor
    public TreeNode(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    //Korzeń
    public E returnRoot() {
        return root.getValue();
    }

    //Dzieci korzenia
    public List<Node<E>> returnChildrenOfRoot() {
        return returnChildrenOfRoot(root);
    }
    private List<Node<E>> returnChildrenOfRoot(Node<E> node) {
        if (node == null) return null;
        List<Node<E>> list = new LinkedList<>();
        list.add(root.getLeft());
        list.add(root.getRight());
        return list;
    }

    //Dzieci dowolnego Node'a
    public List<E> printChildren(E elem) {
        Node<E> node = findInner(elem, root);
        List<E> temp = new LinkedList<>();
        if (node==null) return null;
        if (node.getLeft() != null) temp.add(node.getLeft().getValue());
        if (node.getRight() != null) temp.add(node.getRight().getValue());
        return temp;
    }

    //Wartość maksymalna drzewa
    public E findMax() {
        if (root == null) return null;
        Node<E> actual = root;
        if (actual.getRight() == null) return root.getValue();
        else {
            while (actual.getRight() != null) {
                actual = actual.getRight();
            }
        }
        return actual.getValue();
    }

    //Wartość minimalna drzewa
    public E findMin() {
        if (root == null) return null;
        Node<E> actual = root;
        if (actual.getLeft() == null) return root.getValue();
        else {
            while (actual.getLeft() != null) {
                actual = actual.getLeft();
            }
        }
        return actual.getValue();
    }

    public E findMin(Node<E> actual) {
        if (root == null) return null;
        if (actual.getLeft() == null) return actual.getValue();
        else {
            while (actual.getLeft() != null) {
                actual = actual.getLeft();
            }
        }
        return actual.getValue();
    }

    //Dodanie elementu do drzewa
    public void add(E elem) {
        if (root == null) {
            this.root = new Node<>(null, null, null, elem);
        } else addInner(root, elem);
    }
    private void addInner(Node<E> actual, E value) {
        int resultComparator = comparator.compare(value, actual.getValue());
        boolean greater = resultComparator >= 0;
        if (greater) {
            if (actual.getRight() != null) {
                addInner(actual.getRight(), value);
            } else {
                Node<E> newNodeToAdd = new Node<>(null, null, actual, value);
                actual.setRight(newNodeToAdd);
            }
        } else {
            if (actual.getLeft() != null) {
                addInner(actual.getLeft(), value);
            } else {
                Node<E> newNodeToAdd = new Node<>(null, null, actual, value);
                actual.setLeft(newNodeToAdd);
            }
        }
    }

    //find Element in Tree - iteration
    public boolean findElement(E value) {
        if (root == null) return false;
        Node<E> actual = root;
        if (actual.getValue() == value) return true;
        while (actual != null) {
            int resultComparator = comparator.compare(value, actual.getValue());
            boolean greater = resultComparator > 0;
            if (resultComparator == 0) return true;
            if (greater) {
                actual = actual.getRight();
            } else {
                actual = actual.getLeft();
            }
        }
        return false;
    }

    //find element - recursion
    private Node<E> findElemRecursion(E value) {
        return findInner(value, root);
    }
    private Node<E> findInner(E value, Node<E> actualNode) {
        if (actualNode == null) return null;
        int resultComparator = comparator.compare(value, actualNode.getValue());
        if (resultComparator == 0) return actualNode;
        else if (resultComparator > 0) return findInner(value, actualNode.getRight());
        else return findInner(value, actualNode.getLeft());
    }

    //PREORDER
    public List<Integer> preOrderFind() {
        return preOrderInner(root);
    }
    private List<Integer> preOrderInner(Node<E> actual) {
        if (actual != null) {
            boolean justOneChild = (actual.getLeft() == null && actual.getRight() != null) || (actual.getLeft() != null && actual.getRight() == null);
            nodeList.add((int)actual.getValue());
            preOrderInner(actual.getRight());
            preOrderInner(actual.getLeft());
            if (actual.getLeft() == null && actual.getRight() == null) leafList.add(actual.getValue());
            if (justOneChild) justOneChildList.add(actual.getValue());
        }
        return nodeList;
    }

    //POSTORDER
    public List<E> postOrder() {
        tempList.clear();
        return postOrderInner(root);
    }
    private List<E> postOrderInner(Node<E> node) {
        if (node != null) {
            postOrderInner(node.getLeft());
            postOrderInner(node.getRight());
            tempList.add(node.getValue());
        }
        return tempList;
    }

    //INORDER
    public List<E> inOrder() {
        inOrderList.clear();
        return inOrderInner(root);
    }
    private List<E> inOrderInner(Node<E> node) {
        if (node != null) {
            inOrderInner(node.getLeft());
            inOrderList.add(node.getValue());
            inOrderInner(node.getRight());
        }
        return inOrderList;
    }

    //POSTORDERTEMPLATE
    public String print() {
        return postOrderInnerTemplate(root, (node, acc) -> acc.append(node.getValue()).append(" "), new StringBuilder()).toString();
    }
    private <A> A postOrderInnerTemplate(Node<E> node, BiFunction<Node<E>, A, A> function, A acc) {
        if (node != null) {
            postOrderInnerTemplate(node.getLeft(), function, acc);
            postOrderInnerTemplate(node.getRight(), function, acc);
            function.apply(node, acc);
        }
        return acc;
    }

    //get leaves template
    public List<E> getLeavesFromTemplate() {
        return postOrderInnerTemplate(root, (node, list) -> {
            if (node.getLeft() == null && node.getRight() == null) list.add(node.getValue());
            return list;
        }, new LinkedList<>());
    }

    //Atomic Integer
    public AtomicInteger getSizeAtomic() {
        AtomicInteger acc = new AtomicInteger();
        return getSizeAtomic(root, acc);
    }
    private AtomicInteger getSizeAtomic(Node<E> node, AtomicInteger counter) {
        if (node != null) {
            getSizeAtomic(node.getLeft(), counter);
            getSizeAtomic(node.getRight(), counter);
            counter.set(counter.get() + 1);
        }
        return counter;
    }

    //count elements in tree
    public int countElements() {
        nodeList.clear();
        preOrderInner(root);
        return nodeList.size();
    }

    //count leaves in tree
    public int countLeaves() {
        leafList.clear();
        preOrderInner(root);
        return leafList.size();
    }

    //count sum of Nodes
    public Optional<Integer> sumOfNodes() {
        nodeList.clear();
        preOrderInner(root);
        return nodeList.stream().reduce(Integer::sum);
    }

    //count nodes with just one child
    public int countNodesWithJustOneChild() {
        justOneChildList.clear();
        preOrderInner(root);
        return justOneChildList.size();
    }

    //count length of tree
    public Optional<Integer> treeLength() {
        treeLength.clear();
        return Optional.of(Objects.requireNonNull(findTreeLengthInner(root, 0)).stream().max(Integer::compareTo).get());
    }
    private List<Integer> findTreeLengthInner(Node<E> actual, int counter) {
        if (root == null) return null;
        if (actual != null) {
            if (actual.getRight() != null || actual.getLeft() != null) {
                counter++;
                findTreeLengthInner(actual.getRight(), counter);
                findTreeLengthInner(actual.getLeft(), counter);
            }
            treeLength.add(counter);
        }
        return treeLength;
    }

    //find previous value
    public Node<E> previous(E elem) {
        Node<E> node = findElemRecursion(elem);
        return previous(node);
    }
    private Node<E> previous(Node<E> actual) {
        if (actual == null) return null;
        if (actual.getValue() == findMin()) return null;
        if (actual.getLeft() != null) {
            actual = actual.getLeft();
            while (actual.getRight() != null) {
                actual = actual.getRight();
            }
            return actual;
        } else if (actual == root) return null;
        else {
            Node<E> parent = actual.getParent();
            boolean hasParentGreaterValue = comparator.compare(parent.getValue(), actual.getValue()) > 0;
            while (hasParentGreaterValue && root != parent) {
                parent = parent.getParent();
                hasParentGreaterValue = comparator.compare(parent.getValue(), actual.getValue()) > 0;
            }
            return parent;
        }
    }

    //find next value
    public Node<E> next(E elem) {
        Node<E> node = findElemRecursion(elem);
        return next(node);
    }
    private Node<E> next(Node<E> actual) {
        if (actual == null) return null;
        if (actual.getValue() == findMax()) return null;
        if (actual.getRight() != null) {
            actual = actual.getRight();
            while (actual.getLeft() != null) {
                actual = actual.getLeft();
            }
            return actual;
        } else if (actual == root) return null;
        else {
            Node<E> parent = actual.getParent();
            boolean hasParentLoverThanValue = comparator.compare(parent.getValue(), actual.getValue()) < 0;
            while (hasParentLoverThanValue && root == parent) {
                parent = parent.getParent();
                hasParentLoverThanValue = comparator.compare(parent.getValue(), actual.getValue()) < 0;
            }
            return parent;
        }
    }

    //remove
    public void removeNode(E value) {
        removeNodeInner(this.root,value);
    }
    private Node<E> removeNodeInner(Node<E> actual, E value) {
        if (actual == null) return null;
        if (comparator.compare(value, actual.getValue()) < 0) {
            actual.setLeft(removeNodeInner(actual.getLeft(), value));
        } else if (comparator.compare(value, actual.getValue()) > 0) {
            actual.setRight(removeNodeInner(actual.getRight(), value));
        } else {
            if (actual.getLeft() == null && actual.getRight() == null) {
                System.out.println("Deleting: " + value);
                return null;
            } else if (actual.getLeft() == null) {
                System.out.println("Deleting: " + value);
                return actual.getRight();
            } else if (actual.getRight() == null){
                System.out.println("Deleting: " + value);
                return actual.getLeft();
            } else {
                E minValue = findMin(actual.getRight());
                findElemRecursion(minValue).setLeft(actual.getLeft());
                actual = actual.getRight();
                System.out.println("Deleting: "+value);
            }
        }
        return actual;
    }
    //compareTo
    @Override
    public int compareTo(@NotNull Node<E> eNode) {
        return 0;
    }
}