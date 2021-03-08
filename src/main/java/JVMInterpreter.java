import java.util.Arrays;

public class JVMInterpreter {

    private static final JVMCommand[] commandsList = new JVMCommand[256];

    static {
        Arrays.stream(JVMCommand.values())
              .forEach(command -> commandsList[command.getCommandCode()] = command);
    }

    JVMValue execMethod(final byte[] instructions, JVMLocalVars jvmLocalVars) {
        JVMStack jvmStack = new JVMStack();
        int currentIndex = 0;
        while (true) {
            byte instruction = instructions[currentIndex++];
            JVMCommand command = commandsList[instruction & 0xff];

            switch (command) {
                case INTEGER_CONST_1 -> jvmStack.push(JVMValue.integerEntry(1));
                case INTEGER_CONST_2 -> jvmStack.push(JVMValue.integerEntry(2));
                case INTEGER_CONST_5 -> jvmStack.push(JVMValue.integerEntry(5));
                case INTEGER_CONST_NEGATIVE_1 -> jvmStack.push(JVMValue.integerEntry(-1));
                case INTEGER_ADD -> jvmStack.sumIntegers();
                case INTEGER_MULTIPLY -> jvmStack.multiplyIntegers();
                case INTEGER_STORE -> jvmLocalVars.store(instructions[currentIndex++], jvmStack.pop());
                case INTEGER_INCREMENT -> jvmLocalVars.incrementIntegerBy(instructions[currentIndex++], instructions[currentIndex++]);
                case INTEGER_LOAD -> jvmStack.push(jvmLocalVars.load(instructions[currentIndex++]));
                case INTEGER_RETURN -> { return  jvmStack.pop(); }
                default -> {return null; }
            }
        }
    }
}
