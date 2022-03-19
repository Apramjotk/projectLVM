import java.util.UUID;
// superclass for now plan is to make this the superclass since it has the most consistent in common
public class LogicalVolumeManager {
    // based on description in what componets of subclasses nessed they all have a name and UUID in common
    private String name;
    private UUID uuid;

    // make a constructor for the main superclass
    public LogicalVolumeManager(String name, UUID uuid){
        this.name= name;
        this.uuid= uuid;
    }
    // now make a accesor method for each since they will be used in the other subclasses

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
