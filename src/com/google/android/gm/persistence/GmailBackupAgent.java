package com.google.android.gm.persistence;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupManager;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.android.gm.SharedPreference;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.android.gm.provider.LogUtils;
import com.google.common.collect.Maps;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.Adler32;
import org.json.JSONException;
import org.json.JSONObject;

public class GmailBackupAgent
  extends BackupAgent
{
  public static void dataChanged(String paramString)
  {
    LogUtils.v("GmailBackupAgent", "%s may have changed", new Object[] { paramString });
    BackupManager.dataChanged("com.google.android.gm");
  }
  
  private static long getChecksum(Map<String, Gmail.Settings> paramMap, List<SharedPreference> paramList)
  {
    Adler32 localAdler32 = new Adler32();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      updateChecksum(localAdler32, ((Map.Entry)localObject).getKey());
      localObject = (Gmail.Settings)((Map.Entry)localObject).getValue();
      updateChecksum(localAdler32, ((Gmail.Settings)localObject).getConversationAgeDays());
      updateChecksum(localAdler32, ((Gmail.Settings)localObject).getMaxAttachmentSizeMb());
      updateChecksum(localAdler32, ((Gmail.Settings)localObject).getLabelsIncluded());
      updateChecksum(localAdler32, ((Gmail.Settings)localObject).getLabelsPartial());
    }
    paramMap = paramList.iterator();
    while (paramMap.hasNext())
    {
      paramList = (SharedPreference)paramMap.next();
      updateChecksum(localAdler32, paramList.getKey());
      updateChecksum(localAdler32, paramList.getValue());
    }
    return localAdler32.getValue();
  }
  
  private static Object getDataObject(BackupDataInput paramBackupDataInput)
    throws IOException
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
      LogUtils.e("GmailBackupAgent", paramBackupDataInput, "Invalid restore data", new Object[0]);
    }
    return null;
  }
  
  private List<String> getDatabaseAccounts(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.databaseList();
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = new File(paramContext[i]).getName();
      if ((str.endsWith(".db")) && (str.startsWith("internal"))) {
        localArrayList.add(str.substring("internal".length() + 1, str.length() - ".db".length()));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private List<SharedPreference> getSharedPreferenceList(BackupDataInput paramBackupDataInput)
    throws IOException
  {
    return (List)getDataObject(paramBackupDataInput);
  }
  
  private List<SharedPreference> getSharedPreferences(Context paramContext)
  {
    paramContext = Persistence.getInstance().getBackupPreferences(paramContext);
    if (LogUtils.isLoggable("GmailBackupAgent", 2))
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        LogUtils.v("GmailBackupAgent", "Backup %s", new Object[] { (SharedPreference)localIterator.next() });
      }
    }
    return paramContext;
  }
  
  private Map<String, Gmail.Settings> getSyncSettings(Context paramContext)
  {
    Object localObject = getDatabaseAccounts(paramContext);
    Gmail localGmail = LongShadowUtils.getContentProviderMailAccess(getContentResolver());
    LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localLinkedHashMap.put(str, localGmail.getBackupSettings(paramContext, str));
    }
    if (LogUtils.isLoggable("GmailBackupAgent", 2))
    {
      paramContext = localLinkedHashMap.entrySet().iterator();
      while (paramContext.hasNext()) {
        LogUtils.v("GmailBackupAgent", "Backup %s", new Object[] { (Map.Entry)paramContext.next() });
      }
    }
    return localLinkedHashMap;
  }
  
  private LinkedHashMap<String, Gmail.Settings> getSyncSettingsMap(BackupDataInput paramBackupDataInput)
    throws IOException
  {
    return (LinkedHashMap)getDataObject(paramBackupDataInput);
  }
  
  private GmailBackupData parseJsonBackupData(BackupDataInput paramBackupDataInput)
  {
    try
    {
      int i = paramBackupDataInput.getDataSize();
      byte[] arrayOfByte = new byte[i];
      paramBackupDataInput.readEntityData(arrayOfByte, 0, i);
      paramBackupDataInput = parseJsonBackupData(arrayOfByte);
      return paramBackupDataInput;
    }
    catch (IOException paramBackupDataInput)
    {
      LogUtils.e("GmailBackupAgent", paramBackupDataInput, "Invalid restore data", new Object[0]);
    }
    return new GmailBackupData(null, null);
  }
  
  private GmailBackupData parseJsonBackupData(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      LogUtils.v("GmailBackupAgent", "Reading restore data: %s", new Object[] { paramArrayOfByte });
      paramArrayOfByte = GmailBackupData.fromJson(new JSONObject(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      LogUtils.e("GmailBackupAgent", paramArrayOfByte, "Invalid restore data", new Object[0]);
      return new GmailBackupData(null, null);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException("UTF-8 should never throw a UnsupportedEncodingException", paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      LogUtils.e("GmailBackupAgent", paramArrayOfByte, "Invalid restore data", new Object[0]);
    }
    return new GmailBackupData(null, null);
  }
  
  private byte[] serializeBackupData(GmailBackupData paramGmailBackupData)
    throws UnsupportedEncodingException, JSONException
  {
    paramGmailBackupData = paramGmailBackupData.toJson().toString();
    LogUtils.v("GmailBackupAgent", "Writing backup data: %s", new Object[] { paramGmailBackupData });
    return paramGmailBackupData.getBytes("UTF-8");
  }
  
  private static void updateChecksum(Adler32 paramAdler32, long paramLong)
  {
    paramAdler32.update((int)(0xFFFF & paramLong));
    paramAdler32.update((int)(paramLong >>> 32));
  }
  
  private static void updateChecksum(Adler32 paramAdler32, Object paramObject)
  {
    try
    {
      paramAdler32.update(paramObject.toString().getBytes("UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramAdler32) {}
  }
  
  private static void updateChecksum(Adler32 paramAdler32, List<String> paramList)
  {
    updateChecksum(paramAdler32, (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  private static void updateChecksum(Adler32 paramAdler32, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      updateChecksum(paramAdler32, paramArrayOfString[i]);
      updateChecksum(paramAdler32, 124L);
      i += 1;
    }
  }
  
  private static void writeBackupData(BackupDataOutput paramBackupDataOutput, String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      paramBackupDataOutput.writeEntityHeader(paramString, i);
      paramBackupDataOutput.writeEntityData(paramArrayOfByte, i);
    }
  }
  
  public void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2)
    throws IOException
  {
    Object localObject = getApplicationContext();
    Map localMap = getSyncSettings((Context)localObject);
    localObject = getSharedPreferences((Context)localObject);
    long l = getChecksum(localMap, (List)localObject);
    new DataOutputStream(new FileOutputStream(paramParcelFileDescriptor2.getFileDescriptor())).writeLong(l);
    paramParcelFileDescriptor1 = new DataInputStream(new FileInputStream(paramParcelFileDescriptor1.getFileDescriptor()));
    try
    {
      if (paramParcelFileDescriptor1.readLong() == l)
      {
        LogUtils.v("GmailBackupAgent", "No changes to backup", new Object[0]);
        return;
      }
    }
    catch (IOException paramParcelFileDescriptor1)
    {
      LogUtils.w("GmailBackupAgent", "Failed to read old backup state", new Object[0]);
      paramParcelFileDescriptor1 = new GmailBackupData(localMap, (List)localObject);
      try
      {
        writeBackupData(paramBackupDataOutput, "backup_data_v2", serializeBackupData(paramParcelFileDescriptor1));
        return;
      }
      catch (JSONException paramParcelFileDescriptor1)
      {
        throw new IOException("Failed to serialize settings", paramParcelFileDescriptor1);
      }
    }
  }
  
  /* Error */
  public void onFullBackup(android.app.backup.FullBackupDataOutput paramFullBackupDataOutput)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 335	com/google/android/gm/persistence/GmailBackupAgent:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: new 248	com/google/android/gm/persistence/GmailBackupData
    //   8: dup
    //   9: aload_0
    //   10: aload_2
    //   11: invokespecial 337	com/google/android/gm/persistence/GmailBackupAgent:getSyncSettings	(Landroid/content/Context;)Ljava/util/Map;
    //   14: aload_0
    //   15: aload_2
    //   16: invokespecial 339	com/google/android/gm/persistence/GmailBackupAgent:getSharedPreferences	(Landroid/content/Context;)Ljava/util/List;
    //   19: invokespecial 251	com/google/android/gm/persistence/GmailBackupData:<init>	(Ljava/util/Map;Ljava/util/List;)V
    //   22: astore 4
    //   24: new 152	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 392	com/google/android/gm/persistence/GmailBackupAgent:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 395	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: ldc_w 397
    //   38: invokespecial 400	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: astore_2
    //   42: new 343	java/io/DataOutputStream
    //   45: dup
    //   46: new 402	java/io/BufferedOutputStream
    //   49: dup
    //   50: new 345	java/io/FileOutputStream
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 405	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 406	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   61: invokespecial 357	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore_3
    //   65: aload_3
    //   66: iconst_2
    //   67: invokevirtual 409	java/io/DataOutputStream:writeInt	(I)V
    //   70: aload_0
    //   71: aload 4
    //   73: invokespecial 381	com/google/android/gm/persistence/GmailBackupAgent:serializeBackupData	(Lcom/google/android/gm/persistence/GmailBackupData;)[B
    //   76: astore 4
    //   78: aload_3
    //   79: aload 4
    //   81: arraylength
    //   82: invokevirtual 409	java/io/DataOutputStream:writeInt	(I)V
    //   85: aload_3
    //   86: aload 4
    //   88: invokevirtual 412	java/io/DataOutputStream:write	([B)V
    //   91: aload_3
    //   92: invokevirtual 415	java/io/DataOutputStream:flush	()V
    //   95: aload_0
    //   96: aload_2
    //   97: aload_1
    //   98: invokevirtual 419	com/google/android/gm/persistence/GmailBackupAgent:fullBackupFile	(Ljava/io/File;Landroid/app/backup/FullBackupDataOutput;)V
    //   101: aload_2
    //   102: invokevirtual 422	java/io/File:delete	()Z
    //   105: pop
    //   106: return
    //   107: astore_1
    //   108: new 107	java/io/IOException
    //   111: dup
    //   112: ldc_w 424
    //   115: aload_1
    //   116: invokespecial 386	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: athrow
    //   120: astore_1
    //   121: aload_2
    //   122: invokevirtual 422	java/io/File:delete	()Z
    //   125: pop
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	GmailBackupAgent
    //   0	128	1	paramFullBackupDataOutput	android.app.backup.FullBackupDataOutput
    //   4	118	2	localObject1	Object
    //   64	28	3	localDataOutputStream	DataOutputStream
    //   22	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	78	107	org/json/JSONException
    //   42	70	120	finally
    //   70	78	120	finally
    //   78	101	120	finally
    //   108	120	120	finally
  }
  
  public void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    Context localContext = getApplicationContext();
    Persistence localPersistence = Persistence.getInstance();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    for (;;)
    {
      Object localObject4 = localObject2;
      localObject3 = localObject1;
      if (paramBackupDataInput.readNextHeader())
      {
        localObject3 = paramBackupDataInput.getKey();
        if ("gmail_shared_preferences_v1".equals(localObject3))
        {
          localObject2 = getSharedPreferenceList(paramBackupDataInput);
          continue;
        }
        if ("gmail_sync_settings_v1".equals(localObject3))
        {
          localObject1 = getSyncSettingsMap(paramBackupDataInput);
          continue;
        }
        if ("backup_data_v2".equals(localObject3))
        {
          paramBackupDataInput = parseJsonBackupData(paramBackupDataInput);
          localObject3 = paramBackupDataInput.getSyncSettings();
          localObject4 = paramBackupDataInput.getSharedPreferences();
        }
      }
      else
      {
        if (localObject4 != null) {
          localPersistence.restoreSharedPreferences(localContext, (List)localObject4, "GmailBackupAgent");
        }
        paramBackupDataInput = LongShadowUtils.getContentProviderMailAccess(getContentResolver());
        if (localObject3 == null) {
          break;
        }
        localObject1 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          LogUtils.v("GmailBackupAgent", "Restore: %s: %s", new Object[] { ((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue() });
          paramBackupDataInput.restoreSettings(localContext, (String)((Map.Entry)localObject2).getKey(), (Gmail.Settings)((Map.Entry)localObject2).getValue());
        }
      }
      paramBackupDataInput.skipEntityData();
      LogUtils.w("GmailBackupAgent", "Unknown restore key: %s", new Object[] { paramBackupDataInput.getKey() });
    }
    localObject1 = Maps.newLinkedHashMap();
    localObject2 = getDatabaseAccounts(localContext).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((Map)localObject1).put(localObject3, paramBackupDataInput.getBackupSettings(localContext, (String)localObject3));
    }
    paramBackupDataInput = localPersistence.getBackupPreferences(localContext);
    new DataOutputStream(new FileOutputStream(paramParcelFileDescriptor.getFileDescriptor())).writeLong(getChecksum((Map)localObject1, paramBackupDataInput));
  }
  
  public void onRestoreFile(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, File paramFile, int paramInt, long paramLong2, long paramLong3)
    throws IOException
  {
    LogUtils.v("GmailBackupAgent", "onRestoreFile() invoked", new Object[0]);
    paramFile = new DataInputStream(new FileInputStream(paramParcelFileDescriptor.getFileDescriptor()));
    paramInt = paramFile.readInt();
    LogUtils.v("GmailBackupAgent", "Flattened data version %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2)
    {
      paramParcelFileDescriptor = new byte[paramFile.readInt()];
      paramFile.readFully(paramParcelFileDescriptor);
      paramFile = parseJsonBackupData(paramParcelFileDescriptor);
      Object localObject1 = paramFile.getSyncSettings();
      paramParcelFileDescriptor = getApplicationContext();
      if (localObject1 != null)
      {
        Gmail localGmail = LongShadowUtils.getContentProviderMailAccess(getContentResolver());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          Gmail.Settings localSettings = (Gmail.Settings)((Map.Entry)localObject2).getValue();
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          LogUtils.v("GmailBackupAgent", "Restore: %s: %s", new Object[] { localObject2, localSettings });
          localGmail.restoreSettings(paramParcelFileDescriptor, (String)localObject2, localSettings);
        }
      }
      paramFile = paramFile.getSharedPreferences();
      if (paramFile != null) {
        Persistence.getInstance().restoreSharedPreferences(paramParcelFileDescriptor, paramFile, "GmailBackupAgent");
      }
      return;
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