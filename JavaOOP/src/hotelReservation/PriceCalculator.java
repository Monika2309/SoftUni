package hotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private DiscountType discountType;
    private Season season;

    public PriceCalculator(double pricePerDay, int numberOfDays,Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }
    public double calculatePrice(){
        double pricePerDays = this.numberOfDays*(this.pricePerDay * season.getCoefficient());
        return pricePerDays-pricePerDays*(discountType.getPercent()/100.0);
    }
}
