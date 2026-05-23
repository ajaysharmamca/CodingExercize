package my.test;

import java.util.List;

public class TotalWordCount {
//   Given a list of sentences, return the total word count across all sentences.

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams make coding cleaner",
                "Practice improves skill",
                "Mahamaya Homestay welcomes guests"
        );
        int sum = sentences.stream().mapToInt(
                sen -> sen.split("\\W+").length
         ).sum();
        System.out.println(sum);

    }
}
