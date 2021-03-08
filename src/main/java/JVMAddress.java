/*
    Addresses are provided as Cities from the republic if Georgia.
 */

public enum JVMAddress {
    TBILISI((byte) 1),
    SOKHUMI((byte) 2),
    BICHVINTA((byte) 3),
    GORI((byte) 4);

    private byte address;

    JVMAddress(byte address) {
        this.address = address;
    }

    public byte getAddress() {
        return address;
    }
}
