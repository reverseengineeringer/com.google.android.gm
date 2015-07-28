.class Lcom/android/ex/chips/RecipientEditTextView$3;
.super Ljava/lang/Object;
.source "RecipientEditTextView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/chips/RecipientEditTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/chips/RecipientEditTextView;


# direct methods
.method constructor <init>(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView$3;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$3;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->shrink()V
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$200(Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 223
    return-void
.end method
