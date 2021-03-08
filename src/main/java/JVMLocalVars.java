public class JVMLocalVars {

    private final JVMValue[] vars = new JVMValue[100];

    void incrementIntegerBy(byte address, byte amount) {
        JVMValue value = vars[address & 0xff];
        vars[address & 0xff] = JVMValue.integerEntry(amount + (int)value.getByteValue());
    }

    public JVMValue load(byte address) {
        return vars[address].copy();
    }

    public void store(byte address, JVMValue value) {
        vars[address] = value;
    }
}
