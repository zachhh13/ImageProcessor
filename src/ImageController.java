import java.io.IOException;
import java.util.Scanner;

/**
 * The ImageController class handles user input and controls the image processing operations.
 */
public class ImageController {
  private  String[] words;
  private String userCMD = "";
  private ImageProcessing p = new ImageProcessing();


  /**
   * Constructs an instance of ImageController.
   *
   * @throws IOException if an I/O error occurs.
   */
  ImageController() throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Hello, welcome to Image Processing, please enter the output folder filepath");

    userCMD = scanner.nextLine();
    p.setFolderLocation(userCMD);
    userCMD = "";

    while(true) {
      System.out.println("Please enter a command .........");
      userCMD = scanner.nextLine();
      words = userCMD.split("\\s+");
      p.setWords(words);
      p.pickCMD();

    }
  }

}
