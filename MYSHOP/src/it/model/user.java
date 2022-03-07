package it.model;

public class user {
    private int id;
    private String username;
    private String password;
    private String Name;
    private String Surname;
    private int age;
    private String Email;
    private int telephone;
    private String Occupation;

    public user(int id, String username, String password, String Name, String Surname, int age, String Email, int telephone, String Occupation)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.Name = Name;
        this.Surname = Surname;
        this.age = age;
        this.Email = Email;
        this.telephone = telephone;
        this.Occupation = Occupation;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public String getOccupation() {
        return Occupation;
    }
    public void setOccupation(String occupation) {
        Occupation = occupation;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
