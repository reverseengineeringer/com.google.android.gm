package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Serialization
{
  static <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMap.put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  static int readCount(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    return paramObjectInputStream.readInt();
  }
  
  static <K, V> void writeMap(Map<K, V> paramMap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */