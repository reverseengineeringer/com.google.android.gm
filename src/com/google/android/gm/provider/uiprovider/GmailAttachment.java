package com.google.android.gm.provider.uiprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import chh;
import com.android.mail.providers.Attachment;
import ctr;
import cvr;
import cxa;
import dpa;
import dri;
import dvm;
import ghz;
import hgd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GmailAttachment
  extends Attachment
{
  public static final Parcelable.Creator<GmailAttachment> CREATOR = new dvm();
  public long p;
  public long q;
  public int r;
  public int s;
  public int t;
  public long u;
  public String v;
  private String w;
  private String x;
  
  public GmailAttachment() {}
  
  public GmailAttachment(Parcel paramParcel)
  {
    super(paramParcel);
    q();
  }
  
  private GmailAttachment(String paramString, ContentResolver paramContentResolver)
  {
    String[] arrayOfString = TextUtils.split(paramString, chh.q);
    if ((arrayOfString != null) && (arrayOfString.length >= 6))
    {
      b = arrayOfString[0];
      b(arrayOfString[1]);
      a(arrayOfString[2]);
      try
      {
        d = Integer.parseInt(arrayOfString[3]);
        e(arrayOfString[4]);
        if (arrayOfString[5].equalsIgnoreCase("SERVER_ATTACHMENT")) {
          i = 0;
        }
        r = i;
        f(arrayOfString[6]);
        if (arrayOfString.length > 7) {
          v = arrayOfString[7];
        }
        if (arrayOfString.length <= 8) {}
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          k = Integer.parseInt(arrayOfString[8]);
          n = a(paramContentResolver, l());
          return;
          paramString = paramString;
          d = 0;
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            k = 0;
          }
        }
      }
    }
    throw new IllegalArgumentException(String.format("Joined string %s has less than 6 tokens.", new Object[] { paramString }));
  }
  
  private GmailAttachment(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    q();
  }
  
  public static String a(List<GmailAttachment> paramList)
  {
    if (paramList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GmailAttachment localGmailAttachment = (GmailAttachment)paramList.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(localGmailAttachment.n());
    }
    return localStringBuilder.toString();
  }
  
  public static List<GmailAttachment> a(String paramString, ContentResolver paramContentResolver)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      String[] arrayOfString = TextUtils.split(paramString, chh.p);
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str = arrayOfString[i];
          try
          {
            localArrayList.add(new GmailAttachment(str, paramContentResolver));
            i += 1;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              dri.e(a, "Unable to create attachment from %s. Full string %s", new Object[] { str, paramString });
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean a(ContentResolver paramContentResolver, String paramString)
  {
    switch (ctr.a(paramString))
    {
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return ghz.a(paramContentResolver, "gmail_use_senna", true);
  }
  
  public static int c(int paramInt)
  {
    if (dpa.d(paramInt)) {
      return 3;
    }
    if (dpa.b(paramInt)) {
      return 2;
    }
    if ((dpa.c(paramInt)) || (dpa.a(paramInt))) {
      return 5;
    }
    if (dpa.e(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public static ArrayList<Attachment> d(String paramString)
  {
    localArrayList = new ArrayList();
    if (paramString != null) {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          localArrayList.add(new GmailAttachment(paramString.getJSONObject(i)));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  public static boolean h(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = new JSONObject(paramString).getInt("origin");
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  public final JSONObject a()
  {
    p();
    return super.a();
  }
  
  public final void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      k = 1;
      return;
    case 2: 
      k = 2;
      return;
    }
    k = 0;
  }
  
  public final boolean b(String paramString)
  {
    if (super.b(paramString))
    {
      x = null;
      return true;
    }
    return false;
  }
  
  public final void e(String paramString)
  {
    if (!TextUtils.equals(w, paramString))
    {
      x = null;
      w = paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (GmailAttachment)paramObject;
      if (p != p) {
        return false;
      }
      if (u != u) {
        return false;
      }
      if (t != t) {
        return false;
      }
      if (r != r) {
        return false;
      }
      if (s != s) {
        return false;
      }
      if (q != q) {
        return false;
      }
      if (v != null)
      {
        if (v.equals(v)) {}
      }
      else {
        while (v != null) {
          return false;
        }
      }
      if (w == null) {
        break;
      }
    } while (w.equals(w));
    for (;;)
    {
      return false;
      if (w == null) {
        break;
      }
    }
  }
  
  public final void f(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    if (((Uri)localObject).getScheme() != null)
    {
      r = 1;
      i = ((Uri)localObject);
      if (cxa.b(j)) {
        j = i;
      }
      return;
    }
    localObject = TextUtils.split(paramString, "_");
    if (localObject.length == 3) {
      try
      {
        long l1 = Long.parseLong(localObject[0]);
        long l2 = Long.parseLong(localObject[1]);
        localObject = localObject[2];
        r = 0;
        p = l1;
        q = l2;
        b = ((String)localObject);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        dri.d(a, "Unknown origin for extras: %s", new Object[] { paramString });
        return;
      }
    }
    dri.d(a, "Unknown origin for extras: %s", new Object[] { paramString });
  }
  
  public final void g(String paramString)
  {
    if (paramString == null) {
      v = null;
    }
    do
    {
      Uri localUri;
      do
      {
        return;
        localUri = Uri.parse(paramString);
        if (localUri.getScheme() == null) {
          break;
        }
        v = paramString;
      } while (!TextUtils.isEmpty(c));
      b(localUri.getLastPathSegment());
      return;
      v = null;
    } while (!TextUtils.isEmpty(c));
    b(paramString);
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = super.hashCode();
    int m = (int)(p ^ p >>> 32);
    int n = (int)(q ^ q >>> 32);
    int i1 = r;
    if (w != null) {}
    for (int i = w.hashCode();; i = 0)
    {
      int i2 = s;
      int i3 = t;
      int i4 = (int)(u ^ u >>> 32);
      if (v != null) {
        j = v.hashCode();
      }
      return ((((i + (((k * 31 + m) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + j;
    }
  }
  
  public final String n()
  {
    String str1;
    String str2;
    label22:
    String str5;
    int i;
    String str3;
    label66:
    String str6;
    label96:
    String str7;
    if (b == null)
    {
      str1 = "";
      if (c != null) {
        break label190;
      }
      str2 = "";
      str5 = l();
      i = d;
      if (TextUtils.isEmpty(x))
      {
        if (TextUtils.isEmpty(w)) {
          break label207;
        }
        str3 = cvr.a(c, w);
        x = cvr.a(c, str3);
      }
      str6 = x;
      if (r != 0) {
        break label216;
      }
      str3 = "SERVER_ATTACHMENT";
      str7 = s();
      if (v != null) {
        break label224;
      }
    }
    label190:
    label207:
    label216:
    label224:
    for (String str4 = "";; str4 = v)
    {
      return TextUtils.join("|", hgd.a(new String[] { str1, str2, str5, String.valueOf(i), str6, str3, str7, str4, String.valueOf(k) }));
      str1 = b;
      break;
      str2 = c.replaceAll("[|\n]", "");
      break label22;
      str3 = l();
      break label66;
      str3 = "LOCAL_FILE";
      break label96;
    }
  }
  
  public final void p()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("partId", b);
      localJSONObject.put("conversationId", p);
      localJSONObject.put("messageId", q);
      localJSONObject.put("origin", r);
      localJSONObject.put("simpleContentType", w);
      localJSONObject.put("rendition", s);
      localJSONObject.put("downloadStatus", t);
      localJSONObject.put("downloadId", u);
      localJSONObject.put("cachedFileUri", v);
      m = localJSONObject.toString();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        dri.d(a, "Failed to deflate to provider data.", new Object[0]);
      }
    }
  }
  
  public final void q()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(m);
      b = localJSONObject.optString("partId");
      p = localJSONObject.optLong("conversationId");
      q = localJSONObject.optLong("messageId");
      r = localJSONObject.optInt("origin", 1);
      w = localJSONObject.optString("simpleContentType");
      s = localJSONObject.optInt("rendition");
      t = localJSONObject.optInt("downloadStatus");
      u = localJSONObject.optLong("downloadId");
      v = localJSONObject.optString("cachedFileUri");
      return;
    }
    catch (JSONException localJSONException)
    {
      dri.b(a, "Failed to inflate from provider data: %s", new Object[] { m });
      r = 1;
    }
  }
  
  public final String r()
  {
    return TextUtils.join("_", hgd.a(new String[] { String.valueOf(p), String.valueOf(q), b }));
  }
  
  public final String s()
  {
    if (r == 0) {
      return r();
    }
    if (i != null) {
      return i.toString();
    }
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p();
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.GmailAttachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */