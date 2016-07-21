import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.android.datetimepicker.time.RadialPickerLayout;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public final class aqb
  extends aoc
  implements apq
{
  private int A;
  private int B;
  private String C;
  private String D;
  private String E;
  private String F;
  public aqi b;
  aod c;
  RadialPickerLayout d;
  String e;
  String f;
  public int g;
  public int h;
  public boolean i;
  public boolean j;
  String k;
  public boolean l;
  ArrayList<Integer> m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private View t;
  private int u;
  private int v;
  private boolean w;
  private char x;
  private String y;
  private aqh z;
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (i) {
      localObject = "%02d";
    }
    for (;;)
    {
      localObject = String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) });
      o.setText((CharSequence)localObject);
      p.setText((CharSequence)localObject);
      if (paramBoolean) {
        aom.a(d, (CharSequence)localObject);
      }
      return;
      String str = "%d";
      int i1 = paramInt % 12;
      localObject = str;
      paramInt = i1;
      if (i1 == 0)
      {
        paramInt = 12;
        localObject = str;
      }
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i2 = 255;
    Object localObject1 = d;
    int i1;
    Object localObject2;
    if ((paramInt != 0) && (paramInt != 1))
    {
      Log.e("RadialPickerLayout", 53 + "TimePicker does not support view at index " + paramInt);
      if (paramInt != 0) {
        break label489;
      }
      i2 = d.c;
      i1 = i2;
      if (!i) {
        i1 = i2 % 12;
      }
      localObject1 = d;
      localObject2 = C;
      ((RadialPickerLayout)localObject1).setContentDescription(String.valueOf(localObject2).length() + 13 + (String)localObject2 + ": " + i1);
      if (paramBoolean3) {
        aom.a(d, D);
      }
      localObject1 = o;
      label153:
      if (paramInt != 0) {
        break label576;
      }
      i1 = u;
      label163:
      if (paramInt != 1) {
        break label585;
      }
    }
    label425:
    label483:
    label489:
    label576:
    label585:
    for (paramInt = u;; paramInt = v)
    {
      o.setTextColor(i1);
      q.setTextColor(paramInt);
      localObject1 = aom.a((View)localObject1, 0.85F, 1.1F);
      if (paramBoolean2) {
        ((ObjectAnimator)localObject1).setStartDelay(300L);
      }
      ((ObjectAnimator)localObject1).start();
      return;
      i1 = ((RadialPickerLayout)localObject1).b();
      e = paramInt;
      if ((paramBoolean1) && (paramInt != i1))
      {
        localObject2 = new ObjectAnimator[4];
        if (paramInt == 1)
        {
          localObject2[0] = h.a();
          localObject2[1] = j.a();
          localObject2[2] = i.b();
          localObject2[3] = k.b();
        }
        for (;;)
        {
          if ((o != null) && (o.isRunning())) {
            o.end();
          }
          o = new AnimatorSet();
          o.playTogether((Animator[])localObject2);
          o.start();
          break;
          if (paramInt == 0)
          {
            localObject2[0] = h.b();
            localObject2[1] = j.b();
            localObject2[2] = i.a();
            localObject2[3] = k.a();
          }
        }
      }
      if (paramInt == 0)
      {
        i1 = 255;
        if (paramInt != 1) {
          break label483;
        }
      }
      for (;;)
      {
        h.setAlpha(i1);
        j.setAlpha(i1);
        i.setAlpha(i2);
        k.setAlpha(i2);
        break;
        i1 = 0;
        break label425;
        i2 = 0;
      }
      i1 = d.d;
      localObject1 = d;
      localObject2 = E;
      ((RadialPickerLayout)localObject1).setContentDescription(String.valueOf(localObject2).length() + 13 + (String)localObject2 + ": " + i1);
      if (paramBoolean3) {
        aom.a(d, F);
      }
      localObject1 = q;
      break label153;
      i1 = v;
      break label163;
    }
  }
  
  private final int[] a(Boolean[] paramArrayOfBoolean)
  {
    int i1;
    int i2;
    int i4;
    if ((!i) && (a()))
    {
      i1 = ((Integer)m.get(m.size() - 1)).intValue();
      if (i1 == e(0))
      {
        i1 = 0;
        i2 = 2;
        i4 = i1;
        i1 = i2;
      }
    }
    for (;;)
    {
      int i7 = -1;
      int i6 = -1;
      int i5 = i1;
      label64:
      if (i5 <= m.size())
      {
        int i8 = d(((Integer)m.get(m.size() - i5)).intValue());
        int i3;
        if (i5 == i1)
        {
          i3 = i8;
          i2 = i7;
        }
        for (;;)
        {
          i5 += 1;
          i7 = i2;
          i6 = i3;
          break label64;
          if (i1 != e(1)) {
            break label307;
          }
          i1 = 1;
          break;
          if (i5 == i1 + 1)
          {
            i6 += i8 * 10;
            i2 = i7;
            i3 = i6;
            if (paramArrayOfBoolean != null)
            {
              i2 = i7;
              i3 = i6;
              if (i8 == 0)
              {
                paramArrayOfBoolean[1] = Boolean.valueOf(true);
                i2 = i7;
                i3 = i6;
              }
            }
          }
          else if (i5 == i1 + 2)
          {
            i2 = i8;
            i3 = i6;
          }
          else
          {
            i2 = i7;
            i3 = i6;
            if (i5 == i1 + 3)
            {
              i7 += i8 * 10;
              i2 = i7;
              i3 = i6;
              if (paramArrayOfBoolean != null)
              {
                i2 = i7;
                i3 = i6;
                if (i8 == 0)
                {
                  paramArrayOfBoolean[0] = Boolean.valueOf(true);
                  i2 = i7;
                  i3 = i6;
                }
              }
            }
          }
        }
      }
      return new int[] { i7, i6, i4 };
      label307:
      i1 = -1;
      break;
      i1 = 1;
      i4 = -1;
    }
  }
  
  static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 7: 
      return 0;
    case 8: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    case 11: 
      return 4;
    case 12: 
      return 5;
    case 13: 
      return 6;
    case 14: 
      return 7;
    case 15: 
      return 8;
    }
    return 9;
  }
  
  private final void f(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 60) {
      i1 = 0;
    }
    String str = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(i1) });
    aom.a(d, str);
    q.setText(str);
    r.setText(str);
  }
  
  final void a(int paramInt)
  {
    if (paramInt == 0)
    {
      s.setText(e);
      aom.a(d, e);
      t.setContentDescription(e);
      return;
    }
    if (paramInt == 1)
    {
      s.setText(f);
      aom.a(d, f);
      t.setContentDescription(f);
      return;
    }
    s.setText(y);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 0)
    {
      a(paramInt2, false);
      localObject1 = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      if ((w) && (paramBoolean))
      {
        a(1, true, true, false);
        localObject1 = String.valueOf(localObject1);
        localObject2 = F;
        localObject1 = String.valueOf(localObject1).length() + 2 + String.valueOf(localObject2).length() + (String)localObject1 + ". " + (String)localObject2;
        aom.a(d, (CharSequence)localObject1);
      }
    }
    do
    {
      return;
      localObject2 = d;
      String str = C;
      ((RadialPickerLayout)localObject2).setContentDescription(String.valueOf(str).length() + 13 + str + ": " + paramInt2);
      break;
      if (paramInt1 == 1)
      {
        f(paramInt2);
        localObject1 = d;
        localObject2 = E;
        ((RadialPickerLayout)localObject1).setContentDescription(String.valueOf(localObject2).length() + 13 + (String)localObject2 + ": " + paramInt2);
        return;
      }
      if (paramInt1 == 2)
      {
        a(paramInt2);
        return;
      }
    } while (paramInt1 != 3);
    if (!a()) {
      m.clear();
    }
    a(true);
  }
  
  final void a(boolean paramBoolean)
  {
    l = false;
    if (!m.isEmpty())
    {
      int[] arrayOfInt = a(null);
      RadialPickerLayout localRadialPickerLayout = d;
      int i1 = arrayOfInt[0];
      int i2 = arrayOfInt[1];
      localRadialPickerLayout.a(0, i1);
      localRadialPickerLayout.a(1, i2);
      if (!i) {
        d.a(arrayOfInt[2]);
      }
      m.clear();
    }
    if (paramBoolean)
    {
      b(false);
      d.a(true);
    }
  }
  
  final boolean a()
  {
    if (i)
    {
      arrayOfInt = a(null);
      if ((arrayOfInt[0] < 0) || (arrayOfInt[1] < 0) || (arrayOfInt[1] >= 60)) {}
    }
    while ((m.contains(Integer.valueOf(e(0)))) || (m.contains(Integer.valueOf(e(1)))))
    {
      int[] arrayOfInt;
      return true;
      return false;
    }
    return false;
  }
  
  final int b()
  {
    int i1 = ((Integer)m.remove(m.size() - 1)).intValue();
    if (!a()) {
      n.setEnabled(false);
    }
    return i1;
  }
  
  final void b(int paramInt)
  {
    if ((d.a(false)) && ((paramInt == -1) || (c(paramInt))))
    {
      l = true;
      n.setEnabled(false);
      b(false);
    }
  }
  
  final void b(boolean paramBoolean)
  {
    int i1 = 0;
    if ((!paramBoolean) && (m.isEmpty()))
    {
      int i2 = d.c;
      int i3 = d.d;
      a(i2, true);
      f(i3);
      if (!i) {
        if (i2 >= 12) {
          break label86;
        }
      }
      for (;;)
      {
        a(i1);
        a(d.b(), true, true, true);
        n.setEnabled(true);
        return;
        label86:
        i1 = 1;
      }
    }
    Object localObject = new Boolean[2];
    localObject[0] = Boolean.valueOf(false);
    localObject[1] = Boolean.valueOf(false);
    int[] arrayOfInt = a((Boolean[])localObject);
    String str;
    if (localObject[0].booleanValue())
    {
      str = "%02d";
      label135:
      if (!localObject[1].booleanValue()) {
        break label259;
      }
      localObject = "%02d";
      label149:
      if (arrayOfInt[0] != -1) {
        break label267;
      }
      str = y;
      label163:
      if (arrayOfInt[1] != -1) {
        break label300;
      }
    }
    label259:
    label267:
    label300:
    for (localObject = y;; localObject = String.format((String)localObject, new Object[] { Integer.valueOf(arrayOfInt[1]) }).replace(' ', x))
    {
      o.setText(str);
      p.setText(str);
      o.setTextColor(v);
      q.setText((CharSequence)localObject);
      r.setText((CharSequence)localObject);
      q.setTextColor(v);
      if (i) {
        break;
      }
      a(arrayOfInt[2]);
      return;
      str = "%2d";
      break label135;
      localObject = "%2d";
      break label149;
      str = String.format(str, new Object[] { Integer.valueOf(arrayOfInt[0]) }).replace(' ', x);
      break label163;
    }
  }
  
  final boolean c(int paramInt)
  {
    if (((i) && (m.size() == 4)) || ((!i) && (a()))) {
      return false;
    }
    m.add(Integer.valueOf(paramInt));
    aqh localaqh = z;
    Iterator localIterator1 = m.iterator();
    if (localIterator1.hasNext())
    {
      int i2 = ((Integer)localIterator1.next()).intValue();
      if (b != null)
      {
        Iterator localIterator2 = b.iterator();
        label103:
        if (localIterator2.hasNext())
        {
          localaqh = (aqh)localIterator2.next();
          i1 = 0;
          label127:
          if (i1 < a.length) {
            if (a[i1] == i2)
            {
              i1 = 1;
              label150:
              if (i1 == 0) {
                break label182;
              }
              label154:
              if (localaqh != null) {
                break label190;
              }
            }
          }
        }
      }
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0) {
        break label198;
      }
      b();
      return false;
      i1 += 1;
      break label127;
      i1 = 0;
      break label150;
      label182:
      break label103;
      localaqh = null;
      break label154;
      label190:
      break;
    }
    label198:
    paramInt = d(paramInt);
    aom.a(d, String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
    if (a())
    {
      if ((!i) && (m.size() <= 3))
      {
        m.add(m.size() - 1, Integer.valueOf(7));
        m.add(m.size() - 1, Integer.valueOf(7));
      }
      n.setEnabled(true);
    }
    return true;
  }
  
  final int e(int paramInt)
  {
    Object localObject;
    int i3;
    if ((A == -1) || (B == -1))
    {
      localObject = KeyCharacterMap.load(-1);
      i3 = 0;
    }
    for (;;)
    {
      if (i3 < Math.max(e.length(), f.length()))
      {
        int i1 = e.toLowerCase(Locale.getDefault()).charAt(i3);
        int i2 = f.toLowerCase(Locale.getDefault()).charAt(i3);
        if (i1 == i2) {
          break label158;
        }
        localObject = ((KeyCharacterMap)localObject).getEvents(new char[] { i1, i2 });
        if ((localObject == null) || (localObject.length != 4)) {
          break label145;
        }
        A = localObject[0].getKeyCode();
        B = localObject[2].getKeyCode();
      }
      while (paramInt == 0)
      {
        return A;
        label145:
        Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
      }
      label158:
      i3 += 1;
    }
    if (paramInt == 1) {
      return B;
    }
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("hour_of_day")) && (paramBundle.containsKey("minute")) && (paramBundle.containsKey("is_24_hour_view")))
    {
      g = paramBundle.getInt("hour_of_day");
      h = paramBundle.getInt("minute");
      i = paramBundle.getBoolean("is_24_hour_view");
      l = paramBundle.getBoolean("in_kb_mode");
      j = paramBundle.getBoolean("dark_theme");
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    Fragment localFragment = getTargetFragment();
    if ((localFragment instanceof aqa)) {
      b = new apz((aqa)localFragment);
    }
    return paramBundle;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    View localView = paramLayoutInflater.inflate(aok.b, null);
    paramLayoutInflater = new aqg(this);
    localView.findViewById(aoj.t).setOnKeyListener(paramLayoutInflater);
    paramViewGroup = getResources();
    C = paramViewGroup.getString(aol.g);
    D = paramViewGroup.getString(aol.p);
    E = paramViewGroup.getString(aol.i);
    F = paramViewGroup.getString(aol.q);
    label126:
    Object localObject1;
    int i2;
    Object localObject2;
    aqh localaqh1;
    label1066:
    label1096:
    label1158:
    label1221:
    int i7;
    int i9;
    int i5;
    int i3;
    int i6;
    int i4;
    if (j)
    {
      i1 = aog.m;
      u = paramViewGroup.getColor(i1);
      if (!j) {
        break label1552;
      }
      i1 = 17170443;
      v = paramViewGroup.getColor(i1);
      o = ((TextView)localView.findViewById(aoj.l));
      o.setOnKeyListener(paramLayoutInflater);
      p = ((TextView)localView.findViewById(aoj.k));
      r = ((TextView)localView.findViewById(aoj.o));
      q = ((TextView)localView.findViewById(aoj.n));
      q.setOnKeyListener(paramLayoutInflater);
      s = ((TextView)localView.findViewById(aoj.b));
      s.setOnKeyListener(paramLayoutInflater);
      localObject1 = new DateFormatSymbols().getAmPmStrings();
      e = localObject1[0];
      f = localObject1[1];
      c = new aod(getActivity());
      d = ((RadialPickerLayout)localView.findViewById(aoj.s));
      d.b = this;
      d.setOnKeyListener(paramLayoutInflater);
      d.a(getActivity(), c, g, h, i);
      i2 = 0;
      i1 = i2;
      if (paramBundle != null)
      {
        i1 = i2;
        if (paramBundle.containsKey("current_item_showing")) {
          i1 = paramBundle.getInt("current_item_showing");
        }
      }
      a(i1, false, true, true);
      d.invalidate();
      o.setOnClickListener(new aqc(this));
      q.setOnClickListener(new aqd(this));
      n = ((TextView)localView.findViewById(aoj.j));
      n.setOnClickListener(new aqe(this));
      n.setOnKeyListener(paramLayoutInflater);
      t = localView.findViewById(aoj.a);
      if (!i) {
        break label1560;
      }
      s.setVisibility(8);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
      paramLayoutInflater.addRule(13);
      ((TextView)localView.findViewById(aoj.p)).setLayoutParams(paramLayoutInflater);
      w = true;
      a(g, true);
      f(h);
      y = paramViewGroup.getString(aol.w);
      k = paramViewGroup.getString(aol.f);
      x = y.charAt(0);
      B = -1;
      A = -1;
      z = new aqh(this, new int[0]);
      if (!i) {
        break label1610;
      }
      paramLayoutInflater = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12 });
      localObject1 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
      paramLayoutInflater.a((aqh)localObject1);
      localObject2 = new aqh(this, new int[] { 7, 8 });
      z.a((aqh)localObject2);
      localaqh1 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a(paramLayoutInflater);
      localaqh1.a(new aqh(this, new int[] { 13, 14, 15, 16 }));
      localaqh1 = new aqh(this, new int[] { 13, 14, 15, 16 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a(paramLayoutInflater);
      localObject2 = new aqh(this, new int[] { 9 });
      z.a((aqh)localObject2);
      localaqh1 = new aqh(this, new int[] { 7, 8, 9, 10 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a(paramLayoutInflater);
      localaqh1 = new aqh(this, new int[] { 11, 12 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a((aqh)localObject1);
      localObject1 = new aqh(this, new int[] { 10, 11, 12, 13, 14, 15, 16 });
      z.a((aqh)localObject1);
      ((aqh)localObject1).a(paramLayoutInflater);
      if (!l) {
        break label2218;
      }
      m = paramBundle.getIntegerArrayList("typed_times");
      b(-1);
      o.invalidate();
      paramLayoutInflater = d;
      paramBundle = getActivity().getApplicationContext();
      boolean bool = j;
      localObject1 = f;
      localObject2 = paramBundle.getResources();
      if (!bool) {
        break label2239;
      }
      b = ((Resources)localObject2).getColor(aog.d);
      c = ((Resources)localObject2).getColor(aog.i);
      localObject1 = g;
      localObject2 = paramBundle.getResources();
      if (!bool) {
        break label2268;
      }
      c = ((Resources)localObject2).getColor(aog.d);
      e = ((Resources)localObject2).getColor(aog.m);
      d = ((Resources)localObject2).getColor(17170443);
      b = 102;
      h.a(paramBundle, bool);
      i.a(paramBundle, bool);
      j.a(paramBundle, bool);
      k.a(paramBundle, bool);
      i1 = paramViewGroup.getColor(17170443);
      i7 = paramViewGroup.getColor(aog.c);
      i9 = paramViewGroup.getColor(aog.j);
      i2 = paramViewGroup.getColor(aog.l);
      paramLayoutInflater = paramViewGroup.getColorStateList(aog.g);
      i5 = aoi.a;
      i3 = paramViewGroup.getColor(aog.d);
      int i8 = paramViewGroup.getColor(aog.i);
      int i10 = paramViewGroup.getColor(aog.k);
      paramViewGroup = paramViewGroup.getColorStateList(aog.h);
      i6 = aoi.b;
      paramBundle = localView.findViewById(aoj.r);
      if (!j) {
        break label2317;
      }
      i4 = i3;
      label1370:
      paramBundle.setBackgroundColor(i4);
      paramBundle = localView.findViewById(aoj.q);
      if (!j) {
        break label2324;
      }
      label1392:
      paramBundle.setBackgroundColor(i3);
      paramBundle = (TextView)localView.findViewById(aoj.p);
      if (!j) {
        break label2331;
      }
      i3 = i1;
      label1421:
      paramBundle.setTextColor(i3);
      paramBundle = (TextView)localView.findViewById(aoj.b);
      if (!j) {
        break label2338;
      }
      label1446:
      paramBundle.setTextColor(i1);
      paramBundle = localView.findViewById(aoj.m);
      if (!j) {
        break label2345;
      }
      i1 = i10;
      label1472:
      paramBundle.setBackgroundColor(i1);
      paramBundle = n;
      if (!j) {
        break label2352;
      }
      paramLayoutInflater = paramViewGroup;
      label1492:
      paramBundle.setTextColor(paramLayoutInflater);
      paramLayoutInflater = d;
      if (!j) {
        break label2355;
      }
      i1 = i8;
      label1513:
      paramLayoutInflater.setBackgroundColor(i1);
      paramLayoutInflater = n;
      if (!j) {
        break label2362;
      }
    }
    label1552:
    label1560:
    label1610:
    label2218:
    label2239:
    label2268:
    label2317:
    label2324:
    label2331:
    label2338:
    label2345:
    label2352:
    label2355:
    label2362:
    for (int i1 = i6;; i1 = i5)
    {
      paramLayoutInflater.setBackgroundResource(i1);
      return localView;
      i1 = aog.b;
      break;
      i1 = aog.l;
      break label126;
      s.setVisibility(0);
      if (g < 12) {}
      for (i1 = 0;; i1 = 1)
      {
        a(i1);
        t.setOnClickListener(new aqf(this));
        break;
      }
      paramLayoutInflater = new aqh(this, new int[] { e(0), e(1) });
      localObject1 = new aqh(this, new int[] { 8 });
      z.a((aqh)localObject1);
      ((aqh)localObject1).a(paramLayoutInflater);
      localObject2 = new aqh(this, new int[] { 7, 8, 9 });
      ((aqh)localObject1).a((aqh)localObject2);
      ((aqh)localObject2).a(paramLayoutInflater);
      localaqh1 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a(paramLayoutInflater);
      aqh localaqh2 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
      localaqh1.a(localaqh2);
      localaqh2.a(paramLayoutInflater);
      localaqh1 = new aqh(this, new int[] { 13, 14, 15, 16 });
      ((aqh)localObject2).a(localaqh1);
      localaqh1.a(paramLayoutInflater);
      localObject2 = new aqh(this, new int[] { 10, 11, 12 });
      ((aqh)localObject1).a((aqh)localObject2);
      localObject1 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
      ((aqh)localObject2).a((aqh)localObject1);
      ((aqh)localObject1).a(paramLayoutInflater);
      localObject2 = new aqh(this, new int[] { 9, 10, 11, 12, 13, 14, 15, 16 });
      z.a((aqh)localObject2);
      ((aqh)localObject2).a(paramLayoutInflater);
      localObject1 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12 });
      ((aqh)localObject2).a((aqh)localObject1);
      localObject2 = new aqh(this, new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
      ((aqh)localObject1).a((aqh)localObject2);
      ((aqh)localObject2).a(paramLayoutInflater);
      break label1066;
      if (m != null) {
        break label1096;
      }
      m = new ArrayList();
      break label1096;
      b = ((Resources)localObject2).getColor(17170443);
      c = ((Resources)localObject2).getColor(aog.l);
      break label1158;
      c = ((Resources)localObject2).getColor(17170443);
      e = ((Resources)localObject2).getColor(aog.b);
      d = ((Resources)localObject2).getColor(aog.a);
      b = 51;
      break label1221;
      i4 = i1;
      break label1370;
      i3 = i1;
      break label1392;
      i3 = i2;
      break label1421;
      i1 = i2;
      break label1446;
      i1 = i9;
      break label1472;
      break label1492;
      i1 = i7;
      break label1513;
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    c.b();
  }
  
  public final void onResume()
  {
    super.onResume();
    c.a();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (d != null)
    {
      paramBundle.putInt("hour_of_day", d.c);
      paramBundle.putInt("minute", d.d);
      paramBundle.putBoolean("is_24_hour_view", i);
      paramBundle.putInt("current_item_showing", d.b());
      paramBundle.putBoolean("in_kb_mode", l);
      if (l) {
        paramBundle.putIntegerArrayList("typed_times", m);
      }
      paramBundle.putBoolean("dark_theme", j);
    }
  }
}

/* Location:
 * Qualified Name:     aqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */