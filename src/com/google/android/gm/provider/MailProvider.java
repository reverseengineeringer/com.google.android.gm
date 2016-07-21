package com.google.android.gm.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import bgr;
import bhk;
import chi;
import com.android.mail.providers.Attachment;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import cvm;
import cvp;
import dpa;
import dpx;
import dpy;
import dqh;
import drf;
import dri;
import drj;
import drk;
import drp;
import drx;
import dso;
import dsr;
import dtg;
import dtu;
import duy;
import hef;
import hfd;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class MailProvider
  extends ContentProvider
{
  public static volatile MailProvider a;
  private static final UriMatcher b;
  private static final Uri c = Uri.parse("content://gmail-ls/accountquery");
  private static boolean h = false;
  private ContentResolver d;
  private bgr e;
  private String f = null;
  private drp g;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    b = localUriMatcher;
    localUriMatcher.addURI("gmail-ls", "accountquery/*", 24);
    b.addURI("gmail-ls", "*/conversations", 1);
    b.addURI("gmail-ls", "*/conversations/labels", 16);
    b.addURI("gmail-ls", "*/conversations/#/labels", 3);
    b.addURI("gmail-ls", "*/conversations/#/labels/*", 4);
    b.addURI("gmail-ls", "*/conversations/#/attachments", 21);
    b.addURI("gmail-ls", "*/conversations/#/messages", 5);
    b.addURI("gmail-ls", "*/messages", 6);
    b.addURI("gmail-ls", "*/messages/#", 7);
    b.addURI("gmail-ls", "*/messages/server/#", 8);
    b.addURI("gmail-ls", "*/messages/#/labels", 9);
    b.addURI("gmail-ls", "*/messages/#/labels/*", 10);
    b.addURI("gmail-ls", "*/messages/labels", 17);
    b.addURI("gmail-ls", "*/messages/#/attachments/*/*/*", 11);
    b.addURI("gmail-ls", "*/messages/#/attachments/*/*/*/download", 12);
    b.addURI("gmail-ls", "*/labels/lastTouched", 22);
    b.addURI("gmail-ls", "*/labels/*/#", 18);
    b.addURI("gmail-ls", "*/labels/*", 13);
    b.addURI("gmail-ls", "*/label/#", 19);
    b.addURI("gmail-ls", "*/settings", 14);
    b.addURI("gmail-ls", "*/unread/*", 15);
    b.addURI("gmail-ls", "*/status", 20);
    b.addURI("gmail-ls", "*/appdatasearch", 23);
  }
  
  private static long a(drp paramdrp, long paramLong, ContentValues paramContentValues)
  {
    paramContentValues = new ContentValues(paramContentValues);
    boolean bool = paramContentValues.getAsBoolean("save").booleanValue();
    paramContentValues.remove("save");
    long l = paramContentValues.getAsLong("refMessageId").longValue();
    paramContentValues.remove("refMessageId");
    return paramdrp.a(paramLong, bool, l, paramContentValues, null);
  }
  
  private static Cursor a(Uri paramUri)
  {
    paramUri = Base64.decode((String)paramUri.getPathSegments().get(1), 0);
    try
    {
      if (dpx.a == null) {
        dri.e(dri.a, "Encryption key not set. Caller attempting to decrypt data across process runs.", new Object[0]);
      }
      Cipher localCipher;
      for (paramUri = null; paramUri == null; paramUri = localCipher.doFinal(paramUri))
      {
        dri.e("Gmail", "Null decrypted bytes returned.  Returning null cursor", new Object[0]);
        return null;
        localObject = new SecretKeySpec(dpx.a, "AES");
        localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, (Key)localObject, dpx.b);
      }
      paramUri = new String(paramUri);
    }
    catch (GeneralSecurityException paramUri)
    {
      dri.e("Gmail", paramUri, "Failure to decrypt account name.  Returning null cursor", new Object[0]);
      return null;
    }
    Object localObject = new cvp(dpy.q, 1);
    ((MatrixCursor)localObject).addRow(new String[] { paramUri });
    return (Cursor)localObject;
  }
  
  public static Uri a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(dpx.a(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, localSecretKeySpec, dpx.b);
      paramString = localCipher.doFinal(paramString);
      paramString = Base64.encodeToString(paramString, 0);
      return c.buildUpon().appendPath(paramString).build();
    }
    catch (GeneralSecurityException paramString)
    {
      dri.e("Gmail", paramString, "Failure to encrypt account name.  Returning null Uri", new Object[0]);
    }
    return null;
  }
  
  public static bgr a()
  {
    MailProvider localMailProvider = a;
    if (localMailProvider != null) {
      return e;
    }
    return null;
  }
  
  private static dtg a(drp paramdrp, Uri paramUri)
  {
    long l = Long.parseLong((String)paramUri.getPathSegments().get(2));
    String str = (String)paramUri.getPathSegments().get(4);
    int i = chi.a((String)paramUri.getPathSegments().get(5));
    boolean bool = Boolean.valueOf((String)paramUri.getPathSegments().get(6)).booleanValue();
    paramdrp = paramdrp.a(l, false);
    if (paramdrp == null)
    {
      dri.d("Gmail", "Message not found", new Object[0]);
      return null;
    }
    paramUri = new dtg();
    a = paramdrp;
    b = str;
    c = i;
    d = bool;
    return paramUri;
  }
  
  private final drp b(String paramString)
  {
    if (f != null)
    {
      if (f.equals(paramString)) {
        return g;
      }
      throw new IllegalArgumentException("Must request bound account");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    return drp.a(getContext(), paramString);
  }
  
  public final int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = b.match(paramUri);
    Object localObject1 = GmailProvider.a(paramUri);
    Object localObject2 = paramUri.getQueryParameter("suppressUINotifications");
    if ((localObject2 != null) && (Boolean.valueOf((String)localObject2).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = b((String)localObject1);
      switch (i)
      {
      default: 
        throw new IllegalArgumentException(paramUri.toString());
      }
    }
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfContentValues.length;
    i = 0;
    Object localObject3;
    long l;
    while (i < j)
    {
      localObject3 = paramArrayOfContentValues[i];
      if (!((ContentValues)localObject3).containsKey("_id")) {
        throw new IllegalArgumentException("values must have '_id'");
      }
      l = ((ContentValues)localObject3).getAsLong("_id").longValue();
      localObject1 = (List)localHashMap.get(Long.valueOf(l));
      paramUri = (Uri)localObject1;
      if (localObject1 == null)
      {
        paramUri = new ArrayList();
        localHashMap.put(Long.valueOf(l), paramUri);
      }
      paramUri.add(localObject3);
      i += 1;
    }
    i = 0;
    paramArrayOfContentValues = new HashSet();
    r.a(A);
    if (bool) {}
    for (;;)
    {
      int k;
      Object localObject4;
      try
      {
        r.b();
        paramUri = localHashMap.keySet().iterator();
        if (!paramUri.hasNext()) {
          break label690;
        }
        localObject1 = (Long)paramUri.next();
        localObject3 = (List)localHashMap.get(localObject1);
        k = 0;
        localObject3 = ((List)localObject3).iterator();
        j = i;
        i = k;
        if (!((Iterator)localObject3).hasNext()) {
          break label673;
        }
        localObject4 = (ContentValues)((Iterator)localObject3).next();
        if (!((ContentValues)localObject4).containsKey("canonicalName")) {
          throw new IllegalArgumentException("values must have 'canonicalName'");
        }
      }
      finally
      {
        r.d();
        ((drp)localObject2).b(true);
        ((drp)localObject2).a(paramArrayOfContentValues);
      }
      String str = ((ContentValues)localObject4).getAsString("canonicalName");
      if (!((ContentValues)localObject4).containsKey("maxMessageId")) {
        throw new IllegalArgumentException("values must have 'maxMessageId'");
      }
      l = ((ContentValues)localObject4).getAsLong("maxMessageId").longValue();
      if (!((ContentValues)localObject4).containsKey("add_label_action")) {
        throw new IllegalArgumentException("values must have 'add_label_action'");
      }
      bool = ((ContentValues)localObject4).getAsBoolean("add_label_action").booleanValue();
      dri.b(drp.b, "MailProvider.insert(): adding or removing label %s to conversation %d, maxMessageId %d operation (is add) = %b", new Object[] { str, localObject1, Long.valueOf(l), Boolean.valueOf(bool) });
      if (!dpy.l.contains(str)) {
        if (!dpy.j(str)) {
          break label751;
        }
      }
      for (;;)
      {
        if (k == 0)
        {
          paramUri = String.valueOf(str);
          if (paramUri.length() != 0) {}
          for (paramUri = "label is not provider-settable: ".concat(paramUri);; paramUri = new String("label is not provider-settable: ")) {
            throw new IllegalArgumentException(paramUri);
          }
        }
        localObject4 = o.a(str);
        if (localObject4 != null)
        {
          paramArrayOfContentValues.add(Long.valueOf(a));
          o.a(((Long)localObject1).longValue(), l, (drk)localObject4, bool, 1);
          if ((bool) || (!"^u".equals(str))) {
            break label740;
          }
          i = 1;
          j = 1;
          break;
        }
        dri.e(drp.b, "Missing label in setLabelOnConversationsBulk: %s", new Object[] { str });
        break label757;
        label673:
        if (i == 0) {
          break label760;
        }
        ((drp)localObject2).h(((Long)localObject1).longValue());
        break label760;
        label690:
        r.c();
        r.d();
        ((drp)localObject2).b(true);
        ((drp)localObject2).a(paramArrayOfContentValues);
        if (i != 0) {
          ((drp)localObject2).a(false);
        }
        return 0;
        ((drp)localObject2).a(paramArrayOfContentValues, bool);
        return 0;
        label740:
        i = 1;
        break label757;
        k = 1;
        continue;
        label751:
        k = 0;
      }
      label757:
      continue;
      label760:
      i = j;
    }
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramString2 = GmailProvider.a(Uri.parse(paramString2));
    drp localdrp = b(paramString2);
    MailIndexerService.a(paramString2);
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException(paramString1);
        if (paramString1.equals("sync_message")) {
          i = 0;
        }
        break;
      }
    }
    i = localdrp.e(paramBundle.getLong("_id"));
    paramString1 = new Bundle(1);
    paramString1.putInt("result", i);
    return paramString1;
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    int j = 0;
    int k = b.match(paramUri);
    String str = GmailProvider.a(paramUri);
    drp localdrp = b(str);
    MailIndexerService.a(str);
    long l1;
    switch (k)
    {
    case 5: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 10: 
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = paramUri.getLastPathSegment();
      dri.b("Gmail", "MailProvider.delete(): removing label %s from local message %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!dpy.j(paramUri))
      {
        paramUri = String.valueOf(paramUri);
        if (paramUri.length() != 0) {}
        for (paramUri = "label is not user-settable: ".concat(paramUri);; paramUri = new String("label is not user-settable: ")) {
          throw new IllegalArgumentException(paramUri);
        }
      }
      localdrp.a(l1, paramUri, false);
      i = 1;
    }
    do
    {
      return i;
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = paramUri.getLastPathSegment();
      if ((!TextUtils.equals(paramString, "maxMessageId")) || (paramArrayOfString.length != 1)) {
        throw new IllegalArgumentException("selection must be 'maxMessageId', selection args must contain max message id");
      }
      long l2 = Long.parseLong(paramArrayOfString[0]);
      dri.b("Gmail", "MailProvider.delete(): removing label %s from conversation %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!dpy.j(paramUri))
      {
        paramUri = String.valueOf(paramUri);
        if (paramUri.length() != 0) {}
        for (paramUri = "label is not user-settable: ".concat(paramUri);; paramUri = new String("label is not user-settable: ")) {
          throw new IllegalArgumentException(paramUri);
        }
      }
      localdrp.a(l1, l2, paramUri, false);
      return 1;
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      l1 = Long.parseLong(paramUri.getLastPathSegment());
      dri.b("Gmail", "MailProvider.delete(): removing local message %d", new Object[] { Long.valueOf(l1) });
      return localdrp.b(l1);
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("selection Args must be specified");
      }
      paramUri = new ArrayList();
      j = paramArrayOfString.length;
      while (i < j)
      {
        paramUri.add(Long.valueOf(Long.parseLong(paramArrayOfString[i])));
        i += 1;
      }
      return localdrp.a(paramUri);
      paramUri = a(localdrp, paramUri);
      i = j;
    } while (paramUri == null);
    return w.b(a.d, a.c, b, c, false);
  }
  
  public final String getType(Uri paramUri)
  {
    switch (b.match(paramUri))
    {
    }
    do
    {
      return null;
      return "com.google.android.gm/conversations";
      paramUri = a(b(GmailProvider.a(paramUri)), paramUri);
    } while (paramUri == null);
    return a.a(b).l();
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "MailProvider.insert: %s(%s)", new Object[] { cvm.a(cvm.a, paramUri), paramContentValues });
    }
    int i = b.match(paramUri);
    String str = GmailProvider.a(paramUri);
    drp localdrp = b(str);
    MailIndexerService.a(str);
    switch (i)
    {
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 9: 
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      if (paramContentValues.size() != 1) {
        throw new IllegalArgumentException(paramContentValues.toString());
      }
      if (!paramContentValues.containsKey("canonicalName")) {
        throw new IllegalArgumentException("values must have 'canonicalName'");
      }
      paramUri = paramContentValues.getAsString("canonicalName");
      dri.b("Gmail", "MailProvider.insert(): adding label %s to local message %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!dpy.j(paramUri))
      {
        paramUri = String.valueOf(paramUri);
        if (paramUri.length() != 0) {}
        for (paramUri = "label is not user-settable: ".concat(paramUri);; paramUri = new String("label is not user-settable: ")) {
          throw new IllegalArgumentException(paramUri);
        }
      }
      localdrp.a(l1, paramUri, true);
      return dpy.b(str, l1, paramUri);
    case 6: 
      l1 = a(localdrp, 0L, paramContentValues);
      dri.b("Gmail", "MailProvider.insert(): added local message %d", new Object[] { Long.valueOf(l1) });
      return dpy.b(str, l1);
    }
    long l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
    if (!paramContentValues.containsKey("canonicalName")) {
      throw new IllegalArgumentException("values must have 'canonicalName'");
    }
    paramUri = paramContentValues.getAsString("canonicalName");
    if (!paramContentValues.containsKey("maxMessageId")) {
      throw new IllegalArgumentException("values must have 'maxMessageId'");
    }
    long l2 = paramContentValues.getAsLong("maxMessageId").longValue();
    if (paramContentValues.size() != 2) {
      throw new IllegalArgumentException(paramContentValues.toString());
    }
    dri.b("Gmail", "MailProvider.insert(): adding label %s to conversation %d,maxMessageId %d", new Object[] { paramUri, Long.valueOf(l1), Long.valueOf(l2) });
    if (!dpy.j(paramUri))
    {
      paramUri = String.valueOf(paramUri);
      if (paramUri.length() != 0) {}
      for (paramUri = "label is not user-settable: ".concat(paramUri);; paramUri = new String("label is not user-settable: ")) {
        throw new IllegalArgumentException(paramUri);
      }
    }
    localdrp.a(l1, l2, paramUri, true);
    return dpy.a(str, l1, paramUri);
  }
  
  public final boolean onCreate()
  {
    a = this;
    if (!h) {
      e = dqh.a(getContext());
    }
    d = getContext().getContentResolver();
    Intent localIntent = new Intent("com.google.android.gm.intent.ACTION_PROVIDER_CREATED");
    getContext().sendBroadcast(localIntent);
    return true;
  }
  
  public final ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "MailProvider.openFile: %s", new Object[] { cvm.a(cvm.a, paramUri) });
    }
    int i = b.match(paramUri);
    paramString = b((String)paramUri.getPathSegments().get(0));
    switch (i)
    {
    default: 
      paramUri = String.valueOf(paramUri.toString());
      if (paramUri.length() == 0) {
        break;
      }
    }
    for (paramUri = "Unsupported uri in openFile: ".concat(paramUri);; paramUri = new String("Unsupported uri in openFile: "))
    {
      throw new IllegalArgumentException(paramUri);
      paramUri = a(paramString, paramUri);
      if (paramUri == null) {
        throw new FileNotFoundException();
      }
      try
      {
        paramString = w.a(a.d, a.c, b, c, d);
        return paramString;
      }
      catch (FileNotFoundException paramString)
      {
        paramUri = a.a(b);
        if (paramUri == null) {
          throw new FileNotFoundException("Failed to open local attachment. Attachment not found");
        }
        return drp.a(paramUri);
      }
    }
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (dri.a("Gmail", 3)) {
      dri.b("Gmail", "MailProvider.query: %s(%s, %s)", new Object[] { cvm.a(cvm.a, paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    if (!TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("sortOrder must be empty");
    }
    int i = b.match(paramUri);
    if (i == 24)
    {
      paramArrayOfString1 = a(paramUri);
      label84:
      return paramArrayOfString1;
    }
    paramString2 = GmailProvider.a(paramUri);
    if ((f != null) && (!paramString2.equals(f))) {}
    for (;;)
    {
      Object localObject;
      try
      {
        f = paramString2;
        g = drp.a(getContext(), f);
        localObject = b(paramString2);
        MailIndexerService.a(paramString2);
        switch (i)
        {
        case 2: 
        case 3: 
        case 4: 
        case 9: 
        case 10: 
        case 12: 
        case 15: 
        case 16: 
        case 17: 
        case 22: 
        default: 
          paramUri = null;
          i = 1;
          paramArrayOfString1 = paramUri;
          if (paramUri == null) {
            break label84;
          }
          paramArrayOfString1 = paramUri;
          if (i == 0) {
            break label84;
          }
          paramUri.setNotificationUri(d, dpy.a(paramString2));
          return paramUri;
        }
      }
      finally {}
      paramUri = ((drp)localObject).b(paramString2, paramArrayOfString2);
      i = 0;
      continue;
      if (paramString1 != null)
      {
        paramArrayOfString1 = paramString1;
        if (paramString1.length() != 0) {}
      }
      else
      {
        paramArrayOfString1 = "label:^i";
      }
      paramUri = paramUri.getQueryParameter("limit");
      if (Binder.getCallingPid() != Process.myPid())
      {
        bool = true;
        label349:
        if (paramUri == null) {
          break label382;
        }
      }
      label382:
      for (paramUri = Integer.valueOf(paramUri);; paramUri = null)
      {
        paramUri = ((drp)localObject).a(paramArrayOfString1, paramArrayOfString2, paramUri, bool);
        i = 1;
        break;
        bool = false;
        break label349;
      }
      paramUri = ((drp)localObject).a(paramArrayOfString1, Long.parseLong((String)paramUri.getPathSegments().get(2)), "1".equals(paramUri.getQueryParameter("useCache")), "1".equals(paramUri.getQueryParameter("useMatrixCursor")));
      i = 1;
      continue;
      long l = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = w.c.query("attachments", paramArrayOfString1, "messages_conversation=? AND desiredRendition=?", new String[] { String.valueOf(l), chi.a(1) }, null, null, null);
      paramUri.setNotificationUri(d, dpy.a(paramString2, l));
      i = 0;
      continue;
      paramArrayOfString1 = ((drp)localObject).b(paramArrayOfString1, Long.parseLong(paramString1));
      paramArrayOfString1.setNotificationUri(d, paramUri);
      paramUri = paramArrayOfString1;
      i = 0;
      continue;
      paramUri = ((drp)localObject).a(paramArrayOfString1, ContentUris.parseId(paramUri));
      i = 1;
      continue;
      paramUri = ((drp)localObject).b(paramArrayOfString1, ContentUris.parseId(paramUri));
      i = 1;
      continue;
      paramString1 = a((drp)localObject, paramUri);
      if (paramString1 == null) {
        return null;
      }
      paramArrayOfString2 = a.a(b);
      label640:
      String str;
      if (paramArrayOfString1 != null)
      {
        paramUri = new cvp(paramArrayOfString1);
        localObject = paramUri.newRow();
        int j = paramArrayOfString1.length;
        i = 0;
        if (i >= j) {
          break label750;
        }
        str = paramArrayOfString1[i];
        if (!"_display_name".equals(str)) {
          break label704;
        }
        ((MatrixCursor.RowBuilder)localObject).add(c);
      }
      for (;;)
      {
        i += 1;
        break label640;
        paramArrayOfString1 = new String[2];
        paramArrayOfString1[0] = "_display_name";
        paramArrayOfString1[1] = "_size";
        break;
        label704:
        if (("_size".equals(str)) && (c == 1)) {
          ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(d));
        } else {
          ((MatrixCursor.RowBuilder)localObject).add(null);
        }
      }
      label750:
      i = 1;
      continue;
      if (Long.valueOf((String)paramUri.getPathSegments().get(2)).longValue() != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = paramUri.getQueryParameter("before");
        paramArrayOfString2 = paramUri.getQueryParameter("limit");
        paramUri = paramUri.getQueryParameters("canonicalName");
        paramUri = ((drp)localObject).b(paramArrayOfString1).a(paramUri).a(bool);
        if (paramString1 != null) {
          paramUri.a(Long.parseLong(paramString1), Integer.parseInt(paramArrayOfString2));
        }
        paramUri = paramUri.a();
        i = 1;
        break;
      }
      paramString1 = (String)paramUri.getPathSegments().get(2);
      if (Long.valueOf((String)paramUri.getPathSegments().get(3)).longValue() != 0L) {}
      for (bool = true;; bool = false)
      {
        paramUri = ((drp)localObject).b(paramArrayOfString1).a(hef.a(paramString1)).a(bool).a();
        i = 1;
        break;
      }
      l = Long.valueOf((String)paramUri.getPathSegments().get(2)).longValue();
      paramUri = ((drp)localObject).b(paramArrayOfString1);
      if (l != 0L)
      {
        paramUri.a("_id = ?");
        a.add(Long.toString(l));
      }
      paramUri = paramUri.a();
      i = 1;
      continue;
      paramUri = ((drp)localObject).c(paramArrayOfString1);
      i = 1;
      continue;
      paramUri = ((drp)localObject).F();
      paramUri.setNotificationUri(d, dpy.e(paramString2));
      i = 0;
    }
  }
  
  public final void shutdown()
  {
    Object localObject7;
    Thread localThread;
    synchronized (drp.R)
    {
      Iterator localIterator = drp.R.values().iterator();
      if (!localIterator.hasNext()) {
        break label342;
      }
      localObject7 = (dsr)localIterator.next();
      synchronized (b)
      {
        if (a == null) {
          break label331;
        }
        localObject7 = a;
        P = true;
        ((drp)localObject7).D();
        synchronized (g)
        {
          localThread = i;
          ((drp)localObject7).D();
          ((drp)localObject7).a(localThread);
        }
      }
    }
    synchronized (J)
    {
      localThread = K;
      ((drp)localObject7).a(localThread);
      ??? = hfd.a(drp.Q).iterator();
      while (((Iterator)???).hasNext())
      {
        ((drp)localObject7).a((Thread)((Iterator)???).next());
        continue;
        localObject3 = finally;
        throw ((Throwable)localObject3);
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject4 = finally;
        throw ((Throwable)localObject4);
      }
    }
    W.removeCallbacksAndMessages(null);
    if (!bhk.b())
    {
      dri.c(drp.b, "blockUntilBackgroundTasksComplete: queueing", new Object[0]);
      ??? = new Semaphore(0);
      W.post(new drx((drp)localObject7, (Semaphore)???));
    }
    try
    {
      ((Semaphore)???).acquire();
      if (drp.ac != null) {
        drp.ac.cancel(true);
      }
      label331:
      synchronized (s)
      {
        if (p != null)
        {
          p.close();
          p = null;
        }
        if (q != null)
        {
          q.close();
          q = null;
        }
      }
      label342:
      drp.R.clear();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("selection must be empty");
    }
    int i = b.match(paramUri);
    paramString = GmailProvider.a(paramUri);
    paramArrayOfString = b(paramString);
    MailIndexerService.a(paramString);
    switch (i)
    {
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 7: 
      a(paramArrayOfString, ContentUris.parseId(paramUri), paramContentValues);
      return 1;
    case 14: 
      if (paramArrayOfString.a(paramContentValues))
      {
        d.notifyChange(dpy.a(paramString), null);
        return 1;
      }
      break;
    case 22: 
      return paramArrayOfString.b(paramContentValues);
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */