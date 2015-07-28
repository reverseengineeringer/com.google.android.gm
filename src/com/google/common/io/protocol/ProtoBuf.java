package com.google.common.io.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class ProtoBuf
{
  public static final Boolean FALSE = new Boolean(false);
  private static Long[] SMALL_NUMBERS = { new Long(0L), new Long(1L), new Long(2L), new Long(3L), new Long(4L), new Long(5L), new Long(6L), new Long(7L), new Long(8L), new Long(9L), new Long(10L), new Long(11L), new Long(12L), new Long(13L), new Long(14L), new Long(15L) };
  public static final Boolean TRUE = new Boolean(true);
  private ProtoBufType msgType;
  private final Vector values = new Vector();
  private final StringBuffer wireTypes = new StringBuffer();
  
  public ProtoBuf(ProtoBufType paramProtoBufType)
  {
    msgType = paramProtoBufType;
  }
  
  private void assertTypeMatch(int paramInt, Object paramObject)
  {
    int i = getType(paramInt);
    if ((i == 16) && (msgType == null)) {}
    label19:
    do
    {
      return;
      if (!(paramObject instanceof Boolean)) {
        break;
      }
    } while ((i == 24) || (i == 0));
    for (;;)
    {
      throw new IllegalArgumentException("Type mismatch type:" + msgType + " tag:" + paramInt);
      if ((paramObject instanceof Long)) {
        switch (i)
        {
        }
      } else if ((paramObject instanceof byte[])) {
        switch (i)
        {
        }
      } else if ((paramObject instanceof ProtoBuf)) {
        switch (i)
        {
        default: 
          break;
        case 2: 
        case 3: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
          if ((msgType == null) || (msgType.getData(paramInt) == null) || (msgType == null)) {
            break label19;
          }
          if (msgType != msgType.getData(paramInt)) {
            continue;
          }
          return;
        }
      } else if ((paramObject instanceof String)) {
        switch (i)
        {
        }
      }
    }
  }
  
  private Object convert(Object paramObject, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 17: 
    case 18: 
    case 20: 
    case 29: 
    case 30: 
    default: 
      throw new RuntimeException("Unsupp.Type");
    case 24: 
      if (!(paramObject instanceof Boolean)) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramObject;
            switch ((int)((Long)paramObject).longValue())
            {
            default: 
              throw new IllegalArgumentException("Type mismatch");
            case 0: 
              return FALSE;
            }
            return TRUE;
          } while (!(paramObject instanceof Boolean));
          localObject = SMALL_NUMBERS;
          if (((Boolean)paramObject).booleanValue()) {}
          for (paramInt = i;; paramInt = 0) {
            return localObject[paramInt];
          }
          if ((paramObject instanceof String)) {
            return encodeUtf8((String)paramObject);
          }
        } while (!(paramObject instanceof ProtoBuf));
        Object localObject = new ByteArrayOutputStream();
        try
        {
          ((ProtoBuf)paramObject).outputTo((OutputStream)localObject);
          paramObject = ((ByteArrayOutputStream)localObject).toByteArray();
          return paramObject;
        }
        catch (IOException paramObject)
        {
          throw new RuntimeException(((IOException)paramObject).toString());
        }
      } while (!(paramObject instanceof byte[]));
      paramObject = (byte[])paramObject;
      return decodeUtf8((byte[])paramObject, 0, paramObject.length, true);
    } while (!(paramObject instanceof byte[]));
    try
    {
      paramObject = new ProtoBuf(null).parse((byte[])paramObject);
      return paramObject;
    }
    catch (IOException paramObject)
    {
      throw new RuntimeException(((IOException)paramObject).toString());
    }
  }
  
  static String decodeUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 - paramInt1);
    int i = paramInt1;
    label92:
    int m;
    int k;
    int n;
    if (i < paramInt2)
    {
      paramInt1 = i + 1;
      int i1 = paramArrayOfByte[i] & 0xFF;
      if (i1 <= 127) {
        localStringBuffer.append((char)i1);
      }
      for (;;)
      {
        i = paramInt1;
        break;
        if (i1 < 245) {
          break label92;
        }
        if (!paramBoolean) {
          throw new IllegalArgumentException("Invalid UTF8");
        }
        localStringBuffer.append((char)i1);
      }
      m = 224;
      int j = 1;
      k = 128;
      i = 31;
      if (i1 >= m)
      {
        n = m >> 1 | 0x80;
        if (j == 1) {}
        for (m = 4;; m = 5)
        {
          k <<= m;
          j += 1;
          i >>= 1;
          m = n;
          break;
        }
      }
      i = i1 & i;
      m = 0;
      label177:
      if (m < j)
      {
        n = i << 6;
        if (paramInt1 >= paramInt2)
        {
          if (paramBoolean) {
            break label372;
          }
          throw new IllegalArgumentException("Invalid UTF8");
        }
        if ((!paramBoolean) && ((paramArrayOfByte[paramInt1] & 0xC0) != 128)) {
          throw new IllegalArgumentException("Invalid UTF8");
        }
        i = paramInt1 + 1;
      }
    }
    for (paramInt1 = n | paramArrayOfByte[paramInt1] & 0x3F;; paramInt1 = n)
    {
      m += 1;
      n = i;
      i = paramInt1;
      paramInt1 = n;
      break label177;
      if (((!paramBoolean) && (i < k)) || ((i >= 55296) && (i <= 57343))) {
        throw new IllegalArgumentException("Invalid UTF8");
      }
      if (i <= 65535)
      {
        localStringBuffer.append((char)i);
        break;
      }
      i -= 65536;
      localStringBuffer.append((char)(0xD800 | i >> 10));
      localStringBuffer.append((char)(0xDC00 | i & 0x3FF));
      break;
      return localStringBuffer.toString();
      label372:
      i = paramInt1;
    }
  }
  
  static int encodeUtf8(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramString.length();
    int i = 0;
    int j = paramInt;
    if (i < i1)
    {
      paramInt = paramString.charAt(i);
      int n = paramInt;
      int k = i;
      int m;
      if (paramInt >= 55296)
      {
        n = paramInt;
        k = i;
        if (paramInt <= 57343)
        {
          n = paramInt;
          k = i;
          if (i + 1 < i1)
          {
            m = paramString.charAt(i + 1);
            n = paramInt;
            k = i;
            if ((m & 0xFC00 ^ paramInt & 0xFC00) == 1024)
            {
              k = i + 1;
              if ((m & 0xFC00) != 55296) {
                break label165;
              }
              i = paramInt;
              paramInt = m;
              label112:
              n = ((paramInt & 0x3FF) << 10 | i & 0x3FF) + 65536;
            }
          }
        }
      }
      if (n <= 127)
      {
        if (paramArrayOfByte != null) {
          paramArrayOfByte[j] = ((byte)n);
        }
        paramInt = j + 1;
      }
      for (;;)
      {
        i = k + 1;
        j = paramInt;
        break;
        label165:
        i = m;
        break label112;
        if (n <= 2047)
        {
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte[j] = ((byte)(n >> 6 | 0xC0));
            paramArrayOfByte[(j + 1)] = ((byte)(n & 0x3F | 0x80));
          }
          paramInt = j + 2;
        }
        else if (n <= 65535)
        {
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte[j] = ((byte)(n >> 12 | 0xE0));
            paramArrayOfByte[(j + 1)] = ((byte)(n >> 6 & 0x3F | 0x80));
            paramArrayOfByte[(j + 2)] = ((byte)(n & 0x3F | 0x80));
          }
          paramInt = j + 3;
        }
        else
        {
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte[j] = ((byte)(n >> 18 | 0xF0));
            paramArrayOfByte[(j + 1)] = ((byte)(n >> 12 & 0x3F | 0x80));
            paramArrayOfByte[(j + 2)] = ((byte)(n >> 6 & 0x3F | 0x80));
            paramArrayOfByte[(j + 3)] = ((byte)(n & 0x3F | 0x80));
          }
          paramInt = j + 4;
        }
      }
    }
    return j;
  }
  
  static byte[] encodeUtf8(String paramString)
  {
    byte[] arrayOfByte = new byte[encodeUtf8(paramString, null, 0)];
    encodeUtf8(paramString, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private int getDataSize(int paramInt1, int paramInt2)
  {
    int i = getVarIntSize(paramInt1 << 3);
    Object localObject;
    switch (getWireType(paramInt1))
    {
    case 2: 
    case 4: 
    default: 
      localObject = getObject(paramInt1, paramInt2, 16);
      if ((localObject instanceof byte[])) {
        paramInt1 = ((byte[])localObject).length;
      }
      break;
    }
    for (;;)
    {
      return getVarIntSize(paramInt1) + i + paramInt1;
      return i + 4;
      return i + 8;
      long l2 = getLong(paramInt1, paramInt2);
      long l1 = l2;
      if (isZigZagEncodedType(paramInt1)) {
        l1 = zigZagEncode(l2);
      }
      return getVarIntSize(l1) + i;
      return getProtoBuf(paramInt1, paramInt2).getDataSize() + i + i;
      if ((localObject instanceof String)) {
        paramInt1 = encodeUtf8((String)localObject, null, 0);
      } else {
        paramInt1 = ((ProtoBuf)localObject).getDataSize();
      }
    }
  }
  
  private Object getDefault(int paramInt)
  {
    switch (getType(paramInt))
    {
    default: 
      return msgType.getData(paramInt);
    }
    return null;
  }
  
  private Object getObject(int paramInt1, int paramInt2)
  {
    int i = getCount(paramInt1);
    if (i == 0) {
      return getDefault(paramInt1);
    }
    if (i > 1) {
      throw new IllegalArgumentException();
    }
    return getObject(paramInt1, 0, paramInt2);
  }
  
  private Object getObject(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= getCount(paramInt1)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object localObject2 = values.elementAt(paramInt1);
    Vector localVector = null;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof Vector))
    {
      localVector = (Vector)localObject2;
      localObject1 = localVector.elementAt(paramInt2);
    }
    localObject2 = convert(localObject1, paramInt3);
    if ((localObject2 != localObject1) && (localObject1 != null))
    {
      if (localVector == null) {
        setObject(paramInt1, localObject2);
      }
    }
    else {
      return localObject2;
    }
    localVector.setElementAt(localObject2, paramInt2);
    return localObject2;
  }
  
  private static int getVarIntSize(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = 10;
      return j;
    }
    int i = 1;
    for (;;)
    {
      j = i;
      if (paramLong < 128L) {
        break;
      }
      i += 1;
      paramLong >>= 7;
    }
  }
  
  private final int getWireType(int paramInt)
  {
    int j = getType(paramInt);
    int i = j;
    switch (j)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      throw new RuntimeException("Unsupp.Type:" + msgType + '/' + paramInt + '/' + j);
    case 19: 
    case 20: 
    case 21: 
    case 24: 
    case 29: 
    case 30: 
    case 33: 
    case 34: 
      i = 0;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 16: 
      return i;
    case 25: 
    case 27: 
    case 28: 
    case 35: 
    case 36: 
      return 2;
    case 17: 
    case 22: 
    case 32: 
      return 1;
    case 18: 
    case 23: 
    case 31: 
      return 5;
    }
    return 3;
  }
  
  private void insertObject(int paramInt1, int paramInt2, Object paramObject)
  {
    assertTypeMatch(paramInt1, paramObject);
    if (getCount(paramInt1) == 0)
    {
      setObject(paramInt1, paramObject);
      return;
    }
    Object localObject = values.elementAt(paramInt1);
    Vector localVector;
    if ((localObject instanceof Vector)) {
      localVector = (Vector)localObject;
    }
    for (;;)
    {
      localVector.insertElementAt(paramObject, paramInt2);
      return;
      localVector = new Vector();
      localVector.addElement(localObject);
      values.setElementAt(localVector, paramInt1);
    }
  }
  
  private boolean isZigZagEncodedType(int paramInt)
  {
    paramInt = getType(paramInt);
    return (paramInt == 33) || (paramInt == 34);
  }
  
  static long readVarInt(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    long l1 = 0L;
    int j = 0;
    int i = 0;
    for (;;)
    {
      long l2 = l1;
      if (i < 10)
      {
        int k = paramInputStream.read();
        if (k == -1)
        {
          if ((i == 0) && (paramBoolean)) {
            return -1L;
          }
          throw new IOException("EOF");
        }
        l1 |= (k & 0x7F) << j;
        if ((k & 0x80) == 0) {
          l2 = l1;
        }
      }
      else
      {
        return l2;
      }
      j += 7;
      i += 1;
    }
  }
  
  private void setObject(int paramInt, Object paramObject)
  {
    if (values.size() <= paramInt) {
      values.setSize(paramInt + 1);
    }
    if (paramObject != null) {
      assertTypeMatch(paramInt, paramObject);
    }
    values.setElementAt(paramObject, paramInt);
  }
  
  static void writeVarInt(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      int j;
      if (i < 10)
      {
        j = (int)(0x7F & paramLong);
        paramLong >>>= 7;
        if (paramLong == 0L) {
          paramOutputStream.write(j);
        }
      }
      else
      {
        return;
      }
      paramOutputStream.write(j | 0x80);
      i += 1;
    }
  }
  
  private static long zigZagDecode(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private static long zigZagEncode(long paramLong)
  {
    return paramLong << 1 ^ -(paramLong >>> 63);
  }
  
  public void addLong(int paramInt, long paramLong)
  {
    insertLong(paramInt, getCount(paramInt), paramLong);
  }
  
  public ProtoBuf addNewProtoBuf(int paramInt)
  {
    ProtoBuf localProtoBuf = newProtoBufForTag(paramInt);
    addProtoBuf(paramInt, localProtoBuf);
    return localProtoBuf;
  }
  
  public void addProtoBuf(int paramInt, ProtoBuf paramProtoBuf)
  {
    insertProtoBuf(paramInt, getCount(paramInt), paramProtoBuf);
  }
  
  public void addString(int paramInt, String paramString)
  {
    insertString(paramInt, getCount(paramInt), paramString);
  }
  
  public void clear()
  {
    values.setSize(0);
    wireTypes.setLength(0);
  }
  
  public boolean getBool(int paramInt)
  {
    return ((Boolean)getObject(paramInt, 24)).booleanValue();
  }
  
  public byte[] getBytes(int paramInt)
  {
    return (byte[])getObject(paramInt, 25);
  }
  
  public int getCount(int paramInt)
  {
    if (paramInt >= values.size()) {}
    Object localObject;
    do
    {
      return 0;
      localObject = values.elementAt(paramInt);
    } while (localObject == null);
    if ((localObject instanceof Vector)) {
      return ((Vector)localObject).size();
    }
    return 1;
  }
  
  public int getDataSize()
  {
    int j = 0;
    int i = 0;
    while (i <= maxTag())
    {
      int k = 0;
      while (k < getCount(i))
      {
        j += getDataSize(i, k);
        k += 1;
      }
      i += 1;
    }
    return j;
  }
  
  public int getInt(int paramInt)
  {
    return (int)((Long)getObject(paramInt, 21)).longValue();
  }
  
  public long getLong(int paramInt)
  {
    return ((Long)getObject(paramInt, 19)).longValue();
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    return ((Long)getObject(paramInt1, paramInt2, 19)).longValue();
  }
  
  public ProtoBuf getProtoBuf(int paramInt)
  {
    return (ProtoBuf)getObject(paramInt, 26);
  }
  
  public ProtoBuf getProtoBuf(int paramInt1, int paramInt2)
  {
    return (ProtoBuf)getObject(paramInt1, paramInt2, 26);
  }
  
  public String getString(int paramInt)
  {
    return (String)getObject(paramInt, 28);
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    return (String)getObject(paramInt1, paramInt2, 28);
  }
  
  public int getType(int paramInt)
  {
    int j = 16;
    if (msgType != null) {
      j = msgType.getType(paramInt);
    }
    int i = j;
    if (j == 16)
    {
      i = j;
      if (paramInt < wireTypes.length()) {
        i = wireTypes.charAt(paramInt);
      }
    }
    j = i;
    if (i == 16)
    {
      j = i;
      if (getCount(paramInt) > 0)
      {
        Object localObject = getObject(paramInt, 0, 16);
        if ((!(localObject instanceof Long)) && (!(localObject instanceof Boolean))) {
          break label97;
        }
        j = 0;
      }
    }
    return j;
    label97:
    return 2;
  }
  
  public boolean has(int paramInt)
  {
    return (getCount(paramInt) > 0) || (getDefault(paramInt) != null);
  }
  
  public void insertLong(int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < SMALL_NUMBERS.length)) {}
    for (Long localLong = SMALL_NUMBERS[((int)paramLong)];; localLong = new Long(paramLong))
    {
      insertObject(paramInt1, paramInt2, localLong);
      return;
    }
  }
  
  public void insertProtoBuf(int paramInt1, int paramInt2, ProtoBuf paramProtoBuf)
  {
    insertObject(paramInt1, paramInt2, paramProtoBuf);
  }
  
  public void insertString(int paramInt1, int paramInt2, String paramString)
  {
    insertObject(paramInt1, paramInt2, paramString);
  }
  
  public int maxTag()
  {
    return values.size() - 1;
  }
  
  public ProtoBuf newProtoBufForTag(int paramInt)
  {
    return new ProtoBuf((ProtoBufType)msgType.getData(paramInt));
  }
  
  public void outputTo(OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    while (i <= maxTag())
    {
      int n = getCount(i);
      int i1 = getWireType(i);
      int j = 0;
      if (j < n)
      {
        writeVarInt(paramOutputStream, i << 3 | i1);
        long l1;
        int k;
        switch (i1)
        {
        case 4: 
        default: 
          throw new IllegalArgumentException();
        case 1: 
        case 5: 
          l1 = ((Long)getObject(i, j, 19)).longValue();
          if (i1 == 5) {}
          for (k = 4;; k = 8)
          {
            int m = 0;
            while (m < k)
            {
              paramOutputStream.write((int)(0xFF & l1));
              l1 >>= 8;
              m += 1;
            }
          }
        case 0: 
          long l2 = ((Long)getObject(i, j, 19)).longValue();
          l1 = l2;
          if (isZigZagEncodedType(i)) {
            l1 = zigZagEncode(l2);
          }
          writeVarInt(paramOutputStream, l1);
        }
        for (;;)
        {
          j += 1;
          break;
          if (getType(i) == 27) {}
          for (k = 16;; k = 25)
          {
            localObject = getObject(i, j, k);
            if (!(localObject instanceof byte[])) {
              break label275;
            }
            localObject = (byte[])localObject;
            writeVarInt(paramOutputStream, localObject.length);
            paramOutputStream.write((byte[])localObject);
            break;
          }
          label275:
          Object localObject = (ProtoBuf)localObject;
          writeVarInt(paramOutputStream, ((ProtoBuf)localObject).getDataSize());
          ((ProtoBuf)localObject).outputTo(paramOutputStream);
          continue;
          ((ProtoBuf)getObject(i, j, 26)).outputTo(paramOutputStream);
          writeVarInt(paramOutputStream, i << 3 | 0x4);
        }
      }
      i += 1;
    }
  }
  
  public int parse(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    clear();
    int i = paramInt;
    long l1;
    if (paramInt > 0)
    {
      l1 = readVarInt(paramInputStream, true);
      if (l1 != -1L) {
        break label40;
      }
      i = paramInt;
    }
    while (i < 0)
    {
      throw new IOException();
      label40:
      int j = paramInt - getVarIntSize(l1);
      paramInt = (int)l1 & 0x7;
      i = j;
      if (paramInt != 4)
      {
        int k = (int)(l1 >>> 3);
        while (wireTypes.length() <= k) {
          wireTypes.append('\020');
        }
        wireTypes.setCharAt(k, (char)paramInt);
        switch (paramInt)
        {
        case 4: 
        default: 
          throw new RuntimeException("Unsupp.Type" + paramInt);
        case 0: 
          long l2 = readVarInt(paramInputStream, false);
          paramInt = j - getVarIntSize(l2);
          l1 = l2;
          if (isZigZagEncodedType(k)) {
            l1 = zigZagDecode(l2);
          }
          if ((l1 >= 0L) && (l1 < SMALL_NUMBERS.length)) {
            localObject = SMALL_NUMBERS[((int)l1)];
          }
        case 1: 
        case 5: 
        case 2: 
          for (;;)
          {
            insertObject(k, getCount(k), localObject);
            break;
            localObject = new Long(l1);
            continue;
            l1 = 0L;
            i = 0;
            if (paramInt == 5) {}
            for (paramInt = 4;; paramInt = 8)
            {
              j -= paramInt;
              while (paramInt > 0)
              {
                l1 |= paramInputStream.read() << i;
                i += 8;
                paramInt -= 1;
              }
            }
            if ((l1 >= 0L) && (l1 < SMALL_NUMBERS.length)) {}
            for (localObject = SMALL_NUMBERS[((int)l1)];; localObject = new Long(l1))
            {
              paramInt = j;
              break;
            }
            int m = (int)readVarInt(paramInputStream, false);
            i = j - getVarIntSize(m) - m;
            if (getType(k) == 27)
            {
              localObject = new ProtoBuf((ProtoBufType)msgType.getData(k));
              ((ProtoBuf)localObject).parse(paramInputStream, m);
              paramInt = i;
            }
            else
            {
              localObject = new byte[m];
              paramInt = 0;
              while (paramInt < m)
              {
                j = paramInputStream.read((byte[])localObject, paramInt, m - paramInt);
                if (j <= 0) {
                  throw new IOException("Unexp.EOF");
                }
                paramInt += j;
              }
              paramInt = i;
            }
          }
        }
        if (msgType == null) {}
        for (Object localObject = null;; localObject = (ProtoBufType)msgType.getData(k))
        {
          localObject = new ProtoBuf((ProtoBufType)localObject);
          paramInt = ((ProtoBuf)localObject).parse(paramInputStream, j);
          break;
        }
      }
    }
    return i;
  }
  
  public ProtoBuf parse(InputStream paramInputStream)
    throws IOException
  {
    parse(paramInputStream, Integer.MAX_VALUE);
    return this;
  }
  
  public ProtoBuf parse(byte[] paramArrayOfByte)
    throws IOException
  {
    parse(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    return this;
  }
  
  public void setBool(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = TRUE;; localBoolean = FALSE)
    {
      setObject(paramInt, localBoolean);
      return;
    }
  }
  
  public void setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    setObject(paramInt, paramArrayOfByte);
  }
  
  public void setInt(int paramInt1, int paramInt2)
  {
    setLong(paramInt1, paramInt2);
  }
  
  public void setLong(int paramInt, long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < SMALL_NUMBERS.length)) {}
    for (Long localLong = SMALL_NUMBERS[((int)paramLong)];; localLong = new Long(paramLong))
    {
      setObject(paramInt, localLong);
      return;
    }
  }
  
  public ProtoBuf setNewProtoBuf(int paramInt)
  {
    ProtoBuf localProtoBuf = newProtoBufForTag(paramInt);
    setProtoBuf(paramInt, localProtoBuf);
    return localProtoBuf;
  }
  
  public void setProtoBuf(int paramInt, ProtoBuf paramProtoBuf)
  {
    setObject(paramInt, paramProtoBuf);
  }
  
  public void setString(int paramInt, String paramString)
  {
    setObject(paramInt, paramString);
  }
  
  void setType(ProtoBufType paramProtoBufType)
  {
    if ((values.size() != 0) || ((msgType != null) && (paramProtoBufType != null) && (paramProtoBufType != msgType))) {
      throw new IllegalArgumentException();
    }
    msgType = paramProtoBufType;
  }
  
  public byte[] toByteArray()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    outputTo(localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:
 * Qualified Name:     com.google.common.io.protocol.ProtoBuf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */