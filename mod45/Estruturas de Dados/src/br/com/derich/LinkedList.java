package br.com.derich;

// push(): Adiciona um elemento no início. Tempo - O(1), Espaço - O(1)
// pop(): Remove o elemento do início. Tempo - O(1), Espaço - O(1)
// insert():  Insere um elemento em uma posição específica. Tempo - O(n), Espaço - O(1)
// remove(): Remove um elemento de uma posição específica. Tempo - O(n), Espaço - O(1)
// elementAt(): Retorna o elemento na posição especificada. Tempo - O(n), Espaço - O(1)

public class LinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public T pop() {
        if (head == null) throw new IllegalStateException("List is empty");
        T data = head.data;
        head = head.next;
        return data;
    }

    public void insert(int index, T data) {
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0) {
            push(data);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException("Index out of bounds");
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public T remove(int index) {
        if (index < 0 || head == null) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0) return pop();
        Node<T> current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) throw new IndexOutOfBoundsException("Index out of bounds");
        T data = current.next.data;
        current.next = current.next.next;
        return data;
    }

    public T elementAt(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        Node<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException("Index out of bounds");
        return current.data;
    }
}
