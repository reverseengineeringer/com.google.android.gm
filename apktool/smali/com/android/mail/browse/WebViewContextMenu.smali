.class public Lcom/android/mail/browse/WebViewContextMenu;
.super Ljava/lang/Object;
.source "WebViewContextMenu.java"

# interfaces
.implements Landroid/view/MenuItem$OnMenuItemClickListener;
.implements Landroid/view/View$OnCreateContextMenuListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/WebViewContextMenu$1;,
        Lcom/android/mail/browse/WebViewContextMenu$Share;,
        Lcom/android/mail/browse/WebViewContextMenu$Copy;,
        Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;,
        Lcom/android/mail/browse/WebViewContextMenu$MenuType;
    }
.end annotation


# instance fields
.field private mActivity:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0
    .param p1, "host"    # Landroid/app/Activity;

    .prologue
    .line 81
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 82
    iput-object p1, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    .line 83
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/CharSequence;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/WebViewContextMenu;
    .param p1, "x1"    # Ljava/lang/CharSequence;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/android/mail/browse/WebViewContextMenu;->copy(Ljava/lang/CharSequence;)V

    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/WebViewContextMenu;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/android/mail/browse/WebViewContextMenu;->shareLink(Ljava/lang/String;)V

    return-void
.end method

.method private copy(Ljava/lang/CharSequence;)V
    .locals 3
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 137
    iget-object v1, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    const-string v2, "clipboard"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 139
    .local v0, "clipboard":Landroid/content/ClipboardManager;
    const/4 v1, 0x0

    invoke-static {v1, p1}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 140
    return-void
.end method

.method private shareLink(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 124
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 125
    .local v0, "send":Landroid/content/Intent;
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 126
    const-string v1, "android.intent.extra.TEXT"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 129
    :try_start_0
    iget-object v1, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    sget-object v3, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    invoke-virtual {p0, v3}, Lcom/android/mail/browse/WebViewContextMenu;->getChooserTitleStringResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :goto_0
    return-void

    .line 131
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private showShareLinkMenuItem()Z
    .locals 4

    .prologue
    .line 116
    iget-object v3, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 117
    .local v0, "pm":Landroid/content/pm/PackageManager;
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.SEND"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 118
    .local v2, "send":Landroid/content/Intent;
    const-string v3, "text/plain"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 119
    const/high16 v3, 0x10000

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v1

    .line 120
    .local v1, "ri":Landroid/content/pm/ResolveInfo;
    if-eqz v1, :cond_0

    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected getChooserTitleStringResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I
    .locals 2
    .param p1, "menuType"    # Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .prologue
    .line 370
    sget-object v0, Lcom/android/mail/browse/WebViewContextMenu$1;->$SwitchMap$com$android$mail$browse$WebViewContextMenu$MenuType:[I

    invoke-virtual {p1}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 374
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected MenuType"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 372
    :pswitch_0
    const v0, 0x7f0c0088

    return v0

    .line 370
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method protected getMenuGroupResId(Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;)I
    .locals 2
    .param p1, "menuGroupType"    # Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;

    .prologue
    .line 384
    sget-object v0, Lcom/android/mail/browse/WebViewContextMenu$1;->$SwitchMap$com$android$mail$browse$WebViewContextMenu$MenuGroupType:[I

    invoke-virtual {p1}, Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 394
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected MenuGroupType"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 386
    :pswitch_0
    const v0, 0x7f100141

    .line 392
    :goto_0
    return v0

    .line 388
    :pswitch_1
    const v0, 0x7f100146

    goto :goto_0

    .line 390
    :pswitch_2
    const v0, 0x7f100149

    goto :goto_0

    .line 392
    :pswitch_3
    const v0, 0x7f10014c

    goto :goto_0

    .line 384
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I
    .locals 2
    .param p1, "menuType"    # Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .prologue
    .line 336
    sget-object v0, Lcom/android/mail/browse/WebViewContextMenu$1;->$SwitchMap$com$android$mail$browse$WebViewContextMenu$MenuType:[I

    invoke-virtual {p1}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 360
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected MenuType"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 338
    :pswitch_0
    const v0, 0x7f10014d

    .line 358
    :goto_0
    return v0

    .line 340
    :pswitch_1
    const v0, 0x7f10014e

    goto :goto_0

    .line 342
    :pswitch_2
    const v0, 0x7f10014f

    goto :goto_0

    .line 344
    :pswitch_3
    const v0, 0x7f100142

    goto :goto_0

    .line 346
    :pswitch_4
    const v0, 0x7f100143

    goto :goto_0

    .line 348
    :pswitch_5
    const v0, 0x7f100144

    goto :goto_0

    .line 350
    :pswitch_6
    const v0, 0x7f100145

    goto :goto_0

    .line 352
    :pswitch_7
    const v0, 0x7f100147

    goto :goto_0

    .line 354
    :pswitch_8
    const v0, 0x7f100148

    goto :goto_0

    .line 356
    :pswitch_9
    const v0, 0x7f10014a

    goto :goto_0

    .line 358
    :pswitch_a
    const v0, 0x7f10014b

    goto :goto_0

    .line 336
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch
.end method

.method protected getMenuResourceId()I
    .locals 1

    .prologue
    .line 402
    const v0, 0x7f120010

    return v0
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .locals 24
    .param p1, "menu"    # Landroid/view/ContextMenu;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "info"    # Landroid/view/ContextMenu$ContextMenuInfo;

    .prologue
    .line 147
    move-object/from16 v18, p2

    check-cast v18, Landroid/webkit/WebView;

    .line 148
    .local v18, "webview":Landroid/webkit/WebView;
    invoke-virtual/range {v18 .. v18}, Landroid/webkit/WebView;->getHitTestResult()Landroid/webkit/WebView$HitTestResult;

    move-result-object v14

    .line 149
    .local v14, "result":Landroid/webkit/WebView$HitTestResult;
    if-nez v14, :cond_0

    .line 289
    :goto_0
    :sswitch_0
    return-void

    .line 153
    :cond_0
    invoke-virtual {v14}, Landroid/webkit/WebView$HitTestResult;->getType()I

    move-result v16

    .line 154
    .local v16, "type":I
    sparse-switch v16, :sswitch_data_0

    .line 165
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/app/Activity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v11

    .line 168
    .local v11, "inflater":Landroid/view/MenuInflater;
    invoke-virtual/range {p0 .. p0}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResourceId()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p1

    invoke-virtual {v11, v0, v1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 172
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    invoke-interface/range {p1 .. p1}, Landroid/view/ContextMenu;->size()I

    move-result v19

    move/from16 v0, v19

    if-ge v9, v0, :cond_1

    .line 173
    move-object/from16 v0, p1

    invoke-interface {v0, v9}, Landroid/view/ContextMenu;->getItem(I)Landroid/view/MenuItem;

    move-result-object v12

    .line 174
    .local v12, "menuItem":Landroid/view/MenuItem;
    move-object/from16 v0, p0

    invoke-interface {v12, v0}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 172
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 179
    .end local v12    # "menuItem":Landroid/view/MenuItem;
    :cond_1
    invoke-virtual {v14}, Landroid/webkit/WebView$HitTestResult;->getExtra()Ljava/lang/String;

    move-result-object v7

    .line 180
    .local v7, "extra":Ljava/lang/String;
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;->PHONE_GROUP:Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuGroupResId(Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;)I

    move-result v20

    const/16 v19, 0x2

    move/from16 v0, v16

    move/from16 v1, v19

    if-ne v0, v1, :cond_3

    const/16 v19, 0x1

    :goto_2
    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v19

    invoke-interface {v0, v1, v2}, Landroid/view/ContextMenu;->setGroupVisible(IZ)V

    .line 182
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;->EMAIL_GROUP:Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuGroupResId(Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;)I

    move-result v20

    const/16 v19, 0x4

    move/from16 v0, v16

    move/from16 v1, v19

    if-ne v0, v1, :cond_4

    const/16 v19, 0x1

    :goto_3
    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v19

    invoke-interface {v0, v1, v2}, Landroid/view/ContextMenu;->setGroupVisible(IZ)V

    .line 184
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;->GEO_GROUP:Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuGroupResId(Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;)I

    move-result v20

    const/16 v19, 0x3

    move/from16 v0, v16

    move/from16 v1, v19

    if-ne v0, v1, :cond_5

    const/16 v19, 0x1

    :goto_4
    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v19

    invoke-interface {v0, v1, v2}, Landroid/view/ContextMenu;->setGroupVisible(IZ)V

    .line 186
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;->ANCHOR_GROUP:Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuGroupResId(Lcom/android/mail/browse/WebViewContextMenu$MenuGroupType;)I

    move-result v20

    const/16 v19, 0x7

    move/from16 v0, v16

    move/from16 v1, v19

    if-eq v0, v1, :cond_2

    const/16 v19, 0x8

    move/from16 v0, v16

    move/from16 v1, v19

    if-ne v0, v1, :cond_6

    :cond_2
    const/16 v19, 0x1

    :goto_5
    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v19

    invoke-interface {v0, v1, v2}, Landroid/view/ContextMenu;->setGroupVisible(IZ)V

    .line 191
    packed-switch v16, :pswitch_data_0

    :pswitch_0
    goto/16 :goto_0

    .line 195
    :pswitch_1
    :try_start_0
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/nio/charset/Charset;->name()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-static {v7, v0}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 202
    .local v5, "decodedPhoneExtra":Ljava/lang/String;
    :goto_6
    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Landroid/view/ContextMenu;->setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/ContextMenu;

    .line 204
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->DIAL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v6

    .line 207
    .local v6, "dialMenuItem":Landroid/view/MenuItem;
    const/16 v19, 0x0

    move-object/from16 v0, v19

    invoke-interface {v6, v0}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 208
    new-instance v19, Landroid/content/Intent;

    const-string v20, "android.intent.action.VIEW"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "tel:"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v21

    invoke-direct/range {v19 .. v21}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    move-object/from16 v0, v19

    invoke-interface {v6, v0}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 212
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SMS_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v15

    .line 215
    .local v15, "sendSmsMenuItem":Landroid/view/MenuItem;
    const/16 v19, 0x0

    move-object/from16 v0, v19

    invoke-interface {v15, v0}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 216
    new-instance v19, Landroid/content/Intent;

    const-string v20, "android.intent.action.SENDTO"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "smsto:"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v21

    invoke-direct/range {v19 .. v21}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    move-object/from16 v0, v19

    invoke-interface {v15, v0}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 220
    new-instance v3, Landroid/content/Intent;

    const-string v19, "android.intent.action.INSERT_OR_EDIT"

    move-object/from16 v0, v19

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 221
    .local v3, "addIntent":Landroid/content/Intent;
    const-string v19, "vnd.android.cursor.item/contact"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 223
    const-string v19, "phone"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->ADD_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v4

    .line 227
    .local v4, "addToContactsMenuItem":Landroid/view/MenuItem;
    const/16 v19, 0x0

    move-object/from16 v0, v19

    invoke-interface {v4, v0}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 228
    invoke-interface {v4, v3}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 231
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_PHONE_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Lcom/android/mail/browse/WebViewContextMenu$Copy;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$Copy;-><init>(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/CharSequence;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 180
    .end local v3    # "addIntent":Landroid/content/Intent;
    .end local v4    # "addToContactsMenuItem":Landroid/view/MenuItem;
    .end local v5    # "decodedPhoneExtra":Ljava/lang/String;
    .end local v6    # "dialMenuItem":Landroid/view/MenuItem;
    .end local v15    # "sendSmsMenuItem":Landroid/view/MenuItem;
    :cond_3
    const/16 v19, 0x0

    goto/16 :goto_2

    .line 182
    :cond_4
    const/16 v19, 0x0

    goto/16 :goto_3

    .line 184
    :cond_5
    const/16 v19, 0x0

    goto/16 :goto_4

    .line 186
    :cond_6
    const/16 v19, 0x0

    goto/16 :goto_5

    .line 197
    :catch_0
    move-exception v10

    .line 199
    .local v10, "ignore":Ljava/io/UnsupportedEncodingException;
    move-object v5, v7

    .restart local v5    # "decodedPhoneExtra":Ljava/lang/String;
    goto/16 :goto_6

    .line 236
    .end local v5    # "decodedPhoneExtra":Ljava/lang/String;
    .end local v10    # "ignore":Ljava/io/UnsupportedEncodingException;
    :pswitch_2
    move-object/from16 v0, p1

    invoke-interface {v0, v7}, Landroid/view/ContextMenu;->setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/ContextMenu;

    .line 237
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->EMAIL_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Landroid/content/Intent;

    const-string v21, "android.intent.action.VIEW"

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "mailto:"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v22

    invoke-direct/range {v20 .. v22}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 240
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_MAIL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Lcom/android/mail/browse/WebViewContextMenu$Copy;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$Copy;-><init>(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/CharSequence;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 245
    :pswitch_3
    move-object/from16 v0, p1

    invoke-interface {v0, v7}, Landroid/view/ContextMenu;->setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/ContextMenu;

    .line 246
    const-string v8, ""

    .line 248
    .local v8, "geoExtra":Ljava/lang/String;
    :try_start_1
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/nio/charset/Charset;->name()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-static {v7, v0}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v8

    .line 253
    :goto_7
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->MAP_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v17

    .line 256
    .local v17, "viewMapMenuItem":Landroid/view/MenuItem;
    const/16 v19, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 257
    new-instance v19, Landroid/content/Intent;

    const-string v20, "android.intent.action.VIEW"

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "geo:0,0?q="

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v21

    invoke-direct/range {v19 .. v21}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 259
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_GEO_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Lcom/android/mail/browse/WebViewContextMenu$Copy;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$Copy;-><init>(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/CharSequence;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 265
    .end local v8    # "geoExtra":Ljava/lang/String;
    .end local v17    # "viewMapMenuItem":Landroid/view/MenuItem;
    :pswitch_4
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    invoke-direct/range {p0 .. p0}, Lcom/android/mail/browse/WebViewContextMenu;->showShareLinkMenuItem()Z

    move-result v20

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 272
    move-object/from16 v0, p1

    invoke-interface {v0, v7}, Landroid/view/ContextMenu;->setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/ContextMenu;

    .line 274
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Lcom/android/mail/browse/WebViewContextMenu$Copy;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$Copy;-><init>(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/CharSequence;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 277
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->OPEN_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v13

    .line 280
    .local v13, "openLinkMenuItem":Landroid/view/MenuItem;
    const/16 v19, 0x0

    move-object/from16 v0, v19

    invoke-interface {v13, v0}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 281
    new-instance v19, Landroid/content/Intent;

    const-string v20, "android.intent.action.VIEW"

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v21

    invoke-direct/range {v19 .. v21}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    move-object/from16 v0, v19

    invoke-interface {v13, v0}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 283
    sget-object v19, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/WebViewContextMenu;->getMenuResIdForMenuType(Lcom/android/mail/browse/WebViewContextMenu$MenuType;)I

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/view/ContextMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v19

    new-instance v20, Lcom/android/mail/browse/WebViewContextMenu$Share;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$Share;-><init>(Lcom/android/mail/browse/WebViewContextMenu;Ljava/lang/String;)V

    invoke-interface/range {v19 .. v20}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 250
    .end local v13    # "openLinkMenuItem":Landroid/view/MenuItem;
    .restart local v8    # "geoExtra":Ljava/lang/String;
    :catch_1
    move-exception v19

    goto/16 :goto_7

    .line 154
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x9 -> :sswitch_0
    .end sparse-switch

    .line 191
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_4
    .end packed-switch
.end method

.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 293
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/WebViewContextMenu;->onMenuItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method protected onMenuItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "menuItem"    # Landroid/view/MenuItem;

    .prologue
    .line 410
    iget-object v0, p0, Lcom/android/mail/browse/WebViewContextMenu;->mActivity:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
