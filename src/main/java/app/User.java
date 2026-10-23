package app;

public class User {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String city;
    private String phone;

    public User(String name, String surname, Integer age, String email, String city, String phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.city = city;
        this.phone = phone;
    }

    public User(Long id, String name, String surname, Integer age, String email, String city, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.city = city;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Integer getAge() { return age; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}