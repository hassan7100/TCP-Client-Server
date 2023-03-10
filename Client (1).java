import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        String hostname = "localhost";
        try{
            Socket cl = new Socket(hostname, 3000);
            System.out.println("Enter Positive Numbers plz ,-1 to finish:");
            Scanner sc= new Scanner(System.in);
            double num=sc.nextDouble();
            double[] d=new double[50];
            int c=0;
            int count=0;
            do{
                d[c]=num;
                num=sc.nextDouble();
                c++;
            }while(num!=-1);
            count=c+1;
            double[]d1=new double[count];
            for(int x=0;x<d1.length;x++) {
                d1[x] = d[x];
                if(x==d1.length-1)
                    d1[x]=-1;
            }
            DataOutputStream wr = new DataOutputStream(cl.getOutputStream());
            for(double e:d1)
                wr.writeDouble(e);
            DataInputStream in = new DataInputStream(cl.getInputStream());
            for(int x=0;x<d1.length-1;x++)
                d1[x]=in.readDouble();
            for(double e:d1) {
             if(e==-1)
                 break;
                System.out.println(e);
            }
        }
        catch(IOException io){

        }
    }
}
