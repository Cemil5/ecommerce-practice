package e_commerceApp;

public class Address {

    private String streetNumber;
    private String streetName;
    private String additionalAddressLine;
    private String zipCode;
    private String state;

    public Address(String streetNumber, String streetName, String additionalAddressLine, String zipCode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddressLine = additionalAddressLine;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAdditionalAddressLine() {
        return additionalAddressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public static void printAddressByCustomerId(Customer customer) {
        if (!customer.getAddress().isEmpty()) {
//            for (Address address : customer.getAddress()) {
//                System.out.println(" Street Name: " + address.getStreetName() +
//                        " Street Number: " + address.getStreetNumber() + "ZipCode:  "
//                        + address.getZipCode() + " State: " + address.getState());
//            }

            customer.getAddress().forEach(
                    address -> System.out.println(" Street Name: " + address.getStreetName() +
                            " Street Number: " + address.getStreetNumber() + "ZipCode:  "
                            + address.getZipCode() + " State: " + address.getState())
            );
        } else {
            System.out.println("You don't have an address yet");
        }
    }
}
