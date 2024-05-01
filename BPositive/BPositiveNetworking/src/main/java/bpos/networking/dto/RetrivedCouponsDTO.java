package bpos.networking.dto;

public class RetrivedCouponsDTO implements java.io.Serializable{
    private String id;
    private CouponDTO coupon;

    public RetrivedCouponsDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RetrivedCouponsDTO(String id, CouponDTO coupon, String receivedDate, String expirationDate) {
        this.id = id;
        this.coupon = coupon;
        this.receivedDate = receivedDate;
        this.expirationDate = expirationDate;
    }

    private String receivedDate;
    private String expirationDate;

    public CouponDTO getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponDTO coupon) {
        this.coupon = coupon;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public RetrivedCouponsDTO(CouponDTO coupon, String receivedDate, String expirationDate) {
        this.coupon = coupon;
        this.receivedDate = receivedDate;
        this.expirationDate = expirationDate;
    }
}
