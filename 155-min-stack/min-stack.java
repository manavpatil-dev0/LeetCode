import java.util.*;

class MinStack {

    private static class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private final Deque<Node> stack = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int value) {
        int currentMin = stack.isEmpty()
                ? value
                : Math.min(value, stack.peek().min);

        stack.push(new Node(value, currentMin));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}