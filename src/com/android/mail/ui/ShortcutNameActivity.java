package com.android.mail.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import buc;
import bue;
import bug;

public class ShortcutNameActivity
  extends Activity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  private EditText a;
  private String b;
  private Intent c;
  
  private final void a()
  {
    Object localObject = a.getText();
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_folder_click_intent", c);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", b);
    localObject = ((CharSequence)localObject).toString();
    if (TextUtils.getTrimmedLength((CharSequence)localObject) > 0) {
      c.putExtra("android.intent.extra.shortcut.NAME", (String)localObject);
    }
    setResult(-1, c);
    finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (buc.be == i) {
      a();
    }
    while (buc.P != i) {
      return;
    }
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.ah);
    c = ((Intent)getIntent().getParcelableExtra("extra_folder_click_intent"));
    b = getIntent().getStringExtra("extra_shortcut_name");
    a = ((EditText)findViewById(buc.bC));
    a.setText(b);
    a.setOnEditorActionListener(this);
    a.requestFocus();
    paramBundle = a.getText();
    Selection.setSelection(paramBundle, paramBundle.length());
    findViewById(buc.be).setOnClickListener(this);
    findViewById(buc.P).setOnClickListener(this);
    paramBundle = getActionBar();
    if (paramBundle != null) {
      paramBundle.setIcon(bug.a);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      a();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ShortcutNameActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */