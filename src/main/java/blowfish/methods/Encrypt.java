package blowfish.methods;
import blowfish.options.SPbox;

public class Encrypt {

    /**
     * Шифрование 64-битного блока ОТ
     * Сеть Фейстеля
     * @param sp            Таблицы замен (предварительно расширенные)
     * @param dataLeft_32   32-bit левая часть ОТ
     * @param dataRight_32  32-bit правая часть ОТ
     * @return              блок зашифрованного текста
     */
    public static long[] functionEnc(long dataLeft_32, long dataRight_32, SPbox sp) {
        long[] result = new long[2];
        long left = dataLeft_32;
        long right = dataRight_32;

        for (int i = 0; i < 16; i++) {
            left = left ^ sp.getChangedPArray()[i];
            right = FunctionF.F(left, sp) ^ right;
            left = left + right;
            right = left - right;
            left = left - right;
        }
        left = left + right;
        right = left - right;
        left = left - right;

        right = right ^ sp.getChangedPArray()[16];
        left = left ^ sp.getChangedPArray()[17];
        result[0] = left;
        result[1] = right;
        return result;
    }
}