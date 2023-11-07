package model;

import java.util.ArrayList;

public class CodingExercise {
    private String titel;
    private String taskDescription;
    private String baseCode;
    private final ArrayList<Method> methods = new ArrayList<>();

    public CodingExercise(String titel, String taskDescription, String baseCode) {
        this.titel = titel;
        this.taskDescription = taskDescription;
        this.baseCode = baseCode;
    }

    public String getTitel() {
        return titel;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void addMethod(Method method) {
        methods.add(method);
    }
}
