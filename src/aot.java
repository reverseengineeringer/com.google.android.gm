import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.datetimepicker.date.AccessibleDateAnimator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public final class aot
  extends aoc
  implements View.OnClickListener, aos
{
  private static SimpleDateFormat j = new SimpleDateFormat("yyyy", Locale.getDefault());
  private static SimpleDateFormat k = new SimpleDateFormat("dd", Locale.getDefault());
  private String A;
  private String B;
  final Calendar b = Calendar.getInstance();
  aow c;
  aox d;
  int e = b.getFirstDayOfWeek();
  int f = 1900;
  int g = 2100;
  aod h;
  boolean i = false;
  private HashSet<aov> l = new HashSet();
  private AccessibleDateAnimator m;
  private TextView n;
  private LinearLayout o;
  private TextView p;
  private TextView q;
  private TextView r;
  private apj s;
  private Button t;
  private int u = -1;
  private Calendar v;
  private Calendar w;
  private boolean x = true;
  private String y;
  private String z;
  
  private final void a(boolean paramBoolean)
  {
    if (n != null) {
      n.setText(b.getDisplayName(7, 2, Locale.getDefault()).toUpperCase(Locale.getDefault()));
    }
    p.setText(b.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
    q.setText(k.format(b.getTime()));
    r.setText(j.format(b.getTime()));
    long l1 = b.getTimeInMillis();
    m.a = l1;
    String str = DateUtils.formatDateTime(getActivity(), l1, 24);
    o.setContentDescription(str);
    if (paramBoolean)
    {
      str = DateUtils.formatDateTime(getActivity(), l1, 20);
      aom.a(m, str);
    }
  }
  
  private final void b(int paramInt)
  {
    long l1 = b.getTimeInMillis();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localObject1 = aom.a(o, 0.9F, 1.05F);
      if (x)
      {
        ((ObjectAnimator)localObject1).setStartDelay(500L);
        x = false;
      }
      d.a();
      if (u != paramInt)
      {
        o.setSelected(true);
        r.setSelected(false);
        m.setDisplayedChild(0);
        u = paramInt;
      }
      ((ObjectAnimator)localObject1).start();
      localObject1 = DateUtils.formatDateTime(getActivity(), l1, 16);
      localObject2 = m;
      str = y;
      ((AccessibleDateAnimator)localObject2).setContentDescription(String.valueOf(str).length() + 2 + String.valueOf(localObject1).length() + str + ": " + (String)localObject1);
      aom.a(m, z);
      return;
    }
    Object localObject1 = aom.a(r, 0.85F, 1.1F);
    if (x)
    {
      ((ObjectAnimator)localObject1).setStartDelay(500L);
      x = false;
    }
    s.a();
    if (u != paramInt)
    {
      o.setSelected(false);
      r.setSelected(true);
      m.setDisplayedChild(1);
      u = paramInt;
    }
    ((ObjectAnimator)localObject1).start();
    String str = j.format(Long.valueOf(l1));
    localObject1 = m;
    Object localObject2 = A;
    str = String.valueOf(str);
    ((AccessibleDateAnimator)localObject1).setContentDescription(String.valueOf(localObject2).length() + 2 + String.valueOf(str).length() + (String)localObject2 + ": " + str);
    aom.a(m, B);
  }
  
  private final void h()
  {
    Iterator localIterator = l.iterator();
    while (localIterator.hasNext()) {
      ((aov)localIterator.next()).a();
    }
  }
  
  public final apb a()
  {
    return new apb(b);
  }
  
  public final void a(int paramInt)
  {
    int i2 = b.get(2);
    int i1 = b.get(5);
    i2 = aom.a(i2, paramInt);
    if (i1 > i2) {
      b.set(5, i2);
    }
    b.set(1, paramInt);
    h();
    b(0);
    a(true);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b.set(1, paramInt1);
    b.set(2, paramInt2);
    b.set(5, paramInt3);
    h();
    a(true);
  }
  
  public final void a(aov paramaov)
  {
    l.add(paramaov);
  }
  
  public final void a(Calendar paramCalendar)
  {
    v = paramCalendar;
    if (d != null) {
      d.b();
    }
  }
  
  public final int b()
  {
    return e;
  }
  
  public final void b(Calendar paramCalendar)
  {
    w = paramCalendar;
    if (d != null) {
      d.b();
    }
  }
  
  public final int c()
  {
    return f;
  }
  
  public final int d()
  {
    return g;
  }
  
  public final Calendar e()
  {
    return v;
  }
  
  public final Calendar f()
  {
    return w;
  }
  
  public final void g()
  {
    h.c();
  }
  
  public final void onClick(View paramView)
  {
    h.c();
    if (paramView.getId() == aoj.h) {
      b(1);
    }
    while (paramView.getId() != aoj.g) {
      return;
    }
    b(0);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActivity().getWindow().setSoftInputMode(3);
    if (paramBundle != null)
    {
      b.set(1, paramBundle.getInt("year"));
      b.set(2, paramBundle.getInt("month"));
      b.set(5, paramBundle.getInt("day"));
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    Fragment localFragment = getTargetFragment();
    if ((localFragment instanceof aor)) {
      c = new aoq((aor)localFragment);
    }
    return paramBundle;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    paramLayoutInflater = paramLayoutInflater.inflate(aok.a, null);
    n = ((TextView)paramLayoutInflater.findViewById(aoj.e));
    o = ((LinearLayout)paramLayoutInflater.findViewById(aoj.g));
    o.setOnClickListener(this);
    p = ((TextView)paramLayoutInflater.findViewById(aoj.f));
    q = ((TextView)paramLayoutInflater.findViewById(aoj.d));
    r = ((TextView)paramLayoutInflater.findViewById(aoj.h));
    r.setOnClickListener(this);
    int i3 = -1;
    int i2 = 0;
    int i1 = 0;
    if (paramBundle != null)
    {
      e = paramBundle.getInt("week_start");
      f = paramBundle.getInt("year_start");
      g = paramBundle.getInt("year_end");
      int i4 = paramBundle.getInt("current_view");
      int i5 = paramBundle.getInt("list_position");
      int i6 = paramBundle.getInt("list_position_offset");
      if (paramBundle.containsKey("min_date"))
      {
        paramViewGroup = Calendar.getInstance();
        paramViewGroup.setTimeInMillis(paramBundle.getLong("min_date"));
        a(paramViewGroup);
      }
      i1 = i4;
      i2 = i6;
      i3 = i5;
      if (paramBundle.containsKey("max_date"))
      {
        paramViewGroup = Calendar.getInstance();
        paramViewGroup.setTimeInMillis(paramBundle.getLong("max_date"));
        b(paramViewGroup);
        i3 = i5;
        i2 = i6;
        i1 = i4;
      }
    }
    paramViewGroup = getActivity();
    d = new apg(paramViewGroup, this);
    paramBundle = d;
    boolean bool = i;
    if (i != null) {
      i.b = bool;
    }
    s = new apj(paramViewGroup, this);
    paramBundle = getResources();
    y = paramBundle.getString(aol.e);
    z = paramBundle.getString(aol.o);
    A = paramBundle.getString(aol.x);
    B = paramBundle.getString(aol.r);
    m = ((AccessibleDateAnimator)paramLayoutInflater.findViewById(aoj.c));
    m.addView(d);
    m.addView(s);
    m.a = b.getTimeInMillis();
    paramBundle = new AlphaAnimation(0.0F, 1.0F);
    paramBundle.setDuration(300L);
    m.setInAnimation(paramBundle);
    paramBundle = new AlphaAnimation(1.0F, 0.0F);
    paramBundle.setDuration(300L);
    m.setOutAnimation(paramBundle);
    t = ((Button)paramLayoutInflater.findViewById(aoj.i));
    t.setOnClickListener(new aou(this));
    a(false);
    b(i1);
    if (i3 != -1)
    {
      if (i1 != 0) {
        break label545;
      }
      d.a(i3);
    }
    for (;;)
    {
      h = new aod(paramViewGroup);
      return paramLayoutInflater;
      label545:
      if (i1 == 1) {
        s.a(i3, i2);
      }
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    h.b();
  }
  
  public final void onResume()
  {
    super.onResume();
    h.a();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("year", b.get(1));
    paramBundle.putInt("month", b.get(2));
    paramBundle.putInt("day", b.get(5));
    paramBundle.putInt("week_start", e);
    paramBundle.putInt("year_start", f);
    paramBundle.putInt("year_end", g);
    paramBundle.putInt("current_view", u);
    int i1 = -1;
    Object localObject;
    int i6;
    int i3;
    int i2;
    if (u == 0)
    {
      localObject = d;
      i6 = ((aox)localObject).getFirstVisiblePosition();
      int i7 = ((aox)localObject).getHeight();
      int i4 = 0;
      i1 = 0;
      i3 = 0;
      i2 = 0;
      if (i4 < i7)
      {
        View localView = ((aox)localObject).getChildAt(i1);
        if (localView != null)
        {
          i4 = localView.getBottom();
          int i5 = Math.min(i4, i7) - Math.max(0, localView.getTop());
          if (i5 <= i2) {
            break label310;
          }
          i3 = i1;
          i2 = i5;
        }
      }
    }
    label310:
    for (;;)
    {
      i1 += 1;
      break;
      i1 = i3 + i6;
      do
      {
        paramBundle.putInt("list_position", i1);
        if (v != null) {
          paramBundle.putLong("min_date", v.getTimeInMillis());
        }
        if (w != null) {
          paramBundle.putLong("max_date", w.getTimeInMillis());
        }
        return;
      } while (u != 1);
      i2 = s.getFirstVisiblePosition();
      localObject = s.getChildAt(0);
      if (localObject == null) {}
      for (i1 = 0;; i1 = ((View)localObject).getTop())
      {
        paramBundle.putInt("list_position_offset", i1);
        i1 = i2;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     aot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */