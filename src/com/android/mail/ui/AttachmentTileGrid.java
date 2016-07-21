package com.android.mail.ui;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import bua;
import bue;
import buj;
import buo;
import but;
import bvu;
import byu;
import byv;
import cfc;
import ckk;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.browse.MessageAttachmentTile;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import cvl;
import cvm;
import cxe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AttachmentTileGrid
  extends FrameLayout
  implements byu, ckk
{
  private static final String i = cvl.a;
  public final LayoutInflater a;
  public final List<Attachment> b = new ArrayList();
  public bvu c;
  public final HashMap<String, AttachmentTile.AttachmentPreview> d;
  public FragmentManager e;
  public byv f;
  public Account g;
  public ConversationMessage h;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private int n;
  
  public AttachmentTileGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a = LayoutInflater.from(paramContext);
    paramContext = paramContext.getResources();
    j = paramContext.getDimensionPixelSize(bua.d);
    k = paramContext.getDimensionPixelSize(bua.c);
    l = paramContext.getDimensionPixelSize(bua.e);
    m = paramContext.getDimensionPixelSize(bua.b);
    d = new HashMap();
  }
  
  public final Bitmap a(Attachment paramAttachment)
  {
    paramAttachment = paramAttachment.k().toString();
    if (paramAttachment != null)
    {
      paramAttachment = (AttachmentTile.AttachmentPreview)d.get(paramAttachment);
      if (paramAttachment != null) {
        return b;
      }
    }
    return null;
  }
  
  public final void a(FragmentManager paramFragmentManager, Account paramAccount, ConversationMessage paramConversationMessage, List<Attachment> paramList, boolean paramBoolean, bvu parambvu)
  {
    e = paramFragmentManager;
    g = paramAccount;
    h = paramConversationMessage;
    b.clear();
    b.addAll(paramList);
    c = parambvu;
    int i1 = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      parambvu = (Attachment)paramList.next();
      if (getChildCount() <= i1)
      {
        paramFragmentManager = (MessageAttachmentTile)a.inflate(bue.p, this, false);
        FragmentManager localFragmentManager = e;
        bvu localbvu = c;
        a.h = localFragmentManager;
        b = localFragmentManager;
        d = localbvu;
        f = f;
        c = this;
        addView(paramFragmentManager);
      }
      for (;;)
      {
        paramFragmentManager.a(parambvu, paramAccount, paramConversationMessage, i1, this, paramBoolean);
        i1 += 1;
        break;
        paramFragmentManager = (MessageAttachmentTile)getChildAt(i1);
      }
    }
  }
  
  public final void a(MessageAttachmentTile paramMessageAttachmentTile)
  {
    String str = null;
    int i1 = indexOfChild(paramMessageAttachmentTile);
    Context localContext = getContext();
    if (h.x == null)
    {
      cvm.d(i, "Viewing photos of message (%d) with %d attachments but null attachmentListUri", new Object[] { Long.valueOf(h.d), Integer.valueOf(h.c(true)) });
      Toast.makeText(localContext, localContext.getString(buj.dC), 0).show();
      buo.a().a("errors", "view_photo_failed", null, 0L);
      return;
    }
    if (g == null)
    {
      paramMessageAttachmentTile = null;
      if (g != null) {
        break label138;
      }
    }
    for (;;)
    {
      cfc.a(localContext, paramMessageAttachmentTile, str, h, i1);
      return;
      paramMessageAttachmentTile = g.c;
      break;
      label138:
      str = g.e;
    }
  }
  
  public final void a(Attachment paramAttachment, Bitmap paramBitmap)
  {
    String str = paramAttachment.k().toString();
    if (str != null) {
      d.put(str, new AttachmentTile.AttachmentPreview(paramAttachment, paramBitmap));
    }
  }
  
  public final void a(ArrayList<AttachmentTile.AttachmentPreview> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AttachmentTile.AttachmentPreview localAttachmentPreview = (AttachmentTile.AttachmentPreview)paramArrayList.next();
        d.put(a, localAttachmentPreview);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i4 = getChildCount();
    int i2;
    int i3;
    AttachmentTile localAttachmentTile;
    int i1;
    label152:
    int i6;
    if (i4 != 0)
    {
      paramBoolean = cxe.a(this);
      int i5 = getMeasuredWidth();
      paramInt2 = 0;
      paramInt1 = -getChildAt(0).getMeasuredHeight() - l;
      i2 = 0;
      i3 = 0;
      paramInt3 = 0;
      if (paramInt3 < i4)
      {
        localAttachmentTile = (AttachmentTile)getChildAt(paramInt3);
        i1 = i3;
        paramInt4 = i2;
        if (i2 == 0)
        {
          i1 = i3;
          paramInt4 = i2;
          if (!g.j())
          {
            i1 = paramInt3 % n;
            paramInt4 = 1;
          }
        }
        i3 = localAttachmentTile.getMeasuredWidth();
        i2 = localAttachmentTile.getMeasuredHeight();
        if ((paramInt3 - i1) % n != 0) {
          break label257;
        }
        if (paramBoolean)
        {
          paramInt2 = i5 - i3 - m;
          i6 = getChildAt(Math.max(0, paramInt3 - n)).getMeasuredHeight();
          int i7 = l;
          paramInt1 += i6 + i7;
        }
      }
    }
    label257:
    for (;;)
    {
      localAttachmentTile.layout(paramInt2, paramInt1, paramInt2 + i3, i2 + paramInt1);
      i6 = l;
      if (paramBoolean) {}
      for (i2 = -1;; i2 = 1)
      {
        paramInt3 += 1;
        paramInt2 += i2 * (i3 + i6);
        i3 = i1;
        i2 = paramInt4;
        break;
        paramInt2 = m;
        break label152;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i6 - m * 2;
    int i7 = getChildCount();
    if (i7 == 0)
    {
      setMeasuredDimension(i6, 0);
      return;
    }
    paramInt2 = l + paramInt1;
    int i8;
    int i9;
    int i3;
    int i2;
    label102:
    AttachmentTile localAttachmentTile;
    int i4;
    int i1;
    if (paramInt1 < k)
    {
      n = (paramInt2 / (paramInt1 + l));
      i8 = Math.min(paramInt2 / n - l, k);
      i9 = i8 * 55 / 100;
      paramInt2 = 0;
      i3 = 0;
      i2 = 0;
      paramInt1 = 0;
      if (paramInt2 >= i7) {
        break label256;
      }
      localAttachmentTile = (AttachmentTile)getChildAt(paramInt2);
      if (g.j()) {
        break label267;
      }
      h.setVisibility(8);
      int i5 = Integer.MIN_VALUE;
      i4 = i5;
      i1 = i2;
      if (i2 == 0)
      {
        i3 = paramInt2 % n;
        i1 = 1;
        i4 = i5;
      }
    }
    for (;;)
    {
      localAttachmentTile.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, i4));
      if ((paramInt2 - i3) % n == 0) {
        paramInt1 = localAttachmentTile.getMeasuredHeight() + l + paramInt1;
      }
      for (;;)
      {
        paramInt2 += 1;
        i2 = i1;
        break label102;
        if (paramInt2 / (j + l) > 1)
        {
          paramInt1 = j;
          break;
        }
        paramInt1 = k;
        break;
        label256:
        setMeasuredDimension(i6, paramInt1);
        return;
      }
      label267:
      i4 = 1073741824;
      i1 = i2;
    }
  }
  
  public void sendAccessibilityEvent(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTileGrid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */