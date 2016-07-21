import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dgs
  extends DialogFragment
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  private static final int[] a = { 1, 2, 3, 4, 5, 6, 7 };
  private static final List<Integer> b = hef.a(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
  private int c;
  private Advertisement d;
  private Account e;
  private Uri f;
  private List<Integer> g;
  
  private static List<Integer> a(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("opts");
    if (TextUtils.isEmpty(str))
    {
      paramUri = b;
      return paramUri;
    }
    String[] arrayOfString = str.split(",");
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject = arrayOfString[i];
        try
        {
          int m = Integer.parseInt((String)localObject);
          localObject = a;
          int n = localObject.length;
          int j = 0;
          while (j < n)
          {
            if (localObject[j] == m)
            {
              if (m == 2) {
                if (TextUtils.isEmpty(paramUri.getQueryParameter("brand"))) {
                  break;
                }
              }
              for (;;)
              {
                localArrayList.add(Integer.valueOf(m));
                break;
                if (m == 3)
                {
                  if (TextUtils.isEmpty(paramUri.getQueryParameter("cat"))) {
                    break;
                  }
                }
                else if (m == 4)
                {
                  boolean bool = TextUtils.isEmpty(paramUri.getQueryParameter("merchant"));
                  if (bool) {
                    break;
                  }
                }
              }
            }
            j += 1;
          }
          paramUri = localArrayList;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          dri.d("AdFeedbackDialogFragment", "Options not correctly parsed: %s", new Object[] { str });
        }
      }
      if (localArrayList.size() != 0) {
        break;
      }
      return b;
      i += 1;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = (AlertDialog)getDialog();
    if (localObject != null)
    {
      localObject = ((AlertDialog)localObject).getButton(-1);
      if (localObject != null) {
        ((Button)localObject).setEnabled(paramBoolean);
      }
    }
  }
  
  private final String[] a(Uri paramUri, List<Integer> paramList)
  {
    Resources localResources = getResources();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      switch (localInteger.intValue())
      {
      default: 
        dri.d("AdFeedbackDialogFragment", "Unknown options: %d", new Object[] { localInteger });
        break;
      case 1: 
        localArrayList.add(localResources.getString(dge.ad));
        break;
      case 2: 
        localArrayList.add(localResources.getString(dge.Y, new Object[] { Uri.decode(paramUri.getQueryParameter("brand")) }));
        break;
      case 3: 
        localArrayList.add(localResources.getString(dge.Z, new Object[] { Uri.decode(paramUri.getQueryParameter("cat")) }));
        break;
      case 4: 
        localArrayList.add(localResources.getString(dge.ab, new Object[] { Uri.decode(paramUri.getQueryParameter("merchant")) }));
        break;
      case 5: 
        localArrayList.add(localResources.getString(dge.ac));
        break;
      case 6: 
        localArrayList.add(localResources.getString(dge.ae));
        break;
      case 7: 
        localArrayList.add(localResources.getString(dge.aa));
      }
    }
    return (String[])localArrayList.toArray(new String[paramList.size()]);
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1 = getResources();
    if (paramBoolean) {}
    for (int i = dge.ag;; i = dge.X)
    {
      Toast.makeText(getActivity(), ((Resources)localObject1).getString(i), 0).show();
      localObject1 = new dgt();
      Object localObject3 = getActivity();
      Object localObject2 = f;
      i = c;
      Advertisement localAdvertisement = d;
      Account localAccount = e;
      c = localAdvertisement;
      d = localAccount;
      e = ((Context)localObject3);
      b = paramBoolean;
      localObject3 = new Uri.Builder();
      ((Uri.Builder)localObject3).scheme("gmail-ads");
      ((Uri.Builder)localObject3).authority("submit-body-feedback");
      localObject2 = ((Uri)localObject2).getQueryParameter("id");
      if (localObject2 != null) {
        ((Uri.Builder)localObject3).appendQueryParameter("id", (String)localObject2);
      }
      if (paramBoolean) {
        ((Uri.Builder)localObject3).appendQueryParameter("opts", Integer.toString(i));
      }
      a = ((Uri.Builder)localObject3).build();
      AsyncTask.execute((Runnable)localObject1);
      return;
    }
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      b(true);
      return;
    }
    if (paramInt == -2)
    {
      b(false);
      return;
    }
    c = ((Integer)g.get(paramInt)).intValue();
    a(true);
  }
  
  public final void onClick(View paramView)
  {
    dfh.b(getActivity());
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = getArguments();
    f = ((Uri)((Bundle)localObject).getParcelable("uri"));
    d = ((Advertisement)((Bundle)localObject).getParcelable("advertisement"));
    e = ((Account)((Bundle)localObject).getParcelable("account"));
    g = a(f);
    if (paramBundle != null) {
      c = paramBundle.getInt("selection");
    }
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(getResources().getString(dge.ah));
    paramBundle.setSingleChoiceItems(a(f, g), -1, this);
    localObject = LayoutInflater.from(paramBundle.getContext()).inflate(dga.k, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(dfy.n);
    Activity localActivity = getActivity();
    Resources localResources = localActivity.getResources();
    String str = localResources.getString(dge.fh);
    localTextView.setText(cwt.a(localActivity, localResources.getString(dge.bc, new Object[] { str }), str, dgf.b));
    localTextView.setOnClickListener(this);
    paramBundle.setView((View)localObject);
    paramBundle.setPositiveButton(dge.af, this);
    paramBundle.setNegativeButton(dge.bG, this);
    return paramBundle.create();
  }
  
  public final void onResume()
  {
    if (c == 0) {
      a(false);
    }
    super.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("selection", c);
  }
}

/* Location:
 * Qualified Name:     dgs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */