package gui;

import org.mdkt.compiler.InMemoryJavaCompiler;

import java.util.Map;

public class MethodTester {
    private String code;
    private String className;

    public MethodTester(String code, String className) {
        this.code = code;
        this.className = className;
    }

    public String runMethodAndReturnResult() {
        String result = "";
        try {
            Map<String, Class<?>> compiled = InMemoryJavaCompiler.newInstance().addSource(className, code).compileAll();

            System.out.println(compiled.get("A"));
            Class<?> aClass = compiled.get("A");
            Object a = aClass.newInstance();
            result = aClass.getMethod("b").invoke(a).toString();
        } catch (Exception e) {

        }
        return result;
    }
}
