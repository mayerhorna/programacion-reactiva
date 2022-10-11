package java11_pruebas.pruebas.patron_publisher_subscribe;

import java.util.concurrent.Flow;

public class VideoPlayer implements Flow.Subscriber<VideoFrame> {
   
    Flow.Subscription subscription = null;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
        System.out.println("onSubscribe ");
    }

    @Override
    public void onNext(VideoFrame item) {
    	System.out.println("play "+ item.getNumber());
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
    	System.out.println("There is an error in video streaming: " + throwable.getMessage());

    }

    @Override
    public void onComplete() {
    	System.out.println("Video has ended");
    }
}