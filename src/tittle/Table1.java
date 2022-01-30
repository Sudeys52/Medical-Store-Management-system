
package tittle;


class Table1 {
         int Age;
    String Name;
    
    String Address;
    public Table1(){
        this.Age = 0;
        this.Name = "";
        this.Address = "";
    }

    public Table1(int Age, String Name, String Address) {
        this.Age = Age;
        this.Name = Name;
        this.Address = Address;
    
    }
     public int getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
