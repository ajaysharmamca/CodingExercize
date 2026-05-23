public class CustomStack {
    int position;
    int[] stack = new int[10];
    int size = 10;
    public void push(int i) {
        if (position >= size) {
            System.out.println("Stack Full");
            return;
        }
        stack[position++] = i;

    }

    public int pop() {
        if (position <= 0) {
            System.out.println("Stack Empty");
            return -1;
        }
        int ret = stack[--position];
        stack[position] = 0;
        return ret;
    }

    public int peek() {
        if (position <= 0) {
            System.out.println("Stack Empty");
            return -1;
        }
        int ret = stack[position-1];
        return ret;
    }

    static void main(String[] args) {
        CustomStack ss = new CustomStack();
        ss.push(1);
        ss.push(2);
        ss.push(3);
        System.out.println(ss.peek());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }
}
