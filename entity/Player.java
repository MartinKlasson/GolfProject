package se.lexicon.MartinKlasson.GolfProject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String playerId;
    private LocalDate regDate;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String mobileNr;
    private double hcp;
    private int nrOfRounds;

    public Player() {
    }

    public Player(String playerId, LocalDate regDate, String firstName, String lastName, String password, String email, String mobileNr, double hcp, int nrOfRounds) {
        this.playerId = playerId;
        this.regDate = regDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNr = mobileNr;
        this.hcp = hcp;
        this.nrOfRounds = nrOfRounds;
    }

    public Player(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getPlayerId() {
        return playerId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
    }

    public double getHcp() {
        return hcp;
    }

    public void setHcp(double hcp) {
        this.hcp = hcp;
    }

    public int getNrOfRounds() {
        return nrOfRounds;
    }

    public void setNrOfRounds(int nrOfRounds) {
        this.nrOfRounds = nrOfRounds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId &&
                mobileNr == player.mobileNr &&
                Double.compare(player.hcp, hcp) == 0 &&
                nrOfRounds == player.nrOfRounds &&
                Objects.equals(regDate, player.regDate) &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, regDate, firstName, lastName, email, mobileNr, hcp, nrOfRounds);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", regDate=" + regDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNr=" + mobileNr +
                ", hcp=" + hcp +
                ", nrOfRounds=" + nrOfRounds +
                '}';
    }
}