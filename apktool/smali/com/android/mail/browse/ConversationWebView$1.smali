.class Lcom/android/mail/browse/ConversationWebView$1;
.super Ljava/lang/Object;
.source "ConversationWebView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/ConversationWebView;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/ConversationWebView;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/android/mail/browse/ConversationWebView$1;->this$0:Lcom/android/mail/browse/ConversationWebView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView$1;->this$0:Lcom/android/mail/browse/ConversationWebView;

    const/4 v1, 0x0

    # setter for: Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z
    invoke-static {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->access$002(Lcom/android/mail/browse/ConversationWebView;Z)Z

    .line 55
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView$1;->this$0:Lcom/android/mail/browse/ConversationWebView;

    # invokes: Lcom/android/mail/browse/ConversationWebView;->destroyBitmap()V
    invoke-static {v0}, Lcom/android/mail/browse/ConversationWebView;->access$100(Lcom/android/mail/browse/ConversationWebView;)V

    .line 56
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView$1;->this$0:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationWebView;->invalidate()V

    .line 57
    return-void
.end method
