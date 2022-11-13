package model;

import java.time.Instant;

public class User {
    public long id;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private String appliances;
    private String address;
    private Role role;
    private Instant createdAt;
    private Instant updatedAt;

    public User(){
    }

    public User(long id, String userName, String passWord, String fullName, String email, String appliances, String address, Role role, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.email = email;
        this.appliances = appliances;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(long id, String userName, String passWord, String fullName, String email, String appliances, String address, Role role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.email = email;
        this.appliances = appliances;
        this.address = address;
        this.role = role;
    }

    public static User parseUser(String line) {
        User user = new User();
        String[] fields = line.split(",");
        user.id = Long.parseLong(fields[0]);
        user.userName = fields[1];
        user.passWord = fields[2];
        user.fullName = fields[3];
        user.email = fields[4];
        user.appliances = fields[5];
        user.address = fields[6];
        user.role = Role.parseRole(fields[7]);
        user.createdAt = Instant.parse(fields[8]);
        String temp = fields[9];
        if (temp != null && !temp.equals("null")) user.updatedAt = Instant.parse(temp);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppliances() {
        return appliances;
    }

    public void setAppliances(String appliances) {
        this.appliances = appliances;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return  id + "," +
                userName + "," +
                passWord + "," +
                fullName + "," +
                email + "," +
                appliances + "," +
                address + "," +
                role + "," +
                createdAt + "," +
                updatedAt
                ;
    }
}
