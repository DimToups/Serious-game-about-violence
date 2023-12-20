package fr.tyr.components.character.identity;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.identity.enums.Origin;

public class Identity {
    private FirstName firstName;
    private LastName lastName;
    private Gender gender;
    private Origin origin;
    private boolean isOriginDiscovered = false;
    private int age;

    /**
     * Send the instance's firstname field
     * @return The instance's firstname field
     */
    public FirstName getFirstName() {
        return firstName;
    }

    /**
     * Set the instance's firstname value with a specified Firstname value
     * @param firstName The FirstName instance replacing the current one
     */
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    /**
     * Send the instance's lastname field
     * @return The instance's lastname field
     */
    public LastName getLastName() {
        return lastName;
    }

    /**
     * Set the instance's lastname value with a specified Lastname value
     * @param lastName The LastName instance replacing the current one
     */
    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    /**
     * Send the instance's gender field
     * @return The instance's gender field
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Set the instance's gender value with a specified Gender value
     * @param gender The Gender instance replacing the current one
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Send the instance's origin field
     * @return The instance's origin field
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Set the instance's origin value with a specified Origin value
     * @param origin The Origin instance replacing the current one
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * Send the state of the instance's origin field
     * @return The state of the instance's origin field
     */
    public boolean isOriginDiscovered() {
        return isOriginDiscovered;
    }

    /**
     * Set the state of the origin field
     * @param originDiscovered The wanted state of the origin field
     */
    public void setOriginDiscovered(boolean originDiscovered) {
        isOriginDiscovered = originDiscovered;
    }

    /**
     * Send the instance's age field
     * @return The instance's age field
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the instance's age value with a specified int value
     * @param age The int instance replacing the current one
     */
    public void setAge(int age) {
        this.age = age;
    }
}
