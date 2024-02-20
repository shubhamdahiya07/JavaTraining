package OOP.Objects;

class Address implements Cloneable {
    String street, city, country;
    Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    // copy constructor
    Address(Address address) {
        this.city = address.city;
        this.street = address.street;
        this.country = address.country;
    }

    @Override
    public Object clone() {
        try {
            return (Address) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return new Address(this.street, this.city, this.country);
        }
    }
}

class User implements Cloneable {
    String firstName, lastName;
    Address address;

    User() {
        firstName = lastName = "";
        address = null;
    }
    User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // copy constructor
    User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.address = new Address(user.address);
    }

    @Override
    public Object clone() {
        User cloneUser = null;
        try {
            cloneUser = (User) super.clone();
        }
        catch (CloneNotSupportedException e) {
            cloneUser = new User(this.firstName, this.lastName, this.address);
        }
        cloneUser.address = (Address) this.address.clone();
        return cloneUser;
    }
}

public class CopyingObjects {
    public static void main(String[] args) {
        User user = new User(
                "Aditya",
                "Nautiyal",
                new Address("Vikas Nagar", "Delhi", "India")
        );

        User shallowCopy = new User(user.firstName, user.lastName, user.address);

        /*
        For non-primitive types, only the references are copied
        That means, if changes are made in the non-primitive attributes
        of the original object, they would also be reflected in the shallowCopy
         */

        System.out.println("City in copy object: "+ shallowCopy.address.city);
        user.address.city = "Chandigarh";
        System.out.println("Original object updated...");
        System.out.println("City in copy object: " + shallowCopy.address.city);

        /*
        To perform shallow copy, we can use the copy constructors in the classes
         */

        User copyConstructorUser = new User(user);

        /*
        Drawback:
        1. copy constructors can only be created if you have the access to the class
            definition file
        2. for complex objects, adding copy constructors in all the class definitions
            is not practical approach
         */

        /*
        Another approach is to implement the Cloneable interface
        by writing clone() function inside the class.
         */

        User cloneableUser = (User) user.clone();

    }
}
