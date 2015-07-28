.class Lcom/android/mail/ui/AnimatedAdapter$2;
.super Lcom/android/mail/providers/AccountObserver;
.source "AnimatedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AnimatedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AnimatedAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter$2;->this$0:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 1
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter$2;->this$0:Lcom/android/mail/ui/AnimatedAdapter;

    # invokes: Lcom/android/mail/ui/AnimatedAdapter;->setAccount(Lcom/android/mail/providers/Account;)V
    invoke-static {v0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->access$000(Lcom/android/mail/ui/AnimatedAdapter;Lcom/android/mail/providers/Account;)V

    .line 103
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter$2;->this$0:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 104
    return-void
.end method
