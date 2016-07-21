import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.people.identity.internal.AccountToken;
import com.google.android.gms.people.identity.internal.ParcelableGetOptions;
import com.google.android.gms.people.identity.internal.ParcelableListOptions;
import com.google.android.gms.people.internal.ParcelableLoadImageOptions;
import com.google.android.gms.people.model.AvatarReference;
import java.util.ArrayList;
import java.util.List;

public abstract class fwx
  extends Binder
  implements fww
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject1;
    boolean bool1;
    boolean bool2;
    label559:
    label634:
    Object localObject3;
    Object localObject4;
    Object localObject5;
    long l;
    label1054:
    int i;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.people.internal.IPeopleService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label559;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((fwt)localObject1, bool1, bool2, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 305: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label634;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((fwt)localObject1, bool1, bool2, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.createStringArrayList();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (List)localObject5, paramInt1, bool1, paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, l, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 603: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        b((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = a(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label1054;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        paramParcel2.writeInt(0);
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 201: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool1, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 202: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, paramInt1, bool1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 203: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        localObject5 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          break label1410;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, paramInt1, bool1, paramInt2, i, (String)localObject5, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 402: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        localObject5 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          break label1535;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, paramInt1, bool1, paramInt2, i, (String)localObject5, bool2, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, bool1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        return true;
      }
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramParcel1 = a((fwt)localObject1, bool1, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label1671;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        bool1 = false;
        break;
        paramParcel2.writeInt(0);
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.createStringArrayList());
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a(bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      bool1 = a();
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = b(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject2 = fwu.a(paramParcel1.readStrongBinder());
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label2040;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject2, (String)localObject3, (String)localObject4, (Uri)localObject1, bool1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject5 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, paramInt1, (String)localObject5, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.createStringArrayList();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (List)localObject5, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 401: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.createStringArrayList();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (List)localObject5, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 404: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.createStringArrayList();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (List)localObject5, paramInt1, bool1, paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.createStringArrayList();
      ArrayList localArrayList = paramParcel1.createStringArrayList();
      if (paramParcel1.readInt() != 0) {
        eon localeon = FavaDiagnosticsEntity.CREATOR;
      }
      for (paramParcel1 = eon.a(paramParcel1);; paramParcel1 = null)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (List)localObject5, localArrayList, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 403: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramParcel1 = a((String)localObject1, (String)localObject2, l, bool1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label2778;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        bool1 = false;
        break;
        paramParcel2.writeInt(0);
      }
    case 205: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label2872;
        }
        bool2 = true;
        paramParcel1 = a((String)localObject1, (String)localObject2, l, bool1, bool2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label2878;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label2830;
        paramParcel2.writeInt(0);
      }
    case 101: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 102: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      c(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 701: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((fwt)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList());
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 204: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 301: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 302: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((fwt)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 303: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 304: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b((fwt)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 501: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject2 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountToken.CREATOR;
        localObject1 = fwh.a(paramParcel1);
        localObject3 = paramParcel1.createStringArrayList();
        if (paramParcel1.readInt() == 0) {
          break label3444;
        }
        localObject4 = ParcelableGetOptions.CREATOR;
      }
      for (paramParcel1 = fwn.a(paramParcel1);; paramParcel1 = null)
      {
        a((fwt)localObject2, (AccountToken)localObject1, (List)localObject3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 502: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 503: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        paramParcel1 = b((fwt)localObject1, l, bool1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label3576;
        }
      }
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        bool1 = false;
        break;
      }
    case 504: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 505: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = b(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 506: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = c(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 507: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject1 = fwu.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        localObject4 = paramParcel1.readString();
        localObject5 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label3876;
        }
        bool2 = true;
        paramParcel1 = a((fwt)localObject1, (String)localObject2, (String)localObject3, bool1, (String)localObject4, (String)localObject5, paramInt1, paramInt2, i, bool2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label3882;
        }
      }
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label3824;
      }
    case 508: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject2 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AvatarReference.CREATOR;
        localObject1 = fyd.a(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label3975;
        }
        localObject3 = ParcelableLoadImageOptions.CREATOR;
        paramParcel1 = fxa.a(paramParcel1);
        paramParcel1 = a((fwt)localObject2, (AvatarReference)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label3980;
        }
      }
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        localObject1 = null;
        break;
        paramParcel1 = null;
        break label3937;
      }
    case 509: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      paramParcel1 = a(fwu.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 601: 
      label1410:
      label1535:
      label1671:
      label2040:
      label2778:
      label2830:
      label2872:
      label2878:
      label3444:
      label3576:
      label3824:
      label3876:
      label3882:
      label3937:
      label3975:
      label3980:
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
      localObject2 = fwu.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountToken.CREATOR;
        localObject1 = fwh.a(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label4126;
        }
        localObject3 = ParcelableListOptions.CREATOR;
        paramParcel1 = fwo.a(paramParcel1);
        label4088:
        paramParcel1 = a((fwt)localObject2, (AccountToken)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label4131;
        }
      }
      label4126:
      label4131:
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        localObject1 = null;
        break;
        paramParcel1 = null;
        break label4088;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
    Object localObject2 = fwu.a(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0)
    {
      localObject1 = DataHolder.CREATOR;
      localObject1 = elm.a(paramParcel1);
      paramParcel1 = a((fwt)localObject2, (DataHolder)localObject1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break label4218;
      }
    }
    label4218:
    for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
    {
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
      localObject1 = null;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     fwx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */