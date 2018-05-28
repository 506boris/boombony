package by.vit.boombony.helpers;

public class Couple {
    private Integer one;
    private Integer two;

    public static Couple get() {
        return new Couple(0, 0);
    }

    public Couple(Integer one, Integer two) {
        this.one = one;
        this.two = two;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }
}
