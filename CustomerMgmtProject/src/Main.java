import java.util.Scanner;

import pkg.cogent.controller.CustomerController;

public class Main {

	public static void main(String[] args) {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		CustomerController cc=new CustomerController();
		System.out.println("Welcome to Customer Management Application");
		do {
			
			System.out.println("1-Add record");
			System.out.println("2-Read records");
			System.out.println("3-Update record");
			System.out.println("4-Delete record");
			System.out.println("5-Find customer by ID");
			System.out.println("6-Find youngest customer");
			System.out.println("7-Exit");
			System.out.println("Please enter your choice...");
			choice=sc.nextInt();
			cc.accept(choice);
			
		}while(choice!=7);
		sc.close();
	}

}
