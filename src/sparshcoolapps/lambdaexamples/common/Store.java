package sparshcoolapps.lambdaexamples.common;

//Store,DayOfWeek,Sales,Customers,Open,Promo,SchoolHoliday
public class Store {

    private Integer store;
    private Integer dayOfWeek;
    private Integer sales;
    private Integer customers;
    private Integer open;
    private Integer promo;
    private Integer holiday;

    public Store(Integer store, Integer dayOfWeek, Integer sales, Integer customers, Integer open, Integer promo, Integer holiday) {
        this.store = store;
        this.dayOfWeek = dayOfWeek;
        this.sales = sales;
        this.customers = customers;
        this.open = open;
        this.promo = promo;
        this.holiday = holiday;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store=" + store +
                ", dayOfWeek=" + dayOfWeek +
                ", sales=" + sales +
                ", customers=" + customers +
                ", open=" + open +
                ", promo=" + promo +
                ", holiday=" + holiday +
                '}';
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getCustomers() {
        return customers;
    }

    public void setCustomers(Integer customers) {
        this.customers = customers;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getPromo() {
        return promo;
    }

    public void setPromo(Integer promo) {
        this.promo = promo;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }
}
