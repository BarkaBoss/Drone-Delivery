package ng.com.nokt.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHelper {

	public static boolean medicineCodeChecker(String str){

        boolean matchedCriteria = true;

        String regex = "^[A-Z0-9_]*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println("Correct");
            matchedCriteria = true;
        }else{
            matchedCriteria = false;
            System.out.println("Wrong");
        }
        return matchedCriteria;
    }
	
	public static boolean medicineNameChecker(String str){

        boolean matchedCriteria = true;

        String regex = "^[a-zA-Z_-]*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println("Correct");
            matchedCriteria = true;
        }else{
            matchedCriteria = false;
            System.out.println("Wrong");
        }
        return matchedCriteria;
    }
}
