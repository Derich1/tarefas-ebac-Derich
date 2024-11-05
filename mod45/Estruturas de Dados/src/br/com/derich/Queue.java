package br.com.derich;

// enqueue(): Adiciona um elemento ao final da fila. Tempo - O(1), Espaço - O(1)
// dequeue(): Remove e retorna o elemento do início da fila. Tempo - O(1), Espaço - O(1)
// rear(): Retorna o elemento no final da fila. Tempo - O(1), Espaço - O(1)
// front(): Retorna o elemento no início da fila. Tempo - O(1), Espaço - O(1)

public class Queue<T> {
    private Node<T> front, rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    public T dequeue() {
        if (front == null) throw new IllegalStateException("Queue is empty");
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T front() {
        if (front == null) throw new IllegalStateException("Queue is empty");
        return front.data;
    }

    public T rear() {
        if (rear == null) throw new IllegalStateException("Queue is empty");
        return rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
