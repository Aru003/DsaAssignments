import java.math.BigInteger;

public class BaseConverter {
    private static String map = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static String convertBase10ToBase62(BigInteger decimalValue) {
        StringBuilder base62Value = new StringBuilder("");

        while (BigInteger.valueOf(0).compareTo(decimalValue) < 0) {
            base62Value.append(map.charAt(decimalValue.mod(BigInteger.valueOf(62)).intValue()));
            decimalValue = decimalValue.divide(BigInteger.valueOf(62));
        }

        return base62Value.reverse().toString();
    }

    static BigInteger convertBase62ToBase10(String url) {
        int power = 0;
        BigInteger decimalValue = new BigInteger("0");

        for (int i = url.length() - 1; i >= 0; i--) {
            BigInteger mapValue = BigInteger.valueOf((long) map.indexOf(url.charAt(i)));
            decimalValue = decimalValue.add(mapValue.multiply(BigInteger.valueOf(62).pow(power++)));
        }
        return decimalValue;

    }

    public static void main(String[] args) {

        String url = "LpuPe81bc2w";

        //convert base62 to Base10
        BigInteger decimalValue = new BigInteger(String.valueOf(convertBase62ToBase10(url)));
        System.out.println(decimalValue.toString());

        //convert back from base10 to Base62
        System.out.println(convertBase10ToBase62(decimalValue));

    }
}
