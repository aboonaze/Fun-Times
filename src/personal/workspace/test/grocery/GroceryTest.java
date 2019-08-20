package src.personal.workspace.test.grocery;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.junit.Test;

import src.personal.workspace.funsystem.grocery.Grocery;
import src.personal.workspace.funsystem.item.Item;

public class GroceryTest {

    private static final double EXPECTED_VALUE_TEST_ONE = 284.0;
    private static final double EXPECTED_VALUE_TEST_TWO = 264.0;
    private static final double EXPECTED_VALUE_TEST_THREE = 285.0;

    @Test
    public void testGroceryFunctionWithinDiscountPeriodOne() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.SOUP, 100);
	grocery.addItem(Item.BREAD, 100);
	grocery.addItem(Item.MILK, 100);
	grocery.addItem(Item.APPLE, 100);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now());
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_ONE));
    }

    @Test
    public void testGroceryFunctionWithinDiscountPeriodTwo() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.SOUP, 100);
	grocery.addItem(Item.BREAD, 100);
	grocery.addItem(Item.MILK, 100);
	grocery.addItem(Item.APPLE, 100);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now().plusDays(4));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_TWO));
    }

    @Test
    public void testGroceryFunctionWithoutDiscount() {
	Grocery grocery = new Grocery();
	grocery.addItem(Item.SOUP, 100);
	grocery.addItem(Item.BREAD, 100);
	grocery.addItem(Item.MILK, 100);
	grocery.addItem(Item.APPLE, 100);
	BigDecimal totalAmount = grocery
		.calculateTotalPrice(LocalDate.now().plusMonths(1));
	assertTrue(Objects.equals(totalAmount.doubleValue(),
		EXPECTED_VALUE_TEST_THREE));
    }
}