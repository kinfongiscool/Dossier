package com.delta.dossier;

import java.io.Serializable;

/**
 * Created by Kin on 8/3/13.
 */
public class Person implements Serializable{

    String personFirstName = "";
    String personLastName = "";
    String personOccupation = "";
    int personExperience = 0;
    String personAddress = "";
    String personPhoneNumber = "";
    String personEmailAddress = "";

    String personFacebookId = "";
    String personFacebookUrl = "";
    int personTwitterId = 0;
    String personTwitterUrl = "";
    String personLinkedInUrl = "";

    String personOther = "";

    int personNumberApps = 0;

    public Person(String personFirstName, String personLastName, String personOccupation,
                  int personExperience, String personAddress, String personPhoneNumber,
                  String personEmailAddress, String personFacebookId, String personFacebookUrl,
                  int personTwitterId, String personTwitterUrl, String personLinkedInUrl, String personOther,
                  int personNumberApps) {
        this.personFirstName = personFirstName;
        this. personLastName = personLastName;
        this.personOccupation = personOccupation;
        this.personExperience = personExperience;
        this.personAddress = personAddress;
        this.personPhoneNumber = personPhoneNumber;
        this.personEmailAddress = personEmailAddress;
        this.personFacebookId = personFacebookId;
        this.personFacebookUrl = personFacebookUrl;
        this.personTwitterId = personTwitterId;
        this.personTwitterUrl = personTwitterUrl;
        this.personLinkedInUrl = personLinkedInUrl;
        this.personOther = personOther;
        this.personNumberApps = personNumberApps;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonFacebookId() {
        return personFacebookId;
    }

    public void setPersonFacebookId(String personFacebookId) {
        this.personFacebookId = personFacebookId;
    }

    public String getPersonFacebookUrl() {
        return personFacebookUrl;
    }

    public void setPersonFacebookUrl(String personFacebookUrl) {
        this.personFacebookUrl = personFacebookUrl;
    }

    public int getPersonTwitterId() {
        return personTwitterId;
    }

    public void setPersonTwitterId(int personTwitterId) {
        this.personTwitterId = personTwitterId;
    }

    public String getPersonTwitterUrl() {
        return personTwitterUrl;
    }

    public void setPersonTwitterUrl(String personTwitterUrl) {
        this.personTwitterUrl = personTwitterUrl;
    }

    public String getPersonLinkedInUrl() {
        return personLinkedInUrl;
    }

    public void setPersonLinkedInUrl(String personLinkedInUrl) {
        this.personLinkedInUrl = personLinkedInUrl;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public int getPersonNumberOfAppsMade() {
        return personNumberApps;
    }

    public void setPersonNumberOfAppsMade(int personNumberOfAppsMade) {
        this.personNumberApps = personNumberOfAppsMade;
    }

    public String getPersonOccupation() {
        return personOccupation;
    }

    public void setPersonOccupation(String personOccupation) {
        this.personOccupation = personOccupation;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonEmailAddress() {
        return personEmailAddress;
    }

    public void setPersonEmailAddress(String personEmailAddress) {
        this.personEmailAddress = personEmailAddress;
    }

    public String getPersonOther() {
        return personOther;
    }

    public void setPersonOther(String personOther) {
        this.personOther = personOther;
    }

    public int getPersonNumberApps() {
        return personNumberApps;
    }

    public void setPersonNumberApps(int personNumberApps) {
        this.personNumberApps = personNumberApps;
    }

    public int getPersonExperience() {
        return personExperience;
    }

    public void setPersonExperience(int personExperience) {
        this.personExperience = personExperience;
    }
}
