package com.android.mail.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.text.TextUtils;
import buj;
import bwg;
import ccx;
import cga;
import cgb;
import cvl;
import cvm;
import hef;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Conversation
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<Conversation> CREATOR;
  public static final ccx<Conversation> F = new cgb();
  private static String I;
  private static final Collection<Conversation> J;
  private static final Bundle K;
  private static final Bundle L;
  public static final String a = cvl.a;
  public int A;
  public final boolean B;
  @Deprecated
  public transient int C;
  public transient boolean D;
  public transient boolean E;
  private final int G;
  private int H;
  public final long b;
  public final Uri c;
  public final String d;
  public final long e;
  public final boolean f;
  public final Uri g;
  public final int h;
  public int i;
  public boolean j;
  public boolean k;
  public boolean l;
  public int m = 1;
  public FolderList n;
  public int o;
  public final int p;
  public final boolean q;
  public final boolean r;
  public final Uri s;
  public final ConversationInfo t;
  public final Uri u;
  public final boolean v;
  public final long w;
  public final int x;
  public final String y;
  public final String z;
  
  static
  {
    J = Collections.emptyList();
    CREATOR = new cga();
    Bundle localBundle = new Bundle(2);
    L = localBundle;
    localBundle.putBoolean("rawFolders", true);
    L.putInt("options", 1);
    localBundle = new Bundle(2);
    K = localBundle;
    localBundle.putBoolean("conversationInfo", true);
    K.putInt("options", 1);
  }
  
  public Conversation(Cursor paramCursor)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("Creating conversation from null cursor");
    }
    b = paramCursor.getLong(0);
    c = Uri.parse(paramCursor.getString(1));
    e = paramCursor.getLong(6);
    Object localObject1 = paramCursor.getString(3);
    if (localObject1 == null)
    {
      d = "";
      if (paramCursor.getInt(7) == 0) {
        break label579;
      }
      bool1 = true;
      label98:
      f = bool1;
      localObject1 = paramCursor.getString(2);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label584;
      }
      localObject1 = Uri.parse((String)localObject1);
      label127:
      g = ((Uri)localObject1);
      h = paramCursor.getInt(10);
      i = paramCursor.getInt(11);
      if (paramCursor.getInt(12) == 0) {
        break label590;
      }
      bool1 = true;
      label170:
      j = bool1;
      if (paramCursor.getInt(13) == 0) {
        break label595;
      }
      bool1 = true;
      label188:
      k = bool1;
      if (paramCursor.getInt(14) == 0) {
        break label600;
      }
      bool1 = true;
      label206:
      l = bool1;
      if (!(paramCursor instanceof bwg)) {
        break label605;
      }
      localObject1 = ((bwg)paramCursor).a(15);
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label605;
      }
      localObject1 = FolderList.a((byte[])localObject1);
      label247:
      n = ((FolderList)localObject1);
      o = paramCursor.getInt(16);
      p = paramCursor.getInt(17);
      if (paramCursor.getInt(18) == 0) {
        break label657;
      }
      bool1 = true;
      label290:
      q = bool1;
      if (paramCursor.getInt(20) == 0) {
        break label662;
      }
      bool1 = true;
      label308:
      r = bool1;
      G = paramCursor.getInt(21);
      localObject1 = paramCursor.getString(22);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label667;
      }
      localObject1 = Uri.parse((String)localObject1);
      label350:
      s = ((Uri)localObject1);
      C = -1;
      D = false;
      if (!(paramCursor instanceof bwg)) {
        break label673;
      }
      localObject1 = ((bwg)paramCursor).a(5);
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label673;
      }
      localObject1 = ConversationInfo.a((byte[])localObject1);
      label401:
      t = ((ConversationInfo)localObject1);
      if (t == null) {
        cvm.f(a, "Null conversation info from cursor", new Object[0]);
      }
      String str = paramCursor.getString(24);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = Uri.parse(str);
      }
      u = ((Uri)localObject1);
      if (paramCursor.getInt(25) == 0) {
        break label724;
      }
    }
    label579:
    label584:
    label590:
    label595:
    label600:
    label605:
    label657:
    label662:
    label667:
    label673:
    label724:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v = bool1;
      w = paramCursor.getLong(26);
      x = paramCursor.getInt(27);
      H = paramCursor.getInt(28);
      y = paramCursor.getString(29);
      z = paramCursor.getString(30);
      m = paramCursor.getInt(31);
      A = paramCursor.getInt(32);
      B = false;
      return;
      d = ((String)localObject1);
      break;
      bool1 = false;
      break label98;
      localObject1 = null;
      break label127;
      bool1 = false;
      break label170;
      bool1 = false;
      break label188;
      bool1 = false;
      break label206;
      localObject1 = paramCursor.respond(L);
      if (((Bundle)localObject1).containsKey("rawFolders"))
      {
        localObject1 = (FolderList)((Bundle)localObject1).getParcelable("rawFolders");
        break label247;
      }
      localObject1 = FolderList.a(paramCursor.getBlob(15));
      break label247;
      bool1 = false;
      break label290;
      bool1 = false;
      break label308;
      localObject1 = null;
      break label350;
      localObject1 = paramCursor.respond(K);
      if (((Bundle)localObject1).containsKey("conversationInfo"))
      {
        localObject1 = (ConversationInfo)((Bundle)localObject1).getParcelable("conversationInfo");
        break label401;
      }
      localObject1 = ConversationInfo.a(paramCursor.getBlob(5));
      break label401;
    }
  }
  
  public Conversation(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    b = paramParcel.readLong();
    c = ((Uri)paramParcel.readParcelable(null));
    d = paramParcel.readString();
    e = paramParcel.readLong();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      f = bool1;
      g = ((Uri)paramParcel.readParcelable(null));
      h = paramParcel.readInt();
      i = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label324;
      }
      bool1 = true;
      label99:
      j = bool1;
      if (paramParcel.readInt() == 0) {
        break label329;
      }
      bool1 = true;
      label113:
      k = bool1;
      if (paramParcel.readInt() == 0) {
        break label334;
      }
      bool1 = true;
      label127:
      l = bool1;
      n = ((FolderList)paramParcel.readParcelable(paramClassLoader));
      o = paramParcel.readInt();
      p = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label339;
      }
      bool1 = true;
      label169:
      q = bool1;
      if (paramParcel.readInt() == 0) {
        break label344;
      }
      bool1 = true;
      label183:
      r = bool1;
      G = paramParcel.readInt();
      s = ((Uri)paramParcel.readParcelable(null));
      C = -1;
      D = false;
      t = ((ConversationInfo)paramParcel.readParcelable(paramClassLoader));
      u = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readInt() == 0) {
        break label349;
      }
    }
    label324:
    label329:
    label334:
    label339:
    label344:
    label349:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v = bool1;
      w = paramParcel.readLong();
      x = paramParcel.readInt();
      H = paramParcel.readInt();
      y = paramParcel.readString();
      z = paramParcel.readString();
      m = paramParcel.readInt();
      A = paramParcel.readInt();
      B = false;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label99;
      bool1 = false;
      break label113;
      bool1 = false;
      break label127;
      bool1 = false;
      break label169;
      bool1 = false;
      break label183;
    }
  }
  
  public Conversation(Conversation paramConversation)
  {
    if (paramConversation == null) {
      throw new IllegalArgumentException("Copying null conversation");
    }
    b = b;
    c = c;
    e = e;
    d = d;
    f = f;
    g = g;
    h = h;
    i = i;
    j = j;
    k = k;
    l = l;
    n = n;
    o = o;
    p = p;
    q = q;
    r = r;
    G = G;
    s = s;
    C = C;
    D = D;
    t = t;
    u = u;
    v = v;
    w = w;
    x = x;
    H = H;
    y = y;
    z = z;
    m = m;
    A = A;
    B = false;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if (TextUtils.isEmpty(paramString2)) {
      str = paramContext.getString(buj.dn);
    }
    do
    {
      return str;
      str = paramString2;
    } while (TextUtils.isEmpty(paramString1));
    if (I == null) {
      I = paramContext.getString(buj.K);
    }
    return String.format(I, new Object[] { paramString1, paramString2 });
  }
  
  public static String a(Collection<Conversation> paramCollection)
  {
    int i1 = paramCollection.size();
    StringBuilder localStringBuilder = new StringBuilder(26 + i1 + " conversations:");
    paramCollection = paramCollection.iterator();
    i1 = 0;
    while (paramCollection.hasNext())
    {
      Object localObject = (Conversation)paramCollection.next();
      i1 += 1;
      localObject = String.valueOf(((Conversation)localObject).toString());
      localStringBuilder.append(String.valueOf(localObject).length() + 20 + "      " + i1 + ": " + (String)localObject + "\n");
    }
    return localStringBuilder.toString();
  }
  
  public static Collection<Conversation> a(Conversation paramConversation)
  {
    if (paramConversation == null) {
      return J;
    }
    return hef.a(paramConversation);
  }
  
  public static boolean a(Collection<Conversation> paramCollection, Conversation paramConversation)
  {
    if ((paramCollection == null) || (paramCollection.size() <= 0)) {
      return false;
    }
    if (paramConversation == null) {
      return true;
    }
    long l1 = b;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (l1 == nextb) {
        return true;
      }
    }
    return false;
  }
  
  public final String a(String paramString)
  {
    if (u != null) {
      paramString = u.toString();
    }
    return paramString;
  }
  
  public final void a(ContentValues paramContentValues)
  {
    Iterator localIterator = paramContentValues.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramContentValues.get((String)localObject1);
      cvm.b(a, "Conversation: applying cached value to col=%s val=%s", new Object[] { localObject1, localObject2 });
      boolean bool;
      if ("read".equals(localObject1))
      {
        if (((Integer)localObject2).intValue() != 0) {}
        for (bool = true;; bool = false)
        {
          j = bool;
          break;
        }
      }
      if ("conversationInfo".equals(localObject1))
      {
        localObject1 = ConversationInfo.a((byte[])localObject2);
        if (localObject1 == null)
        {
          cvm.b(a, "Null ConversationInfo in applyCachedValues", new Object[0]);
        }
        else
        {
          localObject2 = t;
          a.clear();
          a.addAll(a);
          b = b;
          c = c;
          d = d;
          e = e;
        }
      }
      else
      {
        int i1;
        if ("conversationFlags".equals(localObject1))
        {
          if (localObject2 != null) {}
          for (i1 = ((Integer)localObject2).intValue();; i1 = 0)
          {
            o = i1;
            break;
          }
        }
        if ("starred".equals(localObject1))
        {
          if (((Integer)localObject2).intValue() != 0) {}
          for (bool = true;; bool = false)
          {
            l = bool;
            break;
          }
        }
        if ("seen".equals(localObject1))
        {
          if (((Integer)localObject2).intValue() != 0) {}
          for (bool = true;; bool = false)
          {
            k = bool;
            break;
          }
        }
        if ("rawFolders".equals(localObject1)) {
          n = FolderList.a((byte[])localObject2);
        } else if (!"viewed".equals(localObject1)) {
          if ("importance".equals(localObject1))
          {
            i = ((Integer)localObject2).intValue();
          }
          else
          {
            if ("unsubscribeState".equals(localObject1))
            {
              if (localObject2 != null) {}
              for (i1 = ((Integer)localObject2).intValue();; i1 = 0)
              {
                H = i1;
                break;
              }
            }
            if (!"unsubscribeSenderIdentifier".equals(localObject1))
            {
              if ("priority".equals(localObject1))
              {
                if (localObject2 != null) {}
                for (i1 = ((Integer)localObject2).intValue();; i1 = 0)
                {
                  m = i1;
                  break;
                }
              }
              cvm.e(a, new UnsupportedOperationException(), "unsupported cached conv value in col=%s", new Object[] { localObject1 });
            }
          }
        }
      }
    }
  }
  
  public final boolean a()
  {
    return i == 1;
  }
  
  public final boolean b()
  {
    return (o & 0x1) != 0;
  }
  
  public final boolean c()
  {
    return (o & 0x10) == 16;
  }
  
  public final String d()
  {
    if (!TextUtils.isEmpty(t.d)) {
      return t.d;
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    Iterator localIterator = n.a.iterator();
    while (localIterator.hasNext()) {
      if (((Folder)localIterator.next()).d(32)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Conversation)) {
      return c.equals(c);
    }
    return false;
  }
  
  public final boolean f()
  {
    return (z != null) && ((H == 1) || (H == 2)) && (!q) && (!e());
  }
  
  public int hashCode()
  {
    return c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[conversation id=");
    localStringBuilder.append(b);
    if (cvm.a(a, 3))
    {
      localStringBuilder.append(", subject=");
      localStringBuilder.append(d);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(b);
    paramParcel.writeParcelable(c, paramInt);
    paramParcel.writeString(d);
    paramParcel.writeLong(e);
    if (f)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(g, 0);
      paramParcel.writeInt(h);
      paramParcel.writeInt(i);
      if (!j) {
        break label280;
      }
      paramInt = 1;
      label83:
      paramParcel.writeInt(paramInt);
      if (!k) {
        break label285;
      }
      paramInt = 1;
      label97:
      paramParcel.writeInt(paramInt);
      if (!l) {
        break label290;
      }
      paramInt = 1;
      label111:
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(n, 0);
      paramParcel.writeInt(o);
      paramParcel.writeInt(p);
      if (!q) {
        break label295;
      }
      paramInt = 1;
      label150:
      paramParcel.writeInt(paramInt);
      if (!r) {
        break label300;
      }
      paramInt = 1;
      label164:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(G);
      paramParcel.writeParcelable(s, 0);
      paramParcel.writeParcelable(t, 0);
      paramParcel.writeParcelable(u, 0);
      if (!v) {
        break label305;
      }
    }
    label280:
    label285:
    label290:
    label295:
    label300:
    label305:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(w);
      paramParcel.writeInt(x);
      paramParcel.writeInt(H);
      paramParcel.writeString(y);
      paramParcel.writeString(z);
      paramParcel.writeInt(m);
      paramParcel.writeInt(A);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label83;
      paramInt = 0;
      break label97;
      paramInt = 0;
      break label111;
      paramInt = 0;
      break label150;
      paramInt = 0;
      break label164;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Conversation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */