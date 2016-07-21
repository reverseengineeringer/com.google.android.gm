package com.android.mail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bua;
import buc;
import com.android.mail.providers.Folder;
import cus;
import cvl;
import cvm;
import cxa;

public class FolderItemView
  extends NonOverlappingLinearLayout
{
  private static float[] f;
  public Folder a;
  public View b;
  public float c;
  public boolean d;
  private final String e = cvl.a;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public FolderItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private static void a(Context paramContext)
  {
    if (f == null)
    {
      float f1 = paramContext.getResources().getDimension(bua.M);
      f = new float[] { f1, f1, f1, f1, f1, f1, f1, f1 };
    }
  }
  
  private final void b(int paramInt)
  {
    TextView localTextView = h;
    if (paramInt > 0) {}
    for (int j = 0;; j = 8)
    {
      localTextView.setVisibility(j);
      if (paramInt > 0) {
        h.setText(cxa.a(getContext(), paramInt));
      }
      return;
    }
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    c = paramFloat;
    d = paramBoolean;
    setAlpha(1.0F);
    b.setAlpha(1.0F);
  }
  
  public final void a(int paramInt)
  {
    cvm.e(e, "FLF->FolderItem.getFolderView: unread count mismatch found (%s vs %d)", new Object[] { h.getText(), Integer.valueOf(paramInt) });
    b(paramInt);
  }
  
  public final void a(Folder paramFolder, cus paramcus)
  {
    int k = 0;
    a = paramFolder;
    g.setText(d);
    int j;
    if (paramcus != null)
    {
      boolean bool = c.equals(paramcus);
      paramFolder = findViewById(buc.dc);
      if (bool)
      {
        j = 8;
        paramFolder.setVisibility(j);
      }
    }
    else
    {
      if ((!a.d(8194)) || (a.j <= 0)) {
        break label220;
      }
      h.setVisibility(8);
      int m = a.b(-16777216);
      int n = a.j;
      paramFolder = i;
      if (n <= 0) {
        break label214;
      }
      j = k;
      label119:
      paramFolder.setVisibility(j);
      if (n > 0)
      {
        paramFolder = new ShapeDrawable(new RoundRectShape(f, null, null));
        paramFolder.getPaint().setColor(m);
        i.setBackgroundDrawable(paramFolder);
        i.setText(cxa.b(getContext(), n));
      }
    }
    for (;;)
    {
      setAlpha(1.0F);
      setTranslationY(0.0F);
      b.setAlpha(1.0F);
      b.setTranslationY(0.0F);
      return;
      j = 0;
      break;
      label214:
      j = 8;
      break label119;
      label220:
      i.setVisibility(8);
      b(cxa.a(a));
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b = findViewById(buc.bz);
    g = ((TextView)b.findViewById(buc.cY));
    h = ((TextView)b.findViewById(buc.fx));
    i = ((TextView)b.findViewById(buc.fz));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */