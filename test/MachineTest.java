import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Machine;
import sml.Registers;
import sml.Translator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

public class MachineTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream pOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
        //...
    }

    @AfterEach
    void tearDown() {
        System.setOut(pOut);
    }

    @Test
    void executeValidLabel() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sample1");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        System.out.println(m.getLabels());
        Assertions.assertEquals("[h1 -> 2]", out.toString().trim());
    }

    @Test
    void executeValidIns() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sample1");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = 0, EBX = 1, ECX = 0, EDX = 0, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }
    @Test
    void executeMovCheck() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sampleMov");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = 100, EBX = 200, ECX = 300, EDX = 600, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }
    @Test
    void executeAddCheck() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sampleAdd");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = 210, EBX = 200, ECX = 0, EDX = 0, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }

    @Test
    void executeSubCheck() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sampleSub");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = -190, EBX = 200, ECX = 0, EDX = 0, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }

    @Test
    void executeMulCheck() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sampleMul");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = 2000, EBX = 200, ECX = 0, EDX = 0, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }

    @Test
    void executeDivCheck() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Translator t = new Translator("./test/resource/sampleDiv");
        Machine m = new Machine(new Registers());
        t.readAndTranslate(m.getLabels(), m.getProgram());
        m.execute();
        System.out.println(m.getRegisters());
        Assertions.assertEquals("[EAX = 10, EBX = 20, ECX = 0, EDX = 0, ESP = 0, EBP = 0, ESI = 0, EDI = 0]", out.toString().trim());
    }
}

