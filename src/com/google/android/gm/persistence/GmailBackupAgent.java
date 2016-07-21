package com.google.android.gm.persistence;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import ccy;
import cfg;
import cfi;
import cfk;
import cfm;
import cgr;
import chh;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import dfh;
import dgi;
import dmu;
import dmv;
import dnm;
import dnn;
import dpy;
import dqg;
import dqz;
import dra;
import drd;
import dri;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.Adler32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GmailBackupAgent
  extends BackupAgent
{
  private static long a(Map<String, dqg> paramMap, List<dgi> paramList, List<cfi> paramList1, Map<String, List<cfi>> paramMap1, Map<String, Map<String, List<cfi>>> paramMap2)
  {
    Adler32 localAdler32 = new Adler32();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      a(localAdler32, ((Map.Entry)localObject).getKey());
      localObject = (dqg)((Map.Entry)localObject).getValue();
      a(localAdler32, ((dqg)localObject).a());
      a(localAdler32, ((dqg)localObject).b());
      a(localAdler32, ((dqg)localObject).c());
      a(localAdler32, ((dqg)localObject).d());
    }
    paramMap = paramList.iterator();
    while (paramMap.hasNext())
    {
      paramList = (dgi)paramMap.next();
      a(localAdler32, a);
      a(localAdler32, c);
    }
    paramMap = paramList1.iterator();
    while (paramMap.hasNext())
    {
      paramList = (cfi)paramMap.next();
      a(localAdler32, paramList.a());
      a(localAdler32, paramList.b());
    }
    paramMap = paramMap1.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramList = (Map.Entry)paramMap.next();
      a(localAdler32, paramList.getKey());
      paramList = ((List)paramList.getValue()).iterator();
      while (paramList.hasNext())
      {
        paramList1 = (cfi)paramList.next();
        a(localAdler32, paramList1.a());
        a(localAdler32, paramList1.b());
      }
    }
    paramMap = paramMap2.entrySet().iterator();
    if (paramMap.hasNext())
    {
      paramList = (Map.Entry)paramMap.next();
      a(localAdler32, paramList.getKey());
      paramList = ((Map)paramList.getValue()).entrySet().iterator();
      while (paramList.hasNext())
      {
        paramList1 = (Map.Entry)paramList.next();
        a(localAdler32, paramList1.getKey());
        paramList1 = ((List)paramList1.getValue()).iterator();
        while (paramList1.hasNext())
        {
          paramMap1 = (cfi)paramList1.next();
          a(localAdler32, paramMap1.a());
          a(localAdler32, paramMap1.b());
        }
      }
    }
    return localAdler32.getValue();
  }
  
  private final dmu a(DataInputStream paramDataInputStream)
  {
    Object localObject1 = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.readFully((byte[])localObject1);
    paramDataInputStream = a((byte[])localObject1);
    Object localObject2 = a;
    localObject1 = getApplicationContext();
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        dqg localdqg = (dqg)((Map.Entry)localObject3).getValue();
        localObject3 = (String)((Map.Entry)localObject3).getKey();
        dri.a("GmailBackupAgent", "Restore: %s: %s", new Object[] { localObject3, localdqg });
        dpy.a((Context)localObject1, (String)localObject3, localdqg);
      }
    }
    localObject2 = b;
    if (localObject2 != null) {
      dmv.a().a((Context)localObject1, (List)localObject2, "GmailBackupAgent");
    }
    return paramDataInputStream;
  }
  
  private static dmu a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      dri.a("GmailBackupAgent", "Reading restore data: %s", new Object[] { paramArrayOfByte });
      paramArrayOfByte = dmu.a(new JSONObject(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      dri.e("GmailBackupAgent", paramArrayOfByte, "Invalid restore data", new Object[0]);
      return new dmu(null, null, null, null, null);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException("UTF-8 should never throw a UnsupportedEncodingException", paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      dri.e("GmailBackupAgent", paramArrayOfByte, "Invalid restore data", new Object[0]);
    }
    return new dmu(null, null, null, null, null);
  }
  
  private static Object a(BackupDataInput paramBackupDataInput)
  {
    int i = paramBackupDataInput.getDataSize();
    byte[] arrayOfByte = new byte[i];
    paramBackupDataInput.readEntityData(arrayOfByte, 0, i);
    paramBackupDataInput = new ObjectInputStream(new ByteArrayInputStream(arrayOfByte));
    try
    {
      paramBackupDataInput = paramBackupDataInput.readObject();
      return paramBackupDataInput;
    }
    catch (ClassNotFoundException paramBackupDataInput)
    {
      dri.e("GmailBackupAgent", paramBackupDataInput, "Invalid restore data", new Object[0]);
    }
    return null;
  }
  
  private static List<dgi> a(Context paramContext)
  {
    paramContext = dmv.a().i(paramContext);
    if (dri.a("GmailBackupAgent", 2))
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        dri.a("GmailBackupAgent", "Backup %s", new Object[] { (dgi)localIterator.next() });
      }
    }
    return paramContext;
  }
  
  public static void a(String paramString)
  {
    dri.a("GmailBackupAgent", "%s may have changed", new Object[] { paramString });
    BackupManager.dataChanged("com.google.android.gm");
  }
  
  private static void a(Adler32 paramAdler32, long paramLong)
  {
    paramAdler32.update((int)(0xFFFF & paramLong));
    paramAdler32.update((int)(paramLong >>> 32));
  }
  
  private static void a(Adler32 paramAdler32, Object paramObject)
  {
    try
    {
      paramAdler32.update(paramObject.toString().getBytes("UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramAdler32) {}
  }
  
  private static void a(Adler32 paramAdler32, List<String> paramList)
  {
    paramList = (String[])paramList.toArray(new String[paramList.size()]);
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      a(paramAdler32, paramList[i]);
      a(paramAdler32, 124L);
      i += 1;
    }
  }
  
  private static byte[] a(dmu paramdmu)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = new JSONObject();
    localJSONObject1.put("sync_settings", localObject1);
    Object localObject2 = a.entrySet().iterator();
    Object localObject4;
    Object localObject3;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (dqg)((Map.Entry)localObject4).getValue();
      localObject5 = new JSONObject();
      ((JSONObject)localObject5).put("conversation_age_days", a);
      ((JSONObject)localObject5).put("max_attachment_size_mb", b);
      ((JSONObject)localObject5).put("labels_included", new JSONArray(c));
      ((JSONObject)localObject5).put("labels_partial", new JSONArray(d));
      ((JSONObject)localObject1).put((String)localObject3, localObject5);
    }
    localJSONObject1.put("shared_preferences", dmu.a(b));
    localJSONObject1.put("mail_prefs", dmu.a(c));
    localObject1 = new JSONArray();
    localObject2 = d.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("account_name", ((Map.Entry)localObject3).getKey());
      ((JSONObject)localObject4).put("preferences", dmu.a((List)((Map.Entry)localObject3).getValue()));
      ((JSONArray)localObject1).put(localObject4);
    }
    localJSONObject1.put("account_prefs", localObject1);
    localObject1 = new JSONArray();
    paramdmu = e.entrySet().iterator();
    while (paramdmu.hasNext())
    {
      localObject4 = (Map.Entry)paramdmu.next();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("account_name", ((Map.Entry)localObject4).getKey());
      localObject3 = new JSONArray();
      ((JSONObject)localObject2).put("folders", localObject3);
      localObject4 = ((Map)((Map.Entry)localObject4).getValue()).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("folder_backup_key", ((Map.Entry)localObject5).getKey());
        localJSONObject2.put("preferences", dmu.a((List)((Map.Entry)localObject5).getValue()));
        ((JSONArray)localObject3).put(localJSONObject2);
      }
      ((JSONArray)localObject1).put(localObject2);
    }
    localJSONObject1.put("folder_prefs", localObject1);
    paramdmu = localJSONObject1.toString();
    dri.a("GmailBackupAgent", "Writing backup data: %s", new Object[] { paramdmu });
    return paramdmu.getBytes("UTF-8");
  }
  
  private static dmu b(BackupDataInput paramBackupDataInput)
  {
    try
    {
      int i = paramBackupDataInput.getDataSize();
      byte[] arrayOfByte = new byte[i];
      paramBackupDataInput.readEntityData(arrayOfByte, 0, i);
      paramBackupDataInput = a(arrayOfByte);
      return paramBackupDataInput;
    }
    catch (IOException paramBackupDataInput)
    {
      dri.e("GmailBackupAgent", paramBackupDataInput, "Invalid restore data", new Object[0]);
    }
    return new dmu(null, null, null, null, null);
  }
  
  private static List<cfi> b(Context paramContext)
  {
    paramContext = cfm.a(paramContext).m();
    Iterator localIterator = paramContext.iterator();
    while (localIterator.hasNext()) {
      dri.a("GmailBackupAgent", "Backup %s", new Object[] { (cfi)localIterator.next() });
    }
    return paramContext;
  }
  
  private static Map<String, List<cfi>> c(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Account[] arrayOfAccount = f(paramContext);
    int j = arrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      Account localAccount = arrayOfAccount[i];
      localHashMap.put(c, cfg.b(paramContext, localAccount.h()).m());
      i += 1;
    }
    return localHashMap;
  }
  
  private static Map<String, Map<String, List<cfi>>> d(Context paramContext)
  {
    HashMap localHashMap1 = new HashMap();
    Account[] arrayOfAccount = f(paramContext);
    int k = arrayOfAccount.length;
    int i = 0;
    while (i < k)
    {
      Account localAccount = arrayOfAccount[i];
      HashMap localHashMap2 = new HashMap();
      String str1 = c;
      dra localdra = drd.a(paramContext, str1, false);
      int j = 0;
      while (j < a.size())
      {
        String str2 = localdra.a(j).b();
        Object localObject = dfh.c(paramContext, str1, str2);
        localObject = new dnn(paramContext, localAccount.h(), (Folder)localObject, false);
        if (((cfk)localObject).n()) {
          localHashMap2.put(str2, ((cfk)localObject).m());
        }
        j += 1;
      }
      if (!localHashMap2.isEmpty()) {
        localHashMap1.put(str1, localHashMap2);
      }
      i += 1;
    }
    return localHashMap1;
  }
  
  private static Map<String, dqg> e(Context paramContext)
  {
    Object localObject = g(paramContext);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localLinkedHashMap.put(str, dpy.b(paramContext, str));
    }
    if (dri.a("GmailBackupAgent", 2))
    {
      paramContext = localLinkedHashMap.entrySet().iterator();
      while (paramContext.hasNext()) {
        dri.a("GmailBackupAgent", "Backup %s", new Object[] { (Map.Entry)paramContext.next() });
      }
    }
    return localLinkedHashMap;
  }
  
  private static Account[] f(Context paramContext)
  {
    paramContext = new ccy(paramContext.getContentResolver().query(cgr.b(), chh.c, null, null, null), Account.S);
    try
    {
      Account[] arrayOfAccount = Account.a(paramContext);
      return arrayOfAccount;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private static List<String> g(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.databaseList();
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = new File(paramContext[i]).getName();
      if ((str.endsWith(".db")) && (str.startsWith("internal"))) {
        localArrayList.add(str.substring(9, str.length() - 3));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2)
  {
    Object localObject = getApplicationContext();
    Map localMap1 = e((Context)localObject);
    List localList1 = a((Context)localObject);
    List localList2 = b((Context)localObject);
    Map localMap2 = c((Context)localObject);
    localObject = d((Context)localObject);
    long l = a(localMap1, localList1, localList2, localMap2, (Map)localObject);
    new DataOutputStream(new FileOutputStream(paramParcelFileDescriptor2.getFileDescriptor())).writeLong(l);
    paramParcelFileDescriptor1 = new DataInputStream(new FileInputStream(paramParcelFileDescriptor1.getFileDescriptor()));
    try
    {
      if (paramParcelFileDescriptor1.readLong() == l)
      {
        dri.a("GmailBackupAgent", "No changes to backup", new Object[0]);
        return;
      }
    }
    catch (IOException paramParcelFileDescriptor1)
    {
      for (;;)
      {
        dri.d("GmailBackupAgent", "Failed to read old backup state", new Object[0]);
        paramParcelFileDescriptor1 = new dmu(localMap1, localList1, localList2, localMap2, (Map)localObject);
        try
        {
          paramParcelFileDescriptor1 = a(paramParcelFileDescriptor1);
          if (paramParcelFileDescriptor1 == null) {
            continue;
          }
          int i = paramParcelFileDescriptor1.length;
          paramBackupDataOutput.writeEntityHeader("backup_data_v3", i);
          paramBackupDataOutput.writeEntityData(paramParcelFileDescriptor1, i);
          return;
        }
        catch (JSONException paramParcelFileDescriptor1)
        {
          throw new IOException("Failed to serialize settings", paramParcelFileDescriptor1);
        }
      }
    }
  }
  
  /* Error */
  public void onFullBackup(android.app.backup.FullBackupDataOutput paramFullBackupDataOutput)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 113	com/google/android/gm/persistence/GmailBackupAgent:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: new 106	dmu
    //   8: dup
    //   9: aload_2
    //   10: invokestatic 478	com/google/android/gm/persistence/GmailBackupAgent:e	(Landroid/content/Context;)Ljava/util/Map;
    //   13: aload_2
    //   14: invokestatic 480	com/google/android/gm/persistence/GmailBackupAgent:a	(Landroid/content/Context;)Ljava/util/List;
    //   17: aload_2
    //   18: invokestatic 482	com/google/android/gm/persistence/GmailBackupAgent:b	(Landroid/content/Context;)Ljava/util/List;
    //   21: aload_2
    //   22: invokestatic 484	com/google/android/gm/persistence/GmailBackupAgent:c	(Landroid/content/Context;)Ljava/util/Map;
    //   25: aload_2
    //   26: invokestatic 486	com/google/android/gm/persistence/GmailBackupAgent:d	(Landroid/content/Context;)Ljava/util/Map;
    //   29: invokespecial 172	dmu:<init>	(Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V
    //   32: astore 4
    //   34: new 447	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: invokevirtual 544	com/google/android/gm/persistence/GmailBackupAgent:getFilesDir	()Ljava/io/File;
    //   42: invokevirtual 547	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: ldc_w 549
    //   48: invokespecial 552	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore_2
    //   52: new 490	java/io/DataOutputStream
    //   55: dup
    //   56: new 554	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 492	java/io/FileOutputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 557	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 558	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: invokespecial 504	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_3
    //   75: aload_3
    //   76: iconst_3
    //   77: invokevirtual 561	java/io/DataOutputStream:writeInt	(I)V
    //   80: aload 4
    //   82: invokestatic 523	com/google/android/gm/persistence/GmailBackupAgent:a	(Ldmu;)[B
    //   85: astore 4
    //   87: aload_3
    //   88: aload 4
    //   90: arraylength
    //   91: invokevirtual 561	java/io/DataOutputStream:writeInt	(I)V
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 564	java/io/DataOutputStream:write	([B)V
    //   100: aload_3
    //   101: invokevirtual 567	java/io/DataOutputStream:flush	()V
    //   104: aload_0
    //   105: aload_2
    //   106: aload_1
    //   107: invokevirtual 571	com/google/android/gm/persistence/GmailBackupAgent:fullBackupFile	(Ljava/io/File;Landroid/app/backup/FullBackupDataOutput;)V
    //   110: aload_2
    //   111: invokevirtual 574	java/io/File:delete	()Z
    //   114: pop
    //   115: return
    //   116: astore_1
    //   117: new 318	java/io/IOException
    //   120: dup
    //   121: ldc_w 576
    //   124: aload_1
    //   125: invokespecial 538	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: athrow
    //   129: astore_1
    //   130: aload_2
    //   131: invokevirtual 574	java/io/File:delete	()Z
    //   134: pop
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	GmailBackupAgent
    //   0	137	1	paramFullBackupDataOutput	android.app.backup.FullBackupDataOutput
    //   4	127	2	localObject1	Object
    //   74	27	3	localDataOutputStream	DataOutputStream
    //   32	64	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   80	87	116	org/json/JSONException
    //   52	80	129	finally
    //   80	87	129	finally
    //   87	110	129	finally
    //   117	129	129	finally
  }
  
  public void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    Context localContext = getApplicationContext();
    dmv localdmv = dmv.a();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2;
    Object localObject4;
    for (;;)
    {
      if (paramBackupDataInput.readNextHeader())
      {
        localObject2 = paramBackupDataInput.getKey();
        if ("gmail_shared_preferences_v1".equals(localObject2))
        {
          localObject3 = (List)a(paramBackupDataInput);
        }
        else if ("gmail_sync_settings_v1".equals(localObject2))
        {
          localObject1 = (LinkedHashMap)a(paramBackupDataInput);
        }
        else if ("backup_data_v2".equals(localObject2))
        {
          paramBackupDataInput = b(paramBackupDataInput);
          localObject2 = a;
          localObject3 = b;
          paramBackupDataInput = null;
          localObject1 = null;
          localObject4 = null;
        }
      }
    }
    for (;;)
    {
      label112:
      if (localObject3 != null) {
        localdmv.a(localContext, (List)localObject3, "GmailBackupAgent");
      }
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            dri.a("GmailBackupAgent", "Restore: %s: %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
            dpy.a(localContext, (String)((Map.Entry)localObject3).getKey(), (dqg)((Map.Entry)localObject3).getValue());
            continue;
            if ("backup_data_v3".equals(localObject2))
            {
              paramBackupDataInput = b(paramBackupDataInput);
              localObject2 = a;
              localObject3 = b;
              localObject4 = c;
              localObject1 = d;
              paramBackupDataInput = e;
              break label112;
            }
            paramBackupDataInput.skipEntityData();
            dri.d("GmailBackupAgent", "Unknown restore key: %s", new Object[] { paramBackupDataInput.getKey() });
            break;
          }
        }
      }
      localObject2 = cfm.a(localContext);
      if (localObject4 != null) {
        ((cfm)localObject2).a((List)localObject4);
      }
      localObject2 = ((cfm)localObject2).m();
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (List)((Map.Entry)localObject4).getValue();
          dnm.a(localContext, (String)localObject3).a((List)localObject4);
        }
      }
      localObject1 = c(localContext);
      if (paramBackupDataInput != null)
      {
        paramBackupDataInput = paramBackupDataInput.entrySet().iterator();
        while (paramBackupDataInput.hasNext())
        {
          localObject4 = (Map.Entry)paramBackupDataInput.next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = ((Map)((Map.Entry)localObject4).getValue()).entrySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
            str = (String)((Map.Entry)localObject5).getKey();
            localObject5 = (List)((Map.Entry)localObject5).getValue();
            new dnn(localContext, (String)localObject3, str, false).a((List)localObject5);
          }
        }
      }
      paramBackupDataInput = d(localContext);
      localObject3 = new LinkedHashMap();
      localObject4 = g(localContext).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        str = (String)((Iterator)localObject4).next();
        ((Map)localObject3).put(str, dpy.b(localContext, str));
      }
      localObject4 = localdmv.i(localContext);
      new DataOutputStream(new FileOutputStream(paramParcelFileDescriptor.getFileDescriptor())).writeLong(a((Map)localObject3, (List)localObject4, (List)localObject2, (Map)localObject1, paramBackupDataInput));
      return;
      paramBackupDataInput = null;
      String str = null;
      localObject4 = null;
      localObject2 = localObject1;
      localObject1 = str;
    }
  }
  
  public void onRestoreFile(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, File paramFile, int paramInt, long paramLong2, long paramLong3)
  {
    dri.a("GmailBackupAgent", "onRestoreFile() invoked", new Object[0]);
    paramFile = new DataInputStream(new FileInputStream(paramParcelFileDescriptor.getFileDescriptor()));
    paramInt = paramFile.readInt();
    dri.a("GmailBackupAgent", "Flattened data version %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2) {
      a(paramFile);
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
      paramParcelFileDescriptor = getApplicationContext();
      paramFile = a(paramFile);
      localObject1 = cfm.a(paramParcelFileDescriptor);
      localObject2 = c;
      if (c != null) {
        ((cfm)localObject1).a((List)localObject2);
      }
      if (d != null)
      {
        localObject1 = d.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (List)((Map.Entry)localObject3).getValue();
          dnm.a(paramParcelFileDescriptor, (String)localObject2).a((List)localObject3);
        }
      }
    } while (e == null);
    paramFile = e.entrySet().iterator();
    while (paramFile.hasNext())
    {
      localObject2 = (Map.Entry)paramFile.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map)((Map.Entry)localObject2).getValue()).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (List)((Map.Entry)localObject4).getValue();
        new dnn(paramParcelFileDescriptor, (String)localObject1, (String)localObject3, false).a((List)localObject4);
      }
    }
    paramParcelFileDescriptor.close();
    throw new IOException("Invalid file schema");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.GmailBackupAgent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */