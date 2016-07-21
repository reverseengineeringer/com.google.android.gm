import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface.OnClickListener;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class cob
  extends DialogFragment
  implements LoaderManager.LoaderCallbacks<Cursor>, DialogInterface.OnClickListener
{
  public cpx a;
  public Collection<Conversation> b;
  public boolean c;
  public Account d;
  public Folder e;
  public int f;
  public Parcelable g;
  private boolean h;
  
  public static cob a(Account paramAccount, Collection<Conversation> paramCollection, boolean paramBoolean, Folder paramFolder, int paramInt, Parcelable paramParcelable)
  {
    if ((paramInt == buc.cT) || (!paramAccount.a(16384L))) {}
    for (Object localObject = new cpa();; localObject = new ckr())
    {
      Bundle localBundle = new Bundle(5);
      localBundle.putParcelable("folder", paramFolder);
      localBundle.putParcelable("account", paramAccount);
      localBundle.putBoolean("batch", paramBoolean);
      localBundle.putParcelableArray("target", (Parcelable[])paramCollection.toArray(new Conversation[paramCollection.size()]));
      localBundle.putParcelable("dialogState", paramParcelable);
      ((cob)localObject).setArguments(localBundle);
      return (cob)localObject;
    }
  }
  
  protected final cll a()
  {
    if (!isResumed()) {
      throw new IllegalStateException("Tried to update conversations while fragment is not running");
    }
    return ((ckv)getActivity()).k();
  }
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(Context paramContext, Cursor paramCursor);
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = new cpx();
    paramBundle = getArguments();
    e = ((Folder)paramBundle.getParcelable("folder"));
    d = ((Account)paramBundle.getParcelable("account"));
    c = paramBundle.getBoolean("batch");
    b = Arrays.asList((Conversation[])cwl.a(paramBundle, "target", Conversation.class));
    g = paramBundle.getParcelable("dialogState");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity()).setNegativeButton(buj.R, this).setPositiveButton(buj.dx, this).setAdapter(a, this).setTitle(f).create();
    paramBundle.getListView().setOnItemClickListener(new coc(this));
    return paramBundle;
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    h = false;
    if (!cxa.b(d.j)) {}
    for (paramBundle = d.j;; paramBundle = d.i) {
      return new CursorLoader(getActivity().getApplicationContext(), paramBundle, chh.i, null, null, null);
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.a.clear();
    h = false;
  }
}

/* Location:
 * Qualified Name:     cob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */