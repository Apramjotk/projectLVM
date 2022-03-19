public class physicalHardDrive {
    // based on description this is the only class that wouldn't use the user name  and also has a size
    String name;
    int size;

    // make a constructor for this class
    public physicalHardDrive(String name, int size){
        this.name= name;
        this. size= size;
    }

    // accesor method

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
