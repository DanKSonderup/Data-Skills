package model;

import java.util.ArrayList;

public class Method {
    private String name;
    private ArrayList<Object> parameters = new ArrayList<>();
    private Object returnType;

    public Method(String name, Object returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Object> getParameters() {
        return parameters;
    }

    public Object getReturnType() {
        return returnType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addParameter(Object parameter) {
        this.parameters.add(parameter);
    }

    public void setReturnType(Object returnType) {
        this.returnType = returnType;
    }
}
