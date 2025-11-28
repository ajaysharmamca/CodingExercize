package my.object;

class Parent {
    public static void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    public static void print() {
        System.out.println("Child");
    }
}

class Main {
    public static void printMain(Parent o) {
        o.print();
    }

    public static void main(String[] args) {
        Parent x = new Parent();
        Parent y = new Child();
        Child z = new Child();
        printMain(x);
        printMain(y);
        printMain(z);
    }
}