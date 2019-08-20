package src.personal.workspace.funsystem.grocery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import src.personal.workspace.funsystem.item.Item;

public class Grocery {

    private static final Integer MINIMUM_COUNT = 2;

    private static final double PROMOTION_DISCOUNT_VALUE_ONE = 0.9;

    private static final double PROMOTION_DISCOUNT_VALUE_TWO = 0.5;

    private static final Integer MAXIMUM_COUNT = 7;

    private Map<Item, Integer> cart = new HashMap<>();

    public void addItem(Item item, Integer quantity) {
	if (cart.containsKey(item)) {
	    cart.put(item, cart.get(item) + quantity);
	} else {
	    cart.put(item, quantity);
	}
    }

    public BigDecimal calculateTotalPrice(LocalDate localDate) {
	AtomicInteger numberOfDiscountApplicableItems = new AtomicInteger();
	if (cart.containsKey(Item.SOUP)
		&& cart.get(Item.SOUP) >= MINIMUM_COUNT) {
	    int temp = cart.get(Item.SOUP) / MINIMUM_COUNT;
	    numberOfDiscountApplicableItems.set(temp);
	}
	return performTotalPriceCalculation(
		numberOfDiscountApplicableItems, localDate);
    }

    private BigDecimal performTotalPriceCalculation(
	    AtomicInteger numberOfDiscountApplicableItems,
	    LocalDate localDate) {
	List<BigDecimal> valueList = new ArrayList<>();
	cart.entrySet().forEach(entry -> {
	    if (isDiscountValid(entry.getKey(), localDate)) {
		if (entry.getKey().equals(Item.APPLE)) {
		    valueList.add(entry.getKey().getPrice()
			    .multiply(BigDecimal.valueOf(
				    PROMOTION_DISCOUNT_VALUE_ONE))
			    .multiply(BigDecimal
				    .valueOf(entry.getValue())));
		} else if (entry.getKey().equals(Item.BREAD)) {
		    valueList.add(entry.getKey().getPrice()
			    .multiply(BigDecimal.valueOf(
				    PROMOTION_DISCOUNT_VALUE_TWO))
			    .multiply(BigDecimal.valueOf(
				    numberOfDiscountApplicableItems
					    .get())));
		    valueList.add(entry.getKey().getPrice()
			    .multiply(BigDecimal.valueOf(entry
				    .getValue()
				    - numberOfDiscountApplicableItems
					    .get())));
		}
	    } else {
		valueList.add(entry.getKey().getPrice().multiply(
			BigDecimal.valueOf(entry.getValue())));
	    }
	});
	return valueList.stream().reduce(BigDecimal.ZERO,
		BigDecimal::add);
    }

    private boolean isDiscountValid(Item item, LocalDate localDate) {
	if (item.equals(Item.BREAD)) {
	    return localDate
		    .isAfter(LocalDate.now().minusDays(MINIMUM_COUNT))
		    && localDate
			    .isBefore(LocalDate.now()
				    .plusDays(MAXIMUM_COUNT));
	}
	if (item.equals(Item.APPLE)) {
	    return localDate
		    .isAfter(LocalDate.now().plusDays(MINIMUM_COUNT))
		    && localDate.isBefore(LocalDate.now()
			    .plusDays(LocalDate.now().lengthOfMonth()
				    - LocalDate.now()
					    .getDayOfMonth()));
	}
	return false;
    }
}
