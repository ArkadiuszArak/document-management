package pl.com.bottega.documentmanagement.api;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
public class EmployeeDetails {

    private String firsName, lastName, email, address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {

        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "address='" + address + '\'' +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean hasEmail(){
        return email != null;
    }
}
