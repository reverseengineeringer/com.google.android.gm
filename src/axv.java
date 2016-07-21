import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public final class axv
{
  public final ArrayList<axu> a = new ArrayList();
  private final aqu b;
  private int c;
  private final ayc d;
  private final int e;
  private final StringBuilder f = new StringBuilder();
  private final StringBuilder g = new StringBuilder();
  
  public axv(InputStream paramInputStream, ayc paramayc)
  {
    this(paramInputStream, paramayc, (byte)0);
  }
  
  private axv(InputStream paramInputStream, ayc paramayc, byte paramByte)
  {
    b = new aqu(paramInputStream);
    d = paramayc;
    e = 2097152;
  }
  
  private final axr a(char paramChar1, char paramChar2)
  {
    a(paramChar1);
    axr localaxr = new axr();
    a(localaxr, paramChar2);
    a(paramChar2);
    return localaxr;
  }
  
  private final void a(char paramChar)
  {
    char c1 = d();
    if (paramChar != c1) {
      throw new IOException(String.format("Expected %04x (%c) but got %04x (%c)", new Object[] { Integer.valueOf(paramChar), Character.valueOf(paramChar), Integer.valueOf(c1), Character.valueOf((char)c1) }));
    }
  }
  
  private final void a(axr paramaxr, char paramChar)
  {
    for (;;)
    {
      char c1 = c();
      if (c1 == paramChar) {
        label10:
        return;
      }
      if (c1 != ' ') {
        break;
      }
      d();
    }
    Object localObject;
    switch (c())
    {
    default: 
      localObject = g();
    }
    for (;;)
    {
      if (localObject == null) {
        break label10;
      }
      paramaxr.a((axp)localObject);
      break;
      localObject = a('(', ')');
      continue;
      localObject = a('[', ']');
      continue;
      d();
      localObject = new axx(b('"'));
      continue;
      localObject = h();
      continue;
      d();
      a('\n');
      localObject = null;
      continue;
      d();
      localObject = null;
    }
  }
  
  private final void a(Exception paramException)
  {
    int i = 0;
    for (;;)
    {
      if (i < 4) {
        try
        {
          int j = d();
          if ((j != -1) && (j != 10)) {
            i += 1;
          }
        }
        catch (IOException localIOException) {}
      }
    }
    cvm.d(bbw.a, paramException, "parse exception", new Object[0]);
    d.b();
  }
  
  private static IOException b()
  {
    cvm.d(bbw.a, "End of stream reached", new Object[0]);
    return new IOException("End of stream reached");
  }
  
  private final String b(char paramChar)
  {
    f.setLength(0);
    for (;;)
    {
      char c1 = d();
      if (c1 == paramChar) {
        break;
      }
      f.append((char)c1);
    }
    return f.toString();
  }
  
  private final int c()
  {
    aqu localaqu = b;
    if (!a)
    {
      b = localaqu.read();
      a = true;
    }
    int i = b;
    if (i == -1) {
      throw b();
    }
    return i;
  }
  
  private final int d()
  {
    int i = b.read();
    if (i == -1) {
      throw b();
    }
    Object localObject = d;
    if ((32 <= i) && (i <= 126)) {
      a.append((char)i);
    }
    do
    {
      for (;;)
      {
        c += 1;
        return i;
        if (i != 10) {
          break;
        }
        ((ayc)localObject).a();
      }
    } while (i == 13);
    String str = String.valueOf(Integer.toHexString(i));
    if (str.length() != 0)
    {
      str = "00".concat(str);
      label97:
      localObject = a;
      str = String.valueOf(str.substring(str.length() - 2, str.length()));
      if (str.length() == 0) {
        break label156;
      }
    }
    label156:
    for (str = "\\x".concat(str);; str = new String("\\x"))
    {
      ((StringBuilder)localObject).append(str);
      break;
      str = new String("00");
      break label97;
    }
  }
  
  private final String e()
  {
    String str = b('\r');
    a('\n');
    return str;
  }
  
  /* Error */
  private final axu f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 89	axv:c	()I
    //   7: istore_1
    //   8: iload_1
    //   9: bipush 43
    //   11: if_icmpne +41 -> 52
    //   14: aload_0
    //   15: invokespecial 63	axv:d	()I
    //   18: pop
    //   19: aload_0
    //   20: bipush 32
    //   22: invokespecial 54	axv:a	(C)V
    //   25: new 186	axu
    //   28: dup
    //   29: aconst_null
    //   30: iconst_1
    //   31: invokespecial 189	axu:<init>	(Ljava/lang/String;Z)V
    //   34: astore_3
    //   35: aload_3
    //   36: new 99	axx
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 191	axv:e	()Ljava/lang/String;
    //   44: invokespecial 103	axx:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 192	axu:a	(Laxp;)V
    //   50: aload_3
    //   51: areturn
    //   52: iload_1
    //   53: bipush 42
    //   55: if_icmpne +138 -> 193
    //   58: aload_0
    //   59: invokespecial 63	axv:d	()I
    //   62: pop
    //   63: aload_0
    //   64: bipush 32
    //   66: invokespecial 54	axv:a	(C)V
    //   69: aconst_null
    //   70: astore_2
    //   71: new 186	axu
    //   74: dup
    //   75: aload_2
    //   76: iconst_0
    //   77: invokespecial 189	axu:<init>	(Ljava/lang/String;Z)V
    //   80: astore_2
    //   81: aload_2
    //   82: aload_0
    //   83: invokespecial 92	axv:g	()Laxy;
    //   86: invokevirtual 192	axu:a	(Laxp;)V
    //   89: aload_0
    //   90: invokespecial 89	axv:c	()I
    //   93: bipush 32
    //   95: if_icmpne +116 -> 211
    //   98: aload_0
    //   99: invokespecial 63	axv:d	()I
    //   102: pop
    //   103: aload_2
    //   104: invokevirtual 195	axu:g	()Z
    //   107: ifeq +96 -> 203
    //   110: aload_0
    //   111: invokespecial 89	axv:c	()I
    //   114: bipush 91
    //   116: if_icmpne +29 -> 145
    //   119: aload_2
    //   120: aload_0
    //   121: bipush 91
    //   123: bipush 93
    //   125: invokespecial 97	axv:a	(CC)Laxr;
    //   128: invokevirtual 192	axu:a	(Laxp;)V
    //   131: aload_0
    //   132: invokespecial 89	axv:c	()I
    //   135: bipush 32
    //   137: if_icmpne +8 -> 145
    //   140: aload_0
    //   141: invokespecial 63	axv:d	()I
    //   144: pop
    //   145: aload_0
    //   146: invokespecial 191	axv:e	()Ljava/lang/String;
    //   149: astore 4
    //   151: aload_2
    //   152: astore_3
    //   153: aload 4
    //   155: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -108 -> 50
    //   161: aload_2
    //   162: new 99	axx
    //   165: dup
    //   166: aload 4
    //   168: invokespecial 103	axx:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 192	axu:a	(Laxp;)V
    //   174: aload_2
    //   175: areturn
    //   176: astore 4
    //   178: aload_2
    //   179: astore_3
    //   180: aload 4
    //   182: astore_2
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 203	axu:c	()V
    //   191: aload_2
    //   192: athrow
    //   193: aload_0
    //   194: bipush 32
    //   196: invokespecial 102	axv:b	(C)Ljava/lang/String;
    //   199: astore_2
    //   200: goto -129 -> 71
    //   203: aload_0
    //   204: aload_2
    //   205: iconst_0
    //   206: invokespecial 60	axv:a	(Laxr;C)V
    //   209: aload_2
    //   210: areturn
    //   211: aload_0
    //   212: bipush 13
    //   214: invokespecial 54	axv:a	(C)V
    //   217: aload_0
    //   218: bipush 10
    //   220: invokespecial 54	axv:a	(C)V
    //   223: aload_2
    //   224: areturn
    //   225: astore_2
    //   226: aload 4
    //   228: astore_3
    //   229: goto -46 -> 183
    //   232: astore_2
    //   233: goto -50 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	axv
    //   7	49	1	i	int
    //   70	154	2	localObject1	Object
    //   225	1	2	localObject2	Object
    //   232	1	2	localObject3	Object
    //   34	195	3	localObject4	Object
    //   1	166	4	str	String
    //   176	51	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   81	145	176	finally
    //   145	151	176	finally
    //   153	174	176	finally
    //   203	209	176	finally
    //   211	223	176	finally
    //   3	8	225	finally
    //   14	35	225	finally
    //   58	69	225	finally
    //   71	81	225	finally
    //   193	200	225	finally
    //   35	50	232	finally
  }
  
  private final axy g()
  {
    g.setLength(0);
    for (;;)
    {
      int i = c();
      if ((i == 40) || (i == 41) || (i == 123) || (i == 32) || (i == 93) || (i == 37) || (i == 34) || ((i >= 0) && (i <= 31)) || (i == 127))
      {
        if (g.length() == 0) {
          throw new bdi(26, "Expected string, none found.");
        }
        String str = g.toString();
        if ("NIL".equalsIgnoreCase(str)) {
          return axy.d;
        }
        return new axx(str);
      }
      if (i == 91)
      {
        g.append((char)d());
        g.append(b(']'));
        g.append(']');
      }
      else
      {
        g.append((char)d());
      }
    }
  }
  
  private final axy h()
  {
    a('{');
    int i;
    try
    {
      i = Integer.parseInt(b('}'));
      if (i < 0) {
        throw new bdi(26, "Invalid negative length in literal");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new bdi(26, "Invalid length in literal");
    }
    a('\r');
    a('\n');
    aqs localaqs = new aqs(b, i);
    if (i > e) {}
    for (Object localObject = new aya(localaqs);; localObject = new axt(localaqs))
    {
      i = c;
      c = (b + i);
      return (axy)localObject;
    }
  }
  
  public final axu a()
  {
    c = 0;
    axu localaxu;
    try
    {
      localaxu = f();
      String str2 = bbw.a;
      String str1 = String.valueOf(localaxu.toString());
      if (str1.length() != 0) {}
      for (str1 = "<<< ".concat(str1);; str1 = new String("<<< "))
      {
        cvm.a(str2, str1, new Object[0]);
        if (!localaxu.a(0, "BYE", false)) {
          break;
        }
        cvm.d(bbw.a, "Received BYE", new Object[0]);
        localaxu.c();
        throw new axw();
      }
      a.add(localaxu);
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
      throw localRuntimeException;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
    f = c;
    return localaxu;
  }
}

/* Location:
 * Qualified Name:     axv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */