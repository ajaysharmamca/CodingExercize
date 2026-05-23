package my.imp;

record Employee(int id, String name, String deparment) {
    public static Employee of(int id, String name, String deparment) {
        return new Employee(id, name, deparment);
    }
}