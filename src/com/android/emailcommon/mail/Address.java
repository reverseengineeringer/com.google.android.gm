package com.android.emailcommon.mail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import bcr;
import cvl;
import cvm;
import iec;
import ieh;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address
  implements Parcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new bcr();
  private static final String c = cvl.a;
  private static final Pattern d = Pattern.compile("^<?([^>]+)>?$");
  private static final Pattern e = Pattern.compile("^\"?([^\"]*)\"?$");
  private static final Pattern f = Pattern.compile("\\\\([\\\\\"])");
  private static final Pattern g = Pattern.compile("\\A[^@]+@([[\\w][\\d]\\-\\(\\)\\[\\]]+\\.)+[[\\w][\\d]\\-\\(\\)\\[\\]]+\\z");
  private static final Address[] h = new Address[0];
  public String a;
  public String b;
  private String i;
  
  public Address(Parcel paramParcel)
  {
    j(paramParcel.readString());
    i(paramParcel.readString());
  }
  
  public Address(String paramString)
  {
    i(paramString);
  }
  
  public Address(String paramString1, String paramString2)
  {
    j(paramString2);
    i(paramString1);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Html.fromHtml(paramString.replace("<", "&lt;").replace(">", "&gt;")).toString();
  }
  
  public static String a(Address[] paramArrayOfAddress)
  {
    int j = 1;
    if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0)) {
      return null;
    }
    if (paramArrayOfAddress.length == 1) {
      return paramArrayOfAddress[0].toString();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfAddress[0].toString());
    while (j < paramArrayOfAddress.length)
    {
      localStringBuilder.append(",");
      localStringBuilder.append(paramArrayOfAddress[j].toString().trim());
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = e.matcher(paramString).replaceAll("$1");
      paramString = ieh.a(f.matcher(paramString).replaceAll("$1"));
      str = paramString;
      if (paramString.length() == 0) {
        str = null;
      }
    }
    return str;
  }
  
  public static String b(Address[] paramArrayOfAddress)
  {
    int j = 1;
    if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0)) {
      return null;
    }
    if (paramArrayOfAddress.length == 1) {
      return paramArrayOfAddress[0].b();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfAddress[0].b());
    while (j < paramArrayOfAddress.length)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfAddress[j].b());
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Address c(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          paramString = null;
          return paramString;
        }
        localObject = Rfc822Tokenizer.tokenize(paramString);
        if (localObject.length <= 0) {
          break label92;
        }
        paramString = localObject[0].getName();
        if (paramString != null)
        {
          paramString = a(paramString.trim());
          paramString = paramString.replace("\"", "\\\"");
          localObject = a(localObject[0].getAddress());
          paramString = new Address((String)localObject, paramString);
          continue;
        }
        paramString = "";
      }
      finally {}
      continue;
      label92:
      Object localObject = a(paramString);
      paramString = "";
    }
  }
  
  public static Address[] d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return h;
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    ArrayList localArrayList = new ArrayList(arrayOfRfc822Token.length);
    int k = arrayOfRfc822Token.length;
    int j = 0;
    while (j < k)
    {
      paramString = arrayOfRfc822Token[j];
      String str2 = paramString.getAddress();
      if ((!TextUtils.isEmpty(str2)) && (g.matcher(str2).find()))
      {
        String str1 = paramString.getName();
        paramString = str1;
        if (TextUtils.isEmpty(str1)) {
          paramString = null;
        }
        localArrayList.add(new Address(str2, paramString));
      }
      j += 1;
    }
    return (Address[])localArrayList.toArray(new Address[localArrayList.size()]);
  }
  
  public static String e(String paramString)
  {
    return a(h(paramString));
  }
  
  public static Address f(String paramString)
  {
    paramString = h(paramString);
    if (paramString.length > 0) {
      return paramString[0];
    }
    return null;
  }
  
  public static String g(String paramString)
  {
    return b(h(paramString));
  }
  
  public static Address[] h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return h;
    }
    if ((paramString.indexOf(2) == -1) && (paramString.indexOf(1) == -1)) {
      return d(paramString);
    }
    ArrayList localArrayList = new ArrayList();
    int n = paramString.length();
    int j = paramString.indexOf(2);
    int k = 0;
    int m;
    if (k < n)
    {
      m = paramString.indexOf(1, k);
      if (m != -1) {
        break label171;
      }
      m = n;
    }
    label171:
    for (;;)
    {
      Address localAddress;
      if ((j == -1) || (m <= j)) {
        localAddress = new Address(paramString.substring(k, m), null);
      }
      for (;;)
      {
        localArrayList.add(localAddress);
        k = m + 1;
        break;
        localAddress = new Address(paramString.substring(k, j), paramString.substring(j + 1, m));
        j = paramString.indexOf(2, m + 1);
      }
      return (Address[])localArrayList.toArray(new Address[localArrayList.size()]);
    }
  }
  
  private final void i(String paramString)
  {
    a = d.matcher(paramString).replaceAll("$1");
  }
  
  private final void j(String paramString)
  {
    b = b(paramString);
  }
  
  public final String a()
  {
    int j;
    String str;
    if (i == null)
    {
      if ((!TextUtils.isEmpty(b)) || (TextUtils.isEmpty(a))) {
        break label68;
      }
      j = a.indexOf('@');
      if (j == -1) {
        break label62;
      }
      str = a.substring(0, j);
      i = str;
    }
    for (;;)
    {
      return i;
      label62:
      str = "";
      break;
      label68:
      if (!TextUtils.isEmpty(b))
      {
        j = b.indexOf(' ');
        while ((j > 0) && (b.charAt(j - 1) == ',')) {
          j -= 1;
        }
        if (j <= 0) {}
        for (str = b;; str = b.substring(0, j))
        {
          i = str;
          break;
        }
      }
      cvm.d(c, "Unable to get a simplified name", new Object[0]);
      i = "";
    }
  }
  
  public final String b()
  {
    if (b != null)
    {
      String str1 = String.valueOf(iec.a(b));
      String str2 = a;
      return String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + str1 + " <" + str2 + ">";
    }
    return a;
  }
  
  public final String c()
  {
    if ((b != null) && (b.length() > 0)) {
      return b;
    }
    return a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Address)) {
      return a.equals(a);
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public String toString()
  {
    if ((b != null) && (!b.equals(a)))
    {
      if (b.matches(".*[\\(\\)<>@,;:\\\\\".\\[\\]].*"))
      {
        str = b;
        if (str == null) {
          localObject = null;
        }
        for (;;)
        {
          localObject = String.valueOf(localObject);
          str = a;
          return String.valueOf(localObject).length() + 3 + String.valueOf(str).length() + (String)localObject + " <" + str + ">";
          localObject = str;
          if (!str.matches("^\".*\"$")) {
            localObject = String.valueOf(str).length() + 2 + "\"" + str + "\"";
          }
        }
      }
      Object localObject = b;
      String str = a;
      return String.valueOf(localObject).length() + 3 + String.valueOf(str).length() + (String)localObject + " <" + str + ">";
    }
    return a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(b);
    paramParcel.writeString(a);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.mail.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */