package domain;

import java.util.Date;

public class ClientCard {

    private int id;
    private String lastName;
    private String firstName;
    private String CNP; //unic!!
    private Date birthDate; //dd.mm.yyyy
    private Date inregistrationDate; //dd.mm.yyyy

    public ClientCard() {
    }

    public ClientCard(int id, String lastName, String firstName, String CNP, Date birthDate, Date inregistrationDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.inregistrationDate = inregistrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getInregistrationDate() {
        return inregistrationDate;
    }

    public void setInregistrationDate(Date inregistrationDate) {
        this.inregistrationDate = inregistrationDate;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "idClient=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", birthDate=" + birthDate +
                ", inregistrationDate=" + inregistrationDate +
                '}';
    }
}
