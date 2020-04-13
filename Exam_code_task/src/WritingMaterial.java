public abstract class WritingMaterial {

    private Colors color;
    private int thickness;
    private int weight;
    private String brand;
    private boolean isPermanent;
    private boolean isWritable;

    public WritingMaterial(Colors color, int thickness, int weight, String brand, boolean isPermanent, boolean isWritable) {
        setColor(color);
        this.thickness = thickness;
        this.weight = weight;
        this.brand = brand;
        this.isPermanent = isPermanent;
        this.isWritable = isWritable;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public boolean isWritable() {
        return isWritable;
    }

    public void setWritable(boolean writable) {
        isWritable = writable;
    }


    @Override
    public String toString() {
        return
                "color: " + getColor() + ", thickness: " + getThickness() + ", "
                + "weight: " + getWeight() + ", brand: " + getBrand() + ", "
                + "isPermanent: " + isPermanent() + ", isWritable: " + isWritable();
    }

}
