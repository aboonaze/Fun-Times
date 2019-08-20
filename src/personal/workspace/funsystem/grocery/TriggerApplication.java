package src.personal.workspace.funsystem.grocery;

import java.time.LocalDate;
import java.util.Scanner;

import src.personal.workspace.funsystem.item.Item;

public class TriggerApplication {

    public static void main(String[] args) {
	Grocery grocery = new Grocery();
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the tins of soup: ");
	grocery.addItem(Item.SOUP, scan.nextInt());
	System.out.println("Enter the number of bread loafs: ");
	grocery.addItem(Item.BREAD, scan.nextInt());
	System.out.println("Enter the packets of milk: ");
	grocery.addItem(Item.MILK, scan.nextInt());
	System.out.println("Enter the number of apples: ");
	grocery.addItem(Item.APPLE, scan.nextInt());
	System.out.printf("Total Rupees : Rs %f",
		grocery.calculateTotalPrice(LocalDate.now()));
    }
}
