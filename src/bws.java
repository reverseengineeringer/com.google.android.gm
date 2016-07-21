import android.os.AsyncTask;
import com.android.mail.providers.Conversation;
import java.util.List;

final class bws
  extends AsyncTask<Void, Void, Void>
{
  final int a;
  
  bws(bwr parambwr, int paramInt)
  {
    a = paramInt;
  }
  
  private final Void a()
  {
    try
    {
      cxa.g("backgroundCaching");
      int i = b.getCount();
      for (;;)
      {
        int j = b.b;
        if ((isCancelled()) || (j >= i)) {
          break;
        }
        bwu localbwu = (bwu)b.g.get(j);
        if ((b == null) && (b.moveToPosition(j))) {
          b = new Conversation(b);
        }
        b.b = (j + 1);
      }
    }
    finally
    {
      cxa.a();
    }
    cxa.a();
    return null;
  }
}

/* Location:
 * Qualified Name:     bws
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */