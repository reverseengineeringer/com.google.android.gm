import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import com.android.emailcommon.provider.Policy;
import com.android.exchange.adapter.Parser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bpe
  extends Parser
{
  public Policy a = null;
  public String b = null;
  public boolean c = false;
  public boolean d = true;
  public boolean e;
  public boolean f;
  public boolean g;
  private final Context h;
  private boolean i = false;
  private final Resources n;
  
  public bpe(Context paramContext, InputStream paramInputStream)
  {
    super(paramInputStream);
    h = paramContext;
    n = paramContext.getResources();
  }
  
  private final void a(Policy paramPolicy)
  {
    paramPolicy.d();
    StringBuilder localStringBuilder = new StringBuilder();
    if (n) {
      a(localStringBuilder, bnu.y);
    }
    if (l) {
      a(localStringBuilder, bnu.M);
    }
    v = localStringBuilder.toString();
    a = paramPolicy;
  }
  
  private final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(n.getString(paramInt));
    paramStringBuilder.append('\001');
  }
  
  private static void a(XmlPullParser paramXmlPullParser, Policy paramPolicy)
  {
    int j;
    String str1;
    label157:
    do
    {
      do
      {
        do
        {
          j = paramXmlPullParser.nextTag();
          if ((j == 3) && (paramXmlPullParser.getName().equals("wap-provisioningdoc"))) {
            break;
          }
        } while ((j != 2) || (!paramXmlPullParser.getName().equals("characteristic")));
        str1 = paramXmlPullParser.getAttributeValue(null, "type");
        if (!str1.equals("SecurityPolicy")) {
          break label157;
        }
        for (j = 1;; j = 0) {
          do
          {
            k = paramXmlPullParser.nextTag();
            if ((k == 3) && (paramXmlPullParser.getName().equals("characteristic"))) {
              break;
            }
          } while ((k != 2) || (!paramXmlPullParser.getName().equals("parm")) || (!paramXmlPullParser.getAttributeValue(null, "name").equals("4131")) || (!paramXmlPullParser.getAttributeValue(null, "value").equals("1")));
        }
      } while (j != 0);
      return;
    } while (!str1.equals("Registry"));
    do
    {
      j = paramXmlPullParser.nextTag();
      if ((j == 3) && (paramXmlPullParser.getName().equals("characteristic"))) {
        break;
      }
    } while ((j != 2) || (!paramXmlPullParser.getName().equals("characteristic")));
    int k = 1;
    for (;;)
    {
      j = paramXmlPullParser.nextTag();
      if ((j == 3) && (paramXmlPullParser.getName().equals("characteristic"))) {
        break;
      }
      if ((j == 2) && (paramXmlPullParser.getName().equals("parm")))
      {
        str1 = paramXmlPullParser.getAttributeValue(null, "name");
        String str2 = paramXmlPullParser.getAttributeValue(null, "value");
        j = -1;
        switch (str1.hashCode())
        {
        }
        for (;;)
        {
          switch (j)
          {
          case 3: 
          default: 
            break;
          case 0: 
            if (k == 0) {
              break;
            }
            if (!str2.equals("0")) {
              break label503;
            }
            h = 1;
            break;
            if (str1.equals("AEFrequencyValue"))
            {
              j = 0;
              continue;
              if (str1.equals("AEFrequencyType"))
              {
                j = 1;
                continue;
                if (str1.equals("DeviceWipeThreshold"))
                {
                  j = 2;
                  continue;
                  if (str1.equals("CodewordFrequency"))
                  {
                    j = 3;
                    continue;
                    if (str1.equals("MinimumPasswordLength"))
                    {
                      j = 4;
                      continue;
                      if (str1.equals("PasswordComplexity")) {
                        j = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        label503:
        h = (Integer.parseInt(str2) * 60);
        continue;
        if (str2.equals("0"))
        {
          k = 0;
          continue;
          d = Integer.parseInt(str2);
          continue;
          c = Integer.parseInt(str2);
          continue;
          if (str2.equals("0")) {
            b = 2;
          } else {
            b = 1;
          }
        }
      }
    }
  }
  
  private final boolean a()
  {
    return ((DevicePolicyManager)h.getSystemService("device_policy")).getStorageEncryptionStatus() != 0;
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool = false;
    while (b(paramInt) != 3) {
      switch (l)
      {
      case 953: 
      default: 
        i();
        break;
      case 952: 
      case 954: 
        bool = true;
      }
    }
    return bool;
  }
  
  private final void b()
  {
    Policy localPolicy;
    Object localObject1;
    label39:
    label248:
    int j;
    if (b(906) != 3) {
      if (l == 909)
      {
        localPolicy = new Policy();
        localObject1 = new ArrayList();
        if (b(909) != 3) {
          switch (l)
          {
          case 914: 
          case 952: 
          default: 
            i();
            j = 1;
          }
        }
      }
    }
    for (;;)
    {
      label250:
      if (j != 0) {
        break label39;
      }
      j = l;
      a(33 + "Policy not supported: " + j);
      d = false;
      break label39;
      cvm.b("Exchange", "password enabled", new Object[0]);
      if ((h() != 1) || (b != 0)) {
        break label248;
      }
      b = 1;
      j = 1;
      continue;
      c = h();
      j = 1;
      continue;
      if (h() != 1) {
        break label248;
      }
      b = 2;
      j = 1;
      continue;
      h = h();
      j = 1;
      continue;
      d = h();
      j = 1;
      continue;
      e = h();
      j = 1;
      continue;
      f = h();
      j = 1;
      continue;
      if (h() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        m = bool;
        if ((!m) || (bfh.a(h))) {
          break;
        }
        m = false;
        j = 0;
        break label250;
      }
      if ((h() != 0) || ((b != 0) && (b != 1))) {
        break label248;
      }
      b = 3;
      j = 1;
      continue;
      g();
      j = 1;
      continue;
      if (h() != 0) {
        break label248;
      }
      switch (l)
      {
      default: 
        j = 0;
      }
      for (;;)
      {
        if (j > 0)
        {
          ((ArrayList)localObject1).add(Integer.valueOf(j));
          j = 0;
          break label250;
          j = bnu.F;
          continue;
          j = bnu.H;
          continue;
          j = bnu.I;
          continue;
          j = bnu.J;
          continue;
          j = bnu.G;
          continue;
          j = bnu.E;
          continue;
          j = bnu.D;
          continue;
          j = bnu.B;
          o = true;
          continue;
          j = bnu.z;
          continue;
          j = bnu.A;
          continue;
          j = bnu.C;
          continue;
          if (h() != 1) {}
          for (bool = true;; bool = false)
          {
            n = bool;
            j = 1;
            break;
          }
          if (h() == 2) {
            break label248;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(bnu.x));
          j = 0;
          break label250;
          if (h() != 1) {
            break label248;
          }
          if (!a())
          {
            ((ArrayList)localObject1).add(Integer.valueOf(bnu.L));
            j = 0;
            break label250;
          }
          j = true;
          j = 1;
          break label250;
          if (h() != 1) {
            break label248;
          }
          a("Policy requires SD card encryption");
          Object localObject2;
          if (a())
          {
            localObject2 = jr.a(h);
            if ((Environment.isExternalStorageRemovable()) || ((localObject2 != null) && (localObject2.length > 1)))
            {
              j = 1;
              label873:
              if (j != 0) {
                break label906;
              }
            }
            label906:
            for (j = 1;; j = 0)
            {
              k = j;
              if (j == 0) {
                break label920;
              }
              a("Device supports SD card encryption");
              j = true;
              break;
              j = 0;
              break label873;
            }
          }
          a("Device doesn't support encryption; failing");
          int k = 0;
          label920:
          ((ArrayList)localObject1).add(Integer.valueOf(bnu.N));
          j = k;
          break label250;
          if (h() == 1) {}
          for (bool = true;; bool = false)
          {
            l = bool;
            j = 1;
            break;
          }
          if (h() == 1) {}
          for (bool = true;; bool = false)
          {
            u = bool;
            j = 1;
            break;
          }
          if (h() != 1) {
            break label248;
          }
          if (!i)
          {
            ((ArrayList)localObject1).add(Integer.valueOf(bnu.O));
            i = true;
            j = 0;
            break label250;
            j = h();
            if (j <= 0) {
              break label248;
            }
            p = j;
            j = 1;
            break label250;
            g = h();
            j = 1;
            break label250;
            i();
            j = 1;
            break label250;
            if (!a(l)) {
              break label248;
            }
            if (l == 951)
            {
              ((ArrayList)localObject1).add(Integer.valueOf(bnu.v));
              j = 0;
              break label250;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(bnu.w));
            j = 0;
            break label250;
            t = h();
            j = 1;
            break label250;
            s = h();
            j = 1;
            break label250;
            localObject2 = g();
            if (((String)localObject2).equals("-1")) {
              break label248;
            }
            j = Integer.parseInt((String)localObject2);
            if (l == 939)
            {
              q = j;
              ((ArrayList)localObject1).add(Integer.valueOf(bnu.P));
            }
            for (;;)
            {
              j = 0;
              break;
              r = j;
              ((ArrayList)localObject1).add(Integer.valueOf(bnu.K));
            }
            if (!((ArrayList)localObject1).isEmpty())
            {
              localObject2 = new StringBuilder();
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                a((StringBuilder)localObject2, ((Integer)((Iterator)localObject1).next()).intValue());
              }
              w = ((StringBuilder)localObject2).toString();
            }
            a(localPolicy);
            break;
            i();
            break;
            return;
          }
        }
      }
      j = 0;
    }
  }
  
  private final void c()
  {
    e = true;
    while (b(902) != 3) {
      if (l == 903)
      {
        f = true;
        String str1 = null;
        while (b(903) != 3) {
          switch (l)
          {
          case 907: 
          default: 
            i();
            break;
          case 904: 
            str1 = g();
            cvm.b("Exchange", "Policy type: %s", new Object[] { str1 });
            break;
          case 905: 
            b = g();
            break;
          case 906: 
            g = true;
            if (str1.equalsIgnoreCase("MS-WAP-Provisioning-XML"))
            {
              cvm.c("Exchange", "Parsing <Data> with MS-WAP-Provisioning-XML", new Object[0]);
              String str2 = g();
              Policy localPolicy = new Policy();
              try
              {
                XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
                localXmlPullParser.setInput(new ByteArrayInputStream(str2.getBytes()), "UTF-8");
                if ((localXmlPullParser.getEventType() == 0) && (localXmlPullParser.next() == 2) && (localXmlPullParser.getName().equals("wap-provisioningdoc"))) {
                  a(localXmlPullParser, localPolicy);
                }
                a(localPolicy);
              }
              catch (XmlPullParserException localXmlPullParserException)
              {
                throw new IOException();
              }
            }
            else
            {
              cvm.c("Exchange", "Parsing <Data> with MS-EAS-Provisioning-WBXML", new Object[0]);
              b();
            }
            break;
          }
        }
      }
      else
      {
        i();
      }
    }
  }
  
  private final void e()
  {
    while (b(1174) != 3) {
      if (l == 1158) {
        cvm.b("Exchange", "DeviceInformation status: %s", new Object[] { g() });
      } else {
        i();
      }
    }
  }
  
  public final boolean d()
  {
    boolean bool;
    if (b(0) != 901)
    {
      throw new IOException();
      int j = h();
      if (j != 1) {
        cvm.e("Exchange", "Provision status: %d", new Object[] { Integer.valueOf(j) });
      }
      if (j == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (b(0) != 1)
      {
        switch (l)
        {
        case 907: 
        default: 
          i();
          continue;
          bool = false;
          break;
        case 1174: 
          e();
          break;
        case 902: 
          c();
          if (a != null) {
            continue;
          }
          cvm.d("Exchange", "Parsing policy did not succeed.", new Object[0]);
          break;
        case 908: 
          c = true;
          break;
        }
      }
      else
      {
        return bool;
        bool = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bpe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */