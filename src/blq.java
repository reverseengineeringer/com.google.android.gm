import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.android.ex.photo.PhotoViewPager;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class blq
  implements blh, bln, bmd, gp<Cursor>, su
{
  public static int a;
  public static int b;
  public boolean A;
  public boolean B;
  public bma C;
  public final Handler D = new Handler();
  private final View.OnSystemUiVisibilityChangeListener E;
  private String F;
  private int G;
  private String[] H;
  private final Map<Integer, blp> I = new HashMap();
  private final Set<blo> J = new HashSet();
  private boolean K;
  private final AccessibilityManager L;
  private long M;
  private int N = -1;
  private final Runnable O = new bls(this);
  public final blz c;
  int d;
  String e;
  String f;
  public int g = -1;
  public boolean h;
  public View i;
  public View j;
  public PhotoViewPager k;
  public ImageView l;
  public bmq m;
  public boolean n;
  boolean o;
  public boolean p = true;
  public float q;
  public String r;
  public String s;
  boolean t;
  public boolean u;
  public int v;
  public int w;
  public int x;
  public int y;
  public boolean z;
  
  public blq(blz paramblz)
  {
    c = paramblz;
    if (Build.VERSION.SDK_INT < 11) {}
    for (E = null;; E = new blr(this))
    {
      L = ((AccessibilityManager)paramblz.i().getSystemService("accessibility"));
      return;
    }
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    return paramInt1 - Math.round((paramInt3 - paramInt3 * paramFloat) / 2.0F) - Math.round((paramInt3 * paramFloat - paramInt2) / 2.0F);
  }
  
  private static final String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private final void a(Cursor paramCursor)
  {
    try
    {
      Iterator localIterator = J.iterator();
      while (localIterator.hasNext()) {
        ((blo)localIterator.next()).a(paramCursor);
      }
    }
    finally {}
  }
  
  private final void a(blg paramblg)
  {
    if (paramblg == null) {
      return;
    }
    paramblg.a(a(r));
    paramblg.b(a(s));
  }
  
  private final void o()
  {
    if (z) {
      D.postDelayed(O, M);
    }
  }
  
  private final void p()
  {
    D.removeCallbacks(O);
  }
  
  public final int a(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = I.values().iterator();
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2;
    if (localIterator.hasNext())
    {
      blp localblp = (blp)localIterator.next();
      bool2 = bool3;
      if (!bool3) {
        bool2 = localblp.l_();
      }
      if (bool1) {
        break label109;
      }
      bool1 = localblp.m_();
    }
    label109:
    for (;;)
    {
      bool3 = bool2;
      break;
      if (bool3)
      {
        if (bool1) {
          return bmc.d;
        }
        return bmc.b;
      }
      if (bool1) {
        return bmc.c;
      }
      return bmc.a;
    }
  }
  
  public final jy<Cursor> a(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 100) {
      return new bmw(c.i(), Uri.parse(F), H);
    }
    return null;
  }
  
  public final jy<bmv> a(String paramString)
  {
    switch (paramString)
    {
    default: 
      return null;
    }
    String str;
    return new bmt(c.i(), str);
  }
  
  public final void a()
  {
    if (!n) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, true);
      return;
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < 1.0E-4D)
    {
      blp localblp = (blp)I.get(Integer.valueOf(paramInt1 - 1));
      if (localblp != null) {
        localblp.j_();
      }
      localblp = (blp)I.get(Integer.valueOf(paramInt1 + 1));
      if (localblp != null) {
        localblp.j_();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt, blp paramblp)
  {
    I.put(Integer.valueOf(paramInt), paramblp);
  }
  
  public final void a(blo paramblo)
  {
    try
    {
      J.add(paramblo);
      return;
    }
    finally
    {
      paramblo = finally;
      throw paramblo;
    }
  }
  
  public void a(bmr parambmr) {}
  
  public void a(bmr parambmr, Cursor paramCursor) {}
  
  public final void a(bmr parambmr, boolean paramBoolean)
  {
    if ((f()) && (l.getVisibility() != 8) && (TextUtils.equals(a, f)))
    {
      if (!paramBoolean) {
        break label75;
      }
      if (f()) {
        l.setVisibility(8);
      }
      k.setVisibility(0);
    }
    for (;;)
    {
      c.x_().a(2);
      return;
      label75:
      Log.w("PhotoViewController", "Failed to load fragment image");
      if (f()) {
        l.setVisibility(8);
      }
      k.setVisibility(0);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      p();
      return;
    }
    o();
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    int i5 = 0;
    int i6 = 0;
    int i4 = 0;
    if (bnh.a(L))
    {
      paramBoolean2 = false;
      paramBoolean1 = false;
    }
    int i2;
    if (paramBoolean1 != n)
    {
      i2 = 1;
      n = paramBoolean1;
      if (!n) {
        break label367;
      }
      i6 = Build.VERSION.SDK_INT;
      if (i6 >= 16) {
        break label117;
      }
      i3 = 1;
    }
    label117:
    int i1;
    for (;;)
    {
      if ((!u) || (t))
      {
        if (i6 <= 19)
        {
          if (i6 != 19) {
            break label247;
          }
          if (Build.VERSION.SDK_INT != 19)
          {
            throw new IllegalStateException("kitkatIsSecondary user is only callable on KitKat");
            i2 = 0;
            break;
            i3 = 0;
            continue;
          }
          if (Process.myUid() <= 100000) {
            break label242;
          }
          i1 = 1;
          if (i1 != 0) {
            break label247;
          }
        }
        i1 = 3846;
        for (;;)
        {
          i4 = i1;
          if (i3 != 0)
          {
            c.j().d();
            i4 = i1;
          }
          if (i6 >= 11)
          {
            d = i4;
            i.setSystemUiVisibility(i4);
          }
          p();
          if (i2 == 0) {
            return;
          }
          Iterator localIterator = I.values().iterator();
          while (localIterator.hasNext()) {
            ((blp)localIterator.next()).c();
          }
          label242:
          i1 = 0;
          break;
          label247:
          if (i6 >= 16)
          {
            i1 = 1285;
          }
          else if (i6 >= 14)
          {
            i1 = 1;
          }
          else
          {
            i1 = i4;
            if (i6 >= 11) {
              i1 = 1;
            }
          }
        }
      }
    }
    if (i6 >= 19) {
      i1 = 1792;
    }
    for (;;)
    {
      i4 = i1;
      if (i3 == 0) {
        break;
      }
      c.j().c();
      i4 = i1;
      break;
      if (i6 >= 16)
      {
        i1 = 1280;
      }
      else
      {
        i1 = i5;
        if (i6 < 14)
        {
          i1 = i5;
          if (i6 >= 11) {
            i1 = i5;
          }
        }
      }
    }
    label367:
    i4 = Build.VERSION.SDK_INT;
    if (i4 < 16)
    {
      label379:
      if (i4 < 19) {
        break label446;
      }
      i1 = 1792;
    }
    for (;;)
    {
      if (i3 != 0) {
        c.j().c();
      }
      if (i4 >= 11)
      {
        d = i1;
        i.setSystemUiVisibility(i1);
      }
      if (!paramBoolean2) {
        break;
      }
      o();
      break;
      i3 = 0;
      break label379;
      label446:
      if (i4 >= 16)
      {
        i1 = 1280;
      }
      else
      {
        i1 = i6;
        if (i4 < 14)
        {
          i1 = i6;
          if (i4 >= 11) {
            i1 = i6;
          }
        }
      }
    }
  }
  
  public final boolean a(Fragment paramFragment)
  {
    if ((k == null) || (m == null)) {}
    while (k.c != m.b(paramFragment)) {
      return false;
    }
    return true;
  }
  
  public boolean a(Menu paramMenu)
  {
    return true;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    c.finish();
    return true;
  }
  
  public final void a_(int paramInt)
  {
    G = paramInt;
    e(paramInt);
  }
  
  public void a_(Bundle paramBundle)
  {
    int i2 = 1;
    int i3 = 0;
    Object localObject;
    int i1;
    if (b == 0)
    {
      localObject = new DisplayMetrics();
      WindowManager localWindowManager = (WindowManager)c.i().getSystemService("window");
      i1 = bna.b;
      localWindowManager.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    }
    boolean bool;
    label261:
    label303:
    label447:
    label487:
    label715:
    int i4;
    switch (bly.a[(i1 - 1)])
    {
    default: 
      b = Math.min(heightPixels, widthPixels);
      a = ((ActivityManager)c.getApplicationContext().getSystemService("activity")).getMemoryClass();
      localObject = c.getIntent();
      if (((Intent)localObject).hasExtra("photos_uri")) {
        F = ((Intent)localObject).getStringExtra("photos_uri");
      }
      z = ((Intent)localObject).getBooleanExtra("enable_timer_lights_out", true);
      if (((Intent)localObject).getBooleanExtra("scale_up_animation", false))
      {
        u = true;
        v = ((Intent)localObject).getIntExtra("start_x_extra", 0);
        w = ((Intent)localObject).getIntExtra("start_y_extra", 0);
        x = ((Intent)localObject).getIntExtra("start_width_extra", 0);
        y = ((Intent)localObject).getIntExtra("start_height_extra", 0);
      }
      if ((((Intent)localObject).getBooleanExtra("action_bar_hidden_initially", false)) && (!bnh.a(L)))
      {
        bool = true;
        A = bool;
        B = ((Intent)localObject).getBooleanExtra("display_thumbs_fullscreen", false);
        if (!((Intent)localObject).hasExtra("projection")) {
          break label877;
        }
        H = ((Intent)localObject).getStringArrayExtra("projection");
        q = ((Intent)localObject).getFloatExtra("max_scale", 1.0F);
        f = null;
        G = -1;
        if (((Intent)localObject).hasExtra("photo_index")) {
          G = ((Intent)localObject).getIntExtra("photo_index", -1);
        }
        if (((Intent)localObject).hasExtra("initial_photo_uri"))
        {
          e = ((Intent)localObject).getStringExtra("initial_photo_uri");
          f = e;
        }
        h = true;
        if (paramBundle == null) {
          break label891;
        }
        e = paramBundle.getString("com.android.ex.PhotoViewFragment.INITIAL_URI");
        f = paramBundle.getString("com.android.ex.PhotoViewFragment.CURRENT_URI");
        G = paramBundle.getInt("com.android.ex.PhotoViewFragment.CURRENT_INDEX");
        if ((!paramBundle.getBoolean("com.android.ex.PhotoViewFragment.FULLSCREEN", false)) || (bnh.a(L))) {
          break label885;
        }
        bool = true;
        n = bool;
        r = paramBundle.getString("com.android.ex.PhotoViewFragment.ACTIONBARTITLE");
        s = paramBundle.getString("com.android.ex.PhotoViewFragment.ACTIONBARSUBTITLE");
        t = paramBundle.getBoolean("com.android.ex.PhotoViewFragment.SCALEANIMATIONFINISHED", false);
        c.setContentView(bml.a);
        m = new bmq(c.i(), c.a_(), null, q, B);
        paramBundle = c.getResources();
        i = d(bmj.e);
        if (Build.VERSION.SDK_INT >= 11) {
          i.setOnSystemUiVisibilityChangeListener(E);
        }
        j = d(bmj.d);
        l = ((ImageView)d(bmj.f));
        k = ((PhotoViewPager)d(bmj.j));
        k.a(m);
        k.e = this;
        k.i = this;
        k.c(paramBundle.getDimensionPixelSize(bmh.c));
        C = new bma(this);
        if ((u) && (!t)) {
          break label902;
        }
        c.x_().a(100, null, this);
        if (e()) {
          j.setVisibility(0);
        }
        M = paramBundle.getInteger(bmk.a);
        paramBundle = c.j();
        if (paramBundle != null)
        {
          paramBundle.a();
          paramBundle.a(this);
          paramBundle.b();
          a(paramBundle);
        }
        if (u) {
          break label1145;
        }
        bool = n;
        i4 = Build.VERSION.SDK_INT;
        if (i4 >= 16) {
          break label955;
        }
        i2 = 1;
      }
      break;
    }
    for (;;)
    {
      if ((bool) && ((!u) || (t)))
      {
        if (i4 <= 19)
        {
          if (i4 != 19) {
            break label1031;
          }
          if (Build.VERSION.SDK_INT != 19)
          {
            throw new IllegalStateException("kitkatIsSecondary user is only callable on KitKat");
            b = Math.min(heightPixels, widthPixels) * 800 / 1000;
            break;
            bool = false;
            break label261;
            label877:
            H = null;
            break label303;
            label885:
            bool = false;
            break label447;
            label891:
            n = A;
            break label487;
            label902:
            k.setVisibility(8);
            localObject = new Bundle();
            ((Bundle)localObject).putString("image_uri", e);
            c.x_().a(2, (Bundle)localObject, C);
            break label715;
            label955:
            i2 = 0;
            continue;
          }
          if (Process.myUid() <= 100000) {
            break label1026;
          }
          i1 = 1;
          if (i1 != 0) {
            break label1031;
          }
        }
        i1 = 3846;
      }
    }
    for (;;)
    {
      i3 = i1;
      if (i2 != 0)
      {
        c.j().d();
        i3 = i1;
      }
      if (i4 >= 11)
      {
        d = i3;
        i.setSystemUiVisibility(i3);
      }
      return;
      label1026:
      i1 = 0;
      break;
      label1031:
      if (i4 >= 16)
      {
        i1 = 1285;
      }
      else if (i4 >= 14)
      {
        i1 = 1;
      }
      else if (i4 >= 11)
      {
        i1 = 1;
        continue;
        if (i4 >= 19) {
          i1 = 1792;
        }
        for (;;)
        {
          i3 = i1;
          if (i2 == 0) {
            break;
          }
          c.j().c();
          i3 = i1;
          break;
          if (i4 >= 16)
          {
            i1 = 1280;
          }
          else if (i4 >= 14)
          {
            i1 = 0;
          }
          else if (i4 >= 11)
          {
            i1 = 0;
            continue;
            label1145:
            i4 = Build.VERSION.SDK_INT;
            if (i4 < 16)
            {
              label1157:
              if (i4 < 19) {
                break label1212;
              }
              i1 = 1792;
            }
            for (;;)
            {
              if (i2 != 0) {
                c.j().c();
              }
              if (i4 < 11) {
                break;
              }
              d = i1;
              i.setSystemUiVisibility(i1);
              return;
              i2 = 0;
              break label1157;
              label1212:
              if (i4 >= 16)
              {
                i1 = 1280;
              }
              else
              {
                i1 = i3;
                if (i4 < 14)
                {
                  i1 = i3;
                  if (i4 >= 11) {
                    i1 = i3;
                  }
                }
              }
            }
          }
          else
          {
            i1 = 0;
          }
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public final void b()
  {
    if (!o) {
      m.a(null);
    }
  }
  
  public final void b(int paramInt)
  {
    I.remove(Integer.valueOf(paramInt));
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putString("com.android.ex.PhotoViewFragment.INITIAL_URI", e);
    paramBundle.putString("com.android.ex.PhotoViewFragment.CURRENT_URI", f);
    paramBundle.putInt("com.android.ex.PhotoViewFragment.CURRENT_INDEX", G);
    paramBundle.putBoolean("com.android.ex.PhotoViewFragment.FULLSCREEN", n);
    paramBundle.putString("com.android.ex.PhotoViewFragment.ACTIONBARTITLE", r);
    paramBundle.putString("com.android.ex.PhotoViewFragment.ACTIONBARSUBTITLE", s);
    paramBundle.putBoolean("com.android.ex.PhotoViewFragment.SCALEANIMATIONFINISHED", t);
  }
  
  public final void b(blo paramblo)
  {
    try
    {
      J.remove(paramblo);
      return;
    }
    finally
    {
      paramblo = finally;
      throw paramblo;
    }
  }
  
  public final boolean b(Fragment paramFragment)
  {
    if ((k == null) || (m == null) || (m.a() == 0)) {
      return n;
    }
    return (n) || (k.c != m.b(paramFragment));
  }
  
  public final bmq c()
  {
    return m;
  }
  
  public void c(int paramInt) {}
  
  public final View d(int paramInt)
  {
    return c.findViewById(paramInt);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e(int paramInt)
  {
    Object localObject1 = (blp)I.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      ((blp)localObject1).k_();
    }
    localObject1 = l();
    G = paramInt;
    f = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("uri"));
    k();
    if ((L.isEnabled()) && (N != paramInt))
    {
      localObject1 = r;
      if (s == null) {
        break label314;
      }
      localObject1 = c.i().getResources().getString(bmm.c, new Object[] { r, s });
    }
    label171:
    label314:
    for (;;)
    {
      View localView;
      Object localObject3;
      if (localObject1 != null)
      {
        localView = i;
        localObject3 = L;
        if (Build.VERSION.SDK_INT < 16) {
          break label171;
        }
        localView.announceForAccessibility((CharSequence)localObject1);
      }
      for (;;)
      {
        N = paramInt;
        p();
        o();
        return;
        Context localContext = localView.getContext().getApplicationContext();
        Object localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = (AccessibilityManager)localContext.getSystemService("accessibility");
        }
        if (((AccessibilityManager)localObject2).isEnabled())
        {
          localObject3 = AccessibilityEvent.obtain(8);
          ((AccessibilityEvent)localObject3).getText().add(localObject1);
          ((AccessibilityEvent)localObject3).setEnabled(localView.isEnabled());
          ((AccessibilityEvent)localObject3).setClassName(localView.getClass().getName());
          ((AccessibilityEvent)localObject3).setPackageName(localContext.getPackageName());
          localObject1 = ub.a((AccessibilityEvent)localObject3);
          vk.a.a(b, localView);
          if (Build.VERSION.SDK_INT >= 14) {
            localView.getParent().requestSendAccessibilityEvent(localView, (AccessibilityEvent)localObject3);
          } else {
            ((AccessibilityManager)localObject2).sendAccessibilityEvent((AccessibilityEvent)localObject3);
          }
        }
      }
    }
  }
  
  protected final boolean e()
  {
    return j != null;
  }
  
  protected final boolean f()
  {
    return l != null;
  }
  
  public void g() {}
  
  public void h()
  {
    a(n, false);
    p = false;
    if (K)
    {
      K = false;
      c.x_().a(100, null, this);
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    int i2 = k.c + 1;
    int i1;
    if (g >= 0)
    {
      i1 = 1;
      Cursor localCursor = l();
      if (localCursor == null) {
        break label86;
      }
      r = localCursor.getString(localCursor.getColumnIndex("_display_name"));
      label47:
      if ((!h) && (i1 != 0) && (i2 > 0)) {
        break label94;
      }
    }
    label86:
    label94:
    for (s = null;; s = c.getResources().getString(bmm.b, new Object[] { Integer.valueOf(i2), Integer.valueOf(g) }))
    {
      a(c.j());
      return;
      i1 = 0;
      break;
      r = null;
      break label47;
    }
  }
  
  public final Cursor l()
  {
    if (k == null) {}
    int i1;
    Cursor localCursor;
    do
    {
      return null;
      i1 = k.c;
      localCursor = m.b;
    } while (localCursor == null);
    localCursor.moveToPosition(i1);
    return localCursor;
  }
  
  public final void m()
  {
    int i4 = 0;
    int i3 = 0;
    t = true;
    k.setVisibility(0);
    boolean bool = n;
    int i5 = Build.VERSION.SDK_INT;
    int i2;
    if (i5 < 16) {
      i2 = 1;
    }
    int i1;
    while ((bool) && ((!u) || (t)))
    {
      if (i5 <= 19)
      {
        if (i5 != 19) {
          break label162;
        }
        if (Build.VERSION.SDK_INT != 19)
        {
          throw new IllegalStateException("kitkatIsSecondary user is only callable on KitKat");
          i2 = 0;
          continue;
        }
        if (Process.myUid() > 100000)
        {
          i1 = 1;
          if (i1 != 0) {
            break label162;
          }
        }
      }
      else
      {
        i1 = 3846;
      }
      for (;;)
      {
        i3 = i1;
        if (i2 != 0)
        {
          c.j().d();
          i3 = i1;
        }
        if (i5 >= 11)
        {
          d = i3;
          i.setSystemUiVisibility(i3);
        }
        return;
        i1 = 0;
        break;
        label162:
        if (i5 >= 16)
        {
          i1 = 1285;
        }
        else if (i5 >= 14)
        {
          i1 = 1;
        }
        else
        {
          i1 = i3;
          if (i5 >= 11) {
            i1 = 1;
          }
        }
      }
    }
    if (i5 >= 19) {
      i1 = 1792;
    }
    for (;;)
    {
      i3 = i1;
      if (i2 == 0) {
        break;
      }
      c.j().c();
      i3 = i1;
      break;
      if (i5 >= 16)
      {
        i1 = 1280;
      }
      else
      {
        i1 = i4;
        if (i5 < 14)
        {
          i1 = i4;
          if (i5 >= 11) {
            i1 = i4;
          }
        }
      }
    }
  }
  
  final void n()
  {
    int i1 = i.getMeasuredWidth();
    int i2 = i.getMeasuredHeight();
    if (f()) {
      l.setVisibility(0);
    }
    float f1 = Math.max(x / i1, y / i2);
    i1 = a(v, x, i1, f1);
    i2 = a(w, y, i2, f1);
    int i3 = Build.VERSION.SDK_INT;
    if (i3 >= 14)
    {
      if (e())
      {
        j.setAlpha(0.0F);
        j.animate().alpha(1.0F).setDuration(250L).start();
        j.setVisibility(0);
      }
      if (f())
      {
        l.setScaleX(f1);
        l.setScaleY(f1);
        l.setTranslationX(i1);
        l.setTranslationY(i2);
        localObject1 = new blt(this);
        localObject2 = l.animate().scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setDuration(250L);
        if (i3 < 16) {
          break label237;
        }
        ((ViewPropertyAnimator)localObject2).withEndAction((Runnable)localObject1);
        ((ViewPropertyAnimator)localObject2).start();
      }
    }
    label237:
    do
    {
      return;
      D.postDelayed((Runnable)localObject1, 250L);
      break;
      if (e())
      {
        localObject1 = new AlphaAnimation(0.0F, 1.0F);
        ((Animation)localObject1).setDuration(250L);
        j.startAnimation((Animation)localObject1);
        j.setVisibility(0);
      }
    } while (!f());
    Object localObject1 = new TranslateAnimation(i1, i2, 0.0F, 0.0F);
    ((Animation)localObject1).setDuration(250L);
    Object localObject2 = new ScaleAnimation(f1, f1, 0.0F, 0.0F);
    ((Animation)localObject2).setDuration(250L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setAnimationListener(new blu(this));
    l.startAnimation(localAnimationSet);
  }
}

/* Location:
 * Qualified Name:     blq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */