package chapter1_foundmentals.programModel;
import edu.princeton.cs.algs4.*;

public class Wget {
    public static void main(String[] args) {

        // read in data from URL
        String url = "http://introcs.cs.princeton.edu/data/codes.csv";
        //读取URL的顺序
        //1.from local fileSystem 2.from jar 3.from http_connection
        In in = new In(url);
        String data = in.readAll();

        // write data to a file
        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }

}
