import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents. Feel free to change this method 
 * as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   * @return the colors of the image as a 2D array of RGB values.
   */
  public static ArrayList<ArrayList<int[]>> readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      System.out.println("File "+filename+ " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: "+width);
    int height = sc.nextInt();
    System.out.println("Height of image: "+height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): "+maxValue);
    ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();
    for (int i=0;i<height;i++) {
      ArrayList<int[]> temp = new ArrayList<int[]>();
      for (int j=0;j<width;j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        temp.add(new int[]{r, g, b});
        //    System.out.println("Color of pixel ("+j+","+i+"): "+ r+","+g+","+b);
      }
      result.add(temp);
    }
    return result;
  }

  //demo main
  public static void main(String []args) throws IOException {
    String filename;

//      if (args.length>0) {
//          filename = args[0];
//      }
//      else {
//          filename = "/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code (1)/Koala.ppm";
//      }

//      ImageUtil.readPPM(filename);

    ImageController i = new ImageController();
  }
}

///Users/zachhixson/Desktop/HWOUTPUTS

// /Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm
// vertical-flip
// horizontal-flip
// brighten

//load /Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm koala

//brighten 10 koala koala-brighter

//save koala-test-3.ppm koala-brighter

//value-red koala koala-greyscale

//save koala-gray4.ppm koala-greyscale

///Users/zachhixson/Desktop/Seattle.ppm