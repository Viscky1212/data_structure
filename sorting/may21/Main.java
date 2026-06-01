package sorting.may21;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Map<String, Object> input = new HashMap<>();
        input.put("email", "test@abcdbl.com");
        input.put("age", 16);

        Map<String, Object> result = FormValidator.build()
                .email("email").required()
                .age("age").min(18)
                .validate(input);

        System.out.println(result);
    }
}

class FormValidator {

    private final List<Rule> rules = new ArrayList<>();

    private FormValidator() {
    }

    public static FormValidator build() {
        return new FormValidator();
    }

    public EmailRuleBuilder email(String fieldName) {
        return new EmailRuleBuilder(this, fieldName);
    }

    public AgeRuleBuilder age(String fieldName) {
        return new AgeRuleBuilder(this, fieldName);
    }

    void addRule(Rule rule) {
        rules.add(rule);
    }

    public Map<String, Object> validate(Map<String, Object> input) {

        List<String> errors = new ArrayList<>();

        for (Rule rule : rules) {
            String error = rule.validate(input);

            if (error != null) {
                errors.add(error);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("valid", errors.isEmpty());
        result.put("errors", errors);

        return result;
    }
}

interface Rule {
    String validate(Map<String, Object> input);
}

class EmailRuleBuilder {

    private final FormValidator validator;
    private final String fieldName;

    public EmailRuleBuilder(FormValidator validator, String fieldName) {
        this.validator = validator;
        this.fieldName = fieldName;
    }

    public FormValidator required() {
       // validator.addRule(new RequiredRule(fieldName));
       // validator.addRule(new EmailRule(fieldName));
        return validator;
    }
}

class AgeRuleBuilder {

    private final FormValidator validator;
    private final String fieldName;

    public AgeRuleBuilder(FormValidator validator, String fieldName) {
        this.validator = validator;
        this.fieldName = fieldName;
    }

    public FormValidator min(int minAge) {
        validator.addRule(new MinAgeRule(fieldName, minAge));
        return validator;
    }
}

class RequiredRule implements Rule {

    private final String fieldName;

    public RequiredRule(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String validate(Map<String, Object> input) {

        Object value = input.get(fieldName);

        if (value == null) {
            return fieldName + " is required";
        }

        if (value instanceof String && ((String) value).trim().isEmpty()) {
            return fieldName + " is required";
        }

        return null;
    }
}

class EmailRule implements Rule {

    private final String fieldName;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public EmailRule(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String validate(Map<String, Object> input) {

        Object value = input.get(fieldName);

        if (value == null) {
            return null;
        }

        String email = String.valueOf(value).trim();

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return fieldName + " is invalid";
        }

        return null;
    }
}

class MinAgeRule implements Rule {

    private final String fieldName;
    private final int minAge;

    public MinAgeRule(String fieldName, int minAge) {
        this.fieldName = fieldName;
        this.minAge = minAge;
    }

    @Override
    public String validate(Map<String, Object> input) {

        Object value = input.get(fieldName);

        if (value == null) {
            return fieldName + " is required";
        }

        Integer age = convertToInteger(value);

        if (age == null) {
            return fieldName + " must be a valid number";
        }

        if (age < minAge) {
            return fieldName + " must be at least " + minAge;
        }

        return null;
    }

    private Integer convertToInteger(Object value) {

        if (value instanceof Integer) {
            return (Integer) value;
        }

        if (value instanceof String) {
            try {
                return Integer.parseInt(((String) value).trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return null;
    }
}