class ScaryException extends Exception {
};

public class TestExceptions {
    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("Starat try");
            doRisky(test);
            System.out.println("Finish Try");
        } catch (ScaryException se) {
            System.out.println("Exception case");
        } finally {
            System.out.println("main finish");
        }
    }

    static void doRisky(String t) throws ScaryException {
        System.out.println("Start danger method");
        if ("yes".equals(t)) {
            throw new ScaryException();
        }
        System.out.println("finished mehtod");
        return;
    }

}
