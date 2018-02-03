package com.example.murodjonrahimov.savefellowsinfo.data_base;

/**
 * Created by murodjon.rahimov on 2/3/18.
 */

public class Fellow {
  private String firstName;
  private String phoneNumber;

  public Fellow(String firstName, String phoneNumber) {
    this.firstName = firstName;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
