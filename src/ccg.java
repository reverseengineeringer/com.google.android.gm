import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import com.android.mail.providers.Attachment;
import java.util.List;

public final class ccg
{
  final int a;
  final ContentValues b;
  public final boolean c;
  final Bundle d;
  
  public ccg(Context paramContext, int paramInt, ContentValues paramContentValues, List<Attachment> paramList, Bundle paramBundle, boolean paramBoolean)
  {
    a = paramInt;
    b = paramContentValues;
    c = paramBoolean;
    if (paramBundle != null)
    {
      d = paramBundle;
      return;
    }
    d = cbk.a(paramContext, paramList);
  }
}

/* Location:
 * Qualified Name:     ccg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */