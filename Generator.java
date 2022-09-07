import java.util.Random;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Generator {
    public static void main (String[] args){
        System.out.println("The unique ISRC code is: "  +
                DetermineCountryCode() + "-" +
                GenerateRegistrantCode() + "-" +
                GenerateDate() + "-" +
                GenerateDesignationCode());

//        if(GenerateDesignationCode().length() != 5){
//            System.out.println("Error!");
//        }
    }

    static String GenerateDesignationCode(){
        Random randomise = new Random();
        int designationCode = randomise.nextInt(100000);

        String numsInString = String.valueOf(designationCode);
        while (numsInString.length() != 5){
            System.out.println("Code not valid. Let's run again.");
            break;
        }
        return numsInString;
    }

    static String GenerateRegistrantCode(){
        Scanner userChars = new Scanner(System.in);
        System.out.println("Please enter the registrant code " +
                "(This is usually 2 or 3 letters, e.g.: VM, " +
                "BKR, SNY, WB.): ");

        return userChars.nextLine();
    }

    static String GenerateDate(){
        Date currentDate = Calendar.getInstance().getTime();
        DateFormat myFormat = new SimpleDateFormat();
        String stringDate = myFormat.format(currentDate);
        return stringDate.substring(2,4);
    }

    static String DetermineCountryCode(){
        HashMap<String,String> codeMap = new HashMap<>();

        codeMap.put("South Africa", "ZA");
        codeMap.put("Great Britain", "GB");
        codeMap.put("United States", "US");
        codeMap.put("Japan", "JP");
        codeMap.put("Germany", "DE");

        System.out.println("Please enter country where song " +
                "originates: ");
        Scanner country = new Scanner(System.in);
        String countryEntered = country.nextLine();

        StringBuilder countryCode = new StringBuilder();
        for (HashMap.Entry pairEntry: codeMap.entrySet()) {
            countryCode.append(pairEntry.getValue());
        }
        String originCode = "";
        switch (countryEntered) {
            case "Great Britain" -> originCode += countryCode.substring(0, 2);
            case "United States" -> originCode += countryCode.substring(2, 4);
            case "Japan" -> originCode += countryCode.substring(4, 6);
            case "South Africa" -> originCode += countryCode.substring(6, 8);
            case "Germany" -> originCode += countryCode.substring(8, 10);
        }
        return originCode;
    }
}
