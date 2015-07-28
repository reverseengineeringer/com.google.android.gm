.class Lcom/android/mail/ui/MailActionBarView$1;
.super Ljava/lang/Object;
.source "MailActionBarView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/MailActionBarView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MailActionBarView;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/MailActionBarView;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView$1;->this$0:Lcom/android/mail/ui/MailActionBarView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$1;->this$0:Lcom/android/mail/ui/MailActionBarView;

    iget-object v0, v0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 105
    return-void
.end method
