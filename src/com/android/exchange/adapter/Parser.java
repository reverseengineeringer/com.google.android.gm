package com.android.exchange.adapter;

import boy;
import boz;
import bpa;
import bpb;
import bpc;
import bpk;
import btf;
import cvm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Parser
{
  private final Deque<bpc> a = new ArrayDeque();
  private bpc b;
  private int c;
  private String d;
  private byte[] e;
  public InputStream j;
  public int k;
  public int l;
  public boolean m;
  
  public Parser(Parser paramParser)
  {
    a(j, false);
  }
  
  public Parser(InputStream paramInputStream)
  {
    a(paramInputStream, true);
  }
  
  private final int a()
  {
    int i = 0;
    e = null;
    d = null;
    if (m)
    {
      a.removeFirst();
      c = 3;
      m = false;
      return c;
    }
    int n;
    do
    {
      n = k;
      new StringBuilder(17).append("Page: ").append(n);
      n = b();
      if (n != 0) {
        break;
      }
      k = c();
    } while (bpk.a(k));
    i = k;
    throw new boy(this, 29 + "Unknown code page " + i);
    switch (n)
    {
    default: 
      if (bpk.b(n & 0x3F)) {
        throw new boy(this, String.format("Unhandled WBXML global token 0x%02X", new Object[] { Integer.valueOf(n) }));
      }
      break;
    case -1: 
      c = 1;
    }
    for (;;)
    {
      return c;
      c = 3;
      j();
      continue;
      c = 4;
      d = k();
      String str1 = String.valueOf(b);
      String str2 = d;
      a(String.valueOf(str1).length() + 2 + String.valueOf(str2).length() + str1 + ": " + str2);
      continue;
      c = 5;
      n = e();
      e = new byte[n];
      while (i < n)
      {
        e[i] = ((byte)c());
        i += 1;
      }
      str1 = String.valueOf(b);
      a(String.valueOf(str1).length() + 23 + str1 + ": (opaque:" + n + ") ");
      continue;
      if ((n & 0x80) != 0) {
        throw new boy(this, String.format("Attributes unsupported, tag 0x%02X", new Object[] { Integer.valueOf(n) }));
      }
      c = 2;
      c(n);
    }
  }
  
  private final void a(InputStream paramInputStream, boolean paramBoolean)
  {
    j = paramInputStream;
    if ((paramInputStream != null) && (paramBoolean)) {
      try
      {
        c();
        e();
        e();
        if (e() != 0) {
          throw new boy(this, "WBXML string table unsupported");
        }
      }
      catch (bpb paramInputStream)
      {
        throw new boz(this);
      }
    }
  }
  
  private final int b()
  {
    int i = j.read();
    new StringBuilder(17).append("Byte: ").append(i);
    return i;
  }
  
  private final int c()
  {
    int i = b();
    if (i == -1) {
      throw new bpb(this);
    }
    return i;
  }
  
  private final int e()
  {
    int n = 0;
    int i = 0;
    int i2;
    int i1;
    do
    {
      n += 1;
      if (n > 5) {
        throw new boy(this, "Invalid integer encoding, too many bytes");
      }
      i2 = c();
      i1 = i << 7 | i2 & 0x7F;
      i = i1;
    } while ((i2 & 0x80) != 0);
    return i1;
  }
  
  private final String k()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    for (;;)
    {
      int i = b();
      if (i == 0) {
        break;
      }
      if (i == -1) {
        throw new bpb(this);
      }
      localByteArrayOutputStream.write(i);
    }
    localByteArrayOutputStream.flush();
    String str = localByteArrayOutputStream.toString("UTF-8");
    localByteArrayOutputStream.close();
    return str;
  }
  
  public final void a(String paramString)
  {
    if (!cvm.a("Exchange", 2)) {
      return;
    }
    int i = paramString.indexOf('\n');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(0, i);
    }
    paramString = new char[a.size() * 2];
    Arrays.fill(paramString, ' ');
    paramString = String.valueOf(new String(paramString));
    String str2 = String.valueOf(str1);
    if (str2.length() != 0) {}
    for (paramString = paramString.concat(str2);; paramString = new String(paramString))
    {
      cvm.a("Exchange", "%s", new Object[] { paramString });
      btf.a("Exchange", str1);
      return;
    }
  }
  
  public final int b(int paramInt)
  {
    while (a() != 1)
    {
      if (c == 2)
      {
        l = b.a();
        return l;
      }
      if ((c == 3) && (b.a() == paramInt)) {
        return 3;
      }
    }
    if (paramInt == 0) {
      return 1;
    }
    throw new bpa(this);
  }
  
  public final void c(int paramInt)
  {
    b = new bpc(this, k, paramInt);
    m = b.a;
    String str = String.valueOf(b);
    if (m) {}
    for (Object localObject = Character.valueOf('/');; localObject = "")
    {
      localObject = String.valueOf(localObject);
      a(String.valueOf(str).length() + 2 + String.valueOf(localObject).length() + "<" + str + (String)localObject + ">");
      a.addFirst(b);
      return;
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public final byte[] f()
  {
    String str = b.toString();
    a();
    if (c == 3)
    {
      localObject = String.valueOf(str);
      if (((String)localObject).length() != 0)
      {
        localObject = "No value for tag: ".concat((String)localObject);
        a((String)localObject);
        localObject = new byte[0];
      }
    }
    do
    {
      return (byte[])localObject;
      localObject = new String("No value for tag: ");
      break;
      if ((c != 5) && (c != 4))
      {
        localObject = String.valueOf(str);
        if (((String)localObject).length() != 0) {}
        for (localObject = "Expected OPAQUE or TEXT data for tag ".concat((String)localObject);; localObject = new String("Expected OPAQUE or TEXT data for tag ")) {
          throw new boy(this, (String)localObject);
        }
      }
      if (c != 5) {
        break label177;
      }
      localObject = e;
      a();
    } while (c == 3);
    Object localObject = String.valueOf(str);
    if (((String)localObject).length() != 0) {}
    for (localObject = "No END found for tag ".concat((String)localObject);; localObject = new String("No END found for tag "))
    {
      throw new boy(this, (String)localObject);
      label177:
      localObject = d.getBytes("UTF-8");
      break;
    }
  }
  
  public final String g()
  {
    String str2 = b.toString();
    a();
    if (c == 3)
    {
      str1 = String.valueOf(str2);
      if (str1.length() != 0)
      {
        str1 = "No value for tag: ".concat(str1);
        a(str1);
        str1 = "";
      }
    }
    do
    {
      return str1;
      str1 = new String("No value for tag: ");
      break;
      if (c != 4)
      {
        str1 = String.valueOf(str2);
        if (str1.length() != 0) {}
        for (str1 = "Expected TEXT data for tag ".concat(str1);; str1 = new String("Expected TEXT data for tag ")) {
          throw new boy(this, str1);
        }
      }
      str1 = d;
      a();
    } while (c == 3);
    String str1 = String.valueOf(str2);
    if (str1.length() != 0) {}
    for (str1 = "No END found for tag ".concat(str1);; str1 = new String("No END found for tag ")) {
      throw new boy(this, str1);
    }
  }
  
  public final int h()
  {
    String str1 = g();
    if (str1.length() == 0) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(str1);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      str1 = String.valueOf(b);
      String str2 = String.valueOf(localNumberFormatException.getMessage());
      throw new boy(this, String.valueOf(str1).length() + 6 + String.valueOf(str2).length() + "Tag " + str1 + ": " + str2);
    }
  }
  
  public final void i()
  {
    int i = b.a();
    while (a() != 1) {
      if ((c == 3) && (b.a() == i)) {
        return;
      }
    }
    throw new bpb(this);
  }
  
  public final void j()
  {
    b = ((bpc)a.removeFirst());
    String str = String.valueOf(b);
    a(String.valueOf(str).length() + 3 + "</" + str + ">");
  }
  
  void resetInput(InputStream paramInputStream)
  {
    j = paramInputStream;
    try
    {
      b();
      return;
    }
    catch (IOException paramInputStream) {}
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.adapter.Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */