package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ListParams
  implements Parcelable
{
  public static final Parcelable.Creator<ListParams> CREATOR = new Parcelable.Creator()
  {
    public ListParams createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ListParams(paramAnonymousParcel);
    }
    
    public ListParams[] newArray(int paramAnonymousInt)
    {
      return new ListParams[paramAnonymousInt];
    }
  };
  private static final String LOG_TAG = ;
  public final int mLimit;
  public final boolean mUseNetwork;
  
  public ListParams(int paramInt, boolean paramBoolean)
  {
    mLimit = paramInt;
    mUseNetwork = paramBoolean;
  }
  
  public ListParams(Parcel paramParcel)
  {
    mLimit = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      mUseNetwork = bool;
      return;
    }
  }
  
  public static ListParams newinstance(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      LogUtils.wtf(LOG_TAG, localJSONException1, "Could not create an params object from this input: \"" + paramString, new Object[0]);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localObject = new ListParams(((JSONObject)localObject).getInt("limit"), ((JSONObject)localObject).getBoolean("use-network"));
        return (ListParams)localObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      localJSONException1 = localJSONException1;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  /* Error */
  public String serialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 52	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 90	org/json/JSONObject:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc 57
    //   13: aload_0
    //   14: getfield 37	com/android/mail/providers/ListParams:mLimit	I
    //   17: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload_1
    //   22: ldc 63
    //   24: aload_0
    //   25: getfield 39	com/android/mail/providers/ListParams:mUseNetwork	Z
    //   28: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 98	org/json/JSONObject:toString	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: astore_2
    //   42: getstatic 27	com/android/mail/providers/ListParams:LOG_TAG	Ljava/lang/String;
    //   45: aload_2
    //   46: ldc 100
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokestatic 87	com/android/mail/utils/LogUtils:wtf	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   55: pop
    //   56: goto -24 -> 32
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ListParams
    //   9	31	1	localObject1	Object
    //   59	4	1	localObject2	Object
    //   41	5	2	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   10	32	41	org/json/JSONException
    //   2	10	59	finally
    //   10	32	59	finally
    //   32	37	59	finally
    //   42	56	59	finally
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mLimit);
    if (mUseNetwork) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.ListParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */