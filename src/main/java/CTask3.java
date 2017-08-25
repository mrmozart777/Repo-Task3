package main.java;

import java.io.IOException;
import java.util.Scanner;

public class CTask3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("### Enter the phrase in Russian: ");
        CTranslate t = new CTranslate("en", sc.nextLine());
        System.out.println("Translated phrase: " + t.getRes());
    }
}