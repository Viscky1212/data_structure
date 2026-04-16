package two_pointer_problem;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {

        // Remove leading and trailing spaces
        version1 = version1.trim();
        version2 = version2.trim();

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int max = Math.max(v1.length, v2.length);

        for (int i = 0; i < max; i++) {

            int num1 = (i < v1.length) ? Integer.parseInt(v1[i].trim()) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i].trim()) : 0;

            if (num1 > num2)
                return 1;

            if (num1 < num2)
                return -1;
        }

        return 0;
    }

    public static void main(String[] args) {

        CompareVersion obj = new CompareVersion();

        String version1 = " 1.2";
        String version2 = "1.10";

        int result = obj.compareVersion(version1, version2);

        System.out.println("Result = " + result);
    }
}