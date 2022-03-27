import java.util.UUID;

public class physicalVolume extends LogicalVolumeManager{
    // instance needed hard drive
    private physicalHardDrive hardDrive;
    private volumeGroups volume;
    private int size2;
    // **name, uuid so extended the LogicalVolumeManager
    public physicalVolume(String name,physicalHardDrive hardDrive ){
        super(name);// super always comes first in java and fill in the variables of the superclass
        this. hardDrive= hardDrive;
    }
    // accesor method

    public int getsizePv (){
       return hardDrive.getSize();
    }
    public physicalHardDrive getHardDrive()
    {
        return hardDrive;
    }

    public volumeGroups getVolume() {
        return volume;
    }
    public void volume(volumeGroups volume){
        this. volume= volume;
    }
}
