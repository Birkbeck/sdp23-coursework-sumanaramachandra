package sml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sml.instruction.*;

@Configuration
public class InstructionConfig {

    @Bean(name = "add")
    @Scope("prototype")
    public AddInstruction add(String label, RegisterName result, RegisterName source){
        return new AddInstruction(label, result, source);
    }

    @Bean(name = "sub")
    @Scope("prototype")
    public SubInstruction sub(String label, RegisterName result, RegisterName source){
        return new SubInstruction(label, result, source);
    }

    @Bean(name = "mul")
    @Scope("prototype")
    public MulInstruction mul(String label, RegisterName result, RegisterName source){
        return new MulInstruction(label, result, source);
    }

    @Bean(name = "div")
    @Scope("prototype")
    public DivInstruction div(String label, RegisterName result, RegisterName source){
        return new DivInstruction(label, result, source);
    }
    @Bean(name = "mov")
    @Scope("prototype")
    public MovInstruction mov(String label, RegisterName result, int value){
        return new MovInstruction(label, result, value);
    }

    @Bean(name = "out")
    @Scope("prototype")
    public OutInstruction out(String label, RegisterName result){
        return new OutInstruction(label, result);
    }

    @Bean(name = "jnz")
    @Scope("prototype")
    public JnzInstruction jnz(String label, RegisterName result, String jmpLabel){
        return new JnzInstruction(label, result, jmpLabel);
    }
}
