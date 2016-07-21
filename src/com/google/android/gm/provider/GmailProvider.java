package com.google.android.gm.provider;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import buo;
import but;
import cfm;
import cfr;
import cfw;
import cge;
import cgk;
import cgr;
import cgy;
import cha;
import chh;
import chl;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.providers.ListParams;
import com.android.mail.providers.Message;
import com.google.android.gm.ConversationInfo;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import ctl;
import cus;
import cuu;
import cvm;
import cvp;
import cvq;
import cvr;
import cwl;
import ddy;
import deg;
import dfh;
import dfk;
import dfl;
import dfz;
import dge;
import dkn;
import dms;
import dmv;
import dnd;
import dnm;
import dos;
import dpa;
import dpy;
import dqc;
import dqg;
import dqm;
import dqn;
import dqo;
import dqp;
import dqq;
import dqz;
import drd;
import drf;
import dri;
import drj;
import drk;
import drp;
import dsj;
import dst;
import dth;
import dtn;
import dtu;
import dtv;
import duf;
import duy;
import dvd;
import dvj;
import dvk;
import dvl;
import dvn;
import dvo;
import dvp;
import dvs;
import dvt;
import dyr;
import dyv;
import ghz;
import gwt;
import hef;
import hen;
import hfd;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import nx;
import org.apache.http.client.CookieStore;
import org.json.JSONArray;

public class GmailProvider
  extends ContentProvider
  implements SharedPreferences.OnSharedPreferenceChangeListener, dst
{
  public static int b;
  public static String c;
  public static final Map<String, dvj> e = new HashMap();
  private static final String[] f = { "^^out" };
  private static final Uri g = Uri.parse("content://com.android.gmail.ui/accounts");
  private static final Uri h = Uri.parse("setting://gmail/");
  private static final Uri i = Uri.parse("auth://gmail/");
  private static final String[] j = { "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR" };
  private static final hfd<String> k = hfd.b("null");
  private static final int l = "search".hashCode();
  private static final UriMatcher m = new UriMatcher(-1);
  private static final hfd<String> n = hfd.a("^u", "^t", "^o");
  private static Map<String, CharSequence> s;
  private static GmailProvider u;
  private static final Map<String, Map<String, String>> v;
  private static final Map<String, Integer> y = new hen().b("^t", Integer.valueOf(128)).b("^i", Integer.valueOf(2)).b("^iim", Integer.valueOf(2)).b("^r", Integer.valueOf(4)).b("^^out", Integer.valueOf(8)).b("^f", Integer.valueOf(16)).b("^k", Integer.valueOf(32)).b("^s", Integer.valueOf(64)).b("^all", Integer.valueOf(512)).b("^im", Integer.valueOf(256)).b("^sq_ig_i_personal", Integer.valueOf(1026)).b("^sq_ig_i_social", Integer.valueOf(1026)).b("^sq_ig_i_promo", Integer.valueOf(1026)).b("^sq_ig_i_notification", Integer.valueOf(1026)).b("^sq_ig_i_group", Integer.valueOf(1026)).b();
  public final Set<String> a = new HashSet();
  public android.accounts.Account[] d;
  private ContentResolver o;
  private dpy p;
  private boolean q = false;
  private volatile boolean r = false;
  private final Map<String, dqo> t = new HashMap();
  private int w = -1;
  private final List<dqq> x = new ArrayList();
  
  static
  {
    m.addURI("com.android.gmail.ui", "accounts", 1);
    m.addURI("com.android.gmail.ui", "*/account", 2);
    m.addURI("com.android.gmail.ui", "*/labels", 3);
    m.addURI("com.android.gmail.ui", "*/label/*", 18);
    m.addURI("com.android.gmail.ui", "*/conversations/*", 4);
    m.addURI("com.android.gmail.ui", "*/conversationsForLabel/*", 5);
    m.addURI("com.android.gmail.ui", "*/conversationMessages/#", 6);
    m.addURI("com.android.gmail.ui", "*/messageAttachments/#/#", 22);
    m.addURI("com.android.gmail.ui", "*/messageAttachment/#/#/*", 23);
    m.addURI("com.android.gmail.ui", "*/messages", 7);
    m.addURI("com.android.gmail.ui", "*/sendNewMessage", 8);
    m.addURI("com.android.gmail.ui", "*/saveNewMessage", 9);
    m.addURI("com.android.gmail.ui", "*/expungeMessage", 24);
    m.addURI("com.android.gmail.ui", "*/message/#", 10);
    m.addURI("com.android.gmail.ui", "*/message/save", 11);
    m.addURI("com.android.gmail.ui", "*/message/send", 12);
    m.addURI("com.android.gmail.ui", "*/undo", 15);
    m.addURI("com.android.gmail.ui", "*/refresh", 17);
    m.addURI("com.android.gmail.ui", "*/refresh/*", 16);
    m.addURI("com.android.gmail.ui", "*/conversation/#", 13);
    m.addURI("com.android.gmail.ui", "*/conversationInlineResource/#/*", 14);
    m.addURI("com.android.gmail.ui", "*/search", 19);
    m.addURI("com.android.gmail.ui", "*/searchMessageGeneric/*", 34);
    m.addURI("com.android.gmail.ui", "*/searchConversations", 20);
    m.addURI("com.android.gmail.ui", "*/recentFolders", 21);
    m.addURI("com.android.gmail.ui", "*/defaultRecentFolders", 25);
    m.addURI("com.android.gmail.ui", "*/cookie", 26);
    m.addURI("com.android.gmail.ui", "*/settings", 27);
    m.addURI("com.android.gmail.ui", "*/messageserverid/#", 28);
    m.addURI("com.android.gmail.ui", "*/ads", 29);
    m.addURI("com.android.gmail.ui", "*/ad/*", 30);
    m.addURI("com.android.gmail.ui", "*/promo", 31);
    m.addURI("com.android.gmail.ui", "*/settingsSnapshot", 32);
    m.addURI("com.android.gmail.ui", "*/vacationResponderSettings", 33);
    m.addURI("com.android.gmail.ui", "*/oauthToken", 38);
    m.addURI("com.android.gmail.ui", "*/oauthChanged", 41);
    cgy.a(m, "com.android.gmail.ui", "*/drive", 35, 36, 37, 39, 40);
    v = new HashMap();
  }
  
  private final int a(drp paramdrp, String paramString, ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.keySet();
    paramContentValues = new ContentValues(paramContentValues.size());
    long l1 = System.currentTimeMillis();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramContentValues.put(Uri.parse((String)((Iterator)localObject).next()).getLastPathSegment(), Long.valueOf(l1));
    }
    localObject = paramContentValues.keySet();
    if (dri.a("Gmail", 2)) {
      dri.a("Gmail", "Updating last touched for labels: %s", new Object[] { dri.a((Set)localObject) });
    }
    int i1 = paramdrp.b(paramContentValues);
    o.notifyChange(l(paramString), null, false);
    return i1;
  }
  
  private final int a(String paramString, ContentValues paramContentValues)
  {
    boolean bool = true;
    int i1;
    if (!paramContentValues.containsKey("_id")) {
      i1 = 0;
    }
    drp localdrp;
    int i2;
    do
    {
      return i1;
      localdrp = n(paramString);
      long l1 = paramContentValues.getAsLong("_id").longValue();
      paramString = g(paramString, l1);
      try
      {
        if (paramString.moveToFirst()) {
          bool = new Message(paramString).p();
        }
        for (;;)
        {
          paramString.close();
          if (bool) {
            break;
          }
          return 0;
          dri.d("Gmail", "Could not retrieve the draft (ID#: %d) while trying to expunge it", new Object[] { Long.valueOf(l1) });
        }
        paramString = localdrp.a(l1, false);
      }
      finally
      {
        paramString.close();
      }
      i2 = localdrp.b(l1);
      i1 = i2;
    } while (paramString == null);
    o.notifyChange(c(l.name, d), null, false);
    return i2;
  }
  
  private static int a(String paramString, ContentValues paramContentValues, drp paramdrp)
  {
    if ((!paramContentValues.containsKey("seen")) || (paramContentValues.getAsInteger("seen").intValue() != 1)) {
      return 0;
    }
    Object localObject = paramdrp.a(new String[] { paramString });
    paramString = paramdrp.a(new String[] { dpy.k(paramString) });
    if ((localObject.length > 0) && (paramString.length > 0))
    {
      localObject = localObject[0];
      drk localdrk = paramString[0];
      if (localdrk != null)
      {
        paramString = paramContentValues.getAsString("conversationUri");
        if (TextUtils.isEmpty(paramString)) {}
        for (paramString = null; TextUtils.isEmpty(paramString); paramString = (String)Uri.parse(paramString).getPathSegments().get(2)) {
          return paramdrp.a((drk)localObject, localdrk);
        }
        try
        {
          long l1 = Long.parseLong(paramString);
          paramContentValues = Long.toString(a);
          int i1 = p.delete("conversation_labels", "labels_id=? and conversation_id=?", new String[] { paramContentValues, String.valueOf(l1) });
          return i1;
        }
        catch (NumberFormatException paramContentValues)
        {
          dri.d("Gmail", paramContentValues, "Error parsing %s", new Object[] { paramString });
        }
      }
    }
    return 0;
  }
  
  public static int a(Map<String, dqz> paramMap)
  {
    if (paramMap.containsKey("^punsub")) {
      return 3;
    }
    if (paramMap.containsKey("^p_aunsub")) {
      return 2;
    }
    if (paramMap.containsKey("^p_mtunsub")) {
      return 1;
    }
    return 0;
  }
  
  private int a(String[] paramArrayOfString, String paramString, dfk paramdfk, dqq paramdqq)
  {
    if (a.size() == 0) {
      return 0;
    }
    drp localdrp = n(paramString);
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = paramArrayOfString[i1];
      localObject1 = localdrp.a(dpy.r, (String)localObject1, paramString);
      if (localObject1 != null) {
        localArrayList1.add(localObject1);
      }
      i1 += 1;
    }
    Iterator localIterator = localArrayList1.iterator();
    ConversationInfo localConversationInfo;
    long l1;
    long l2;
    long l3;
    long l4;
    Map localMap;
    label261:
    Object localObject2;
    label502:
    label517:
    label522:
    label538:
    label544:
    String str;
    if (localIterator.hasNext())
    {
      localConversationInfo = (ConversationInfo)localIterator.next();
      l1 = b;
      l2 = c;
      l3 = d;
      l4 = a;
      localMap = localdrp.c(getContext(), String.valueOf(l4));
      localObject1 = paramdfk.c();
      if ((((List)localObject1).size() == 2) && (get0a != get1a))
      {
        i1 = 1;
        if (i1 == 0) {
          break label517;
        }
        if (!get0a) {
          break label502;
        }
        paramArrayOfString = (dfl)((List)localObject1).get(0);
        if (i1 == 0) {
          break label538;
        }
        if (!get0a) {
          break label522;
        }
        localObject1 = (dfl)((List)localObject1).get(1);
      }
      for (;;)
      {
        if ((paramdqq != null) && (i1 != 0) && (paramArrayOfString != null))
        {
          localObject2 = b.b();
          if (localMap.containsKey(localObject2))
          {
            dri.c("Gmail", "Move operation to a label we already have. Removing it from the undo operation.", new Object[0]);
            paramdqq.a((String)localObject2);
          }
        }
        if (!o.a("bx_pie", false)) {
          break label1763;
        }
        if ((i1 == 0) || (paramArrayOfString == null) || (localObject1 == null) || (!dpy.a.contains(b.b())) || (dpy.a.contains(b.b()))) {
          break label544;
        }
        dri.c("Gmail", "Moving from section to non-inbox label. Remove ^i/^iim.", new Object[0]);
        i1 = 0;
        while (i1 < 2)
        {
          paramArrayOfString = new String[] { "^i", "^iim" }[i1];
          paramArrayOfString = drd.a(getContext(), paramString, paramArrayOfString);
          paramdfk.a(paramArrayOfString, false);
          if (paramdqq != null) {
            paramdqq.a(paramArrayOfString, true);
          }
          i1 += 1;
        }
        i1 = 0;
        break;
        paramArrayOfString = (dfl)((List)localObject1).get(1);
        break label261;
        paramArrayOfString = null;
        break label261;
        localObject1 = (dfl)((List)localObject1).get(0);
        continue;
        localObject1 = null;
      }
      if (paramdfk.c("^i"))
      {
        paramArrayOfString = localMap.keySet().iterator();
        while (paramArrayOfString.hasNext())
        {
          localObject1 = (String)paramArrayOfString.next();
          if ((dpy.a.contains(localObject1)) && (!paramdfk.c((String)localObject1)))
          {
            localObject1 = (dqz)localMap.get(localObject1);
            paramdfk.a((dqz)localObject1, false);
            if (paramdqq != null) {
              paramdqq.a((dqz)localObject1, true);
            }
          }
        }
      }
      if (!paramdfk.c("^i"))
      {
        paramArrayOfString = new HashSet();
        localObject1 = dpy.a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (localMap.containsKey(localObject2)) {
            paramArrayOfString.add(localObject2);
          }
        }
        if (!paramArrayOfString.isEmpty())
        {
          localObject1 = paramdfk.c().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dfl)((Iterator)localObject1).next();
            str = b.b();
            if ((paramArrayOfString.contains(str)) && (!a)) {
              paramArrayOfString.remove(str);
            } else if ((dpy.a.contains(str)) && (a)) {
              paramArrayOfString.add(str);
            }
          }
          if (paramArrayOfString.isEmpty())
          {
            dri.c("Gmail", "Removing all sections, so also remove ^i/^iim", new Object[0]);
            i1 = 0;
            while (i1 < 2)
            {
              paramArrayOfString = new String[] { "^i", "^iim" }[i1];
              paramArrayOfString = drd.a(getContext(), paramString, paramArrayOfString);
              paramdfk.a(paramArrayOfString, false);
              if (paramdqq != null) {
                paramdqq.a(paramArrayOfString, true);
              }
              i1 += 1;
            }
          }
        }
      }
      localObject1 = paramdfk.c().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (dfl)((Iterator)localObject1).next();
        paramArrayOfString = b.b();
      } while ((!a) || (!dpy.a.contains(paramArrayOfString)));
    }
    for (;;)
    {
      if (paramArrayOfString != null)
      {
        dri.c("Gmail", "Moving to an inbox section, removing other sections", new Object[0]);
        localObject1 = localMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((dpy.a.contains(localObject2)) && (!paramArrayOfString.equals(localObject2)))
          {
            localObject2 = drd.a(getContext(), paramString, (String)localObject2);
            paramdfk.a((dqz)localObject2, false);
            if (paramdqq != null) {
              paramdqq.a((dqz)localObject2, true);
            }
          }
        }
      }
      paramArrayOfString = o.f();
      boolean bool1;
      if (paramArrayOfString == null) {
        bool1 = false;
      }
      while ((bool1) && (localMap.containsKey("^t")) && (!paramdfk.c("^t")))
      {
        paramArrayOfString = new HashSet();
        localObject1 = dpy.a.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (localMap.containsKey(localObject2))
            {
              paramArrayOfString.add(localObject2);
              continue;
              bool1 = c;
              break;
            }
          }
        }
        localObject1 = paramdfk.c().iterator();
        i1 = 0;
        label1223:
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dfl)((Iterator)localObject1).next();
          str = b.b();
          if (!dpy.a.contains(str)) {
            break label2684;
          }
          if (a)
          {
            paramArrayOfString.add(str);
          }
          else
          {
            paramArrayOfString.remove(str);
            if (!"^sq_ig_i_personal".equals(str)) {
              break label2684;
            }
            i1 = 1;
          }
        }
      }
      label1544:
      label1622:
      label1763:
      label1867:
      label1958:
      label1993:
      label2106:
      label2188:
      label2321:
      label2327:
      label2333:
      label2437:
      label2675:
      label2681:
      label2684:
      for (;;)
      {
        break label1223;
        if ((i1 != 0) && (!paramArrayOfString.isEmpty()))
        {
          dri.c("Gmail", "Trying to remove Primary from starred message that still has other sections. Keeping Primary.", new Object[0]);
          paramdfk.a("^sq_ig_i_personal");
          if (paramdqq != null) {
            paramdqq.a("^sq_ig_i_personal");
          }
          paramArrayOfString = localArrayList2.iterator();
          while (paramArrayOfString.hasNext())
          {
            localObject1 = (ContentValues)paramArrayOfString.next();
            if (("^sq_ig_i_personal".equals(((ContentValues)localObject1).get("canonicalName"))) && (Boolean.FALSE.equals(((ContentValues)localObject1).getAsBoolean("add_label_action")))) {
              paramArrayOfString.remove();
            }
          }
          paramArrayOfString = localArrayList3.iterator();
          while (paramArrayOfString.hasNext())
          {
            localObject1 = (ContentValues)paramArrayOfString.next();
            if (("^sq_ig_i_personal".equals(((ContentValues)localObject1).get("canonicalName"))) && (Boolean.FALSE.equals(((ContentValues)localObject1).getAsBoolean("add_label_action")))) {
              paramArrayOfString.remove();
            }
          }
        }
        paramArrayOfString = o.f();
        if (paramArrayOfString == null)
        {
          bool1 = false;
          if (!bool1) {
            break label1763;
          }
          if (!paramdfk.b("^t")) {
            break label1622;
          }
          bool1 = a.get("^t")).a;
        }
        for (;;)
        {
          if (bool1)
          {
            paramArrayOfString = new HashSet();
            localObject1 = dpy.a.iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                if (localMap.containsKey(localObject2))
                {
                  paramArrayOfString.add(localObject2);
                  continue;
                  bool1 = c;
                  break;
                  bool1 = false;
                  break label1544;
                }
              }
            }
            localObject1 = paramdfk.c().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (dfl)((Iterator)localObject1).next();
              str = b.b();
              if (dpy.a.contains(str)) {
                if (a) {
                  paramArrayOfString.add(str);
                } else {
                  paramArrayOfString.remove(str);
                }
              }
            }
            if ((!paramArrayOfString.isEmpty()) && (!paramArrayOfString.contains("^sq_ig_i_personal")))
            {
              dri.c("Gmail", "Adding star, so also adding primary", new Object[0]);
              localdrp.a(l4, l3, "^sq_ig_i_personal", true, 0);
            }
          }
        }
        paramArrayOfString = paramdfk.c().iterator();
        if (!paramArrayOfString.hasNext()) {
          break;
        }
        localObject1 = (dfl)paramArrayOfString.next();
        localObject2 = b;
        boolean bool2 = a;
        localObject1 = new HashMap();
        localObject2 = ((dqz)localObject2).b();
        ((Map)localObject1).put(localObject2, Boolean.valueOf(bool2));
        ContentValues localContentValues;
        if (("^k".equals(localObject2)) || ("^g".equals(localObject2)))
        {
          if (!bool2)
          {
            bool1 = true;
            ((Map)localObject1).put("^i", Boolean.valueOf(bool1));
          }
        }
        else
        {
          if (("^i".equals(localObject2)) && (bool2))
          {
            ((Map)localObject1).put("^s", Boolean.FALSE);
            ((Map)localObject1).put("^k", Boolean.FALSE);
          }
          if (((!"^^important".equals(localObject2)) || (!bool2)) && ((!"^^unimportant".equals(localObject2)) || (bool2))) {
            break label2321;
          }
          i1 = 1;
          if (((!"^^unimportant".equals(localObject2)) || (!bool2)) && ((!"^^important".equals(localObject2)) || (bool2))) {
            break label2327;
          }
          i2 = 1;
          if (i1 == 0) {
            break label2333;
          }
          ((Map)localObject1).put("^im", Boolean.TRUE);
          ((Map)localObject1).put("^io_im", Boolean.TRUE);
          ((Map)localObject1).put("^imi", Boolean.TRUE);
          ((Map)localObject1).put("^imn", Boolean.FALSE);
          ((Map)localObject1).put("^^unimportant", Boolean.FALSE);
          ((Map)localObject1).put("^io_ns", Boolean.FALSE);
          if (localMap.containsKey("^i")) {
            ((Map)localObject1).put("^iim", Boolean.TRUE);
          }
          if ((((Map)localObject1).containsKey("^i")) && (localConversationInfo.a())) {
            ((Map)localObject1).put("^iim", Boolean.valueOf(((Boolean)((Map)localObject1).get("^i")).booleanValue()));
          }
          i2 = ((Map)localObject1).size();
          localObject2 = (String[])((Map)localObject1).keySet().toArray(new String[i2]);
          i1 = 0;
          if (i1 < i2)
          {
            str = localObject2[i1];
            bool1 = ((Boolean)((Map)localObject1).get(str)).booleanValue();
            if (l1 == 0L) {
              break label2437;
            }
            localContentValues = new ContentValues(5);
            localContentValues.put("canonicalName", str);
            localContentValues.put("_id", Long.valueOf(l1));
            localContentValues.put("messageId", Long.valueOf(l2));
            localContentValues.put("conversation", Long.valueOf(l4));
            localContentValues.put("add_label_action", Boolean.valueOf(bool1));
            localArrayList2.add(localContentValues);
          }
        }
        for (;;)
        {
          i1 += 1;
          break label2188;
          break;
          bool1 = false;
          break label1867;
          i1 = 0;
          break label1958;
          i2 = 0;
          break label1993;
          if (i2 == 0) {
            break label2106;
          }
          ((Map)localObject1).put("^imn", Boolean.TRUE);
          ((Map)localObject1).put("^im", Boolean.FALSE);
          ((Map)localObject1).put("^io_im", Boolean.FALSE);
          ((Map)localObject1).put("^iim", Boolean.FALSE);
          ((Map)localObject1).put("^imi", Boolean.FALSE);
          ((Map)localObject1).put("^^important", Boolean.FALSE);
          ((Map)localObject1).put("^io_ns", Boolean.FALSE);
          break label2106;
          localContentValues = new ContentValues(4);
          localContentValues.put("_id", Long.valueOf(l4));
          localContentValues.put("canonicalName", str);
          localContentValues.put("maxMessageId", Long.valueOf(d));
          localContentValues.put("add_label_action", Boolean.valueOf(bool1));
          localArrayList3.add(localContentValues);
        }
        bool1 = paramdfk.d();
        if (localArrayList3.size() > 0)
        {
          paramdfk = p;
          paramdqq = (ContentValues[])localArrayList3.toArray(new ContentValues[localArrayList3.size()]);
          if (!bool1) {}
          for (i1 = 1; TextUtils.isEmpty(paramString); i1 = 0) {
            throw new IllegalArgumentException("account is empty");
          }
          paramArrayOfString = dpy.a(paramString, "/conversations/labels");
          if (i1 == 0) {
            break label2681;
          }
          paramArrayOfString = paramArrayOfString.buildUpon().appendQueryParameter("suppressUINotifications", Boolean.TRUE.toString()).build();
        }
        for (;;)
        {
          w.bulkInsert(paramArrayOfString, paramdqq);
          if (localArrayList2.size() > 0)
          {
            paramArrayOfString = p;
            paramdfk = (ContentValues[])localArrayList2.toArray(new ContentValues[localArrayList2.size()]);
            if (bool1) {
              break label2675;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            paramArrayOfString.a(paramString, paramdfk, bool1);
            return localArrayList1.size();
          }
        }
      }
      paramArrayOfString = null;
    }
  }
  
  private final long a(drp paramdrp, long paramLong, boolean paramBoolean, ContentValues paramContentValues, Bundle paramBundle)
  {
    paramContentValues = new ContentValues(paramContentValues);
    long l1 = paramContentValues.getAsLong("refMessageId").longValue();
    paramContentValues.remove("refMessageId");
    paramLong = paramdrp.a(paramLong, paramBoolean, l1, paramContentValues, paramBundle);
    paramContentValues = paramdrp.a(paramLong, false);
    if (paramContentValues != null) {
      o.notifyChange(c(l.name, d), null, false);
    }
    return paramLong;
  }
  
  private final long a(drp paramdrp, Bundle paramBundle)
  {
    if (paramBundle.containsKey("_id")) {}
    for (long l1 = paramBundle.getLong("_id");; l1 = 0L)
    {
      Bundle localBundle = (Bundle)paramBundle.getParcelable("opened_fds");
      return a(paramdrp, l1, true, a(paramBundle), localBundle);
    }
  }
  
  private static ContentValues a(Bundle paramBundle)
  {
    boolean bool2 = true;
    long l3 = 0L;
    long l1;
    ContentValues localContentValues;
    if (paramBundle.containsKey("_id"))
    {
      l1 = paramBundle.getLong("_id");
      localContentValues = new ContentValues(paramBundle.size());
      localContentValues.put("toAddresses", o(paramBundle.getString("toAddresses")));
      localContentValues.put("ccAddresses", o(paramBundle.getString("ccAddresses")));
      localContentValues.put("bccAddresses", o(paramBundle.getString("bccAddresses")));
      localContentValues.put("subject", paramBundle.getString("subject"));
      localContentValues.put("snippet", paramBundle.getString("snippet"));
      localContentValues.put("replyToAddresses", paramBundle.getString("replyToAddress"));
      localContentValues.put("fromAddress", paramBundle.getString("fromAddress"));
      localObject1 = Address.f(paramBundle.getString("customFrom"));
      if (localObject1 == null) {
        break label311;
      }
    }
    Object localObject3;
    label311:
    for (Object localObject1 = a;; localObject1 = null)
    {
      localContentValues.put("customFromAddress", (String)localObject1);
      localObject2 = paramBundle.getString("attachments");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label333;
      }
      localObject1 = new ArrayList();
      localObject2 = GmailAttachment.d((String)localObject2).iterator();
      int i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Attachment)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(b)) {
          b = (16 + "local" + i1);
        }
        ((List)localObject1).add(((Attachment)localObject3).n());
        i1 += 1;
      }
      l1 = 0L;
      break;
    }
    localContentValues.put("joinedAttachmentInfos", TextUtils.join("\n", (Iterable)localObject1));
    label333:
    Object localObject2 = paramBundle.getString("bodyHtml");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = paramBundle.getString("bodyText");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = Html.toHtml(new SpannedString((CharSequence)localObject3));
      }
    }
    localContentValues.put("body", (String)localObject1);
    localContentValues.put("stylesheet", paramBundle.getString("stylesheet"));
    localContentValues.put("stylesheetRestrictor", paramBundle.getString("stylesheetRestrictor"));
    if (paramBundle.getInt("appendRefMessageContent", 0) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localContentValues.put("includeQuotedText", Boolean.valueOf(bool1));
      if (paramBundle.containsKey("quotedTextStartPos")) {
        localContentValues.put("quoteStartPos", Integer.valueOf(paramBundle.getInt("quotedTextStartPos")));
      }
      l2 = l3;
      if (l1 == 0L)
      {
        if (paramBundle.containsKey("refMessageId")) {
          break;
        }
        l2 = l3;
      }
      localContentValues.put("refMessageId", Long.valueOf(l2));
      if (paramBundle.containsKey("refAdEventId")) {
        localContentValues.put("refAdEventId", paramBundle.getString("refAdEventId"));
      }
      return localContentValues;
    }
    long l2 = Long.parseLong(Uri.parse(paramBundle.getString("refMessageId")).getLastPathSegment());
    if (paramBundle.getInt("draftType") == 4) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localContentValues.put("forward", Boolean.valueOf(bool1));
      break;
    }
  }
  
  public static Cursor a(drp paramdrp, String paramString1, String[] paramArrayOfString, Cursor paramCursor, String paramString2)
  {
    if (paramCursor == null) {
      return null;
    }
    return new dvs(paramCursor, paramdrp, paramString1, paramArrayOfString, paramString2);
  }
  
  private final Cursor a(dvn paramdvn, String[] paramArrayOfString)
  {
    long l1 = b;
    String str1 = a;
    Object localObject = e;
    long l2 = c;
    long l3 = d;
    List localList = f;
    String[] arrayOfString = chl.a(paramArrayOfString, chh.o);
    paramArrayOfString = a(str1, l1, l2);
    paramdvn = paramArrayOfString;
    if (paramArrayOfString == null)
    {
      dri.d("Gmail", "getAttachments failed with account: %s, conversationId: %d, serverMessageId: %d", new Object[] { str1, Long.valueOf(l1), Long.valueOf(l2) });
      paramdvn = new ArrayList();
    }
    if ((paramdvn.size() > 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      dri.b("Gmail", "Looking for attachment partId: %s", new Object[] { localObject });
      paramArrayOfString = paramdvn.iterator();
      for (;;)
      {
        if (paramArrayOfString.hasNext())
        {
          paramdvn = (GmailAttachment)paramArrayOfString.next();
          if (((String)localObject).equalsIgnoreCase(b))
          {
            dri.b("Gmail", "Found attachment", new Object[0]);
            if (paramdvn != null) {
              paramdvn = Collections.singletonList(paramdvn);
            }
          }
        }
      }
    }
    for (;;)
    {
      paramArrayOfString = paramdvn;
      if (paramdvn != null)
      {
        paramArrayOfString = paramdvn;
        if (paramdvn.size() > 0)
        {
          paramArrayOfString = paramdvn;
          if (localList != null)
          {
            paramArrayOfString = paramdvn;
            if (!localList.isEmpty())
            {
              paramArrayOfString = new ArrayList();
              label248:
              paramdvn = paramdvn.iterator();
              for (;;)
              {
                if (paramdvn.hasNext())
                {
                  localObject = (GmailAttachment)paramdvn.next();
                  Iterator localIterator = localList.iterator();
                  if (localIterator.hasNext())
                  {
                    String str2 = (String)localIterator.next();
                    String str3 = ((GmailAttachment)localObject).l();
                    if ((str3 == null) || (!str3.startsWith(str2))) {
                      break label248;
                    }
                    paramArrayOfString.add(localObject);
                    continue;
                    paramdvn = Collections.emptyList();
                    break;
                  }
                }
              }
            }
          }
        }
      }
      return a(str1, l1, l2, l3, arrayOfString, paramArrayOfString);
      paramdvn = null;
      break;
    }
  }
  
  private final Cursor a(String paramString, long paramLong1, long paramLong2, long paramLong3, String[] paramArrayOfString, List<GmailAttachment> paramList)
  {
    dqp localdqp = new dqp(this, paramString, paramLong1, paramArrayOfString, paramList.size());
    Object localObject2 = f(paramString, paramLong1);
    for (;;)
    {
      MatrixCursor.RowBuilder localRowBuilder;
      String str1;
      String str2;
      synchronized (b)
      {
        b.put(localdqp, null);
        ??? = paramList.iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localObject2 = (GmailAttachment)((Iterator)???).next();
        dri.b("Gmail", "adding attachment to cursor %s", new Object[] { localObject2 });
        localRowBuilder = localdqp.newRow();
        str1 = b;
        str2 = ((GmailAttachment)localObject2).l();
        int i3 = paramArrayOfString.length;
        int i1 = 0;
        if (i1 >= i3) {
          continue;
        }
        paramList = paramArrayOfString[i1];
        if (TextUtils.equals(paramList, "uri"))
        {
          localRowBuilder.add(a(paramString, paramLong1, paramLong2, paramLong3, str1, str2));
          i1 += 1;
        }
      }
      if (TextUtils.equals(paramList, "_display_name"))
      {
        localRowBuilder.add(c);
      }
      else if (TextUtils.equals(paramList, "_size"))
      {
        localRowBuilder.add(Integer.valueOf(d));
      }
      else if (TextUtils.equals(paramList, "contentType"))
      {
        localRowBuilder.add(str2);
      }
      else if (TextUtils.equals(paramList, "state"))
      {
        if (r == 1) {
          localRowBuilder.add(Integer.valueOf(3));
        } else {
          localRowBuilder.add(Integer.valueOf(f));
        }
      }
      else if (TextUtils.equals(paramList, "destination"))
      {
        localRowBuilder.add(Integer.valueOf(g));
      }
      else if (TextUtils.equals(paramList, "downloadedSize"))
      {
        localRowBuilder.add(Integer.valueOf(h));
      }
      else
      {
        if (TextUtils.equals(paramList, "contentUri"))
        {
          if (cvr.a(((Attachment)localObject2).l())) {
            if (v != null) {
              paramList = Uri.parse(v);
            }
          }
          for (;;)
          {
            localRowBuilder.add(paramList);
            break;
            paramList = Uri.EMPTY;
            continue;
            paramList = dpy.a(paramString, paramLong3, str1, 1, false);
          }
        }
        if (TextUtils.equals(paramList, "thumbnailUri"))
        {
          localRowBuilder.add(dpy.a(paramString, paramLong3, (GmailAttachment)localObject2, 0));
        }
        else if (TextUtils.equals(paramList, "providerData"))
        {
          ((GmailAttachment)localObject2).p();
          localRowBuilder.add(m);
        }
        else if (TextUtils.equals(paramList, "supportsDownloadAgain"))
        {
          localRowBuilder.add(Integer.valueOf(1));
        }
        else if (TextUtils.equals(paramList, "type"))
        {
          localRowBuilder.add(Integer.valueOf(k));
        }
        else if (TextUtils.equals(paramList, "flags"))
        {
          localRowBuilder.add(Integer.valueOf(l));
        }
        else if (TextUtils.equals(paramList, "contentId"))
        {
          localRowBuilder.add(b);
        }
        else if (TextUtils.equals(paramList, "hasPreview"))
        {
          if (GmailAttachment.a(o, str2)) {}
          for (int i2 = 1;; i2 = 0)
          {
            localRowBuilder.add(Integer.valueOf(i2));
            break;
          }
        }
      }
    }
    if (localdqp.getCount() > 0)
    {
      paramString = f(paramString, paramLong1);
      h.post(new dvl(paramString));
    }
    return localdqp;
  }
  
  private final Cursor a(String paramString1, Uri paramUri, long paramLong, String paramString2, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramUri, null, null, paramLong, paramString2, paramArrayOfString, paramInteger, paramBoolean1, paramBoolean2);
  }
  
  private final Cursor a(String paramString1, Uri paramUri, String paramString2, String paramString3, long paramLong, String paramString4, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    drp localdrp = n(paramString1);
    String[] arrayOfString = chl.a(paramArrayOfString, chh.k);
    String str;
    if (paramBoolean1)
    {
      paramArrayOfString = null;
      if ((!paramBoolean2) || (TextUtils.isEmpty(paramString4))) {
        break label84;
      }
      str = dpy.k(paramString4);
      label45:
      paramString3 = localdrp.a(dfh.a(paramString2, str), paramArrayOfString, paramInteger, false, paramString3);
      if (paramString3 != null) {
        break label91;
      }
      paramString3 = null;
    }
    label84:
    label91:
    do
    {
      do
      {
        return paramString3;
        paramArrayOfString = j;
        break;
        str = paramString4;
        break label45;
        paramArrayOfString = new dvp(paramString3, paramString1, b(paramString1).toString(), arrayOfString);
        paramString3 = paramArrayOfString;
      } while (paramUri == null);
      paramString3 = paramArrayOfString;
    } while (!paramBoolean1);
    paramString1 = q(paramString1);
    paramUri = a(paramLong, paramString4, paramString2);
    c.put(paramUri, new WeakReference(paramArrayOfString));
    return paramArrayOfString;
  }
  
  private final Cursor a(String paramString, String[] paramArrayOfString)
  {
    int i1 = 0;
    paramString = n(paramString);
    if (dms.a(o)) {
      return null;
    }
    paramArrayOfString = chl.a(paramArrayOfString, chh.f);
    try
    {
      paramString = paramString.a("mail", "GmailProvider");
      if (paramString != null)
      {
        paramString = ddy.a(paramString);
        localcvp = new cvp(paramArrayOfString, 1);
        localRowBuilder = localcvp.newRow();
        int i2 = paramArrayOfString.length;
        for (;;)
        {
          if (i1 >= i2) {
            break label138;
          }
          if (!TextUtils.equals(paramArrayOfString[i1], "cookie")) {
            break;
          }
          localRowBuilder.add(paramString);
          i1 += 1;
        }
      }
    }
    catch (IOException paramString)
    {
      cvp localcvp;
      for (;;)
      {
        MatrixCursor.RowBuilder localRowBuilder;
        dri.e("Gmail", paramString, "Exception retrieving auth ClientLogin token", new Object[0]);
        paramString = null;
        continue;
        paramString = null;
        continue;
        localRowBuilder.add(null);
      }
      return localcvp;
    }
    catch (dsj paramString)
    {
      label138:
      for (;;) {}
    }
  }
  
  private final Cursor a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return n(paramString1).E().a(paramArrayOfString, paramString2);
  }
  
  private final Cursor a(String[] paramArrayOfString)
  {
    synchronized (x)
    {
      localObject1 = hef.a(x);
      x.clear();
      ??? = new HashSet();
      if (((List)localObject1).isEmpty()) {
        break label205;
      }
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        dqq localdqq = (dqq)localIterator.next();
        ((Set)???).add(c);
        GmailProvider localGmailProvider = e;
        String str1 = Long.toString(b);
        String str2 = c;
        localGmailProvider.a(new String[] { str1 }, str2, localdqq, null);
      }
    }
    dri.d("Gmail", "Performed undo on %d operations", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    Object localObject1 = ((Set)???).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      o.notifyChange(dpy.a((String)???), null, false);
      continue;
      label205:
      dri.e("Gmail", "Requested to perform an undo when with no saved undo operations", new Object[0]);
    }
    return new cvp(paramArrayOfString, 0);
  }
  
  private final Cursor a(String[] paramArrayOfString, List<drp> paramList)
  {
    paramArrayOfString = chl.a(paramArrayOfString, chh.c);
    Object localObject = new Bundle();
    int i1;
    if (r)
    {
      i1 = 1;
      ((Bundle)localObject).putInt("accounts_loaded", i1);
      localObject = new cvq(paramArrayOfString, paramList.size(), (Bundle)localObject);
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label168;
      }
      drp localdrp = (drp)paramList.next();
      MatrixCursor.RowBuilder localRowBuilder = ((MatrixCursor)localObject).newRow();
      String str = l.name;
      if (p(str))
      {
        dri.b("Gmail", "populateAccountCursorRow %s", new Object[] { str });
        a(getContext(), str, localdrp, paramArrayOfString, localRowBuilder);
        continue;
        i1 = 0;
        break;
      }
      dri.e("Gmail", "Invalid MailEngine account name: %s", new Object[] { str });
    }
    label168:
    return (Cursor)localObject;
  }
  
  public static Uri a()
  {
    return Uri.parse(dvd.a.toString());
  }
  
  public static Uri a(String paramString)
  {
    String str = String.valueOf("content://com.android.gmail.uiinternal/");
    return Uri.parse(String.valueOf(str).length() + 13 + String.valueOf(paramString).length() + str + paramString + "/notification");
  }
  
  public static Uri a(String paramString, long paramLong)
  {
    paramString = String.valueOf(d(paramString, "conversations"));
    return Uri.parse(String.valueOf(paramString).length() + 21 + paramString + "/" + paramLong);
  }
  
  public static Uri a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    paramString = String.valueOf(d(paramString, "messageAttachments"));
    return Uri.parse(String.valueOf(paramString).length() + 42 + paramString + "/" + paramLong1 + "/" + paramLong3).buildUpon().appendQueryParameter("serverMessageId", Long.toString(paramLong2)).build();
  }
  
  public static Uri a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3)
  {
    String str = String.valueOf(d(paramString1, "messageAttachment"));
    if (!TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = paramString2;; paramString1 = "empty")
    {
      paramString1 = Uri.parse(String.valueOf(str).length() + 43 + String.valueOf(paramString1).length() + str + "/" + paramLong1 + "/" + paramLong3 + "/" + paramString1).buildUpon();
      paramString1.appendQueryParameter("serverMessageId", Long.toString(paramLong2));
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1.appendQueryParameter("mimeType", paramString3);
      }
      paramString1 = paramString1.build();
      if (TextUtils.isEmpty(paramString2)) {
        dri.e("Gmail", "Constructed message attachment uri %s with empty partId", new Object[] { paramString1 });
      }
      return paramString1;
    }
  }
  
  public static Uri a(String paramString1, String paramString2)
  {
    paramString1 = String.valueOf(d(paramString1, "label"));
    paramString2 = String.valueOf(Uri.encode(paramString2));
    return Uri.parse(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + "/" + paramString2);
  }
  
  private static Pair<Long, CharSequence> a(Context paramContext, dqc paramdqc, String paramString1, String paramString2, boolean paramBoolean)
  {
    CharSequence localCharSequence = null;
    if (paramBoolean) {
      localCharSequence = d(paramContext, paramString2);
    }
    Object localObject1 = localCharSequence;
    long l1;
    if (paramdqc != null)
    {
      localObject1 = localCharSequence;
      try
      {
        l1 = paramdqc.a(paramString2);
        Object localObject2 = localCharSequence;
        if (localCharSequence == null)
        {
          localObject1 = localCharSequence;
          localObject2 = paramdqc.c(l1).getAsString("name");
        }
        localObject1 = localObject2;
        paramdqc = Pair.create(Long.valueOf(l1), localObject2);
        return paramdqc;
      }
      catch (IllegalArgumentException paramdqc) {}
    }
    paramdqc = drd.a(paramContext, paramString1, paramString2);
    if (paramdqc != null)
    {
      l1 = paramdqc.a();
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = paramdqc.c();
      }
      return Pair.create(Long.valueOf(l1), paramContext);
    }
    dri.e("Gmail", "Couldn't find label: %s", new Object[] { dri.c(paramString2) });
    return Pair.create(Long.valueOf(-1L), localObject1);
  }
  
  public static com.android.mail.providers.Account a(Context paramContext, String paramString)
  {
    cvp localcvp = new cvp(chh.c, 1);
    MatrixCursor.RowBuilder localRowBuilder = localcvp.newRow();
    a(paramContext, paramString, null, chh.c, localRowBuilder);
    localcvp.moveToFirst();
    com.android.mail.providers.Account.b();
    return cfw.a(localcvp);
  }
  
  public static Folder a(Context paramContext, String paramString1, String paramString2)
  {
    cvp localcvp = new cvp(dpy.t, 1);
    boolean bool = dpy.f(paramString2);
    paramContext = a(paramContext, null, paramString1, paramString2, bool);
    MatrixCursor.RowBuilder localRowBuilder = localcvp.newRow();
    String[] arrayOfString = dpy.t;
    int i3 = arrayOfString.length;
    int i2 = 0;
    if (i2 < i3)
    {
      String str = arrayOfString[i2];
      int i1 = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i1)
        {
        default: 
          label120:
          localRowBuilder.add(null);
        }
        break;
      }
      for (;;)
      {
        i2 += 1;
        break;
        if (!str.equals("_id")) {
          break label120;
        }
        i1 = 0;
        break label120;
        if (!str.equals("canonicalName")) {
          break label120;
        }
        i1 = 1;
        break label120;
        if (!str.equals("systemLabel")) {
          break label120;
        }
        i1 = 2;
        break label120;
        if (!str.equals("name")) {
          break label120;
        }
        i1 = 3;
        break label120;
        if (!str.equals("color")) {
          break label120;
        }
        i1 = 4;
        break label120;
        localRowBuilder.add(first);
        continue;
        localRowBuilder.add(paramString2);
        continue;
        if (bool) {}
        for (i1 = 1;; i1 = 0)
        {
          localRowBuilder.add(Integer.valueOf(i1));
          break;
        }
        localRowBuilder.add(second);
        continue;
        localRowBuilder.add("2147483647");
      }
    }
    try
    {
      paramContext = a(null, paramString1, chh.i, localcvp, null);
      if (paramContext == null) {
        break label378;
      }
    }
    finally
    {
      try
      {
        paramContext.moveToFirst();
        paramString1 = new Folder(paramContext);
        if (paramContext != null) {
          paramContext.close();
        }
        return paramString1;
      }
      finally {}
      paramString1 = finally;
      paramContext = null;
    }
    paramContext.close();
    label378:
    throw paramString1;
  }
  
  public static GmailAttachment a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = f(paramString1, paramLong1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.b(paramLong2);
      if (paramString1 != null) {
        return paramString1.a(paramString2);
      }
    }
    return null;
  }
  
  private final dqq a(long paramLong, String paramString, ContentValues paramContentValues, boolean paramBoolean)
  {
    int i1 = 0;
    dqq localdqq = new dqq(this, paramString, paramLong, paramBoolean, (byte)0);
    paramContentValues = paramContentValues.getAsString("folders_updated");
    if (!TextUtils.isEmpty(paramContentValues))
    {
      paramContentValues = TextUtils.split(paramContentValues, ",");
      int i2 = paramContentValues.length;
      while (i1 < i2)
      {
        Uri localUri = Uri.parse(paramContentValues[i1]);
        Object localObject = (String)localUri.getPathSegments().get(2);
        if (m((String)localObject))
        {
          localObject = drd.a(getContext(), paramString, (String)localObject);
          if (localObject != null) {
            localdqq.a((dqz)localObject, Boolean.valueOf((String)localUri.getPathSegments().get(3)).booleanValue());
          }
        }
        i1 += 1;
      }
    }
    return localdqq;
  }
  
  private final dqq a(String paramString, long paramLong, List<Folder> paramList, List<String> paramList1, boolean paramBoolean)
  {
    dqq localdqq = new dqq(this, paramString, paramLong, paramBoolean, (byte)0);
    HashSet localHashSet2 = new HashSet();
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet2.add((String)((Iterator)localObject).next());
    }
    HashSet localHashSet1 = new HashSet();
    int i1;
    if (paramList1.size() == 0)
    {
      i1 = 1;
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      paramList = ((List)localObject).iterator();
    }
    label111:
    int i2;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label282;
      }
      String str = (String)nextc.b.getPathSegments().get(2);
      localHashSet1.add(str);
      if ((i1 != 0) || (!localHashSet2.contains(str))) {
        i2 = 1;
      }
      for (;;)
      {
        if ((i2 != 0) && (m(str)))
        {
          dqz localdqz = drd.a(getContext(), paramString, str);
          if (localdqz != null)
          {
            localdqq.a(localdqz, true);
            break label111;
            i1 = 0;
            break;
            i2 = 0;
            continue;
          }
          dri.e("Gmail", "Couldn't create label for canonical name: %s", new Object[] { str });
          break label111;
        }
      }
      if (!m(str)) {
        dri.d("Gmail", "Couldn't create label operation for canonical name: %s", new Object[] { str });
      }
    }
    label282:
    if (((List)localObject).size() == 0)
    {
      i1 = 1;
      paramList = paramList1.iterator();
    }
    for (;;)
    {
      label304:
      if (!paramList.hasNext()) {
        break label449;
      }
      paramList1 = (String)paramList.next();
      if ((i1 != 0) || (!localHashSet1.contains(paramList1))) {
        i2 = 1;
      }
      for (;;)
      {
        if ((i2 != 0) && (m(paramList1)))
        {
          localObject = drd.a(getContext(), paramString, paramList1);
          if (localObject != null)
          {
            localdqq.a((dqz)localObject, false);
            break label304;
            i1 = 0;
            break;
            i2 = 0;
            continue;
          }
          dri.e("Gmail", "Couldn't create label for canonical name: %s", new Object[] { paramList1 });
          break label304;
        }
      }
      if (!m(paramList1)) {
        dri.d("Gmail", "Couldn't create label operation for canonical name: %s", new Object[] { paramList1 });
      }
    }
    label449:
    return localdqq;
  }
  
  private static String a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong != -1L) {
      return Long.toString(paramLong);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = String.valueOf("label:");
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0) {
        paramString1 = paramString2.concat(paramString1);
      }
    }
    for (;;)
    {
      return Uri.encode(paramString1);
      paramString1 = new String(paramString2);
      continue;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      paramString1 = String.valueOf("query:");
      paramString2 = String.valueOf(paramString2);
      if (paramString2.length() != 0) {
        paramString1 = paramString1.concat(paramString2);
      } else {
        paramString1 = new String(paramString1);
      }
    }
    throw new IllegalStateException("no canonicalName or query specified");
  }
  
  protected static String a(Uri paramUri)
  {
    return (String)paramUri.getPathSegments().get(0);
  }
  
  public static String a(Folder paramFolder)
  {
    return c.b.getLastPathSegment();
  }
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    paramString2 = a(paramLong, paramString2, paramString3);
    paramString1 = String.valueOf(d(paramString1, "refresh"));
    return String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + "/" + paramString2;
  }
  
  public static List<GmailAttachment> a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = f(paramString, paramLong1);
    if (paramString != null)
    {
      paramString = paramString.b(paramLong2);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return null;
  }
  
  public static List<GmailAttachment> a(String paramString, long paramLong1, long paramLong2, List<GmailAttachment> paramList)
  {
    paramString = f(paramString, paramLong1);
    if (paramString != null)
    {
      paramString = paramString.b(paramLong2);
      if (paramString != null)
      {
        paramString.a(paramList);
        return paramString.a();
      }
    }
    return null;
  }
  
  public static List<Folder> a(String paramString, Map<String, dqz> paramMap, nx<Folder> paramnx, Map<String, String[]> paramMap1)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.values().iterator();
    dqz localdqz;
    String str2;
    int i1;
    label99:
    Object localObject1;
    label164:
    Object localObject2;
    if (localIterator.hasNext())
    {
      localdqz = (dqz)localIterator.next();
      long l1 = localdqz.a();
      str2 = localdqz.b();
      if (!dpy.h.contains(str2))
      {
        if ((!TextUtils.isEmpty(str2)) && (str2.charAt(0) != '^'))
        {
          i1 = 1;
          if (i1 == 0) {
            break label308;
          }
        }
      }
      else
      {
        paramMap = null;
        if (paramnx != null) {
          paramMap = (Folder)paramnx.a(l1, null);
        }
        if (paramMap != null) {
          break label409;
        }
        if ((paramMap1 == null) || (!paramMap1.containsKey(str2))) {
          break label310;
        }
        localObject1 = (String[])paramMap1.get(str2);
        paramMap = localObject1[0];
        localObject1 = localObject1[1];
        i1 = (int)l1;
        localObject2 = new cgk();
        a = i1;
        b = localdqz.b();
        c = a(paramString, localdqz.b());
        d = localdqz.c();
        e = a(paramString, i1);
        f = 0;
        g = 0;
        h = i(localdqz.b());
        i = paramMap;
        j = ((String)localObject1);
        localObject1 = ((cgk)localObject2).a();
        paramMap = (Map<String, dqz>)localObject1;
        if (paramnx != null)
        {
          paramnx.b(l1, localObject1);
          paramMap = (Map<String, dqz>)localObject1;
        }
      }
    }
    label308:
    label310:
    label409:
    for (;;)
    {
      localArrayList.add(paramMap);
      break;
      i1 = 0;
      break label99;
      break;
      i1 = localdqz.d();
      localObject2 = 11 + i1;
      i1 = localdqz.e();
      String str1 = 11 + i1;
      localObject1 = str1;
      paramMap = (Map<String, dqz>)localObject2;
      if (paramMap1 == null) {
        break label164;
      }
      paramMap1.put(str2, new String[] { localObject2, str1 });
      localObject1 = str1;
      paramMap = (Map<String, dqz>)localObject2;
      break label164;
      return localArrayList;
    }
  }
  
  private static Map<String, Object> a(Context paramContext, android.accounts.Account paramAccount, String paramString, drp paramdrp, cfm paramcfm, dmv paramdmv)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("_id", Integer.valueOf(paramAccount.hashCode()));
    localHashMap.put("name", paramString);
    localHashMap.put("senderName", null);
    localHashMap.put("accountManagerName", paramString);
    String str = deg.a(paramContext).a(paramString);
    localHashMap.put("accountId", str);
    localHashMap.put("type", type);
    localHashMap.put("providerVersion", Integer.valueOf(0));
    localHashMap.put("accountUri", b(paramString));
    long l1 = 17881890431L;
    if (!ghz.a(paramContext.getContentResolver(), "gmail_enable_block_sender", cuu.c.booleanValue())) {
      l1 = 17865113215L;
    }
    localHashMap.put("capabilities", Long.valueOf(l1));
    paramAccount = c(paramString);
    localHashMap.put("folderListUri", paramAccount);
    localHashMap.put("fullFolderListUri", paramAccount);
    localHashMap.put("allFolderListUri", paramAccount);
    localHashMap.put("searchUri", k(paramString));
    localHashMap.put("searchMessageGenericUri", Uri.parse(d(paramString, "searchMessageGeneric")));
    Object localObject = dyr.a(b(paramString));
    int i1;
    int i2;
    int i3;
    if (localObject != null)
    {
      paramAccount = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramAccount.put(((cha)((Iterator)localObject).next()).a());
      }
      paramAccount = paramAccount.toString();
      localHashMap.put("accountFromAddresses", paramAccount);
      localHashMap.put("expungeMessageUri", d(paramString, "expungeMessage"));
      localHashMap.put("undoUri", d(paramString, "undo"));
      localHashMap.put("accountSettingsIntentUri", h.buildUpon().appendQueryParameter("account", paramString).build());
      localHashMap.put("helpIntentUri", dyv.a(paramContext));
      localHashMap.put("sendFeedbackIntentUri", h.buildUpon().appendQueryParameter("account", paramString).appendQueryParameter("reporting_problem", Boolean.TRUE.toString()).build());
      localHashMap.put("reauthenticationUri", i.buildUpon().appendQueryParameter("account", paramString).build());
      i1 = 0;
      if (paramdrp == null) {
        break label1831;
      }
      if (paramdrp.y()) {
        i1 = 4;
      }
      i2 = i1;
      if (paramdrp.z()) {
        i2 = i1 | 0x2;
      }
      i1 = i2;
      if (paramdrp.A()) {
        i1 = i2 | 0x1;
      }
      if ((X.a()) && (b(paramdrp))) {
        break label1783;
      }
      i3 = 1;
      label547:
      i2 = i1;
      if (i3 != 0) {
        i2 = i1 | 0x8;
      }
      i1 = i2;
      if (!X.b()) {
        i1 = i2 | 0x20;
      }
      if ((ContentResolver.getMasterSyncAutomatically()) && (paramdrp.j())) {
        break label2057;
      }
      dri.c(dri.a, "master sync=%b, engine sync=%b", new Object[] { Boolean.valueOf(ContentResolver.getMasterSyncAutomatically()), Boolean.valueOf(paramdrp.j()) });
      i1 |= 0x10;
    }
    label667:
    label675:
    label708:
    label763:
    label794:
    label825:
    label856:
    label872:
    label908:
    label1191:
    label1218:
    label1245:
    label1281:
    label1308:
    label1362:
    label1425:
    label1433:
    label1563:
    label1579:
    label1783:
    label1795:
    label1801:
    label1807:
    label1813:
    label1819:
    label1825:
    label1831:
    label1942:
    label1956:
    label1962:
    label1968:
    label1974:
    label1980:
    label1986:
    label1991:
    label1997:
    label2003:
    label2009:
    label2027:
    label2050:
    label2057:
    for (;;)
    {
      boolean bool;
      if (!"1".equals((String)o.g.get("bx_ioao")))
      {
        i2 = 1;
        if (i2 == 0) {
          break label1795;
        }
        i2 = 1;
        localHashMap.put("importance_markers_enabled", Integer.valueOf(i2));
        if (!o.a("bx_sc", false)) {
          break label1801;
        }
        i2 = 1;
        localHashMap.put("show_chevrons_enabled", Integer.valueOf(i2));
        localHashMap.put("welcome_tour_shown_version", Integer.valueOf(o.d("ix_awtsv")));
        if (!v.l()) {
          break label1807;
        }
        i2 = 1;
        localHashMap.put("temp_tls_ii", Integer.valueOf(i2));
        if (!v.m()) {
          break label1813;
        }
        i2 = 1;
        localHashMap.put("temp_tls_oi", Integer.valueOf(i2));
        if (!v.n()) {
          break label1819;
        }
        i2 = 1;
        localHashMap.put("temp_fz_ii", Integer.valueOf(i2));
        if (!v.o()) {
          break label1825;
        }
        i2 = 1;
        localHashMap.put("temp_fz_oi", Integer.valueOf(i2));
        localHashMap.put("syncStatus", Integer.valueOf(i1));
        paramAccount = String.valueOf(paramString);
        if (paramAccount.length() == 0) {
          break label1942;
        }
        paramAccount = "gmail2from://gmail-ls/account/".concat(paramAccount);
        localHashMap.put("composeUri", Uri.parse(paramAccount));
        localHashMap.put("mimeType", "application/gmail-ls");
        localHashMap.put("recentFolderListUri", l(paramString));
        localHashMap.put("defaultRecentFolderListUri", d(paramString, "defaultRecentFolders"));
        localHashMap.put("manualSyncUri", d(paramString, "refresh"));
        localHashMap.put("viewProxyUri", "content://com.android.gmail.ui/proxy");
        localHashMap.put("accountCookieUri", d(paramString, "cookie"));
        localHashMap.put("accountOAuthTokenUri", d(paramString, "oauthToken"));
        localHashMap.put("updateSettingsUri", d(paramString, "settings"));
        localHashMap.put("enableMessageTransforms", Integer.valueOf(ghz.a(paramContext.getContentResolver(), "gmail-msg-transforms-enabled", 1)));
        localHashMap.put("syncAuthority", "gmail-ls");
        localHashMap.put("quickResponseUri", Uri.EMPTY);
        localHashMap.put("settingsFragmentClass", dnd.class.getName());
        paramdmv = paramdmv.b(paramContext, str);
        paramAccount = paramdmv;
        if (TextUtils.isEmpty(paramdmv)) {
          paramAccount = null;
        }
        localHashMap.put("signature", paramAccount);
        localHashMap.put("auto_advance", Integer.valueOf(paramcfm.i()));
        if (!paramcfm.c()) {
          break label1956;
        }
        i1 = 1;
        localHashMap.put("reply_behavior", Integer.valueOf(i1));
        if (!paramcfm.e()) {
          break label1962;
        }
        i1 = 1;
        localHashMap.put("conversation_list_icon", Integer.valueOf(i1));
        if (!paramcfm.f()) {
          break label1968;
        }
        i1 = 1;
        localHashMap.put("confirm_delete", Integer.valueOf(i1));
        if (!d.getBoolean("confirm-archive", false)) {
          break label1974;
        }
        i1 = 1;
        localHashMap.put("confirm_archive", Integer.valueOf(i1));
        if (!paramcfm.g()) {
          break label1980;
        }
        i1 = 1;
        localHashMap.put("confirm_send", Integer.valueOf(i1));
        localHashMap.put("default_inbox", a(paramString, dmv.f(paramContext, str)));
        paramdmv = dmv.f(paramContext, str);
        if (paramdrp == null) {
          break label1986;
        }
        paramAccount = X;
        localHashMap.put("default_inbox_name", afsecond);
        paramAccount = b(paramString);
        if ((dyr.j == null) || (!dyr.j.containsKey(paramAccount))) {
          break label1991;
        }
        bool = ((Boolean)dyr.j.get(paramAccount)).booleanValue();
        if (!bool) {
          break label1997;
        }
        i1 = 1;
        localHashMap.put("force_reply_from_default", Integer.valueOf(i1));
        localHashMap.put("max_attachment_size", Integer.valueOf(ghz.a(paramContext.getContentResolver(), "gmail_max_attachment_size_bytes", 20971520)));
        localHashMap.put("swipe", Integer.valueOf(paramcfm.b(true)));
        localHashMap.put("setup_intent_uri", Uri.EMPTY);
        localHashMap.put("conversation_view_mode", Integer.valueOf(paramcfm.j()));
        localHashMap.put("move_to_inbox", a(paramString, "^i"));
        if (paramdrp == null) {
          break label2009;
        }
        if (!o.i()) {
          break label2003;
        }
        i1 = 0;
        localHashMap.put("show_images", Integer.valueOf(i1));
        localHashMap.put("securityHold", Integer.valueOf(0));
        localHashMap.put("accountSecurityUri", "");
        localHashMap.put("settingsSnapshotUri", Uri.parse(d(paramString, "settingsSnapshot")));
        localHashMap.put("vacationResponderSettingsUri", Uri.parse(d(paramString, "vacationResponderSettings")));
        localHashMap.put("driveUri", Uri.parse(d(paramString, "drive")));
        if (paramdrp == null) {
          break label2050;
        }
        paramAccount = o.a("sx_deo", null);
        if (TextUtils.isEmpty(paramAccount)) {
          break label2027;
        }
      }
      for (;;)
      {
        localHashMap.put("drawerAddress", paramAccount);
        localHashMap.put("providerHostname", ghz.a(paramContext.getContentResolver(), "gmail_hostname", "mail.google.com"));
        localHashMap.put("providerPathname", ghz.a(paramContext.getContentResolver(), "gmail_pathname", "/mail/g/"));
        localHashMap.put("domainTlsPredictionUri", Uri.parse(d(paramString, "domainTlsPrediction")));
        return localHashMap;
        paramAccount = null;
        break;
        i3 = 0;
        break label547;
        i2 = 0;
        break label667;
        i2 = 0;
        break label675;
        i2 = 0;
        break label708;
        i2 = 0;
        break label763;
        i2 = 0;
        break label794;
        i2 = 0;
        break label825;
        i2 = 0;
        break label856;
        localHashMap.put("importance_markers_enabled", Integer.valueOf(1));
        localHashMap.put("show_chevrons_enabled", Integer.valueOf(0));
        localHashMap.put("welcome_tour_shown_version", Integer.valueOf(0));
        localHashMap.put("temp_tls_ii", Integer.valueOf(0));
        localHashMap.put("temp_tls_oi", Integer.valueOf(0));
        localHashMap.put("temp_fz_ii", Integer.valueOf(0));
        localHashMap.put("temp_fz_oi", Integer.valueOf(0));
        i1 = 0;
        break label872;
        paramAccount = new String("gmail2from://gmail-ls/account/");
        break label908;
        i1 = 0;
        break label1191;
        i1 = 2;
        break label1218;
        i1 = 0;
        break label1245;
        i1 = 0;
        break label1281;
        i1 = 0;
        break label1308;
        paramAccount = null;
        break label1362;
        bool = false;
        break label1425;
        i1 = 0;
        break label1433;
        i1 = 1;
        break label1563;
        localHashMap.put("show_images", Integer.valueOf(1));
        break label1579;
        if (dkn.a())
        {
          paramdrp = o.j();
          paramAccount = paramdrp;
          if (!TextUtils.isEmpty(paramdrp)) {}
        }
        else
        {
          paramAccount = "";
        }
      }
    }
  }
  
  private final void a(int paramInt, dqq paramdqq)
  {
    List localList = x;
    if (paramInt != -1) {}
    try
    {
      if (paramInt > w)
      {
        dri.d("Gmail", "About to clean %d undo operations. sequenceNum:%d mLastSequence: %d", new Object[] { Integer.valueOf(x.size()), Integer.valueOf(paramInt), Integer.valueOf(w) });
        x.clear();
        w = paramInt;
      }
      x.add(paramdqq);
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    paramContext.getContentResolver().notifyChange(g, null, false);
  }
  
  public static void a(Context paramContext, dqc paramdqc, String paramString, Set<Long> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject != null)
      {
        localObject = paramdqc.b(((Long)localObject).longValue());
        if (localObject != null) {
          paramContext.notifyChange(e(paramString, (String)localObject), null, false);
        }
      }
    }
    if (paramSet.size() > 0)
    {
      paramContext.notifyChange(c(paramString), null, false);
      paramContext.notifyChange(l(paramString), null, false);
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getContentResolver().notifyChange(c(paramString, paramLong), null, false);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3, Set<String> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    paramContext.notifyChange(a(paramString, paramLong1, paramLong2, paramLong3), null, false);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      paramContext.notifyChange(a(paramString, paramLong1, paramLong2, paramLong3, (String)paramSet.next(), null), null, false);
    }
  }
  
  private static void a(Context paramContext, String paramString, drp paramdrp, String[] paramArrayOfString, MatrixCursor.RowBuilder paramRowBuilder)
  {
    android.accounts.Account localAccount = new android.accounts.Account(paramString, "com.google");
    dmv localdmv = dmv.a();
    paramContext = a(paramContext, localAccount, paramString, paramdrp, cfm.a(paramContext), localdmv);
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramString = paramArrayOfString[i1];
      if (paramContext.containsKey(paramString))
      {
        paramRowBuilder.add(paramContext.get(paramString));
        i1 += 1;
      }
      else
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {}
        for (paramContext = "Unexpected column: ".concat(paramContext);; paramContext = new String("Unexpected column: ")) {
          throw new IllegalStateException(paramContext);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, Set<String> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      paramContext.notifyChange(e(paramString, (String)localIterator.next()), null, false);
    }
    if (paramSet.size() > 0)
    {
      paramContext.notifyChange(c(paramString), null, false);
      paramContext.notifyChange(l(paramString), null, false);
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    paramContext = paramContext.getContentResolver();
    if (paramBoolean)
    {
      paramContext.notifyChange(k(paramString1), null, false);
      return;
    }
    paramContext.notifyChange(e(paramString1, paramString2), null, false);
  }
  
  private final void a(drp paramdrp, String paramString)
  {
    dri.b("Gmail", "GmailProvider.populateRecentLabels()", new Object[0]);
    long l1 = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(3);
    int i1 = 0;
    while (i1 < 3)
    {
      String str = new String[] { "^t", "^f", "^r" }[i1];
      dri.b("Gmail", "Marking %s with %d", new Object[] { str, Long.valueOf(l1) });
      localContentValues.put(str, Long.valueOf(l1));
      i1 += 1;
    }
    paramdrp.b(localContentValues);
    o.notifyChange(l(paramString), null, false);
  }
  
  private final void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(5);
    localContentValues.put("_id", Long.valueOf(paramLong1));
    localContentValues.put("messageId", Long.valueOf(paramLong2));
    localContentValues.put("conversation", Long.valueOf(paramLong3));
    localContentValues.put("canonicalName", paramString2);
    localContentValues.put("add_label_action", Boolean.valueOf(paramBoolean));
    p.a(paramString1, new ContentValues[] { localContentValues }, true);
  }
  
  public static void a(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    GmailAttachment localGmailAttachment = a(paramString1, paramLong1, paramLong2, paramString2);
    if (localGmailAttachment == null)
    {
      paramString1 = a(paramString1, paramLong1, paramLong2);
      if (paramString1 != null) {}
      for (paramString1 = Arrays.toString(paramString1.toArray(new GmailAttachment[paramString1.size()]));; paramString1 = null)
      {
        dri.e("Gmail", "couldn't find attachment %d %s in update AttachmentState.  attachments: %s", new Object[] { Long.valueOf(paramLong2), paramString2, paramString1 });
        return;
      }
    }
    if ((paramInt2 == 404) && (f == 3) && (!TextUtils.isEmpty(v)))
    {
      dri.e("Gmail", "Attempt to make successful download a failure", new Object[0]);
      return;
    }
    int i1 = GmailAttachment.c(paramInt2);
    dri.b("Gmail", "Updating attachment state %d/%d/%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt1), paramString3 });
    localGmailAttachment.a(i1);
    g = paramInt1;
    u = -1L;
    t = paramInt2;
    if ((f == 3) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(v)))
    {
      paramString1 = new File(dpa.a(v));
      if (!paramString1.equals(new File(dpa.a(paramString3)))) {
        paramString1.delete();
      }
    }
    localGmailAttachment.g(paramString3);
  }
  
  public static int b(Map<String, dqz> paramMap)
  {
    if (paramMap.containsKey("^p_mtunsub")) {
      return 1;
    }
    if (paramMap.containsKey("^p_ag")) {
      return 2;
    }
    return 0;
  }
  
  private final Cursor b(String paramString, String[] paramArrayOfString)
  {
    int i1 = 0;
    paramString = n(paramString);
    if (!dms.a(o))
    {
      paramString = null;
      return paramString;
    }
    String[] arrayOfString = chl.a(paramArrayOfString, chh.g);
    for (;;)
    {
      try
      {
        String str = paramString.a(dms.b(getContext()), "GmailProvider");
        paramArrayOfString = new cvp(arrayOfString, 1);
        localRowBuilder = paramArrayOfString.newRow();
        int i2 = arrayOfString.length;
        paramString = paramArrayOfString;
        if (i1 >= i2) {
          break;
        }
        if (!"oauthToken".equals(arrayOfString[i1])) {
          continue;
        }
        localRowBuilder.add(str);
      }
      catch (IOException paramString)
      {
        MatrixCursor.RowBuilder localRowBuilder;
        dri.e("Gmail", paramString, "Exception retrieving OAuth token", new Object[0]);
        return null;
        localRowBuilder.add(null);
        continue;
      }
      catch (dsj paramString)
      {
        continue;
      }
      i1 += 1;
    }
  }
  
  private final Cursor b(String[] paramArrayOfString)
  {
    dri.c(dri.a, "getAccountsCursor", new Object[0]);
    Object localObject = new dqm(this);
    AccountManager.get(getContext()).getAccountsByTypeAndFeatures("com.google", ddy.b, (AccountManagerCallback)localObject, null);
    if (d != null)
    {
      paramArrayOfString = a(paramArrayOfString, drp.a(getContext(), d));
      try
      {
        if (!q)
        {
          localObject = getContext();
          new ddy((Context)localObject).a(new dqn(this, (Context)localObject));
          q = true;
        }
        return paramArrayOfString;
      }
      finally {}
    }
    return a(paramArrayOfString, new ArrayList());
  }
  
  public static Uri b(String paramString)
  {
    return Uri.parse(d(paramString, "account"));
  }
  
  public static Uri b(String paramString1, String paramString2)
  {
    paramString1 = String.valueOf(d(paramString1, "conversationsForLabel"));
    paramString2 = String.valueOf(Uri.encode(paramString2));
    return Uri.parse(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + "/" + paramString2);
  }
  
  public static GmailAttachment b(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = q(paramString1).a(paramLong1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramLong2);
      if (paramString1 != null) {
        return paramString1.a(paramString2);
      }
    }
    return null;
  }
  
  public static String b(String paramString, long paramLong)
  {
    paramString = String.valueOf(d(paramString, "conversation"));
    return String.valueOf(paramString).length() + 21 + paramString + "/" + paramLong;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    dri.c(dri.a, "notifyAccountChanged", new Object[0]);
    paramContext.getContentResolver().notifyChange(b(paramString), null, false);
    a(paramContext);
  }
  
  private static boolean b(drp paramdrp)
  {
    paramdrp = X;
    String[] arrayOfString = f;
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (!paramdrp.b(arrayOfString[i1])) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public static Uri c(String paramString)
  {
    return Uri.parse(d(paramString, "labels"));
  }
  
  public static Uri c(String paramString, long paramLong)
  {
    paramString = String.valueOf(d(paramString, "conversationMessages"));
    return Uri.parse(String.valueOf(paramString).length() + 21 + paramString + "/" + paramLong);
  }
  
  public static Uri c(String paramString1, String paramString2)
  {
    paramString1 = String.valueOf(d(paramString1, "ad"));
    return Uri.parse(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + "/" + paramString2);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    GmailProvider localGmailProvider = u;
    Handler localHandler;
    if (localGmailProvider != null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    synchronized (t)
    {
      dqo localdqo2 = (dqo)t.get(paramString);
      dqo localdqo1 = localdqo2;
      if (localdqo2 == null)
      {
        localdqo1 = new dqo(paramContext, localHandler.getLooper(), paramString);
        t.put(paramString, localdqo1);
      }
      localdqo1.a();
      return;
    }
  }
  
  public static Uri d(String paramString)
  {
    return Uri.parse(d(paramString, "saveNewMessage"));
  }
  
  public static Uri d(String paramString, long paramLong)
  {
    paramString = String.valueOf(d(paramString, "message"));
    return Uri.parse(String.valueOf(paramString).length() + 21 + paramString + "/" + paramLong);
  }
  
  private static CharSequence d(Context paramContext, String paramString)
  {
    if (!dpy.f(paramString)) {
      return null;
    }
    try
    {
      if (s == null) {
        s = dqz.a(paramContext);
      }
      paramContext = (CharSequence)s.get(paramString);
      return paramContext;
    }
    finally {}
  }
  
  private static String d(String paramString1, String paramString2)
  {
    Map localMap = j(paramString1);
    String str2 = (String)localMap.get(paramString2);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = String.valueOf("content://com.android.gmail.ui/");
      str1 = String.valueOf(str1).length() + 1 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + str1 + paramString1 + "/" + paramString2;
      localMap.put(paramString2, str1);
    }
    return str1;
  }
  
  public static Uri e(String paramString)
  {
    return Uri.parse(d(paramString, "promo"));
  }
  
  private static Uri e(String paramString1, String paramString2)
  {
    paramString1 = String.valueOf(d(paramString1, "account"));
    return Uri.parse(String.valueOf(paramString1).length() + 7 + String.valueOf(paramString2).length() + paramString1 + "/label/" + paramString2);
  }
  
  private static String e(Context paramContext, String paramString)
  {
    dnm localdnm = dnm.a(paramContext, paramString);
    dmv localdmv = dmv.a();
    drp localdrp = drp.a(paramContext, paramString);
    dqg localdqg = dpy.a(paramContext, paramString);
    HashSet localHashSet = new HashSet();
    Object localObject1 = localdqg.c().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (dpy.f((String)localObject2)) {
        localHashSet.add(localObject2);
      } else {
        localHashSet.add(Integer.toString(((String)localObject2).hashCode()));
      }
    }
    localObject1 = new HashSet();
    Object localObject2 = localdqg.d().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (dpy.f(str)) {
        ((Set)localObject1).add(str);
      } else {
        ((Set)localObject1).add(Integer.toString(str.hashCode()));
      }
    }
    return String.format(Locale.ENGLISH, "client-id: %d, inbox-type: %s, notification: %b, sync: %b, sync-days: %d, attachments: %b, show-imgs: %b, conn-timeout: %d, socket-timeout: %d, conn-manager-timeout: %d, included-labels: %s, partial-labels: %s", new Object[] { Long.valueOf(m.a("clientId")), localdmv.a(paramContext, paramString, false), Boolean.valueOf(localdnm.b()), Boolean.valueOf(ContentResolver.getSyncAutomatically(l, "gmail-ls")), Long.valueOf(localdqg.a()), Boolean.valueOf(localdmv.e(paramContext, paramString)), Boolean.valueOf(o.i()), Integer.valueOf(localdrp.q()), Integer.valueOf(localdrp.r()), Long.valueOf(localdrp.s()), localHashSet, localObject1 });
  }
  
  public static String e(String paramString, long paramLong)
  {
    paramString = String.valueOf(d(paramString, "messageserverid"));
    return String.valueOf(paramString).length() + 21 + paramString + "/" + paramLong;
  }
  
  public static Uri f(String paramString)
  {
    return Uri.parse(d(paramString, "oauthChanged"));
  }
  
  private static dvk f(String paramString, long paramLong)
  {
    return q(paramString).a(u.getContext(), paramLong);
  }
  
  private final Cursor g(String paramString, long paramLong)
  {
    Object localObject = n(paramString);
    cfm localcfm = cfm.a(getContext());
    localObject = ((drp)localObject).a(dpy.s, paramLong);
    return new dvt(getContext(), (Cursor)localObject, paramString, null, localcfm, "<div class=\"gmail_quote\">", chh.n);
  }
  
  static String g(String paramString)
  {
    return d(paramString, "refresh");
  }
  
  public static Uri h(String paramString)
  {
    return Uri.parse(d(paramString, "ads"));
  }
  
  public static int i(String paramString)
  {
    if (y.containsKey(paramString)) {
      return ((Integer)y.get(paramString)).intValue();
    }
    if (!dpy.i(paramString)) {
      return 256;
    }
    return 1;
  }
  
  private static Map<String, String> j(String paramString)
  {
    synchronized (v)
    {
      Map localMap1 = (Map)v.get(paramString);
      Object localObject = localMap1;
      if (localMap1 == null)
      {
        localObject = new ConcurrentHashMap();
        v.put(paramString, localObject);
      }
      return (Map<String, String>)localObject;
    }
  }
  
  private static Uri k(String paramString)
  {
    return Uri.parse(d(paramString, "search"));
  }
  
  private static Uri l(String paramString)
  {
    return Uri.parse(d(paramString, "recentFolders"));
  }
  
  private static boolean m(String paramString)
  {
    return (dpy.j(paramString)) && (!n.contains(paramString));
  }
  
  private final drp n(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    return drp.a(getContext(), paramString);
  }
  
  private static String o(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return TextUtils.join("\n", Message.f(paramString));
  }
  
  private static boolean p(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!k.contains(paramString.toLowerCase(Locale.ENGLISH)));
  }
  
  private static dvj q(String paramString)
  {
    synchronized (e)
    {
      if (e.containsKey(paramString))
      {
        paramString = (dvj)e.get(paramString);
        return paramString;
      }
      dvj localdvj = new dvj(paramString, u.n(paramString));
      e.put(paramString, localdvj);
      paramString = localdvj;
    }
  }
  
  public final void a(drp paramdrp)
  {
    a.remove(l.name);
    b();
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    localObject = null;
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(a(((ContentProviderOperation)localIterator.next()).getUri()));
    }
    if (localHashSet.size() == 1)
    {
      localObject = localHashSet.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label131;
      }
    }
    for (localObject = n((String)((Iterator)localObject).next());; localObject = null)
    {
      if (localObject != null) {
        ((drp)localObject).d(false);
      }
      try
      {
        paramArrayList = super.applyBatch(paramArrayList);
        if (localObject != null) {
          r.c();
        }
        return paramArrayList;
      }
      finally
      {
        label131:
        if (localObject == null) {
          break;
        }
        r.d();
      }
    }
  }
  
  public final void b()
  {
    if (a.size() == 0)
    {
      r = true;
      a(getContext());
    }
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramString2 = a(Uri.parse(paramString2));
    drp localdrp = n(paramString2);
    MailIndexerService.a(paramString2);
    int i1 = -1;
    long l1;
    switch (paramString1.hashCode())
    {
    default: 
      switch (i1)
      {
      default: 
        dri.f("Gmail", "Unexpected Content provider method: %s", new Object[] { paramString1 });
        l1 = -1L;
      }
      break;
    }
    for (;;)
    {
      if (l1 == -1L) {
        break label394;
      }
      paramString1 = new Bundle();
      paramString1.putParcelable("messageUri", d(paramString2, l1));
      return paramString1;
      if (!paramString1.equals("send_message")) {
        break;
      }
      i1 = 0;
      break;
      if (!paramString1.equals("save_message")) {
        break;
      }
      i1 = 1;
      break;
      if (!paramString1.equals("sync_message")) {
        break;
      }
      i1 = 2;
      break;
      if (!paramString1.equals("cancel_message_save")) {
        break;
      }
      i1 = 3;
      break;
      if (!paramString1.equals("set_current_account")) {
        break;
      }
      i1 = 4;
      break;
      if (paramBundle.containsKey("_id")) {}
      for (l1 = paramBundle.getLong("_id");; l1 = 0L)
      {
        paramString1 = (Bundle)paramBundle.getParcelable("opened_fds");
        l1 = a(localdrp, l1, false, a(paramBundle), paramString1);
        break;
      }
      l1 = a(localdrp, paramBundle);
      continue;
      i1 = localdrp.e(paramBundle.getLong("_id"));
      paramString1 = new Bundle(1);
      paramString1.putInt("result", i1);
      return paramString1;
      i1 = localdrp.g(paramBundle.getLong("_id"));
      paramString1 = new Bundle(1);
      paramString1.putInt("result", i1);
      return paramString1;
      c = paramString2;
      l1 = -1L;
    }
    label394:
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "GmailProvider.delete: %s", new Object[] { cvm.a(cvm.a, paramUri) });
    }
    int i1 = m.match(paramUri);
    paramString = a(paramUri);
    Object localObject;
    switch (i1)
    {
    default: 
      return 0;
    case 13: 
      paramArrayOfString = (String)paramUri.getPathSegments().get(2);
      localObject = paramUri.getQueryParameter("seq");
      if (localObject == null) {
        break;
      }
    }
    for (i1 = Integer.parseInt((String)localObject);; i1 = -1)
    {
      paramUri = paramUri.getQueryParameter("forceUiNotifications");
      if ((paramUri != null) && (Boolean.valueOf(paramUri).booleanValue())) {}
      for (boolean bool = true;; bool = false)
      {
        paramUri = new dqq(this, paramString, Long.parseLong(paramArrayOfString), bool, (byte)0);
        paramUri.a(drd.a(getContext(), paramString, "^k"), true);
        localObject = (dqq)paramUri.a();
        a(i1, (dqq)localObject);
        return a(new String[] { paramArrayOfString }, paramString, paramUri, (dqq)localObject);
      }
      return cge.b(n(paramString), paramUri);
      return cge.c(n(paramString), paramUri);
    }
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramArrayOfString = getContext();
    paramPrintWriter.append("  ").append("Gmail account states:");
    if (d == null) {}
    for (paramFileDescriptor = AccountManager.get(paramArrayOfString).getAccountsByType("com.google");; paramFileDescriptor = d)
    {
      int i2 = paramFileDescriptor.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramFileDescriptor[i1];
        dnm localdnm = dnm.a(paramArrayOfString, name);
        paramPrintWriter.println();
        ctl.a("  ", paramPrintWriter, name, e(paramArrayOfString, name), localdnm);
        i1 += 1;
      }
    }
  }
  
  public String getType(Uri paramUri)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "GmailProvider.getType: %s", new Object[] { cvm.a(cvm.a, paramUri) });
    }
    switch (m.match(paramUri))
    {
    default: 
      return null;
    }
    return paramUri.getQueryParameter("mimeType");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "GmailProvider.insert: %s(%s)", new Object[] { cvm.a(cvm.a, paramUri), paramContentValues });
    }
    drp localdrp = n(a(paramUri));
    switch (m.match(paramUri))
    {
    default: 
      dri.f("Gmail", "Unexpected GmailProvider.insert: %s(%s)", new Object[] { cvm.a(cvm.a, paramUri), paramContentValues });
      return null;
    case 9: 
      return c("account", a(localdrp, cwl.a(paramContentValues)));
    case 35: 
      return cge.a(localdrp, paramUri, paramContentValues);
    }
    return cge.b(localdrp, paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    o = localContext.getContentResolver();
    p = new dpy(o);
    b = localContext.getResources().getInteger(dfz.a);
    u = this;
    cfm.a(localContext, this);
    return true;
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (("removal-action".equals(paramString)) || ("conversation-list-swipe".equals(paramString)) || ("conversation-list-sender-image".equals(paramString)) || ("default-reply-all".equals(paramString)) || ("conversation-overview-mode".equals(paramString)) || ("auto-advance-mode".equals(paramString)) || ("snap-header-mode".equals(paramString)) || ("confirm-delete".equals(paramString)) || ("confirm-archive".equals(paramString)) || ("confirm-send".equals(paramString))) {
      a(getContext());
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "GmailProvider.query: %s(%s, %s)", new Object[] { cvm.a(cvm.a, paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    int i1 = m.match(paramUri);
    if (i1 == 1)
    {
      paramArrayOfString1 = b(paramArrayOfString1);
      paramArrayOfString1.setNotificationUri(o, g);
      return paramArrayOfString1;
    }
    paramArrayOfString2 = a(paramUri);
    paramString1 = null;
    switch (i1)
    {
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 24: 
    case 25: 
    case 27: 
    case 33: 
    case 35: 
    default: 
      i1 = 1;
      paramUri = paramString1;
    case 2: 
    case 3: 
      for (;;)
      {
        label273:
        paramArrayOfString1 = paramUri;
        if (paramUri == null) {
          break;
        }
        paramArrayOfString1 = paramUri;
        if (i1 == 0) {
          break;
        }
        paramUri.setNotificationUri(o, a(paramArrayOfString2));
        return paramUri;
        paramString1 = n(paramArrayOfString2);
        if ((paramString1 != null) && (p(l.name)))
        {
          paramString1 = a(paramArrayOfString1, Collections.singletonList(paramString1));
          paramArrayOfString1 = dmv.f(getContext(), paramArrayOfString2);
          paramString2 = buo.a();
          if ("^iim".equals(paramArrayOfString1)) {}
          for (paramArrayOfString1 = "priority_inbox";; paramArrayOfString1 = "inbox")
          {
            paramString2.a(5, paramArrayOfString1);
            buo.a().a(6, Boolean.toString(dmv.a().c(getContext(), paramArrayOfString2)));
            paramArrayOfString1 = paramString1;
            paramArrayOfString1.setNotificationUri(o, paramUri);
            i1 = 0;
            paramUri = paramArrayOfString1;
            break;
          }
        }
        if (paramString1 == null) {}
        for (paramArrayOfString1 = "null MailEngine";; paramArrayOfString1 = l.name)
        {
          dri.e("Gmail", "Invalid mailEngine. %s", new Object[] { paramArrayOfString1 });
          paramArrayOfString1 = null;
          break;
        }
        paramUri = n(paramArrayOfString2);
        paramString1 = chl.a(paramArrayOfString1, chh.i);
        paramUri = a(paramUri, paramArrayOfString2, paramString1, paramUri.b(dpy.t).a(false).a(), null);
        if ((paramUri != null) && (paramUri.getCount() != 0)) {
          break label541;
        }
        label520:
        paramUri.setNotificationUri(o, c(paramArrayOfString2));
        i1 = 0;
      }
      label541:
      paramArrayOfString1 = null;
      if ((ba.size() > 1) && (cfm.a(getContext()).d("enableAllInboxes")))
      {
        paramString2 = getContext();
        paramArrayOfString1 = Uri.parse(paramString2.getString(dge.bk));
      }
      break;
    }
    for (paramString1 = paramString2.getContentResolver().query(paramArrayOfString1, paramString1, null, null, null);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString2 = getContext().getContentResolver();
        paramString1.setNotificationUri(paramString2, paramArrayOfString1);
        paramUri.setNotificationUri(paramString2, c(paramArrayOfString2));
        paramUri = new MergeCursor(new Cursor[] { paramString1, paramUri });
        break label520;
      }
      break label520;
      paramString2 = paramUri.getLastPathSegment();
      boolean bool2 = Boolean.parseBoolean(paramUri.getQueryParameter("inboxFallback"));
      if (paramUri.getQueryParameterNames().contains("allowHiddenFolders"))
      {
        bool1 = Boolean.parseBoolean(paramUri.getQueryParameter("allowHiddenFolders"));
        label710:
        if (!paramUri.getQueryParameterNames().contains("defaultParent")) {
          break label873;
        }
      }
      Object localObject1;
      Object localObject2;
      label873:
      for (paramUri = paramUri.getQueryParameter("defaultParent");; paramUri = null)
      {
        localObject1 = n(paramArrayOfString2);
        localObject2 = chl.a(paramArrayOfString1, chh.i);
        paramString1 = ((drp)localObject1).b(dpy.t).a(Collections.singletonList(paramString2)).a(bool1).a();
        paramArrayOfString1 = paramString1;
        if (paramString1.getCount() == 0)
        {
          paramArrayOfString1 = paramString1;
          if (bool2)
          {
            paramString1.close();
            paramArrayOfString1 = dmv.f(getContext(), paramArrayOfString2);
            paramArrayOfString1 = ((drp)localObject1).b(dpy.t).a(Collections.singletonList(paramArrayOfString1)).a(false).a();
          }
        }
        paramUri = a((drp)localObject1, paramArrayOfString2, (String[])localObject2, paramArrayOfString1, paramUri);
        paramUri.setNotificationUri(o, e(paramArrayOfString2, paramString2));
        i1 = 0;
        break;
        bool1 = false;
        break label710;
      }
      paramString2 = paramUri.getQueryParameter("limit");
      paramString1 = null;
      try
      {
        int i2 = Integer.parseInt(paramString2);
        paramString1 = Integer.valueOf(i2);
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          continue;
          paramUri = paramArrayOfString1;
          i1 = 0;
          continue;
          paramUri = null;
          i1 = 0;
          continue;
          bool1 = true;
        }
        i1 = 1;
      }
      boolean bool1 = true;
      paramString2 = paramUri.getQueryParameter("use_network");
      if (paramString2 != null) {
        bool1 = Boolean.parseBoolean(paramString2);
      }
      paramString2 = paramUri.getQueryParameter("all_notifications");
      if (paramString2 != null) {}
      for (bool2 = Boolean.parseBoolean(paramString2);; bool2 = false)
      {
        paramString2 = paramUri.getQueryParameter("seen");
        boolean bool3;
        if ((paramString2 != null) && (Boolean.FALSE.toString().equals(paramString2)))
        {
          bool3 = true;
          label978:
          if (i1 != 4) {
            break label1167;
          }
          paramString2 = (String)paramUri.getPathSegments().get(2);
        }
        for (;;)
        {
          try
          {
            l1 = Long.parseLong(paramString2);
            paramString2 = nX.b(l1);
            if (paramString2 != null) {
              break label1146;
            }
            dri.e("Gmail", "Unknown canonical name for label ID: %s", new Object[] { Long.valueOf(l1) });
            paramUri = null;
            paramString1 = paramUri;
            paramUri = paramString1;
            if (paramString1 == null)
            {
              dri.e("Gmail", "Returning an empty cursor instead of a null cursor", new Object[0]);
              paramUri = new cvp(paramArrayOfString1, 0);
            }
            if (!bool2) {
              break label2750;
            }
            paramUri.setNotificationUri(o, dpy.a(paramArrayOfString2));
            i1 = 0;
          }
          catch (NumberFormatException paramUri)
          {
            dri.e("Gmail", paramUri, "Unable to parse label id %s", new Object[] { paramString2 });
            return new cvp(paramArrayOfString1, 0);
          }
          bool3 = false;
          break label978;
          label1146:
          paramUri = a(paramArrayOfString2, paramUri, l1, paramString2, paramArrayOfString1, paramString1, bool1, bool3);
          continue;
          label1167:
          paramString1 = a(paramArrayOfString2, paramUri, -1L, (String)paramUri.getPathSegments().get(2), paramArrayOfString1, paramString1, bool1, bool3);
        }
        paramString1 = (String)paramUri.getPathSegments().get(2);
        for (;;)
        {
          try
          {
            l1 = Long.parseLong(paramString1);
            paramString1 = paramUri.getQueryParameter("listParams");
            if (paramString1 == null) {
              break label2744;
            }
            paramString1 = ListParams.a(paramString1);
            if (paramString1 == null) {
              break label2744;
            }
            bool1 = b;
            paramUri = paramUri.getQueryParameter("label");
            paramString2 = n(paramArrayOfString2);
            if (!bool1)
            {
              bool1 = true;
              paramString1 = cfm.a(getContext());
              paramArrayOfString1 = chl.a(paramArrayOfString1, chh.n);
              paramString2 = paramString2.a(dpy.s, l1, bool1, false);
              paramUri = new dvt(getContext(), paramString2, paramArrayOfString2, paramUri, paramString1, "<div class=\"gmail_quote\">", paramArrayOfString1);
              paramUri.setNotificationUri(o, c(paramArrayOfString2, l1));
              i1 = 0;
            }
          }
          catch (NumberFormatException paramUri)
          {
            return null;
          }
          bool1 = false;
        }
        paramUri = g(paramArrayOfString2, Long.parseLong(paramUri.getLastPathSegment()));
        i1 = 1;
        break label273;
        long l1 = Long.parseLong(paramUri.getLastPathSegment());
        paramArrayOfString1 = n(paramArrayOfString2);
        paramUri = cfm.a(getContext());
        paramArrayOfString1 = paramArrayOfString1.b(dpy.s, l1);
        if (paramArrayOfString1 == null) {}
        for (paramUri = null;; paramUri = new dvt(getContext(), paramArrayOfString1, paramArrayOfString2, null, paramUri, "<div class=\"gmail_quote\">", chh.n))
        {
          i1 = 1;
          break;
        }
        paramUri = a(paramArrayOfString1);
        i1 = 1;
        break label273;
        if (i1 == 16)
        {
          paramUri = paramUri.getLastPathSegment();
          label1472:
          paramUri = Uri.encode(paramUri);
          paramString1 = n(paramArrayOfString2);
          if (paramUri == null) {
            break label1768;
          }
          paramUri = (WeakReference)qc.get(paramUri);
          if (paramUri == null) {
            break label1758;
          }
          paramUri = (dvp)paramUri.get();
          label1516:
          if (paramUri == null) {
            break label1763;
          }
          paramUri = paramUri.getWrappedCursor();
          label1525:
          paramString1.a(4, true);
          u = 0;
          W.removeCallbacks(M);
          af = false;
          L = 0;
          W.postDelayed(M, N);
          if (paramUri == null) {
            break label2736;
          }
          paramString2 = paramUri.getExtras();
          paramArrayOfString1 = paramString2.getString("label_canonical_name");
          if (!paramString2.getBoolean("active_network_query", false)) {
            break label2728;
          }
          if (paramString2.getInt("status") != 3) {
            break label1773;
          }
          i1 = 1;
          label1622:
          if (!TextUtils.isEmpty(paramArrayOfString1)) {
            break label1779;
          }
          bool1 = false;
        }
        for (;;)
        {
          if ((!bool1) || (i1 != 0))
          {
            paramString2 = new Bundle();
            paramString2.putString("command", "retry");
            paramString2.putBoolean("force_refresh", true);
            paramUri.respond(paramString2);
            i1 = 1;
            paramUri = paramArrayOfString1;
            if (i1 == 0)
            {
              paramArrayOfString1 = new Bundle();
              paramArrayOfString1.putBoolean("force", true);
              paramArrayOfString1.putBoolean("do_not_retry", true);
              paramArrayOfString1.putBoolean("expedited", true);
              if (paramUri != null) {
                paramArrayOfString1.putString("activeLabel", paramUri);
              }
              ContentResolver.requestSync(l, "gmail-ls", paramArrayOfString1);
            }
            paramUri = null;
            i1 = 1;
            break label273;
            paramUri = null;
            break label1472;
            label1758:
            paramUri = null;
            break label1516;
            label1763:
            paramUri = null;
            break label1525;
            label1768:
            paramUri = null;
            break label1525;
            label1773:
            i1 = 0;
            break label1622;
            label1779:
            bool1 = paramString1.K().contains(paramArrayOfString1);
            continue;
            paramString1 = paramUri.getQueryParameter("query");
            paramArrayOfString1 = paramUri.getQueryParameter("query_identifier");
            paramString2 = q(paramArrayOfString2);
            localObject1 = Uri.parse(d(paramArrayOfString2, "searchConversations")).buildUpon();
            ((Uri.Builder)localObject1).appendQueryParameter("query", paramString1);
            ((Uri.Builder)localObject1).appendQueryParameter("query_identifier", paramArrayOfString1);
            localObject2 = ((Uri.Builder)localObject1).build();
            paramArrayOfString1 = new cvp(chh.i, 1);
            localObject1 = paramArrayOfString1.newRow();
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(l));
            ((MatrixCursor.RowBuilder)localObject1).add(null);
            ((MatrixCursor.RowBuilder)localObject1).add(paramUri);
            ((MatrixCursor.RowBuilder)localObject1).add("search");
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(4172));
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
            ((MatrixCursor.RowBuilder)localObject1).add(localObject2);
            ((MatrixCursor.RowBuilder)localObject1).add(null);
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
            paramString2.a(paramString1);
            paramString2 = (Integer)b.get(paramString1);
            if (paramString2 != null) {}
            for (i1 = paramString2.intValue();; i1 = 0)
            {
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(i1));
              ((MatrixCursor.RowBuilder)localObject1).add(a(paramArrayOfString2, -1L, null, paramString1));
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(4097));
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
              ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(0));
              ((MatrixCursor.RowBuilder)localObject1).add(null);
              ((MatrixCursor.RowBuilder)localObject1).add(null);
              ((MatrixCursor.RowBuilder)localObject1).add(null);
              ((MatrixCursor.RowBuilder)localObject1).add("search");
              ((MatrixCursor.RowBuilder)localObject1).add(Long.valueOf(0L));
              ((MatrixCursor.RowBuilder)localObject1).add(null);
              if (24 != chh.i.length) {
                dri.f("Gmail", "unexpected number of columns. Projection specifies %d items, while only %d columns added", new Object[] { Integer.valueOf(chh.i.length), Integer.valueOf(24) });
              }
              paramArrayOfString1.setNotificationUri(o, paramUri.buildUpon().clearQuery().build());
              i1 = 0;
              paramUri = paramArrayOfString1;
              break;
            }
            paramString1 = paramUri.getQueryParameter("query");
            paramUri = a(paramArrayOfString2, paramUri, paramString1, paramUri.getQueryParameter("query_identifier"), -1L, null, paramArrayOfString1, null, true, false);
            i1 = paramUri.getCount();
            paramArrayOfString1 = q(paramArrayOfString2);
            paramArrayOfString1.a(paramString1);
            b.put(paramString1, Integer.valueOf(i1));
            o.notifyChange(k(paramArrayOfString2), null, false);
            i1 = 1;
            break label273;
            paramUri = n(paramArrayOfString2);
            paramArrayOfString1 = chl.a(paramArrayOfString1, chh.i);
            paramString1 = paramUri.b(dpy.t).a(false);
            paramString1.a(System.currentTimeMillis(), 10);
            paramUri = a(paramUri, paramArrayOfString2, paramArrayOfString1, paramString1.a(), null);
            paramUri.setNotificationUri(o, l(paramArrayOfString2));
            i1 = 0;
            break label273;
            paramArrayOfString1 = a(dvn.a(paramUri), paramArrayOfString1);
            paramArrayOfString1.setNotificationUri(o, paramUri);
            i1 = 0;
            paramUri = paramArrayOfString1;
            break label273;
            paramUri = a(paramArrayOfString2, paramArrayOfString1);
            i1 = 1;
            break label273;
            paramUri = a(paramArrayOfString2, paramArrayOfString1, null);
            paramUri.setNotificationUri(o, h(paramArrayOfString2));
            i1 = 0;
            break label273;
            paramString1 = paramUri.getLastPathSegment();
            paramUri = a(paramArrayOfString2, paramArrayOfString1, paramString1);
            paramUri.setNotificationUri(o, c(paramArrayOfString2, paramString1));
            i1 = 0;
            break label273;
            paramUri = np;
            l1 = System.currentTimeMillis();
            i1 = Build.VERSION.SDK_INT;
            paramArrayOfString1 = Long.toString(l1);
            paramUri = paramUri.query("promotions", null, "startTime <= ? AND expirationTime > ? AND minBuildSdk <= ?", new String[] { paramArrayOfString1, paramArrayOfString1, Integer.toString(i1) }, null, null, "priority DESC", "1");
            i1 = 0;
            break label273;
            paramArrayOfString1 = e(getContext(), paramArrayOfString2);
            paramUri = new MatrixCursor(new String[] { "snapshot" });
            paramUri.addRow(new Object[] { paramArrayOfString1 });
            i1 = 1;
            break label273;
            throw new UnsupportedOperationException();
            paramUri = cge.d(n(paramArrayOfString2), paramUri);
            i1 = 0;
            break label273;
            paramUri = cge.e(n(paramArrayOfString2), paramUri);
            i1 = 0;
            break label273;
            paramUri = cge.a(n(paramArrayOfString2));
            i1 = 0;
            break label273;
            paramUri = cge.f(n(paramArrayOfString2), paramUri);
            i1 = 0;
            break label273;
            paramUri = b(paramArrayOfString2, paramArrayOfString1);
            i1 = 1;
            break label273;
            paramUri = n(paramArrayOfString2);
            if ((!dms.a(o)) || (z == null)) {
              break;
            }
            z.clear();
            break;
          }
        }
        label2728:
        label2736:
        label2744:
        label2750:
        break label273;
      }
    }
  }
  
  public void shutdown()
  {
    cfm.b(getContext(), this);
    u = null;
    e.clear();
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "GmailProvider.update: %s(%s)", new Object[] { cvm.a(cvm.a, paramUri), paramContentValues });
    }
    int i1 = m.match(paramUri);
    paramArrayOfString = a(paramUri);
    paramString = n(paramArrayOfString);
    MailIndexerService.a(paramArrayOfString);
    Object localObject1;
    switch (i1)
    {
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 20: 
    case 26: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 34: 
    case 38: 
    case 39: 
    default: 
      paramUri = String.valueOf(dri.a(paramUri));
      paramContentValues = String.valueOf(paramContentValues.toString());
      dri.f("Gmail", "Unexpected GmailProvider.update: %s", new Object[] { String.valueOf(paramUri).length() + 18 + String.valueOf(paramContentValues).length() + paramUri + " and values are : " + paramContentValues });
    case 33: 
      return 0;
    case 13: 
      localObject1 = (String)paramUri.getPathSegments().get(2);
      paramString = paramUri.getQueryParameter("seq");
      if (paramString == null) {
        break;
      }
    }
    for (int i3 = Integer.parseInt(paramString);; i3 = -1)
    {
      paramUri = paramUri.getQueryParameter("forceUiNotifications");
      boolean bool1;
      Object localObject2;
      long l1;
      label424:
      label540:
      label572:
      int i2;
      if ((paramUri != null) && (Boolean.valueOf(paramUri).booleanValue()))
      {
        bool1 = true;
        dri.c("Gmail", "GmailProvider.updateConversation for conversation %s", new Object[] { localObject1 });
        localObject2 = n(paramArrayOfString);
        l1 = Long.parseLong((String)localObject1);
        if (!paramContentValues.containsKey("operation")) {
          break label1109;
        }
        paramString = paramContentValues.getAsString("operation");
        i1 = -1;
        switch (paramString.hashCode())
        {
        default: 
          switch (i1)
          {
          default: 
            dri.b("Gmail", "Received operation %s for conversation %d", new Object[] { paramString, Long.valueOf(l1) });
            paramUri = new dqq(this, paramArrayOfString, l1, bool1, (byte)0);
            i1 = -1;
            switch (paramString.hashCode())
            {
            default: 
              switch (i1)
              {
              default: 
                i1 = 0;
                i2 = 0;
              }
              break;
            }
            break;
          }
          break;
        }
      }
      for (;;)
      {
        label578:
        if (paramUri == null) {
          paramUri = new dqq(this, paramArrayOfString, l1, bool1, (byte)0);
        }
        for (;;)
        {
          if (paramContentValues.containsKey("starred")) {
            paramUri.a(drd.a(getContext(), paramArrayOfString, "^t"), paramContentValues.getAsBoolean("starred").booleanValue());
          }
          label671:
          int i4;
          if (paramContentValues.containsKey("read"))
          {
            paramString = drd.a(getContext(), paramArrayOfString, "^u");
            if (!paramContentValues.getAsBoolean("read").booleanValue())
            {
              bool1 = true;
              paramUri.a(paramString, bool1);
            }
          }
          else
          {
            if (paramContentValues.containsKey("viewed")) {
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^o"), true);
            }
            if (paramContentValues.containsKey("importance"))
            {
              if (paramContentValues.getAsInteger("importance").intValue() != 1) {
                break label1214;
              }
              i4 = 1;
              label731:
              if (i4 == 0) {
                break label1220;
              }
              paramString = "^^important";
              label740:
              paramUri.a(drd.a(getContext(), paramArrayOfString, paramString), true);
            }
            if (paramContentValues.containsKey("unsubscribeState"))
            {
              if (paramContentValues.getAsInteger("unsubscribeState").intValue() != 3) {
                break label1227;
              }
              if (paramContentValues.containsKey("unsubscribeSenderIdentifier"))
              {
                paramString = paramContentValues.getAsString("unsubscribeSenderIdentifier");
                if (paramString != null) {
                  v.a(paramString, 0L);
                }
              }
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^punsub"), true);
              o.notifyChange(c(l.name, l1), null, false);
            }
            label852:
            if (i2 == 0) {
              break label1261;
            }
            i1 = ((drp)localObject2).c(l1);
          }
          for (;;)
          {
            label866:
            paramContentValues = paramContentValues.getAsBoolean("suppress_undo");
            if ((paramContentValues == null) || (!paramContentValues.booleanValue()))
            {
              paramContentValues = (dqq)paramUri.a();
              a(i3, paramContentValues);
            }
            for (;;)
            {
              return a(new String[] { localObject1 }, paramArrayOfString, paramUri, paramContentValues) + i1;
              bool1 = false;
              break;
              if (!paramString.equals("discard_drafts")) {
                break label424;
              }
              i1 = 0;
              break label424;
              if (!paramString.equals("discard_outbox")) {
                break label424;
              }
              i1 = 1;
              break label424;
              i1 = 0;
              i2 = 1;
              paramUri = null;
              break label578;
              i1 = 1;
              i2 = 0;
              paramUri = null;
              break label578;
              if (!paramString.equals("archive")) {
                break label540;
              }
              i1 = 0;
              break label540;
              if (!paramString.equals("mute")) {
                break label540;
              }
              i1 = 1;
              break label540;
              if (!paramString.equals("report_spam")) {
                break label540;
              }
              i1 = 2;
              break label540;
              if (!paramString.equals("report_not_spam")) {
                break label540;
              }
              i1 = 3;
              break label540;
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^i"), false);
              break label572;
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^g"), true);
              break label572;
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^s"), "report_spam".equals(paramString));
              break label572;
              label1109:
              if (paramContentValues.containsKey("folders_updated"))
              {
                paramUri = a(l1, paramArrayOfString, paramContentValues, bool1);
                i1 = 0;
                i2 = 0;
                break label578;
              }
              if (!paramContentValues.containsKey("rawFolders")) {
                break label2603;
              }
              paramUri = new ArrayList(((drp)localObject2).c(getContext(), (String)localObject1).keySet());
              paramUri = a(paramArrayOfString, l1, agetAsByteArray"rawFolders"a, paramUri, bool1);
              i1 = 0;
              i2 = 0;
              break label578;
              bool1 = false;
              break label671;
              label1214:
              i4 = 0;
              break label731;
              label1220:
              paramString = "^^unimportant";
              break label740;
              label1227:
              if (paramContentValues.getAsInteger("unsubscribeState").intValue() != 4) {
                break label852;
              }
              paramUri.a(drd.a(getContext(), paramArrayOfString, "^p_aunsub"), false);
              break label852;
              label1261:
              if (i1 == 0) {
                break label2594;
              }
              i1 = ((drp)localObject2).f(l1);
              break label866;
              paramContentValues = null;
            }
            dri.b("Gmail", "update: running populateRecentLabels.", new Object[0]);
            a(paramString, paramArrayOfString);
            break;
            return a(paramString, paramArrayOfString, paramContentValues);
            paramString = paramContentValues.getAsInteger("state");
            paramArrayOfString = paramContentValues.getAsInteger("destination");
            localObject1 = paramContentValues.getAsInteger("rendition");
            localObject2 = paramContentValues.getAsInteger("additionalPriority");
            paramContentValues = paramContentValues.getAsBoolean("delayDownload");
            if ((paramString != null) || (paramArrayOfString != null))
            {
              paramUri = dvn.a(paramUri);
              localObject4 = n(a);
              if (paramString != null)
              {
                localObject3 = a(a, b, c, e);
                if (localObject3 != null) {
                  break label1429;
                }
                dri.e("Gmail", "couldn't find attachment in updateAttachmentState", new Object[0]);
              }
            }
            for (;;)
            {
              return 0;
              label1429:
              if (localObject1 != null) {}
              for (i1 = ((Integer)localObject1).intValue();; i1 = 1)
              {
                i4 = paramString.intValue();
                switch (i4)
                {
                case 1: 
                case 3: 
                default: 
                  break;
                case 0: 
                  return w.b(b, c, e, i1, false);
                }
              }
              label1529:
              label1538:
              label1550:
              boolean bool2;
              if (paramArrayOfString != null)
              {
                i2 = paramArrayOfString.intValue();
                if (i2 != 1) {
                  break label1648;
                }
                bool1 = true;
                if (localObject2 == null) {
                  break label1654;
                }
                i3 = ((Integer)localObject2).intValue();
                if (paramContentValues == null) {
                  break label1660;
                }
                bool2 = paramContentValues.booleanValue();
                label1560:
                paramContentValues = w;
                if (i4 != 4) {
                  break label1666;
                }
                ((GmailAttachment)localObject3).a(5);
                paramContentValues.b(b, c, e, i1, true);
              }
              for (;;)
              {
                g = i2;
                if (!bool2) {
                  break label1704;
                }
                ((GmailAttachment)localObject3).a(5);
                paramContentValues.a(b, c, (GmailAttachment)localObject3, i1, bool1, false, i3 + 1);
                break;
                i2 = 0;
                break label1529;
                label1648:
                bool1 = false;
                break label1538;
                label1654:
                i3 = 0;
                break label1550;
                label1660:
                bool2 = false;
                break label1560;
                label1666:
                if ((i4 == 2) && (f == 3) && (g == i2)) {
                  if (s == i1) {
                    break;
                  }
                }
              }
              label1704:
              ((GmailAttachment)localObject3).a(2);
              paramContentValues.a(b, c, (GmailAttachment)localObject3, i1, bool1, i3 + 1);
            }
            return 0;
            paramString = n(paramArrayOfString);
            l1 = Long.parseLong(paramUri.getLastPathSegment());
            Object localObject3 = paramContentValues.getAsInteger("read");
            Object localObject4 = paramContentValues.getAsInteger("starred");
            localObject1 = paramContentValues.getAsInteger("alwaysShowImages");
            localObject2 = paramContentValues.getAsInteger("senderBlocked");
            paramUri = paramContentValues.getAsInteger("respond");
            if ((localObject1 != null) || (localObject3 != null) || (localObject4 != null) || (localObject2 != null) || (paramUri != null))
            {
              paramContentValues = paramString.a(l1, false);
              if (paramContentValues == null) {
                dri.e("Gmail", "Error finding message for localMessageId: %d", new Object[] { Long.valueOf(l1) });
              }
            }
            else
            {
              return 0;
            }
            i1 = 0;
            long l2;
            long l3;
            if (localObject3 != null)
            {
              l2 = c;
              l3 = d;
              if (((Integer)localObject3).intValue() == 0)
              {
                bool1 = true;
                label1888:
                a(paramArrayOfString, l1, l2, l3, "^u", bool1);
                i1 = 1;
              }
            }
            else
            {
              if (localObject4 != null)
              {
                l2 = c;
                l3 = d;
                if (((Integer)localObject4).intValue() == 0) {
                  break label2244;
                }
                bool1 = true;
                label1935:
                a(paramArrayOfString, l1, l2, l3, "^t", bool1);
                i1 = 1;
              }
              i2 = i1;
              if (localObject2 != null)
              {
                l2 = c;
                l3 = d;
                if (((Integer)localObject2).intValue() == 0) {
                  break label2250;
                }
                bool1 = true;
                label1986:
                a(paramArrayOfString, l1, l2, l3, "^p_bs", bool1);
                i2 = 1;
                paramArrayOfString = Address.c(f);
                if (((Integer)localObject2).intValue() == 0) {
                  break label2256;
                }
                i1 = 1;
                label2026:
                if (paramArrayOfString != null)
                {
                  localObject2 = a;
                  if (localObject2 != null)
                  {
                    if (i1 == 0) {
                      break label2262;
                    }
                    v.a((String)localObject2, b, 0L);
                  }
                }
              }
            }
            for (;;)
            {
              o.notifyChange(c(l.name, d), null, false);
              i1 = i2;
              if (localObject1 != null)
              {
                i1 = i2;
                if (((Integer)localObject1).intValue() != 0)
                {
                  dmv.a();
                  paramArrayOfString = cf).a;
                  localObject1 = dmv.d(getContext());
                  cfm.a(getContext()).a(paramArrayOfString, (List)localObject1);
                  i1 = 1;
                }
              }
              i2 = i1;
              if (paramUri != null)
              {
                if ((M != null) && (!TextUtils.isEmpty(M.i)) && (!TextUtils.isEmpty(M.j))) {
                  break label2279;
                }
                dri.e("Gmail", "Unable to record event rsvp.", new Object[0]);
                dri.a("Gmail", "event: %s", new Object[] { M });
                i2 = i1;
              }
              if (i2 == 0) {
                break;
              }
              return 1;
              bool1 = false;
              break label1888;
              label2244:
              bool1 = false;
              break label1935;
              label2250:
              bool1 = false;
              break label1986;
              label2256:
              i1 = 0;
              break label2026;
              label2262:
              v.b(a);
            }
            label2279:
            paramArrayOfString = M.i;
            paramContentValues = M.j;
            i1 = paramUri.intValue();
            switch (i1)
            {
            default: 
              throw new IllegalArgumentException(41 + "Unknown message respond type: " + i1);
            case 1: 
              i1 = 1;
            }
            for (;;)
            {
              paramUri = n;
              localObject1 = new ContentValues(3);
              ((ContentValues)localObject1).put("action", "eventRsvp");
              ((ContentValues)localObject1).put("value1", Integer.valueOf(i1));
              ((ContentValues)localObject1).put("value3", paramArrayOfString);
              ((ContentValues)localObject1).put("value4", paramContentValues);
              c.insert("operations", null, (ContentValues)localObject1);
              paramString.l();
              i2 = 1;
              break;
              i1 = 3;
              continue;
              i1 = 2;
            }
            return a(paramArrayOfString, paramContentValues);
            paramUri = cfm.a(getContext());
            if (paramContentValues.containsKey("auto_advance")) {
              paramUri.d(paramContentValues.getAsInteger("auto_advance").intValue());
            }
            while (!paramContentValues.containsKey("conversation_view_mode"))
            {
              o.notifyChange(Uri.parse("content://com.android.gmail.ui/"), null, false);
              return 1;
            }
            if (paramContentValues.getAsInteger("conversation_view_mode").intValue() == 0) {}
            for (bool1 = true;; bool1 = false)
            {
              paramUri.d(bool1);
              break;
            }
            return a(paramUri.getLastPathSegment(), paramContentValues, paramString);
            return cge.a(paramString, paramContentValues);
            return cge.c(paramString, paramUri, paramContentValues);
            return cge.d(paramString, paramUri, paramContentValues);
            return cge.a(paramString, paramUri);
            label2594:
            i1 = 0;
          }
        }
        label2603:
        i1 = 0;
        i2 = 0;
        paramUri = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.GmailProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */