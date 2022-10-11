package java11_pruebas.pruebas.patron_publisher_subscribe;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class VideoApplication {
	public static void main(String[] args) throws InterruptedException {
		VideoStreamServer streamServer = new VideoStreamServer();
		VideoPlayer videoPlayer = new VideoPlayer();
		streamServer.subscribe(videoPlayer);
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		AtomicLong frameNumber = new AtomicLong();
		executor.scheduleWithFixedDelay(() -> {
		    streamServer.offer(new VideoFrame(frameNumber.getAndIncrement()), (subscriber, videoFrame) -> {
		        subscriber.onError(new RuntimeException("Frame#" + videoFrame.getNumber()
		        + " se cayo"));
		        return true;
		    });
		}, 0, 1, TimeUnit.MILLISECONDS);
		Thread.sleep(1000);
	}
}
