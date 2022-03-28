import java.util.UUID;

public class logicalVolumes extends LogicalVolumeManager{
    // an associated volume group

    private int size;
    private String v;
    // new size since this has a different size

    // **name, uuid so extended the LogicalVolumeManager
    public logicalVolumes(String name,int size, String v){
     super(name);

     this.size= size;
     this.v= v;

    }
    public String v(){
        return this.v;
    }
      //accesor method


    public int getSize() {
        return size;
    }
}
