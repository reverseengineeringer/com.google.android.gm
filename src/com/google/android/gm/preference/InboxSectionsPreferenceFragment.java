package com.google.android.gm.preference;

import aaj;
import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.text.TextUtils;
import com.google.android.gm.provider.GmailProvider;
import crx;
import cse;
import cvl;
import cvm;
import dgh;
import dpy;
import dri;
import drj;
import drn;
import drp;
import duf;
import gwt;
import hfd;
import hfe;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import zc;

public final class InboxSectionsPreferenceFragment
  extends cse
{
  private drp a;
  private CheckBoxPreference b;
  private CheckBoxPreference c;
  private CheckBoxPreference d;
  private CheckBoxPreference e;
  private CheckBoxPreference f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (a != null) {
      ((crx)getActivity()).b().a().b(a.l.name);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = drp.a(getArguments().getString("account"));
    if (a == null) {
      return;
    }
    addPreferencesFromResource(dgh.e);
    b = ((CheckBoxPreference)findPreference("inbox-category-social"));
    c = ((CheckBoxPreference)findPreference("inbox-category-promo"));
    d = ((CheckBoxPreference)findPreference("inbox-category-notification"));
    e = ((CheckBoxPreference)findPreference("inbox-category-group"));
    f = ((CheckBoxPreference)findPreference("inbox-sections-starred-in-personal"));
    paramBundle = a;
    Object localObject2 = o.g().values();
    Object localObject1 = new hfe();
    if (o.a("bx_pie", false))
    {
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((hfe)localObject1).c(nexta);
      }
    }
    ((hfe)localObject1).c("^sq_ig_i_personal");
    localObject1 = ((hfe)localObject1).a();
    g = ((Set)localObject1).contains("^sq_ig_i_social");
    h = ((Set)localObject1).contains("^sq_ig_i_promo");
    i = ((Set)localObject1).contains("^sq_ig_i_notification");
    j = ((Set)localObject1).contains("^sq_ig_i_group");
    paramBundle = o.f();
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = c)
    {
      k = bool;
      b.setChecked(g);
      c.setChecked(h);
      d.setChecked(i);
      e.setChecked(j);
      f.setChecked(k);
      return;
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    if (a == null) {
      return;
    }
    boolean bool1 = b.isChecked();
    boolean bool2 = c.isChecked();
    boolean bool3 = d.isChecked();
    boolean bool4 = e.isChecked();
    boolean bool5 = f.isChecked();
    if ((g != bool1) || (h != bool2) || (i != bool3) || (j != bool4) || (k != bool5))
    {
      Object localObject2 = new hfe();
      Object localObject1 = new hfe();
      ((hfe)localObject2).c(Integer.valueOf(0));
      ((hfe)localObject1).c("^sq_ig_i_personal");
      if (bool1)
      {
        ((hfe)localObject2).c(Integer.valueOf(1));
        ((hfe)localObject1).c("^sq_ig_i_social");
      }
      if (bool2)
      {
        ((hfe)localObject2).c(Integer.valueOf(2));
        ((hfe)localObject1).c("^sq_ig_i_promo");
      }
      if (bool3)
      {
        ((hfe)localObject2).c(Integer.valueOf(3));
        ((hfe)localObject1).c("^sq_ig_i_notification");
      }
      if (bool4)
      {
        ((hfe)localObject2).c(Integer.valueOf(4));
        ((hfe)localObject1).c("^sq_ig_i_group");
      }
      drp localdrp = a;
      localObject2 = ((hfe)localObject2).a();
      hfd localhfd = ((hfe)localObject1).a();
      if (dri.a(drp.b, 3))
      {
        localObject1 = String.valueOf(l.name);
        if (((String)localObject1).length() != 0)
        {
          localObject1 = " for ".concat((String)localObject1);
          dri.c(drp.b, "Configuring sectioned inbox with sections: %s and show starred: %b%s", new Object[] { TextUtils.join(",", (Iterable)localObject2), Boolean.valueOf(bool5), localObject1 });
          o.a(localhfd, bool5);
          localObject1 = n;
          localObject2 = TextUtils.join(",", (Iterable)localObject2);
          if (!bool5) {
            break label454;
          }
        }
      }
      label454:
      for (int m = 1;; m = 0)
      {
        ((duf)localObject1).a("configureSectionedInbox", 0L, m, 0L, (String)localObject2, null, null, null, 0L, 0, 0L);
        k.getContentResolver().notifyChange(dpy.a(l.name), null, true);
        k.getContentResolver().notifyChange(GmailProvider.c(l.name), null, true);
        a.l();
        return;
        localObject1 = new String(" for ");
        break;
        localObject1 = "";
        break;
      }
    }
    cvm.b(cvl.a, "Section configuration was not changed, so leave as is", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.InboxSectionsPreferenceFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */