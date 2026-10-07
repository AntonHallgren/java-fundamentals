public class Person
{
    public String name;
    public int age;
    public String city;

    public Person(String name, int age, String city)
    {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void printProfile()
    {

        IO.println("==================");
        IO.println("\t My Profile");
        IO.println("==================");
        IO.println("Name : " + name);
        IO.println("Age  : " + age);
        IO.println("City : " + city);
        IO.println("==================");
    }

}
