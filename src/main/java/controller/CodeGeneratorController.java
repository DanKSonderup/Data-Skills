package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class CodeGeneratorController {

    public static String generateCodeFile(String baseSource) {
        StringBuilder sb = new StringBuilder();
        String[] lines = baseSource.split("\n");

        int i = 0;

        while (i < lines.length-1) {
            sb.append(lines[i]);
            i++;
        }
        File testCode = new File("src/main/java/exercises/rekursion1/opg1testcode.txt");

        try {
            Scanner input = new Scanner(testCode);
            while (input.hasNextLine()) {
                sb.append(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
