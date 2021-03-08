import java.util.Stack;

public class JVMStack extends Stack<JVMValue> {

    void addIntegerConstant(int i) {
        push(JVMValue.integerEntry(i));
    }

    void sumIntegers() {
        JVMValue value1 = pop();
        JVMValue value2 = pop();
        int sum = (int) (value1.getByteValue() + value2.getByteValue());
        push(JVMValue.integerEntry(sum));
    }

    void multiplyIntegers() {
        JVMValue value1 = pop();
        JVMValue value2 = pop();
        int sum = (int) (value1.getByteValue() * value2.getByteValue());
        push(JVMValue.integerEntry(sum));
    }
}
