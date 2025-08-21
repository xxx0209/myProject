package com.itgroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// CREATE USER oraman IDENTIFIED BY oracle DEFAULT TABLESPACE users TEMPORARY TABLESPACE temp;
//GRANT connect, resource TO oraman;
//ALTER USER oraman ACCOUNT UNLOCK;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("메뉴 선택");
            System.out.println("0 : 닫기");
            int menu = scan.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                break;
            }
        }
    }
}