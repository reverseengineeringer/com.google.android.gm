package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

class AbstractBiMap$Inverse<K, V>
  extends AbstractBiMap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  private AbstractBiMap$Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    super(paramMap, paramAbstractBiMap, null);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    setInverse((AbstractBiMap)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(inverse());
  }
  
  Object readResolve()
  {
    return inverse().inverse();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.Inverse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */