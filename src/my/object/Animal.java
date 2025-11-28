package my.object;

abstract class Animal {
    public static void makeSound(String sound) {
        System.out.println(sound);
    }

    public abstract void makeSound();
}