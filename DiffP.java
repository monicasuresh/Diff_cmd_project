import java.util.*;
import java.io.*;

public class DiffP {

    static int buck;
   
    // counting total line numbers in file
    public static int count(String p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(p));
        int line = 0;
        while ((br.readLine()) != null) {
            line++;
        }
        return line;

    }//count

    //reading two files
    public static void read() throws IOException {
        Scanner c = new Scanner(System.in);
       // buck = Integer.parseInt(c.nextLine());  //Fixing the array bucket size
        //System.out.println(buck);
         buck=13;
        String ss = "/home/anjali/Desktop/" + c.nextLine();
        String sss = "/home/anjali/Desktop/" + c.nextLine();
        int l1 = count(ss);
        int l2 = count(sss);

        BufferedReader br = new BufferedReader(new FileReader(ss));
        BufferedReader br1 = new BufferedReader(new FileReader(sss));
        String s = null;
        String s1 = null;
        process(br, br1, s, s1, l1, l2);

    }//read

    //processing and passing each line num to bucket
    public static void process(BufferedReader br, BufferedReader br1, String s, String p, int l1, int l2) throws IOException {
        int c1 = 1, c2 = 1;
        while (((s = br.readLine()) != null) && ((p = br1.readLine()) != null)) {

            // converting string to ascii code
            byte h[] = s.getBytes();
            byte h1[] = p.getBytes();
            String sp = s.toString();
            String ps = p.toString();

            int bucket1 = hashing.hashs(buck, h);
            int bucket2 = hashing.hashs(buck, h1);
            if (bucket1 == bucket2) {
                hashing.store(bucket1, sp, ps, c1);

            } else {
                System.out.println(sp + " and " + ps + " " + "are not same sentence/word");
            }
            c1++;
            c2++;

        }

        if (l1 > l2) {

            System.out.println("File 1 contains more data:");
            System.out.println(s);
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } else if (l1 < l2) {

            System.out.println("File 2 contains more data:");
            while ((p = br1.readLine()) != null) {
                System.out.println(p);
            }
        }

        br.close();
        br1.close();

        hashing.processData();

    }//process

    //main method
    public static void main(String[] args) throws IOException {

        DiffP d = new DiffP();
        d.read();
    }//main

}
