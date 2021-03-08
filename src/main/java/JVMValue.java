public class JVMValue {

    private final JVMType type;
    private final long byteValue;

    public JVMValue(JVMType type, long byteValue) {
        this.type = type;
        this.byteValue = byteValue;
    }

    public static JVMValue doubleEntry(double d) {
        return new JVMValue(JVMType.DOUBLE, Double.doubleToLongBits(d));
    }

    public static JVMValue integerEntry(int n) {
        return new JVMValue(JVMType.INTEGER, n);
    }

    public static JVMValue addressEntry(long address) {
        return new JVMValue(JVMType.ADDRESS, address);
    }

    public JVMValue copy() {
        return new JVMValue(type, byteValue);
    }

    public JVMType getType() {
        return type;
    }

    public long getByteValue() {
        return byteValue;
    }
}
