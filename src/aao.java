import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Calendar;

class aao
  extends aan
{
  private static abr z;
  private int A = -100;
  private boolean B;
  boolean q = true;
  
  aao(Context paramContext, Window paramWindow, aai paramaai)
  {
    super(paramContext, paramWindow, paramaai);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new aap(this, paramCallback);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (A == -100)) {
      A = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (A != -100) {
      paramBundle.putInt("appcompat:local_night_mode", A);
    }
  }
  
  int f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if (z == null) {
        z = new abr(c.getApplicationContext());
      }
      Object localObject3 = z;
      abs localabs = abr.a;
      boolean bool;
      if (abr.a(localabs)) {
        bool = a;
      }
      while (bool)
      {
        return 2;
        Object localObject1 = null;
        Object localObject2 = null;
        if (kl.a(b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
          localObject1 = ((abr)localObject3).a("network");
        }
        if (kl.a(b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
          localObject2 = ((abr)localObject3).a("gps");
        }
        label161:
        long l1;
        long l2;
        if ((localObject2 != null) && (localObject1 != null)) {
          if (((Location)localObject2).getTime() > ((Location)localObject1).getTime())
          {
            localObject1 = localObject2;
            if (localObject1 == null) {
              break label431;
            }
            localObject2 = abr.a;
            l1 = System.currentTimeMillis();
            if (abq.a == null) {
              abq.a = new abq();
            }
            localObject3 = abq.a;
            ((abq)localObject3).a(l1 - 86400000L, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
            l2 = b;
            ((abq)localObject3).a(l1, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
            if (d != 1) {
              break label382;
            }
          }
        }
        long l3;
        long l4;
        long l5;
        label382:
        for (bool = true;; bool = false)
        {
          l3 = c;
          l4 = b;
          ((abq)localObject3).a(86400000L + l1, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
          l5 = c;
          if ((l3 != -1L) && (l4 != -1L)) {
            break label387;
          }
          l1 = 43200000L + l1;
          a = bool;
          b = l2;
          c = l3;
          d = l4;
          e = l5;
          f = l1;
          bool = a;
          break;
          break label161;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            break label161;
          }
          break label161;
        }
        label387:
        if (l1 > l4) {
          l1 = 0L + l5;
        }
        for (;;)
        {
          l1 += 60000L;
          break;
          if (l1 > l3) {
            l1 = 0L + l4;
          } else {
            l1 = 0L + l3;
          }
        }
        label431:
        paramInt = Calendar.getInstance().get(11);
        if ((paramInt < 6) || (paramInt >= 22)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      return 1;
    }
    return -1;
  }
  
  public final boolean j()
  {
    B = true;
    Resources localResources;
    Configuration localConfiguration;
    int j;
    if (A == -100)
    {
      i = aaj.a;
      i = f(i);
      if (i == -1) {
        break label116;
      }
      localResources = c.getResources();
      localConfiguration = localResources.getConfiguration();
      j = uiMode;
      if (i != 2) {
        break label108;
      }
    }
    label108:
    for (int i = 32;; i = 16)
    {
      if ((j & 0x30) == i) {
        break label114;
      }
      localConfiguration = new Configuration(localConfiguration);
      uiMode = (i | uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
      i = A;
      break;
    }
    label114:
    return false;
    label116:
    return false;
  }
}

/* Location:
 * Qualified Name:     aao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */