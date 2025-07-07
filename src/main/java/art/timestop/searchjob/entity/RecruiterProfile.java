package art.timestop.searchjob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recruiter_profile")
public class RecruiterProfile {

    @Id
    private int userAccoundId;

    @OneToOne
    @JoinColumn(name="user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String company;
    private String country;
    private String state;
    @Column(nullable=true, length=64)
    private String profilePhoto;
    
    public RecruiterProfile() {
     
    }

    public RecruiterProfile(Users users) {
        this.userId = users;
    }

    public RecruiterProfile(int userAccoundId, Users userId, String firstName, String lastName, String city,
            String company, String country, String state, String profilePhoto) {
        this.userAccoundId = userAccoundId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.company = company;
        this.country = country;
        this.state = state;
        this.profilePhoto = profilePhoto;
    }

    public int getUserAccoundId() {
        return userAccoundId;
    }

    public void setUserAccoundId(int userAccoundId) {
        this.userAccoundId = userAccoundId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "RecruiterProfile [userAccoundId=" + userAccoundId + ", userId=" + userId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", city=" + city + ", company=" + company + ", country=" + country
                + ", state=" + state + ", profilePhoto=" + profilePhoto + "]";
    }

   
    
}
