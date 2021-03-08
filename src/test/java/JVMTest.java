import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class JVMTest {

    private static JVMInterpreter im;

    @BeforeClass
    public static void setup() {
        im = new JVMInterpreter();
    }

    @Test
    public void test_integer_arithmetic() {

        byte[] buffer1 = {JVMCommand.INTEGER_CONST_1.getByte(),
                          JVMCommand.INTEGER_CONST_1.getByte(),
                          JVMCommand.INTEGER_ADD.getByte(),
                          JVMCommand.INTEGER_RETURN.getByte()};
        JVMValue res = im.execMethod(buffer1, new JVMLocalVars());
        assertEquals("Return type should be int", JVMType.INTEGER, res.getType());
        assertEquals("Return value should be 2", 2, (int) res.getByteValue());


        byte[] buffer2 = {JVMCommand.INTEGER_CONST_1.getByte(),
                           JVMCommand.INTEGER_CONST_NEGATIVE_1.getByte(),
                           JVMCommand.INTEGER_ADD.getByte(),
                           JVMCommand.INTEGER_RETURN.getByte()};
        res = im.execMethod(buffer2, new JVMLocalVars());
        assertEquals("Return type should be int", JVMType.INTEGER, res.getType());
        assertEquals("Return value should be 0", 0, (int) res.getByteValue());


        byte[] buffer3 = {JVMCommand.INTEGER_CONST_2.getByte(),
                          JVMCommand.INTEGER_CONST_NEGATIVE_1.getByte(),
                          JVMCommand.INTEGER_MULTIPLY.getByte(),
                          JVMCommand.INTEGER_RETURN.getByte()};
        res = im.execMethod(buffer3, new JVMLocalVars());
        assertEquals("Return type should be int", JVMType.INTEGER, res.getType());
        assertEquals("Return value should be -2", -2, (int) res.getByteValue());
    }

    @Test
    public void test_local_variables() {
        byte[] buffer = {JVMCommand.INTEGER_CONST_5.getByte(),
                         JVMCommand.INTEGER_STORE.getByte(), JVMAddress.SOKHUMI.getAddress(),
                         JVMCommand.INTEGER_INCREMENT.getByte(), JVMAddress.SOKHUMI.getAddress(), (byte) 2,
                         JVMCommand.INTEGER_LOAD.getByte(), JVMAddress.SOKHUMI.getAddress(),
                         JVMCommand.INTEGER_RETURN.getByte()
        };
        JVMValue res = im.execMethod(buffer, new JVMLocalVars());

        assertEquals("Return type should be int", JVMType.INTEGER, res.getType());
        assertEquals("Return value should be 7", 7, (int) res.getByteValue());
    }


}
