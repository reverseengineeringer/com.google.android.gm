.class Lcom/android/mail/browse/ConversationCursor$CursorObserver;
.super Landroid/database/ContentObserver;
.source "ConversationCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CursorObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/ConversationCursor;


# direct methods
.method public constructor <init>(Lcom/android/mail/browse/ConversationCursor;Landroid/os/Handler;)V
    .locals 0
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 894
    iput-object p1, p0, Lcom/android/mail/browse/ConversationCursor$CursorObserver;->this$0:Lcom/android/mail/browse/ConversationCursor;

    .line 895
    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 896
    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .locals 1
    .param p1, "selfChange"    # Z

    .prologue
    .line 902
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$CursorObserver;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # invokes: Lcom/android/mail/browse/ConversationCursor;->underlyingChanged()V
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$900(Lcom/android/mail/browse/ConversationCursor;)V

    .line 903
    return-void
.end method
