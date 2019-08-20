package src.personal.workspace.funsystem.item;

import java.math.BigDecimal;

public enum Item {
    SOUP(BigDecimal.valueOf(0.65)),
    BREAD(BigDecimal.valueOf(0.80)),
    MILK(BigDecimal.valueOf(1.30)),
    APPLE(BigDecimal.valueOf(0.10));

    private final BigDecimal price;

    Item(BigDecimal price) {
	this.price = price;
    }

    public BigDecimal getPrice() {
	return price;
    }

}
