package model;

public class CodingTest {
    private int number;
    private Object expectedReturn;
    private String errorMessage;


    public CodingTest(int number, Object expectedReturn) {
        this.number = number;
        this.expectedReturn = expectedReturn;
    }

    public int getNumber() {
        return number;
    }

    public Object getExpectedReturn() {
        return expectedReturn;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void runTest() {

    }
}
