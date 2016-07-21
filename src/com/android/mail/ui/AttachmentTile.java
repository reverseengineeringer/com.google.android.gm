package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import bua;
import bub;
import buc;
import buj;
import ceb;
import cki;
import ckk;
import com.android.mail.providers.Attachment;
import cqr;
import ctr;
import cvl;
import cvm;
import cxa;
import cxe;

public class AttachmentTile
  extends FrameLayout
  implements View.OnLongClickListener, cki
{
  private static final String j = cvl.a;
  private int a;
  private int b;
  private int c;
  private ImageView d;
  private TextView e;
  private boolean f = true;
  public Attachment g;
  ImageView h;
  private ckk i;
  
  public AttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return bub.X;
    case 1: 
      return bub.ad;
    case 2: 
      return bub.Y;
    case 3: 
      return bub.ac;
    case 5: 
      return bub.Z;
    case 6: 
      return bub.aa;
    case 7: 
      return bub.V;
    case 8: 
      return bub.ab;
    case 9: 
      return bub.W;
    }
    return bub.ae;
  }
  
  private final CharSequence a()
  {
    if (g == null) {
      return null;
    }
    int k;
    switch (ctr.a(g.l()))
    {
    case 4: 
    default: 
      k = buj.G;
    }
    for (;;)
    {
      String str = cxa.d(g.c);
      return getResources().getString(k, new Object[] { str });
      k = buj.s;
      continue;
      k = buj.x;
      continue;
      k = buj.H;
      continue;
      k = buj.t;
      continue;
      k = buj.v;
      continue;
      k = buj.w;
      continue;
      k = buj.B;
      continue;
      k = buj.u;
      continue;
      k = buj.I;
    }
  }
  
  public final void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int n = h.getWidth();
    int i1 = h.getHeight();
    float f1 = n / k;
    float f2 = i1 / m;
    Matrix localMatrix = new Matrix();
    float f3 = Math.max(f1, f2);
    localMatrix.setScale(f3, f3);
    if (ctr.a(g.l()) == 2)
    {
      if (f1 >= f2) {
        break label171;
      }
      localMatrix.postTranslate((n - k * f2) * 0.5F, 0.0F);
    }
    for (;;)
    {
      ceb localceb = new ceb(paramBitmap, a);
      a.getShader().setLocalMatrix(localMatrix);
      h.setImageDrawable(localceb);
      i.a(g, paramBitmap);
      f = false;
      return;
      label171:
      localMatrix.postTranslate(0.0F, (i1 - m * f1) * 0.5F);
    }
  }
  
  public void a(Attachment paramAttachment, ckk paramckk)
  {
    if (paramAttachment == null)
    {
      setVisibility(4);
      return;
    }
    Attachment localAttachment = g;
    g = paramAttachment;
    i = paramckk;
    paramckk = c;
    cvm.b(j, "got attachment list row: name=%s state/dest=%d/%d dled=%d contentUri=%s MIME=%s flags=%d", new Object[] { paramckk, Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(h), i, paramAttachment.l(), Integer.valueOf(l) });
    int m;
    Object localObject;
    int k;
    if ((localAttachment == null) || (!TextUtils.equals(paramckk, c)))
    {
      e.setText(paramckk);
      m = ctr.a(paramAttachment.l());
      localObject = h;
      switch (m)
      {
      default: 
        k = bub.ak;
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setImageResource(k);
      localObject = getResources();
      h.setContentDescription(((Resources)localObject).getString(buj.z, new Object[] { paramckk }));
      d.setImageResource(a(m));
      d.setContentDescription(a());
      cqr.a(i, this, paramAttachment, localAttachment);
      return;
      k = bub.al;
      continue;
      k = bub.am;
    }
  }
  
  public String c()
  {
    if (g == null) {
      return null;
    }
    Resources localResources = getResources();
    return localResources.getString(buj.C, new Object[] { a(), localResources.getString(buj.A, new Object[] { g.c }) });
  }
  
  public void d()
  {
    g();
  }
  
  public final int e()
  {
    return h.getWidth();
  }
  
  public final int f()
  {
    return h.getHeight();
  }
  
  public final void g()
  {
    Bitmap localBitmap = i.a(g);
    if (localBitmap != null)
    {
      a(localBitmap);
      return;
    }
    h.setScaleType(ImageView.ScaleType.CENTER);
    h.setImageResource(bub.ak);
    f = true;
  }
  
  public final ContentResolver h()
  {
    return getContext().getContentResolver();
  }
  
  public final boolean i()
  {
    return f;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    Resources localResources = getResources();
    a = localResources.getDimensionPixelSize(bua.f);
    b = localResources.getDimensionPixelSize(bua.h);
    c = localResources.getDimensionPixelSize(bua.g);
    h = ((ImageView)findViewById(buc.F));
    d = ((ImageView)findViewById(buc.A));
    e = ((TextView)findViewById(buc.G));
    setOnLongClickListener(this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    cqr.a(i, this, g, null);
  }
  
  public boolean onLongClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(localRect);
    Context localContext = getContext();
    int k = getHeight();
    int m = arrayOfInt[1] + k;
    if (cxe.a(paramView))
    {
      k = getResourcesgetDisplayMetricswidthPixels - arrayOfInt[0] - getWidth();
      if (m >= localRect.height()) {
        break label156;
      }
      m -= c;
    }
    for (;;)
    {
      paramView = Toast.makeText(localContext, localContext.getString(buj.E, new Object[] { g.c, ctr.a(localContext, g.d) }), 0);
      paramView.setGravity(8388659, k, m);
      paramView.show();
      return true;
      k = arrayOfInt[0];
      break;
      label156:
      m = arrayOfInt[1] - b;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */