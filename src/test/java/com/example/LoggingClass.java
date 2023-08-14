package com.example;

import ch.qos.logback.classic.joran.JoranConfigurator;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import testbase.TestBase;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class LoggingClass implements AfterEachCallback, BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Class<?> testClass = extensionContext.getTestClass().get();
        Method method = extensionContext.getTestMethod().get();
        String methodName = method.getName();
        String fileName = String.format("%s", methodName);
        MDC.put("testName", fileName);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        MDC.remove("testName");
    }
}
