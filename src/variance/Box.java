package variance;

public  class   Box<T> {
    private T value;
    private Box<? extends T> box;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setBox(Box<? extends T> otherBox) {

        // 다운캐스팅이 자동으로 안되는 것과 유사.
        // 현재 T와 otherBox의 T가 서로 다른 타입 일 수도(Integer, Double) 있기 때문
        // otherBox의 T가 현재 T의 서브타입이기 때문
        otherBox.setValue(value);

        // 업캐스팅이 자동으로 되는것과 유사. 현재 T는 otherBox의 T의 상위 타입이기 때문.
        value = otherBox.getValue();
    }

    public void  getBox(Box<? super T> otherBox) {
        otherBox.setValue(value);
        value = otherBox.getValue();
    }

}

