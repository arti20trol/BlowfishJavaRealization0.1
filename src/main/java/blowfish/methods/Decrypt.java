package blowfish.methods;
import blowfish.options.SPbox;

public class Decrypt {

    /**
     * Расшифровывание 64-битного блока ЗТ
     * Сеть Фейстеля
     * @param sp            Таблицы замен (предварительно расширенные)
     * @param dataLeft_32   32-bit левая часть ЗТ
     * @param dataRight_32  32-bit правая часть ЗТ
     * @return              блок расшифрованного текста
     */
    public static long[] functionDec(long dataLeft_32, long dataRight_32, SPbox sp) {
        long[] result = new long[2];
        long left = dataLeft_32;
        long right = dataRight_32;

        for (int i = 17; i > 1; i--) {
            left = left ^ sp.getChangedPArray()[i];
            right = FunctionF.F(left, sp) ^ right;
            left = left + right;
            right = left - right;
            left = left - right;
        }
        left = left + right;
        right = left - right;
        left = left - right;
        right = right ^ sp.getChangedPArray()[1];
        left = left ^ sp.getChangedPArray()[0];

        result[0] = left;
        result[1] = right;
        return result;
    }
}
