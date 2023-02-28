package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * Represents an instruction factory class.
 * InstructionFactory class takes up the responsibility of creating and configuring objects of required type.
 * Returns newly created object.
 * @author Sumana Ramachandra
 */

public class InstructionFactory {

    public Instruction makeInstruction(String opcode, String label, ArrayList<String> scanArgs) {
        Instruction ins;
        String sub = opcode.substring(0,1).toUpperCase() + opcode.substring(1);
        Class<?> insClass;

        try {
            insClass = Class.forName("sml.instruction." + sub + "Instruction");
            Constructor<?>[] constructors = insClass.getConstructors();
            Parameter[] p = constructors[0].getParameters();
            Object[] cons = findParams(p, scanArgs);
            cons[0] = label;
            ins = (Instruction) constructors[0].newInstance(cons);
            return ins;
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] findParams(Parameter[] p, ArrayList<String> scanArgs) {
        Object[] arg = new Object[p.length];
        for(int i = 0;i < p.length; i++) {
            String s = scanArgs.get(i);
            if (p[i].getType().toString().equals("int")) {
               arg[i] = Integer.parseInt(s);
            } else if (p[i].getType().toString().equals("interface sml.RegisterName")) {
                arg[i] = Registers.Register.valueOf(s);
            } else {
                arg[i] = s;

            }
        }
        return arg;
    }
}
