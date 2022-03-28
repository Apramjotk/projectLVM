import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // ask the user the commands they want
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the LVM system. Here are the choices you here. If you want to leave type leave");
        boolean leave = false;
        commands c = new commands();

        String choice = "";
        while (! leave) {
            System.out.print("cmd#: ");
            choice = input.nextLine().toLowerCase();
            if (choice.contains("install-drive")) {
                c.installDrive(choice);
            } else if (choice.contains("list-drives")) {
                c.listDrives(choice);
            } else if (choice.contains("pvcreate")) {
                   c.PVCreate(choice);
            } else if (choice.contains("pvlist")) {
               c.PhysicalVolumeList();
            } else if (choice.contains("vgcreate")) {
                c.VGCreate(choice);

            } else if (choice.contains("vgextend")) {

                c.extendVolume(choice);


            } else if (choice.contains("vglist")) {
                c.VolList();
            }
            else if (choice.contains("lvcreate")) {
                    c.createLV(choice);
            }
            else if (choice.contains("lvlist")) {
                c.lvlist(choice);
            }else if (choice.contains("exit")) {
                leave = true;
                System.out.println("Good Bye");
            } else {
                System.out.println("Our sytem can not handle such a command yet");
            }


        }


    }
}