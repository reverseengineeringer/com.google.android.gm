package com.android.mail.browse;

import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import buc;
import buj;
import buo;
import but;
import bvo;
import bvu;
import bvz;
import bxu;
import byy;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import com.android.mail.ui.AttachmentTileGrid;
import ctw;
import cvl;
import cvm;
import hbc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MessageFooterView
  extends LinearLayout
  implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener
{
  private static final String g = cvl.a;
  public AttachmentTileGrid a;
  private bxu b;
  private LoaderManager c;
  private FragmentManager d;
  private final List<Attachment> e = new ArrayList();
  private TextView f;
  private bvz h;
  private byy i;
  private bvu j;
  private Integer k;
  
  public MessageFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final Account a()
  {
    if (h != null) {
      return h.a();
    }
    return null;
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1;
    if (!e.isEmpty())
    {
      localObject1 = e;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break label45;
      }
    }
    label45:
    ArrayList localArrayList;
    do
    {
      return;
      localObject1 = b.f.l();
      break;
      localArrayList = new ArrayList(((List)localObject1).size());
      Object localObject2 = ((List)localObject1).iterator();
      int m = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Attachment localAttachment = (Attachment)((Iterator)localObject2).next();
        if (((!localAttachment.m()) || (i.c())) && ((l & 0x800) == 0)) {
          if (localAttachment.j())
          {
            localArrayList.add(m, localAttachment);
            m += 1;
          }
          else
          {
            localArrayList.add(localAttachment);
          }
        }
      }
      localObject2 = b.f;
      H = Attachment.a((Collection)localObject1);
      al = null;
    } while (localArrayList.isEmpty());
    a.a(d, a(), b.f, localArrayList, paramBoolean, j);
    a.setVisibility(0);
  }
  
  public final void a(LoaderManager paramLoaderManager, FragmentManager paramFragmentManager, bvz parambvz, byy parambyy, bvu parambvu)
  {
    c = paramLoaderManager;
    d = paramFragmentManager;
    h = parambvz;
    i = parambyy;
    j = parambvu;
  }
  
  public final void a(bxu parambxu, boolean paramBoolean)
  {
    TextView localTextView = null;
    int n = 0;
    b = parambxu;
    if (b == null)
    {
      parambxu = null;
      if (parambxu != null) {
        break label247;
      }
      parambxu = localTextView;
      label27:
      if ((k != null) && (!hbc.a(k, parambxu)))
      {
        c.destroyLoader(k.intValue());
        a.removeAllViewsInLayout();
        f.setVisibility(8);
        a.setVisibility(8);
      }
      k = parambxu;
      if ((!paramBoolean) && (parambxu != null))
      {
        cvm.c(g, "binding footer view, calling initLoader for message %d", new Object[] { parambxu });
        c.initLoader(parambxu.intValue(), Bundle.EMPTY, this);
      }
      if (a.getChildCount() == 0) {
        a(false);
      }
      parambxu = b.f;
      localTextView = f;
      if (O != 2) {
        break label255;
      }
      m = buj.fD;
      label171:
      localTextView.setText(m);
      localTextView = f;
      if ((O != 2) && ((O != 1) || (TextUtils.isEmpty(P)))) {
        break label262;
      }
      m = 0;
      label211:
      localTextView.setVisibility(m);
      if (!b.g) {
        break label268;
      }
    }
    label247:
    label255:
    label262:
    label268:
    for (int m = n;; m = 8)
    {
      setVisibility(m);
      return;
      parambxu = b.f;
      break;
      parambxu = parambxu.q();
      break label27;
      m = buj.fC;
      break label171;
      m = 8;
      break label211;
    }
  }
  
  public void onClick(View paramView)
  {
    buo.a().a("view_entire_message", "clicked", null, 0L);
    paramView = getContext();
    ConversationMessage localConversationMessage = b.f;
    if (O == 1)
    {
      localObject1 = new Intent();
      localObject2 = paramView.getResources().getString(buj.cb);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        cvm.f(g, "Trying to open clipped message with no activity defined", new Object[0]);
      }
    }
    while (O != 2)
    {
      Object localObject2;
      do
      {
        return;
        ((Intent)localObject1).setClassName(paramView, (String)localObject2);
        localObject2 = a();
      } while ((localObject2 == null) || (TextUtils.isEmpty(P)));
      ((Intent)localObject1).putExtra("extra-account-uri", g);
      ((Intent)localObject1).putExtra("permalink", P);
      ((Intent)localObject1).putExtra("account-name", c);
      ((Intent)localObject1).putExtra("server-message-id", e);
      paramView.startActivity((Intent)localObject1);
      return;
    }
    Object localObject1 = new ContentValues(1);
    ((ContentValues)localObject1).put("clipped", Integer.valueOf(3));
    new ctw().a(paramView.getContentResolver(), f, (ContentValues)localObject1, null, null);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new bvo(getContext(), b.f.x);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    f = ((TextView)findViewById(buc.fH));
    a = ((AttachmentTileGrid)findViewById(buc.z));
    f.setOnClickListener(this);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    e.clear();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */