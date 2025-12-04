package utilities;

import java.util.Date;

public class Common_utils {

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 10;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 15;
    public String getemailtimestamp()
    {
        Date date = new Date();
        return "arjun"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
    }
}
