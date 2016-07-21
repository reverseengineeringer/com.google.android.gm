import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.EmailProviderConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class awg
{
  static final Uri a = Uri.parse("content://com.android.email.partnerprovider/providers");
  static final Uri b = Uri.parse("content://com.android.email.partnerprovider/account_setup_entry");
  private static final String c = cvm.a;
  private final Context d;
  
  public awg(Context paramContext)
  {
    d = paramContext.getApplicationContext();
  }
  
  private final boolean c()
  {
    boolean bool = true;
    if (cfm.a(d).d("allowNonSystemPartnerProviderApp"))
    {
      cvm.b(c, "PartnerProviderHelper: bypassing check for system app.", new Object[0]);
      return true;
    }
    for (;;)
    {
      try
      {
        if ((d.getPackageManager().getApplicationInfo("com.android.email.partnerprovider", 0).flags & 0x1) != 0)
        {
          cvm.b(c, "PartnerProviderHelper app found, isSystemApp: %b", new Object[] { Boolean.valueOf(bool) });
          return bool;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        cvm.b(c, "PartnerProviderHelper: PartnerProvider app not found.", new Object[0]);
        return false;
      }
      bool = false;
    }
  }
  
  public final String a(String paramString)
  {
    if (!c())
    {
      cvm.b(c, "PartnerProviderHelper.getSignature: no system app found", new Object[0]);
      return null;
    }
    if ((paramString == null) || (!paramString.startsWith("partnerprovider_")))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Illegal provider id: ".concat(paramString);; paramString = new String("Illegal provider id: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    String str = paramString.substring(16);
    paramString = d.getContentResolver().query(a, null, null, null, null);
    if (paramString == null)
    {
      cvm.b(c, "PartnerProviderHelper.getSignature: null Cursor", new Object[0]);
      return null;
    }
    try
    {
      while (paramString.moveToNext()) {
        if (str.equals(paramString.getString(paramString.getColumnIndex("id"))))
        {
          str = paramString.getString(paramString.getColumnIndex("signature"));
          return str;
        }
      }
      return null;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public final List<EmailProviderConfiguration> a()
  {
    if (!c())
    {
      cvm.b(c, "PartnerProviderHelper.getProviders: no system app found", new Object[0]);
      return Collections.emptyList();
    }
    Cursor localCursor = d.getContentResolver().query(a, null, null, null, null);
    if (localCursor == null)
    {
      cvm.d(c, "PartnerProviderHelper.getProviders: null Cursor", new Object[0]);
      return Collections.emptyList();
    }
    for (;;)
    {
      ArrayList localArrayList;
      EmailProviderConfiguration localEmailProviderConfiguration;
      try
      {
        localArrayList = new ArrayList();
        if (!localCursor.moveToNext()) {
          break label475;
        }
        localEmailProviderConfiguration = new EmailProviderConfiguration(3);
        b = localCursor.getString(localCursor.getColumnIndex("id"));
        c = localCursor.getString(localCursor.getColumnIndex("label"));
        d = localCursor.getString(localCursor.getColumnIndex("domain"));
        if (d != null) {
          d = d.toLowerCase(Locale.ENGLISH);
        }
        e = localCursor.getString(localCursor.getColumnIndex("inUriTemplate"));
        f = localCursor.getString(localCursor.getColumnIndex("inUserTemplate"));
        g = localCursor.getString(localCursor.getColumnIndex("outUriTemplate"));
        h = localCursor.getString(localCursor.getColumnIndex("outUserTemplate"));
        if ((3 != a) || (TextUtils.isEmpty(b)) || (TextUtils.isEmpty(c)) || (TextUtils.isEmpty(d)) || (TextUtils.isEmpty(e)) || (TextUtils.isEmpty(f)) || (TextUtils.isEmpty(g))) {
          break label484;
        }
        if (!TextUtils.isEmpty(h)) {
          break label421;
        }
      }
      finally
      {
        String str1;
        String str4;
        localCursor.close();
      }
      if (i != 0)
      {
        str1 = String.valueOf("partnerprovider_");
        str4 = String.valueOf(b);
        if (str4.length() != 0)
        {
          str1 = str1.concat(str4);
          b = str1;
          localArrayList.add(localEmailProviderConfiguration);
          cvm.b(c, "PartnerProviderHelper.getProviders: loaded provider: %s", new Object[] { b });
          continue;
          label421:
          if (d.startsWith("*"))
          {
            i = 0;
            continue;
          }
        }
        else
        {
          String str3 = new String(str2);
          continue;
        }
      }
      else
      {
        cvm.d(c, "PartnerProvider: provider with id \"%s\" will not be used because it's invalid", new Object[] { b });
        continue;
        label475:
        localCursor.close();
        return localArrayList;
        label484:
        i = 0;
        continue;
      }
      int i = 1;
    }
  }
  
  public final awh b()
  {
    if (!c())
    {
      cvm.b(c, "PartnerProviderHelper.getAccountSetupEntry: no system app found", new Object[0]);
      return null;
    }
    Cursor localCursor = d.getContentResolver().query(b, null, null, null, null);
    if (localCursor == null)
    {
      cvm.b(c, "PartnerProviderHelper.getAccountSetupEntry: null Cursor", new Object[0]);
      return null;
    }
    try
    {
      if (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("label"));
        boolean bool = TextUtils.isEmpty(str);
        if (bool) {
          return null;
        }
        Object localObject1 = localCursor.getBlob(localCursor.getColumnIndex("logo"));
        if (localObject1 != null) {}
        for (localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);; localObject1 = null)
        {
          localObject1 = new awh(str, (Bitmap)localObject1);
          return (awh)localObject1;
        }
      }
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     awg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */