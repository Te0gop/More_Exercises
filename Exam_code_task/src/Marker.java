public class Marker extends WritingMaterial {

    public Marker(Colors color, int thickness, int weight, String brand, boolean isPermanent, boolean isWritable) {
        super(color, thickness, weight, brand, isPermanent, isWritable);
    }

    @Override
    public void setWeight(int weight) {
        if(weight > 500) {
            super.setWeight(weight);
        } else {
            throw new IllegalArgumentException("Marker's weight cannot be more than 500 gr.");
        }
    }

}
