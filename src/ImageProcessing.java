import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The ImageProcessing class represents an image processing system that performs various operations on images
 * such as loading, manipulating, and saving images.
 */
public class ImageProcessing {
  private String userCMD = "";
  private HashMap<String,ArrayList<ArrayList<int[]>>> files = new HashMap<String,ArrayList<ArrayList<int[]>>>();
  private String fileName = "";
  private int number;
  private  String[] words;
  private ArrayList<ArrayList<int[]>> image = new ArrayList<ArrayList<int[]>>();
  private String folderLocation;

  /**
   * Sets the folder location where the image files will be saved.
   *
   * @param s the folder location.
   */
  void setFolderLocation(String s) {
    this.folderLocation = s;
  }

  /**
   * Returns the folder location where the image files are saved.
   *
   * @return the folder location.
   */
  public String getFolderLocation() {
    return this.folderLocation;
  }

  /**
   * Returns the array of words entered by the user.
   *
   * @return the array of words.
   */
  public String[] getWords() {
    return words;
  }


  /**
   * Constructs an instance of ImageProcessing.
   *
   * @throws IOException if an I/O error occurs.
   */
  ImageProcessing() throws IOException {

  }

  /**
   * Sets the array of words entered by the user.
   *
   * @param w the array of words.
   */
  void setWords(String[] w) {
    this.words = w;
  }


  /**
   * Returns the user command entered by the user.
   *
   * @return the user command.
   */
  public String getUserCMD() {
    return userCMD;
  }


  /**
   * Sets the user command entered by the user.
   *
   * @param userCMD the user command.
   */
  public void setUserCMD(String userCMD) {
    this.userCMD = userCMD;
  }

  /**
   * Returns the HashMap that stores the image files.
   *
   * @return the HashMap of image files.
   */
  public HashMap<String, ArrayList<ArrayList<int[]>>> getFiles() {
    return files;
  }

  /**
   * Sets the HashMap that stores the image files.
   *
   * @param files the HashMap of image files.
   */
  public void setFiles(HashMap<String, ArrayList<ArrayList<int[]>>> files) {
    this.files = files;
  }

  /**
   * Returns the value used for brightening the image.
   *
   * @return the brightening value.
   */
  public int getNumber() {
    return number;
  }

  /**
   * Sets the value used for brightening the image.
   *
   * @param number the brightening value.
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Returns the current image.
   *
   * @return the image.
   */
  public ArrayList<ArrayList<int[]>> getImage() {
    return image;
  }

  /**
   * Sets the current image.
   *
   * @param image the image.
   */
  public void setImage(ArrayList<ArrayList<int[]>> image) {
    this.image = image;
  }

  /**
   * Processes the user command and performs the corresponding image manipulation operation.
   *
   * @throws IOException if an I/O error occurs.
   */
  void pickCMD() throws IOException {
//    Scanner sc = new Scanner(System.in);
    switch(words[0]) {
      case "load" :

        fileName = words[1];
        ImageUtil i = new ImageUtil();
        image = i.readPPM(fileName);
        files.put(words[2], image);
        break;

      case "brighten":
        number = Integer.parseInt(words[1]);
        image = (ArrayList<ArrayList<int[]>>) files.get(words[2]).clone();
        files.put(words[3], brightenImage());
        System.out.println("Brightened");
        break;

      case "vertical-flip" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], flipVertically());
        System.out.println("flipped");
        break;

      case "horizontal-flip" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], horizontalFlip());
        System.out.println("flipped");
        break;

      case "save" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[2]).clone();
        save(words[1]);
        break;

      case "value-red" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], valueComp(0));
        System.out.println("Gray scaled");
        break;

      case "value-green" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], valueComp(1));
        System.out.println("Gray scaled");
        break;

      case "value-blue" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], valueComp(2));
        System.out.println("Gray scaled");
        break;

      case "blur" :
        image = (ArrayList<ArrayList<int[]>>) files.get(words[1]).clone();
        files.put(words[2], blur());
        System.out.println("Blurred");
        break;

      case "exit" :
        System.out.println("Goodbye");
        System.exit(0);
        break;

      default:
        System.out.println("This is not a command");
        new ImageController();
        break;


    }
  }



ArrayList<ArrayList<int[]>> blur() {
    double[][] blurMatrix = {
            {(1.0/16.0), (1.0/8.0), (1.0/16.0)},
            {(1.0/8.0), (1.0/4), (1.0/8.0)},
            {(1.0/16.0), (1.0/8.0), (1.0/16.0)}
    };
    int sumRed = 0;
    int sumGreen = 0;
    int sumBlue = 0;

    for(int i = 0; i < image.size(); i++) {
      for(int j = 0; j < image.get(i).size(); j++) {



        for(int iB = 0; iB < 3; iB++) {
          for(int jB = 0; jB < 3; jB++) {

            int tempPixelY = (i + iB - 1);
            int tempPixelX = (j + jB - 1);

            if(tempPixelY < image.size() &&  tempPixelY >= 0 && tempPixelX < image.get(i).size() && tempPixelX >= 0) {

              sumRed += image.get(tempPixelY).get(tempPixelX)[0] * ;
              sumGreen += image.get(tempPixelY).get(tempPixelX)[1];
              sumBlue += image.get(tempPixelY).get(tempPixelX)[2];


            }
          }
        }

        int avgRed = sumRed;
        int avgGreen = sumGreen;
        int avgBlue = sumBlue;

        double[] temp

        image.get(i).set(j, )

      }
    }




}












  /**
   * Converts the image to grayscale based on the given value.
   *
   * @param val the value for grayscale conversion (0 for red, 1 for green, 2 for blue).
   * @return the resulting grayscale image.
   */
  ArrayList<ArrayList<int[]>> valueComp(int val)  {
    ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();

    for(int i = 0; i < image.size(); i++) {
      ArrayList<int[]> temp = new ArrayList<int[]>();
      for(int j = 0; j < image.get(i).size(); j++) {

        int[] rgbTemp = image.get(i).get(j);
        int[] rgb = new int[3];
        rgb[0] = rgbTemp[val];
        rgb[1] = rgbTemp[val];
        rgb[2] = rgbTemp[val];

        temp.add(rgb);


      }
      result.add(temp);
    }

    return result;
  }


  /**
   * Flips the image vertically.
   *
   * @return the vertically flipped image.
   * @throws IOException if an I/O error occurs.
   */
  ArrayList<ArrayList<int[]>> flipVertically() throws IOException {

    ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();
    for(int i = (image.size() - 1); i > -1; i--) {
      ArrayList<int[]> temp = new ArrayList<int[]>();
      for(int j = 0; j < image.get(i).size(); j++) {
        temp.add(image.get(i).get(j));



      }
      result.add(temp);
    }
    return result;
  }


  /**
   * Flips the image horizontally.
   *
   * @return the horizontally flipped image.
   * @throws IOException if an I/O error occurs.
   */
  ArrayList<ArrayList<int[]>> horizontalFlip() throws IOException {
    ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();


    for(int i = 0; i < image.size(); i++) {
      ArrayList<int[]> temp = new ArrayList<int[]>();
      for(int j = (image.get(i).size() - 1); j > -1; j--) {
        temp.add(image.get(i).get(j));



      }
      result.add(temp);
    }
    return result;

  }

  /**
   * Brightens or darkens the image based on the specified number.
   *
   * @return the brightened or darkened image.
   * @throws IOException if an I/O error occurs.
   */
  ArrayList<ArrayList<int[]>> brightenImage() throws IOException {

    ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();

    for(int i = 0; i < image.size(); i++) {
      ArrayList<int[]> temp = new ArrayList<int[]>();
      for(int j = 0; j < image.get(i).size(); j++) {

        int[] rgbTemp = image.get(i).get(j);
        int[] rgb = new int[3];
        if(rgbTemp[0] + number < 256) {
          rgb[0] = rgbTemp[0] + number;
        } else {
          rgb[0] = 255;
        }

        if(rgbTemp[1] + number < 256) {
          rgb[1] = rgbTemp[1] + number;
        } else {
          rgb[1] = 255;
        }

        if(rgbTemp[2] + number < 256) {
          rgb[2] = rgbTemp[2] + number;
        } else {
          rgb[2] = 255;
        }

        temp.add(rgb);


      }
      result.add(temp);
    }

    return result;
  }


  /**
   * Saves the image to a file with the specified name.
   *
   * @param name the name of the file to save.
   * @throws IOException if an I/O error occurs.
   */
  void save(String name) throws IOException {
    FileWriter writer = new FileWriter(folderLocation + "/" + name);

    System.out.println("Height of the image: " + image.size() + " width of the image: " + image.get(0).size());
    writer.write("P3\n");
    writer.write(image.get(0).size() + " " + image.size() + "\n");
    writer.write("255\n");


    for(int i = 0; i < image.size(); i++) {

      for(int j = 0; j < image.get(i).size(); j++) {

        int[] rgb = image.get(i).get(j);



        writer.write((rgb[0] ) + " " + (rgb[1] ) + " " + (rgb[2] ) + "\n");

      }

    }

    writer.close();
    System.out.println("file has been created");
  }




}
