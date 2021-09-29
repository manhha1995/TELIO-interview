import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class test {
  // public static void main(String[] args) {
  // Duck duck = new MallardDuck();
  // duck.performFly();
  // duck.performQuack();
  // }
  // }
  // public class ConcatTest {
  public static String concatWithString() {
    String t = "Java";
    for (int i = 0; i < 10000; i++) {
      t = t + "Hello";
    }
    return t;
  }

  public static String concatWithStringBuffer() {
    StringBuffer sb = new StringBuffer("Java");
    for (int i = 0; i < 10000; i++) {
      sb.append("Hello");
    }
    return sb.toString();
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    long startTime = System.currentTimeMillis();
    concatWithString();
    System.out.println("Thời gian nối chuỗi của lớp String: " + (System.currentTimeMillis() - startTime) + "ms");
    startTime = System.currentTimeMillis();
    concatWithStringBuffer();
    System.out.println("Thời gian nối chuỗi của lớp StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
    System.out.println("Run a task specified by a Runnable Object asynchronously.");

    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("It is runnig in a separate thread than the main thread.");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Completed";
    });

    System.out.println("It is also running... ");
    // Block and wait for the future to complete
    System.out.println("Result: " + future.get());
    System.out.println("Done!!!");

    // A list of 100 web page links
    List<String> webPageLinks = Arrays.asList( //
        "https://www.google.com.vn/", "https://vnexpress.net/", "https://gpcoder.com/");

    // Download contents of all the web pages asynchronously
    List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
        .map(webPageLink -> downloadWebPage(webPageLink)).collect(Collectors.toList());

    // Create a combined Future using allOf()
    CompletableFuture<Void> allFutures = CompletableFuture
        .allOf(pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()]));

    // When all the Futures are completed, call `future.join()` to get their results
    // and collect the results in a list
    CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
      return pageContentFutures.stream().map(pageContentFuture -> pageContentFuture.join())
          .collect(Collectors.toList());
    });

    // Count the number of web pages having the "CompletableFuture" keyword.
    CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
      return pageContents.stream().filter(pageContent -> pageContent.contains("CompletableFuture")).count();
    });

    System.out.println("Number of Web Pages having CompletableFuture keyword: " + countFuture.get());
  }

  public static CompletableFuture<String> downloadWebPage(String pageLink) {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("Downloading: " + pageLink);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // Code to download and return the web page's content
      return "CompletableFuture Completed";
    });
  }

  AtomicBoolean canceled = new AtomicBoolean(true); // set a flag to cancel a completablefuture
  CompletableFuture<Integer> cancelFuture = CompletableFuture.supplyAsync(() -> {
    while (true) {
      if(canceled.get()) { 
      }
    }
});
}
