import java.util.ArrayList;
import java.util.UUID;

public class volumeGroups extends LogicalVolumeManager{
    // **name, uuid so extended the LogicalVolumeManager
    // a list from the physicalVolumes class and Logical Volumes
    private ArrayList<physicalVolume> physicalVol= new ArrayList<physicalVolume>();
    private ArrayList<logicalVolumes> logicalVolumes= new ArrayList<logicalVolumes>();
    int size=0;

    // constructor calling the superclass
    public volumeGroups(String name, UUID uuid, ArrayList<physicalVolume> physicalVo, ArrayList<logicalVolumes> logicalVolumes){
        super(name, uuid);
        this.physicalVol= physicalVol;
        this.logicalVolumes= logicalVolumes;

    }
    // accesor methods


    public ArrayList<logicalVolumes> getLogicalVolumes() {
        return logicalVolumes;
    }

    public ArrayList<physicalVolume> getPhysicalVol() {
        return physicalVol;
    }
    // now make methods of thic class that would get the size , and display the amount of free space

    public int sizeofVolumeGroup(){
        int size=0;
      for (physicalVolume add: physicalVol){
          size+=add.size();
      }
       return size;
    }
    // a method to calculate the free space is needed
    public int freeSpaceOfVG(){
        int space=0;
        for (logicalVolumes free: logicalVolumes  ){ // find total useing logical operations
            space+= free.getSize();
        }
        for (physicalVolume free: physicalVol ){
            space-= free.size();
        }

       return space;

    }
}
