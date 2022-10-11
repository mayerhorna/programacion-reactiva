package java11_pruebas.pruebas.asincrono.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsTest {

	public static void main(String[] args) {
	}

}
class ZooInfo {
	public static void main(String[] args) {
		// System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable task1 = () -> {
			System.out.println("task1: " + Thread.currentThread().getName());
			System.out.println("Printing zoo inventory");
		};
		Runnable task2 = () -> {
			System.out.println("task2: " + Thread.currentThread().getName());
			for (int i = 0; i < 3; i++)
				System.out.println("Printing record: " + i);
		};
		try {
			System.out.println("begin");
			service.execute(task1);
			service.execute(task2);
			service.execute(task1);
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}

//Waiting for Results - Future<?>  sin Callable
class CheckResults {
	private static int counter = 0;

	public static void main(String[] unused) throws Exception {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 500; i++)
					CheckResults.counter++;
			});
			result.get(10, TimeUnit.SECONDS);
			System.out.println(CheckResults.counter);
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}

//Con Callable
class AddData {
	public static void main(String[] args) throws Exception {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30 + 11);
			System.out.println(result.get()); // 41
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}

class ZooInfoTasks {
	public static void main(String[] args) {
		// System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable task1 = () -> {
			System.out.println("task1: " + Thread.currentThread().getName());
			System.out.println("Printing zoo inventory");
		};
		Runnable task2 = () -> {
			System.out.println("task2: " + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			for (int i = 0; i < 3; i++)
				System.out.println("Printing record: " + i);
		};
		try {
			System.out.println("begin");
			service.execute(task1);
			service.execute(task2);
			service.execute(task1);
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
			try {
				service.awaitTermination(1, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (service.isTerminated())
				System.out.println("Finished!");
			else
				System.out.println("At least one task is still running");

		}
	}
}

class InvokeAllTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		System.out.println("begin");
		Callable<String> task1 = () -> { 
			System.out.println(Thread.currentThread().getName());
			return "result1"; 
		};
		Callable<String> task2 = () -> { 
			System.out.println(Thread.currentThread().getName());
			return "result2"; 
		};
		Callable<String> task3 = () -> { 
			System.out.println(Thread.currentThread().getName());
			return "result3"; 
		};
		List<Future<String>> list = service.invokeAll(List.of(task1, task2, task3));
		//String result = service.invokeAny(List.of(task1, task2, task3));
		//System.out.println(result);
		for (Future<String> future : list) {
			System.out.println(future.get());
		}
		System.out.println("end");
	}
}


class SechedulerTest {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Hello Zoo");
		Callable<String> task2 = () -> "Monkey";
		ScheduledFuture<?> r1 = service.scheduleAtFixedRate(task1, 0, 3, TimeUnit.SECONDS);
		ScheduledFuture<?> r2 = service.scheduleWithFixedDelay(task1, 0, 3, TimeUnit.SECONDS);
		ScheduledFuture<?> r3 = service.schedule(task2, 8,  TimeUnit.MINUTES);
		
	}
}