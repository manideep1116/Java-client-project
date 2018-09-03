import java.io.File;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;





public class Client {
    private static Scanner input;
    private static Scanner scanner;

    public static void main(String[] args){
        input = new Scanner(System.in);
        String choice;
        String name = "";
        String lastName = "";
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            Hello stub = (Hello) registry.lookup("Hello");
            Scanner sc=new Scanner(System.in);            // Calling the remote method using the obtained object

        	/*Now it is necessary obtain the Registry and the stub*/
            System.out.println("==============================");
            System.out.println("-----Connected to Server-----");

            while(true){
                if (stub!=null){

                    System.out.println("\nPlease insert first name of a student:");
                    name = sc.nextLine();
                    Student student = stub.getName(name);
                    System.out.println(student.getLastname());
                }
                else{
                    System.out.println("Student NOT found");
                }
                System.out.println("\nSearch another student? (Y o N)");
                choice = input.nextLine();
                if(choice.equalsIgnoreCase("Y")) {
                    continue;
                }
                else {
                    System.out.println("-----Connection closed-----");
                    System.out.println("==============================");
                    break;
                }

            }

        }catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
            e.printStackTrace();
        }

    }
    /*This method is used to change the char '\' -> '/' to change the String passed as value
     * from a java path to a Win path*/
    public static String changeSeparator(String s){
        char[] sep = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            sep[i] = s.charAt(i);
            if (sep[i] == '\\'){
                sep[i] = '/';
            }
        }
        String str =new String(sep);
        return str;

    }
}
