import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
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
import com.google.android.gms.auth.firstparty.dataservice.GetAndAdvanceOtpCounterResponse;
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

public abstract class efu
  extends Binder
  implements eft
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject1 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    Object localObject20 = null;
    Object localObject21 = null;
    Object localObject22 = null;
    Object localObject23 = null;
    Object localObject24 = null;
    String str = null;
    int j = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = str;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountNameCheckRequest.CREATOR;
        localObject1 = edz.a(paramParcel1);
      }
      paramParcel1 = a((AccountNameCheckRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = PasswordCheckRequest.CREATOR;
        localObject1 = efd.a(paramParcel1);
      }
      paramParcel1 = a((PasswordCheckRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = CheckRealNameRequest.CREATOR;
        localObject1 = eem.a(paramParcel1);
      }
      paramParcel1 = a((CheckRealNameRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GoogleAccountSetupRequest.CREATOR;
        localObject1 = eey.a(paramParcel1);
      }
      paramParcel1 = a((GoogleAccountSetupRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GplusInfoRequest.CREATOR;
        localObject1 = eez.a(paramParcel1);
      }
      paramParcel1 = a((GplusInfoRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GoogleAccountSetupRequest.CREATOR;
        localObject1 = eey.a(paramParcel1);
      }
      paramParcel1 = b((GoogleAccountSetupRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = TokenRequest.CREATOR;
        localObject1 = efl.a(paramParcel1);
      }
      paramParcel1 = a((TokenRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountSignInRequest.CREATOR;
        localObject1 = eej.a(paramParcel1);
      }
      paramParcel1 = a((AccountSignInRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ConfirmCredentialsRequest.CREATOR;
        localObject1 = eeq.a(paramParcel1);
      }
      paramParcel1 = a((ConfirmCredentialsRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = UpdateCredentialsRequest.CREATOR;
        localObject1 = efn.a(paramParcel1);
      }
      paramParcel1 = a((UpdateCredentialsRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountRecoveryDataRequest.CREATOR;
        localObject1 = eec.a(paramParcel1);
      }
      paramParcel1 = a((AccountRecoveryDataRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountRecoveryUpdateRequest.CREATOR;
        localObject1 = eef.a(paramParcel1);
      }
      paramParcel1 = a((AccountRecoveryUpdateRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject13;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountRecoveryGuidanceRequest.CREATOR;
        localObject1 = eee.a(paramParcel1);
      }
      paramParcel1 = a((AccountRecoveryGuidanceRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      bool = a(str, (Bundle)localObject1);
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject14;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = WebSetupConfigRequest.CREATOR;
        localObject1 = efs.a(paramParcel1);
      }
      paramParcel1 = a((WebSetupConfigRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject15;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ClearTokenRequest.CREATOR;
        localObject1 = eeo.a(paramParcel1);
      }
      paramParcel1 = a((ClearTokenRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject16;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountRemovalRequest.CREATOR;
        localObject1 = eeh.a(paramParcel1);
      }
      paramParcel1 = a((AccountRemovalRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject17;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ReauthSettingsRequest.CREATOR;
        localObject1 = efi.a(paramParcel1);
      }
      paramParcel1 = a((ReauthSettingsRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject18;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = VerifyPinRequest.CREATOR;
        localObject1 = efp.a(paramParcel1);
      }
      paramParcel1 = a((VerifyPinRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject19;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AccountChangeEventsRequest)AccountChangeEventsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((AccountChangeEventsRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject20;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = OtpRequest.CREATOR;
        localObject1 = efb.a(paramParcel1);
      }
      paramParcel1 = a((OtpRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      paramParcel1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject21;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = CheckFactoryResetPolicyComplianceRequest.CREATOR;
        localObject1 = eek.a(paramParcel1);
      }
      paramParcel1 = a((CheckFactoryResetPolicyComplianceRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      b();
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject22;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((Account)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject23;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = b((Account)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      bool = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      bool = c();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
      localObject1 = localObject24;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = AccountCredentials.CREATOR;
        localObject1 = ege.a(paramParcel1);
      }
      paramParcel1 = a((AccountCredentials)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
    paramParcel1 = d(paramParcel1.readString());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}

/* Location:
 * Qualified Name:     efu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */