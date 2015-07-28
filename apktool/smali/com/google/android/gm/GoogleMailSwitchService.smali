.class public Lcom/google/android/gm/GoogleMailSwitchService;
.super Landroid/app/IntentService;
.source "GoogleMailSwitchService.java"


# static fields
.field private static final GMAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

.field private static final GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 16
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.google.android.gm"

    const-string v2, "com.google.android.gm.widget.GmailWidgetProvider"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/GoogleMailSwitchService;->GMAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 20
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.google.android.gm"

    const-string v2, "com.google.android.gm.widget.GoogleMailWidgetProvider"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/GoogleMailSwitchService;->GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    const-string v0, "GoogleMailSwitchService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method private validateGmailWidgets()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/google/android/gm/GoogleMailSwitchService;->validateWidgetProvider()V

    .line 55
    invoke-static {p0}, Lcom/google/android/gm/Utils;->enableLabelShortcutActivity(Landroid/content/Context;)V

    .line 56
    return-void
.end method

.method private validateWidgetProvider()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 62
    invoke-virtual {p0}, Lcom/google/android/gm/GoogleMailSwitchService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 66
    .local v3, "pm":Landroid/content/pm/PackageManager;
    invoke-static {p0}, Lcom/google/android/gm/Utils;->haveGoogleMailActivitiesBeenEnabled(Landroid/content/Context;)Z

    move-result v2

    .line 68
    .local v2, "googleMailActivitiesEnabled":Z
    if-eqz v2, :cond_0

    sget-object v1, Lcom/google/android/gm/GoogleMailSwitchService;->GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 70
    .local v1, "enabledWidgetComponent":Landroid/content/ComponentName;
    :goto_0
    if-eqz v2, :cond_1

    sget-object v0, Lcom/google/android/gm/GoogleMailSwitchService;->GMAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 72
    .local v0, "disabledWidgetComponent":Landroid/content/ComponentName;
    :goto_1
    const/4 v4, 0x2

    invoke-virtual {v3, v0, v4, v5}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 75
    invoke-virtual {v3, v1, v5, v5}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 78
    return-void

    .line 68
    .end local v0    # "disabledWidgetComponent":Landroid/content/ComponentName;
    .end local v1    # "enabledWidgetComponent":Landroid/content/ComponentName;
    :cond_0
    sget-object v1, Lcom/google/android/gm/GoogleMailSwitchService;->GMAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    goto :goto_0

    .line 70
    .restart local v1    # "enabledWidgetComponent":Landroid/content/ComponentName;
    :cond_1
    sget-object v0, Lcom/google/android/gm/GoogleMailSwitchService;->GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME:Landroid/content/ComponentName;

    goto :goto_1
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 33
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "action":Ljava/lang/String;
    const-string v1, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 36
    invoke-direct {p0}, Lcom/google/android/gm/GoogleMailSwitchService;->validateGmailWidgets()V

    .line 48
    :cond_0
    :goto_0
    return-void

    .line 37
    :cond_1
    const-string v1, "android.intent.action.MY_PACKAGE_REPLACED"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 43
    invoke-static {p0}, Lcom/google/android/gm/GoogleMailDeviceStartupReceiver;->enableReceiver(Landroid/content/Context;)V

    .line 46
    invoke-direct {p0}, Lcom/google/android/gm/GoogleMailSwitchService;->validateGmailWidgets()V

    goto :goto_0
.end method
