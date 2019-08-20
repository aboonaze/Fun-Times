package src.personal.workspace.test.grocery;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.junit.Test;

import src.personal.workspace.funsystem.grocery.Grocery;
import src.personal.workspace.funsystem.item.Item;

public class GroceryTest {

    private static final double EXPECTED_VALUE_TEST_ONE = 3.15;
    private static final double EXPECTED_VALUE_TEST_TWO = 1.90;
    private static final double EXPECTED_VALUE_TEST_THREE = 1.84;
    private static final double EXPECTED_VALUE_TEST_FOUR = 1.97;

    @Test
    public void problemTestcaseOne() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.SOUP, 3);
	grocery.addItem(Item.BREAD, 2);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_ONE));
    }

    @Test
    public void problemTestcaseTwo() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.APPLE, 6);
	grocery.addItem(Item.MILK, 1);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_TWO));
    }

    @Test
    public void problemTestcaseThree() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.APPLE, 6);
	grocery.addItem(Item.MILK, 1);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_THREE));
    }

    @Test
    public void problemTestcaseFour() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.APPLE, 3);
	grocery.addItem(Item.SOUP, 2);
	grocery.addItem(Item.BREAD, 1);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now().plusDays(5));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_FOUR));
    }
}