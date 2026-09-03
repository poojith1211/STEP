import java.util.*;

public class Banktransaction {

    static String normalizeReference(String raw) {

        raw = raw.trim();

        if (raw.length() < 3)
            return raw.toUpperCase();

        String bankCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bankCode + rest;
    }
    static String validateAndFormat(String reference) {

        if (reference.length() != 14)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i)))
                return "Invalid: body must contain only digits";
        }

 String bankCode = reference.substring(0, 3);
     String date = reference.substring(3, 9);
 String sequence = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();

        sb.append("[");
 sb.append(bankCode);
        sb.append("] DATE: ");
    sb.append(date.substring(0, 2));
        sb.append("/");
        sb.append(date.substring(2, 4));
        sb.append("/");
  sb.append(date.substring(4, 6));
        sb.append(" | SEQ: ");
     sb.append(sequence);
        return sb.toString();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String reference = normalizeReference(raw);
        System.out.println(validateAndFormat(reference));
    }
}