import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckRequest;
import com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckResponse;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryData;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryDataRequest;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryGuidance;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryGuidanceRequest;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryUpdateRequest;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryUpdateResult;
import com.google.android.gms.auth.firstparty.dataservice.AccountRemovalRequest;
import com.google.android.gms.auth.firstparty.dataservice.AccountRemovalResponse;
import com.google.android.gms.auth.firstparty.dataservice.AccountSignInRequest;
import com.google.android.gms.auth.firstparty.dataservice.CheckFactoryResetPolicyComplianceRequest;
import com.google.android.gms.auth.firstparty.dataservice.CheckFactoryResetPolicyComplianceResponse;
import com.google.android.gms.auth.firstparty.dataservice.CheckRealNameRequest;
import com.google.android.gms.auth.firstparty.dataservice.CheckRealNameResponse;
import com.google.android.gms.auth.firstparty.dataservice.ClearTokenRequest;
import com.google.android.gms.auth.firstparty.dataservice.ClearTokenResponse;
import com.google.android.gms.auth.firstparty.dataservice.ConfirmCredentialsRequest;
import com.google.android.gms.auth.firstparty.dataservice.GoogleAccountData;
import com.google.android.gms.auth.firstparty.dataservice.GoogleAccountSetupRequest;
import com.google.android.gms.auth.firstparty.dataservice.GplusInfoRequest;
import com.google.android.gms.auth.firstparty.dataservice.GplusInfoResponse;
import com.google.android.gms.auth.firstparty.dataservice.OtpRequest;
import com.google.android.gms.auth.firstparty.dataservice.OtpResponse;
import com.google.android.gms.auth.firstparty.dataservice.PasswordCheckRequest;
import com.google.android.gms.auth.firstparty.dataservice.PasswordCheckResponse;
import com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsRequest;
import com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsResponse;
import com.google.android.gms.auth.firstparty.dataservice.TokenRequest;
import com.google.android.gms.auth.firstparty.dataservice.TokenResponse;
import com.google.android.gms.auth.firstparty.dataservice.UpdateCredentialsRequest;
import com.google.android.gms.auth.firstparty.dataservice.ValidateAccountCredentialsResponse;
import com.google.android.gms.auth.firstparty.dataservice.VerifyPinRequest;
import com.google.android.gms.auth.firstparty.dataservice.VerifyPinResponse;
import com.google.android.gms.auth.firstparty.dataservice.WebSetupConfig;
import com.google.android.gms.auth.firstparty.dataservice.WebSetupConfigRequest;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;

final class efv
  implements eft
{
  private IBinder a;
  
  efv(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountChangeEventsRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountChangeEventsRequest.writeToParcel(localParcel1, 0);
          a.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountChangeEventsRequest = (AccountChangeEventsResponse)AccountChangeEventsResponse.CREATOR.createFromParcel(localParcel2);
            return paramAccountChangeEventsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountChangeEventsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final AccountNameCheckResponse a(AccountNameCheckRequest paramAccountNameCheckRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountNameCheckRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountNameCheckRequest.writeToParcel(localParcel1, 0);
          a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountNameCheckRequest = AccountNameCheckResponse.CREATOR;
            paramAccountNameCheckRequest = eea.a(localParcel2);
            return paramAccountNameCheckRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountNameCheckRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final AccountRecoveryData a()
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	efv:a	Landroid/os/IBinder;
    //   18: bipush 12
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 45 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 48	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 52	android/os/Parcel:readInt	()I
    //   37: ifeq +22 -> 59
    //   40: getstatic 87	com/google/android/gms/auth/firstparty/dataservice/AccountRecoveryData:CREATOR	Leeb;
    //   43: astore_1
    //   44: aload_3
    //   45: invokestatic 92	eeb:a	(Landroid/os/Parcel;)Lcom/google/android/gms/auth/firstparty/dataservice/AccountRecoveryData;
    //   48: astore_1
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: areturn
    //   59: aconst_null
    //   60: astore_1
    //   61: goto -12 -> 49
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 67	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 67	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	efv
    //   43	18	1	localObject1	Object
    //   64	10	1	localObject2	Object
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	49	64	finally
  }
  
  public final AccountRecoveryData a(AccountRecoveryDataRequest paramAccountRecoveryDataRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountRecoveryDataRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountRecoveryDataRequest.writeToParcel(localParcel1, 0);
          a.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountRecoveryDataRequest = AccountRecoveryData.CREATOR;
            paramAccountRecoveryDataRequest = eeb.a(localParcel2);
            return paramAccountRecoveryDataRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountRecoveryDataRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final AccountRecoveryGuidance a(AccountRecoveryGuidanceRequest paramAccountRecoveryGuidanceRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountRecoveryGuidanceRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountRecoveryGuidanceRequest.writeToParcel(localParcel1, 0);
          a.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountRecoveryGuidanceRequest = AccountRecoveryGuidance.CREATOR;
            paramAccountRecoveryGuidanceRequest = eed.a(localParcel2);
            return paramAccountRecoveryGuidanceRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountRecoveryGuidanceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final AccountRecoveryUpdateResult a(AccountRecoveryUpdateRequest paramAccountRecoveryUpdateRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountRecoveryUpdateRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountRecoveryUpdateRequest.writeToParcel(localParcel1, 0);
          a.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountRecoveryUpdateRequest = AccountRecoveryUpdateResult.CREATOR;
            paramAccountRecoveryUpdateRequest = eeg.a(localParcel2);
            return paramAccountRecoveryUpdateRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountRecoveryUpdateRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final AccountRemovalResponse a(AccountRemovalRequest paramAccountRemovalRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountRemovalRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountRemovalRequest.writeToParcel(localParcel1, 0);
          a.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountRemovalRequest = AccountRemovalResponse.CREATOR;
            paramAccountRemovalRequest = eei.a(localParcel2);
            return paramAccountRemovalRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountRemovalRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final CheckFactoryResetPolicyComplianceResponse a(CheckFactoryResetPolicyComplianceRequest paramCheckFactoryResetPolicyComplianceRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramCheckFactoryResetPolicyComplianceRequest != null)
        {
          localParcel1.writeInt(1);
          paramCheckFactoryResetPolicyComplianceRequest.writeToParcel(localParcel1, 0);
          a.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramCheckFactoryResetPolicyComplianceRequest = CheckFactoryResetPolicyComplianceResponse.CREATOR;
            paramCheckFactoryResetPolicyComplianceRequest = eel.a(localParcel2);
            return paramCheckFactoryResetPolicyComplianceRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCheckFactoryResetPolicyComplianceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final CheckRealNameResponse a(CheckRealNameRequest paramCheckRealNameRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramCheckRealNameRequest != null)
        {
          localParcel1.writeInt(1);
          paramCheckRealNameRequest.writeToParcel(localParcel1, 0);
          a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramCheckRealNameRequest = CheckRealNameResponse.CREATOR;
            paramCheckRealNameRequest = een.a(localParcel2);
            return paramCheckRealNameRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCheckRealNameRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final ClearTokenResponse a(ClearTokenRequest paramClearTokenRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramClearTokenRequest != null)
        {
          localParcel1.writeInt(1);
          paramClearTokenRequest.writeToParcel(localParcel1, 0);
          a.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramClearTokenRequest = ClearTokenResponse.CREATOR;
            paramClearTokenRequest = eep.a(localParcel2);
            return paramClearTokenRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramClearTokenRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final GoogleAccountData a(Account paramAccount)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          a.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccount = GoogleAccountData.CREATOR;
            paramAccount = ees.a(localParcel2);
            return paramAccount;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccount = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final GoogleAccountData a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 198	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	efv:a	Landroid/os/IBinder;
    //   23: iconst_1
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 45 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 48	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 52	android/os/Parcel:readInt	()I
    //   41: ifeq +22 -> 63
    //   44: getstatic 189	com/google/android/gms/auth/firstparty/dataservice/GoogleAccountData:CREATOR	Lees;
    //   47: astore_1
    //   48: aload_3
    //   49: invokestatic 194	ees:a	(Landroid/os/Parcel;)Lcom/google/android/gms/auth/firstparty/dataservice/GoogleAccountData;
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 67	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 67	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 67	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	efv
    //   0	79	1	paramString	String
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public final GplusInfoResponse a(GplusInfoRequest paramGplusInfoRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramGplusInfoRequest != null)
        {
          localParcel1.writeInt(1);
          paramGplusInfoRequest.writeToParcel(localParcel1, 0);
          a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramGplusInfoRequest = GplusInfoResponse.CREATOR;
            paramGplusInfoRequest = efa.a(localParcel2);
            return paramGplusInfoRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGplusInfoRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final OtpResponse a(OtpRequest paramOtpRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramOtpRequest != null)
        {
          localParcel1.writeInt(1);
          paramOtpRequest.writeToParcel(localParcel1, 0);
          a.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramOtpRequest = OtpResponse.CREATOR;
            paramOtpRequest = efc.a(localParcel2);
            return paramOtpRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramOtpRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final PasswordCheckResponse a(PasswordCheckRequest paramPasswordCheckRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramPasswordCheckRequest != null)
        {
          localParcel1.writeInt(1);
          paramPasswordCheckRequest.writeToParcel(localParcel1, 0);
          a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramPasswordCheckRequest = PasswordCheckResponse.CREATOR;
            paramPasswordCheckRequest = efe.a(localParcel2);
            return paramPasswordCheckRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramPasswordCheckRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final ReauthSettingsResponse a(ReauthSettingsRequest paramReauthSettingsRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramReauthSettingsRequest != null)
        {
          localParcel1.writeInt(1);
          paramReauthSettingsRequest.writeToParcel(localParcel1, 0);
          a.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramReauthSettingsRequest = ReauthSettingsResponse.CREATOR;
            paramReauthSettingsRequest = efj.a(localParcel2);
            return paramReauthSettingsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramReauthSettingsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final TokenResponse a(AccountSignInRequest paramAccountSignInRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountSignInRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountSignInRequest.writeToParcel(localParcel1, 0);
          a.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountSignInRequest = TokenResponse.CREATOR;
            paramAccountSignInRequest = efm.a(localParcel2);
            return paramAccountSignInRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountSignInRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final TokenResponse a(ConfirmCredentialsRequest paramConfirmCredentialsRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramConfirmCredentialsRequest != null)
        {
          localParcel1.writeInt(1);
          paramConfirmCredentialsRequest.writeToParcel(localParcel1, 0);
          a.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramConfirmCredentialsRequest = TokenResponse.CREATOR;
            paramConfirmCredentialsRequest = efm.a(localParcel2);
            return paramConfirmCredentialsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramConfirmCredentialsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final TokenResponse a(GoogleAccountSetupRequest paramGoogleAccountSetupRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramGoogleAccountSetupRequest != null)
        {
          localParcel1.writeInt(1);
          paramGoogleAccountSetupRequest.writeToParcel(localParcel1, 0);
          a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramGoogleAccountSetupRequest = TokenResponse.CREATOR;
            paramGoogleAccountSetupRequest = efm.a(localParcel2);
            return paramGoogleAccountSetupRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGoogleAccountSetupRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final TokenResponse a(TokenRequest paramTokenRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramTokenRequest != null)
        {
          localParcel1.writeInt(1);
          paramTokenRequest.writeToParcel(localParcel1, 0);
          a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramTokenRequest = TokenResponse.CREATOR;
            paramTokenRequest = efm.a(localParcel2);
            return paramTokenRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramTokenRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final TokenResponse a(UpdateCredentialsRequest paramUpdateCredentialsRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramUpdateCredentialsRequest != null)
        {
          localParcel1.writeInt(1);
          paramUpdateCredentialsRequest.writeToParcel(localParcel1, 0);
          a.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramUpdateCredentialsRequest = TokenResponse.CREATOR;
            paramUpdateCredentialsRequest = efm.a(localParcel2);
            return paramUpdateCredentialsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramUpdateCredentialsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final ValidateAccountCredentialsResponse a(AccountCredentials paramAccountCredentials)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramAccountCredentials != null)
        {
          localParcel1.writeInt(1);
          paramAccountCredentials.writeToParcel(localParcel1, 0);
          a.transact(36, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountCredentials = ValidateAccountCredentialsResponse.CREATOR;
            paramAccountCredentials = efo.a(localParcel2);
            return paramAccountCredentials;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountCredentials = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final VerifyPinResponse a(VerifyPinRequest paramVerifyPinRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramVerifyPinRequest != null)
        {
          localParcel1.writeInt(1);
          paramVerifyPinRequest.writeToParcel(localParcel1, 0);
          a.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramVerifyPinRequest = VerifyPinResponse.CREATOR;
            paramVerifyPinRequest = efq.a(localParcel2);
            return paramVerifyPinRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramVerifyPinRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final WebSetupConfig a(WebSetupConfigRequest paramWebSetupConfigRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramWebSetupConfigRequest != null)
        {
          localParcel1.writeInt(1);
          paramWebSetupConfigRequest.writeToParcel(localParcel1, 0);
          a.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramWebSetupConfigRequest = WebSetupConfig.CREATOR;
            paramWebSetupConfigRequest = efr.a(localParcel2);
            return paramWebSetupConfigRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramWebSetupConfigRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final boolean a(String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        localParcel1.writeString(paramString);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          a.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      a.transact(34, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
  
  /* Error */
  public final Bundle b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 198	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	efv:a	Landroid/os/IBinder;
    //   23: bipush 16
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 45 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 48	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 52	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 336	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 64 2 0
    //   54: checkcast 329	android/os/Bundle
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 67	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 67	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 67	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 67	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	efv
    //   0	84	1	paramString	String
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
  
  public final TokenResponse b(GoogleAccountSetupRequest paramGoogleAccountSetupRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
        if (paramGoogleAccountSetupRequest != null)
        {
          localParcel1.writeInt(1);
          paramGoogleAccountSetupRequest.writeToParcel(localParcel1, 0);
          a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramGoogleAccountSetupRequest = TokenResponse.CREATOR;
            paramGoogleAccountSetupRequest = efm.a(localParcel2);
            return paramGoogleAccountSetupRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGoogleAccountSetupRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final String b(Account paramAccount)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +48 -> 63
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 184	android/accounts/Account:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	efv:a	Landroid/os/IBinder;
    //   33: bipush 31
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 45 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 48	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 341	android/os/Parcel:readString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 67	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aload_2
    //   64: iconst_0
    //   65: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   68: goto -39 -> 29
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 67	android/os/Parcel:recycle	()V
    //   76: aload_2
    //   77: invokevirtual 67	android/os/Parcel:recycle	()V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	efv
    //   0	82	1	paramAccount	Account
    //   3	74	2	localParcel1	Parcel
    //   7	66	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	71	finally
    //   18	29	71	finally
    //   29	53	71	finally
    //   63	68	71	finally
  }
  
  public final void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      a.transact(29, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final String c(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localParcel1.writeString(paramString);
      a.transact(25, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean c()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      a.transact(35, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final com.google.android.gms.auth.firstparty.dataservice.GetAndAdvanceOtpCounterResponse d(String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 198	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	efv:a	Landroid/os/IBinder;
    //   23: bipush 37
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 45 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 48	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 52	android/os/Parcel:readInt	()I
    //   42: ifeq +22 -> 64
    //   45: getstatic 351	com/google/android/gms/auth/firstparty/dataservice/GetAndAdvanceOtpCounterResponse:CREATOR	Leer;
    //   48: astore_1
    //   49: aload_3
    //   50: invokestatic 356	eer:a	(Landroid/os/Parcel;)Lcom/google/android/gms/auth/firstparty/dataservice/GetAndAdvanceOtpCounterResponse;
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 67	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 67	android/os/Parcel:recycle	()V
    //   62: aload_1
    //   63: areturn
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -12 -> 54
    //   69: astore_1
    //   70: aload_3
    //   71: invokevirtual 67	android/os/Parcel:recycle	()V
    //   74: aload_2
    //   75: invokevirtual 67	android/os/Parcel:recycle	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	efv
    //   0	80	1	paramString	String
    //   3	72	2	localParcel1	Parcel
    //   7	64	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	54	69	finally
  }
}

/* Location:
 * Qualified Name:     efv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */