import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;

public final class bbh
  extends bbd
{
  private static final String a = cvl.a;
  
  public bbh(Context paramContext, Intent paramIntent)
  {
    super(paramContext, paramIntent);
    b = paramContext;
  }
  
  public bbh(Context paramContext, Class<?> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public final void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Attachment localAttachment = Attachment.a(b, paramLong2);
    if ((localAttachment == null) || (v != 2))
    {
      parambfb.a(-1L, paramLong2, 17, 0);
      return;
    }
    if (bhn.a(b, localAttachment))
    {
      if ((w == 1) && (TextUtils.isEmpty(p))) {}
      try
      {
        Object localObject = Uri.parse(localAttachment.d());
        localObject = b.getContentResolver().openInputStream((Uri)localObject);
        bgt.a(b, (InputStream)localObject, localAttachment);
        parambfb.a(o, paramLong2, 0, 100);
        return;
      }
      catch (IOException localIOException)
      {
        cvm.e(a, localIOException, "failed to save attachment to storage", new Object[0]);
        parambfb.a(o, paramLong2, 2, 0);
        return;
      }
    }
    paramLong1 = Mailbox.a(b, u, 0);
    if (paramLong1 == -1L)
    {
      parambfb.a(-1L, paramLong2, 20, 0);
      return;
    }
    beb localbeb = beb.a(b, o);
    if (localbeb == null)
    {
      parambfb.a(o, paramLong2, 16, 0);
      return;
    }
    r = 5;
    localbeb.h(b);
    parambfb.a(o, paramLong2, 1, 0);
    bam.c(b, paramLong1);
  }
}

/* Location:
 * Qualified Name:     bbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */