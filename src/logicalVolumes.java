import java.util.UUID;

public class logicalVolumes extends LogicalVolumeManager{
    // an associated volume group

    private int size;
    // new size since this has a different size

    // **name, uuid so extended the LogicalVolumeManager
    public logicalVolumes(String name,int size){
     super(name);

     this.size= size;

    }
      //accesor method


    public int getSize() {
        return size;
    }
}
