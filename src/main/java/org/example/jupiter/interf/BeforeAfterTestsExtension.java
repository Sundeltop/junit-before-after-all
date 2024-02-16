package org.example.jupiter.interf;

public class BeforeAfterTestsExtension implements SuiteExtension {

    @Override
    public void beforeAllTests() {
        System.out.println("BEFORE");
    }

    @Override
    public void afterAllTests() {
        System.out.println("AFTER");
    }
}
