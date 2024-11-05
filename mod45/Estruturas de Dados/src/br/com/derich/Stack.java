package br.com.derich;

import java.util.EmptyStackException;

// push(): Adiciona um elemento ao topo da pilha. Tempo - O(1), Espaço - O(1)
// pop(): Remove e retorna o elemento do topo da pilha. Tempo - O(1), Espaço - O(1)

public class Stack<T> {
    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
