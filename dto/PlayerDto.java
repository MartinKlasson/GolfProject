package se.lexicon.MartinKlasson.GolfProject.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class PlayerDto implements Serializable {

    private String playerId;
    private LocalDate regDate = LocalDate.now();

    @NotBlank(message = "Required field!")
    @Size(min = 2, max = 255, message = "Not a valid input!")
    private String firstName;

    @NotBlank(message = "Required field!")
    @Size(min = 2, max = 255, message = "Not a valid input!")
    private String lastName;

    @NotBlank(message = "Password is required! At least 6 letters.")
    @Size(min = 6, max = 255, message = "Password need to be at least 6 letters long.")
    private String password;
    @NotBlank(message = "Please confirm password.")
    private String confirm;

    @NotBlank(message = "Required field!")
    @Email(regexp = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email format is invalid")
    private String email;


    private String mobileNr;
    private double hcp;
    private int nrOfRounds;

    public PlayerDto() {
    }

    public PlayerDto(String playerId, LocalDate regDate, @NotBlank(message = "Required field!") @Size(min = 2, max = 255, message = "Not a valid input!") String firstName,
                     @NotBlank(message = "Required field!") @Size(min = 2, max = 255, message = "Not a valid input!") String lastName,
                     @NotBlank(message = "Password is required! At least 6 letters.") @Size(min = 6, max = 255, message = "Password need to be at least 6 letters long.") String password,
                     @NotBlank(message = "Please confirm password.") String confirm, @NotBlank(message = "Required field!") @Email(regexp = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email format is invalid") String email,
                     String mobileNr, double hcp, int nrOfRounds) {
        this.playerId = playerId;
        this.regDate = regDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirm = confirm;
        this.email = email;
        this.mobileNr = mobileNr;
        this.hcp = hcp;
        this.nrOfRounds = nrOfRounds;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getNrOfRounds() {
        return nrOfRounds;
    }

    public void setNrOfRounds(int nrOfRounds) {
        this.nrOfRounds = nrOfRounds;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "playerId='" + playerId + '\'' +
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
