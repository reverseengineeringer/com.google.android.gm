import android.util.Log;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public final class bow
  extends Parser
{
  public ExchangeOofSettings a;
  private box b;
  
  public bow(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    if (b != null) {}
    switch (b.a)
    {
    default: 
      return;
    case 0: 
      a.e = b.b;
      a.g = b.c;
      a.f = ExchangeOofSettings.a(b.d);
      return;
    case 1: 
      a.h = b.b;
      a.j = b.c;
      a.i = ExchangeOofSettings.a(b.d);
      return;
    }
    a.k = b.b;
    a.m = b.c;
    a.l = ExchangeOofSettings.a(b.d);
  }
  
  public final boolean d()
  {
    a = new ExchangeOofSettings();
    int i;
    if (b(0) != 1157)
    {
      throw new IOException();
      i = h();
      if (!ExchangeOofSettings.b(i)) {
        break label202;
      }
      a.a = i;
    }
    while (b(0) != 1)
    {
      label202:
      Object localObject;
      switch (l)
      {
      case 1162: 
      case 1159: 
      case 1161: 
      case 1160: 
      default: 
        i = l;
        new StringBuilder(24).append("unknown tag: ").append(i);
        i();
        break;
      case 1158: 
        i = h();
        if (i != 1)
        {
          Log.w("Exchange", 53 + "OofGetParser returned non-success status: " + i);
          return false;
          Log.w("Exchange", 39 + "Received invalid oof state: " + i);
        }
        break;
      case 1163: 
        localObject = g();
        try
        {
          a.b = bhn.b((String)localObject);
        }
        catch (ParseException localParseException1)
        {
          localObject = String.valueOf(localObject);
          if (((String)localObject).length() != 0) {}
          for (localObject = "Unable to parse oof start time: ".concat((String)localObject);; localObject = new String("Unable to parse oof start time: "))
          {
            Log.w("Exchange", (String)localObject);
            break;
          }
        }
      case 1164: 
        localObject = g();
        try
        {
          a.c = bhn.b((String)localObject);
        }
        catch (ParseException localParseException2)
        {
          localObject = String.valueOf(localObject);
          if (((String)localObject).length() != 0) {}
          for (localObject = "Unable to parse oof end time: ".concat((String)localObject);; localObject = new String("Unable to parse oof end time: "))
          {
            Log.w("Exchange", (String)localObject);
            break;
          }
        }
      case 1165: 
        a();
        b = new box();
        break;
      case 1166: 
        if (b != null) {
          b.a = 0;
        }
        break;
      case 1167: 
        if (b != null) {
          b.a = 1;
        }
        break;
      case 1168: 
        if (b != null) {
          b.a = 2;
        }
        break;
      case 1169: 
        if (b != null)
        {
          localObject = b;
          if (h() != 0) {}
          for (boolean bool = true;; bool = false)
          {
            b = bool;
            break;
          }
        }
        break;
      case 1170: 
        if (b != null) {
          b.c = g();
        }
        break;
      case 1171: 
        if (b != null) {
          b.d = g();
        }
        break;
      }
    }
    a();
    return true;
  }
}

/* Location:
 * Qualified Name:     bow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */