package sparshcoolapps.lambdaexamples.common;


//row,abv,ibu,id,name,style,brewery_id,ounces

public class Beer {
    private Integer row;
    private Double abv;
    private Double ibu;
    private Integer id;
    private String name;
    private String style;
    private Integer breweryID;
    private Double ounces;

    public static Beer newInstance(String... rec){
        Integer row;
        Double abv;
        Double ibu;
        Integer id;
        String name;
        String style;
        Integer breweryID;
        Double ounces;

        if (rec[0] != null && rec[0].length() > 0  && rec[0] != "")
            row = Integer.parseInt(rec[0]);
        else
            row = -1;

        if (rec[1] != null && rec[1].length() > 0 && rec[1] != "")
            abv = Double.parseDouble(rec[1]);
        else abv = 0.0;

        if (rec[2] != null && rec[2].length() > 0 && rec[2] != "")
            ibu = Double.parseDouble(rec[2]);
        else ibu = 0.0;

        if (rec[3] != null && rec[3].length() > 0 && rec[3] != "")
            id = Integer.parseInt(rec[3]);
        else id = -1;

        name = rec[4].trim();
        style = rec[5].trim();


        if (rec[6].length() > 0 && rec[6] != null && rec[6] != "") {
            if (Character.isDigit(rec[6].charAt(0)))
                breweryID = Integer.parseInt(rec[6]);
            else breweryID = -1;
        }
        else
            breweryID = -1;

        if (rec[7].length() > 0 && rec[7] != null && rec[7] != "")
            ounces = Double.parseDouble(rec[7]);
        else
            ounces = 0.0;

        return new Beer(row, abv, ibu, id, name, style, breweryID, ounces);
    }

    public Beer(String... rec) {


    }

    public Beer(Integer row, Double abv, Double ibu, Integer id, String name, String style, Integer breweryID, Double ounces) {
        this.row = row;
        this.abv = abv;
        this.ibu = ibu;
        this.id = id;
        this.name = name;
        this.style = style;
        this.breweryID = breweryID;
        this.ounces = ounces;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "row=" + row +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", breweryID='" + breweryID + '\'' +
                ", ounces=" + ounces +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        if (abv != null ? !abv.equals(beer.abv) : beer.abv != null) return false;
        if (ibu != null ? !ibu.equals(beer.ibu) : beer.ibu != null) return false;
        if (name != null ? !name.equals(beer.name) : beer.name != null) return false;
        if (style != null ? !style.equals(beer.style) : beer.style != null) return false;
        if (breweryID != null ? !breweryID.equals(beer.breweryID) : beer.breweryID != null) return false;
        return ounces != null ? ounces.equals(beer.ounces) : beer.ounces == null;
    }

    @Override
    public int hashCode() {
        int result = abv != null ? abv.hashCode() : 0;
        result = 31 * result + (ibu != null ? ibu.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (breweryID != null ? breweryID.hashCode() : 0);
        result = 31 * result + (ounces != null ? ounces.hashCode() : 0);
        return result;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getBreweryID() {
        return breweryID;
    }

    public void setBreweryID(Integer breweryID) {
        this.breweryID = breweryID;
    }

    public Double getOunces() {
        return ounces;
    }

    public void setOunces(Double ounces) {
        this.ounces = ounces;
    }
}

/*
abv
The alcoholic content by volume with 0 being no alcohol and 1 being pure alcohol

Numeric
ibu
International bittering units, which describe how bitter a drink is.

String
id
Help us describe this column...
Numeric
name
Name of the beer.

String
style
Beer style (lager, ale, IPA, etc.)

String
brewery_id
Unique identifier for brewery that produces this beer; can use to join with brewery info.

Numeric
ounces
Size of beer in ounces.

Numeric
 */
