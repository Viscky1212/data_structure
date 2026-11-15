package systemDesign.easy;


import java.util.ArrayList;
import java.util.List;

// 1. Common Validator Interface
interface Validator {

    boolean isValid(String value);

    String name();
}

// 2. Email Validator
class EmailValidator implements Validator {

    @Override
    public boolean isValid(String value) {

        return value != null && value.contains("@");
    }

    @Override
    public String name() {

        return "Email";
    }
}

// 3. Length Validator
class LengthValidator implements Validator {

    private final int minLength;

    public LengthValidator(int minLength) {

        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String value) {

        return value != null && value.length() >= minLength;
    }

    @Override
    public String name() {

        return "Length";
    }
}

// 4. Digit Validator
class DigitValidator implements Validator {

    @Override
    public boolean isValid(String value) {

        if (value == null) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {

            char ch = value.charAt(i);

            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }

        return false;
    }

    @Override
    public String name() {

        return "Digit";
    }
}

// 5. Provided RegistrationForm class
class RegistrationForm {

    private final List<Validator> rules = new ArrayList<>();

    public RegistrationForm() {
    }

    public int addEmailRule() {

        rules.add(new EmailValidator());

        return rules.size() - 1;
    }

    public int addLengthRule(int minLength) {

        rules.add(new LengthValidator(minLength));

        return rules.size() - 1;
    }

    public int addDigitRule() {

        rules.add(new DigitValidator());

        return rules.size() - 1;
    }

    public boolean validate(String value) {

        for (Validator rule : rules) {

            if (!rule.isValid(value)) {
                return false;
            }
        }

        return true;
    }

    public String report(String value) {

        for (Validator rule : rules) {

            if (!rule.isValid(value)) {

                return value + " - FAILED (" + rule.name() + ")";
            }
        }

        return value + " - PASSED";
    }

    public int ruleCount() {

        return rules.size();
    }

    public static void main(String[] args) {

        RegistrationForm form = new RegistrationForm();

        // Add validation rules
        System.out.println("Email Rule Index: "
                + form.addEmailRule());

        System.out.println("Length Rule Index: "
                + form.addLengthRule(8));

        System.out.println("Digit Rule Index: "
                + form.addDigitRule());

        // Check total rules
        System.out.println("\nTotal Rules: "
                + form.ruleCount());

        // Test Case 1
        String input1 = "user@gmail.com123";

        System.out.println("\nTest Case 1:");
        System.out.println("Valid: " + form.validate(input1));
        System.out.println("Report: " + form.report(input1));

        // Test Case 2
        String input2 = "invalid-email";

        System.out.println("\nTest Case 2:");
        System.out.println("Valid: " + form.validate(input2));
        System.out.println("Report: " + form.report(input2));

        // Test Case 3
        String input3 = "user@gmail.com";

        System.out.println("\nTest Case 3:");
        System.out.println("Valid: " + form.validate(input3));
        System.out.println("Report: " + form.report(input3));

        // Test Case 4
        String input4 = "abc@123";

        System.out.println("\nTest Case 4:");
        System.out.println("Valid: " + form.validate(input4));
        System.out.println("Report: " + form.report(input4));
    }
}
