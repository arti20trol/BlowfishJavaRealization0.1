package blowfish.options;
import blowfish.AdditionKeys;

public class SecretKey implements AdditionKeys {
    private final String KeyStr;
    private final char[] keyInChar;

    public SecretKey(String key) {
        KeyStr = key;
        keyInChar = key.toCharArray();
    }

    public String getKeyStr() {
        return KeyStr;
    }



    /*    public long[] stringToArray(String line) {
        long[] result = new long[72];
        if (line.length() >= 72){
            for (int i = 0; i < 72; i++) {
                result[i] = line.charAt(i);
            }
        }else {
            for (int i = 0; i < line.length(); i++) {
                result[i] = line.charAt(i);
            }
        }
        return result;
    }

    public String arrayToString(long[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
        }
        return sb.toString();
    }*/

    @Override
    public char[] keyToCharArray() {
        return keyInChar;
    }
}
