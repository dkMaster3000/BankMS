package bank.management.system;

public class GeneralUtils {
    public static boolean checkIfAllFieldsFilled(String[] requiredFields) {
        for (String requiredField : requiredFields) {
            if (requiredField.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static void sendQuery(String query) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
