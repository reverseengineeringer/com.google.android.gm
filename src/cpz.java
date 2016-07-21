import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import com.android.mail.providers.Folder;

public abstract class cpz
  extends cob
{
  protected final void a(Context paramContext, Cursor paramCursor)
  {
    if (!e.d(8192))
    {
      cqa localcqa = new cqa(paramContext, paramCursor, bue.ai, e);
      if (localcqa.getCount() > 0) {
        a.a(localcqa);
      }
    }
    paramContext = new cri(paramContext, cjx.a(paramCursor), bue.ai, e);
    if (paramContext.getCount() > 0) {
      a.a(paramContext);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
}

/* Location:
 * Qualified Name:     cpz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */