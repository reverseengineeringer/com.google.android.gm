package com.google.android.gm.preference;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import buo;
import but;
import com.android.mail.providers.Account;
import com.android.mail.widget.BaseGmailWidgetProviderService;
import cxa;
import dff;
import dfy;
import dga;
import dgd;
import dge;
import dpy;
import dqg;
import dqz;
import drd;
import dri;
import java.util.ArrayList;

public class LabelSynchronizationActivity
  extends dff
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private boolean a;
  private int b = -1;
  private Account c;
  private int d;
  private Uri e;
  private Uri f;
  private String g;
  private String h;
  private ArrayList<String> i;
  private ArrayList<String> j;
  private dqg k = null;
  private String l;
  private String m;
  private String n;
  private String o;
  
  public void onClick(View paramView)
  {
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(dga.Q);
    paramBundle = getIntent();
    a = paramBundle.getBooleanExtra("perform-actions-internally", false);
    if (paramBundle.getExtras().containsKey("update-widgetid-on-sync-change"))
    {
      b = paramBundle.getIntExtra("update-widgetid-on-sync-change", -1);
      d = paramBundle.getIntExtra("folder-type", 1);
      e = ((Uri)paramBundle.getParcelableExtra("folder-uri"));
      f = ((Uri)paramBundle.getParcelableExtra("folder-conversation-list-uri"));
      g = paramBundle.getStringExtra("folder-display-name");
      h = e.getLastPathSegment();
      c = ((Account)paramBundle.getParcelableExtra("account"));
      o = c.c;
      buo.a().b(o);
      buo.a().a("widget", "sync_tapped", null, 0L);
      if (a) {
        break label267;
      }
      i = paramBundle.getStringArrayListExtra("included-labels");
      j = paramBundle.getStringArrayListExtra("partial-labels");
    }
    for (int i1 = paramBundle.getIntExtra("num-of-sync-days", 0);; i1 = (int)k.a())
    {
      paramBundle = drd.a(this, o, h);
      if (paramBundle != null) {
        break label343;
      }
      dri.e(dri.a, "Unable to get label: %s for account: %s", new Object[] { h, o });
      finish();
      return;
      h = paramBundle.getStringExtra("folder");
      o = paramBundle.getStringExtra("account");
      break;
      label267:
      k = dpy.a(this, o);
      i = new ArrayList();
      i.addAll(k.c());
      j = new ArrayList();
      j.addAll(k.d());
    }
    label343:
    setTitle(paramBundle.c());
    Resources localResources = getResources();
    String str = localResources.getString(dge.fR);
    m = cxa.a(this, dgd.f, i1);
    n = localResources.getString(dge.fN);
    if (paramBundle.f())
    {
      paramBundle = new String[2];
      paramBundle[0] = m;
      paramBundle[1] = n;
      if (!i.contains(h)) {
        break label541;
      }
      l = n;
      label438:
      i1 = 0;
      label440:
      if (i1 >= paramBundle.length) {
        break label581;
      }
      if (!paramBundle[i1].equals(l)) {
        break label574;
      }
    }
    for (;;)
    {
      setListAdapter(new ArrayAdapter(this, dga.R, paramBundle));
      getListView().setChoiceMode(1);
      getListView().setItemChecked(i1, true);
      getListView().setOnItemClickListener(this);
      ((Button)findViewById(dfy.aa)).setOnClickListener(this);
      return;
      paramBundle = new String[3];
      paramBundle[0] = str;
      paramBundle[1] = m;
      paramBundle[2] = n;
      break;
      label541:
      if (j.contains(h))
      {
        l = m;
        break label438;
      }
      l = str;
      break label438;
      label574:
      i1 += 1;
      break label440;
      label581:
      i1 = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)getListAdapter().getItem(paramInt);
    if (paramAdapterView.equals(l))
    {
      finish();
      return;
    }
    i.remove(h);
    j.remove(h);
    if (paramAdapterView.equals(n))
    {
      i.add(h);
      if (a) {
        break label188;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("included-labels", i);
      paramAdapterView.putExtra("partial-labels", j);
      setResult(-1, paramAdapterView);
    }
    for (;;)
    {
      if (b != -1) {
        BaseGmailWidgetProviderService.a(this, b, c, d, 0, e, f, g);
      }
      finish();
      return;
      if (!paramAdapterView.equals(m)) {
        break;
      }
      j.add(h);
      break;
      label188:
      k.a(i);
      k.b(j);
      dpy.a(o, k, getContentResolver());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.LabelSynchronizationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */