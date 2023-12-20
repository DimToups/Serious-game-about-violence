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
    public FirstName getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public boolean isOriginDiscovered() {
        return isOriginDiscovered;
    }

    public void setOriginDiscovered(boolean originDiscovered) {
        isOriginDiscovered = originDiscovered;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
