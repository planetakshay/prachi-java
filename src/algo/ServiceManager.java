package algo;

import com.sun.jdi.InvocationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceManager {

    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();
        Map<String, Object> parameters = new HashMap<>();

        // No invocation.
        parameters.put("param1", new Object());
        parameters.put("param2", new Object());
        List<String> result = serviceManager.invokeServiceEndpoints(parameters);
        serviceManager.printResult(result);

        // Exactly one endpoint is invoked
        parameters.remove("param2");
        result = serviceManager.invokeServiceEndpoints(parameters);
        serviceManager.printResult(result);

        // All endpoints invoked
        parameters.remove("param1");
        result = serviceManager.invokeServiceEndpoints(parameters);
        serviceManager.printResult(result);

        // Concurrent invocation of the service manager.
        System.out.println("Service Manager multiple invocations.");
        CompletableFuture<List<String>> serviceManagerTask1, serviceManagerTask2, serviceManagerTask3, serviceManagerTask4;
        serviceManagerTask1 = CompletableFuture.supplyAsync(() -> {
            return serviceManager.invokeServiceEndpoints(parameters);
        });

        serviceManagerTask2 = CompletableFuture.supplyAsync(() -> {
            return serviceManager.invokeServiceEndpoints(parameters);
        });

        serviceManagerTask3 = CompletableFuture.supplyAsync(() -> {
            return serviceManager.invokeServiceEndpoints(parameters);
        });

        serviceManagerTask4 = CompletableFuture.supplyAsync(() -> {
            return serviceManager.invokeServiceEndpoints(parameters);
        });

        CompletableFuture<Void> combinedResults
                = CompletableFuture.allOf(serviceManagerTask1, serviceManagerTask2, serviceManagerTask3, serviceManagerTask4);
        try {
            combinedResults.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        List<List<String>> combinedList = Stream.of(serviceManagerTask1, serviceManagerTask2, serviceManagerTask3, serviceManagerTask4)
                .map(CompletableFuture::join).collect(Collectors.toList());
        List<String> flatList = combinedList.stream().flatMap(List::stream).collect(Collectors.toList());
        serviceManager.printResult(flatList);
    }

    public List<String> invokeServiceEndpoints(Map<String, Object> parameters) {

        ServiceEndpoint1 se1 = new ServiceEndpoint1();
        ServiceEndpoint2 se2 = new ServiceEndpoint2();
        CompletableFuture<List<String>> task1, task2;
        try {
            if (parameters == null || parameters.isEmpty()) {
                // Call all service endpoints concurrently. Also use Future as
                // need to return the output after all service endpoint execution
                // is concluded.
                task1 = CompletableFuture.supplyAsync(() -> {
                    try {
                        return se1.invoke(parameters);
                    } catch (InvocationException e) {
                        throw new RuntimeException(e);
                    }
                });
                task2 = CompletableFuture.supplyAsync(() -> {
                    try {
                        return se2.invoke(parameters);
                    } catch (InvocationException e) {
                        throw new RuntimeException(e);
                    }
                });
                CompletableFuture<Void> combinedFuture
                        = CompletableFuture.allOf(task1, task2);
                combinedFuture.get();
                List<List<String>> combinedList = Stream.of(task1, task2)
                        .map(CompletableFuture::join).collect(Collectors.toList());
                List<String> flatList = combinedList.stream().flatMap(List::stream).collect(Collectors.toList());
                return flatList;
            }

            Set<String> params = parameters.keySet();
            if (se1.getSupportedParameters().containsAll(params)) {
                return se1.invoke(parameters);
            } else if (se2.getSupportedParameters().containsAll(params)) {
                return se2.invoke(parameters);
            }
        } catch (InvocationException e) {
            System.out.println("Exception occured during invocation of train or traveler" + e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void printResult(List<String> result) {
        if (result == null || result.isEmpty()) {
            System.out.println("No results found due to no endpoint was invoked.");
        } else {
            String str = result.stream().collect(Collectors.joining(",\n "));
            System.out.println(str);
        }
    }
}
