import java.util.UUID;

public class logicalVolumes extends LogicalVolumeManager{
    // an associated volume group
    private volumeGroups group;
    // new size since this has a different size
    int size;
    // **name, uuid so extended the LogicalVolumeManager
    public logicalVolumes(String name, UUID uuid,volumeGroups group,int size){
     super(name, uuid);
    }
      //accesor method
    public volumeGroups getGroup() {
        return group;
    }
    //size method needed

    public int getSize() {
        return size;
    }
}
