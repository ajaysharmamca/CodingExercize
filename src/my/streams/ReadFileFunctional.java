package my.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileFunctional {
    static class Cat {
        String name;
        String colour;

        Cat(String name, String colour) {
            this.name = name;
            this.colour = colour;
        }

        @Override
        public String toString() {
            return "Cat{name=" + name + ", colour=" + colour + "}";
        }
    }
    public static void main(String[] args) throws IOException {

        String filename = "/home/ajay/IdeaProjects/CodingExercize/src/my/streams/cats.txt";

        List<Cat> cats = Files.lines(Paths.get(filename))
                .map(line -> line.split("/"))
                .filter(arr -> arr.length >= 2)
                .map(arr -> new Cat(arr[0].trim(), arr[1].trim()))
                .toList();

        cats.forEach(System.out::println);
    }
}
