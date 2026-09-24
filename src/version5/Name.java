package version5;

public class Name implements Cloneable {

    private String firstName;
    private String lastName;
    private String middleName;

    public Name() {
        this.firstName = "N/A";
        this.lastName = "N/A";
        this.middleName = "";
    }

    public Name(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        if (middleName == null || middleName.isEmpty()) {
            return lastName + ", " + firstName;
        }

        return lastName + ", " + firstName + " " + middleName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Name)) {
            return false;
        }

        Name other = (Name) obj;

        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && middleName.equals(other.middleName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode() + middleName.hashCode();
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}