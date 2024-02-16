package org.example.jupiter.interf;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public interface SuiteExtension extends BeforeAllCallback {

    @Override
    default void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot()
                .getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrComputeIfAbsent(this.getClass(),
                        k -> {
                            beforeAllTests();
                            return (ExtensionContext.Store.CloseableResource) this::afterAllTests;
                        }
                );

    }

    void beforeAllTests();

    void afterAllTests();
}
