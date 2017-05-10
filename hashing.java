import java.io.IOException;
import java.util.*;

public class hashing {

    static List<LinkedList> v = new ArrayList<LinkedList>();
    
    //dynamic creation of linkedlist when class loads by using static block
    static {
        // System.out.println(v.size());
        for (int i = 0; i < DiffP.buck; i++) {
            v.add(new LinkedList());
        }

        for (LinkedList s2 : v) {
            s2.add(0);
        }
    }//static

    // performing hashing
    static int hashs(int sz, byte a[]) {

        int sum = 0;
        int bucket = 0;
        if (sz != 0) {
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
            }
            bucket = sum % sz;

        }// if sz

        return bucket;
    }//hashs
    
    // adding data's into the linked list
    static void store(int b, String s, String p, int line) {
        LinkedList s2 = new LinkedList();
        s2 = v.get(b);

        int rr = (int) s2.get(0);
        s2.set(0, (rr += 2));
        s2.addLast(line + " " + s);
        s2.addLast(line + " " + p);

    }//store

    //sending data to lcs
    static void processData() throws IOException {

        for (LinkedList s : v) {
            if ((int) s.get(0) != 0) {
                int x = (int) s.get(0);
               
                for (int i = 1; i < x; i += 2) {
                    for (int j = i + 1; j <= x; j++) {
                       
                        String p = (String) s.get(i);
                        String k = (String) s.get(j);
                       
                        int l1 = p.length();
                        int l2 = k.length();
                       
                        Lcs.processLcs(p, k, l1, l2);
                        break;
                    }
                }
            }

        }
    }//processData()

}
