import java.net.*;
import java.io.*;

public class Server{
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Daytime service started");
            for (;;) {
                Socket nextClient = server.accept();
                serving nextThread = new serving(nextClient);
                nextThread.start();
            }
        }
        catch(IOException oh){

        }
    }
}
class serving extends Thread{
    Socket nextClient;
    double[]d1;
    public serving(Socket clientSocket) {
        this.nextClient = clientSocket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(nextClient.getInputStream());
            double num=in.readDouble();
            double[] d=new double[50];
            int c=0;
            do{
                d[c]=num;
                num=in.readDouble();
                c++;
                if(num==-1)
                    d[c]=num;
            }while(num!=-1);
            d1=new double[c];
            for(int x=0;x<d1.length;x++)
                d1[x]=d[x];
            java.util.Arrays.sort(d1);
            DataOutputStream out = new DataOutputStream(nextClient.getOutputStream());
            for(double e:d1)
                out.writeDouble(e);
            FileWriter wr=new FileWriter("log.txt",true);
            PrintWriter dwr=new PrintWriter(wr);
            long millis = System.currentTimeMillis();
            java.util.Date date = new java.util.Date(millis);
            dwr.print(date+"\t"+nextClient.getInetAddress().getHostAddress()+":"+nextClient.getPort()+"\t");
            for(double q:d1){
                dwr.print(q);
            }
            dwr.println();
            dwr.close();
        }
        catch(IOException oh){

        }
    }
}