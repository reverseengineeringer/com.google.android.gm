import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class fsl
  extends BaseAdapter
  implements frv
{
  private static final int g = fsw.a;
  public fsc a;
  public List<fyb> b = new ArrayList();
  public boolean c = true;
  public boolean d;
  public fru e;
  public boolean f = false;
  private String h;
  private fso i;
  private fsm j;
  private int k;
  private LayoutInflater l;
  private int m;
  private Context n;
  private boolean o = true;
  
  public fsl(Context paramContext, int paramInt, fso paramfso, fsm paramfsm)
  {
    n = paramContext;
    if (paramInt != -1) {}
    for (;;)
    {
      k = paramInt;
      l = LayoutInflater.from(paramContext);
      i = paramfso;
      j = paramfsm;
      paramInt = fsq.a;
      paramfso = paramContext.obtainStyledAttributes(TypedValuedata, new int[] { paramInt });
      m = paramfso.getColor(0, paramContext.getResources().getColor(fsr.a));
      paramfso.recycle();
      e = new fru(paramContext, this);
      return;
      paramInt = g;
    }
  }
  
  public static List<fyb> a(List<fyb> paramList, fyb paramfyb1, fyb paramfyb2)
  {
    String str = null;
    if (fto.a(paramfyb2)) {}
    for (paramfyb2 = paramfyb2.b();; paramfyb2 = null)
    {
      if (fto.a(paramfyb1)) {
        str = paramfyb1.b();
      }
      int i4 = -1;
      int i2 = -1;
      int i1 = 0;
      while (i1 < paramList.size())
      {
        fyb localfyb = (fyb)paramList.get(i1);
        int i6 = i4;
        int i5 = i2;
        if (fto.a(localfyb))
        {
          int i3 = i2;
          if (i2 < 0)
          {
            i3 = i2;
            if (localfyb.b().equals(paramfyb2)) {
              i3 = i1;
            }
          }
          i6 = i4;
          i5 = i3;
          if (i4 < 0)
          {
            i6 = i4;
            i5 = i3;
            if (localfyb.b().equals(str))
            {
              i6 = i1;
              i5 = i3;
            }
          }
        }
        i1 += 1;
        i4 = i6;
        i2 = i5;
      }
      if (i2 >= 0) {
        paramList.remove(i2);
      }
      if ((i4 < 0) && (str != null) && (!str.equals(paramfyb2))) {
        paramList.add(paramfyb1);
      }
      return paramList;
    }
  }
  
  private final boolean b(int paramInt)
  {
    if (c) {}
    for (int i1 = -2; (o) && (paramInt == i1 + getCount()); i1 = -1) {
      return true;
    }
    return false;
  }
  
  private final boolean c(int paramInt)
  {
    return (c) && (paramInt == getCount() - 1);
  }
  
  public final View a(View paramView, fyb paramfyb, fsc paramfsc, fso paramfso, fsm paramfsm, boolean paramBoolean, int paramInt)
  {
    if (paramView.getTag() == null)
    {
      paramfso = paramfso.a(paramView);
      paramView.setTag(paramfso);
      if ((f != null) && (paramfsc != null) && (fto.a(paramfyb)))
      {
        f.setImageDrawable(null);
        if (TextUtils.isEmpty(paramfyb.f())) {
          break label198;
        }
        paramfsc.a(f);
        paramfsc.a(f, paramfyb, 1);
      }
    }
    for (;;)
    {
      if ((d != null) && (fto.a(paramfyb)))
      {
        d.setTextColor(paramInt);
        d.setVisibility(0);
        d.setText(paramfyb.b());
        d.setContentDescription(n.getResources().getString(fsx.a, new Object[] { paramfyb.b() }));
      }
      if (paramfsm != null) {
        paramfsm.a(paramfso, paramfyb, paramBoolean, paramInt);
      }
      return paramView;
      paramfso = (fsn)paramView.getTag();
      break;
      label198:
      paramfsc.a(f);
      f.setImageBitmap(paramfsc.a(paramView.getContext(), paramfyb, 1));
    }
  }
  
  public final fyb a(int paramInt)
  {
    if ((b(paramInt)) || (c(paramInt))) {}
    while ((b == null) || (b.size() <= 0)) {
      return null;
    }
    return (fyb)b.get(paramInt);
  }
  
  public final void a(List<fyb> paramList)
  {
    f = false;
    if (paramList != null) {}
    for (paramList = new ArrayList(paramList);; paramList = null)
    {
      b = paramList;
      notifyDataSetChanged();
      return;
    }
  }
  
  public final void b(List<fyb> paramList)
  {
    if ((d) || ((paramList != null) && (paramList.size() <= 1)))
    {
      if (b == null) {
        b = new ArrayList();
      }
      b.clear();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (fyb)paramList.next();
          b.add(localObject);
        }
      }
      notifyDataSetChanged();
      return;
    }
    f = true;
    Object localObject = e;
    if (e != null)
    {
      if (f != null)
      {
        f.cancel(true);
        f = null;
      }
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label163;
      }
      e.a(null);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label163:
      b = paramList;
      c.addAll(paramList);
      f = new frw((fru)localObject);
      f.execute(new Void[0]);
    }
  }
  
  public final int getCount()
  {
    int i2 = 1;
    int i3 = 0;
    if (f) {
      return 1;
    }
    int i1;
    if (c)
    {
      i1 = 1;
      if (!o) {
        break label57;
      }
    }
    for (;;)
    {
      if (b != null) {
        i3 = b.size();
      }
      return i1 + i2 + i3;
      i1 = 0;
      break;
      label57:
      i2 = 0;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    if (c(paramInt)) {
      return -2L;
    }
    if (b(paramInt)) {
      return -1L;
    }
    if ((b != null) && (b.size() > 0))
    {
      fyb localfyb = (fyb)b.get(paramInt);
      if (fto.a(localfyb)) {
        return localfyb.b().hashCode();
      }
      return -1L;
    }
    return -1L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (f) {
      return 3;
    }
    if (c(paramInt)) {
      return 2;
    }
    if (b(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if (getItemViewType(paramInt) == 3)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = l.inflate(fsw.d, null);
        paramView = (ContentLoadingProgressBar)paramViewGroup;
        a = -1L;
        d = false;
        paramView.removeCallbacks(e);
        if (!c)
        {
          paramView.postDelayed(f, 500L);
          c = true;
        }
      }
    }
    do
    {
      do
      {
        return paramViewGroup;
        if (getItemViewType(paramInt) != 2) {
          break;
        }
        paramViewGroup = paramView;
      } while (paramView != null);
      return l.inflate(fsw.c, null);
      if (getItemViewType(paramInt) != 1) {
        break;
      }
      paramViewGroup = paramView;
    } while (paramView != null);
    return l.inflate(fsw.b, null);
    if (paramView == null) {
      paramView = l.inflate(k, null);
    }
    for (;;)
    {
      paramViewGroup = a(paramInt);
      boolean bool1 = bool2;
      if (h != null)
      {
        bool1 = bool2;
        if (fto.a(paramViewGroup)) {
          bool1 = h.equals(paramViewGroup.b());
        }
      }
      return a(paramView, paramViewGroup, a, i, j, bool1, m);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return !f;
  }
}

/* Location:
 * Qualified Name:     fsl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */