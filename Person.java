public class Person {
    private String name;
    private int id;
    static int idno = 1;
    private int location = 0;

    Person(String name){
        this.name = name;
        this.id = idno;
        idno++;
    }

    public int getLocation(){
        return this.location;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    public void setLocation(int position){
        this.location = position;
    }
}
