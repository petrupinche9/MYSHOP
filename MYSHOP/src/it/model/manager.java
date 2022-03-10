package it.model;

public class manager extends user
{
    private int id;
    private String username;
    private String password;
    private String Name;
    private String Surname;
    private int age;
    private String Email;
    private int telephone;
    private String Occupation;

    public manager(int id, String username, String password, String Name, String Surname, int age, String Email, int telephone, String Occupation)
    {
        super(id, username, password, Name, Surname, age, Email, telephone, Occupation);
    }

    public manager(){

    }
}
