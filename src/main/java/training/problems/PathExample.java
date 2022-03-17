package training.problems;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;

public class PathExample {
   public static void main(String[] args) throws IOException {
	   Path path=Paths.get("src/main/java/training/problems/problem_input/hello");
	   System.out.println(path);
	   System.out.println(path.toAbsolutePath());
	   System.out.println(path.toRealPath());
//	   File file=path.toAbsolutePath().toFile();
//	   if(file.delete()) System.out.println("success");
//	   else System.out.println("file won");
//	   File file=new File(path.toAbsolutePath().toFile());
	   
   }
}