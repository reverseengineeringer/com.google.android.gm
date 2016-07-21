import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ListView;
import com.android.emailcommon.provider.Mailbox;
import com.android.mail.providers.Folder;
import java.util.HashMap;

public class azn
  extends Activity
  implements azp
{
  long a;
  azo b;
  ProgressDialog c;
  private int d;
  private String e;
  private boolean f = true;
  
  private final void a(Uri paramUri, int paramInt)
  {
    boolean bool = true;
    Object localObject = getString(paramInt, new Object[] { e });
    if (!f) {}
    for (;;)
    {
      paramUri = new azq(this, paramUri, this, (String)localObject, bool);
      a.show();
      a.getListView().setOnItemClickListener(new azr(paramUri));
      localObject = a.getButton(-1);
      if (b.size() == 0) {
        ((Button)localObject).setEnabled(false);
      }
      return;
      bool = false;
    }
  }
  
  final void a()
  {
    int i = arh.cA;
    String str = String.valueOf(bdv.F);
    long l = a;
    a(Uri.parse(String.valueOf(str).length() + 45 + "content://" + str + "/uifullfolders/" + l), i);
  }
  
  public final void a(Folder paramFolder)
  {
    long l = Long.parseLong(c.b.getLastPathSegment());
    paramFolder = new ContentValues();
    Object localObject = Mailbox.b(this, a, d);
    if (localObject != null)
    {
      paramFolder.put("type", Integer.valueOf(1));
      getContentResolver().update(ContentUris.withAppendedId(Mailbox.a, D), paramFolder, null, null);
    }
    localObject = Mailbox.a(this, Long.valueOf(l).longValue());
    if (localObject != null)
    {
      paramFolder.put("type", Integer.valueOf(d));
      getContentResolver().update(ContentUris.withAppendedId(Mailbox.a, D), paramFolder, null, null);
      paramFolder.clear();
      localObject = com.android.emailcommon.provider.Account.a(this, a);
      paramFolder.put("flags", Integer.valueOf(j));
      getContentResolver().update(ContentUris.withAppendedId(com.android.emailcommon.provider.Account.a, D), paramFolder, null, null);
    }
    finish();
  }
  
  public final void b()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject = paramBundle.getData();
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getQueryParameter("account");
      if (localObject == null)
      {
        cvm.d("FolderPickerActivity", "No account # in Uri?", new Object[0]);
        finish();
        return;
      }
      for (;;)
      {
        try
        {
          a = Long.parseLong((String)localObject);
          if (!paramBundle.hasExtra("mailbox_type"))
          {
            bool = true;
            f = bool;
            d = paramBundle.getIntExtra("mailbox_type", 6);
            if ((Mailbox.a(this, a, 6) == -1L) || (!f)) {
              break;
            }
            cvm.d("FolderPickerActivity", "Trash folder already exists", new Object[0]);
            finish();
            return;
          }
        }
        catch (NumberFormatException paramBundle)
        {
          cvm.d("FolderPickerActivity", "Invalid account # in Uri?", new Object[0]);
          finish();
          return;
        }
        boolean bool = false;
      }
      paramBundle = com.android.emailcommon.provider.Account.a(this, a);
      if (paramBundle == null)
      {
        cvm.d("FolderPickerActivity", "No account?", new Object[0]);
        finish();
        return;
      }
      e = c;
      if ((j & 0x2000) != 0)
      {
        a();
        return;
      }
      c = new ProgressDialog(this);
      c.setIndeterminate(true);
      c.setMessage(getString(arh.aR));
      c.show();
      b = new azo(this, this, new Handler());
      paramBundle = ContentUris.withAppendedId(com.android.emailcommon.provider.Account.a, a);
      getContentResolver().registerContentObserver(paramBundle, false, b);
      return;
    }
    localObject = (com.android.mail.providers.Account)paramBundle.getParcelableExtra("picker_ui_account");
    e = a;
    a = Long.parseLong(g.getLastPathSegment());
    d = paramBundle.getIntExtra("picker_mailbox_type", -1);
    int i = paramBundle.getIntExtra("picker_header_id", 0);
    if (i == 0)
    {
      finish();
      return;
    }
    a(i, i);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (b != null)
    {
      getContentResolver().unregisterContentObserver(b);
      b = null;
    }
    if (c != null)
    {
      c.dismiss();
      c = null;
    }
  }
}

/* Location:
 * Qualified Name:     azn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */