package kitchenpos.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Menu {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long menuGroupId;
    private List<MenuProduct> menuProducts;

    public Menu() {
    }

    public Menu(Long id, String name, BigDecimal price, Long menuGroupId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.menuGroupId = menuGroupId;
    }

    public void validationCheck(boolean exitMenuGroupId) {
        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        if (!exitMenuGroupId) {
            throw new IllegalArgumentException();
        }
    }

    public void compare(BigDecimal sum) {
        if (price.compareTo(sum) > 0) {
            throw new IllegalArgumentException();
        }
    }

    public void changeMenuProducts(List<MenuProduct> savedMenuProducts) {
        menuProducts = savedMenuProducts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getMenuGroupId() {
        return menuGroupId;
    }

    public List<MenuProduct> getMenuProducts() {
        return menuProducts;
    }
}
