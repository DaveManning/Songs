import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.regex.*;

import javax.swing.* ;

public class Songs {
	
	//public static String S_Ranking; //1-100
	public static String S_Title;
	public static String S_Writer;
	public static String S_Producer;
	public static String S_Release; 
	public static String S_Description;
	public static String S_Url = "http://www.rollingstone.com/music/lists/the-500-greatest-songs-of-all-time-20110407/bob-dylan-like-a-rolling-stone-20110516";
	public static String MainText;
	

	
    private void getSourceCode(String url, int counter)
    {
    	String line = "";
    	//BufferedReader in = null;
        try
        {

			Matcher matcher;
            //creating the URL
            URL pageURL = new URL(url);
            FileReader fr;
            int Ranking = counter;
			boolean f1= false, f2= false, f3= false, f4= false, f5= false, f6= false;
			
			//Pattern Ranking;
			Pattern Title;
			Pattern Writer;
			Pattern Producer;
			Pattern Release;
			Pattern Description;
			Pattern Url;
            
            //Create the http url connection object
            HttpURLConnection urlConnection = (HttpURLConnection) pageURL.openConnection();
           
            //Reading the stream
            //InputStream in2 = new BufferedInputStream(urlConnection.getInputStream());
          //Reading the stream
            BufferedReader in = new BufferedReader(new InputStreamReader( pageURL.openStream()));
            
			//Ranking = Pattern.compile("meta name=\"description\"(.*?)/>");
			Title = Pattern.compile("meta name=\"title\"(.*?)/>");
			Writer = Pattern.compile("meta name=\"description\"(.*?)Producer:");
			Producer = Pattern.compile("meta name=\"description\"(.*?)Released:");
			Release = Pattern.compile("meta name=\"description\"(.*?)/>");
			Description = Pattern.compile("meta name=\"description\"(.*?)/>");
			Url = Pattern.compile("sliderNo \">" + counter+1 + "</div>");

            
			while ((line = in.readLine()) != null) {
				try {
					
					String page;
					page = pageURL.toString();
					fr = new FileReader(page);
					BufferedReader br = new BufferedReader(fr);
					String s;
				    //FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    //BufferedWriter bw = new BufferedWriter(fw);
					//bw.write(filename);
				    //fr.(Ranking);//appends the string to the file

					
					if (!f1){
					matcher = Title.matcher(line);
					if (matcher.find()) { 
						line = matcher.group();
						S_Title = line.substring(43, line.length()-21);
						//S_Title = S_Title.substring(S_Title.lastIndexOf(">")+1, line.length()-13);
						s =("Title:" + S_Title);
						//System.out.println("group:" + matcher.group());
						f1= true;
						}// inner if
					}// outer if
					
					if (!f2){
					matcher = Writer.matcher(line);
					if (matcher.find()) { 
						line = matcher.group();
						S_Writer = line.substring(42, line.length()-10);
						//S_Writer = S_Writer.substring(S_Writer.lastIndexOf(">")+1, line.length()-13);
						s =("Writer:" + S_Writer);
						//System.out.println("group:" + matcher.group());
						f2= true;
						}// inner if
					}// outer if
					
					if (!f3){
					matcher = Producer.matcher(line);
					if (matcher.find()) { 
						line = matcher.group();
						S_Producer = line.substring(0, line.length()-10);
						S_Producer = S_Producer.substring(S_Producer.lastIndexOf("Producer:")+1, line.length()-10);
						s =("Producer:" + S_Producer);
						//System.out.println("group:" + matcher.group());
						f3= true;
						}// inner if
					}// outer if
					
					if (!f4){
					matcher = Release.matcher(line);
					if (matcher.find()) { 
						line = matcher.group();
						S_Release = line.substring(0, line.length()-13);
						S_Release = S_Release.substring(S_Release.lastIndexOf("Released:")+1, S_Release.lastIndexOf(","));
						s =("Release:" + S_Release);
						//System.out.println("group:" + matcher.group());
						f4= true;
						}// inner if
					}// outer if
					
					if (!f5){
					matcher = Description.matcher(line);
					if (matcher.find()) {
						line = in.readLine();
						line = matcher.group();
						S_Description = line.substring(0, line.length()-3);
						//S_Description = S_Description.substring(S_Description.lastIndexOf(">")+1, line.length()-13);
						s =("Description:" + S_Description);
						//System.out.println("group:" + matcher.group());
						f5= true;
						}// inner if
					}// outer if
					
					if (!f6){
					matcher = Url.matcher(line);
					if (matcher.find()) {
						line = in.readLine();
						line = in.readLine();
						line = in.readLine();
						line = matcher.group();
						String temp = line.substring(8, line.length()-3);
						S_Url = "http://www.rollingstone.com" + temp; 
						f6= true;
						}// inner if
					}// outer if
				    fr.close();					
				}// end try 
				catch (Exception e) {
				}//end catch
			}// end while
			in.close();            
        }// end try block
        catch(MalformedURLException ex)
        {
            System.out.println(url + " is not a valid URL. Please enter a URL starting with http://");
        }// end catch for improper URL
        catch(IOException ie)
        {
            System.out.println("Error while reading: " + ie.getMessage());
        }// end catch for io reasons

    }// end getSourceCode method
    

	public  void main(String[] args) {
		int counter = 1;
        String url = S_Url;
        getSourceCode(url, counter);
        
        do {
        
        //find the metaname="Description" add content to output text
        //find next url inert in String
        //getSourceCode(url);
        	
        	counter++;
            getSourceCode(url, counter);
        } while (counter < 101);
        
        //display text file in ListDisplay
        
	}//end main


}//end class
