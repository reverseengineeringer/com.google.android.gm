import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Entity.NamedContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public final class bod
  extends ArrayList<ContentProviderOperation>
{
  private static final long serialVersionUID = 1L;
  int a = 0;
  int b = a;
  final int[] c = new int['Ȁ'];
  int d = 0;
  ContentProviderResult[] e = null;
  
  static boolean a(ContentValues paramContentValues, String paramString1, String paramString2)
  {
    if (paramContentValues.containsKey(paramString1))
    {
      if ((paramString2 == null) || (!paramContentValues.getAsString(paramString1).equals(paramString2))) {}
    }
    else {
      while ((paramString2 == null) || (paramString2.length() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private final bok c(Entity paramEntity, String paramString)
  {
    int i = b;
    if (paramEntity != null) {
      i = paramEntity.getEntityValues().getAsInteger("_id").intValue();
    }
    bok localbok = new bok(ContentProviderOperation.newInsert(bob.a(ContactsContract.Data.CONTENT_URI)));
    if (paramEntity == null) {
      a.withValueBackReference("raw_contact_id", i);
    }
    for (;;)
    {
      localbok.a("mimetype", paramString);
      return localbok;
      localbok.a("raw_contact_id", Integer.valueOf(i));
    }
  }
  
  final bok a(Entity paramEntity, String paramString)
  {
    return a(paramEntity, paramString, -1, null);
  }
  
  final bok a(Entity paramEntity, String paramString, int paramInt)
  {
    return a(paramEntity, paramString, paramInt, null);
  }
  
  public final bok a(Entity paramEntity, String paramString1, int paramInt, String paramString2)
  {
    ArrayList localArrayList;
    if (paramEntity != null)
    {
      localArrayList = paramEntity.getSubValues();
      if (paramString1 == null)
      {
        paramString2 = null;
        if (paramString2 == null) {
          break label237;
        }
      }
    }
    label206:
    label237:
    for (paramString2 = new bok(ContentProviderOperation.newUpdate(bob.a(bob.a(paramString2))), paramString2);; paramString2 = null)
    {
      Object localObject1 = paramString2;
      if (paramString2 == null) {
        localObject1 = c(paramEntity, paramString1);
      }
      return (bok)localObject1;
      Iterator localIterator = localArrayList.iterator();
      localObject1 = null;
      if (localIterator.hasNext())
      {
        Entity.NamedContentValues localNamedContentValues = (Entity.NamedContentValues)localIterator.next();
        Object localObject2 = uri;
        ContentValues localContentValues = values;
        if ((ContactsContract.Data.CONTENT_URI.equals(localObject2)) && (TextUtils.equals(localContentValues.getAsString("mimetype"), paramString1))) {
          if (paramString2 != null)
          {
            if (!localContentValues.getAsString("data1").equals(paramString2)) {
              break label206;
            }
            localObject2 = localNamedContentValues;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
          localObject2 = localNamedContentValues;
          if (paramInt >= 0)
          {
            localObject2 = localNamedContentValues;
            if (localContentValues.containsKey("data2"))
            {
              localObject2 = localNamedContentValues;
              if (localContentValues.getAsInteger("data2").intValue() != paramInt) {
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      paramString2 = (String)localObject1;
      if (localObject1 == null) {
        break;
      }
      localArrayList.remove(localObject1);
      paramString2 = (String)localObject1;
      break;
    }
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (!isEmpty()) {
        e = paramContext.getContentResolver().applyBatch("com.android.contacts", this);
      }
      return;
    }
    catch (RemoteException paramContext)
    {
      cvm.e("Exchange", paramContext, "problem inserting contact during server update", new Object[0]);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      cvm.e("Exchange", "CP2 is disabled; unable to insert contact.", new Object[0]);
      return;
    }
    catch (OperationApplicationException paramContext)
    {
      for (;;) {}
    }
  }
  
  public final void a(Entity paramEntity, int paramInt, String paramString)
  {
    paramEntity = a(paramEntity, "vnd.android.cursor.item/phone_v2", paramInt);
    ContentValues localContentValues = b;
    if ((localContentValues != null) && (a(localContentValues, "data1", paramString))) {
      return;
    }
    paramEntity.a("data2", Integer.valueOf(paramInt));
    paramEntity.a("data1", paramString);
    a(a.build());
  }
  
  public final void a(Entity paramEntity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramEntity = a(paramEntity, "vnd.android.cursor.item/postal-address_v2", paramInt);
    ContentValues localContentValues = b;
    if ((localContentValues != null) && (a(localContentValues, "data7", paramString2)) && (a(localContentValues, "data4", paramString1)) && (a(localContentValues, "data10", paramString4)) && (a(localContentValues, "data9", paramString5)) && (a(localContentValues, "data8", paramString3))) {
      return;
    }
    paramEntity.a("data2", Integer.valueOf(paramInt));
    paramEntity.a("data7", paramString2);
    paramEntity.a("data4", paramString1);
    paramEntity.a("data10", paramString4);
    paramEntity.a("data9", paramString5);
    paramEntity.a("data8", paramString3);
    a(a.build());
  }
  
  public final void a(Entity paramEntity, ArrayList<String> paramArrayList)
  {
    paramEntity = a(paramEntity, "vnd.android.cursor.item/eas_children");
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      paramEntity.a(bof.a[i], str);
      i += 1;
    }
    a(a.build());
  }
  
  public final void a(Entity paramEntity, ArrayList<bol> paramArrayList, String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = bob.f;
    Object localObject1 = bob.f;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (paramEntity != null)
    {
      localArrayList = new ArrayList();
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Entity.NamedContentValues)((Iterator)localObject2).next();
        localObject4 = uri;
        localObject5 = values;
        if ((ContactsContract.Data.CONTENT_URI.equals(localObject4)) && (TextUtils.equals(((ContentValues)localObject5).getAsString("mimetype"), paramString)) && ((paramInt1 == -1) || (paramInt1 == ((ContentValues)localObject5).getAsInteger("data2").intValue()))) {
          localArrayList.add(localObject3);
        }
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).remove((Entity.NamedContentValues)((Iterator)localObject2).next());
      }
      localObject1 = paramEntity.getSubValues();
    }
    for (;;)
    {
      localObject2 = new ArrayList();
      paramInt1 = localArrayList.size();
      paramArrayList = paramArrayList.iterator();
      label491:
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          localObject3 = (bol)paramArrayList.next();
          localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Entity.NamedContentValues)((Iterator)localObject4).next();
            ContentValues localContentValues = values;
            String str = localContentValues.getAsString("data1");
            i = -1;
            if (localContentValues.containsKey("data2")) {
              i = localContentValues.getAsInteger("data2").intValue();
            }
            if (((bol)localObject3).a(i, str))
            {
              localContentValues.put("com.android.exchange.FOUND_ROW", Boolean.valueOf(true));
              ((ArrayList)localObject1).remove(localObject5);
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label491;
          }
          if (paramInt1 < paramInt2)
          {
            localObject4 = c(paramEntity, paramString);
            ((bol)localObject3).a((bok)localObject4);
            a(a.build());
            paramInt1 += 1;
            break;
          }
          ((ArrayList)localObject2).add(localObject3);
          break;
          paramEntity = ((ArrayList)localObject2).iterator();
          while (paramEntity.hasNext())
          {
            paramArrayList = (bol)paramEntity.next();
            paramString = localArrayList.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (Entity.NamedContentValues)paramString.next();
              if (!values.containsKey("com.android.exchange.FOUND_ROW"))
              {
                localObject1 = new bok(ContentProviderOperation.newUpdate(bob.a(bob.a((Entity.NamedContentValues)localObject1))), (Entity.NamedContentValues)localObject1);
                paramArrayList.a((bok)localObject1);
                a(a.build());
              }
            }
          }
          return;
        }
      }
    }
  }
  
  public final boolean a(ContentProviderOperation paramContentProviderOperation)
  {
    super.add(paramContentProviderOperation);
    a += 1;
    return true;
  }
  
  public final void b(Entity paramEntity, int paramInt, String paramString)
  {
    paramEntity = a(paramEntity, "vnd.android.cursor.item/relation", paramInt);
    ContentValues localContentValues = b;
    if ((localContentValues != null) && (a(localContentValues, "data1", paramString))) {
      return;
    }
    paramEntity.a("data2", Integer.valueOf(paramInt));
    paramEntity.a("data1", paramString);
    a(a.build());
  }
  
  public final void b(Entity paramEntity, String paramString)
  {
    paramEntity = a(paramEntity, "vnd.android.cursor.item/note", -1);
    ContentValues localContentValues = b;
    if (paramString == null) {}
    int j;
    int i;
    do
    {
      do
      {
        return;
        paramString = paramString.replaceAll("\r\n", "\n");
      } while ((localContentValues != null) && (a(localContentValues, "data1", paramString)));
      j = paramString.length();
      i = 0;
      while ((i < j) && (Character.isWhitespace(paramString.charAt(i)))) {
        i += 1;
      }
    } while (i == j);
    paramEntity.a("data1", paramString);
    a(a.build());
  }
}

/* Location:
 * Qualified Name:     bod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */