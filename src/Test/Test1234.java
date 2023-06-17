package Test;

public class Test1234 {

    static void get(String pattern, String target)
    {
        int x,y,p=0,t=0;
        int patLen = pattern.length(),tarLen = target.length();
        if(pattern.length() > target.length()) {
            System.out.println("Not possible");
            return;
        }


        for (x = 0; x <= tarLen; x++) {
            if (x < patLen) {
                p += pattern.charAt(x);
                t += target.charAt(x);
            } else {
                if (p == t) {
                    for (y = 0; y < patLen; y++) {
                        if (target.charAt(x + y) != pattern.charAt(y))
                            break;
                    }
                    if (y == pattern.length()) {
                        System.out.println(
                                "Found the required answer at " + x);
                        //todo if multiple patterns are present
                        return;
                    }
                }
                t = (t - target.charAt(x)) + target.charAt(x + pattern.length());
            }
        }
    }
}
