package se.lexicon.MartinKlasson.GolfProject.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

public class UpdateForm implements Serializable {

    @NotBlank
    private String playerId;

    @NotBlank(message = "Required field!")
    @Size(min = 2, max = 255, message = "Not a valid input!")
    private String firstName;

    @NotBlank(message = "Required field!")
    @Size(min = 2, max = 255, message = "Not a valid input!")
    private String lastName;

    @NotBlank(message = "Required field!")
    @Email(regexp = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email format is invalid")
    private String email;

    private String mobileNr;
    private double hcp;

    public UpdateForm() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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

    @Override
    public String toString() {
        return "UpdateForm{" +
                "playerId='" + playerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNr=" + mobileNr +
                ", hcp=" + hcp +
                '}';
    }
}
