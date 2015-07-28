.class Lcom/android/mail/ui/AbstractActivityController$4;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->onAccountChanged(Lcom/android/mail/providers/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;

.field final synthetic val$accountName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 476
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$4;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iput-object p2, p0, Lcom/android/mail/ui/AbstractActivityController$4;->val$accountName:Ljava/lang/String;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$4;->val$accountName:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/ui/MailActivity;->getMailtoNdef(Ljava/lang/String;)Landroid/nfc/NdefMessage;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/ui/MailActivity;->setForegroundNdef(Landroid/nfc/NdefMessage;)V

    .line 480
    return-void
.end method
