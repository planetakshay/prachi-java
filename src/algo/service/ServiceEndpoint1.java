package algo.service;

import com.sun.jdi.InvocationException;
import java.util.*;
import java.util.concurrent.Semaphore;

public class ServiceEndpoint1 implements ServiceEndpoint<String> {

    public static final int MAX_CONCURRENT_INVOCATION = 10;
    // Using counting semaphore to ensure maxConcurrentInvocation is
    //honored for this endpoint.
    static Semaphore semaphore = new Semaphore(MAX_CONCURRENT_INVOCATION);

    @Override
    public int getMaxConcurrentInvocations() {
        return MAX_CONCURRENT_INVOCATION;
    }

    @Override
    public Set<String> getSupportedParameters() {
        Set<String> supportedParams = new HashSet<>();
        supportedParams.add("param1");
        return supportedParams;
    }

    @Override
    public List<String> invoke(Map<String, Object> parameters) throws InvocationException {
        try {
            semaphore.acquire();
            System.out.println("Available permits: " + semaphore.availablePermits());
            List<String> result = new LinkedList<>();
            result.add("called from se1");
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}