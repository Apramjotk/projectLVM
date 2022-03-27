import java.util.ArrayList;
import java.util.UUID;

public class volumeGroups extends LogicalVolumeManager{
    // **name, uuid so extended the LogicalVolumeManager
    // a list from the physicalVolumes class and Logical Volumes
    private ArrayList<physicalVolume> physicalVol= new ArrayList<physicalVolume>();
    private ArrayList<logicalVolumes> logicalVolum= new ArrayList<logicalVolumes>();
    private double size;
    private double space;

    // constructor calling the superclass
    public volumeGroups(String name, physicalVolume physical ){
        super(name);
        physicalVol.add(physical);


    }
    // accesor methods


    public ArrayList<logicalVolumes> getLogicalVolumes() {
        return logicalVolum;
    }

    public ArrayList<physicalVolume> getPhysicalVol() {
        return physicalVol;
    }
    // now make methods of thic class that would get the size , and display the amount of free space

    public double sizeofVolumeGroup(){
          size=0;
      for (physicalVolume add: physicalVol){
          size+=add.getsizePv();
      }
       return size;
    }
    // a method to calculate the free space is needed
    public double freeSpaceOfVG(){
         double space2=0;
        for (logicalVolumes free: logicalVolum  ){ // find total useing logical operations
            space2+= free.getSize();
        }
        space=sizeofVolumeGroup()- space2;

       return space;

    }


    }



