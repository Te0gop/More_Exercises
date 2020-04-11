package task_03;

public abstract class Food {
    Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
