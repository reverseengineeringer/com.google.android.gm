package com.google.android.gm.welcome;

import android.accounts.Account;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.RawContacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import buo;
import but;
import cfa;
import cfm;
import cui;
import cuo;
import cvl;
import cvm;
import cwm;
import cxa;
import cxe;
import ddy;
import dej;
import deo;
import dev;
import dfy;
import dga;
import dge;
import dmv;
import dyv;
import ead;
import eae;
import eaj;
import eal;
import eam;
import eau;
import eaw;
import ejl;
import frc;
import fyb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SetupAddressesFragment
  extends dej<WelcomeTourState.AccountState>
  implements View.OnClickListener, eaw
{
  public static final String e = cvl.a;
  public TextView f;
  private boolean g;
  private String h;
  
  private static WelcomeTourState.AccountState a(String paramString, List<WelcomeTourState.AccountState> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WelcomeTourState.AccountState localAccountState = (WelcomeTourState.AccountState)paramList.next();
      if (a.equals(paramString)) {
        return localAccountState;
      }
    }
    return null;
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (e()) {
      return;
    }
    FragmentManager localFragmentManager = getFragmentManager();
    Object localObject = localFragmentManager.findFragmentByTag("error-dialog-tag");
    if (localObject != null) {
      ((DialogFragment)localObject).dismiss();
    }
    localObject = new Bundle(2);
    ((Bundle)localObject).putInt("title", paramInt1);
    ((Bundle)localObject).putInt("message", paramInt2);
    eae localeae = new eae();
    localeae.setArguments((Bundle)localObject);
    localeae.show(localFragmentManager, "error-dialog-tag");
  }
  
  private final void a(Activity paramActivity, String paramString)
  {
    if (!cwm.a(paramActivity, "android.permission.READ_CONTACTS")) {
      if (cwm.a(paramActivity, "android.permission.READ_CONTACTS"))
      {
        h = paramString;
        paramActivity = new String[1];
        paramActivity[0] = "android.permission.READ_CONTACTS";
        paramString = cfm.a(getContext());
        int i = 0;
        while (i <= 0)
        {
          paramString.f(paramActivity[0]);
          i += 1;
        }
        requestPermissions(paramActivity, 3);
      }
    }
    do
    {
      do
      {
        return;
      } while (e());
      cfa.a(getString(dge.bJ)).show(paramActivity.getFragmentManager(), "permanent-permission-denial-dialog");
      return;
      if (!a(paramString)) {
        break;
      }
    } while (e());
    new eam().show(paramActivity.getFragmentManager(), "error-dialog-tag");
    return;
    if (cxa.a(paramActivity))
    {
      paramActivity = new Intent(paramActivity, ChangeAddressActivity.class);
      paramActivity.putExtra("account-address", paramString);
      startActivityForResult(paramActivity, 1);
      buo.a().a("setup_addresses", "change_address", null, 0L);
      return;
    }
    a(dge.es, dge.bI);
    buo.a().a("setup_addresses", "change_address", "no_network", 0L);
  }
  
  private static void a(List<WelcomeTourState.AccountState> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (WelcomeTourState.AccountState)paramList.next();
      String str = cui.b(b.name);
      localObject = b.type;
      buo.a().a("setup_addresses-account_added", cui.c(str), (String)localObject, 0L);
    }
  }
  
  private final boolean a(String paramString)
  {
    paramString = getActivity().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[] { "_id" }, "account_name=? AND account_type=? AND data_set IS NULL AND dirty!=0", new String[] { paramString, "com.google" }, null);
    if (paramString != null) {}
    try
    {
      int i = paramString.getCount();
      if (i > 0) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        cvm.d(cvm.a, localException, "SetupAddressesFragment", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label118;
      }
      paramString.close();
    }
    return false;
  }
  
  private final List<WelcomeTourState.AccountState> b(WelcomeTourState paramWelcomeTourState)
  {
    paramWelcomeTourState = new ArrayList(b);
    ListIterator localListIterator = a.b.listIterator();
    while (localListIterator.hasNext())
    {
      WelcomeTourState.AccountState localAccountState1 = (WelcomeTourState.AccountState)localListIterator.next();
      WelcomeTourState.AccountState localAccountState2 = a(a, paramWelcomeTourState);
      if (localAccountState2 == null)
      {
        cvm.b(e, "Updated state not found for account: id:%s %s", new Object[] { a, b });
        if (!localAccountState1.d())
        {
          cvm.b(e, "Existing state is not pending for account id:%s %s. Removing it from the list.", new Object[] { a, b });
          localListIterator.remove();
        }
        else
        {
          cvm.b(e, "Found new account %s", new Object[] { b.name });
        }
      }
      else
      {
        if (!b.name.equals(b.name)) {
          if (localAccountState1.d())
          {
            localListIterator.set(localAccountState2.a(3));
            cvm.b(e, "Rename completed for id: %s", new Object[] { a });
            label217:
            cvm.b(e, "Email address changed for id:%s from %s to %s", new Object[] { a, b.name, b.name });
          }
        }
        for (;;)
        {
          paramWelcomeTourState.remove(localAccountState2);
          break;
          localListIterator.set(localAccountState2);
          cvm.b(e, "Address changed but it was not pending for id: %s", new Object[] { a });
          break label217;
          if (!c.equals(c))
          {
            String str = c;
            localListIterator.set(new WelcomeTourState.AccountState(a, b, str, d, e));
            cvm.b(e, "Display name changed to %s for account id: %s", new Object[] { c, a });
          }
          else
          {
            cvm.b(e, "Account %s is not changed", new Object[] { a });
          }
        }
      }
    }
    a.b.addAll(paramWelcomeTourState);
    a.notifyDataSetChanged();
    c();
    return paramWelcomeTourState;
  }
  
  private final void d()
  {
    Activity localActivity = getActivity();
    if ((localActivity == null) || (!isAdded()))
    {
      cvm.c(e, "SetupAddressesFragment is detached from activity. Aborting restartWelcomeTourStateLoader", new Object[0]);
      return;
    }
    getLoaderManager().restartLoader(21, Bundle.EMPTY, eau.a(localActivity, getLoaderManager(), this));
  }
  
  private final boolean e()
  {
    boolean bool = false;
    if (g)
    {
      cvm.d(e, "SetupAddressesFragment: onSaveInstance state already called", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  protected final void a()
  {
    d();
  }
  
  public final void a(WelcomeTourState paramWelcomeTourState)
  {
    if (a == null)
    {
      localActivity = getActivity();
      if (localActivity != null)
      {
        a = new ead(localActivity, b, new ArrayList(b), this);
        c = new eal(this);
        a.registerDataSetObserver(c);
      }
    }
    while (!a.b.equals(b))
    {
      Activity localActivity;
      buo.a().a(2, Long.toString(b.size()));
      a(b(paramWelcomeTourState));
      return;
    }
  }
  
  protected final ejl<frc> b()
  {
    return a;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {}
    switch (paramInt2)
    {
    case 1: 
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 0: 
      buo.a().a("setup_addresses", "address_changed", "cancelled", 0L);
      return;
    case -1: 
      Object localObject1 = paramIntent.getStringExtra("account-address");
      paramIntent = paramIntent.getStringExtra("changed-address");
      Object localObject2;
      if (a != null)
      {
        localObject2 = getActivity();
        ListIterator localListIterator = a.b.listIterator();
        for (;;)
        {
          if (localListIterator.hasNext())
          {
            WelcomeTourState.AccountState localAccountState = (WelcomeTourState.AccountState)localListIterator.next();
            if (((String)localObject1).equals(b.name))
            {
              cvm.b(e, "Set account %s as pending", new Object[] { localObject1 });
              localListIterator.set(localAccountState.a(2));
              dmv.a().a((Context)localObject2, a, "no_longer_rename_eligible", Boolean.valueOf(true));
              if (a != null) {
                a.notifyDataSetChanged();
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = a.a;
        if (!((Map)localObject2).containsKey(paramIntent))
        {
          localObject1 = (fyb)((Map)localObject2).get(localObject1);
          if (localObject1 != null) {
            ((Map)localObject2).put(paramIntent, localObject1);
          }
        }
        buo.a().a("setup_addresses", "address_changed", "ok", 0L);
        return;
        cvm.d(e, "Failed to mark unknown account as change pending.", new Object[0]);
      }
    }
    paramInt1 = paramIntent.getIntExtra("error", -1);
    switch (paramInt1)
    {
    default: 
      a(dge.fX, dge.fY);
    }
    for (;;)
    {
      buo.a().a("setup_addresses", "address_changed", 17 + "error_" + paramInt1, 0L);
      return;
      a(dge.es, dge.bI);
      continue;
      a(dge.es, dge.et);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject = getActivity();
    if (localObject == null) {
      cvm.d(e, "SetupAddressesFragment is detached from activity. Abort onClick", new Object[0]);
    }
    do
    {
      return;
      if (i == dfy.cb)
      {
        buo.a().a("setup_addresses", "learn_more", null, 0L);
        dev.a(getActivity());
        new dyv().a(getActivity(), null, "gm_default_ww", null);
        return;
      }
      if (i == dfy.by)
      {
        a((Activity)localObject, (String)paramView.getTag());
        return;
      }
      if (i == dfy.bY)
      {
        ddy.a((Activity)localObject, "from_welcome");
        buo.a().a("setup_addresses", "add_account", null, 0L);
        return;
      }
    } while (i != dfy.i);
    if (a != null) {}
    for (i = a.getCount();; i = 0)
    {
      buo.a().a("setup_addresses", "take_me_to_gmail", "nb_addresses", i);
      if (i != 0) {
        break label226;
      }
      if (e()) {
        break;
      }
      paramView = getFragmentManager();
      localObject = paramView.findFragmentByTag("NoAccountsDialog");
      if (localObject != null) {
        ((eaj)localObject).dismiss();
      }
      new eaj().show(paramView, "NoAccountsDialog");
      return;
    }
    label226:
    ((Activity)localObject).setResult(-1);
    ((Activity)localObject).finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c = new eal(this);
    Intent localIntent = getActivity().getIntent();
    if ((paramBundle != null) && (paramBundle.containsKey("pending-changes"))) {
      paramBundle = paramBundle.getParcelableArrayList("pending-changes");
    }
    for (;;)
    {
      if (paramBundle != null) {
        a = new ead(getActivity(), b, paramBundle, this);
      }
      return;
      if (localIntent.hasExtra("pending-changes"))
      {
        paramBundle = localIntent.getParcelableArrayListExtra("pending-changes");
      }
      else
      {
        paramBundle = (WelcomeTourState)localIntent.getParcelableExtra("tour-state");
        if (paramBundle != null)
        {
          paramBundle = new ArrayList(b);
        }
        else
        {
          d();
          paramBundle = null;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(dga.X, paramViewGroup, false);
    if (getResourcesgetConfigurationorientation == 2) {
      paramLayoutInflater.findViewById(dfy.bh).setVisibility(8);
    }
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(dfy.cb);
    paramBundle = (WelcomeTourState)getActivity().getIntent().getParcelableExtra("tour-state");
    if ((paramBundle == null) || (a))
    {
      i = 1;
      if (i == 0) {
        break label186;
      }
    }
    label186:
    for (int i = dge.fD;; i = dge.fE)
    {
      cxe.a(paramViewGroup, i, this, new CharSequence[0]);
      buo.a().a("welcome_tour", "page", "setup_addresses", 0L);
      paramLayoutInflater.findViewById(dfy.i).setOnClickListener(this);
      f = ((TextView)paramLayoutInflater.findViewById(dfy.bY));
      f.setOnClickListener(this);
      d = ((LinearLayout)paramLayoutInflater.findViewById(dfy.ca));
      if (a != null) {
        a.notifyDataSetChanged();
      }
      return paramLayoutInflater;
      i = 0;
      break;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 3)
    {
      paramInt = 0;
      Activity localActivity;
      if (paramInt < paramArrayOfString.length)
      {
        if (!"android.permission.READ_CONTACTS".equals(paramArrayOfString[paramInt])) {
          break label102;
        }
        if (paramArrayOfInt[paramInt] != 0) {
          break label95;
        }
        localActivity = getActivity();
        if (localActivity != null) {
          break label61;
        }
        cvm.d(e, "SetupAddressesFragment is detached from activity. Abort onRequestPermissionsResult", new Object[0]);
      }
      for (;;)
      {
        h = null;
        return;
        label61:
        if (h != null) {
          break;
        }
        cvm.d(e, "Contact permission granted but we don't have accountName.", new Object[0]);
      }
      a(localActivity, h);
      for (;;)
      {
        label95:
        paramInt += 1;
        break;
        label102:
        cvm.f(e, "Unexpected permission requested: %s", new Object[] { paramArrayOfString[paramInt] });
      }
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    g = false;
    d();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (a != null) {
      paramBundle.putParcelableArrayList("pending-changes", a.b);
    }
    g = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.SetupAddressesFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */