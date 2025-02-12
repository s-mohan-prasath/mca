public class ps3 {
    public ps3() {

    }

    public void prob1(int num) {
        switch (num) {
            case 1 -> {
                System.out.println("ONE");
            }
            case 2 -> {
                System.out.println("TWO");
            }
            case 3 -> {
                System.out.println("THREE");
            }
            case 4 -> {
                System.out.println("FOUR");
            }
            case 5 -> {
                System.out.println("FIVE");
            }
            case 6 -> {
                System.out.println("SIX");
            }
            case 7 -> {
                System.out.println("SEVEN");
            }
            case 8 -> {
                System.out.println("EIGHT");
            }
            case 9 -> {
                System.out.println("NINE");
            }
            default -> {
                System.out.println("OTHER");
            }
        }
    }

    public void prob2(int num) {
        switch (num) {
            case 0 -> {
                System.out.println("SUNDAY");
            }
            case 1 -> {
                System.out.println("MONDAY");
            }
            case 2 -> {
                System.out.println("TUESDAY");
            }
            case 3 -> {
                System.out.println("WEDNESDAY");
            }
            case 4 -> {
                System.out.println("THURSDAY");
            }
            case 5 -> {
                System.out.println("FRIDAY");
            }
            case 6 -> {
                System.out.println("SATURDAY");
            }
            default -> {
                System.out.println("NOT A VALID DAY");
            }
        }
    }

    public void prob3(String[] args) {
        if (args.length < 3)
            System.out.println("No Input");
        else if (args[0].equals(args[1]) && args[1].equals(args[2]))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }

    public void prob4(String[] args) {
        if (args.length == 0)
            System.out.println("No Input");
        else {
            int windSpeed = Integer.parseInt(args[0]);
            if (windSpeed >= 155)
                System.out.println("Category - 5");
            else if (windSpeed >= 131)
                System.out.println("Category - 4");
            else if (windSpeed >= 111)
                System.out.println("Category - 3");
            else if (windSpeed >= 96)
                System.out.println("Category - 2");
            else if (windSpeed >= 74)
                System.out.println("Category - 1");
        }
    }

    public void prob5(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        int min = arr[0], max = arr[0], sum = 0;
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        double avg = (sum - min - max) / 4.0;
        System.out.println("Average of 4 numbers excluding Max and Min number is " + avg);
    }

    public void prob6(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        int min = arr[0], max = arr[0], sum = 0;
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        double avg = (sum - min - max) / 4.0;
        System.out.println("Average of 4 numbers excluding Max and Min number is " + avg);
    }

    public void prob7(String[] args) {
        if (args.length < 2)
            System.out.println("Insufficient Arguments");
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        StringBuilder output = new StringBuilder();
        int quotient = p / q;
        output.append(quotient);
        output.append(".(");
        int firstRemainder = p % q;
        int remainder = firstRemainder * 10;
        while (remainder != firstRemainder) {
            // remainder =
        }

    }

    public void prob8(String[] args) {
        if (args.length < 2) {
            System.out.println("Insufficient Arguments");
        } else {
            int M = Integer.parseInt(args[0]);
            int D = Integer.parseInt(args[1]);
            String[] seasons = {"Spring", "Summer", "Fall", "Winter"};
            int[] endMonths = {6, 9, 12, 3};
            int[] endDates = {20, 22, 21, 20};
        }
    }

    public void prob9(int M, int D) {
        int[] down = { 22, 20, 18, 20, 20, 21, 21, 23, 23, 23, 23, 22 };
        String[] signs = { "Capricorn", "Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
                "Libra", "Scorpio", "Sagittarius" };
        String sign = (down[(M - 1) % 12] >= D) ? signs[(M - 1) % 12] : signs[(M) % 12];
        System.out.println("Sign is " + sign);
    }

}
