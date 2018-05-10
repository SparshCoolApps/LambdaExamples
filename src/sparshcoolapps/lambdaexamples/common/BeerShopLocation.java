package sparshcoolapps.lambdaexamples.common;

//row,name,city,state
public class BeerShopLocation {

    private Integer row;
    private String name;
    private String city;
    private String state;

    public BeerShopLocation(Integer row, String name, String city, String state) {
        this.row = row;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "BeerShopLocation{" +
                "row=" + row +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeerShopLocation that = (BeerShopLocation) o;

        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;
    }

    @Override
    public int hashCode() {
        int result = row != null ? row.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
