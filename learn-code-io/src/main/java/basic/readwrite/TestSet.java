package main.java.basic.readwrite;

import main.java.basic.readwrite.march.AddressA;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestSet {
    public static void main(String[] args) throws ParseException {
        System.out.println(FileService.valueOf("BoxFileService".toUpperCase()).getBeanName());

        AddressA addressA=new AddressA();
        System.out.println("pin"+addressA.getPin());
        System.out.println("properties "+System.getProperties().toString());
        // wm.studioUrl

        List<String> stringCollection=new ArrayList<>();
        System.getProperties().put("dineshKey","dineshValue");
        System.getProperty("dineshKey");

        System.out.println(InputOutputOperations.class.toString());
        Object name=null;
        String fullName=(String)name;
        System.out.println("fullName "+fullName);



    }


    private enum FileService {

        DMP_S3("DmpS3FileService","dmp", "s3DmpFileService"),
        LOCAL("LocalFileService","wm_preview", "defaultFileService"),
        BOXFILESERVICE("BoxFileService","BoxFileService","boxFileServiceManagerImpl");

        private final String name;
        private final String key;
        private final String beanName;


        FileService(String name,String key, String beanName) {
            this.name=name;
            this.key = key;
            this.beanName = beanName;
        }

        public String getKey() {
            return key;
        }

        public String getBeanName() {
            return beanName;
        }

        public String getName() {
            return name;
        }
    }

}
