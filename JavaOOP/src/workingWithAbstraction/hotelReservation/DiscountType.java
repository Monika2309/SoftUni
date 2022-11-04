package workingWithAbstraction.hotelReservation;

public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int percent;


    DiscountType(int percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
