import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
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

public abstract interface eft
  extends IInterface
{
  public abstract AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest);
  
  public abstract AccountNameCheckResponse a(AccountNameCheckRequest paramAccountNameCheckRequest);
  
  public abstract AccountRecoveryData a();
  
  public abstract AccountRecoveryData a(AccountRecoveryDataRequest paramAccountRecoveryDataRequest);
  
  public abstract AccountRecoveryGuidance a(AccountRecoveryGuidanceRequest paramAccountRecoveryGuidanceRequest);
  
  public abstract AccountRecoveryUpdateResult a(AccountRecoveryUpdateRequest paramAccountRecoveryUpdateRequest);
  
  public abstract AccountRemovalResponse a(AccountRemovalRequest paramAccountRemovalRequest);
  
  public abstract CheckFactoryResetPolicyComplianceResponse a(CheckFactoryResetPolicyComplianceRequest paramCheckFactoryResetPolicyComplianceRequest);
  
  public abstract CheckRealNameResponse a(CheckRealNameRequest paramCheckRealNameRequest);
  
  public abstract ClearTokenResponse a(ClearTokenRequest paramClearTokenRequest);
  
  public abstract GoogleAccountData a(Account paramAccount);
  
  public abstract GoogleAccountData a(String paramString);
  
  public abstract GplusInfoResponse a(GplusInfoRequest paramGplusInfoRequest);
  
  public abstract OtpResponse a(OtpRequest paramOtpRequest);
  
  public abstract PasswordCheckResponse a(PasswordCheckRequest paramPasswordCheckRequest);
  
  public abstract ReauthSettingsResponse a(ReauthSettingsRequest paramReauthSettingsRequest);
  
  public abstract TokenResponse a(AccountSignInRequest paramAccountSignInRequest);
  
  public abstract TokenResponse a(ConfirmCredentialsRequest paramConfirmCredentialsRequest);
  
  public abstract TokenResponse a(GoogleAccountSetupRequest paramGoogleAccountSetupRequest);
  
  public abstract TokenResponse a(TokenRequest paramTokenRequest);
  
  public abstract TokenResponse a(UpdateCredentialsRequest paramUpdateCredentialsRequest);
  
  public abstract ValidateAccountCredentialsResponse a(AccountCredentials paramAccountCredentials);
  
  public abstract VerifyPinResponse a(VerifyPinRequest paramVerifyPinRequest);
  
  public abstract WebSetupConfig a(WebSetupConfigRequest paramWebSetupConfigRequest);
  
  public abstract boolean a(String paramString, Bundle paramBundle);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract Bundle b(String paramString);
  
  public abstract TokenResponse b(GoogleAccountSetupRequest paramGoogleAccountSetupRequest);
  
  public abstract String b(Account paramAccount);
  
  public abstract void b();
  
  public abstract String c(String paramString);
  
  public abstract boolean c();
  
  public abstract GetAndAdvanceOtpCounterResponse d(String paramString);
}

/* Location:
 * Qualified Name:     eft
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */