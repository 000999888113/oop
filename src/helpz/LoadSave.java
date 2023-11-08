package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage getSpriteAtlas() {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("spriteatlas.PNG");
		try {
			img =ImageIO.read(is);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	
	//txt file
	public static void CreatedFile() {
		File txtFile = new File("res/testTextFile.txt");
		try {
			txtFile.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//create a new level with default values
	// createDefaultlevel from play 
	public static void CreatedLevel (String name,int[] idArr) {
		File newLevel = new File("res/"+name+".txt");	
		if(newLevel.exists()) {
			System.out.println("File : "+name + "already");
			return;
		}else{
			try {
				newLevel.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
				
			}
			WriteToFile(newLevel,idArr);
			
			
		}
			
	}
	
	private static void WriteToFile(File f ,int[] idArr) {
		try {
			PrintWriter pw = new PrintWriter(f);
			for(Integer i : idArr) {
				pw.println(i);
			}
			pw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public static void SaveLevel(String name,int[][] idArr) {
		File levelFile = new File("res/"+name+".txt");	
		if(levelFile.exists()) {
			WriteToFile(levelFile,Utilz.Arr2DTo1D(idArr));
		}else{
			System.out.println("File : "+name + "not exist ");
			return;
		}
	}
	
	
	//read from file to arraylist then GetLevelData
	private static ArrayList<Integer> ReadFromFile(File file) {
		ArrayList<Integer> list =  new ArrayList<>();
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				list.add(Integer.parseInt(sc.nextLine()));
			}
			sc.close();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		return list;
	}
	//arraylist to 2darray
	public static int[][] GetLevelData(String name) {
		File lvlFile = new File("res/"+name+".txt");
		if(lvlFile.exists()) {
			ArrayList<Integer> list =  ReadFromFile(lvlFile);
			return Utilz.ArrayListTo2D(list, 20, 20);
		}else{
			
			System.out.println("File : "+name + "not exists");
			return null;
			
		}
		
		
		
		
	}
	
	
	//save 2d int array to file
	
	
	
	
	
	
	//load int array from file
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
