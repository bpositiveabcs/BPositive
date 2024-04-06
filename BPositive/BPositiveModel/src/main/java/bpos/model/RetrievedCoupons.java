package bpos.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class RetrievedCoupons extends Entity<Integer> {

    private Coupon coupon;
    private LocalDateTime receivedDate;
    private LocalDateTime expirationDate;

    public RetrievedCoupons(Coupon coupon, LocalDateTime receivedDate, LocalDateTime expirationDate) {
        this.coupon = coupon;
        this.receivedDate = receivedDate;
        this.expirationDate = expirationDate;
    }
    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RetrievedCoupons)) return false;
        if (!super.equals(o)) return false;
        RetrievedCoupons that = (RetrievedCoupons) o;
        return Objects.equals(getCoupon(), that.getCoupon()) &&
                Objects.equals(getReceivedDate(), that.getReceivedDate()) &&
                Objects.equals(getExpirationDate(), that.getExpirationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCoupon(), getReceivedDate(), getExpirationDate());
    }

}

