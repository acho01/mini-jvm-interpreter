public enum JVMCommand {

    INTEGER_LOAD(0x15, 1),
    INTEGER_STORE(0x36, 1),
    INTEGER_INCREMENT(0x84, 2),
    INTEGER_ADD(0x60),
    INTEGER_MULTIPLY(0x68),
    INTEGER_CONST_NEGATIVE_1(0x02),
    INTEGER_CONST_1(0x04),
    INTEGER_CONST_2(0x05),
    INTEGER_CONST_3(0x06),
    INTEGER_CONST_4(0x07),
    INTEGER_CONST_5(0x08),
    INTEGER_RETURN(0xac),
    RETURN(0xb1);


    private final int commandCode;
    private final int numParams;

    private JVMCommand(int commandCode) {
        this(commandCode, 0);
    }

    private JVMCommand(int commandCode, int numParams) {
        this.commandCode = commandCode;
        this.numParams = numParams;
    }

    public int getCommandCode() {
        return commandCode;
    }

    public int getNumParams() {
        return numParams;
    }

    public byte getByte() {
        return (byte) commandCode;
    }

}
