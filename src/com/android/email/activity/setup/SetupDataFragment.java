package com.android.email.activity.setup;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awo;
import bam;
import ban;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Policy;

public class SetupDataFragment
  extends Fragment
  implements Parcelable
{
  public static final Parcelable.Creator<SetupDataFragment> CREATOR = new awo();
  public int a = 0;
  public Account b;
  public String c;
  public Bundle d;
  public boolean e = true;
  public boolean f = true;
  public volatile Policy g;
  public String h;
  public String i;
  private ban j;
  
  public SetupDataFragment()
  {
    a(new Account());
  }
  
  public final ban a(Context paramContext)
  {
    if (j == null) {
      j = bam.e(paramContext, b(paramContext));
    }
    return j;
  }
  
  public final Policy a()
  {
    try
    {
      Policy localPolicy = g;
      return localPolicy;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(Context paramContext, String paramString)
  {
    paramContext = b.d(paramContext);
    paramContext.a(paramString, c, d, e);
    h = paramString;
    j = null;
  }
  
  public final void a(Account paramAccount)
  {
    b = paramAccount;
    b.x = true;
  }
  
  public final void a(Policy paramPolicy)
  {
    try
    {
      g = paramPolicy;
      return;
    }
    finally
    {
      paramPolicy = finally;
      throw paramPolicy;
    }
  }
  
  public final void a(String paramString)
  {
    c = paramString;
    b.d = paramString;
    e = false;
    f = false;
  }
  
  public final String b(Context paramContext)
  {
    if (h != null) {
      return h;
    }
    return b.d(paramContext).b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      a = paramBundle.getInt("SetupDataFragment.flowMode");
      a((Account)paramBundle.getParcelable("SetupDataFragment.account"));
      c = paramBundle.getString("SetupDataFragment.email");
      d = ((Bundle)paramBundle.getParcelable("SetupDataFragment.credential"));
      e = paramBundle.getBoolean("SetupDataFragment.incomingLoaded");
      f = paramBundle.getBoolean("SetupDataFragment.outgoingLoaded");
      g = ((Policy)paramBundle.getParcelable("SetupDataFragment.policy"));
      h = paramBundle.getString("SetupDataFragment.incomingProtocol");
      i = paramBundle.getString("SetupDataFragment.amProtocol");
    }
    setRetainInstance(true);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("SetupDataFragment.flowMode", a);
    paramBundle.putParcelable("SetupDataFragment.account", b);
    paramBundle.putString("SetupDataFragment.email", c);
    paramBundle.putParcelable("SetupDataFragment.credential", d);
    paramBundle.putBoolean("SetupDataFragment.incomingLoaded", e);
    paramBundle.putBoolean("SetupDataFragment.outgoingLoaded", f);
    paramBundle.putParcelable("SetupDataFragment.policy", g);
    paramBundle.putString("SetupDataFragment.incomingProtocol", h);
    paramBundle.putString("SetupDataFragment.amProtocol", i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SetupData");
    localStringBuilder.append(":acct=");
    if (b == null)
    {
      localObject = "none";
      localStringBuilder.append(localObject);
      if (c != null)
      {
        localStringBuilder.append(":user=");
        localStringBuilder.append(c);
      }
      if (d != null)
      {
        localStringBuilder.append(":cred=");
        localStringBuilder.append(d.toString());
      }
      localStringBuilder.append(":policy=");
      if (g != null) {
        break label124;
      }
    }
    label124:
    for (Object localObject = "none";; localObject = "exists")
    {
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
      localObject = Long.valueOf(b.D);
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeParcelable(b, 0);
    paramParcel.writeString(c);
    paramParcel.writeParcelable(d, 0);
    paramParcel.writeBooleanArray(new boolean[] { e, f });
    paramParcel.writeParcelable(g, 0);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.SetupDataFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */