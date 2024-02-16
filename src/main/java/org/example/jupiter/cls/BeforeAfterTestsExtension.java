package org.example.jupiter.cls;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeAfterTestsExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot()
                .getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrComputeIfAbsent(this.getClass(),
                        k -> {
                            beforeAll();
                            return new BeforeAfterTestsCallback();
                        });
    }

    void beforeAll() {
        System.out.println("BEFORE");
    }

    private static class BeforeAfterTestsCallback implements ExtensionContext.Store.CloseableResource {

        @Override
        public void close() {
            System.out.println("AFTER");
        }
    }
}
