package model;

import controller.CodeGeneratorController;
import org.mdkt.compiler.InMemoryJavaCompiler;

import java.util.Map;

public class MethodTester {
    private int number;
    private String code;
    private String className;
    private String methodName;

    public MethodTester(int number,String code, String className, String methodName) {
        this.number = number;
        this.code = code;
        this.className = className;
        this.methodName = methodName;
    }

    public void runTe

    public String runMethodAndReturnResult() {
        String finalCode = CodeGeneratorController.generateCodeFile(code);
        String result = "";
        try {
            Map<String, Class<?>> compiled = InMemoryJavaCompiler.newInstance().addSource(className, code).compileAll();


            Class<?> aClass = compiled.get(className);
            Object a = aClass.getDeclaredConstructor().newInstance();
            // result = aClass.getMethod("power").invoke(a).toString();
            Class[] methodArgs = new Class[2];
            methodArgs[0] = int.class;
            methodArgs[1] = int.class;
            result = aClass.getMethod("power",methodArgs).invoke(a,3,8).toString();
        } catch (Exception e) {
            return e.toString();
        }
        return result;
    }
}
