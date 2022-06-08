package main.java;

public class CheckConfiguration {
    public static void main(String[] args) {
        System.out.println("print");
        System.out.println(System.getenv("java.util.logging.config.file"));
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(" DMP_COMPONENTS_USER_ROLE_URL_PREFIX  = "+System.getProperty("DMP_COMPONENTS_USER_ROLE_URL_PREFIX"));
    }
}
