import android.app.Dialog;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.android.mail.providers.Account;
import com.android.mail.ui.ComposeAttachmentTileGrid;
import com.google.android.gm.ComposeActivityGmail;
import java.util.List;

public final class djs
  extends djf
  implements LoaderManager.LoaderCallbacks<long[]>
{
  public static final String a = cvl.a;
  private int b;
  private CharSequence c;
  
  public final void a()
  {
    int i = getArguments().getParcelableArrayList("attachments").size();
    int j = b + 1;
    b = j;
    ComposeActivityGmail localComposeActivityGmail;
    if (j == i)
    {
      b = 0;
      localComposeActivityGmail = (ComposeActivityGmail)getActivity();
      if (localComposeActivityGmail != null) {
        break label67;
      }
      cvm.d(a, "Can't insert placeholders, activity is null", new Object[0]);
    }
    for (;;)
    {
      super.a();
      return;
      label67:
      CharSequence localCharSequence = c;
      A.append(localCharSequence);
      r.a();
      c = null;
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      b = paramBundle.getInt("total_queued", 0);
      c = paramBundle.getCharSequence("chips", null);
    }
    if (TextUtils.isEmpty(c)) {
      getLoaderManager().initLoader(1, getArguments(), this);
    }
    return super.onCreateDialog(paramBundle);
  }
  
  public final Loader<long[]> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    Account localAccount = (Account)paramBundle.getParcelable("account");
    long l = paramBundle.getLong("localMessageId");
    paramInt = paramBundle.getParcelableArrayList("attachments").size();
    return new djt(getActivity(), localAccount, l, paramInt);
  }
  
  public final void onLoaderReset(Loader<long[]> paramLoader) {}
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("total_queued", b);
    paramBundle.putCharSequence("chips", c);
  }
}

/* Location:
 * Qualified Name:     djs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */