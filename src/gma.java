import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class gma
  implements ScheduledExecutorService
{
  final gmd a;
  private final ScheduledExecutorService b;
  
  gma(ScheduledExecutorService paramScheduledExecutorService, gmd paramgmd)
  {
    b = ((ScheduledExecutorService)gol.a(paramScheduledExecutorService));
    a = ((gmd)gol.a(paramgmd));
  }
  
  private final Runnable a(Runnable paramRunnable)
  {
    return new gmb(this, paramRunnable);
  }
  
  private final <V> List<? extends Callable<V>> a(Collection<? extends Callable<V>> paramCollection)
  {
    LinkedList localLinkedList = new LinkedList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedList.add(a((Callable)paramCollection.next()));
    }
    return localLinkedList;
  }
  
  private final <V> Callable<V> a(Callable<V> paramCallable)
  {
    return new gmc(this, paramCallable);
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return b.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    b.execute(a(paramRunnable));
  }
  
  public final <V> List<Future<V>> invokeAll(Collection<? extends Callable<V>> paramCollection)
  {
    return b.invokeAll(a(paramCollection));
  }
  
  public final <V> List<Future<V>> invokeAll(Collection<? extends Callable<V>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return b.invokeAll(a(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final <V> V invokeAny(Collection<? extends Callable<V>> paramCollection)
  {
    return (V)b.invokeAny(a(paramCollection));
  }
  
  public final <V> V invokeAny(Collection<? extends Callable<V>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return (V)b.invokeAny(a(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final boolean isShutdown()
  {
    return b.isShutdown();
  }
  
  public final boolean isTerminated()
  {
    return b.isTerminated();
  }
  
  public final ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return b.schedule(a(paramRunnable), paramLong, paramTimeUnit);
  }
  
  public final <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return b.schedule(a(paramCallable), paramLong, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return b.scheduleAtFixedRate(a(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return b.scheduleWithFixedDelay(a(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
  
  public final void shutdown()
  {
    b.shutdown();
  }
  
  public final List<Runnable> shutdownNow()
  {
    return b.shutdownNow();
  }
  
  public final Future<?> submit(Runnable paramRunnable)
  {
    return b.submit(a(paramRunnable));
  }
  
  public final <V> Future<V> submit(Runnable paramRunnable, V paramV)
  {
    return b.submit(a(paramRunnable), paramV);
  }
  
  public final <V> Future<V> submit(Callable<V> paramCallable)
  {
    return b.submit(a(paramCallable));
  }
}

/* Location:
 * Qualified Name:     gma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */