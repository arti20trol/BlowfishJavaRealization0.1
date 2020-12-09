package blowfish.methods;
import blowfish.options.SPbox;

public class FunctionF {
    public static long F(long data, SPbox sp) {
        long result;
        long copyData = data;

        long x4 = copyData & 0xFF;
        copyData = copyData >> 8;

        long x3 = copyData & 0xFF;
        copyData = copyData >> 8;

        long x2 = copyData & 0xFF;
        copyData = copyData >> 8;

        long x1 = copyData & 0xFF;

        result = sp.getChangedSBox0()[(int)x1] + sp.getChangedSBox1()[(int)x1];
        result = result ^ sp.getChangedSBox2()[(int)x1];
        result = result + sp.getChangedSBox3()[(int)x1];
        return result;
    }
}
