import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

public final class dnw
  extends AsyncTask<Void, Void, Void>
{
  final Context a;
  final String b;
  final List<String> c;
  final List<String> d;
  final int e;
  
  public dnw(Context paramContext, String paramString, List<String> paramList1, List<String> paramList2, int paramInt)
  {
    a = paramContext;
    b = paramString;
    c = new ArrayList(paramList1);
    d = new ArrayList(paramList2);
    e = paramInt;
  }
}

/* Location:
 * Qualified Name:     dnw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */