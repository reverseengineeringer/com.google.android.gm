import com.android.mail.providers.Conversation;
import org.json.JSONException;
import org.json.JSONObject;

public final class dui
{
  final long a;
  final boolean b;
  final boolean c;
  final Integer d;
  
  public dui()
  {
    a = -1L;
    b = false;
    c = false;
    d = Integer.valueOf(-1);
  }
  
  public dui(Conversation paramConversation, int paramInt)
  {
    a = b;
    if (!k) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      c = j;
      d = Integer.valueOf(paramInt);
      return;
    }
  }
  
  /* Error */
  public dui(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 15	java/lang/Object:<init>	()V
    //   4: ldc2_w 16
    //   7: lstore 5
    //   9: aconst_null
    //   10: astore 9
    //   12: aload_1
    //   13: ldc 48
    //   15: invokevirtual 54	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   18: lstore_3
    //   19: lload_3
    //   20: lstore 5
    //   22: aload_1
    //   23: ldc 56
    //   25: invokevirtual 60	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   28: istore 8
    //   30: aload_1
    //   31: ldc 62
    //   33: invokevirtual 60	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   36: istore 7
    //   38: aload_1
    //   39: ldc 64
    //   41: invokevirtual 68	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   44: istore_2
    //   45: iload_2
    //   46: invokestatic 29	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: astore_1
    //   50: aload_0
    //   51: lload_3
    //   52: putfield 19	dui:a	J
    //   55: aload_0
    //   56: iload 8
    //   58: putfield 21	dui:b	Z
    //   61: aload_0
    //   62: iload 7
    //   64: putfield 23	dui:c	Z
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 31	dui:d	Ljava/lang/Integer;
    //   72: return
    //   73: astore_1
    //   74: iconst_0
    //   75: istore 8
    //   77: iconst_0
    //   78: istore 7
    //   80: lload 5
    //   82: lstore_3
    //   83: getstatic 73	duh:a	Ljava/lang/String;
    //   86: aload_1
    //   87: ldc 75
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 81	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   96: pop
    //   97: aload 9
    //   99: astore_1
    //   100: goto -50 -> 50
    //   103: astore_1
    //   104: iconst_0
    //   105: istore 7
    //   107: goto -24 -> 83
    //   110: astore_1
    //   111: goto -28 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	dui
    //   0	114	1	paramJSONObject	JSONObject
    //   44	2	2	i	int
    //   18	65	3	l1	long
    //   7	74	5	l2	long
    //   36	70	7	bool1	boolean
    //   28	48	8	bool2	boolean
    //   10	88	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	73	org/json/JSONException
    //   22	30	73	org/json/JSONException
    //   30	38	103	org/json/JSONException
    //   38	45	110	org/json/JSONException
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("thread_id", a);
      localJSONObject.put("unseen", b);
      localJSONObject.put("is_read", c);
      localJSONObject.put("display_position", d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      dri.e(duh.a, localJSONException, "Could not create JSON object", new Object[0]);
    }
    return localJSONObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof dui))
    {
      paramObject = (dui)paramObject;
      bool1 = bool2;
      if (a == a)
      {
        bool1 = bool2;
        if (b == b)
        {
          bool1 = bool2;
          if (c == c)
          {
            bool1 = bool2;
            if (d == d) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ threadId: ").append(a);
    localStringBuilder.append(", unseen: ").append(b);
    localStringBuilder.append(", isRead: ").append(c);
    localStringBuilder.append(", display_position: ").append(d);
    return "}";
  }
}

/* Location:
 * Qualified Name:     dui
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */