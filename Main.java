package com.nis.wsdltojava;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import javax.lang.model.element.Modifier;
import static org.joox.JOOX.$;
import org.joox.Match;

public class Main {

    public static void main(String[] args) throws Exception {
        Match append = $(Main.class.getResourceAsStream("/test.wsdl"))
                .xpath("//*[local-name()='operation']");

        System.out.println(append.toString());

        
        TypeSpec helloWorld = TypeSpec.interfaceBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(MethodSpec.methodBuilder("beep")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .returns(ClassName.bestGuess("de.nis.MyCoolObject"))
                        .build())
                .build();
        
        
        System.out.println(helloWorld);
    }

}
