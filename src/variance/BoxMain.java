package variance;

public class BoxMain {
    public static void main(String[] args) {
        Box<Number> numberBox = new Box<>(123);
        Box<Integer> intBox = new Box<>(100);
        Box<Double> doubleBox = new Box<>(3.0);

        intBox.setBox(intBox);

    }
}
