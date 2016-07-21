import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public final class cxe
{
  public static SpannableStringBuilder a(TextView paramTextView, int paramInt, View.OnClickListener paramOnClickListener, CharSequence... paramVarArgs)
  {
    String str = paramTextView.getContext().getString(paramInt);
    paramVarArgs = (CharSequence[])Arrays.copyOf(paramVarArgs, paramVarArgs.length + 1);
    paramVarArgs[(paramVarArgs.length - 1)] = paramTextView.getContext().getString(buj.cP);
    return a(paramTextView, paramOnClickListener, str, paramVarArgs);
  }
  
  public static SpannableStringBuilder a(TextView paramTextView, View.OnClickListener paramOnClickListener, String paramString, CharSequence... paramVarArgs)
  {
    Context localContext = paramTextView.getContext();
    SpannableString localSpannableString = new SpannableString(paramVarArgs[(paramVarArgs.length - 1)]);
    localSpannableString.setSpan(new chp(paramOnClickListener), 0, localSpannableString.length(), 33);
    paramVarArgs[(paramVarArgs.length - 1)] = localSpannableString;
    paramString = (SpannableStringBuilder)TextUtils.expandTemplate(paramString, paramVarArgs);
    paramTextView.setText(paramString);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    if (((AccessibilityManager)localContext.getSystemService("accessibility")).isEnabled()) {
      paramTextView.setOnClickListener(paramOnClickListener);
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if ((cxd.d()) && (paramActivity != null))
    {
      Window localWindow = paramActivity.getWindow();
      if (localWindow != null) {
        localWindow.setStatusBarColor(paramActivity.getResources().getColor(paramInt));
      }
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    Object localObject = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    ViewParent localViewParent = paramView.getParent();
    if ((((AccessibilityManager)localObject).isEnabled()) && (localViewParent != null))
    {
      localObject = AccessibilityEvent.obtain(16384);
      paramView.onInitializeAccessibilityEvent((AccessibilityEvent)localObject);
      ((AccessibilityEvent)localObject).getText().add(paramCharSequence);
      ((AccessibilityEvent)localObject).setContentDescription(null);
      localViewParent.requestSendAccessibilityEvent(paramView, (AccessibilityEvent)localObject);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  public static boolean a(View paramView)
  {
    return rg.g(paramView) == 1;
  }
  
  public static void b(View paramView)
  {
    if (cxd.b()) {
      paramView.setTextAlignment(5);
    }
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.isHardwareAccelerated()) && (paramView.getLayerType() != 2))
    {
      paramView.setLayerType(2, null);
      paramView.buildLayer();
    }
  }
  
  public static void d(View paramView)
  {
    if ((paramView != null) && (paramView.getLayerType() != 0)) {
      paramView.setLayerType(0, null);
    }
  }
}

/* Location:
 * Qualified Name:     cxe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */