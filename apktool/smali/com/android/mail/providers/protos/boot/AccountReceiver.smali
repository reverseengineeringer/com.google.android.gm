.class public Lcom/android/mail/providers/protos/boot/AccountReceiver;
.super Landroid/content/BroadcastReceiver;
.source "AccountReceiver.java"


# static fields
.field private static final GMAIL_ACCOUNTS_URI:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-string v0, "content://com.android.gmail.ui/accounts"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/protos/boot/AccountReceiver;->GMAIL_ACCOUNTS_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 27
    sget-object v0, Lcom/android/mail/providers/protos/boot/AccountReceiver;->GMAIL_ACCOUNTS_URI:Landroid/net/Uri;

    invoke-static {v0}, Lcom/android/mail/providers/MailAppProvider;->addAccountsForUriAsync(Landroid/net/Uri;)V

    .line 28
    return-void
.end method
