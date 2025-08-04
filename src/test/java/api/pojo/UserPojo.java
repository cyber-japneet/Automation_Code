package api.pojo;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserPojo {
    private String first_name;
    private String last_name;
    private String dob;
    private String phone;
    private String email;
    private String password;
    private AddressPojo address;

    // Getters and Setters
    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public AddressPojo getAddress() { return address; }
    public void setAddress(AddressPojo address) { this.address = address; }

    public static UserPojo generateFakeUser() {
        Faker faker = new Faker(new Locale("en-US"));

        UserPojo user = new UserPojo();
        user.setFirst_name(faker.name().firstName());
        user.setLast_name(faker.name().lastName());
        user.setDob(faker.date().birthday(18, 65).toInstant().toString().substring(0, 10));
        user.setPhone(faker.phoneNumber().subscriberNumber(10));
        user.setEmail(faker.internet().emailAddress());
        user.setPassword("Qwe#31cv@w");

        AddressPojo address = new AddressPojo();
        address.setStreet(faker.address().streetName());
        address.setCity(faker.address().city());
        address.setState(faker.address().stateAbbr());
        address.setCountry(faker.address().countryCode());
        address.setPostal_code(faker.address().zipCode());

        user.setAddress(address);

        return user;
    }
}
