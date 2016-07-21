import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.mail.providers.Conversation;

public final class cfs
  extends cjm
{
  private static final String f = cvl.a;
  final String a = a(bui.i);
  private final String g = a(bui.h);
  private final String h = a(bui.f);
  private final String i = a(bui.g);
  private final String j = a(bui.a);
  
  public cfs(Context paramContext)
  {
    super(paramContext);
  }
  
  public final String a(boolean paramBoolean)
  {
    if (!e) {
      throw new IllegalStateException("must call startConversation first");
    }
    if (paramBoolean) {
      a(h, new Object[] { b.getString(buj.dY) });
    }
    for (;;)
    {
      e = false;
      cvm.b(f, "rendered conversation of %d bytes, buffer capacity=%d", new Object[] { Integer.valueOf(d.length() << 1), Integer.valueOf(d.capacity() << 1) });
      return a();
      a(i, new Object[0]);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (e) {
      throw new IllegalStateException("Should not call startPrintConversation twice");
    }
    c();
    String str = b.getResources().getQuantityString(buh.t, paramInt, new Object[] { Integer.valueOf(paramInt) });
    paramString = TextUtils.htmlEncode(Conversation.a(b, null, paramString));
    a(g, new Object[] { j, b.getString(buj.p), paramString, str });
    e = true;
  }
}

/* Location:
 * Qualified Name:     cfs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */