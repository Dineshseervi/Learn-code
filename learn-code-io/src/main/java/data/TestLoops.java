package main.java.data;

public class TestLoops {
    public static void doSomeTask(Integer loops)
    {
        Integer count =0;
        while(count<loops)
        {
            System.out.println("count"+count);
            if(loops==5)
            {
                System.out.println("loop out");
                return;
            }
            count++;
        }
    }
    public static void main(String[] args) {
        String pattern="/rest/dmp/dinesh/***";
        int lastIndexOfSlash=pattern.lastIndexOf("/");
        System.out.println("lastIndexOfSlash : "+lastIndexOfSlash);
        System.out.println("pattern length : "+pattern.length());
        String directoryPattern = pattern.substring(0, pattern.length() - 2);
        String directoryPatternwithSlash = pattern.substring(0, pattern.length() - 1);
        System.out.println("directoryPattern :"+directoryPattern);
        System.out.println("directoryPatternwithSlash :"+directoryPatternwithSlash);
        System.out.println("------- directoryPattern : "+pattern.substring(0, lastIndexOfSlash));
        System.out.println("----- directoryPatternwithSlash :"+pattern.substring(0, lastIndexOfSlash+1));
    }
}
