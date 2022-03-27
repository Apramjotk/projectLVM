public class physicalHardDrive  {
    // based on description this is the only class that wouldn't use the user name  and also has a size
    String name;
    int size;
    private physicalVolume pv;

    // make a constructor for this class
    public physicalHardDrive(String name, int size){
       this.name= name;
       this.size= size;
    }

    // accesor method

    public String getName()
    {
        return name;
    }

    public int getSize()
    {
        return size;
    }
    public void Pv(physicalVolume pv)
    {
       this.pv= pv;
    }

    public physicalVolume getPv() {
        return pv;
    }


}
