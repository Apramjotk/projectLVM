import java.util.ArrayList;
public class commands {
    // write arraylist for all instaniated class manager
    private ArrayList<physicalVolume> physicalVol = new ArrayList<physicalVolume>();
    private ArrayList<logicalVolumes> logicalVolum = new ArrayList<logicalVolumes>();
    private ArrayList<physicalHardDrive> drive = new ArrayList<physicalHardDrive>();
    private ArrayList<volumeGroups> vol = new ArrayList<volumeGroups>();
    boolean x= true;
    private String first;
    private String second;
    private int space;

    public ArrayList<physicalVolume> getPhysicalVol() {
        return physicalVol;
    }

    public ArrayList<logicalVolumes> getLogicalVolum() {
        return logicalVolum;
    }

    public ArrayList<physicalHardDrive> getDrive() {
        return drive;
    }

    public ArrayList<volumeGroups> getVol() {
        return vol;
    }

    public boolean alreadyexistDrive(String n) {
        boolean Alreadyadded = false;
        for (int i = 0; i < drive.size(); i++) {
            if (drive.get(i).getName().equals(n)) {
                System.out.println("No" + n + " drive is already installed!");
                Alreadyadded = true;
            }
        }
        return Alreadyadded;
    }

    public void installDrive(String option) {
        int x = option.substring(8).indexOf(" ");
        x = 8 + x + 1;
        int y = option.substring(x).indexOf(" ");
        String n = option.substring(x, y + x);
        if (!alreadyexistDrive(n)) {
            int num = Integer.parseInt(option.substring(x + y + 1, option.length() - 1));

            physicalHardDrive newPD = new physicalHardDrive(n, num);
            drive.add(newPD);
            System.out.println("Successfully installed " + n + " Drive");
        }
    }

    public void listDrives(String option) {
        if (drive.size() == 0) {
            System.out.println("You need a HardDrive first");
        }
        for (int i = 0; i < drive.size(); i++) {
            System.out.println(drive.get(i).getName() + " [" + drive.get(i).getSize() + "G]");
        }
    }

    public boolean doesThisRepeat(String option  ) {
        boolean y = true;
        if (x= true) {
            int z = drive.size();

            if (z != 0) {

                for (int i = 0; i < z; i++) {
                    if (drive.get(i).getName().equals(firstName(option))) {
                        y = false;

                    }
                }
            }
        }
        if (x= false){
            int z=   physicalVol.size();
            if (z != 0) {

                for (int i = 0; i <vol.size(); i++) {
                    if (vol.get(i).getName().equals(firstName(option))) {
                        System.out.println("VG " + firstName(option) + " exists here");
                        y = false;

                    }
                }
            }
        }

        return y;
    }
    public String firstName(String option){
        int x = option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1;
        return option.substring(option.indexOf(" ") + 1, x);
    }
    public String seconeName(String option){
        int x = option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1;
        return option.substring(x + 1);
    }


    public void PVCreate(String option) {
        x= true;
        int z = 0;
         physicalVolume answer;

        if (drive.size() != 0) {
            if (doesThisRepeat(option)) {
                boolean seen  = false;
                for (int i = 0; i < drive.size(); i++) {
                   answer=drive.get(i).getPv();
                    if (drive.get(i).getName().equals(seconeName(option))) {
                        if (answer == null){
                        physicalHardDrive pd = drive.get(i);
                        physicalVolume PVcreate = new physicalVolume(firstName(option), pd);
                        physicalVol.add(PVcreate);
                        drive.get(i).Pv(PVcreate);
                        seen = true;
                        System.out.println(" Created " + firstName(option) + " PV");
                        break;

                    }
                }
                  else if (drive.get(i).getName().equals(seconeName(option)) )
                  {
                      if (answer != null) {
                          seen = true;
                          System.out.println(" HardDrive " +seconeName(option)  + " exists for the Physical volume " + drive.get(i).getPv().getName() + "!");
                      }
                    }

                    if (seen) {
                        System.out.println(" PV " + firstName(option) + "already exists");

                    } else {
                        System.out.println(" no Hard Drives " + seconeName(option));
                    }
                }
            }
        } else {
            System.out.println("can't find hard drive for this");
        }


    }
    public void PhysicalVolumeList() {
        if (physicalVol.size() == 0) {
            System.out.println("Start by creating more Pv because there are none using PVCreate command");
        }
        else{
            for(int i=0; i< physicalVol.size();i++){
                System.out.print("The name of the pv is"+physicalVol.get(i).getName() );
                System.out.print( physicalVol.get(i).getName() +"["+physicalVol.get(i).getHardDrive().getSize()+" ] " );
                if (physicalVol.get(i).getVolume().getName()!=null) {
                    System.out.print("[" + physicalVol.get(i).getVolume().getName() + " ] ");
                }
                System.out.print("[" +physicalVol.get(i).getUuid() + "] \n");


            }
        }
    }
    public void VGCreate(String option) {
        x= false;
     volumeGroups v;
     physicalVolume p;
     System.out.println(doesThisRepeat(option));
     if (doesThisRepeat(option)){
         boolean seen  = false;
         for (int i = 0; i <physicalVol.size(); i++) {

             if(physicalVol.get(i).getName().equals(seconeName(option)) ){

                 if(physicalVol.get(i).getVolume() == null) {
                    p= physicalVol.get(i);
                    v= new volumeGroups(firstName(option), p);
                    vol.add(v);
                     p.volume(v);
                     System.out.println(" PV " + seconeName(option) + " with VG " + firstName(option)+", "+ firstName(option)+" created");
                     seen= true;
                     break;
                 }
                 else  {
                     System.out.println("This is a issue has  " + seconeName(option) + " already is part of the volume grouo " + physicalVol.get(i).getVolume().getName());
                     seen = true;
                 }

             }
         }
    }

}
   public void extendVolume (String option){

   }

    public void VolList()
    {
        if(vol.size() == 0)
        {
            System.out.println(" no created PVs!");
        }
        for(int i = 0; i < vol.size();i++)
        {
            System.out.print(vol.get(i).getName() + ": ");
            System.out.print("total size:["+ vol.get(i).sizeofVolumeGroup() + "G]  free space:["+ vol.get(i).freeSpaceOfVG() + "G] ");

            for( physicalVolume c : vol.get(i).getPhysicalVol())
            {
                System.out.print("[" + c.getName() + "] ");
            }
            System.out.print("[" + vol.get(i).getUuid() + "]");
            System.out.println();
        }
    }
    public void mix(String option){
      first= option.substring( option.indexOf(" ") + 1,(option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1));
      space = Integer.parseInt(option.substring(option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1+ 1,option.substring( option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1 + 1).indexOf(" ") +  option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1));
      second = option.substring(option.substring( option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1 + 1).indexOf(" ") +  option.substring(option.indexOf(" ") + 1).indexOf(" ") + option.indexOf(" ") + 1 + 2);

    }
    public void createLV (String option) {
        boolean y= false;
        mix(option);
        logicalVolumes l= null;
        volumeGroups g= null;
        int x= logicalVolum.size();

        if (x!=0){
            for (int i=0; i< vol.size(); i++){
                for(int j=0; j<vol.get(i).getLogicalVolumes().size();j++){
                    logicalVolumes b =vol.get(i).getLogicalVolumes().get(j);
                    if (b.getName().equals(first)){
                        y= true;
                     System.out.println("This is wrong as "+ first+ "is already in "+ vol.get(i).getName());
                     break;
                    }

                }
            }
        }
        if (!y){
            for (int i=0; i< vol.size(); i++) {
                g= vol.get(i);
             if (g.freeSpaceOfVG()-space >=0 && g.getName().equals(second)){
                 l=new logicalVolumes(first, space,second);
                 g.addLV(l);
                 logicalVolum.add(l);
                 System.out.println(" created LV " + first+ " to VG "+ second);

             }
             else if ( g.getName().equals(second)&& g.freeSpaceOfVG()-space <0 ){
                 System.out.println("This is wrong as there is not enough space as"+ g.freeSpaceOfVG());
             }

            }
            }
        else{
            System.out.println("This is  no vg to assign a lv named"+ first);
        }
        }

        public void lvlist(String option) {

            if (logicalVolum.size()== 0) {
                System.out.println(" no created PVs!");
            }
            for (int i = 0; i < logicalVolum.size(); i++) {
                System.out.print(logicalVolum.get(i).getName() + ": ");
                System.out.print("[" + logicalVolum.get(i).getSize()+ "G]");

                for (int e = 0; e < logicalVolum.size(); e++) {
                    System.out.print("[" + logicalVolum.get(i).v() + "] ");
                }
                System.out.print("[" + vol.get(i).getUuid() + "]");
                System.out.println();

            }

        }






}

