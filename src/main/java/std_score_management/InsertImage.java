package std_score_management;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class InsertImage {
	  public static void main(String[] args) 
	    {
	        System.out.println("시작================================");
	        String driverName = "com.mysql.jdbc.Driver";
	        String url = "jdbc:mysql://localhost:3306/std_score?useSSL=false";
	        String userName = "user_std_score";
	        String password = "rootroot";
	        Connection con = null;
	        try{
	        	System.out.println("시작1==========================");
	            Class.forName(driverName);
	            con = DriverManager.getConnection(url,userName,password);
	            File imgfile = new File("d:\\images\\1038.jpg");
	            System.out.println("중간=========================="+imgfile);
	            FileInputStream fin = new FileInputStream(imgfile);
	            System.out.println("중간1=========================="+fin);
	            PreparedStatement pre = con.prepareStatement("insert into photo (photoNo, fileName, stdPhoto) VALUES (?, ?, ?)");
	            pre.setInt(1,1);
	            pre.setString(2,"test");
	            pre.setBinaryStream(3,fin,(int)imgfile.length());//Stream형의 파일 업로드
	            pre.executeUpdate();
	            System.out.println("Inserting Successfully!");
	            pre.close();
	            con.close(); 
	        }
	        catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	    }

}
