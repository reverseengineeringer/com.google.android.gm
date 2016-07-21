import com.android.mail.providers.Folder;
import java.util.concurrent.atomic.AtomicInteger;

final class cps
  implements Comparable<cps>
{
  private static final AtomicInteger b = new AtomicInteger();
  final Folder a;
  private final int c;
  
  cps(Folder paramFolder)
  {
    a = paramFolder;
    c = b.getAndIncrement();
  }
}

/* Location:
 * Qualified Name:     cps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */