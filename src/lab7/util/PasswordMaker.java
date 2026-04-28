package lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
    private static PasswordMaker instance;
    private static int callingCount = 0;

    private final String name;

    // b) instance initializata in bloc static
    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker("PasswordMaker");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    // a) Singleton getInstance
    public static PasswordMaker getInstance() {
        callingCount++;
        return instance;
    }

    // c) contor apeluri getInstance
    public static int getCallingCounts() {
        return callingCount;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}
