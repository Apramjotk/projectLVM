import java.util.UUID;

public class physicalVolume extends LogicalVolumeManager{
    // instance needed hard drive
    private physicalHardDrive hardDrive;
    // **name, uuid so extended the LogicalVolumeManager
    public physicalVolume(String name, UUID uuid,physicalHardDrive hardDrive ){
        super(name,uuid);// super always comes first in java and fill in the variables of the superclass
        this. hardDrive= hardDrive;
    }
    // accesor method

    public int size (){
       return hardDrive.getSize();
    }
    public physicalHardDrive getHardDrive() {
        return hardDrive;
    }

}
