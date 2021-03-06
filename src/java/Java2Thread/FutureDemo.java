package Java2Thread;

/***Created by moyongzhuo
 *On 2018/3/22  ***10:50.
 ******/
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @ClassName: FutureDemo
 * @Description: Future
 * @author denny.zhang
 * @date 2016年11月4日 下午1:50:32
 *Future是接口，FutrueTask是接口实现类。场景：多线程并发执行，返回结果放进list.
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //结果集
        List<Integer> list = new ArrayList<Integer>();
        //开启多线程
        ExecutorService exs = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        //启动线程池，固定线程数为3
        for(int i=0;i<3;i++){
            //提交任务，添加返回
            futureList.add(exs.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 1;
                }
            }));
        }
        //结果归集
        for (Future<Integer> future : futureList) {
            while (true) {
                if (future.isDone()&& !future.isCancelled()) {
                    Integer i = future.get();
                    list.add(i);
                    break;
                } else {
                    Thread.sleep(100);
                }
            }
        }
        System.out.println("list="+list);
    }
}