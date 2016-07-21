import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public final class aaf
  extends abf
  implements DialogInterface
{
  zs a = new zs(getContext(), this, getWindow());
  
  aaf(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if (paramInt >= 16777216) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(aca.p, localTypedValue, true);
    return resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zs localzs = a;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label99:
    label105:
    label216:
    label351:
    label402:
    label451:
    label500:
    label506:
    label565:
    label582:
    int k;
    label598:
    int j;
    if (G == 0)
    {
      i = F;
      b.setContentView(i);
      paramBundle = c.findViewById(acf.v);
      localObject4 = paramBundle.findViewById(acf.F);
      localObject3 = paramBundle.findViewById(acf.m);
      localObject2 = paramBundle.findViewById(acf.l);
      localObject1 = (ViewGroup)paramBundle.findViewById(acf.o);
      if (g == null) {
        break label848;
      }
      paramBundle = g;
      if (paramBundle == null) {
        break label884;
      }
      i = 1;
      if ((i == 0) || (!zs.a(paramBundle))) {
        c.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label889;
      }
      Object localObject5 = (FrameLayout)c.findViewById(acf.n);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (m) {
        ((FrameLayout)localObject5).setPadding(i, j, k, l);
      }
      if (f != null) {
        getLayoutParamsweight = 0.0F;
      }
      paramBundle = ((ViewGroup)localObject1).findViewById(acf.F);
      View localView = ((ViewGroup)localObject1).findViewById(acf.m);
      localObject5 = ((ViewGroup)localObject1).findViewById(acf.l);
      paramBundle = zs.a(paramBundle, (View)localObject4);
      localObject3 = zs.a(localView, (View)localObject3);
      localObject2 = zs.a((View)localObject5, (View)localObject2);
      w = ((NestedScrollView)c.findViewById(acf.y));
      w.setFocusable(false);
      w.setNestedScrollingEnabled(false);
      B = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (B != null)
      {
        if (e == null) {
          break label899;
        }
        B.setText(e);
      }
      i = 0;
      n = ((Button)((ViewGroup)localObject2).findViewById(16908313));
      n.setOnClickListener(N);
      if (!TextUtils.isEmpty(o)) {
        break label993;
      }
      n.setVisibility(8);
      q = ((Button)((ViewGroup)localObject2).findViewById(16908314));
      q.setOnClickListener(N);
      if (!TextUtils.isEmpty(r)) {
        break label1020;
      }
      q.setVisibility(8);
      t = ((Button)((ViewGroup)localObject2).findViewById(16908315));
      t.setOnClickListener(N);
      if (!TextUtils.isEmpty(u)) {
        break label1049;
      }
      t.setVisibility(8);
      if (i == 0) {
        break label1078;
      }
      i = 1;
      if (i == 0) {
        ((ViewGroup)localObject2).setVisibility(8);
      }
      if (C == null) {
        break label1083;
      }
      localObject4 = new ViewGroup.LayoutParams(-1, -2);
      paramBundle.addView(C, 0, (ViewGroup.LayoutParams)localObject4);
      c.findViewById(acf.E).setVisibility(8);
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1292;
      }
      i = 1;
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1297;
      }
      k = 1;
      if ((localObject2 == null) || (((ViewGroup)localObject2).getVisibility() == 8)) {
        break label1303;
      }
      j = 1;
      label615:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(acf.C);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if ((k != 0) && (w != null)) {
        w.setClipToPadding(true);
      }
      if (i == 0)
      {
        if (f == null) {
          break label1308;
        }
        paramBundle = f;
        label682:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1317;
          }
          i = 1;
          label693:
          if (j == 0) {
            break label1322;
          }
          j = 2;
          label699:
          i |= j;
          localObject1 = c.findViewById(acf.x);
          localObject2 = c.findViewById(acf.w);
          if (Build.VERSION.SDK_INT < 23) {
            break label1327;
          }
          rg.a.a(paramBundle, i, 3);
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
          if (localObject2 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = f;
      if ((paramBundle != null) && (D != null))
      {
        paramBundle.setAdapter(D);
        i = E;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      if (L == 1)
      {
        i = G;
        break;
      }
      i = F;
      break;
      label848:
      if (h != 0)
      {
        paramBundle = LayoutInflater.from(a).inflate(h, (ViewGroup)localObject1, false);
        break label99;
      }
      paramBundle = null;
      break label99;
      label884:
      i = 0;
      break label105;
      label889:
      ((ViewGroup)localObject1).setVisibility(8);
      break label216;
      label899:
      B.setVisibility(8);
      w.removeView(B);
      if (f != null)
      {
        localObject4 = (ViewGroup)w.getParent();
        i = ((ViewGroup)localObject4).indexOfChild(w);
        ((ViewGroup)localObject4).removeViewAt(i);
        ((ViewGroup)localObject4).addView(f, i, new ViewGroup.LayoutParams(-1, -1));
        break label351;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label351;
      label993:
      n.setText(o);
      n.setVisibility(0);
      i = 1;
      break label402;
      label1020:
      q.setText(r);
      q.setVisibility(0);
      i |= 0x2;
      break label451;
      label1049:
      t.setText(u);
      t.setVisibility(0);
      i |= 0x4;
      break label500;
      label1078:
      i = 0;
      break label506;
      label1083:
      z = ((ImageView)c.findViewById(16908294));
      if (!TextUtils.isEmpty(d)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          A = ((TextView)c.findViewById(acf.k));
          A.setText(d);
          if (x != 0)
          {
            z.setImageResource(x);
            break;
            i = 0;
            continue;
          }
          if (y != null)
          {
            z.setImageDrawable(y);
            break;
          }
          A.setPadding(z.getPaddingLeft(), z.getPaddingTop(), z.getPaddingRight(), z.getPaddingBottom());
          z.setVisibility(8);
          break;
        }
      }
      c.findViewById(acf.E).setVisibility(8);
      z.setVisibility(8);
      paramBundle.setVisibility(8);
      break label565;
      label1292:
      i = 0;
      break label582;
      label1297:
      k = 0;
      break label598;
      label1303:
      j = 0;
      break label615;
      label1308:
      paramBundle = w;
      break label682;
      label1317:
      i = 0;
      break label693;
      label1322:
      j = 0;
      break label699;
      label1327:
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if ((i & 0x1) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject1);
          paramBundle = null;
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((i & 0x2) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject1 = null;
        }
      }
      if ((paramBundle != null) || (localObject1 != null)) {
        if (e != null)
        {
          w.a = new zu(localzs, paramBundle, (View)localObject1);
          w.post(new zv(localzs, paramBundle, (View)localObject1));
        }
        else if (f != null)
        {
          f.setOnScrollListener(new zw(localzs, paramBundle, (View)localObject1));
          f.post(new zx(localzs, paramBundle, (View)localObject1));
        }
        else
        {
          if (paramBundle != null) {
            ((ViewGroup)localObject3).removeView(paramBundle);
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    zs localzs = a;
    if ((w != null) && (w.a(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    zs localzs = a;
    if ((w != null) && (w.a(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a.a(paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     aaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */