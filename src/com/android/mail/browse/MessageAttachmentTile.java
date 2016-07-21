package com.android.mail.browse;

import android.accounts.AccountManager;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bna;
import buc;
import buj;
import buo;
import bus;
import but;
import bvk;
import bvl;
import bvq;
import bvr;
import bvu;
import bvx;
import byq;
import byr;
import bys;
import byt;
import byu;
import byv;
import ckk;
import ckm;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import com.android.mail.ui.AttachmentTile;
import com.android.mail.ui.AttachmentTileGrid;
import ctr;
import cuh;
import cvl;
import cvm;
import cvr;
import cwm;
import cxa;
import hbc;
import java.util.PriorityQueue;

public class MessageAttachmentTile
  extends AttachmentTile
  implements View.OnClickListener, bvr
{
  private static final String i = cvl.a;
  public final bvk a = new bvk(paramContext, this);
  public FragmentManager b;
  public byu c;
  public bvu d;
  public bvx e;
  public byv f;
  private Account j;
  private int k;
  private View l;
  private View m;
  private TextView n;
  private Message o;
  
  public MessageAttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageAttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a()
  {
    Object localObject1 = g.l();
    String str = cxa.e((String)localObject1);
    buo.a().a("attachment", "view", str, g.d);
    if (bna.a(str))
    {
      if (c != null)
      {
        c.a(this);
        return;
      }
      cvm.e(i, "Unable to view image attachment b/c handler is null", new Object[0]);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(524289);
    cxa.a(localIntent, g.i, str);
    if (cvr.c((String)localObject1))
    {
      localIntent.setPackage(getContext().getPackageName());
      if (j == null) {
        break label173;
      }
    }
    label173:
    Object localObject2;
    for (localObject1 = j.g;; localObject2 = null)
    {
      localIntent.putExtra("extra-account-uri", (Parcelable)localObject1);
      try
      {
        getContext().startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        cvm.e(i, "Couldn't find Activity for intent", new Object[] { localActivityNotFoundException });
        return;
      }
    }
  }
  
  public final void a(Attachment paramAttachment, Account paramAccount, ConversationMessage paramConversationMessage, int paramInt, ckk paramckk, boolean paramBoolean)
  {
    int i1 = 1;
    a(paramAttachment, paramckk);
    j = paramAccount;
    o = paramConversationMessage;
    k = paramInt;
    a.c = paramAttachment;
    if (j != null) {
      a.a = j.c;
    }
    a.b = paramConversationMessage;
    paramAccount = a;
    boolean bool;
    if (e != null)
    {
      bool = c.g();
      paramConversationMessage = (bvq)h.findFragmentByTag("attachment-progress");
      if (paramConversationMessage != null)
      {
        paramckk = c;
        if ((paramConversationMessage.getDialog() == null) || (!hbc.a(paramckk.k(), a.k()))) {
          break label435;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          paramInt = c.h;
          if (b != null) {
            b.setProgress(paramInt);
          }
          if (bool) {
            break label447;
          }
          if ((b == null) || (!b.isIndeterminate())) {
            break label441;
          }
          paramInt = 1;
          label190:
          if (paramInt == 0) {
            break label447;
          }
          bool = true;
          label198:
          if (b != null) {
            b.setIndeterminate(bool);
          }
          if ((paramBoolean) && (c.h())) {
            g.post(new bvl(paramAccount, paramConversationMessage));
          }
          if (c.f == 3) {
            e.a();
          }
        }
      }
      e.b();
    }
    else
    {
      if (paramAttachment.o()) {
        break label453;
      }
      n.setText(getResources().getText(buj.dS));
      n.setVisibility(0);
      label307:
      paramInt = i1;
      if (!paramAttachment.c()) {
        if ((!paramAttachment.i()) || (!paramAttachment.h())) {
          break label465;
        }
      }
    }
    label435:
    label441:
    label447:
    label453:
    label465:
    for (paramInt = i1;; paramInt = 0)
    {
      if (paramInt != 0) {
        l.setVisibility(0);
      }
      if ((d.a(AccountManager.get(getContext()), j)) && (paramAttachment.o()) && (d.a(paramAttachment.l()))) {
        m.setVisibility(0);
      }
      if ((o) && (e == null)) {
        post(new byq(this));
      }
      setContentDescription(c());
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label190;
      bool = false;
      break label198;
      n.setVisibility(8);
      break label307;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    e = d.a(paramBoolean, new byr(this));
    g.o = true;
  }
  
  public final void b()
  {
    if ((g.e()) || (e == null) || (!d.c())) {
      return;
    }
    if (g.b())
    {
      bvx localbvx = e;
      Attachment localAttachment = g;
      getContext().getContentResolver();
      localbvx.a(localAttachment);
      return;
    }
    e.a();
  }
  
  protected final String c()
  {
    String str2 = super.c();
    if (str2 != null)
    {
      Resources localResources = getResources();
      String str1;
      if (n.getVisibility() == 0) {
        str1 = localResources.getString(buj.A, new Object[] { n.getContentDescription() });
      }
      while (l.getVisibility() == 0) {
        if (m.getVisibility() == 0)
        {
          return localResources.getString(buj.F, new Object[] { str2, str1, l.getContentDescription(), m.getContentDescription() });
          str1 = "";
        }
        else
        {
          return localResources.getString(buj.D, new Object[] { str2, str1, l.getContentDescription() });
        }
      }
      if (m.getVisibility() == 0) {
        return localResources.getString(buj.D, new Object[] { str2, str1, m.getContentDescription() });
      }
      return localResources.getString(buj.C, new Object[] { str2, str1 });
    }
    return null;
  }
  
  public final void d()
  {
    super.d();
    if (ctr.a(getContext(), g)) {
      a.a(0, 0, 0, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    Object localObject1 = g.l();
    String str = cxa.e((String)localObject1);
    but localbut = buo.a();
    int i2 = paramView.getId();
    boolean bool;
    if (i2 == buc.C) {
      if ((!cuh.a()) && (j != null) && ("com.google.android.gm.exchange".equals(j.e)))
      {
        bool = true;
        if ((!bool) || (getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", "com.google.android.gm.exchange") != 0)) {
          break label153;
        }
        label91:
        if ((i1 == 0) && ((bool) || (!cwm.a(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE")))) {
          break label165;
        }
        if (!bool) {
          break label158;
        }
        paramView = "storage_attachment_eas";
        label122:
        bus.a(paramView, "enabled");
        localObject1 = a.b();
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label277;
        }
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label153:
      i1 = 0;
      break label91;
      label158:
      paramView = "storage_attachment";
      break label122;
      label165:
      if (bool)
      {
        paramView = "storage_attachment_eas";
        label174:
        bus.a(paramView, "disabled");
        if (f == null) {
          break label220;
        }
        f.a(bool, g, o);
      }
      for (;;)
      {
        localObject1 = null;
        break;
        paramView = "storage_attachment";
        break label174;
        label220:
        cvm.e(i, "No save permission handler when saving attachment", new Object[0]);
      }
      if (i2 == buc.D) {
        if ((j == null) || (d.b(j.e)))
        {
          a(true);
          paramView = "upload_to_cloud";
        }
      }
      label277:
      while (paramView != null)
      {
        localbut.a("attachment", paramView, str, g.d);
        return;
        a.a();
        paramView = "save_to_cloud";
        continue;
        if (!g.o())
        {
          new bys().show(b, "download-disabled-dialog");
          paramView = "policy_disallows_download";
        }
        else if (cvr.a((String)localObject1))
        {
          a.a(1);
          paramView = "install";
        }
        else
        {
          Object localObject2;
          if (cvr.a(getContext(), g.i, (String)localObject1))
          {
            if (bna.a(str))
            {
              localObject1 = (AttachmentTileGrid)getParent();
              paramView = new PriorityQueue(1, new ckm(k));
              i1 = 0;
              while (i1 < ((AttachmentTileGrid)localObject1).getChildCount())
              {
                localObject2 = ((AttachmentTileGrid)localObject1).getChildAt(i1);
                if ((localObject2 instanceof MessageAttachmentTile))
                {
                  localObject2 = (MessageAttachmentTile)localObject2;
                  if (bna.a(g.l())) {
                    paramView.add(localObject2);
                  }
                }
                i1 += 1;
              }
              i2 = paramView.size();
              i1 = 0;
              if (i1 < i2)
              {
                localObject1 = (MessageAttachmentTile)paramView.remove();
                if (i1 != 0) {}
                for (bool = true;; bool = false)
                {
                  if (!g.b()) {
                    a.a(0, 1, i2 - i1, bool);
                  }
                  i1 += 1;
                  break;
                }
              }
              a();
              paramView = null;
            }
            else
            {
              a.a(0);
              paramView = null;
            }
          }
          else
          {
            paramView = cvr.b(g.c);
            localObject1 = new byt();
            localObject2 = new Bundle(2);
            ((Bundle)localObject2).putString("extensionType", paramView);
            ((Bundle)localObject2).putString("mimeType", str);
            ((byt)localObject1).setArguments((Bundle)localObject2);
            ((byt)localObject1).show(b, "no-app-dialog");
            paramView = "no_viewer";
          }
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    l = findViewById(buc.C);
    m = findViewById(buc.D);
    n = ((TextView)findViewById(buc.E));
    setOnClickListener(this);
    l.setOnClickListener(this);
    m.setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageAttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */