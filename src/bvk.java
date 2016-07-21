import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;

public final class bvk
{
  public static final String i = cvl.a;
  public static bvm j = new bvm();
  public String a;
  public Message b;
  public Attachment c;
  public final bvn d;
  public final bvr e;
  public final Context f;
  public final Handler g;
  public FragmentManager h;
  
  public bvk(Context paramContext, bvr parambvr)
  {
    d = new bvn(paramContext);
    e = parambvr;
    f = paramContext;
    g = new Handler();
  }
  
  public static void a(bvm parambvm)
  {
    j = parambvm;
  }
  
  public final void a()
  {
    if (j == null) {
      return;
    }
    j.a(a, b, c, h);
  }
  
  public final void a(int paramInt)
  {
    if (e == null) {
      return;
    }
    if ((c.b()) && ((paramInt == 0) || (c.g == paramInt)))
    {
      e.a();
      return;
    }
    FragmentTransaction localFragmentTransaction = h.beginTransaction();
    Object localObject = h.findFragmentByTag("attachment-progress");
    if (localObject != null) {
      localFragmentTransaction.remove((Fragment)localObject);
    }
    localFragmentTransaction.addToBackStack(null);
    localObject = c;
    bvq localbvq = new bvq();
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("attachment", (Parcelable)localObject);
    localbvq.setArguments(localBundle);
    try
    {
      localbvq.show(localFragmentTransaction, "attachment-progress");
      b(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        cvm.d(i, localIllegalStateException, "AttachmentActionHandler cannot show progress dialog", new Object[0]);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Attachment localAttachment = c;
    cvm.b(cvm.a, "startDownloadingAttachment %s %d %d %d %b", new Object[] { localAttachment, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    ContentValues localContentValues = new ContentValues(5);
    localContentValues.put("state", Integer.valueOf(2));
    localContentValues.put("destination", Integer.valueOf(paramInt1));
    localContentValues.put("rendition", Integer.valueOf(paramInt2));
    localContentValues.put("additionalPriority", Integer.valueOf(paramInt3));
    localContentValues.put("delayDownload", Boolean.valueOf(paramBoolean));
    d.a(e, localContentValues);
  }
  
  public final String b()
  {
    if (c.c())
    {
      b(1);
      return "save";
    }
    Attachment localAttachment = c;
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("state", Integer.valueOf(4));
    localContentValues.put("destination", Integer.valueOf(g));
    d.a(e, localContentValues);
    return "redownload";
  }
  
  public final void b(int paramInt)
  {
    a(paramInt, 1, 0, false);
  }
}

/* Location:
 * Qualified Name:     bvk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */