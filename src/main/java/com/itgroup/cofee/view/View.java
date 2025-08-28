package com.itgroup.cofee.view;

import java.util.Scanner;

public class View {

    public final Scanner scan = new Scanner(System.in);

    public int printChoiceNumber(int min, int max) {

        String choice = "0";

        while(true) {
            System.out.print("입력 ✎ : ");
            choice = scan.next().trim();
            boolean isNumeric = choice.matches("\\d+");

            if (isNumeric) {
                if (Integer.parseInt(choice) < min || Integer.parseInt(choice) > max) {
                    System.out.println("잘못된 번호입니다.");
                } else {
                    break;
                }
            } else {
                System.out.println("숫자가 아닙니다.");
            }
        }
        return Integer.parseInt(choice);
    }

}
