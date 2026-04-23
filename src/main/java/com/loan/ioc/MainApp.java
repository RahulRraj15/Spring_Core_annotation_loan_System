package com.loan.ioc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loan.config.AppConfig;
import com.loan.sbeans.LoanService;

public final class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Bank: 1. HDFC  2. ICICI");
        int choice = sc.nextInt();

        LoanService service = null;
        System.out.println("enter bean id ");
        String next = sc.next();
        service = context.getBean(next,LoanService.class);

//        if (choice == 1) {
//            service = context.getBean("hdfc", LoanService.class);
//        } else {
//            service = context.getBean("icici", LoanService.class);
//        }

        while (true) {
            System.out.println("\n1.Apply  2.Reject  3.View  4.Exit");
            int op = sc.nextInt();

            try {
                switch (op) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        service.applyLoan(name, amt);
                        break;

                    case 2:
                        System.out.print("Loan ID: ");
                        int id = sc.nextInt();
                        service.rejectLoan(id);
                        break;

                    case 3:
                        service.viewAllLoans();
                        break;

                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}