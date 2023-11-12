import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.junit.Assert.*;

public class ImageProcessingTest {
  ImageProcessing p;

  ImageUtil i = new ImageUtil();

  String FolderLocation = "";  //<--------- Your folder location NO SPACES!!!!!
  String ppmLocation = ""; // <------- your ppm location, PLEASE NO SPACES!!!



  //none of my tests pass, but this is how I would test them

//PLEASE DOWNLOAD THE FILES IN THE GITHUB AND PLACE THEIR FILEPATHS RESPECTIVELY
  ArrayList<ArrayList<int[]>> correctFlipVertically = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/verticle-koala.ppm");
  ArrayList<ArrayList<int[]>> correctFlipHorizontally = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/horizontal-koala.ppm");
  ArrayList<ArrayList<int[]>> correctBrightened = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/koala-bright.ppm");
  ArrayList<ArrayList<int[]>> correctRed = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/koala-red.ppm");
  ArrayList<ArrayList<int[]>> correctBlue = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/koala-blue.ppm");
  ArrayList<ArrayList<int[]>> correctGreen = i.readPPM("/Users/zachhixson/Desktop/HWOUTPUTS/koala-green.ppm");


  void initData() throws IOException {
    p = new ImageProcessing();
  }


  @org.junit.Test
  public void setFolderLocation() throws IOException {
    initData();
    p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    assertEquals(p.getFolderLocation(), "/Users/zachhixson/Desktop/HWOUTPUTS");
  }

  @org.junit.Test
  public void setWords() throws IOException {
    initData();
    String s[] = {"hi", "there", "I", "am", "good"};
    p.setWords(s);

    assertEquals(p.getWords(), s);
  }



  @org.junit.Test
  public void valueComp() throws IOException {
    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    if(FolderLocation == "") {
      p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    } else {
      p.setFolderLocation(FolderLocation);
    }


    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!
    ArrayList<ArrayList<int[]>> a;

    if(ppmLocation == "") {
      a = i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");
    } else {
      a = i.readPPM(ppmLocation);
    }

    HashMap<String, ArrayList<ArrayList<int[]>>> h = new HashMap<String, ArrayList<ArrayList<int[]>>>();
    h.put("koala", a);
    p.setImage(a);
    ArrayList<ArrayList<int[]>> result = p.valueComp(0);

    //assertEquals(correctRed, result);
    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctRed.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctRed.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctRed.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }


    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    if(FolderLocation == "") {
      p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    } else {
      p.setFolderLocation(FolderLocation);
    }


    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!


    if(ppmLocation == "") {
      a = i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");
    } else {
      a = i.readPPM(ppmLocation);
    }

    p.setImage(a);
     result = p.valueComp(1);

    //assertEquals(correctGreen, result);
    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctGreen.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctGreen.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctGreen.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }

    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");

    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!
    a =  i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");


    p.setImage(a);
    result = p.valueComp(2);

    //assertEquals(correctBlue, result);
    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctBlue.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctBlue.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctBlue.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }

  }

  @org.junit.Test
  public void flipVertically() throws IOException {
    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    if(FolderLocation == "") {
      p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    } else {
      p.setFolderLocation(FolderLocation);
    }


    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!
    ArrayList<ArrayList<int[]>> a;

    if(ppmLocation == "") {
      a = i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");
    } else {
      a = i.readPPM(ppmLocation);
    }
    HashMap<String, ArrayList<ArrayList<int[]>>> h = new HashMap<String, ArrayList<ArrayList<int[]>>>();
    h.put("koala", a);
    p.setImage(a);
ArrayList<ArrayList<int[]>> result = p.flipVertically();

//assertEquals(correctFlipVertically, result);
    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctFlipVertically.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctFlipVertically.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctFlipVertically.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }


  }

  @org.junit.Test
  public void horizontalFlip() throws IOException {
    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    if(FolderLocation == "") {
      p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    } else {
      p.setFolderLocation(FolderLocation);
    }


    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!
    ArrayList<ArrayList<int[]>> a;

    if(ppmLocation == "") {
      a = i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");
    } else {
      a = i.readPPM(ppmLocation);
    }
    HashMap<String, ArrayList<ArrayList<int[]>>> h = new HashMap<String, ArrayList<ArrayList<int[]>>>();
    h.put("koala", a);
    p.setImage(a);
    ArrayList<ArrayList<int[]>> result = p.horizontalFlip();

   // assertEquals(correctFlipHorizontally, result);

    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctFlipHorizontally.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctFlipHorizontally.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctFlipHorizontally.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }

  }

  @org.junit.Test
  public void brightenImage() throws IOException {
    initData();
    //PLEASE REPLACE THIS WITH AN EMPTY FOLDER!!!!!! AND COPY THE FILEPATH!!!
    if(FolderLocation == "") {
      p.setFolderLocation("/Users/zachhixson/Desktop/HWOUTPUTS");
    } else {
      p.setFolderLocation(FolderLocation);
    }


    //PLEASE HAVE ANY PPM READY TO USE PLEASE, PLEASE COPY AND PASTE THE FILEPATH BELOW!!!!
    ArrayList<ArrayList<int[]>> a;

    if(ppmLocation == "") {
      a = i.readPPM("/Users/zachhixson/Desktop/CS3500/OODExtraCredit1/code(1)/Koala.ppm");
    } else {
      a = i.readPPM(ppmLocation);
    }
   p.setNumber(10);
    p.setImage(a);
    ArrayList<ArrayList<int[]>> result = p.brightenImage();



    for(int i = 0; i < 4; i++) {
      Random first = new Random();
      int num1 = first.nextInt(700);
      for(int j = 0; j < 4; j++) {
        int num2 = first.nextInt(700);
        assertEquals(correctBrightened.get(num1).get(num2)[0], result.get(num1).get(num2)[0]);
        assertEquals(correctBrightened.get(num1).get(num2)[1], result.get(num1).get(num2)[1]);
        assertEquals(correctBrightened.get(num1).get(num2)[2], result.get(num1).get(num2)[2]);
      }
    }

  }

  @org.junit.Test
  public void save() {
    // After days of deliberation, I still have no clue how to test this method
  }
}