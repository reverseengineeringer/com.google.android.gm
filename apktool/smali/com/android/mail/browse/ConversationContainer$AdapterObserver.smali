.class Lcom/android/mail/browse/ConversationContainer$AdapterObserver;
.super Landroid/database/DataSetObserver;
.source "ConversationContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdapterObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/ConversationContainer;


# direct methods
.method private constructor <init>(Lcom/android/mail/browse/ConversationContainer;)V
    .locals 0

    .prologue
    .line 855
    iput-object p1, p0, Lcom/android/mail/browse/ConversationContainer$AdapterObserver;->this$0:Lcom/android/mail/browse/ConversationContainer;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/browse/ConversationContainer;Lcom/android/mail/browse/ConversationContainer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/browse/ConversationContainer;
    .param p2, "x1"    # Lcom/android/mail/browse/ConversationContainer$1;

    .prologue
    .line 855
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationContainer$AdapterObserver;-><init>(Lcom/android/mail/browse/ConversationContainer;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 858
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer$AdapterObserver;->this$0:Lcom/android/mail/browse/ConversationContainer;

    # invokes: Lcom/android/mail/browse/ConversationContainer;->onDataSetChanged()V
    invoke-static {v0}, Lcom/android/mail/browse/ConversationContainer;->access$200(Lcom/android/mail/browse/ConversationContainer;)V

    .line 859
    return-void
.end method
