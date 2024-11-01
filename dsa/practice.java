public class practice {
    public practice() {

    }

    public static void main(String[] arg) {
        String str1 = "2[abc]3[cd]ef";
        System.out.println(c_string_ps_recur(1, str1));
    }

    public static String c_string_ps_recur(int times, String str) {
        String local = "";
        int len = str.length();
        int digitStart = -1, digitEnd = -1;
        int stringStart, stringEnd;
        int i = 0;
        while (i < len) {
            if (Character.isDigit(str.charAt(i))) {
                if (digitStart == -1) {
                    digitStart = i;
                    digitEnd = i + 1;
                } else {
                    digitEnd++;
                }
            } else if (Character.compare(str.charAt(i), '[') == 0) {
                i++;
                stringStart = i;
                int openBrace = 1;
                int closeBrace = 0;
                while (openBrace != closeBrace) {
                    if (Character.compare(str.charAt(i), ']') == 0) {
                        closeBrace++;
                    } else if (Character.compare(str.charAt(i), '[') == 0) {
                        openBrace++;
                    }
                    i++;
                }
                i--;
                stringEnd = i;
                int t = Integer.parseInt(str.substring(digitStart, digitEnd));
                String sub = str.substring(stringStart, stringEnd);
                local += c_string_ps_recur(t, sub);
                digitStart = -1;
            } else {
                local += str.substring(i, i + 1);
            }
            i++;
        }
        String output = local;
        for (i = 1; i < times; i++) {
            output += local;
        }
        return output;
    }
}