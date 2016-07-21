import android.content.Context;
import com.android.mail.providers.Account;

public final class bur
{
  public static String a(Context paramContext, Account paramAccount)
  {
    paramContext = a(paramContext, e);
    int i = -1;
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "unknown";
        if (paramContext.equals("IMAP"))
        {
          i = 0;
          continue;
          if (paramContext.equals("POP3"))
          {
            i = 1;
            continue;
            if (paramContext.equals("EXCHANGE"))
            {
              i = 2;
              continue;
              if (paramContext.equals("GMAIL")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return "imap";
    return "pop";
    return "eas";
    if (cui.f(c)) {
      return "gmail";
    }
    return "apps";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ("com.google".equals(paramString)) {
      return "GMAIL";
    }
    if (paramContext.getString(buj.b).equals(paramString)) {
      return "IMAP";
    }
    if (paramContext.getString(buj.a).equals(paramString)) {
      return "EXCHANGE";
    }
    if (paramContext.getString(buj.c).equals(paramString)) {
      return "POP3";
    }
    return "OTHER";
  }
}

/* Location:
 * Qualified Name:     bur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */