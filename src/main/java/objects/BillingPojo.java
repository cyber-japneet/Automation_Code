package objects;

public class BillingPojo
{
    private String street_name;
    private String city_name;
    private String state_name;
    private String country_name;
    private String postal_code;

    public String getStreet_name() {
        return street_name;
    }

    public BillingPojo setStreet_name(String street_name) {
        this.street_name = street_name;
        return this;
    }

    public String getCity_name() {
        return city_name;
    }

    public BillingPojo setCity_name(String city_name) {
        this.city_name = city_name;
        return this;
    }

    public String getState_name() {
        return state_name;
    }

    public BillingPojo setState_name(String state_name) {
        this.state_name = state_name;
        return this;
    }

    public String getCountry_name() {
        return country_name;
    }

    public BillingPojo setCountry_name(String country_name) {
        this.country_name = country_name;
        return this;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public BillingPojo setPostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }
}
