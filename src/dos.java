import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AdvertisementOptions;
import com.google.android.gm.provider.Advertisement.AppInstallAdData;
import com.google.android.gm.provider.GmailProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.json.JSONObject;

public final class dos
{
  static final String a = cvl.a;
  private static final Set<Integer> g = hfd.a(Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(20), Integer.valueOf(9), Integer.valueOf(21), Integer.valueOf(3), new Integer[] { Integer.valueOf(8) });
  public final Context b;
  public Account c;
  public SQLiteDatabase d;
  duf e;
  drp f;
  
  dos(Context paramContext, Account paramAccount, SQLiteDatabase paramSQLiteDatabase, duf paramduf, drp paramdrp)
  {
    b = paramContext;
    c = paramAccount;
    d = paramSQLiteDatabase;
    e = paramduf;
    f = paramdrp;
  }
  
  public static dos a(Context paramContext, String paramString)
  {
    return drp.b(paramContext, paramString).E();
  }
  
  public static dos a(String paramString)
  {
    paramString = drp.a(paramString);
    if (paramString != null) {
      return paramString.E();
    }
    return null;
  }
  
  public static void a(Context paramContext, Account paramAccount)
  {
    paramContext.getContentResolver().notifyChange(GmailProvider.h(name), null);
  }
  
  static void a(Context paramContext, Account paramAccount, Collection<String> paramCollection)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      localContentResolver.notifyChange(GmailProvider.c(name, str), null);
    }
    a(paramContext, paramAccount);
  }
  
  private final void a(Advertisement paramAdvertisement, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramAdvertisement == null) {
      dri.e(a, "Trying to record an ad action %d on a null advertisement", new Object[] { Integer.valueOf(paramInt) });
    }
    long l;
    Object localObject2;
    do
    {
      return;
      if (B == null)
      {
        dri.e(a, "AdvertisementOptions null in advertisement", new Object[0]);
        return;
      }
      l = dhw.a(paramAdvertisement, paramInt);
      if ((B.b) && (paramInt == 2) && (!TextUtils.isEmpty(x))) {}
      try
      {
        localObject1 = new HttpGet(new URI(dhw.a(b, Uri.parse(x), paramAdvertisement, 2).toString()));
        localObject1 = f.p().execute((HttpUriRequest)localObject1);
        if ((localObject1 == null) || (((HttpResponse)localObject1).getEntity() == null)) {
          break label802;
        }
        localObject1 = ((HttpResponse)localObject1).getEntity().getContent();
        if (localObject1 != null) {
          break;
        }
        dri.e(a, "Missing content in click id response", new Object[0]);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject1;
          dri.e(a, localIOException, "Failed to fetch click id", new Object[0]);
          continue;
          str1 = "";
          continue;
          dri.e(a, "Got a bad response from click server", new Object[0]);
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          dri.e(a, localURISyntaxException, "Failed to fetch click id due to malformed uri", new Object[0]);
          continue;
          dri.e(a, "Failed to fetch click id", new Object[0]);
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject3;
        do
        {
          for (;;)
          {
            dri.e(a, localJSONException, "Failed to parse json response from the click server", new Object[0]);
            continue;
            str2 = "";
            continue;
            str2 = "";
            continue;
            str2 = "";
          }
        } while ((paramInt != 2) || (!B.g));
        if (C == null) {
          break label905;
        }
        for (str2 = C;; str2 = "")
        {
          ((ContentValues)localObject3).put("value10", str2);
          break;
        }
        duj.a(paramAdvertisement, paramInt, f.p(), b.getContentResolver(), paramString, l);
        return;
      }
      if ((B.a) || (g.contains(Integer.valueOf(paramInt))))
      {
        localObject2 = e;
        localObject3 = new ContentValues(14);
        ((ContentValues)localObject3).put("action", "adAction");
        ((ContentValues)localObject3).put("message_messageId", Integer.valueOf(0));
        ((ContentValues)localObject3).put("value1", Integer.valueOf(paramInt));
        ((ContentValues)localObject3).put("value2", Integer.valueOf(q));
        ((ContentValues)localObject3).put("value3", e);
        ((ContentValues)localObject3).put("value4", s);
        ((ContentValues)localObject3).put("value5", r);
        ((ContentValues)localObject3).put("value6", paramString);
        if (A == null) {
          break label840;
        }
        localObject1 = A;
        ((ContentValues)localObject3).put("value7", (String)localObject1);
        if ((paramInt != 4) && (paramInt != 20)) {
          break label864;
        }
        if ((l == null) || (!B.c)) {
          break label848;
        }
        localObject1 = l;
        ((ContentValues)localObject3).put("value8", (String)localObject1);
        if (C == null) {
          break label856;
        }
        localObject1 = C;
        ((ContentValues)localObject3).put("value10", (String)localObject1);
        ((ContentValues)localObject3).put("value9", Integer.toString(F));
        if (l >= 0L) {
          ((ContentValues)localObject3).put("value11", Long.toString(l));
        }
        ((ContentValues)localObject3).put("value12", Integer.valueOf(M));
        c.insert("operations", null, (ContentValues)localObject3);
        if (paramBoolean) {
          b.getContentResolver().notifyChange(dpy.a(c.name), null, true);
        }
      }
    } while (!B.b);
    label603:
    int i;
    if (paramInt == 2)
    {
      duj.a(paramAdvertisement, paramInt, f.p(), b.getContentResolver(), null, l);
      return;
      localObject1 = idc.a((InputStream)localObject1, "UTF-8");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new JSONObject(((String)localObject1).substring(((String)localObject1).indexOf('\n')));
        if (((JSONObject)localObject2).has("ci"))
        {
          localObject1 = ((JSONObject)localObject2).getString("ci");
          if (!((JSONObject)localObject2).has("referrer")) {
            break label936;
          }
          localObject2 = ((JSONObject)localObject2).getString("referrer");
          localObject3 = e;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label944;
          }
          i = 0;
          label620:
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label950;
          }
        }
      }
    }
    label802:
    label840:
    label848:
    label856:
    label864:
    label905:
    label936:
    label944:
    label950:
    for (int j = 0;; j = 1)
    {
      i = j + i;
      if (i != 0)
      {
        ContentValues localContentValues = new ContentValues(i);
        if (!((String)localObject1).isEmpty()) {
          localContentValues.put("click_id", (String)localObject1);
        }
        if (!((String)localObject2).isEmpty()) {
          localContentValues.put("aia_referrer", (String)localObject2);
        }
        if (d.update("ads", localContentValues, "event_id = ?", new String[] { localObject3 }) > 0) {
          a(Collections.singleton(localObject3));
        }
      }
      C = ((String)localObject1);
      break;
      String str1;
      String str2;
      localObject2 = "";
      break label603;
      i = 1;
      break label620;
    }
  }
  
  public static ContentValues b(Advertisement paramAdvertisement)
  {
    ContentValues localContentValues = new ContentValues(dpy.o.length - 1);
    localContentValues.put("event_id", e);
    localContentValues.put("advertiser_name", f);
    localContentValues.put("title", g);
    localContentValues.put("line1", h);
    localContentValues.put("visible_url", paramAdvertisement.i);
    localContentValues.put("redirect_url", j);
    int i;
    if (k == null)
    {
      localObject = null;
      localContentValues.put("advertiser_image_data", (byte[])localObject);
      localContentValues.put("body", l);
      localContentValues.put("expiration", Long.valueOf(m));
      localContentValues.put("reason", Integer.valueOf(n));
      localContentValues.put("apm_extra_targeting_data", o);
      if (!p) {
        break label708;
      }
      i = 1;
      label156:
      localContentValues.put("starred", Integer.valueOf(i));
      localContentValues.put("view_status", Integer.valueOf(q));
      localContentValues.put("view", r);
      localContentValues.put("slot", s);
      localContentValues.put("apm_xsrf_token", t);
      localContentValues.put("delete_status", Integer.valueOf(u));
      localContentValues.put("wta_data", v);
      localContentValues.put("view_url", w);
      localContentValues.put("click_url", x);
      localContentValues.put("interaction_url", y);
      if (z != null) {
        break label713;
      }
    }
    label708:
    label713:
    for (Object localObject = "";; localObject = TextUtils.join(",", z))
    {
      localContentValues.put("body_view_urls", (String)localObject);
      localContentValues.put("obfuscated_data", A);
      localContentValues.put("report_ad_server", Boolean.valueOf(B.a));
      localContentValues.put("report_bow", Boolean.valueOf(B.b));
      localContentValues.put("send_body", Boolean.valueOf(B.c));
      localContentValues.put("show_body_feedback_survey", Boolean.valueOf(B.d));
      localContentValues.put("report_duration_since_last_action", Boolean.valueOf(B.e));
      localContentValues.put("click_id", C);
      localContentValues.put("aia_star_rating", Float.valueOf(D.a));
      localContentValues.put("aia_ratings_count", Integer.valueOf(D.b));
      localContentValues.put("aia_package_name", D.c);
      localContentValues.put("aia_inline_install_enabled", Boolean.valueOf(D.d));
      localContentValues.put("aia_teaser_experiment", Integer.valueOf(D.e));
      localContentValues.put("aia_body_experiment", Integer.valueOf(D.f));
      localContentValues.put("aia_referrer", D.g);
      localContentValues.put("aia_install_url", D.h);
      localContentValues.put("aia_install_button_url", D.i);
      localContentValues.put("last_shown_timestamp", Long.valueOf(G));
      localContentValues.put("last_clicked_timestamp", Long.valueOf(H));
      localContentValues.put("last_starred_timestamp", Long.valueOf(I));
      localContentValues.put("dismiss_survey_data", E);
      localContentValues.put("wta_get_url", K);
      localContentValues.put("wta_tooltip_type", Integer.valueOf(L));
      localContentValues.put("tab", Integer.valueOf(M));
      localContentValues.put("ad_client_dedup_id_data", N);
      localContentValues.put("report_duration_since_last_action_to_bow", Boolean.valueOf(B.f));
      localContentValues.put("report_click_id_for_click_event", Boolean.valueOf(B.g));
      return localContentValues;
      localObject = new ByteArrayOutputStream();
      k.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      break;
      i = 0;
      break label156;
    }
  }
  
  private final Set<String> c(Advertisement paramAdvertisement)
  {
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add(e);
    ccy localccy = new ccy(a(dpy.o, null), Advertisement.O);
    try
    {
      while (localccy.moveToNext())
      {
        Advertisement localAdvertisement = (Advertisement)localccy.f();
        if (localAdvertisement != null)
        {
          HashSet localHashSet2 = new HashSet(paramAdvertisement.a());
          localHashSet2.retainAll(new HashSet(localAdvertisement.a()));
          if (localHashSet2.size() > 0) {
            localHashSet1.add(e);
          }
        }
      }
    }
    finally
    {
      localccy.close();
    }
    return localHashSet1;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString;
    if (paramString == null)
    {
      paramString = "_id IN ( SELECT MAX(_id) FROM ads   WHERE expiration >= ?    GROUP BY tab)";
      arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(System.currentTimeMillis());
    }
    for (;;)
    {
      return d.query("ads", paramArrayOfString, paramString, arrayOfString, null, null, "tab", null);
      String str = "event_id = ?";
      arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      paramString = str;
    }
  }
  
  public final void a(Advertisement paramAdvertisement)
  {
    String str = e;
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("delete_status", Integer.valueOf(u));
    if (d.update("ads", localContentValues, "event_id = ?", new String[] { str }) > 0) {
      a(Collections.singleton(str));
    }
  }
  
  public final void a(Advertisement paramAdvertisement, int paramInt)
  {
    a(paramAdvertisement, paramInt, null, true);
  }
  
  public final void a(Advertisement paramAdvertisement, int paramInt, String paramString)
  {
    a(paramAdvertisement, paramInt, paramString, true);
  }
  
  public final void a(Advertisement paramAdvertisement, boolean paramBoolean)
  {
    if (paramAdvertisement == null) {
      return;
    }
    Set localSet;
    int j;
    if (paramBoolean)
    {
      i = 8;
      a(paramAdvertisement, i);
      localSet = c(paramAdvertisement);
      j = localSet.size() - 1;
      hbe.a("?, ");
      if (j > 1) {
        break label213;
      }
      if (j < 0) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label96;
      }
      throw new IllegalArgumentException(hbe.a("invalid count: %s", new Object[] { Integer.valueOf(j) }));
      i = 3;
      break;
    }
    label96:
    if (j == 0) {
      paramAdvertisement = "";
    }
    for (;;)
    {
      paramAdvertisement = paramAdvertisement.concat("?");
      SQLiteDatabase localSQLiteDatabase = d;
      String str = String.valueOf("event_id IN (");
      localSQLiteDatabase.delete("ads", String.valueOf(str).length() + 1 + String.valueOf(paramAdvertisement).length() + str + paramAdvertisement + ")", (String[])localSet.toArray(new String[localSet.size()]));
      a(localSet);
      return;
      paramAdvertisement = "?, ";
      continue;
      label213:
      i = "?, ".length();
      long l = i * j;
      j = (int)l;
      if (j != l) {
        throw new ArrayIndexOutOfBoundsException(51 + "Required array size too large: " + l);
      }
      paramAdvertisement = new char[j];
      "?, ".getChars(0, i, paramAdvertisement, 0);
      while (i < j - i)
      {
        System.arraycopy(paramAdvertisement, 0, paramAdvertisement, i, i);
        i <<= 1;
      }
      System.arraycopy(paramAdvertisement, 0, paramAdvertisement, i, j - i);
      paramAdvertisement = new String(paramAdvertisement);
    }
  }
  
  public final void a(Advertisement paramAdvertisement, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    String str2;
    label41:
    ContentValues localContentValues;
    if (paramBoolean2) {
      if (paramBoolean1)
      {
        i = 20;
        a(paramAdvertisement, i, null, false);
        f.l();
        str2 = e;
        if (!paramBoolean1) {
          break label156;
        }
        i = 2;
        localContentValues = new ContentValues(i);
        if (!paramBoolean1) {
          break label162;
        }
      }
    }
    label156:
    label162:
    for (String str1 = "1";; str1 = "0")
    {
      localContentValues.put("starred", str1);
      if (paramBoolean1)
      {
        I = System.currentTimeMillis();
        localContentValues.put("last_starred_timestamp", Long.valueOf(I));
      }
      d.update("ads", localContentValues, "event_id = ?", new String[] { str2 });
      a(Collections.singleton(str2));
      return;
      i = 21;
      break;
      if (paramBoolean1)
      {
        i = 4;
        break;
      }
      i = 9;
      break;
      i = 1;
      break label41;
    }
  }
  
  public final void a(Collection<String> paramCollection)
  {
    a(b, c, paramCollection);
  }
}

/* Location:
 * Qualified Name:     dos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */